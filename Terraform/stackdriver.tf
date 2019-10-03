resource "google_logging_project_sink" "logging_sink" {
    name = "complete-logging-sink"
    destination = "storage.googleapis.com/${google_storage_bucket.data_sink.name}"

    unique_writer_identity = true

    depends_on = [
        google_project_services.project_apis,
    ]
}

resource "google_project_iam_binding" "log_writer" {
    role = "roles/storage.objectCreator"

    members = [
        "${google_logging_project_sink.logging_sink.writer_identity}",
    ]
}