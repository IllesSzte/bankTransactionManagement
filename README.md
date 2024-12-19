# Bank Transaction Management Application

This is a Spring Boot-based application that processes bank card transaction messages, updates account balances, and generates reports. The application exposes a REST API to handle transactions and stores them in an H2 in-memory database. A scheduled task runs every 5 minutes to generate a report of recent transactions.

## Requirements:
- Java 17
- Maven

## How to Run:
1. Clone the repository.
   ```bash
   git clone https://github.com/IllesSzte/bankTransactionManagement.git
3. Build the project using Maven:
   ```bash
   mvn clean package
4. Run the application:
   ```bash
   java -jar target/bankTransactionManagement-0.0.1-SNAPSHOT.jar

## Database Setup:
- The application uses Liquibase to manage database schema updates automatically.
- Example bank accounts and exchange rates are loaded at startup.

## Postman Collection:
- A Postman collection is included under `src/main/resources/postman/bank_postman_collection`.

## API Endpoints:

1. **POST (http://localhost:9090/bank/update-account)**: Küldj tranzakciós üzeneteket a számla frissítéséhez.
   - **Request Parameters**:
     - `accountNumber` (String): A számlaszám, amelyet frissíteni szeretnél.
     - `currency` (String): A pénznem, amelyben a tranzakció történik.
     - `amount` (double): Az összeg, amelyet hozzáadni vagy levonni szeretnél a számláról.

   - **Response**:
     - **200 OK**: Ha a tranzakció sikeresen végrehajtódott.
     - **404 Not Found**: Ha a megadott számlaszám nem létezik.

