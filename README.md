# Bank Transaction Management Application

This is a Spring Boot-based application that processes bank card transaction messages, updates account balances, and generates reports. The application exposes a REST API to handle transactions and stores them in an H2 in-memory database. A scheduled task runs every 5 minutes to generate a report of recent transactions.

## Requirements:
- Java 17
- Maven

## How to Run:
1. Clone the repository.
2. Build the project using Maven:
   ```bash
   mvn clean package
3. Run the application:
4.  ```bash
     java -jar target/bankTransactionManagement-0.0.1-SNAPSHOT.jar

## Database Setup:
- The application uses Liquibase to manage database schema updates automatically.
- Example bank accounts and exchange rates are loaded at startup.

## Postman Collection:
- A Postman collection is included under `src/main/resources/postman/bank_postman_collection`.

## API Endpoints:
1. **POST (http://localhost:9090/bank/update-account)**: Send transaction messages to update the account.

