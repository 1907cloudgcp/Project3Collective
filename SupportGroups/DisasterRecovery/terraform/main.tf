## GCP Cloud infrastructure

// Cloud provider
provider "google" {
  credentials = "${file(".account_credentials/supportforce_terraforming_cloud.json")}"
  project = "support-force"
  region = "us-east4"
  zone = "us-east4-a"
}


// Terraform plugin for creating random ids
resource "random_id" "instance_id" {
  byte_length = 8
}


// service api's
resource "google_project_services" "service_apis" {
  project = "support-force"
  disable_on_destroy = false

  // this should get overwritten...
  services = []
}


// vpc network
resource "google_compute_network" "support_force_network" {
  project = "support-force"
  name = "supportforce-vpc"
}


// vpc firewall rule on compute instance
resource "google_compute_firewall" "instance1_ssh" {
  project = "support-force"
  name = "instance1-ssh"
  network = "supportforce-vpc"

  target_tags = ["bastion-scheduler"]
  source_ranges = ["0.0.0.0/0"]

  allow {
    protocol = "tcp"
    ports = ["22"]
  }
}


// vpc firewall rule on circleci service account
resource "google_compute_firewall" "vpc_circleci_rule" {
  project = "support-force"
  name = "vpc-circleci-rule"
  network = "supportforce-vpc"

  source_service_accounts = ["circleci-build-account@support-force.iam.gserviceaccount.com"]

  allow {
    protocol = "all"
  }
}


// postgresql database
resource "google_sql_database_instance" "uat_db_01" {
  project = "support-force"
  name = "uat-db-01"
  database_version = "POSTGRES_9_6"

  settings {
    tier = "db-custom-1-3840"

    maintenance_window {
      day = "7"
      hour = "9"
    }

    user_labels {
      supportforce = "uat-db-01"
    }
  }
}


// kubernetes cluster
resource "google_container_cluster" "supportforce_uat_cluster" {
  project = "support-force"
  name = "supportforce-uat-cluster"
  location = "us-east4-a"

  network = "supportforce-vpc"
}
