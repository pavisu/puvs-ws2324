# puvs-ws2324
Kurs Parallele und Verteilte Systeme (Distributed Systems) WS23-24

## Step by step coding the lab project
1. Adding the Application logic (for demo purposes)

2. Add Controller, Entity, Repo and Service

3. Using MongoDB, MongoCompass and Postman

4. Test Backend part

5. Implement OpenAPI Swagger

6. Create Fronted with React or Angular

7. Try out React and Create UI with Logic

8. Create a docker-compose.yml file


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

### MongoDB Service

- **Image:** `mongo:latest`
- **Container Name:** `my-mongodb`
- **Exposed Ports:** `27017:27017`
- **Volumes:** Map the local `./data` directory to `/data/db` in the container.
- **Environment Variables:**
  - `MONGO_INITDB_ROOT_USERNAME`: root
  - `MONGO_INITDB_ROOT_PASSWORD`: example

### Spring API Service

- **Build Context:** `./AnimalRegistry`
- **Container Name:** `my-app`
- **Exposed Ports:** `8081:8081`
- **Depends On:** This service depends on the MongoDB service.
- **Environment Variables:**
  - `SPRING_DATA_MONGODB_URI`: mongodb://root:example@mongodb:27017
  - `SPRING_DATA_MONGODB_DATABASE`: animaldb

### React App Service

- **Build Context:** `./animalui`
- **Container Name:** `react-app`
- **Exposed Ports:** `3000:3000`
- **Depends On:** This service depends on the Spring API service.
- **Environment Variables:**
  - `REACT_APP_API_URL`: http://spring-api:8081

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

## Starting the Project

3. Open a terminal and navigate to the project directory.

4. Start the project by running the following command:

   ```shell
   docker-compose up -d
   ```

   The `-d` flag runs the services in the background.

5. The services will start to build and run. You will see logs for each service as they initialize. Wait for the process to complete.

6. Once the services are up and running, you can access your application in a web browser:

   - Spring API: http://localhost:8081
   - React App: http://localhost:3000

## Stopping the Project

7. To stop the project, open a terminal and navigate to the project directory.

8. Run the following command to stop and remove the containers:

   ```shell
   docker-compose down
   ```

   This will gracefully shut down the services.

## Cleaning Up

9. If you want to remove all containers, networks, and volumes used by your project, run the following command:

   ```shell
   docker-compose down -v
   ```

   This is helpful when you want to start with a clean slate.

Congratulations! Your project is up and running using Docker Compose. You can now develop and test your application in this environment.
```





