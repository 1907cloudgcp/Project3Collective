#!/bin/bash
cd "$(dirname "$0")"
terraform init
terraform apply
PAUSE
