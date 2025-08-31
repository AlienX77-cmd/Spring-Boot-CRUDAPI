# Software Architecture & File/Folder Documentation

This document describes the architecture and the purpose of each file and folder in the Spring Boot CRUD API project.

---

## Project Structure

```
crudapi/
├── mvnw, mvnw.cmd           # Maven Wrapper scripts for Unix/Windows
├── pom.xml                  # Maven project configuration
├── README.md                # Project overview and file details
├── ARCHITECTURE.md          # (This file) Architecture and documentation
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/kittipak/crudapi/
│   │   │       ├── CrudapiApplication.java      # Main Spring Boot application entry point
│   │   │       ├── controllers/
│   │   │       │   └── UserController.java      # REST API endpoints for User entity
│   │   │       ├── entity/
│   │   │       │   └── User.java                # User JPA entity definition
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java      # JPA repository interface for User
│   │   │       └── services/
│   │   │           ├── UserService.java         # Service interface for User operations
│   │   │           └── UserServiceAction.java   # Service implementation for User operations
│   │   └── resources/
│   │       └── application.properties           # Application and database configuration
│   └── test/
│       └── java/com/kittipak/crudapi/
│           └── CrudapiApplicationTests.java     # Spring Boot test class
```

---

## File & Folder Details

### Root Level

- **mvnw, mvnw.cmd**: Maven Wrapper scripts to build/run the project without requiring Maven installed globally.
- **pom.xml**: Maven configuration file. Declares dependencies (Spring Boot, JPA, MySQL, etc.), plugins, and project metadata.
- **README.md**: Project overview, usage, and file summaries.
- **ARCHITECTURE.md**: This document. Explains the architecture and file/folder responsibilities.

### `src/main/java/com/kittipak/crudapi/`

- **CrudapiApplication.java**: Main class. Bootstraps the Spring Boot application.

#### `controllers/`

- **UserController.java**: Defines REST API endpoints for CRUD operations on `User`. Handles HTTP requests and delegates to the service layer.

#### `entity/`

- **User.java**: JPA entity representing the `user` table. Contains fields, getters/setters, and annotations for ORM mapping.

#### `repository/`

- **UserRepository.java**: Extends `JpaRepository<User, Integer>`. Provides CRUD operations for `User` via Spring Data JPA.

#### `services/`

- **UserService.java**: Service interface declaring user-related business methods (save, findAll, findById, deleteById).
- **UserServiceAction.java**: Implements `UserService`. Contains business logic and interacts with `UserRepository`.

### `src/main/resources/`

- **application.properties**: Configuration for Spring Boot and database connection (JDBC URL, username, password, JPA settings).

### `src/test/java/com/kittipak/crudapi/`

- **CrudapiApplicationTests.java**: Basic Spring Boot test to verify application context loads.

---

## Architecture Overview

- **Controller Layer**: Handles HTTP requests/responses. Maps endpoints to service methods.
- **Service Layer**: Contains business logic. Acts as an intermediary between controllers and repositories.
- **Repository Layer**: Handles data access using Spring Data JPA.
- **Entity Layer**: Defines data models mapped to database tables.
- **Configuration**: Managed via `application.properties`.

---

## Data Flow Example

1. **Client** sends HTTP request to `/api/users` endpoint.
2. **UserController** receives the request and calls the appropriate method in **UserService**.
3. **UserServiceAction** (service implementation) processes the request and interacts with **UserRepository** for database operations.
4. **UserRepository** performs CRUD operations on the **User** entity/table.
5. Response is returned back through the layers to the client.

---

For more details, see comments in each file and the `README.md`.
