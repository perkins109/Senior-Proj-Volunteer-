-- MySQL dump 10.13  Distrib 5.7.16, for osx10.11 (x86_64)
--
-- Host: localhost    Database: voluntold
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
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `status` varchar(150) NOT NULL,
  `description` text,
  `location` varchar(150) NOT NULL,
  `date` date NOT NULL,
  `time` datetime DEFAULT NULL,
  `attendanceCOUNT` int(10) unsigned NOT NULL DEFAULT '0',
  `owner` varchar(150) NOT NULL,
  `contactEmail` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Park Cleanup','true','clean up the park','rowan university','2016-10-10','2016-01-01 10:00:00',1,'nick','perkins109@gmail.com'),(2,'Cancer walk','true','raise money for cancer awarness','South Street, Philly','2016-12-20','2016-01-01 07:00:00',0,'bob','bob@gmail.com'),(3,'beach cleanup','true','Clean the beach','Ocean City, NJ','2016-11-10','2016-01-01 15:00:00',0,'mike','mike@gmail.com'),(5,'Soup Kitchen Prep','true','Feed the Hungry','Somers Point, NJ','2016-11-20','2016-01-01 10:30:00',0,'Harry','potter@gmail.com'),(10,'10k Run','true','Run for cancer','Mays Landing, NJ','2016-12-20','2016-01-01 10:30:00',0,'admin','potter@gmail.com');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventsAttended`
--

LOCK TABLES `eventsAttended` WRITE;
/*!40000 ALTER TABLE `eventsAttended` DISABLE KEYS */;
INSERT INTO `eventsAttended` VALUES (1,3,'1'),(2,3,'3'),(3,11,'3'),(4,11,'2'),(5,11,'1'),(6,3,'15');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventsCreated`
--

LOCK TABLES `eventsCreated` WRITE;
/*!40000 ALTER TABLE `eventsCreated` DISABLE KEYS */;
INSERT INTO `eventsCreated` VALUES (2,3,'10');
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
  `phone` varchar(150) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `homeLocation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test1','password',NULL,NULL,NULL,NULL),(2,'test2','test2',NULL,NULL,NULL,NULL),(3,'admin','admin',NULL,NULL,NULL,NULL),(7,'Bruce','banner',NULL,NULL,NULL,NULL),(8,'Tony','Hawk',NULL,NULL,NULL,NULL),(11,'Steve','jobs',NULL,NULL,NULL,NULL),(14,'BIll','shakspear',NULL,NULL,NULL,NULL),(15,'gianluca','password',NULL,NULL,NULL,NULL),(17,'ned','stark','6099263102','ts@strark.com','M','08244'),(18,'Nick','Perkins','6094570079','perkins109@gmail.com','M','08244');
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

-- Dump completed on 2016-11-08 17:44:50
