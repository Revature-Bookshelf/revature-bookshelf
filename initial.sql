CREATE DATABASE monoDB;

use monoDB;

CREATE TABLE users ( 
id int PRIMARY KEY auto_increment, 
first_name varchar(25) NOT NULL,
last_name varchar(25) NOT NULL,
email varchar(50) UNIQUE NOT NULL, 
password varchar(128) NOT NULL
);

CREATE TABLE user_roles (
	id int PRIMARY KEY auto_increment,
	authorities varchar(255) NOT NULL,
	user_id int, FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (first_name,last_name, email, password)
VALUES ('test1First','test1Last', 'test1@mail.com', '$2a$10$gXY.y5B45WeaObTSzLW8nuWY0YvxUWyABtleHvz9UzGm9LauNJ04W');

INSERT INTO user_roles (user_id, authorities)
VALUES (1,'ROLE_USER');
