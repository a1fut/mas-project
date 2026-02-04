# Car Service Management System

A Spring Boot web application for managing a car service workshop built as a university project.

## Tech Stack

- **Java 21**
- **Spring Boot 3.5.0** (JPA, Web, Validation, Thymeleaf)
- **H2 Database** (file-based)
- **Maven**

## Features

- Service order management with status tracking
- Vehicle registration and management
- User roles: Receptionist, Mechanic, Client
- Parts and warehouse management
- Order tracking system with status workflow (NEW → IN_PROGRESS → AWAITING_PAYMENT → COMPLETED)
- Discount calculation and payment tracking

## Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/a1fut/mas-project.git
   cd mas-project
   ```

2. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access the application**
   - Application: `http://localhost:2115`
   - H2 Console: `http://localhost:2115/h2-console`
     - JDBC URL: `jdbc:h2:file:./data/MASdb`
     - Username: `sa`
     - Password: *(empty)*

## Project Structure

```
src/main/java/org/example/masimplementacja/
├── controllers/       # MVC Controllers
├── models/            # Domain entities
│   ├── uzytkownicy/  # Users (Client, Mechanic, Receptionist)
│   ├── zlecenie/     # Service orders
│   └── zamowienia/   # Parts orders & warehouse
├── repositories/      # Spring Data repositories
├── services/         # Business logic
└── DTOs/             # Data transfer objects
```

## Key Entities

- **ZlecenieSerwisowe** - Service order with status, description, discount
- **Pojazd** - Vehicle (brand, model, fuel type, registration)
- **Mechanik** - Mechanic with specialization and experience
- **Recepcjonista** - Receptionist managing orders
- **Klient** - Client owning vehicles
- **CzescZamienna** - Spare parts with pricing

## Configuration

Database settings in `application.properties`:
```properties
server.port=2115
spring.datasource.url=jdbc:h2:file:./data/MASdb
spring.jpa.hibernate.ddl-auto=update
```

## Sample Data

The application includes a `DataInitializer` class that creates test data on startup:
- Sample receptionist (Anna Nowak)
- Sample mechanic (Jan Knap)
- Sample client with vehicle
- Sample service order
