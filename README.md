# Spring Cloud Gateway Microservices

The goal of this project is to implement an API gateway in a microservices project. This repository serves as a basic
example of a gateway with YAML file configurations.

## Features

### 1. RABBIT MQ 

- Message broker facilitating communication between the user and the notification service.

### 2. API Gateway

- Implements a gateway for routing requests to various microservices.
- Configurable via YAML files for flexible routing and filtering.

### 3. Eureka Discovery Server

- Centralized service registry for dynamic service registration and discovery.
- Enables load balancing and fault tolerance.

### 4. Spring Cloud Config

- Centralized configuration management for microservices.
- Allows dynamic configuration updates.

### 5. User Service

- Manages user-related operations.
- Supports user creation, retrieval, and storage in a PostgreSQL database.
- Communicates with other services through the gateway.

### 6. Notification Service

- Handles notifications for users.
- Stores notification data in a MongoDB collection.
- Provides APIs for saving and retrieving notifications.¬


- **Spring Boot** for building microservices.
- **Spring Cloud** for service discovery, gateway ,configuration, and Feign integration.
- **RabbitMQ** message broker
- **MongoDB** and **PostgreSQL** as databases.
- **Docker** for containerization.

## Getting Started

To get started with this project, clone the repository and follow the instructions in the respective service directories
to set up and run the services.
