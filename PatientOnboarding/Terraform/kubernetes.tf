resource "google_container_cluster" "uat_cluster" {
    name = "uat-cluster"
    location = var.zone

    remove_default_node_pool = true
    initial_node_count = 1

    network = "${google_compute_network.uat_network.self_link}"
    subnetwork = "${google_compute_subnetwork.uat_subnetwork.self_link}"

    depends_on = [
        google_project_services.project_apis,
    ]
}

resource "google_container_node_pool" "uat_nodes" {
    name = "uat-node-pool"
    location = var.zone
    cluster = "${google_container_cluster.uat_cluster.name}"
    node_count = 1

    node_config {
        preemptible  = false
        machine_type = "g1-small"

        metadata = {
            disable-legacy-endpoints = "true"
        }

        oauth_scopes = [
            "https://www.googleapis.com/auth/logging.write",
            "https://www.googleapis.com/auth/monitoring",
            "https://www.googleapis.com/auth/devstorage.read_only",
        ]
    }
    
    depends_on = [
        google_project_services.project_apis,
    ]
}