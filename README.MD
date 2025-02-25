# F1 Statistics Web Application

A Spring Boot web application that displays Formula 1 statistics using the F1DB database.

## Overview

This application provides an interface to explore Formula 1 data, powered by the [F1DB database](https://github.com/f1db/f1db) (version 2025.0.4).

## Database Configuration

You can run this application with either PostgreSQL or H2 database:

### Option 1: PostgreSQL
1. Copy `application.properties.example` to `application.properties`
2. Configure your PostgreSQL connection details in `application.properties`
3. Start your PostgreSQL server
4. Run the application

### Option 2: H2 Database (In-Memory)
1. Copy `application.properties.example.h2` to `application.properties`
2. Unzip the schema and data files into the `src/main/resources` folder
3. Run the application
4. Access the H2 console at `http://localhost:5000/h2-console`

## Technical Stack
- Java 17
- Spring Boot 3.4.2
- Spring Data JPA
- Thymeleaf
- Maven
- PostgreSQL/H2 Database
- Bootstrap 5.3.3

## Getting Started
1. Clone this repository
2. Choose your database configuration (PostgreSQL or H2)
3. Run `mvn spring-boot:run`
4. Access the application at `http://localhost:5000`