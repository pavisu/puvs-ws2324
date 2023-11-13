# puvs-ws2324
Kurs Parallele und Verteilte Systeme (Distributed Systems) WS23-24

## Step by step coding the lab project

- Adding the Application logic (for demo purposes)

- Add Controller(with ResponseEntity), Entity, Repo and Service

- Using MongoDB, MongoCompass and Postman

- Test Backend part

- Implement OpenAPI Swagger

- Create Fronted with React or Angular

- Try out ReactJS and Create UI with Logic

- Create Dockerfile for SpringAPI and ReactJS

- Create a docker-compose.yml file

- Use implementation language which is supported by OTel: https://opentelemetry.io/docs/instrumentation/

- Using Java as implementation Language

- Implemented OpenTelemetry and Jaeger for tracing


# Spring Controller Documentation: AnimalController

The `AnimalController` class is a part of the Animal Registry API and is responsible for handling various HTTP requests related to animals.

## Request Mappings

- Base URL Path: `/api/v1/animal`
- Cross-Origin Requests: Allowed from any origin ("*")

## Endpoints

### Save Animal
- **HTTP Method:** POST
- **Endpoint:** `/save`
- **Description:** Save an animal.
- **Request Body:** JSON object representing an `Animal`.
- **Response:** The unique identifier (`animalid`) of the saved animal.

### Get All Animals
- **HTTP Method:** GET
- **Endpoint:** `/allanimals`
- **Description:** Retrieve a list of all animals.
- **Response:** An `Iterable` collection of `Animal` objects, representing a list of all animals in the registry.

### Update Animal
- **HTTP Method:** PUT
- **Endpoint:** `/edit/{id}`
- **Description:** Update an existing animal by its ID.
- **Path Variable:** `id` - Animal ID.
- **Request Body:** JSON object representing an `Animal`.
- **Response:** The updated animal.

### Delete Animal
- **HTTP Method:** DELETE
- **Endpoint:** `/delete/{id}`
- **Description:** Delete an animal by its ID.
- **Path Variable:** `id` - Animal ID.
- **Response:** No data. The animal is deleted.

### Get Animal by ID
- **HTTP Method:** GET
- **Endpoint:** `/search/{id}`
- **Description:** Retrieve an animal by its ID.
- **Path Variable:** `id` - Animal ID.
- **Response:** JSON object representing the retrieved `Animal`.

## Methods and Usage

- `saveAnimal`: Save an `Animal` by calling `animalServices.saveorUpdate(animals)` and returning the `animalid`.
- `getAnimals`: Get all animals by calling `animalServices.listAll()`.
- `update`: Update an `Animal` by calling `animalServices.saveorUpdate(animal)` and returning the updated `Animal`.
- `deleteAnimal`: Delete an `Animal` by calling `animalServices.deleteAnimal(animalid)`.
- `getAnimal`: Retrieve an `Animal` by its ID by calling `animalServices.getAnimalById(animalid)`.

## Dependencies

- `AnimalServices`: Provides business logic and services related to animals. It likely includes methods for saving, updating, deleting, and retrieving animals.

This documentation provides an overview of the `AnimalController` class in the Animal Registry API and its associated endpoints and methods.

# Docker Compose Documentation

This documentation provides an overview of the Docker Compose configuration used for your project. The Docker Compose file defines multiple services and their configurations.

## Services

### MongoDB

- **Image:** mongo:latest
- **Container Name:** my-mongodb
- **Ports:** Maps host port 27017 to container port 27017
- **Volumes:** Maps a host directory `./data` to `/data/db` in the container
- **Environment Variables:** Configures the MongoDB root username and password
- **Network:** Attached to the `my-network` Docker network

### Spring API

- **Build:** Builds the Spring API from the specified Dockerfile context
- **Container Name:** my-app
- **Ports:** Maps host port 8081 to container port 8081
- **Depends On:** Requires MongoDB service to be running
- **Environment Variables:** Configures MongoDB URI, database name, and OpenTelemetry parameters
- **Network:** Attached to the `my-network` Docker network

### React App

- **Build:** Builds the React app from the specified Dockerfile context
- **Container Name:** react-app
- **Ports:** Maps host port 3000 to container port 3000
- **Depends On:** Requires Spring API service to be running
- **Environment Variables:** Configures the API URL
- **Network:** Attached to the `my-network` Docker network

### Jaeger Service

- **Image:** jaegertracing/all-in-one:latest
- **Ports:** Maps host ports 16686 and 14250 to container ports
- **Network:** Attached to the `my-network` Docker network

## Networks

- **Network:** Defines a custom Docker network named `my-network` to connect the services and enable communication between them.


## Overview

- The Docker Compose file defines three services: MongoDB, Spring API, and React App.
- MongoDB is used to provide a database for your Spring API.
- The Spring API is built from the `./AnimalRegistry` context and connects to the MongoDB service using environment variables.
- The React App is built from the `./animalui` context and connects to the Spring API service.
- The services have interdependencies based on the order of execution.


This Docker Compose configuration sets up your project environment, allowing the Spring API and React App to interact with a MongoDB database.

```markdown
# Getting Started with Your Project

This guide will walk you through the steps to start your project using Docker Compose. Ensure you have Docker and Docker Compose installed on your system before proceeding.

## Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Initial Setup

1. Clone the project repository to your local machine:

   ```shell
   git clone https://github.com/your-username/your-project.git
   cd your-project
   ```

2. Create a `.env` file in the project directory to specify environment variables. Here's an example of what the `.env` file might look like:

   ```env
   # MongoDB
   MONGO_INITDB_ROOT_USERNAME=root
   MONGO_INITDB_ROOT_PASSWORD=example

   # Spring API
   SPRING_DATA_MONGODB_URI=mongodb://root:example@mongodb:27017
   SPRING_DATA_MONGODB_DATABASE=animaldb

   # React App
   REACT_APP_API_URL=http://spring-api:8081
   ```

# Starting Your Project

## Prerequisites
- Make sure you have Docker installed on your system.

## Steps

1. **Clone Your Project:**
   - If you haven't already, clone your AnimalRegistry project to your local machine.

2. **Navigate to the Project Directory:**
   - Open a terminal or command prompt and navigate to your project's root directory.

3. **Update Your Docker Compose File:**
   - Ensure that your `docker-compose.yml` file is properly configured according to the Docker Compose configuration you've shared.

4. **Build and Run Your Docker Compose:**
   - Run the following command to build and start your services:
     ```bash
     docker-compose up
     ```

   This command will start your MongoDB, Spring API, React app, OpenTelemetry collector, and Jaeger services.

5. **Access Your Application:**
   - After the services are up and running, you can access your application as follows:
     - Your Spring API should be available at: [http://localhost:8081](http://localhost:8081)
     - Your React app should be available at: [http://localhost:3000](http://localhost:3000)
     - Jaeger UI for tracing can be accessed at: [http://localhost:16686](http://localhost:16686)

6. **Access Jaeger Traces:**
   - To view traces in Jaeger, navigate to [http://localhost:16686](http://localhost:16686) in your web browser. You should be able to see traces as you use your application.

7. **Test Your Application:**
   - Interact with your application (e.g., make HTTP requests, submit data, etc.) to generate traces.

8. **View Traces in Jaeger UI:**
   - In Jaeger UI, you should see traces generated by your application. You can filter, search, and analyze the traces to monitor the behavior of your services.

9. **Stop Your Project:**
   - When you're done, you can stop your project using the following command:
     ```bash
     docker-compose down
     ```

   This will stop and remove the containers, but it won't remove the data volume you've created for MongoDB. To remove that as well, you can use `docker-compose down -v`.

And that's it! You should now have your project up and running with OpenTelemetry and Jaeger for tracing. You can interact with your application and analyze traces using Jaeger UI.

