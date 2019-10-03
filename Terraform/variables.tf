// Project information
variable "project_id" {
    type = string
}

variable "region" {
    type = string
}

variable "zone" {
    type = string
}

// Shell script to set up Jenkins on a machine
variable "jenkins_startup_script" {
    type = string
    default = "JenkinsShell.sh"
}

// Database information
variable "database_name" {
    type = string
}

variable "database_instance_name" {
    type = string
    default = "postgres"
}

variable "database_version" {
    type = string
    default = "POSTGRES_9_6"
}

variable "database_tier" {
    type = string
    default = "db-f1-micro"
}

variable "authorized_networks_to_database" {
    type = list(object({
        name = string,
        value = string
    }))
}

// Bucket name that needs to be unique
variable "bucket_webpage_name" { // Bucket for holding static web page
    type = string
}

variable "bucket_data_sink" { // Bucket for log data
    type = string
}

// Key Management System
variable "keyring_name" {
    type = string
}

variable "key_name" {
    type = string
}

// Firewall rules
variable "allowed_into_bastion" {
    type = list(string)
}

variable "allowed_into_jenkins" {
    type = list(string)
}

// Jenkins image
variable "jenkins_image" {
    type = string
    default = "centos-7"
}