# Student Management REST API

A RESTful API built with **Spring Boot** to manage student records using CRUD operations.

## Features
- Create new student records
- Retrieve student details
- Update existing student records
- Delete student records
- DTOs for structured request and response handling
- Input validation to ensure valid data
- Exception handling for errors and invalid requests

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- REST APIs
- Bean Validation
- Maven

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/Madhav-Agg/Student-Management-REST-API.git
   ```
2. Open the project in IntelliJ IDEA.
3. Configure your database and credentials in `src/main/resources/application.properties`.
4. Run the application.

## API Operations

| Method | Operation |
|---|---|
| `POST` | Create a student |
| `GET` | Retrieve student(s) |
| `PUT` | Update a student |
| `DELETE` | Delete a student |

## Note
Configure your database connection before running the application. Keep database credentials private and never commit them to version control.
