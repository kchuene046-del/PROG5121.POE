# PROG5121.POE
Project: Programming Portfolio of Evidence – QuickChat
Project Overview
QuickChat is a Java console-based messaging application developed for the PROG5121 Programming Portfolio of Evidence (POE). The application allows a user to register, log in and manage messages. Users can send messages, disregard messages or store them for later use. Stored messages can also be searched, displayed and deleted.

The project demonstrates object-oriented programming, input validation, collections, file handling, JSON data storage and unit testing.
Main Features
1. User Registration and Login
- Captures the user's first name and surname.
- Validates the username format.
- Checks that the password meets the required complexity rules.
- Validates the cell phone number, including its international format.
- Allows the user to log in using the registered username and password.
- Displays feedback about registration and login results.
2. Message Management
- Allows the user to choose how many messages to enter.
- Captures the recipient's cell phone number and message text.
- Validates recipient numbers and message length.
- Generates a unique message ID.
- Creates a message hash.
- Gives the user three message actions:
  - Send – marks the message as sent.
  - Disregard – does not keep the message as a sent or stored message.
  - Store – saves the message for later use.
3. Stored Message Functions
The stored messages menu provides options to:
- Display the sender and recipient of stored messages.
- Display the longest stored message.
- Search for a message using its ID.
- Search for messages using a recipient's cell phone number.
- Delete a message using its hash.
- Display a report of stored messages.
4. JSON File Storage
Messages are stored in a JSON file named message.json. The application uses the Google Gson library to convert message objects to and from JSON, allowing stored messages to be loaded when the application starts and saved for later use.
Technologies and Tools
- Java – application programming language.
- Apache Maven – project build and dependency management.
- Gson 2.13.2 – JSON reading and writing.
- JUnit 5 – automated unit testing.
- Git and GitHub – source control and project hosting.
- GitHub Actions – automated test workflow.
- NetBeans – project configuration is included for NetBeans users.
Project Structure
The Maven project is located in:
PROG5121_POE/
└── PROG5121/
    └── PROG5121_POE/
        └── PROG5121_POE/
            ├── pom.xml
            ├── message.json
            └── src/
                ├── main/
                │   └── java/
                │       └── com/mycompany/prog5121_poe/
                │           ├── PROG5121_POE.java
                │           ├── Login.java
                │           ├── Message.java
                │           └── MessageManagement.java
                └── test/
                    └── java/
                        ├── MessageTest.java
                        ├── RegisterTest.java
                        └── StoredMessagesTests.java
Main class
Class	Responsibility
PROG5121_POE	Runs the application, displays the menus and coordinates the registration, login and messaging process.
Login	Handles registration, username and password validation, cell phone validation and login checks.
Message	Represents a message and contains message validation, ID/hash generation, message actions and JSON storage functionality.
MessageManagement	Provides operations for displaying, searching, deleting and reporting on stored messages.
Requirements
To build and run the project, install:
- JDK 25 or a compatible newer JDK.
- Apache Maven.
- An IDE such as NetBeans or IntelliJ IDEA (optional).
The Maven configuration sets maven.compiler.release to 25. Make sure Maven is using a JDK that supports Java 25.

How to Run the Application
1. Clone or download this GitHub repository.
2. Open the project folder in your IDE, or open a terminal.
3. Navigate to the directory containing the pom.xml file.
4. Build the project and run the tests
1. Build the project and run the tests:
mvn clean test
5. Run the application:
mvn exec:java
The Maven project defines com.mycompany.prog5121_poe.PROG5121_POE as the main class. If your IDE does not recognise the Maven exec command, run PROG5121_POE.java directly from the IDE.
Running the Unit Tests
JUnit 5 tests are located in src/test/java.

The test classes cover:
- Registration and login validation.
- Message ID and message hash creation.
- Message length and recipient number validation.
- Sending, disregarding and storing messages.
- Total message counting and message display.
- Stored message searching, deletion and reporting.
Run all tests from the directory containing pom.xml:
mvn clean test
Maven displays the test results in the terminal and creates detailed reports in target/surefire-reports/.
Continuous Integration
The repository includes GitHub Actions workflows under .github/workflows/. The test workflow checks out the repository, sets up Java and runs the Maven test command when changes are pushed or pull requests are opened against the configured branches.

A successful workflow run helps confirm that the automated tests pass in the GitHub environment.
Data Storage
The application uses message.json to store message information. The file contains message records with fields such as:
- messageID
- numMesageSent
- recipientCell
- sender
- message
- messageHash
- status
Keep the JSON file in the working directory expected by the application when running it. If the file is not found, check the application's current working directory and the location from which it is being launched.
Usage Flow
1. Register with your personal details.
2. Log in using your registered credentials.
3. Choose Send Messages from the main menu.
4. Enter the number of messages you want to process.
5. Enter each recipient's cell number and message.
6. Choose whether to send, disregard or store each message.
7. Use Stored Messages to view, search, delete or report on stored messages.
8. Choose Quit to exit the application.
Project Purpose
This project was developed as part of the PROG5121 Programming POE to apply Java programming concepts in a practical application. It brings together user authentication, message processing, validation, object-oriented design, persistent data storage and software testing.
