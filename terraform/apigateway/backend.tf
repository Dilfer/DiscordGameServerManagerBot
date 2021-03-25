terraform {
  backend "remote" {
    organization = "Dilfers-Personal"

    workspaces {
      name = "DiscordBotGameManager"
    }
  }
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.0"
    }
  }
}

provider "aws" {
  region = "ca-central-1"
}

data aws_caller_identity current{

}