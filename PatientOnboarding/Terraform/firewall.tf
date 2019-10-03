resource "google_compute_firewall" "allow_http" {
    name = "devops-allow-http"
    network = "${google_compute_network.uat_network.self_link}"

    source_ranges = ["0.0.0.0/0"]
    target_tags = ["http-server"]
    priority = 1000

    allow {
        protocol = "tcp"
        ports = ["80"]
    }
}

resource "google_compute_firewall" "allow_https" {
    name = "devops-allow-https"
    network = "${google_compute_network.uat_network.self_link}"

    source_ranges = ["0.0.0.0/0"]
    target_tags = ["https-server"]
    priority = 1000

    allow {
        protocol = "tcp"
        ports = ["443"]
    }
}

resource "google_compute_firewall" "allow_into_jenkins" {
    name = "allow-into-jenkins-server"
    network = "${google_compute_network.uat_network.self_link}"

    source_ranges = var.allowed_into_jenkins
    target_tags = ["jenkins"]
    priority = 500

    allow {
        protocol = "tcp"
        ports = ["8080"]
    }
}

resource "google_compute_firewall" "allow_bastion_firewall" {
    name = "allow-bastion-in"
    network = "${google_compute_network.uat_network.self_link}"

    source_tags = ["bastion"]
    target_tags = ["server"]
    priority = 1

    allow {
        protocol = "tcp"
        ports = ["22"]
    }
}

resource "google_compute_firewall" "allow_into_bastion_firewall" {
    name = "allow-into-bastion"
    network = "${google_compute_network.uat_network.self_link}"

    source_ranges = var.allowed_into_bastion
    target_tags = ["bastion"]
    priority = 1

    allow {
        protocol = "tcp"
        ports = ["22"]
    }
}

resource "google_compute_firewall" "deny_into_servers_firewall" {
    name = "deny-into-servers"
    network = "${google_compute_network.uat_network.self_link}"

    source_ranges = ["0.0.0.0/0"]
    target_tags = ["server"]
    priority = 2000

    deny {
        protocol = "tcp"
        ports = ["22"]
    }
}