CREATE DATABASE  IF NOT EXISTS `pataviva` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pataviva`;
-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pataviva
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consulta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_hora` datetime NOT NULL,
  `pet_id` int NOT NULL,
  `veterinario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pet_id` (`pet_id`),
  KEY `veterinario_id` (`veterinario_id`),
  CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`pet_id`) REFERENCES `pet` (`id`),
  CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`veterinario_id`) REFERENCES `veterinario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=319 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
INSERT INTO `consulta` VALUES (1,'2026-08-01 08:00:00',1,1),(2,'2026-08-01 09:00:00',2,3),(3,'2026-08-01 10:00:00',3,5),(4,'2026-08-01 11:00:00',4,2),(5,'2026-08-01 14:00:00',5,7),(6,'2026-08-01 15:00:00',6,4),(7,'2026-08-02 08:00:00',7,6),(8,'2026-08-02 09:00:00',8,8),(9,'2026-08-02 10:00:00',9,1),(10,'2026-08-02 11:00:00',10,9),(11,'2026-08-02 14:00:00',11,5),(12,'2026-08-02 15:00:00',12,2),(13,'2026-08-03 08:00:00',13,8),(14,'2026-08-03 09:00:00',14,3),(15,'2026-08-03 10:00:00',15,6),(16,'2026-08-03 11:00:00',16,5),(17,'2026-08-03 14:00:00',17,9),(18,'2026-08-03 15:00:00',18,4),(19,'2026-08-04 08:00:00',19,6),(20,'2026-08-04 09:00:00',20,4),(21,'2026-08-04 10:00:00',21,9),(22,'2026-08-04 11:00:00',22,1),(23,'2026-08-04 14:00:00',23,7),(24,'2026-08-04 15:00:00',24,8),(25,'2026-08-05 08:00:00',25,5),(26,'2026-08-05 09:00:00',26,2),(27,'2026-08-05 10:00:00',27,9),(28,'2026-08-05 11:00:00',28,3),(29,'2026-08-05 14:00:00',29,1),(30,'2026-08-05 15:00:00',30,5),(31,'2026-08-06 08:00:00',31,7),(32,'2026-08-06 09:00:00',32,8),(33,'2026-08-06 10:00:00',33,4),(34,'2026-08-06 11:00:00',34,6),(35,'2026-08-06 14:00:00',35,9),(36,'2026-08-06 15:00:00',36,2),(37,'2026-08-07 08:00:00',37,1),(38,'2026-08-07 09:00:00',38,7),(39,'2026-08-07 10:00:00',39,8),(40,'2026-08-07 11:00:00',40,5),(41,'2026-08-07 14:00:00',41,2),(42,'2026-08-07 15:00:00',42,3),(43,'2026-08-08 08:00:00',43,5),(44,'2026-08-08 09:00:00',44,9),(45,'2026-08-08 10:00:00',45,1),(46,'2026-08-08 11:00:00',46,6),(47,'2026-08-08 14:00:00',47,8),(48,'2026-08-08 15:00:00',48,4),(49,'2026-08-09 08:00:00',49,6),(50,'2026-08-09 09:00:00',50,9),(51,'2026-08-09 10:00:00',51,3),(52,'2026-08-09 11:00:00',52,1),(53,'2026-08-09 14:00:00',53,7),(54,'2026-08-09 15:00:00',54,8),(55,'2026-08-10 08:00:00',55,5),(56,'2026-08-10 09:00:00',56,2),(57,'2026-08-10 10:00:00',57,3),(58,'2026-08-10 11:00:00',58,5),(59,'2026-08-10 14:00:00',59,9),(60,'2026-08-10 15:00:00',60,1),(61,'2026-08-11 08:00:00',61,8),(62,'2026-08-11 09:00:00',62,7),(63,'2026-08-11 10:00:00',63,4),(64,'2026-08-11 11:00:00',64,6),(65,'2026-08-11 14:00:00',65,2),(66,'2026-08-11 15:00:00',66,9),(67,'2026-08-12 08:00:00',67,1),(68,'2026-08-12 09:00:00',68,7),(69,'2026-08-12 10:00:00',69,8),(70,'2026-08-12 11:00:00',70,5),(71,'2026-08-12 14:00:00',71,2),(72,'2026-08-12 15:00:00',72,3),(73,'2026-08-13 08:00:00',73,5),(74,'2026-08-13 09:00:00',74,9),(75,'2026-08-13 10:00:00',75,1),(76,'2026-08-13 11:00:00',76,6),(77,'2026-08-13 14:00:00',77,8),(78,'2026-08-13 15:00:00',78,4),(79,'2026-08-14 08:00:00',79,6),(80,'2026-08-14 09:00:00',80,4),(81,'2026-08-14 10:00:00',81,9),(82,'2026-08-14 11:00:00',82,1),(83,'2026-08-14 14:00:00',83,7),(84,'2026-08-14 15:00:00',84,8),(85,'2026-08-15 08:00:00',85,5),(86,'2026-08-15 09:00:00',86,2),(87,'2026-08-15 10:00:00',87,3),(88,'2026-08-15 11:00:00',88,5),(89,'2026-08-15 14:00:00',89,9),(90,'2026-08-15 15:00:00',90,1),(91,'2026-08-16 08:00:00',91,8),(92,'2026-08-16 09:00:00',92,7),(93,'2026-08-16 10:00:00',93,4),(94,'2026-08-16 11:00:00',94,6),(95,'2026-08-16 14:00:00',95,2),(96,'2026-08-16 15:00:00',96,9),(97,'2026-08-17 08:00:00',97,1),(98,'2026-08-17 09:00:00',98,7),(99,'2026-08-17 10:00:00',99,8),(100,'2026-08-17 11:00:00',100,5),(101,'2026-08-17 14:00:00',101,2),(102,'2026-08-17 15:00:00',102,3),(103,'2026-08-18 08:00:00',103,5),(104,'2026-08-18 09:00:00',104,9),(105,'2026-08-18 10:00:00',105,1),(106,'2026-08-18 11:00:00',106,6),(107,'2026-08-18 14:00:00',107,8),(108,'2026-08-18 15:00:00',108,4),(109,'2026-08-19 08:00:00',109,6),(110,'2026-08-19 09:00:00',110,4),(111,'2026-08-19 10:00:00',111,9),(112,'2026-08-19 11:00:00',112,1),(113,'2026-08-19 14:00:00',113,7),(114,'2026-08-19 15:00:00',114,8),(115,'2026-08-20 08:00:00',115,5),(116,'2026-08-20 09:00:00',116,2),(117,'2026-08-20 10:00:00',117,3),(118,'2026-08-20 11:00:00',118,5),(119,'2026-08-20 14:00:00',119,9),(120,'2026-08-20 15:00:00',120,1),(121,'2026-08-21 08:00:00',121,8),(122,'2026-08-21 09:00:00',122,7),(123,'2026-08-21 10:00:00',123,4),(124,'2026-08-21 11:00:00',124,6),(125,'2026-08-21 14:00:00',125,2),(126,'2026-08-21 15:00:00',126,9),(127,'2026-08-22 08:00:00',127,1),(128,'2026-08-22 09:00:00',128,7),(129,'2026-08-22 10:00:00',129,8),(130,'2026-08-22 11:00:00',130,5),(131,'2026-08-22 14:00:00',131,2),(132,'2026-08-22 15:00:00',132,3),(133,'2026-08-23 08:00:00',133,5),(134,'2026-08-23 09:00:00',134,9),(135,'2026-08-23 10:00:00',135,1),(136,'2026-08-23 11:00:00',136,6),(137,'2026-08-23 14:00:00',137,8),(138,'2026-08-23 15:00:00',138,4),(139,'2026-08-24 08:00:00',139,6),(140,'2026-08-24 09:00:00',140,4),(141,'2026-08-24 10:00:00',141,9),(142,'2026-08-24 11:00:00',142,1),(143,'2026-08-24 14:00:00',143,7),(144,'2026-08-24 15:00:00',144,8),(145,'2026-08-25 08:00:00',145,5),(146,'2026-08-25 09:00:00',146,2),(147,'2026-08-25 10:00:00',147,3),(148,'2026-08-25 11:00:00',148,5),(149,'2026-08-25 14:00:00',149,9),(150,'2026-08-25 15:00:00',150,1),(151,'2026-08-26 08:00:00',151,8),(152,'2026-08-26 09:00:00',152,7),(153,'2026-08-26 10:00:00',153,4),(154,'2026-08-26 11:00:00',154,6),(155,'2026-08-26 14:00:00',155,2),(156,'2026-08-26 15:00:00',156,9),(157,'2026-08-27 08:00:00',157,1),(158,'2026-08-27 09:00:00',158,7),(159,'2026-08-27 10:00:00',159,8),(160,'2026-08-27 11:00:00',160,5),(161,'2026-08-27 14:00:00',161,2),(162,'2026-08-27 15:00:00',162,3),(163,'2026-08-28 08:00:00',163,5),(164,'2026-08-28 09:00:00',164,9),(165,'2026-08-28 10:00:00',165,1),(166,'2026-08-28 11:00:00',166,6),(167,'2026-08-28 14:00:00',167,8),(168,'2026-08-28 15:00:00',168,4),(169,'2026-08-29 08:00:00',169,6),(170,'2026-08-29 09:00:00',170,4),(171,'2026-08-29 10:00:00',171,9),(172,'2026-08-29 11:00:00',172,1),(173,'2026-08-29 14:00:00',173,7),(174,'2026-08-29 15:00:00',174,8),(175,'2026-08-30 08:00:00',175,5),(176,'2026-08-30 09:00:00',176,2),(177,'2026-08-30 10:00:00',177,3),(178,'2026-08-30 11:00:00',178,5),(179,'2026-08-30 14:00:00',179,9),(180,'2026-08-30 15:00:00',180,1),(181,'2026-08-31 08:00:00',181,8),(182,'2026-08-31 09:00:00',182,7),(183,'2026-08-31 10:00:00',183,4),(184,'2026-08-31 11:00:00',184,6),(185,'2026-08-31 14:00:00',185,2),(186,'2026-08-31 15:00:00',186,9),(187,'2026-09-01 08:00:00',187,1),(188,'2026-09-01 09:00:00',188,7),(189,'2026-09-01 10:00:00',189,8),(190,'2026-09-01 11:00:00',190,5),(191,'2026-09-01 14:00:00',191,2),(192,'2026-09-01 15:00:00',192,3),(193,'2026-09-02 08:00:00',193,5),(194,'2026-09-02 09:00:00',194,9),(195,'2026-09-02 10:00:00',195,1),(196,'2026-09-02 11:00:00',196,6),(197,'2026-09-02 14:00:00',197,8),(198,'2026-09-02 15:00:00',198,4),(199,'2026-09-03 08:00:00',199,6),(200,'2026-09-03 09:00:00',200,9),(201,'2026-09-03 10:00:00',1,3),(202,'2026-09-03 11:00:00',10,7),(203,'2026-09-03 14:00:00',20,5),(204,'2026-09-03 15:00:00',30,8),(205,'2026-09-04 08:00:00',40,2),(206,'2026-09-04 09:00:00',50,6),(207,'2026-09-04 10:00:00',60,9),(208,'2026-09-04 11:00:00',70,1),(209,'2026-09-04 14:00:00',80,4),(210,'2026-09-04 15:00:00',90,7),(211,'2026-09-05 08:00:00',100,3),(212,'2026-09-05 09:00:00',110,8),(213,'2026-09-05 10:00:00',120,9),(214,'2026-09-05 11:00:00',130,5),(215,'2026-09-05 14:00:00',140,1),(216,'2026-09-05 15:00:00',150,6),(217,'2026-09-06 08:00:00',160,4),(218,'2026-09-06 09:00:00',170,7),(219,'2026-09-06 10:00:00',180,2),(220,'2026-09-06 11:00:00',190,8),(221,'2026-09-06 14:00:00',200,9),(222,'2026-09-07 08:00:00',5,2),(223,'2026-09-07 09:00:00',15,4),(224,'2026-09-07 10:00:00',25,6),(225,'2026-09-07 11:00:00',35,8),(226,'2026-09-07 14:00:00',45,1),(227,'2026-09-07 15:00:00',55,9),(228,'2026-09-08 08:00:00',65,3),(229,'2026-09-08 09:00:00',75,5),(230,'2026-09-08 10:00:00',85,7),(231,'2026-09-08 11:00:00',95,2),(232,'2026-09-08 14:00:00',105,4),(233,'2026-09-08 15:00:00',115,6),(234,'2026-09-09 08:00:00',125,8),(235,'2026-09-09 09:00:00',135,9),(236,'2026-09-09 10:00:00',145,1),(237,'2026-09-09 11:00:00',155,3),(238,'2026-09-09 14:00:00',165,5),(239,'2026-09-09 15:00:00',175,7),(240,'2026-09-10 08:00:00',185,8),(241,'2026-09-10 09:00:00',195,9),(242,'2026-09-10 10:00:00',2,1),(243,'2026-09-10 11:00:00',12,4),(244,'2026-09-10 14:00:00',22,6),(245,'2026-09-10 15:00:00',32,8),(246,'2026-09-11 08:00:00',42,2),(247,'2026-09-11 09:00:00',52,5),(248,'2026-09-11 10:00:00',62,7),(249,'2026-09-11 11:00:00',72,9),(250,'2026-09-11 14:00:00',82,3),(251,'2026-09-11 15:00:00',92,6),(252,'2026-09-12 08:00:00',102,8),(253,'2026-09-12 09:00:00',112,1),(254,'2026-09-12 10:00:00',122,4),(255,'2026-09-12 11:00:00',132,5),(256,'2026-09-12 14:00:00',142,7),(257,'2026-09-12 15:00:00',152,9),(258,'2026-09-13 08:00:00',162,2),(259,'2026-09-13 09:00:00',172,6),(260,'2026-09-13 10:00:00',182,8),(261,'2026-09-13 11:00:00',192,3),(262,'2026-09-13 14:00:00',8,5),(263,'2026-09-13 15:00:00',18,7),(264,'2026-09-14 08:00:00',28,9),(265,'2026-09-14 09:00:00',38,4),(266,'2026-09-14 10:00:00',48,6),(267,'2026-09-14 11:00:00',58,1),(268,'2026-09-14 14:00:00',68,8),(269,'2026-09-14 15:00:00',78,2),(270,'2026-09-15 08:00:00',88,5),(271,'2026-09-15 09:00:00',98,7),(272,'2026-09-15 10:00:00',108,9),(273,'2026-09-15 11:00:00',118,3),(274,'2026-09-15 14:00:00',128,6),(275,'2026-09-15 15:00:00',138,1),(276,'2026-09-16 08:00:00',148,8),(277,'2026-09-16 09:00:00',158,4),(278,'2026-09-16 10:00:00',168,7),(279,'2026-09-16 11:00:00',178,2),(280,'2026-09-16 14:00:00',188,5),(281,'2026-09-16 15:00:00',198,9),(282,'2026-09-17 08:00:00',3,6),(283,'2026-09-17 09:00:00',23,8),(284,'2026-09-17 10:00:00',43,1),(285,'2026-09-17 11:00:00',63,5),(286,'2026-09-17 14:00:00',83,7),(287,'2026-09-17 15:00:00',103,9),(288,'2026-09-18 08:00:00',123,4),(289,'2026-09-18 09:00:00',143,6),(290,'2026-09-18 10:00:00',163,8),(291,'2026-09-18 11:00:00',183,2),(292,'2026-09-18 14:00:00',193,5),(293,'2026-09-18 15:00:00',13,7),(294,'2026-09-19 08:00:00',33,9),(295,'2026-09-19 09:00:00',53,1),(296,'2026-09-19 10:00:00',73,3),(297,'2026-09-19 11:00:00',93,6),(298,'2026-09-19 14:00:00',113,8),(299,'2026-09-19 15:00:00',173,4),(300,'2026-09-20 10:00:00',200,7);
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `especie` varchar(40) DEFAULT NULL,
  `tutor_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tutor_id` (`tutor_id`),
  CONSTRAINT `pet_ibfk_1` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=220 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` VALUES (1,'Rex','Cachorro',1),(2,'Mel','Gato',1),(3,'Thor','Cachorro',1),(4,'Luna','Gato',2),(5,'Max','Cachorro',2),(6,'Nina','Cachorro',3),(7,'Bob','Cachorro',4),(8,'Mia','Gato',4),(9,'Toby','Cachorro',4),(10,'Thor','Gato',5),(11,'Pipoca','Cachorro',5),(12,'Fred','Cachorro',6),(13,'Amora','Gato',6),(14,'Bento','Cachorro',7),(15,'Zoe','Gato',7),(16,'Jade','Cachorro',7),(17,'Luke','Cachorro',8),(18,'Cookie','Gato',8),(19,'Duke','Cachorro',9),(20,'Maya','Gato',10),(21,'Nala','Gato',10),(22,'Bruce','Cachorro',10),(23,'Pérola','Gato',11),(24,'Billy','Cachorro',11),(25,'Kira','Cachorro',12),(26,'Tom','Gato',13),(27,'Jerry','Gato',13),(28,'Spike','Cachorro',13),(29,'Bidu','Cachorro',14),(30,'Lili','Gato',15),(31,'Apollo','Cachorro',15),(32,'Cristal','Gato',16),(33,'Nico','Cachorro',16),(34,'Pingo','Cachorro',16),(35,'Belinha','Cachorro',17),(36,'Romeu','Gato',17),(37,'Sushi','Gato',18),(38,'Frida','Cachorro',19),(39,'Theo','Gato',19),(40,'Dora','Cachorro',19),(41,'Chico','Cachorro',20),(42,'Mimi','Gato',21),(43,'Tigrão','Gato',21),(44,'Paco','Cachorro',22),(45,'Loki','Gato',22),(46,'Boris','Cachorro',22),(47,'Cacau','Gato',23),(48,'Bobby','Cachorro',24),(49,'Kiwi','Ave',24),(50,'Pépe','Cachorro',25),(51,'Sofia','Gato',26),(52,'Tito','Cachorro',26),(53,'Maggie','Cachorro',26),(54,'Frajola','Gato',27),(55,'Nino','Cachorro',28),(56,'Lua','Gato',28),(57,'Zeus','Cachorro',29),(58,'Diana','Gato',29),(59,'Ringo','Cachorro',29),(60,'Cleo','Gato',30),(61,'Marley','Cachorro',31),(62,'Milu','Gato',31),(63,'Billy','Cachorro',32),(64,'Pudim','Gato',32),(65,'Caju','Gato',32),(66,'Nescau','Cachorro',33),(67,'Amendoim','Cachorro',34),(68,'Paçoca','Gato',34),(69,'Bolota','Cachorro',35),(70,'Neve','Gato',35),(71,'Panda','Cachorro',35),(72,'Teddy','Cachorro',36),(73,'Fiona','Gato',37),(74,'Oliver','Cachorro',37),(75,'Malu','Gato',38),(76,'Jack','Cachorro',38),(77,'Nina','Gato',38),(78,'Ragnar','Cachorro',39),(79,'Pérola','Gato',40),(80,'Café','Cachorro',40),(81,'Mochi','Gato',41),(82,'Bruce','Cachorro',41),(83,'Lola','Cachorro',41),(84,'Bibi','Gato',42),(85,'Ozzy','Cachorro',43),(86,'Maggie','Gato',43),(87,'Pipoca','Cachorro',44),(88,'Fubá','Gato',44),(89,'Churros','Cachorro',44),(90,'Amora','Gato',45),(91,'Toby','Cachorro',46),(92,'Luna','Gato',46),(93,'Apollo','Cachorro',47),(94,'Nala','Gato',47),(95,'Milo','Cachorro',47),(96,'Simba','Gato',48),(97,'Dobby','Cachorro',49),(98,'Mel','Gato',49),(99,'Thor','Cachorro',50),(100,'Kiara','Gato',50),(101,'Pingo','Cachorro',50),(102,'Loki','Gato',51),(103,'Fred','Cachorro',52),(104,'Mia','Gato',52),(105,'Nino','Cachorro',53),(106,'Jujuba','Gato',53),(107,'Tigrão','Gato',53),(108,'Bento','Cachorro',54),(109,'Zeca','Cachorro',55),(110,'Lili','Gato',55),(111,'Paco','Cachorro',56),(112,'Maya','Gato',56),(113,'Pérola','Gato',56),(114,'Bob','Cachorro',57),(115,'Nala','Gato',58),(116,'Rex','Cachorro',58),(117,'Sushi','Gato',59),(118,'Theo','Cachorro',59),(119,'Luna','Gato',59),(120,'Duke','Cachorro',60),(121,'Mimi','Gato',61),(122,'Max','Cachorro',61),(123,'Zoe','Gato',62),(124,'Boris','Cachorro',62),(125,'Pipoca','Cachorro',62),(126,'Milu','Gato',63),(127,'Thor','Cachorro',64),(128,'Amora','Gato',64),(129,'Chico','Cachorro',65),(130,'Frida','Gato',65),(131,'Bento','Cachorro',65),(132,'Nina','Gato',66),(133,'Romeu','Gato',67),(134,'Luke','Cachorro',67),(135,'Cacau','Gato',68),(136,'Toby','Cachorro',68),(137,'Mel','Gato',68),(138,'Zeus','Cachorro',69),(139,'Pudim','Gato',70),(140,'Nescau','Cachorro',70),(141,'Lola','Gato',71),(142,'Bruce','Cachorro',71),(143,'Jade','Gato',71),(144,'Dora','Cachorro',72),(145,'Mochi','Gato',73),(146,'Ragnar','Cachorro',73),(147,'Panda','Cachorro',74),(148,'Neve','Gato',74),(149,'Fubá','Cachorro',74),(150,'Kiwi','Ave',75),(151,'Maggie','Gato',76),(152,'Oliver','Cachorro',76),(153,'Cleo','Gato',77),(154,'Jack','Cachorro',77),(155,'Luna','Gato',77),(156,'Bidu','Cachorro',78),(157,'Pipoca','Cachorro',79),(158,'Mimi','Gato',79),(159,'Teddy','Cachorro',80),(160,'Melody','Gato',80),(161,'Pingo','Cachorro',80),(162,'Nala','Gato',81),(163,'Bobby','Cachorro',82),(164,'Sofia','Gato',82),(165,'Marley','Cachorro',83),(166,'Lua','Gato',83),(167,'Diana','Gato',83),(168,'Spike','Cachorro',84),(169,'Jujuba','Gato',85),(170,'Apollo','Cachorro',85),(171,'Rex','Cachorro',86),(172,'Cristal','Gato',86),(173,'Pérola','Gato',86),(174,'Nico','Cachorro',87),(175,'Fiona','Gato',88),(176,'Dobby','Cachorro',88),(177,'Ozzy','Cachorro',89),(178,'Milu','Gato',89),(179,'Café','Cachorro',89),(180,'Bolota','Gato',90),(181,'Theo','Cachorro',91),(182,'Maya','Gato',91),(183,'Tigrão','Gato',92),(184,'Fred','Cachorro',92),(185,'Lola','Gato',92),(186,'Bento','Cachorro',93),(187,'Amendoim','Cachorro',94),(188,'Paçoca','Gato',94),(189,'Simba','Gato',95),(190,'Thor','Cachorro',95),(191,'Nina','Gato',95),(192,'Bob','Cachorro',96),(193,'Kiara','Gato',97),(194,'Duke','Cachorro',97),(195,'Loki','Gato',98),(196,'Max','Cachorro',98),(197,'Zoe','Gato',98),(198,'Ragnar','Cachorro',99),(199,'Mia','Gato',100),(200,'Toby','Cachorro',100);
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES (1,'Gustavo Tavos','7799900000'),(2,'Gustavo Silva','77999990001'),(3,'João Santos','77999990002'),(4,'Maria Oliveira','77999990003'),(5,'Carlos Souza','77999990004'),(6,'Ana Costa','77999990005'),(7,'Pedro Almeida','77999990006'),(8,'Lucas Ferreira','77999990007'),(9,'Juliana Rodrigues','77999990008'),(10,'Rafael Martins','77999990009'),(11,'Camila Pereira','77999990010'),(12,'Bruno Carvalho','77999990011'),(13,'Larissa Gomes','77999990012'),(14,'Felipe Ribeiro','77999990013'),(15,'Amanda Barbosa','77999990014'),(16,'Diego Lima','77999990015'),(17,'Beatriz Teixeira','77999990016'),(18,'Gabriel Moreira','77999990017'),(19,'Isabela Alves','77999990018'),(20,'Matheus Correia','77999990019'),(21,'Letícia Mendes','77999990020'),(22,'Thiago Nascimento','77999990021'),(23,'Mariana Cardoso','77999990022'),(24,'Vinícius Rocha','77999990023'),(25,'Bianca Castro','77999990024'),(26,'André Dias','77999990025'),(27,'Fernanda Monteiro','77999990026'),(28,'Ricardo Araújo','77999990027'),(29,'Carolina Freitas','77999990028'),(30,'Eduardo Vieira','77999990029'),(31,'Natália Ramos','77999990030'),(32,'Leonardo Moura','77999990031'),(33,'Patrícia Batista','77999990032'),(34,'Rodrigo Cunha','77999990033'),(35,'Aline Campos','77999990034'),(36,'Marcelo Pinto','77999990035'),(37,'Renata Farias','77999990036'),(38,'Daniel Lopes','77999990037'),(39,'Vanessa Moraes','77999990038'),(40,'Henrique Sales','77999990039'),(41,'Priscila Duarte','77999990040'),(42,'Alexandre Tavares','77999990041'),(43,'Sabrina Neves','77999990042'),(44,'Maurício Rezende','77999990043'),(45,'Cristiane Borges','77999990044'),(46,'Fernando Melo','77999990045'),(47,'Tatiane Pires','77999990046'),(48,'Marcelo Azevedo','77999990047'),(49,'Débora Leal','77999990048'),(50,'Samuel Coelho','77999990049'),(51,'Raquel Nunes','77999990050'),(52,'Igor Santana','77999990051'),(53,'Priscila Andrade','77999990052'),(54,'Wesley Barros','77999990053'),(55,'Jéssica Duarte','77999990054'),(56,'Fábio Ramos','77999990055'),(57,'Luana Melo','77999990056'),(58,'Caio Martins','77999990057'),(59,'Mônica Freire','77999990058'),(60,'Vitor Hugo','77999990059'),(61,'Elaine Souza','77999990060'),(62,'Arthur Mendes','77999990061'),(63,'Gabriela Rocha','77999990062'),(64,'Renan Oliveira','77999990063'),(65,'Cíntia Alves','77999990064'),(66,'Murilo Pereira','77999990065'),(67,'Tainá Carvalho','77999990066'),(68,'Otávio Lima','77999990067'),(69,'Débora Martins','77999990068'),(70,'Cauã Ferreira','77999990069'),(71,'Nicole Santos','77999990070'),(72,'Enzo Ribeiro','77999990071'),(73,'Manuela Costa','77999990072'),(74,'Breno Castro','77999990073'),(75,'Yasmin Moreira','77999990074'),(76,'Davi Nascimento','77999990075'),(77,'Alice Cardoso','77999990076'),(78,'Heitor Souza','77999990077'),(79,'Valentina Gomes','77999990078'),(80,'Luan Rodrigues','77999990079'),(81,'Melissa Teixeira','77999990080'),(82,'Pablo Correia','77999990081'),(83,'Lorena Barbosa','77999990082'),(84,'Nathan Vieira','77999990083'),(85,'Eduarda Monteiro','77999990084'),(86,'Jorge Araújo','77999990085'),(87,'Clara Freitas','77999990086'),(88,'Bárbara Dias','77999990087'),(89,'Guilherme Moura','77999990088'),(90,'Heloísa Batista','77999990089'),(91,'Nicolas Cunha','77999990090'),(92,'Sofia Campos','77999990091'),(93,'José Pinto','77999990092'),(94,'Laura Farias','77999990093'),(95,'Antônio Lopes','77999990094'),(96,'Cecília Moraes','77999990095'),(97,'Miguel Sales','77999990096'),(98,'Helena Neves','77999990097'),(99,'Vicente Rezende','77999990098'),(100,'Clara Borges','77999990099'),(127,'Ana Laura','770987678');
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veterinario`
--

DROP TABLE IF EXISTS `veterinario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veterinario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `crmv` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veterinario`
--

LOCK TABLES `veterinario` WRITE;
/*!40000 ALTER TABLE `veterinario` DISABLE KEYS */;
INSERT INTO `veterinario` VALUES (1,'Dr. Marcos Mendes','CRM-VET-1001'),(2,'Dra. Patricia Lima','CRM-VET-1002'),(3,'Dr. Ricardo Alves','CRM-VET-1003'),(4,'Dra. Fernanda Costa','CRM-VET-1004'),(5,'Dr. Henrique Souza','CRM-VET-1005'),(6,'Dra. Juliana Martins','CRM-VET-1006'),(7,'Dr. Rafael Oliveira','CRM-VET-1007'),(8,'Dra. Camila Rodrigues','CRM-VET-1008'),(9,'Dr. Felipe Santos','CRM-VET-1009'),(10,'Dr. JPA','CRMV-JPA-001'),(11,'Dr. JPA','CRMV-JPA-001');
/*!40000 ALTER TABLE `veterinario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_agenda_pataviva`
--

DROP TABLE IF EXISTS `vw_agenda_pataviva`;
/*!50001 DROP VIEW IF EXISTS `vw_agenda_pataviva`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_agenda_pataviva` AS SELECT 
 1 AS `tutor_id`,
 1 AS `tutor`,
 1 AS `quantidade_pets`,
 1 AS `pet`,
 1 AS `especie`,
 1 AS `veterinario`,
 1 AS `crmv`,
 1 AS `data_hora`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'pataviva'
--
/*!50003 DROP FUNCTION IF EXISTS `quantidade_pets` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE FUNCTION `quantidade_pets`(tutor_id INT) RETURNS int
    DETERMINISTIC
BEGIN
    DECLARE quantidade INT;

    SELECT COUNT(*)
    INTO quantidade
    FROM pet
    WHERE pet.tutor_id = tutor_id;

    RETURN quantidade;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `atualizar_nome_pet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE PROCEDURE `atualizar_nome_pet`(
    IN p_pet_id INT,
    IN p_novo_nome VARCHAR(100),
    OUT p_nome_atualizado VARCHAR(100)
)
BEGIN

    UPDATE pet
    SET nome = p_novo_nome
    WHERE id = p_pet_id;

    SELECT nome
    INTO p_nome_atualizado
    FROM pet
    WHERE id = p_pet_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deletar_pet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE PROCEDURE `deletar_pet`(
    IN p_pet_id INT,
    IN p_tutor_id INT,
    INOUT p_quantidade INT
)
BEGIN

    DELETE FROM pet
    WHERE id = p_pet_id
      AND tutor_id = p_tutor_id;

    SELECT COUNT(*)
    INTO p_quantidade
    FROM pet
    WHERE tutor_id = p_tutor_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_tutor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE PROCEDURE `inserir_tutor`(
    IN p_nome VARCHAR(100),
    IN p_telefone VARCHAR(20)
)
BEGIN
    INSERT INTO tutor (nome, telefone)
    VALUES (p_nome, p_telefone);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vw_agenda_pataviva`
--

/*!50001 DROP VIEW IF EXISTS `vw_agenda_pataviva`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 SQL SECURITY INVOKER */
/*!50001 VIEW `vw_agenda_pataviva` AS select `t`.`id` AS `tutor_id`,`t`.`nome` AS `tutor`,count(distinct `p_total`.`id`) AS `quantidade_pets`,`p`.`nome` AS `pet`,`p`.`especie` AS `especie`,`v`.`nome` AS `veterinario`,`v`.`crmv` AS `crmv`,`c`.`data_hora` AS `data_hora` from ((((`consulta` `c` join `pet` `p` on((`c`.`pet_id` = `p`.`id`))) join `tutor` `t` on((`p`.`tutor_id` = `t`.`id`))) join `veterinario` `v` on((`c`.`veterinario_id` = `v`.`id`))) join `pet` `p_total` on((`p_total`.`tutor_id` = `t`.`id`))) group by `t`.`id`,`t`.`nome`,`p`.`id`,`p`.`nome`,`p`.`especie`,`v`.`id`,`v`.`nome`,`v`.`crmv`,`c`.`id`,`c`.`data_hora` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-08-21 17:08:11
