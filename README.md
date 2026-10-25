# FriendApp – Spring Boot REST API

## Overview
FriendApp is a Spring Boot REST API that manages friend contact information using a MySQL database. It allows users to add friend contacts and retrieve a user's saved friend names and phone numbers.

## Technologies Used
- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman

## Features
- Add friend contact details.
- Retrieve friend contacts using a phone number.
- Prevent duplicate contacts for the same user and friend number.
- Store contact details in MySQL.
- Use native SQL queries through Spring Data JPA.
- Follow a layered architecture: Controller, Service, Repository, and Entity.

## Project Structure
```text
FriendApp/
├── src/main/java/com/example/friend/
│   ├── api/
│   │   └── FriendRestController.java
│   ├── entity/
│   │   └── FriendEntity.java
│   ├── repository/
│   │   └── FriendRepository.java
│   ├── service/
│   │   └── FriendService.java
│   └── FriendAppApplication.java
├── src/main/resources/
│   └── application.yaml
└── pom.xml
```

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/friend/add` | Add a friend contact |
| GET | `/friend/{phoneNumber}` | Retrieve friend contacts for a phone number |

### 1. Add a Friend Contact

**Request**
```http
POST http://localhost:8082/friend/add
Content-Type: application/json
```

**Request Body**
```json
{
  "phoneNumber": 9876543210,
  "friendNumber": 9123456780,
  "friendName": "Rahul"
}
```

Returns the saved contact when successful. If the same user and friend number already exist, the API returns `400 Bad Request`.

### 2. Retrieve Friend Contacts

**Request**
```http
GET http://localhost:8082/friend/9876543210
```

Returns the friend numbers and names associated with the supplied phone number.

## Database Configuration
The application uses MySQL with the `friend_schema` database and the `FRIEND` table.

Configure your database URL, username, and password in `src/main/resources/application.yaml`. Do not commit database credentials to GitHub.

## How to Run

1. Install Java 21 and MySQL.
2. Create the `friend_schema` database.
3. Configure your MySQL credentials in `application.yaml`.
4. Run the application using Maven:

```bash
mvn spring-boot:run
```

Alternatively, on Windows:

```bash
mvnw.cmd spring-boot:run
```

The application runs on port **8082**.

## Architecture
- **Controller:** Exposes REST endpoints for adding and retrieving contacts.
- **Service:** Checks for duplicate contacts and handles contact operations.
- **Repository:** Uses Spring Data JPA and native SQL queries to access MySQL.
- **Entity:** Maps `FriendEntity` to the `FRIEND` table.

## Author
Shayan Arshi
