#!/bin/bash

echo "---------------------------------"
docker-compose down

# shellcheck disable=SC2046
docker volume rm $(docker volume ls -qf "name=postgres-data")
# shellcheck disable=SC2046
docker volume rm $(docker volume ls -qf "name=mongo-data")
# shellcheck disable=SC2046
docker volume rm $(docker volume ls -qf "name=rabbitmq-data")


echo "Removing network..."
docker network rm app-network

echo "All services, volumes, and network have been removed."
echo "---------------------------------"
