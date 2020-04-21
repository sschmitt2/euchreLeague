delete from user where true;
delete from user_roles where true;
delete from teams where true;
delete from matches where true;
INSERT INTO user VALUES (1,'John','Doe','jdoe','supersecret1'),(2,'Sandy','Eklof','seklof','secret');
INSERT INTO user_roles VALUES (1,'admin',1, 'jdoe'),(2,'player',2, 'seklof');
INSERT INTO teams VALUES(1, 1, 2),(2, 1, 2);
INSERT INTO matches VALUES(1, 1, 2, 9, 10, 8, 10, 7, 10,'1979-08-30');