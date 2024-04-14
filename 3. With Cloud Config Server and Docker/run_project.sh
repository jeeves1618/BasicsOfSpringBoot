#!/bin/bash

# Check if version parameter is provided
if [ -z "$1" ]; then
    echo "Please provide a version number."
    exit 1
fi

# Assign the value of the version parameter to a variable
version="$1"

# Change directory to the cloud config project folder
cd /path/to/CloudConfigServer

# Run mvn install for cloud config microservice
mvn clean install || {
    echo "Maven build failed."
    exit 1
}

# Build the docker image for cloud config microservice using the jar in target folder
docker build . -t vjponnusamy/basics-config:"$version"

# Change directory to the player microservices project folder
cd /path/to/Player

# Run mvn install for player microservice
mvn clean install || {
    echo "Maven build failed."
    exit 1
}

# Build the docker image for player microservice using the jar in target folder
docker build . -t vjponnusamy/basics-player:"$version"

# Change directory to the team microservices project folder
cd /path/to/Team

# Run mvn install for team microservice
mvn clean install || {
    echo "Maven build failed."
    exit 1
}

# Build the docker image for team microservice using the jar in target folder
docker build . -t vjponnusamy/basics-team:"$version"

# Change directory to the ground microservices project folder
cd /path/to/Ground

# Run mvn install for ground microservice
mvn clean install || {
    echo "Maven build failed."
    exit 1
}

# Build the docker image for ground microservice using the jar in target folder
docker build . -t vjponnusamy/basics-ground:"$version"

# Change directory to the docker compose folder
cd /path/to/docker-compose/default

# Run Docker Compose
docker-compose up -d