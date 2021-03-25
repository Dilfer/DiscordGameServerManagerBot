resource aws_api_gateway_rest_api game_manager_rest_api {
  name = "GameManager"
  description = "API for managing EC2 instances without requiring IAM permissions."
  endpoint_configuration {
    types = ["REGIONAL"]
  }
}

resource aws_api_gateway_api_key discord_bot {
  name = "discord-bot"
  description = "The API Key to be used by the discord bot client."
}

resource aws_api_gateway_deployment prod {
  rest_api_id = aws_api_gateway_rest_api.game_manager_rest_api.id
  triggers = {
    redeployment = timestamp()
  }
}

resource aws_api_gateway_stage prod {
  deployment_id = aws_api_gateway_deployment.prod.id
  rest_api_id = aws_api_gateway_rest_api.game_manager_rest_api.id
  stage_name = "prod"
}

resource aws_api_gateway_resource server_manager {
  parent_id = aws_api_gateway_rest_api.game_manager_rest_api.root_resource_id
  path_part = "servermanager"
  rest_api_id = aws_api_gateway_rest_api.game_manager_rest_api.id
}

resource aws_api_gateway_request_validator body_validator {
  name                        = "body_validator"
  rest_api_id                 = aws_api_gateway_rest_api.game_manager_rest_api.id
  validate_request_body       = true
}

resource aws_api_gateway_usage_plan usage_plan {
  name = "${aws_api_gateway_rest_api.game_manager_rest_api.name}-${aws_api_gateway_stage.prod.stage_name}"
  api_stages {
    api_id = aws_api_gateway_rest_api.game_manager_rest_api.id
    stage = aws_api_gateway_stage.prod.stage_name
  }
}

resource aws_api_gateway_usage_plan_key usage_plan_key {
  key_id = aws_api_gateway_api_key.discord_bot.id
  key_type = "API_KEY"
  usage_plan_id = aws_api_gateway_usage_plan.usage_plan.id
}