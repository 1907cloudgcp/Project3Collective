# deploy.sh
#!/bin/sh

# Install kubernetes and set config
sudo apt-get install google-cloud-sdk

source $HOME/google-cloud-sdk/path.bash.inc

yes | gcloud components install kubectl

gcloud auth configure-docker

docker build -t gcr.io/projectthreeie/PetInsurance:v1.0 .
docker push gcr.io/projectthreeie/PetInsurance:v1.0
echo "k8s.yml"
kubectl delete pods --all
kubectl apply -f k8s.yml