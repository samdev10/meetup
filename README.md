# Meet up app only for learning purpose

### React
run : npm run start

### CSS template
link : https://getbootstrap.com/docs/5.2/examples/blog/

### Spring Jpa
- @JsonManagedReference is the forward part of reference, the one that gets serialized normally.
- @JsonBackReference is the back part of reference; it'll be omitted from serialization.

### Mysql

## Local:
mysql.server start

##Basic Tables:

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `age` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `user_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `group_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_group_user_fk` (`user_id`),
  KEY `user_group_group_fk` (`group_id`),
  CONSTRAINT `user_group_group_fk` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`),
  CONSTRAINT `user_group_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `events` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `notes` varchar(100) DEFAULT NULL,
  `date_from` date NOT NULL,
  `time_from` varchar(100) NOT NULL,
  `date_to` date NOT NULL,
  `time_to` varchar(100) NOT NULL,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `zipcode` varchar(100) DEFAULT NULL,
  `online_meeting_details` varchar(100) DEFAULT NULL,
  `group_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `events_group_fk` (`group_id`),
  CONSTRAINT `events_group_fk` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci