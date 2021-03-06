# Sarah Schmitt Individual Project

Walk through Indie Project demo video - https://youtu.be/NTjyoEM6Bow

### Problem Statement
For the last two years, my friends and I have been playing on a euchre league. The league has grown
tremendously over the last two years, with many new people joining each new season. Currently, we are 
recording the seasons schedule, table information, weekly score results, player overall record, and 
current standings on a google doc spreadsheet. 

With the growing trend of the euchre league, I would like to create an application that will store
player, schedule and score data into the database. The application will allow you to create a league
from the players in the database. Once the leagues players have been added, the application will generate 
randomized tables for the league.

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: login, sign up, logout, view schedules, view score data, view stat data
* Database
  * MySQL
  * Store users and roles
  * Store all data for the leagues (Matches, Teams, League)
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * JavaMail
* CSS 
  * Bootstrap
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA

### Design

* [User Stories](DesignDocuments/userStories.md)
* [Screen Design](DesignDocuments/wireframes/)
* [Application Flow](DesignDocuments/applicationFlow.md)
* [Database Design](DesignDocuments/FinalDatabaseDiagram.png)

### [Project Plan](ProjectPlan.md)



