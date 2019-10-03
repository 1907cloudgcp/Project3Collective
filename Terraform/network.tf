resource "google_compute_network" "uat_network" {
    name = "devops-network"
    auto_create_subnetworks = false

    depends_on = [
        google_project_services.project_apis,
    ]
}

// For the Jenkins server
resource "google_compute_subnetwork" "pipeline_subnetwork" {
    name = "devops-subnet"
    ip_cidr_range = "192.168.1.0/24"
    region = var.region
    network = "${google_compute_network.uat_network.self_link}"
}

// For the Kubernetes UAT cluster
resource "google_compute_subnetwork" "uat_subnetwork" {
    name = "uat-subnet"
    ip_cidr_range = "192.168.2.0/24"
    region = var.region
    network = "${google_compute_network.uat_network.self_link}"
}