# Modern_Programming_Practice

ARS

Air Reservation Online

Small App to help manage Air Reservation

App Build Java and UI via JavaFX

1 Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

2 Prerequisites

2.1 XAMPP OR wamp server 

I suggest Xampp you can Download from this link : 
https://www.apachefriends.org/download.html

2.2 Java JDK
https://www.oracle.com/java/technologies/javase-downloads.html

2.3 Integrated development environment I suggest Eclipse 

https://www.eclipse.org/downloads
3 Installing

3.1 Install the required Prerequisites

- Import Project 
- Import some addtional library there located on :
    /src/Additional/Library To Add
- Open Xampp and Start Mysql 
    Create Database Name airline_reservation_db 
    Go to privilege and add user name systemuser , password rood and give him all Privileges .
- In DB Go to Import and import Sql file from additional/DB.
    
3.2 For Run the project should go to UI/login.java and go to Run Configuration add this on argument

--module-path " LOCATION OF LIB OF JAVAFX " --add-modules javafx.controls,javafx.fxml

4 Project Team

Abyalew Ambaneh 

Rajeev 
