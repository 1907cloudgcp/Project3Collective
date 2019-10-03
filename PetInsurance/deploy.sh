# deploy.sh
#!/bin/sh

# Install kubernetes and set config
sudo apt-get install google-cloud-sdk

# set the path of the google cloud directory
source $HOME/google-cloud-sdk/path.bash.inc

#install kubectl. Pipe yes to confirm any prompts
yes | gcloud components install kubectl

#build the docker container image
# this will need to be changed to reflect the name of the project, image and version
docker build -t gcr.io/projectthreeie/petinsurance:v1.0 .
#push the image up to the cloud container registry
# this will need to be changed to match the name set above
gcloud docker -- push gcr.io/projectthreeie/petinsurance:v1.0
# deletes all pods in order to make sure problematic pods go away
# can probably be removed if you're not having pods that get stuck
kubectl delete pods --all
# applies the new deployment to the kubernetes cluster
kubectl apply -f k8s.yml
