// Project information
project_id = "terraform-test-project-254716"
region = "us-central1"
zone = "us-central1-a"

// Jenkins start up script name (in the resources directory)
jenkins_startup_script = "JenkinsShell.sh"

// Database properties (can't be the same name as one previously deleted within a week)
database_name = "thisisatestdbokay"
database_instance_name = "postgres"
database_version = "POSTGRES_9_6"
database_tier = "db-f1-micro"
authorized_networks_to_database = [{name = "all", value = "0.0.0.0/0"}]

// Bucket name (must be globally unique)
bucket_webpage_name = "thisisatestbucketagain21"
bucket_data_sink = "thisisadatasinkbucket21"

// KMS
keyring_name = "my-keyring"
key_name = "encryption-key"

// Firewall rules
allowed_into_bastion = ["0.0.0.0/0"]
allowed_into_jenkins = ["0.0.0.0/0"]

// Jenkins image
// jenkins_image = "jenkins-image"