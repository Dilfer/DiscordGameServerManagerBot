terraform {
  backend "remote" {
    organization = "Dilfers-Personal"

    workspaces {
      name = "AWS-CICD"
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