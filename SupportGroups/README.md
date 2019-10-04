# Support Groups

## Project Infrastructure

The project resources were split between a development and environment and a
uat environment.  The difference is that development uses a public database
and cluster for the backend, whereas the uat uses a private database and cluster
for the backend.  The frontend site is deployed to a storage bucket with domain
name "www.support-force.org".

The developers' user account falls under a Google group.  It allows for project
view and SQL editing.

## Repository Structure

Used Github.

The Support Force front end and back end portions were separated into two
different repositories.

The **SupportForce** folder here contains the files needed to build the
**front end** application of the project using CircleCI.

The **SupportForceBE** folder here contains the files needed to build the
**back end** application of the project using CircleCI.

UAT branch for both repos is staging-uat.

### Contents of SupportForce Folder

The stagingfe.dockerfile is the Dockerfile used for building the front end container.

The .circleci folder holds the necessary files for a CircleCI build.  It contains
the bucket-cors.json file, which is used to configure the CORS policy on our Google
Cloud Storage bucket.  The config.yml file is the configuration file.  The
.environment files contain environment variables of the backend URL, so this
is where you would put the URL of the instance running the back end application.
In our case, this URL is the IP address of the Kubernetes load balancer managing
the cluster hosting our back end application.  The .json file contains the circleci
service account key (this should also have been kept as a secret; it was
originally stored as a CircleCi encrypted variable, but went back to being a file
and did not change).

### Contents of SupportForceBE Folder

The stagingbe.dockerfile is the Dockerfile used for building the back end container.
The SQL database password in this file has been redacted for this repository.

The .circleci folder holds the necessary files for a CircleCI build. The
config.yml file is the configuration file. The .json file contains the
circleci service account key (this should also have been kept as a secret; it
was originally stored as a CircleCi encrypted variable, but went back to being a
file and did not change).

The .kubernetes folder holds the Kubernetes deployment, service, and namespace
configurations.

## CI/CD Pipeline  

Used CircleCi.

Every push to the frontend origin repo triggers a CircleCI build.  The angular
artifacts are then sent to the host-site storage bucket, "www.support-force.org".

Every push to the backend origin repo triggers a CircleCI build.  A Tomcat
war artifact is then be deployed in a tomcat container that sits in a
Kubernetes cluster.  This hosts the backend site the communicates with the
database.

## Resources

Storage buckets
  - support-force (sql dumps, sf-bsproxy compute instance image)
  - support-force-logs (log sink)
  - www.support-force.org

Kubernetes clusters
  - supportforce-uat-cluster (private)
  - supportforce-dev-cluster (public)

Ancillary Compute instances
  - sf-bsproxy (root profile held essential environment variables, e.g. database
    usernames and  passwords; cronjob sends sql dump daily to support-Force
    bucket; was originally meant to serve as a proxy to the private kubernetes
    master node, whose authorized networks would include this VM and cloud shell)

Databases
  - uat-db-01 (private)
  - dev-postgres1 (public)

VPC network
  - support-force-network

VPC firewall rules
  - health checks on Kubernetes master nodes
  - HTTP(s) 0.0.0.0/0 ingress for cluster load balancers (this could have been
    restricted to "www.support-force.org", but was not)
  - circle-ci allowed service account
  - instance1-ssh (allow ssh into sf-bsproxy VM)

VPC static ip addresses
  - one attached to each cluster load balancer

## Monitoring and Logging

Logs are exported to the support-force-logs bucket.  These are all google
stackdriver logs.

## Disaster Recovery

The terraform folder under DisasterRecovery holds the essential resources.  This
includes everything but static ip addresses, storage buckets, and the proxy compute
instance.  main.tf contains skeleton blocks for which the resources were imported
into after creation in the console (import conflicts were manually resolved).
The service APIs were also imported.

The proxy compute instance is backed up in a snapshot image in the support-force
bucket.  

The sql database is dumped daily to the support-force bucket.

kubernetes secrets exist as environment variables under root in the proxy
compute instance.  They are not auto-deployed.  If credentials change, they
must be changed manually in the kubernetes and also in the root environment.

## Pricing

The daily cost for our project with the resources used is between $6.00 to $7.50.
