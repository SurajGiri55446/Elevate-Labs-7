# Employee Management System (Java + MySQL)

A console-based **Employee Management System** built using **Java JDBC** and **MySQL**. This program provides a simple interface to manage employee records, allowing users to perform CRUD (Create, Read, Update, Delete) operations on employee data stored in a MySQL database.

## 📌 Project Description

The **Employee Management System** is designed to manage employee information efficiently through a command-line interface. It demonstrates the integration of **Java JDBC** for database connectivity and **MySQL** for persistent storage.

### Features
1. **View Employees**: Display all employee records from the database.
2. **Add Employee**: Insert a new employee record into the database.
3. **Delete Employee**: Remove an employee record by their ID.
4. **Update Employee**: Modify employee details such as name, email, address, etc.

## ⚙️ Prerequisites

To run this project, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or above
- **MySQL Database**: Version 5.7 or higher
- **MySQL JDBC Driver**: Required for Java-MySQL connectivity (e.g., `mysql-connector-java.jar`)
- **MySQL Server**: Running locally or remotely with a configured database

## 📂 Project Structure

- **`Employee.java`**: Main Java file containing the application logic, JDBC connectivity, and CRUD operations.
- **`lib/`**: Directory containing the MySQL JDBC driver (e.g., `mysql-connector-java.jar`).
- **SQL Schema**: Database setup script for creating the employee table.

## 🛠 Setup Instructions

### 1. Database Setup
1. Install and configure **MySQL** on your system.
2. Create a database (e.g., `employee_db`).
3. Execute the following SQL script to create the `employees` table:

Compile and Run:javac -cp ".;lib/*" Employee.java && java -cp ".;lib/*" Employee

## Example Output
<img width="1042" height="804" alt="Screenshot 2025-08-14 150708" src="https://github.com/user-attachments/assets/c7a5c58e-7d81-4725-a41e-68d94e1d0cb2" />

## SQL ScreenShoot
<img width="623" height="234" alt="Screenshot 2025-08-14 113500" src="https://github.com/user-attachments/assets/60cc5057-6d47-4432-87cd-2efc5a80499a" />
<img width="892" height="945" alt="image" src="https://github.com/user-attachments/assets/05ee2817-e70b-4461-be2e-bc2688f2f353" />

