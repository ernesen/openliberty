FROM websphere-liberty:latest
COPY mssql-jdbc-6.4.0.jre8.jar /opt/ibm/wlp/usr/shared/resources/
COPY server.xml /configDropins/defaults/
ENV LICENSE accept
ADD HelloWorldEAR.ear /config/dropins/