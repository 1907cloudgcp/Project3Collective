// Rollback to version 2.12.0 due to role creation bug
provider "google" {
    version = "2.12.0"
    project = var.project_id
    region = var.region
    zone = var.zone
}