## tomcat container execution script
mv /usr/local/tomcat/SupportForceBE.war /usr/local/tomcat/webapps
/usr/local/tomcat/bin/startup.sh
tail -f /dev/null
