resource aws_api_gateway_resource resource {
  parent_id = var.path_parent_id
  path_part = var.path_part
  rest_api_id = var.api_id
}

resource aws_api_gateway_method method {
  api_key_required = true
  authorization = "NONE"
  http_method = "POST"
  resource_id = aws_api_gateway_resource.resource.id
  rest_api_id = var.api_id
  request_models = {
    "application/json" = aws_api_gateway_model.request.name
  }
  request_validator_id = var.request_validator_id
}

resource aws_api_gateway_integration integration {
  rest_api_id             = var.api_id
  resource_id             = aws_api_gateway_resource.resource.id
  http_method             = aws_api_gateway_method.method.http_method
  integration_http_method = "POST"
  type                    = "AWS_PROXY"
  uri                     = aws_lambda_function.lambda_function.invoke_arn
}

resource aws_lambda_permission lambda_permissions {
  statement_id  = "AllowExecutionFromAPIGateway"
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.lambda_function.function_name
  principal     = "apigateway.amazonaws.com"

  # More: http://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html
  source_arn = "arn:aws:execute-api:ca-central-1:${var.aws_account_id}:${var.api_id}/*/${aws_api_gateway_method.method.http_method}${aws_api_gateway_resource.resource.path}"
}

resource aws_api_gateway_method_response success_response {
  http_method = aws_api_gateway_method.method.http_method
  resource_id = aws_api_gateway_resource.resource.id
  rest_api_id = var.api_id
  status_code = "200"
  response_models = {
    "application/json" = aws_api_gateway_model.success_response.name
  }
}

resource aws_api_gateway_model request {
  rest_api_id = var.api_id
  content_type = "application/json"
  name = var.request_model_name
  schema = var.request_model_json_schema
}


resource aws_api_gateway_model success_response {
  rest_api_id = var.api_id
  content_type = "application/json"
  name = var.response_model_name
  schema = var.response_model_json_schema
}