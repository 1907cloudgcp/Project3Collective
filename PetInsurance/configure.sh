#!/usr/bin/env bash

gcloud config set project projectthreeie
gcloud container clusters get-credentials petinsurance --zone us-central1-a --project projectthreeie