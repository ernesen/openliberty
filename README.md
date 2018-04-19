# openliberty

## build the docker image

```
docker build -t app-liberty .
```

## run the local image

```
docker run -d -p 5000:9080 -p 443:9443 --name=helloworld-app app-liberty
```

## test the app

```
$ curl -I http://localhost:5000
HTTP/1.1 200 OK
Cache-Control: max-age=604800
Connection: Close
Content-Type: text/html; charset=UTF-8
Date: Thu, 19 Apr 2018 13:43:18 GMT

$ curl -I http://localhost:5000/helloworld/HelloWorld
HTTP/1.1 200 OK
X-Powered-By: Servlet/3.1
Content-Type: text/html
Content-Length: 88
Content-Language: en-US
Date: Thu, 19 Apr 2018 13:43:44 GMT
```

# References

- [Deploy web appication to liberty](https://www.ibm.com/support/knowledgecenter/en/SSEQTP_8.5.5/com.ibm.websphere.wlp.iseries.doc/ae/twlp_dep_war.html)
- additional information on how to push image and create helm chart for IBM Cloud Private refer to [this project example](https://github.com/ibmcloudprivate2/wildfly)