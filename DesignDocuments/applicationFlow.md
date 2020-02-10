# Application Flow


### User Create Account

1. User chooses create account on the menu (available on homepage)
1. User fills out the sign up form and submits.
1. Request goes to create account servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition (show a message on the jsp)

### User Login

1. User chooses login on the menu (available on homepage)
1. User enters username and password on form and submits. 
1. If user is authenticated, the server will handle allowing access to edit 
pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### Please note: Users must be logged in to see schedules, scores, stats, and leagues

### View Schedules

1. Page sends a request to view schedule reports servlet for users enrolled in a specific league
1. Servlet uses the league dao to select reports according to criteria
1. Dao performs select and creates report objects from results.
1. Dao returns list of report matching criteria to servlet.
1. Servlet sends list back to schedules jsp.
1. Schedules jsp displays the leagues schedule.
1. Consider paging results so page does not get super long and too much data 
is sent.

### View Scores

1. Page sends a request to view score servlet along with criteria 
(League, Table, id, first name, last name, week, game 1, game 2, game 3).
1. Servlet uses the leagues dao to select scores according to the criteria
1. Dao performs select and creates score objects from results.
1. Dao returns list of scores matching criteria to servlet.
1. Servlet sends list back to scores jsp.
1. Scores jsp displays the scores according to the criteria.
1. Consider paging results so page does not get super long and too much data 
is sent.

### View Stats

1. Page sends a request to view stat servlet along with criteria
(League, Table, id, first name, last name, week, total score, total points).
1. Servlet uses the leagues dao to select stats according to the criteria
1. Dao performs select and creates stat objects from results.
1. Dao returns list of stats matching criteria to servlet.
1. Servlet sends list back to stats jsp.
1. Stats jsp displays the stats according to the criteria.
1. Consider paging results so page does not get super long and too much data 
is sent.


### Leagues

1. Page sends a request to view league servlet along with criteria
(leagues).
1. Servlet uses the leagues dao to select upcoming leagues according to the criteria
1. Dao performs select and creates league objects from results.
1. Dao returns list of leagues matching criteria to servlet.
1. Servlet sends list back to leagues jsp.
1. Leagues jsp displays the leagues according to the criteria.
1. Consider paging results so page does not get super long and too much data 
is sent.

### Add Scores
1. Option only available to logged in users with proper role(admin)
1. User selects week# to report scores on
1. User enters score details
1. Details are sent to Add Scores servlet
1. Servlet creates score object
1. Servlet sends object to dao
1. Dao adds scores to the database
1. Servlet sends confirmation to score page that scores has been added.

### Add Leagues
1. Option only available to logged in users with proper role
1. User enters league details
1. Details are sent to Add League servlet
1. Servlet creates League object
1. Servlet sends object to dao
1. Dao adds league to the database
1. Servlet sends confirmation to league page that a league has been added.








 