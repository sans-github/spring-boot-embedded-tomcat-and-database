# Building app
    mvn clean install
    Reference - https://github.com/spotify/dockerfile-maven

# Running the app
   ## run jar
    java -jar target/spring-boot-embedded-tomcat-and-database-0.0.1-SNAPSHOT.jar

   ## run in docker
    docker run --name spring-boot-embedded-tomcat-and-database -it -d --rm -p=39080:39080 com-san/spring-boot-embedded-tomcat-and-database:0.0.1-SNAPSHOT
    or
    docker-compose -f 'docker-compose.yml' up -d

# Health check via actuator end-point
```code
curl -sk http://localhost:39080/internal/health | python -m json.tool
{
    "db": {
        "database": "MySQL",
        "hello": 1,
        "status": "UP"
    },
    "diskSpace": {
        "free": 115658240000,
        "status": "UP",
        "threshold": 10485760,
        "total": 499055067136
    },
    "status": "UP"
}
```

# API
## Request: Add user
    curl -sk -X POST http://localhost:39080/users -d "name=Dwight&email=Dwight@shrute.com" | python -m json.tool
    curl -sk -X POST http://localhost:39080/users -d "name=Michael&email=Michael@scott.com" | python -m json.tool

## Request: Get all users
    curl -sk http://localhost:39080/users | python -m json.tool
    
## Request: Get a user by id
    curl -sk http://localhost:39080/users/1 | python -m json.tool    
