delete from user where true;
delete from user_roles where true;
delete from teams where true;
delete from matches where true;
delete from league where true;
INSERT INTO user VALUES (1,'John','Doe','jdoe','supersecret1','jdoe@gmail.com'),(2,'Sandy','Eklof','seklof','secret','seklof@gmail.com'),(3, 'Roger','Gourlie','rgourlie','secret','rgourlie@gmail.com'),(4,'Sarah','Schmitt','ss','secret','sschmitt@gmail.com');
INSERT INTO user_roles VALUES (1,'admin',1, 'jdoe'),(2,'player',2, 'seklof'),(3,'admin',3,'rgourlie'),(4,'player',4,'ss');
INSERT INTO teams VALUES(1, 1, 2),(2, 3, 4);
INSERT INTO matches VALUES(1, 1, 2, 9, 10, 8, 10, 7, 10,'1979-08-30');
INSERT INTO league VALUES(1, 'Spring 2020', '1979-04-30', '1979-08-30'),(2, 'Fall 2020', '1979-09-01', '1979-12-15'),(3, 'Winter 2020', '1979-12-22', '1980-03-22');