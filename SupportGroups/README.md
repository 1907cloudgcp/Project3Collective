# Support Groups

## Project Infrastructure

The front end Angular application was built and its artifacts would be uploaded into a Google Cloud Storage bucket. This bucket had the associated domain name "www.support-force.org" which was publicly accessible. Every time the front end Github repository was pushed to, CircleCI would create a new build and the website would reflect any changes made to it.

The back end Spring application was built and the Tomcat server was deployed to a Kubernetes cluster with g1-small instances located in us-east. This cluster had a load balancer with an IP address that served as the connection point for the front end application.

Another GCP resource used was a PostgreSQL database located in us-east with 1 CPU, 3.75 GB memory, and 10 GB SSD storage.

The daily cost for our project with the resources we used was between $4.50 to $5.00.

## Repository Structure

The Support Force front end and back end portions were separated into two different repositories. 

The **SupportForce** folder here contains the files needed to build the **front end** application of the project using CircleCI. 

The **SupportForceBE** folder here contains the files needed to build the **back end** application of the project using CircleCI.

### Contents of SupportForce Folder

The stagingfe.dockerfile is the Dockerfile used for building the front end container.

The .circleci folder holds the necessary files for a CircleCI build. 

It contains the bucket-cors.json file, which is used to configure the CORS policy on our Google Cloud Storage bucket. 

The config.yml file is the configuration file. 

The .environment files contain environment variables of the backend URL, so this is where you would put the URL of the instance running the back end application. In our case, this URL is the IP address of the Kubernetes load balancer managing the cluster hosting our back end application. 

The .json file contains pertinent access information. The variables' names are shown, but values have been redacted in this repository.

### Contents of SupportForceBE Folder

The stagingbe.dockerfile is the Dockerfile used for building the back end container. The SQL database password in this file has been redacted for this repository.

The .circleci folder holds the necessary files for a CircleCI build. 

The config.yml file is the configuration file. 

The .json file contains pertinent access information. The variables' names are shown, but values have been redacted in this repository.
