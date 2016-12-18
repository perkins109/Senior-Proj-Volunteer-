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
  `date` date NOT NULL,
  `time` datetime DEFAULT NULL,
  `attendanceCOUNT` int(10) unsigned NOT NULL DEFAULT '0',
  `owner` varchar(150) NOT NULL,
  `contactEmail` varchar(150) NOT NULL,
  `lat` float(10,6) DEFAULT NULL,
  `lng` float(10,6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Park Cleanup','true','clean up the park','2016-10-10','2016-01-01 10:00:00',1,'nick','perkins109@gmail.com',39.709862,-75.118950,NULL),(2,'Cancer walk','true','raise money for cancer awarness','2016-12-20','2016-01-01 07:00:00',0,'bob','bob@gmail.com',39.831432,-75.097733,NULL),(3,'beach cleanup','true','Clean the beach and get some rays','2016-11-10','2016-01-01 15:00:00',0,'mike','mike@gmail.com',39.277615,-74.574600,'Boardwalk Ocean City, NJ'),(5,'Soup Kitchen Prep','true','Feed the Hungry','2016-11-20','2016-01-01 10:30:00',0,'Harry','potter@gmail.com',39.799778,-75.108032,NULL),(10,'10k Run','true','Run for cancer','2016-12-20','2016-01-01 10:30:00',0,'admin','potter@gmail.com',39.316063,-74.605309,NULL),(11,'Help grandpa','true','Grandpa needs help','2016-12-20','2016-01-01 10:30:00',0,'admin','potter@gmail.com',39.831432,-75.097733,NULL),(12,'Christmas Contest','true','Help Spread XMAS CHEER!!!!!','2016-12-20','2016-01-01 10:30:00',0,'admin','potter@gmail.com',39.339836,-75.097733,NULL),(13,'Drain the Swamp','true','Help Donald Trump Clear out Washington','2016-11-10','2016-01-01 15:00:00',0,'DJT','DJT@gmail.com',39.277615,-74.574600,'Boardwalk Ocean City, NJ'),(14,'Drain the Swamp','true','Help Donald Trump Clear out Washington','2016-11-10','2016-01-01 15:00:00',0,'admin','DJT@gmail.com',39.277615,-74.574600,'Boardwalk Ocean City, NJ'),(15,'beach concert','true','Clean the beach and get some rays','2016-11-10','2016-01-01 15:00:00',0,'mike','mike@gmail.com',39.277615,-74.574600,'Boardwalk Ocean City, NJ'),(16,'night concert','true','Clean the beach and get some rays','2016-11-10','2016-01-01 15:00:00',0,'admin','mike@gmail.com',39.277615,-74.574600,NULL),(17,'night concert','true','Clean the beach and get some rays','2016-11-10','2016-01-01 15:00:00',0,'admin','mike@gmail.com',39.277615,-74.574600,NULL),(18,'bike ride ','true','ride for fun and a good cause','1992-10-09','2016-01-01 05:30:00',0,'admin','admin@admin.com',39.316063,-74.605309,NULL),(19,'bike ride ','true','ride for fun and a good cause','1992-10-09','2016-01-01 05:30:00',0,'admin','admin@admin.com',NULL,NULL,NULL),(20,'bike ride ','true','ride for fun and a good cause','1992-10-09','2016-01-01 05:30:00',0,'admin','admin@admin.com',NULL,NULL,NULL),(21,'bike ride ','true','ride for fun and a good cause','1992-10-09','2016-01-01 05:30:00',0,'admin','admin@admin.com',NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventsCreated`
--

LOCK TABLES `eventsCreated` WRITE;
/*!40000 ALTER TABLE `eventsCreated` DISABLE KEYS */;
INSERT INTO `eventsCreated` VALUES (2,3,'10'),(3,3,'11'),(4,3,'12'),(5,3,'14'),(6,3,'16'),(7,3,'17'),(8,3,'18'),(9,3,'19'),(10,3,'20'),(11,3,'21');
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test1','password',NULL,NULL,NULL,NULL),(2,'test2','test2',NULL,NULL,NULL,NULL),(3,'admin','admin',NULL,NULL,NULL,NULL),(7,'Bruce','banner',NULL,NULL,NULL,NULL),(8,'Tony','Hawk',NULL,NULL,NULL,NULL),(11,'Steve','jobs',NULL,NULL,NULL,NULL),(14,'BIll','shakspear',NULL,NULL,NULL,NULL),(15,'gianluca','password',NULL,NULL,NULL,NULL),(17,'ned','stark','6099263102','ts@strark.com','M','08244'),(18,'Nick','Perkins','6094570079','perkins109@gmail.com','M','08244'),(24,'arunn','password','6091234567','aruun@strark.com','M','08028'),(25,'dave','hudson','6099263101','ts@strark.com',NULL,NULL);
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

-- Dump completed on 2016-12-18 12:16:23
