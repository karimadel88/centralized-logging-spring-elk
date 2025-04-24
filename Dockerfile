FROM tomcat:9.0-jdk17
COPY target/*.war /usr/local/tomcat/webapps/spring-boot-elk.war
EXPOSE 8080
CMD ["catalina.sh", "run"]