-- MySQL dump 10.13  Distrib 5.7.16, for osx10.11 (x86_64)
--
-- Host: localhost    Database: users
-- ------------------------------------------------------
-- Server version	5.7.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `eventsAttended`
--

DROP TABLE IF EXISTS `eventsAttended`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventsAttended` (
  `eventsAttended_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `eventsAttended` varchar(150) NOT NULL,
  PRIMARY KEY (`eventsAttended_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `eventsattended_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventsAttended`
--

LOCK TABLES `eventsAttended` WRITE;
/*!40000 ALTER TABLE `eventsAttended` DISABLE KEYS */;
INSERT INTO 'eventsAttended' VALUES 
  (1,1,'Test Event 2, Test Event 7'),
  (2,2,'Test Event 1, Test Event 10, Test Event 4'),
  (3,3,'Test Event 3'),
  (4,4,''),
  (5,5,'Park Cleanup Westville NJ, Test Event 5'),
  (6,6,'Test Event 10, Test Event 11'),
  (7,7,'Test Event 2, Test Event 5'),
  (8,8,'Test Event 1, Test Event 2, Test Event 3, Test Event 7'),
  (9,9,'Test Event 6'),
  (10,10,''),
  (11,11,'Test Event 2, Test Event 8, Test Event 11'),
  (12,12,'Test Event 2, Test Event 9'),

/*!40000 ALTER TABLE `eventsAttended` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventsCreated`
--

DROP TABLE IF EXISTS `eventsCreated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventsCreated` (
  `eventsCreated_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `eventsCreated` varchar(150) NOT NULL,
  PRIMARY KEY (`eventsCreated_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `eventscreated_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventsCreated`
--

LOCK TABLES `eventsCreated` WRITE;
/*!40000 ALTER TABLE `eventsCreated` DISABLE KEYS */;
INSERT INTO 'eventsCreated' VALUES
  (1,1,'Test Event 2, Test Event 7'),
  (2,2,'Test Event 1, Test Event 10, Test Event 4'),
  (3,3,'Test Event 3'),
  (4,4,''),
  (5,5,'Park Cleanup Westville NJ, Test Event 5'),
  (6,6,'Test Event 11'),
  (7,7,''),
  (8,8,''),
  (9,9,'Test Event 6'),
  (10,10,''),
  (11,11,'Test Event 8'),
  (12,12,'Test Event 9');
/*!40000 ALTER TABLE `eventsCreated` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(150) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `homeLocation` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO 'users' VALUES
  (1,'user1','password1','(555) 123-4567','user1@email.com','M','1 Wide St, Town, State, ZIP'),
  (2,'user2','p@ssword2','(555) 890-1234','user2@email.com','F','2 Small Rd, Town, State, ZIP'),
  (3,'user3','passw0rd3','(555) 567-8901','user3@email.com','M','3 Empty Dr, Town, State, ZIP'),
  (4,'user4','1234qwer','(555) 234-5678','user4@email.com','M','4 Laughing Cir, Town, State, ZIP'),
  (5,'user5','1f902e0d8a','(555) 901-2345','user5@email.com','F','5 Shephard Path, Town, State, ZIP'),
  (6,'user6','password6','(555) 678-9012','user6@email.com','F','6 Mexico Ln, Town, State, ZIP'),
  (7,'user7','password7','(555) 345-6789','user7@email.com','F','7 Hawthorne Rd, Town, State, ZIP'),
  (8,'user8','password8','(555) 123-7654','user8@email.com','M','8 Log Dr, Town, State, ZIP'),
  (9,'user9','password9','(555) 321-4567','user9@email.com','F','9 Arbor Ln, Town, State, ZIP'),
  (10,'user10','password10','(555) 213-4687','user10@email.com','M','10 Rain St, Town, State, ZIP'),
  (11,'user11','password11','(555) 123-8594','user11@email.com','M','11 Voluntold Cir, Town, State, ZIP'),
  (12,'user12','password12','(555) 133-4217','user12@email.com','M','12 Hidden Path, Town, State, ZIP');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-19 19:47:19
