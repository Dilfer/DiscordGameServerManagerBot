resource aws_iam_role lambda_iam_role {
  name = var.function_name
  assume_role_policy = <<EOF
{
    "Version": "2012-10-17",
    "Statement": [
      {
        "Action": "sts:AssumeRole",
        "Principal": {
          "Service": "lambda.amazonaws.com"
        },
        "Effect": "Allow",
        "Sid": ""
      }
    ]
  }
  EOF
}

resource aws_iam_role_policy_attachment basic_lambda_attachment {
  policy_arn = "arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole"
  role = aws_iam_role.lambda_iam_role.name
}

data aws_iam_policy_document lambda_permissions {
  statement {
    sid = "LambdaPermissions"

    actions = var.allowed_ec2_actions

    resources = [
      "*",
    ]
  }
}

resource aws_iam_role_policy lambda_permissions {
  policy = data.aws_iam_policy_document.lambda_permissions.json
  role = aws_iam_role.lambda_iam_role.name
  name = "${var.function_name}-EC2-Permissions"
}