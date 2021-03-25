locals {
  lambda_config = {
     list_games = {
       name = "ListGames",
       requestHandler = "com.dilfer.aws.lambda.ListGamesRequestHandler::handleRequest",
       allowed_ec2_actions = ["ec2:DescribeInstances"],
       http_method = "GET",
       path_part = "listgames"
    },
    server_info =  {
      name = "ServerInfo",
      requestHandler = "com.dilfer.aws.lambda.ServerInfoRequestHandler::handleRequest",
      allowed_ec2_actions = ["ec2:DescribeInstances"],
      http_method = "POST",
      path_part = "serverinfo"
    },
    start_server = {
      name = "StartServer",
      requestHandler = "com.dilfer.aws.lambda.StartServerRequestHandler::handleRequest",
      allowed_ec2_actions = ["ec2:DescribeInstances", "ec2:StartInstances"],
      http_method = "POST",
      path_part = "startserver"
    },
    stop_server = {
      name = "StopServer",
      requestHandler = "com.dilfer.aws.lambda.StopServerRequestHandler::handleRequest",
      allowed_ec2_actions = ["ec2:DescribeInstances", "ec2:StopInstances"],
      http_method = "POST",
      path_part = "stopserver"
    }
  }
}

module "game_server_backend_lambda" {
  for_each                   = local.lambda_config
  source                     = "./sub-modules/lambda-api-gateway-method-integration"
  allowed_ec2_actions        = each.value["allowed_ec2_actions"]
  function_name              = "GameManager-${each.value["name"]}"
  handler                    = each.value["requestHandler"]
  http_method                = each.value["http_method"]
  s3_bucket                  = "dilfers-source-code-bucket"
  s3_key                     = "DiscordBotGameManager/aws-lambda-0.1.zip"
  api_id                     = aws_api_gateway_rest_api.game_manager_rest_api.id
  aws_account_id             = data.aws_caller_identity.current.account_id
  path_parent_id             = aws_api_gateway_resource.server_manager.id
  path_part                  = each.value["path_part"]
  request_validator_id       = aws_api_gateway_request_validator.body_validator.id
  request_model_json_schema  = file("models/${each.value["name"]}Request.json")
  request_model_name         = "${each.value["name"]}Request"
  response_model_json_schema = file("models/${each.value["name"]}Response.json")
  response_model_name        = "${each.value["name"]}Response"
}