#!/usr/bin/env bash

gcloud config set project projectthreeie
gcloud container clusters get-credentials PetInsurance --zone us-central1-a --project projectthreeie