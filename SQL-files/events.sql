-- MySQL dump 10.13  Distrib 5.7.16, for osx10.11 (x86_64)
--
-- Host: localhost    Database: events
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
  `attendanceCOUNT` int(10) unsigned NOT NULL,
  `owner` varchar(150) NOT NULL,
  `contactEmail` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO 'events' VALUES 
  (1,'Park Cleanup Westville NJ','Open','Looking for volunteers to help clean up XYZ park',
    'Westville, NJ 08093','07/13/2017','7AM-4PM','312','John Smith','smith@email.com'),
  (2,'Test Event 2','Closed','This is a description for Test Event 2',
    'Glassboro, NJ 08028','02/01/2017','10AM-7PM','47','John Wayne','wayne@email.com'),
  (3,'Test Event 3','Open','This is a description for Test Event 3',
    'Glassboro, NJ 08028','03/23/2017','10AM-7PM','47','John Stamos','stamos@email.com'),
  (4,'Test Event 4','Open','This is a description for Test Event 4',
    'Glassboro, NJ 08028','04/14/2017','10AM-7PM','47','John Hancock','hancock@email.com'),
  (5,'Test Event 5','Closed','This is a description for Test Event 5',
    'Glassboro, NJ 08028','05/15/2017','10AM-7PM','47','John F Kennedy','kennedy@email.com'),
  (6,'Test Event 6','Open','This is a description for Test Event 6',
    'Glassboro, NJ 08028','06/16/2017','10AM-7PM','47','John D Rockefeller','rockefeller@email.com'),
  (7,'Test Event 7','Open','This is a description for Test Event 7',
    'Glassboro, NJ 08028','07/17/2017','10AM-7PM','47','John Mellencamp','mellencamp@email.com'),
  (8,'Test Event 8','Closed','This is a description for Test Event 8',
    'Glassboro, NJ 08028','08/18/2017','10AM-7PM','47','John Calvin','calvin@email.com'),
  (9,'Test Event 9','Closed','This is a description for Test Event 9',
    'Glassboro, NJ 08028','09/19/2017','10AM-7PM','47','John J. Pershing','pershing@email.com'),
  (10,'Test Event 10','Open','This is a description for Test Event 10',
    'Glassboro, NJ 08028','10/10/2017','10AM-7PM','47','John Cabot','cabot@email.com'),
  (11,'Test Event 11','Open','This is a description for Test Event 11',
    'Glassboro, NJ 08028','11/11/2017','10AM-7PM','47','John Cena','ucantcme@email.com');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-19 19:44:16
