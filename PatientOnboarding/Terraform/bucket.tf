resource "google_storage_bucket" "static_page" {
    name = "${var.bucket_webpage_name}"
    location = "US"

    cors {
        origin = ["*"]
        method = ["GET", "OPTIONS"]
    }

    labels = {
        environment = "uat"
        application = "front"
    }

    depends_on = [
        google_project_services.project_apis,
    ]
}

// Enable CORS
resource "google_storage_bucket_acl" "static_page_acl" {
    bucket = "${google_storage_bucket.static_page.name}"

    role_entity = [
        "READER:allUsers",
    ]

    depends_on = [
        google_project_services.project_apis,
    ]
}

resource "google_storage_bucket" "data_sink" {
    name = "${var.bucket_data_sink}"

    labels = {
        environment = "logging"
    }

    depends_on = [
        google_project_services.project_apis,
    ]
}
