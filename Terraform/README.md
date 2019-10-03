To start:
- First create a service account for Terraform and give it role of project owner
- Download service account key and set environment variable GOOGLE_CLOUD_KEYFILE_JSON to the downloaded JSON file
- In project, manually enable Cloud Resource Manager API (cloudresourcemanager.googleapis.com) in the Google Console
- Set variables in terraform.tfvars to desired values
- Run the run.sh script
- *May have to run terraform apply a second time to enable Kubernetes Cluster API (container.googleapis.com) due to current bug
- *Google provider set to version 2.12.0 because of a bug with creating roles