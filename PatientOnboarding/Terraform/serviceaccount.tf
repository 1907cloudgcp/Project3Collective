resource "google_service_account" "jenkins_account" {
    account_id = "jenkins-service-account"
    display_name = "Jenkins Service Account"

    depends_on = [
        google_project_services.project_apis,
    ]
}

resource "google_project_iam_custom_role" "jenkins_role" {
    role_id = "jenkinsUAT"
    title = "Jenkins Role"
    description = "Custom role for Jenkins VM"
    permissions = [
          "storage.buckets.get",
          "storage.objects.get",
          "storage.objects.create",
          "storage.buckets.update",
          "container.clusters.getCredentials",
          "container.pods.delete",
          "container.deployments.create",
          "container.deployments.update"
    ]

    depends_on = [
        google_project_services.project_apis,
    ]
}

resource "google_project_iam_member" "jenkins_iam" {
    role = "projects/${var.project_id}/roles/${google_project_iam_custom_role.jenkins_role.role_id}"
    member = "serviceAccount:${google_service_account.jenkins_account.email}"
}