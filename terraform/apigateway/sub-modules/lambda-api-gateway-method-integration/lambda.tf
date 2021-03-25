resource aws_lambda_function lambda_function {
  function_name = var.function_name
  handler       = var.handler
  role          = aws_iam_role.lambda_iam_role.arn
  runtime       = "java11"
  memory_size   = 512
  s3_bucket     = var.s3_bucket
  s3_key        = var.s3_key
  timeout       = 60
}