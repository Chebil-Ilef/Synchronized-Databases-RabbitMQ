
# Synchronized Databases with RabbitMQ

This repository contains a Java application for synchronizing databases using RabbitMQ messaging queue.

## Description

The goal of this project is to demonstrate how to synchronize databases across different instances using RabbitMQ as a messaging queue. The Java application provided here establishes connections to MySQL databases, creates necessary tables, sends and retrieves data, and communicates with a RabbitMQ server for data synchronization.

## Features

- Establishes connections to MySQL databases.
- Creates database tables if they don't exist.
- Sends data updates to RabbitMQ for synchronization.
- Retrieves data from databases.
- Compatible with RabbitMQ messaging queue.

## Installation

1. Clone this repository to your local machine

2. Make sure you have Java JDK and MySQL installed on your system.

3. Set up your MySQL database and RabbitMQ server. Ensure that the credentials are correctly configured.

4. Set up environment variables for your database connection in a `.env` file:

   ```
   DB_URL=jdbc:mysql://localhost:3306/database_name
   DB_USERNAME=username
   DB_PASSWORD=password
   ```

5. Run the Java application using your preferred IDE or build tools.

## Usage

1. Run the Java application.

2. Monitor the console output for database synchronization messages and errors.

## Contributing

Feel free to submit issues or pull requests to improve the project.
