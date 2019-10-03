# PetInsurance
Revature Project

The build.sh builds the maven and works with the front end of the project

configure.sh configerates gcloud and kubernetes, by setting their location, what project working in, and giving credentials 

Deploy.sh is what installs kubernetes, builds the docker files, and deletes existing kubernetes pods and restarts the pods

install.sh installs gcloud

k8s.yml is what the specific specifications as to the properties of the kubernetes cluster

ARCHITECTURE
The front end is run on a cloud bucket for static webcontent while the backend is run on a kubernetes cluster. We use travis to deploy to these things on gcloud and serve the database on a cloud sql server running postgres. The daily cost of this comes primarily from the kuberenetes cluster and is around 10 dollars.
