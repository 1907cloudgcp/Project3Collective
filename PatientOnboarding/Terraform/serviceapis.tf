// Preferable comment this out and manually enable in console
resource "google_project_services" "project_apis" {
    project = "${var.project_id}"
    services = [
        "clouddebugger.googleapis.com",
        "cloudkms.googleapis.com",
        "cloudprofiler.googleapis.com",
        "cloudresourcemanager.googleapis.com",
        "compute.googleapis.com",
        "container.googleapis.com",
        "containerregistry.googleapis.com",
        "iam.googleapis.com",
        "iamcredentials.googleapis.com",
        "logging.googleapis.com",
        "monitoring.googleapis.com",
        "oslogin.googleapis.com",
        "pubsub.googleapis.com",
        "servicemanagement.googleapis.com",
        "serviceusage.googleapis.com",
        "sqladmin.googleapis.com",
        "stackdriver.googleapis.com",
        "storage-api.googleapis.com",
        "storage-component.googleapis.com",
    ]
}