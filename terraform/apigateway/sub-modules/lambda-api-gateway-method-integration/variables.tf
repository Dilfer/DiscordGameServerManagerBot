variable "allowed_ec2_actions" {
  type = list(string)
  description = "A list of the EC2 actions that this lambda will need."
}
variable aws_account_id {
  description = "The ID of the AWS account the API is built in."
}
variable function_name {
  description = "The name to give to the lambda function."
}
variable handler {
  description = "The fully qualified package and class of the request handler to use."
}
variable "http_method" {
  description = "The HTTP method that this Lambda will be used with. GET vs POST"
}
variable s3_bucket {
  description = "The S3 bucket where the zip file can be sourced from."
}
variable s3_key {
  description = "The S3 key of the zip file to source from."
}
variable api_id {
  description = "The ID of the API all of this will be attached to."
}
variable path_parent_id {
  description = "The ID of the parent path to branch off of for this method/resource/integration."
}
variable path_part {
  description = "The REST path part for this method/resource/integration."
}
variable request_validator_id {
  description = "The ID of the request validator to use."
}
variable "request_model_name" {

}
variable "request_model_json_schema" {

}
variable "response_model_name" {

}
variable "response_model_json_schema" {

}

