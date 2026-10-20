# ATM Management System

A RESTful ATM Management System built using Java and Spring Boot. This project demonstrates account management, deposits, withdrawals, transaction history, and validation.

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

## Features

- Create and retrieve bank accounts
- Deposit money
- Withdraw money
- Validate account details and transaction amounts
- Handle API errors
- View transaction history
- Store account and transaction data in MySQL

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/accounts` | Create an account |
| GET | `/api/accounts` | Get all accounts |
| GET | `/api/accounts/{id}` | Get an account by ID |
| POST | `/api/accounts/{id}/deposit` | Deposit money |
| POST | `/api/accounts/{id}/withdraw` | Withdraw money |
| GET | `/api/accounts/{id}/transactions` | View transaction history |

## Setup Instructions

1. Install Java 21 and MySQL.
2. Create a database named `atm_management`.
3. Configure the database URL, username, and password in `application.properties`.
4. Run the application from IntelliJ IDEA or using Maven.
5. Test the endpoints using Postman.

## Database Configuration

Configure your own database credentials locally. Do not commit real passwords or other secrets to GitHub.

## Future Improvements

- Authentication and authorization
- Improved database transaction handling
- Unit and integration tests
- API documentation using Swagger/OpenAPI

## Disclaimer

This is an educational project and is not intended for real banking transactions.