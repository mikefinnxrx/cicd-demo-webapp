FROM tomcat:latest
LABEL maintainer="michael.finn@xerox.com"
ADD ./target/cicd-demo-webapp.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh","run"]