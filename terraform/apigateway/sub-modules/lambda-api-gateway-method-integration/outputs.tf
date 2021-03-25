output function_name {
  value = aws_lambda_function.lambda_function.function_name
}
output http_method {
  value = var.http_method
}
output invoke_arn {
  value = aws_lambda_function.lambda_function.invoke_arn
}