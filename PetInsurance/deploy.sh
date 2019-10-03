# deploy.sh
#!/bin/sh

# Install kubernetes and set config
sudo apt-get install google-cloud-sdk

source $HOME/google-cloud-sdk/path.bash.inc

yes | gcloud components install kubectl

docker build -t gcr.io/projectthreeie/petinsurance:v1.0 .
gcloud docker -- push gcr.io/projectthreeie/petinsurance:v1.0
kubectl delete pods --all
kubectl apply -f k8s.yml