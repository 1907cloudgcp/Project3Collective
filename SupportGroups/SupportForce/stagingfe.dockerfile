########################
### build - frontend ###
########################

## base image
FROM gcr.io/support-force/node-gcloud-supportforce:latest

## environment variables
ENV PATH="/root/google-cloud-sdk/bin:${PATH}"
ENV BACKEND_URL="35.245.242.47:80"

## set up working directory
COPY . /app
WORKDIR /app/SupportForce

## build files
# RUN echo ${PATH}
# RUN npm install -g @angular/cli
RUN yes | npm install
RUN ng build

## save build artifacts to storage bucket
CMD gsutil -m cp -r dist/SupportForce/* gs://www.support-force.org
