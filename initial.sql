CREATE DATABASE  IF NOT EXISTS `monoDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `monoDB`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: monoDB
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address_address_type`
--

DROP TABLE IF EXISTS `address_address_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_address_type` (
  `address_id` int DEFAULT NULL,
  `address_type_id` int DEFAULT NULL,
  KEY `address_id` (`address_id`),
  KEY `address_type_id` (`address_type_id`),
  CONSTRAINT `address_address_type_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`),
  CONSTRAINT `address_address_type_ibfk_2` FOREIGN KEY (`address_type_id`) REFERENCES `address_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_address_type`
--

LOCK TABLES `address_address_type` WRITE;
/*!40000 ALTER TABLE `address_address_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_address_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_types`
--

DROP TABLE IF EXISTS `address_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_types` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_types`
--

LOCK TABLES `address_types` WRITE;
/*!40000 ALTER TABLE `address_types` DISABLE KEYS */;
INSERT INTO `address_types` VALUES (2,'BILLING'),(1,'SHIPPING');
/*!40000 ALTER TABLE `address_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `street_name` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `postal_code` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `addresses` (`street_name`,`city`,`state`,`postal_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `authority` (`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `pagecount` int DEFAULT NULL,
  `publishdate` date DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`),
  UNIQUE KEY `isbn` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Green Eggs and Ham',65,'1960-08-12','0545002850','Dr. Suess','../assets/images/greeneggs.jpg'),
(2,'The Algorithm Design Manual, 3rd Edition',810,'2020-10-06','3030542556','Steven S. Skiena','../assets/images/thealgorithms.jpg'),
(3,'The Organized Mind',544,'2015-09-01','9780147516','Daniel J. Levitin','../assets/images/organizedmind.jpg'),
(4,'Crime and Punishment',576,'1866-01-01','9781593080','Fyodor Dostoyevsky','../assets/images/crimeandpunishment.jpg'),
(5,'From Crook to Cook',192,'2018-10-23','1452179611','Snoop Dogg','../assets/images/crooktocook.jpg'),
(6,'Make Magic! Do Good!',112,'2012-11-13','763657468','Dallas Clayton','../assets/images/makemagic.jpg'),
(7,'The Drama of the Gifted Child: The Search for the True Self',136,'1997-01-01','0465016901','Alice Miller','../assets/images/giftedchild.jpg'),
(8,'The Great Gatsby',152,'1925-04-10','0743273567','F. Scott Fitzgerald','../assets/images/greatgatsby.jpg'),
(9,'Percy Jackson and the Lightning Thief',377,'2006-04-01','0786838655','Rick Riordan','../assets/images/lightning.jpg'),
(10,'Quantum Physics for Dummies',336,'2009-02-03','1118460820','Steven Holzner','../assets/images/quantum.jpg'),
(11,'Design Patterns: Elements of Reusable Object-Oriented Software',416,'1994-11-10','0201633612','Erich Gamma','../assets/images/designpatterns'),
(12,'Clean Architecture: A Craftsman\'s Guide to Software Structure and Design',432,'2017-09-10','0134494168','Robert Martin','../assets/images/cleanarchitecture.jpg'),
(13,'The Lost Art of Listening, Third Edition: How Learning to Listen Can Improve Relationships',370,'2021-03-24','1462542743','Michael P. Nichols','../assets/images/listening.jpg'),
(14,'C.G. Jung Psychological Reflections : A New Anthology of His Writings, 1905-1961',393,'1973-05-01','0691017867','C. G. Jung','../assets/images/jungreflections.jpg'),
(15,'Tao Te Ching (Illustrated Feng/English/Lippe Translation)',184,'2011-11-01','0307949303','Lao Tsu','../assets/images/taoteching.jpg'),
(16,'Interworld',304,'2007-09-06','0007523424','Michael Reaves','../assets/images/interworld.jpg'),
(17,'Where the Sidewalk Ends',309,'1905-05-05','0060256672','Shel Silverstein','../assets/images/sidewalk.jpg'),
(18,'The Future Evolution of Man: The Divine Life Upon Earth',168,'2003-11-04','0940985551','Sri Aurobindo','../assets/images/futureevolution.jpg'),
(19,'Total Freedom: The Essential Krishnamurti',384,'1996-12-08','0060648805','Jiddu Krishnamurti','../assets/images/totalfreedom.jpg'),
(20,'In Order to Live: A North Korean Girl\'s Journey to Freedom',288,'2016-11-09','0143109740','Yeonmi Park','../assets/images/inordertolive.jpg'),
(21,'The Seven Military Classics Of Ancient China',592,'2007-06-11','0465003044','Ralph D. Sawyer','../assets/images/sevenmilitaryclassics.jpg'),
(22,'Man\'s Search for Meaning',192,'2006-01-06','0807014273',' Viktor E. Frankl','../assets/images/manssearch.jpg'),
(23,'The Leader\'s Bookshelf',288,'2017-10-03','1682471799','James Stavridis','../assets/images/leadersbookshelf.jpg'),
(24,'The Inheritance Cycle 4-Book Trade Paperback Boxed Set: Eragon; Eldest; Brisingr; Inheritance',880,'2017-08-10','449813223','Christopher Paolini','../assets/images/inheritance.jpg'),
(25,'Chronicles of Tao: The Secret Life of a Taoist Master',476,'1993-08-10','0062502190','Deng Ming-Dao','../assets/images/chroniclesoftao.jpg'),
(26,'Dune',890,'1965-01-08','0593099320','Frank Herbert','../assets/images/dune'),(27,'Design of Everyday Things: Revised',368,'2013-05-11','0465050654','Don Norman','../assets/images/designofeverydaythings.jpg'),
(28,'Astrophysics for People in a Hurry',222,'2017-02-05','0393609391','Neil deGrasse Tyson','../assets/images/astrophysicsinahurry.jpg'),
(29,'Tao of Jeet Kune Do: Expanded Edition',250,'2011-01-11','0897502027','Bruce Lee','../assets/images/taojeetkunedo.jpg');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_join`
--

DROP TABLE IF EXISTS `cart_join`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_join` (
  `cart_id` int DEFAULT NULL,
  `book_id` int DEFAULT NULL,
  KEY `cart_id` (`cart_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `cart_join_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`),
  CONSTRAINT `cart_join_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_join`
--

LOCK TABLES `cart_join` WRITE;
/*!40000 ALTER TABLE `cart_join` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_join` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (1);
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_join`
--

DROP TABLE IF EXISTS `genre_join`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre_join` (
  `book_id` int DEFAULT NULL,
  `genre_id` int DEFAULT NULL,
  KEY `book_id` (`book_id`),
  KEY `genre_id` (`genre_id`),
  CONSTRAINT `genre_join_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `genre_join_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_join`
--

LOCK TABLES `genre_join` WRITE;
/*!40000 ALTER TABLE `genre_join` DISABLE KEYS */;
INSERT INTO `genre_join` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,1),(7,6),(8,7),(8,8),(9,7),(9,9),(10,10),(10,11),(11,2),(12,2),(13,6),(14,6),(15,4),(16,7),(17,12),(18,4),(19,4),(20,8),(21,4),(22,8),(23,10),(24,7),(24,9),(25,7),(25,4),(26,7),(26,9),(27,10),(27,11),(28,10),(28,11),(29,10);
/*!40000 ALTER TABLE `genre_join` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (1,'Children\'s'),(2,'Computer Science'),(5,'Cookbook'),(9,'Fantasy'),(7,'Fiction'),(8,'Historical'),(10,'Nonfiction'),(4,'Philosophy'),(12,'Poetry'),(6,'Psychology'),(11,'Science'),(3,'Self-Help');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_inventory`
--

DROP TABLE IF EXISTS `store_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_inventory` (
  `book_id` int NOT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_inventory`
--

LOCK TABLES `store_inventory` WRITE;
/*!40000 ALTER TABLE `store_inventory` DISABLE KEYS */;
INSERT INTO `store_inventory` VALUES (1,8.99,7),(2,47.99,2),(3,13.19,5),(4,13.5,17),(5,12.74,10),(6,8.99,6),(7,10.99,11),(8,7.99,23),(9,13.99,7),(10,25.91,3),(11,39.99,8),(12,22.99,9),(13,15.99,15),(14,33.99,18),(15,14.99,12),(16,18.99,2),(17,15.64,4),(18,7.59,8),(19,16.79,9),(20,14.49,12),(21,14.75,13),(22,8.11,14),(23,28.99,15),(24,30.99,3),(25,20.69,4),(26,31.99,10),(27,13.99,8),(28,18.95,5),(29,31.49,10);
/*!40000 ALTER TABLE `store_inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_address` (
  `user_id` int DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  UNIQUE KEY `user_address` (`user_id`,`address_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `user_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `user_address_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_authority` (
  `user_id` int DEFAULT NULL,
  `authority_id` int DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `user_authority_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `user_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (1,1);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) NOT NULL,
  `middle_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(128) NOT NULL,
  `cart_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test1First',NULL,'test1Last','test1@mail.com','$2a$10$gXY.y5B45WeaObTSzLW8nuWY0YvxUWyABtleHvz9UzGm9LauNJ04W',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'monoDB'
--

--
-- Dumping routines for database 'monoDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-11 21:23:16
