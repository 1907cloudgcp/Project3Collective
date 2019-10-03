#!/usr/bin/env bash
# This file configures the settings for gcloud and kubernetes

# set the project that we are working in
# this will need to be changed to suit your project
gcloud config set project projectthreeie
# get the credentials of the kubernetes cluster in the project
# this line will need to be changed for your project/cluster
gcloud container clusters get-credentials petinsurance --zone us-central1-a --project projectthreeie
