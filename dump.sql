CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `user_name` varchar(15) NOT NULL,
  `user_password` varchar(30) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_user_name_uindex` (`user_name`)
)

CREATE TABLE `user_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(25) NOT NULL,
  `user_id` int NOT NULL,
  `user_name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id_uindex` (`id`),
  UNIQUE KEY `user_roles_user_name_uindex` (`user_name`),
  KEY `role_user_user_id_fk` (`user_id`),
  CONSTRAINT `role_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE `teams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `player1_id` int NOT NULL,
  `player2_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teams_user_id_fk` (`player1_id`),
  KEY `teams_user_id_fk_2` (`player2_id`),
  CONSTRAINT `teams_user_id_fk` FOREIGN KEY (`player1_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teams_user_id_fk_2` FOREIGN KEY (`player2_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE `league` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `matches` (
  `id` int NOT NULL AUTO_INCREMENT,
  `team1_id` int DEFAULT NULL,
  `team2_id` int DEFAULT NULL,
  `score_1_1` int DEFAULT NULL,
  `score_2_1` int DEFAULT NULL,
  `score_1_2` int DEFAULT NULL,
  `score_2_2` int DEFAULT NULL,
  `score_1_3` int DEFAULT NULL,
  `score_2_3` int DEFAULT NULL,
  `date_of_play` date DEFAULT NULL,
  `league_id` int DEFAULT NULL,
  `table_number` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `matches_teams_id_fk` (`team1_id`),
  KEY `matches_teams_id_fk_2` (`team2_id`),
  KEY `matches_league_id_fk` (`league_id`),
  CONSTRAINT `matches_league_id_fk` FOREIGN KEY (`league_id`) REFERENCES `league` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `matches_teams_id_fk` FOREIGN KEY (`team1_id`) REFERENCES `teams` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `matches_teams_id_fk_2` FOREIGN KEY (`team2_id`) REFERENCES `teams` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE `user_league` (
  `user_id` int DEFAULT NULL,
  `league_id` int DEFAULT NULL,
  KEY `user_league_user_id_fk` (`user_id`),
  KEY `user_league_league_id_fk` (`league_id`),
  CONSTRAINT `user_league_league_id_fk` FOREIGN KEY (`league_id`) REFERENCES `league` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_league_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)