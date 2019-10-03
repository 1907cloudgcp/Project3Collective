DOCUMENTATION FOR FILES:

DOCKERFILE:

1. This file is used for deployment of the Docker Container, image used is tomcat.
2. Environment variables are set for the database of the project, to change it to your current database please ask you developers to provide the database username and passwords.
3. Run commands get the necesary dependcies installed
4. Port exposed is 80, change it to the port you are going to be using in your project.


.gitlab.yml

1. This file contains the necesary instructions to run a gitlab CI pipeline, if you and your team are using another service, you can ignore this file. 
2. Since Gitlab CI runs on a limited number of minutes per month (2000) you can manipulate the steps to save time. When you get to the only part of the step change it from staging to skip. 

app.yml 

1. This is the base configuration for how the backend will be deployed on App Engine. The run times are defined here, you can change it to the services or runtimes your team is currently using 
