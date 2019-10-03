output "database_ip" {
    value = google_sql_database_instance.uat_database.ip_address.0.ip_address
}

output "database_name" {
    value = google_sql_database_instance.uat_database.connection_name
}

output "bastion_external_ip" {
    value = google_compute_instance.devops_bastion.network_interface.0.access_config.0.nat_ip
}

output "jenkins_external_ip" {
    value = google_compute_instance.jenkins_vm.network_interface.0.access_config.0.nat_ip
}

output "key_path" {
    value = google_kms_crypto_key.encryption_key.self_link
}

output "kubernetes_master_ip" {
    value = google_container_cluster.uat_cluster.endpoint
}