
# to run the jar app

```
java -jar japp.jar
```

# build and run the docker image
```
docker build -t japp .
docker kill jarapp
docker rm jarapp
docker run --name jarapp japp
```

# tag image to my dockerhub account
```
docker tag japp jaricsng/japp:1.0
```

# push image to my dockerhub account
```
docker push jaricsng/japp:1.0
```
