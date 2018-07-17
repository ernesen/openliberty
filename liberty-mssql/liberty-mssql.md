# run a docker ms sql locally

## Start a mssql-server instance using the latest update for SQL Server 2017
```
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=password!23' -p 1433:1433 -d microsoft/mssql-server-linux:latest
```

## get your container id
```
$ docker ps
CONTAINER ID        IMAGE                                 COMMAND                  CREATED             STATUS              PORTS                    NAMES
4578d3fa6389        microsoft/mssql-server-linux:latest   "/opt/mssql/bin/sqls…"   5 seconds ago       Up 4 seconds        0.0.0.0:1433->1433/tcp   objective_bhabha
```

## Connect to Microsoft SQL Server
connect to the SQL container ID obtained above and the password.
```
docker exec -it 4578d3fa6389 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa
```

```
1> create database test
2> go
1> use test
2> go
Changed database context to 'test'.
```

## How to check the current database in sqlcmd
```
1> select DB_NAME()
2> go

--------------------------------------------------------------------------------------------------------------------------------
test

(1 rows affected)
```

## list database name

```
1> select name from sys.databases
2> go
name
--------------------------------------------------------------------------------------------------------------------------------
master
tempdb
model
msdb
test

(5 rows affected)
```

## create table towns
```
1> CREATE TABLE towns (
2> town VARCHAR(64),
3> county VARCHAR(64),
4> state VARCHAR(2)
5> );
6> go
```

## insert some data to towns
```
1> insert into towns values ('Billerica','Middlesex','MA');
2> insert into towns values ('Buffalo','Erie','NY');
3> insert into towns values ('Bay View','Erie','OH');
4> select count(*) as total from towns;
5> go
```

## select some data from table towns
```
1> select * from towns;
2> go
town                                                             county                                                           state
---------------------------------------------------------------- ---------------------------------------------------------------- -----
Billerica                                                        Middlesex                                                        MA
Buffalo                                                          Erie                                                             NY
Bay View                                                         Erie                                                             OH

(3 rows affected)
```


# Deploy application

## build the docker image
```
docker build -t mstestdb .
```

## run the image
```
docker run --name mytestdb -d -p 5000:9080 -p 5443:9443 mstestdb 
```

## list running container
```
docker ps
```
or

```
docker ps -a
```

## interactive console in docker container
```
docker exec -it mytestdb /bin/bash
```

## stop the container
```
docker kill mytestdb
```

## remove the container image
```
docker rm mytestdb
```

## build and run the app

```
chmod +x ./run
./run
```

## test the app

This shows the websphere home page
```
http://localhost:5000/
```

This shows the Hello World servlet sample where it will shows greeting based on time of day
```
http://localhost:5000/jeemssql
```

This is not working - debugging it
```
http://localhost:5000/jeemssql/TestDb
```

# References
- ms sql [dockerhub](https://hub.docker.com/r/microsoft/mssql-server-linux/)
- [deploying](https://www.ibm.com/support/knowledgecenter/en/SSAW57_liberty/com.ibm.websphere.wlp.nd.multiplatform.doc/ae/twlp_dep.html) application in Liberty
- Using the configuration [dropins](https://www.ibm.com/support/knowledgecenter/en/SSEQTP_liberty/com.ibm.websphere.wlp.doc/ae/twlp_setup_dropins.html) folder to specify server configuration
- [Creating the Docker container for your applications](https://www.ibm.com/support/knowledgecenter/en/SSEQTP_liberty/com.ibm.websphere.wlp.doc/ae/twlp_icp_docker.html)