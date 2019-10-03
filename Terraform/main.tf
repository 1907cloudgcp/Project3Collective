provider "google" {
    version = "2.12.0"
    project = var.project_id
    region = var.region
    zone = var.zone
}