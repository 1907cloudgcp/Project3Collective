#back up the database
#first we setup a cronjob on the runner instance which will be recover the data
# At 22:00 on every day-of-week from Monday through Friday.
# you will need to create a postgres instance first with this cmmand

gcloud sql instances create revdoctors --cpu=2 --memory=7680MiB --authorized-networks=10.0.0.0/9 --zone=us-central1-a --database-version=POSTGRES_9_6

#create database using this command

gcloud sql databases create revaturedb --instance=revdoctors

#before you can access the data in the database you will have to give credentials to the db service account to access the bucket

#get the instance service account by describing the instance with this command
gcloud sql instances describe revdoctors
#make sure you change the password for the postgres user

gcloud sql users set-password postgres --instance=revdoctor --password="password"

#then give the service account the access reader rule
gsutil acl ch -u [SERVICE_ACCOUNT_ADDRESS]:W gs://dr_revdoctors
gsutil acl ch -u [SERVICE_ACCOUNT_ADDRESS]:R gs://dr_revdoctors/sqldumpfile.gz

#run this command to import the most recent backup

gcloud sql import sql revdoctors gs://dr_revdoctors/sqldumpfile.gz --database=revaturedb 

#run the terraform templates located in this bucket

#deploy the latest image in the container registry with this commands
    - gcloud config set compute/zone us-central1-c
    - gcloud container clusters get-credentials revdoctors-cluster --zone us-central1-c
    - kubectl apply -f kubernetes.yaml
# you will find kubernetes.yaml in the backup bucket dr_revdoctors