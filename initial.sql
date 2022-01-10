CREATE DATABASE monoDB;

use monoDB;

CREATE TABLE users ( 
id int PRIMARY KEY auto_increment, 
first_name varchar(25) NOT NULL,
middle_name varchar(25),
last_name varchar(25) NOT NULL,
email varchar(50) UNIQUE NOT NULL, 
password varchar(128) NOT NULL
);

CREATE TABLE authorities (
	id int PRIMARY KEY auto_increment,
	authority varchar(255) NOT NULL UNIQUE
);

CREATE TABLE user_authority (
	user_id int, FOREIGN KEY (user_id) REFERENCES users(id),
	authority_id int, FOREIGN KEY (authority_id) REFERENCES authorities(id)
);

INSERT INTO users (first_name,last_name, email, password)
VALUES ('test1First','test1Last', 'test1@mail.com', '$2a$10$gXY.y5B45WeaObTSzLW8nuWY0YvxUWyABtleHvz9UzGm9LauNJ04W');

INSERT INTO authorities (authority) 
VALUES ('ROLE_USER');

INSERT INTO user_authority (user_id, authority_id)
VALUES (1,1);

CREATE TABLE addresses(
	id int PRIMARY KEY auto_increment,
	street_name varchar(50) NOT NULL,
	city varchar(50) NOT NULL,
	state varchar(50) NOT NULL,
	postal_code int NOT NULL
);

CREATE TABLE user_address (
	user_id int, FOREIGN KEY (user_id) REFERENCES users(id),
	address_id int, FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE address_types (
	id int PRIMARY KEY auto_increment,
	type varchar(30) NOT NULL UNIQUE
);

CREATE TABLE address_address_type (
	address_id int, FOREIGN KEY (address_id) REFERENCES addresses(id),
	type_id int, FOREIGN KEY (type_id) REFERENCES address_types(id)
);

ALTER TABLE user_address
ADD CONSTRAINT user_address UNIQUE(user_id,address_id)