CREATE DATABASE monoDB;

use monoDB;

CREATE TABLE users ( 
id int PRIMARY KEY auto_increment, 
first_name varchar(25) NOT NULL,
middle_name varchar(25),
last_name varchar(25) NOT NULL,
email varchar(50) UNIQUE NOT NULL, 
password varchar(128) NOT NULL,
cart_id int REFERENCES carts(id)
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
	address_type_id int, FOREIGN KEY (address_type_id) REFERENCES address_types(id)
);

ALTER TABLE user_address
ADD CONSTRAINT user_address UNIQUE(user_id,address_id);

ALTER TABLE addresses
ADD CONSTRAINT addresses UNIQUE (street_name, city, state, postal_code);

INSERT INTO address_types (type)
VALUES ('SHIPPING'),('BILLING');

CREATE TABLE books (
	id int PRIMARY KEY auto_increment,
	title varchar(255) NOT NULL UNIQUE,
	pagecount int,
	publishdate DATE,
	isbn varchar(255) UNIQUE,
	author varchar(255),
	imgpath varchar(255)
);

CREATE TABLE genres (
	id int PRIMARY KEY auto_increment,
	name varchar(255) UNIQUE
);

CREATE TABLE genre_join (
	book_id int, FOREIGN KEY (book_id) REFERENCES books(id),
	genre_id int, FOREIGN KEY (genre_id) REFERENCES genres(id)
);

CREATE TABLE store_inventory (
	book_id int PRIMARY KEY REFERENCES books(id),
	price double NOT NULL,
	quantity int NOT NULL
);

CREATE TABLE carts (
	id int PRIMARY KEY auto_increment
);

CREATE TABLE cart_join (
	cart_id int, FOREIGN KEY (cart_id) REFERENCES carts(id),
	book_id int, FOREIGN KEY (book_id) REFERENCES books(id)
);

INSERT INTO carts(id)
VALUES (1);

UPDATE users
SET cart_id = 1
WHERE users.id = 1;

INSERT INTO books (title,pagecount,publishdate,isbn,author,imgpath)
VALUES ('Green Eggs and Ham',65,'1960-08-12',0545002850,'Dr. Suess','../assets/images/greeneggs'),
('The Algorithm Design Manual, 3rd Edition',810,'2020-10-06',3030542556,'Steven S. Skiena','../assets/images/thealgorithms'),
('The Organized Mind',544,'2015-09-01',9780147516,'Daniel J. Levitin','../assets/images/organizedmind'),
('Crime and Punishment',576,'1866-01-01',9781593080,'Fyodor Dostoyevsky','../assets/images/crimeandpunishment'),
('From Crook to Cook',192,'2018-10-23',1452179611,'Snoop Dogg','../assets/images/crooktocook'),
('Make Magic! Do Good!',112,'2012-11-13',763657468,'Dallas Clayton','../assets/images/makemagic'),
('The Drama of the Gifted Child: The Search for the True Self',136,'1997-01-01',0465016901,'Alice Miller','../assets/images/giftedchild'),
('The Great Gatsby',152,'1925-04-10', 0743273567,'F. Scott Fitzgerald','../assets/images/greatgatsby'),
('Percy Jackson and the Lightning Thief',377,'2006-04-01', 0786838655,'Rick Riordan','../assets/images/lightning'),
('Quantum Physics for Dummies',336,'2009-02-03', 1118460820,'Steven Holzner','../assets/images/quantum');


INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma',0201633612,'1994-11-10',416,'../assets/images/designpatterns');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Clean Architecture: A Craftsman\'s Guide to Software Structure and Design','Robert Martin',0134494168,'2017-09-10',432,'../assets/images/cleanarchitecture');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('The Lost Art of Listening, Third Edition: How Learning to Listen Can Improve Relationships','Michael P. Nichols',1462542743,'2021-03-24',370,'../assets/images/listening');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('C.G. Jung Psychological Reflections : A New Anthology of His Writings, 1905-1961','C. G. Jung',0691017867,'1973-05-01',393,'../assets/images/jungreflections');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Tao Te Ching (Illustrated Feng/English/Lippe Translation)','Lao Tsu',0307949303,'2011-11-01',184,'../assets/images/taoteching');

INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Interworld','Michael Reaves',0007523424,2007-26-06,304,'../assets/images/interworld');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Where the Sidewalk Ends','Shel Silverstein',0060256672,1905-27-05,309,'../assets/images/sidewalk');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('The Future Evolution of Man: The Divine Life Upon Earth','Sri Aurobindo',0940985551,2003-11-04,168,'../assets/images/futureevolution');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Total Freedom: The Essential Krishnamurti','Jiddu Krishnamurti',0060648805,1996-30-08,384,'../assets/images/totalfreedom');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('In Order to Live: A North Korean Girl\'s Journey to Freedom','Yeonmi Park','014310974X',2016-27-09,288,'../assets/images/inordertolive');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('The Seven Military Classics Of Ancient China','Ralph D. Sawyer',0465003044,2007-06-11,592,'../assets/images/sevenmilitaryclassics');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Man\'s Search for Meaning',' Viktor E. Frankl',0807014273,2006-01-06,192,'../assets/images/manssearch');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('The Leader\'s Bookshelf','James Stavridis',1682471799,2017-15-03,288,'../assets/images/leadersbookshelf');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('The Inheritance Cycle 4-Book Trade Paperback Boxed Set: Eragon; Eldest; Brisingr; Inheritance','Christopher Paolini',449813223,2012-23-10,880,'../assets/images/inheritance');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Chronicles of Tao: The Secret Life of a Taoist Master','Deng Ming-Dao',0062502190,1993-08-10,476,'../assets/images/chroniclesoftao');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Dune','Frank Herbert','059309932X',1965-01-08,890,'../assets/images/dune');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Design of Everyday Things: Revised','Don Norman',0465050654,2013-05-11,368,'../assets/images/designofeverydaythings');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Astrophysics for People in a Hurry','Neil deGrasse Tyson',0393609391,2017-02-05,222,'../assets/images/astrophysicsinahurry');
INSERT INTO books (title, author, isbn, publishdate, pagecount,imgpath) 
VALUES ('Tao of Jeet Kune Do: Expanded Edition','Bruce Lee',0897502027,2011-01-11,250,'../assets/images/taojeetkunedo');




INSERT INTO genres (name) values ('Children\'s');
INSERT INTO genres (name) values ('Computer Science');
INSERT INTO genres (name) values ('Self-Help');
INSERT INTO genres (name) values ('Philosophy');
INSERT INTO genres (name) values ('Cookbook');
INSERT INTO genres (name) values ('Psychology');
INSERT INTO genres (name) values ('Fiction');
INSERT INTO genres (name) values ('Historical');
INSERT INTO genres (name) values ('Fantasy');
INSERT INTO genres (name) values ('Nonfiction');
INSERT INTO genres (name) values ('Science');
INSERT INTO genres (name) values ('Poetry');

INSERT INTO genre_join (book_id,genre_id)
VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,1),(7,6),(8,7),(8,8),(9,7),(9,9),
(10,10),(10,11),(11,2),(12,2),(13,6),(14,6),(15,4);

INSERT INTO genre_join (book_id,genre_id)
VALUES (16,7),(17,12),(18,4),(19,4),(20,8),(21,4),(22,8),(23,10),(24,7),(24,9),(25,7),(25,4),(26,7),(26,9),
(27,10),(27,11),(28,10),(28,11),(29,10);

INSERT INTO store_inventory (book_id,price,quantity)
VALUES (1,8.99,7),(2,47.99,2),(3,13.19,5),(4,13.50,17),
(5,12.74,10),(6,8.99,6),(7,10.99,11),(8,7.99,23),(9,13.99,7),
(10,25.91,3),(11,39.99,8),(12,22.99,9),(13,15.99,15),(14,33.99,18), (15,14.99,12);

INSERT INTO store_inventory (book_id,price,quantity)
VALUES (16,18.99,2),(17,15.64,4),(18,7.59,8),(19,16.79,9),
(20,14.49,12),(21,14.75,13),(22,8.11,14),(23,28.99,15),(24,30.99,3),
(25,20.69,4),(26,31.99,10),(27,13.99,8),(28,18.95,5),(29,31.49,10);
