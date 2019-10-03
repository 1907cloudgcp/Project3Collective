# we use a tomcat image from docker hub and we copy the war file in target to tomcat's webapps directory
# this file is used in the docker build step in the gitlab-ci.yaml
FROM tomcat:8.5.46-jdk8-openjdk as build-env


COPY Master/Staging/Development/Ben/RevatureDoctor/target/RevatureDoctor-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps/
