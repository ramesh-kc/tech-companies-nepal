# Tech Companies List  in NEPAL
It's Spring boot project with Jersey.


# Tech Stack
 - Spring boot
 - Jersey
 - RestTemplate
 - Json
 - Docker

#  Development
```
http://localhost:8080/companies
```
# DOCKER
```
 docker build -f Dockerfile -t tech-companies-nepal .
 docker run -p 8085:8085 tech-companies-nepal
 docker logs tech-companies-nepal

```

# Docker with Mysql
- pull the latest docker image from [docker-hub-mysql](https://hub.docker.com/_/mysql/)
```
docker pull mysql:8.0.19
```
- Create the docker container name as `mysql-standalone` as following
```
 docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:8.0.19
```
- Change the configuration for mysql at `application.properties` file
```
## spring.datasource.url=jdbc:mysql://localhost:3306/companies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.url=jdbc:mysql://mysql-standalone:3306/companies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
```
- Build the project which will create an image named as `tech-companies-nepal`
```
docker build -f Dockerfile -t tech-companies-nepal .
```
- Link the mysql container `mysql-standalone` and  run the image with the container name called `tech-companies-nepal`
```
 docker run -p 8085:8085 --name tech-companies-nepal --link mysql-standalone:mysql -d tech-companies-nepal
```
- if you want to see the logs what's going with mysql and spring boot
```
 docker logs tech-companies-nepal
 docker logs mysql-standalone
```

# License
MIT

# Reference
- [tech-companies-in-nepal](https://github.com/mesaugat/tech-companies-in-nepal)

