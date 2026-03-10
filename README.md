# Formats A Management Service (PP-A and TI-A)

## Description

This service is part of a **microservices-based architecture** designed to support the management of **undergraduate thesis proposal formats** at the Faculty of Electronic and Telecommunications Engineering (FIET) of the University of Cauca.

The service provides functionality to **create and query thesis proposal formats** corresponding to the following modalities:

* **PP-A**: Professional Practice thesis proposal
* **TI-A**: Research Work thesis proposal

The service exposes a **RESTful API** developed in **Java using Spring Boot**, following software engineering best practices and design patterns such as **Layered Architecture**, **MVC**, **DTO**, **Repository**, **Facade**, **Dependency Injection**.

The system is designed to work together with another service responsible for **state transitions and observations** associated with the formats. Communication between services is performed through **RabbitMQ**, enabling asynchronous event-based synchronization.

Link of the service responsible of **state transitions and observations**: TODO

---

# System Context

The Faculty of Electronic and Telecommunications Engineering (FIET) regulates undergraduate thesis modalities through **Resolution 8.4.3-90.2/231 of 2020**.

Among the approved modalities are:

* **Research Work (TI)**
* **Professional Practice (PP)**

Each modality requires submitting a **Format A**, which represents the **initial thesis proposal** presented by undergraduate students.

The purpose of the system is to support the **registration, monitoring, and management** of these proposals within FIET.

---

# Service Responsibilities

This service is responsible for:

1. **Creating thesis proposal formats**

   * PP-A formats
   * TI-A formats

2. **Retrieving a specific format**

   * Using the identifier generated during its creation.

3. **Listing formats registered in the system**

   * Filtered by a **date range**.

4. **Publishing format creation events**

   * So that other services can synchronize their data.

---

### 1. Format Creation and Query Service (this service)

Responsible for:

* Creating PP-A and TI-A formats
* Retrieving formats by identifier
* Listing formats within a date range

### 2. State

Responsible for:

* Set a default  **state** of a format when it's created

---

# Event Communication with RabbitMQ

To maintain **loose coupling between services**, the system uses **RabbitMQ** as a **message broker** for asynchronous communication.

When a new format is created:

1. The service stores the format in its database.
2. A **format-created event** is published to RabbitMQ.
3. The second service consumes the event and synchronizes its internal data.

This architecture allows:

* Reduced coupling between services
* Better scalability
* Event-driven communication

---

# Architecture

The service follows a **layered architecture** implementing the following design patterns:

* **Model–View–Controller (MVC)**
* **Data Transfer Object (DTO)**
* **Repository Pattern**
* **Facade Pattern**
* **Dependency Injection**
* **State Pattern**

### Project Structure

```
src/main/java/com/fiet/formats

controller
│   └── FormatController

service
│   └── FormatService

facade
│   └── FormatFacade

repository
│   └── FormatRepository

entity
│   └── Format

dto
│   └── FormatDTO

config
│   └── RabbitMQConfig
```

---

# Database

This service owns **its own database**, following the **database-per-service** principle commonly used in microservices architectures.

The database stores information related to:

* Student data
* Academic program
* Thesis modality
* Project information
* Creation date
* Format type (PP-A or TI-A)

For **PP-A formats**, an additional requirement is:

* **Acceptance letter from the company or organization** where the professional practice will be carried out.

---

# REST API

## Create Format A

```
POST /api/formats
```

Creates a new **PP-A or TI-A format**.

### Example Request Body

```json
{
  "formatType": "PP-A",
  "title": "IoT Monitoring System for Agricultural Crops",
  "studentName": "Juan Perez",
  "program": "Electronic Engineering",
  "advisor": "Dr. Carlos Lopez",
  "organization": "AgroTech SAS"
}
```

---

## Get Format by ID

```
GET /api/formats/{id}
```

Retrieves a specific format using its unique identifier.

---

## List Formats by Date Range

```
GET /api/formats?startDate=2025-01-01&endDate=2025-12-31
```

Returns the formats registered within the specified date range.

---

# Technologies

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **RabbitMQ**
* **PostgreSQL / MySQL**
* **Maven**
* **Postman / Thunder Client**

---

# Requirements

* Java 17 or higher
* Maven
* RabbitMQ
* Relational database (MySQL or PostgreSQL)

---

# Running the Project

1. Clone the repository

```
git clone https://github.com/your-user/formats-service.git
```

2. Build the project

```
mvn clean install
```

3. Run the application

```
mvn spring-boot:run
```

The service will be available at:

```
http://localhost:5000
```

---

# Author

This project was developed as part of an **academic workshop on microservices architecture and REST API development** for the **Faculty of Electronic and Telecommunications Engineering (FIET)** at the **University of Cauca**.
