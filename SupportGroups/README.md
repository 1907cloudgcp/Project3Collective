# Support Groups

## Structure
The Support Force front end and back end portions were separated into two different repositories. 

The **SupportForce** folder here contains the files needed to build the **front end** application of the project using CircleCI. 

The **SupportForceBE** folder here contains the files needed to build the **back end** application of the project using CircleCI.

## Contents of SupportForce Folder
.* The .circleci folder holds the necessary files for a CircleCI build. 

..* It contains the bucket-cors.json file, which is used to configure the CORS policy on our Google Cloud Storage bucket. 

The config.yml file is the configuration file. 

The .environment files contain environment variables of the backend URL, so this is where you would put the URL of the instance running the back end application. In our case, this URL is the IP address of the Kubernetes load balancer managing the cluster hosting our back end application. 

The .json file contains pertinent access information. The variables' names are shown, but values have been redacted in this repository.

The stagingfe.dockerfile is the Dockerfile used for building the front end container.

## Contents of SupportForceBE Folder
The .circleci folder holds the necessary files for a CircleCI build. 

The config.yml file is the configuration file. 

The .json file contains pertinent access information. The variables' names are shown, but values have been redacted in this repository.

The stagingbe.dockerfile is the Dockerfile used for building the back end container.
