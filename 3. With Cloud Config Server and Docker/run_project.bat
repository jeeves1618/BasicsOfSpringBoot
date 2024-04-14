@echo off

rem Check if version parameter is provided
if "%1"=="" (
    echo Please provide a version number.
    exit /b 1
)

rem Assign the value of the version parameter to a variable
set version=%1

rem Change directory to the cloud config project folder
cd /d "C:\Dev\BasicsOfSpringBoot\3. With Cloud Config Server and Docker\CloudConfigServer"

rem Run mvn install for cloud config microservice
call mvn clean install || (
                      echo Maven build failed.
                      goto :end
                  )

rem Build the docker image for cloud config microservice using the jar in target folder
docker build . -t vjponnusamy/basics-config:%version%

rem Change directory to the player microservices project folder
cd /d "C:\Dev\BasicsOfSpringBoot\3. With Cloud Config Server and Docker\Player"

rem Run mvn install for player microservice
call mvn clean install || (
                      echo Maven build failed.
                      goto :end
                  )

rem Build the docker image for player microservice using the jar in target folder
docker build . -t vjponnusamy/basics-player:%version%

rem Change directory to the team microservices project folder
cd /d "C:\Dev\BasicsOfSpringBoot\3. With Cloud Config Server and Docker\Team"

rem Run mvn install for team microservice
call mvn clean install || (
                      echo Maven build failed.
                      goto :end
                  )

rem Build the docker image for team microservice using the jar in target folder
docker build . -t vjponnusamy/basics-team:%version%

rem Change directory to the ground microservices project folder
cd /d "C:\Dev\BasicsOfSpringBoot\3. With Cloud Config Server and Docker\Ground"

rem Run mvn install for ground microservice
call mvn clean install || (
                      echo Maven build failed.
                      goto :end
                  )

rem Build the docker image for ground microservice using the jar in target folder
docker build . -t vjponnusamy/basics-ground:%version%

rem Change directory to the docker compose folder
cd /d "C:\Dev\BasicsOfSpringBoot\3. With Cloud Config Server and Docker\docker-compose\default"

rem Run Docker Compose
docker-compose up -d