# start from a tomcat server image
FROM tomcat:8.5.46-jdk8-openjdk
# These database credentials will need to be changed based on our sql instance
ENV DATABASE_NAME="postgres"
ENV JDBC_SCHEMA=""
ENV JDBC_URL="34.70.42.108"
ENV JDBC_USERNAME="postgres"
# here we copy the build artifact into the appropriate folder of the tomcat image
COPY RevaturePetInsurance/target/RevaturePetInsurance-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps/
# this line starts the tomcat folder
RUN startup.sh
