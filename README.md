# Employee Leave Management System

A REST-based Employee Leave Management System developed using Java and Spring Boot to manage employee details and the complete leave management process.

## Project Overview

The Employee Leave Management System allows employees to register, log in, apply for leaves, and track their leave requests.

The system also provides functionality to validate, approve, reject, update, delete, and search leave requests based on different criteria.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL
- REST APIs
- Maven
- Postman
- MySQL Workbench

## Architecture

The project follows a layered architecture:

```text
Client / Postman
       ↓
Controller
       ↓
Service
       ↓
DAO
       ↓
Repository
       ↓
JPA / Hibernate
       ↓
MySQL
