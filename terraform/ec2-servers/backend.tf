terraform {
  backend "remote" {
    organization = "Dilfers-Personal"

    workspaces {
      name = "GameManager-EC2-Servers"
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