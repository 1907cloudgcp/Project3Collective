# Resources Created
- A UAT VPC network
  - Two subnets, one for the UAT pipeline and one for the UAT environment
- Firewall rules for a bastion architect
  - A firewall rule to allow into the Jenkins server on port 8080
- Two compute engine instances
  - An f1-micro machine to act as the Bastion for machines with the tag "server" in the same network
  - An n1-standard-1 machine to host Jenkins
- Two buckets
  - One to act as a data sink
  - One to hold the static front end page
- A Postgres database
  - A premade database user is commented out
- A service account for the Jenkins server
  - Also a custom role for the service account
- Enable Stackdriver logging to log data into the sink bucket
- A Kubernetes cluster
- A single zone node pool with only 1 node
- A keyring and a global key
- Other resources
  - A startup script to pass into the Jenkins VM instance which downloads all required software for Jenkins to build and deliver
  - A run.sh script to initialize the Terraform workspace and apply changes

# Outputs
- Database IP
- Database name
- The Bastion's external IP
- The Jenkins server's external IP
- The path to the key
- Kubernetes cluster IP address

# After Creating Project
- First create a service account for Terraform and give it role of project owner or more restrictive roles
- Download service account key and set environment variable GOOGLE_CLOUD_KEYFILE_JSON to the downloaded JSON file
- In project, manually enable Cloud Resource Manager API (cloudresourcemanager.googleapis.com) in the Google Console

# To Run Terraform
- Set variables in terraform.tfvars to desired values
- Run the run.sh script

# Other Notes
- You can have Terraform manage existing resources by using the import command
- It is recommended to manually enable all the APIs in the serviceapis.tf file and not have Terraform manage it since running Terraform destroy will attempt to disable the APIs as well as other issues noted in the Issues section

# Issues
- Enabling the Kubernetes Cluster API (container.googleapis.com) will often fail the first time due to a current bug where it doesn't get enabled on the first apply
- Google provider set to version 2.12.0 because of a bug with creating roles
