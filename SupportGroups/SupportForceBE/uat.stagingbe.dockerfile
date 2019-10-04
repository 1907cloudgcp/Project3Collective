#######################
### build - backend ###
#######################

## base image
FROM maven:latest as build

## environment variables
ENV DB_NAME="postgres"
# ENV DB_SCHEMA=""
ENV DB_URL="jdbc:postgresql://10.0.160.3:5432/postgres"
# ENV DB_USERNAME="postgres"
# ENV DB_PASSWORD=""

## set up working directory
COPY . /app
WORKDIR /app/SupportForceBE

## build files
RUN mvn install


#########################
### delivery - tomcat ###
#########################

## base image
FROM tomcat:latest as deliver

## environment variables
ENV DB_NAME="postgres"
# ENV DB_SCHEMA=""
ENV DB_URL="jdbc:postgresql://10.0.160.3:5432/postgres"
# ENV DB_USERNAME="postgres"
# ENV DB_PASSWORD=""

## copy tomcat settings into tomcat/conf
# COPY --from=build ["/app/Servers/Tomcat v9.0 Server at localhost-config/web.xml", "/usr/local/tomcat/conf"]

## copy war artifact and execution script from build into tomcat/webapps
COPY --from=build /app/SupportForceBE/target/SupportForceBE-0.0.1-SNAPSHOT.war /usr/local/tomcat/SupportForceBE.war
COPY --from=build /app/SupportForceBE/.kubernetes_yaml/execution_script.sh /usr/local/tomcat

## run tomcat server on port 8080
# RUN ls /usr/local/tomcat/conf
# RUN ls /usr/local/tomcat/webapps
# RUN ls /usr/local/tomcat
RUN /usr/local/tomcat/bin/startup.sh
EXPOSE 8080

## persist container
CMD /bin/bash /usr/local/tomcat/execution_script.sh
