CREATE DATABASE  IF NOT EXISTS `reghours` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `reghours`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: reghours
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `timerecord`
--

DROP TABLE IF EXISTS `timerecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timerecord` (
  `idRecord` int(11) NOT NULL AUTO_INCREMENT,
  `record` datetime NOT NULL,
  `type` enum('ENTRY','EXIT') NOT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`idRecord`),
  KEY `user` (`user`),
  CONSTRAINT `timerecord_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timerecord`
--

LOCK TABLES `timerecord` WRITE;
/*!40000 ALTER TABLE `timerecord` DISABLE KEYS */;
INSERT INTO `timerecord` VALUES (1,'2019-02-03 17:51:41','ENTRY',1),(2,'2019-02-03 17:52:03','EXIT',1),(3,'2019-02-03 17:52:19','ENTRY',1),(5,'2019-02-03 17:54:00','EXIT',1),(19,'2019-02-04 01:58:40','ENTRY',1),(20,'2019-02-04 02:04:42','EXIT',1),(21,'2019-02-04 02:35:29','ENTRY',1),(22,'2019-02-04 02:38:42','EXIT',1),(23,'2019-02-04 02:39:43','ENTRY',1),(24,'2019-02-04 02:41:46','EXIT',1),(25,'2019-02-04 03:07:53','ENTRY',2),(26,'2019-02-04 03:11:30','EXIT',2),(27,'2019-02-04 03:11:38','ENTRY',2),(28,'2019-02-04 03:11:39','EXIT',2),(29,'2019-02-04 03:11:42','ENTRY',2),(30,'2019-02-04 03:11:42','EXIT',2),(31,'2019-02-04 03:11:42','ENTRY',2),(32,'2019-02-04 03:11:43','EXIT',2),(33,'2019-02-04 03:12:42','ENTRY',2),(34,'2019-02-04 03:12:43','EXIT',2),(35,'2019-02-05 23:41:17','ENTRY',1),(36,'2019-02-05 23:41:18','EXIT',1),(37,'2019-02-08 01:19:39','ENTRY',1),(38,'2019-02-08 01:35:42','EXIT',1),(39,'2019-02-08 01:36:36','ENTRY',1),(40,'2019-02-08 01:39:34','EXIT',1),(41,'2019-02-08 02:40:21','ENTRY',1),(42,'2019-02-08 02:43:53','EXIT',1),(43,'2019-02-08 02:45:45','ENTRY',1),(44,'2019-02-08 02:45:47','EXIT',1),(45,'2019-02-09 19:14:28','ENTRY',2),(46,'2019-02-09 19:14:30','EXIT',2),(47,'2019-02-17 23:52:22','ENTRY',4),(48,'2019-02-17 23:52:37','EXIT',4),(49,'2019-02-17 23:52:40','ENTRY',4),(50,'2019-02-17 23:52:41','EXIT',4),(51,'2019-02-17 23:59:50','ENTRY',5),(52,'2019-02-17 23:59:51','EXIT',5),(53,'2019-02-17 23:59:51','ENTRY',5),(54,'2019-02-17 23:59:52','EXIT',5),(55,'2019-02-18 00:48:10','ENTRY',4);
/*!40000 ALTER TABLE `timerecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `firstname` varchar(48) NOT NULL,
  `lastname` varchar(90) NOT NULL,
  `email` varchar(68) NOT NULL,
  `passwd` varchar(64) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Benji','Benjamin Adam','Nagy','benji@benji.com','93a4bead3d527e99bc4271330142b2243ec0033bab74f2f7f94edda5fd84659b'),(2,'Krisz','Krisztian Mark','Nagy','krisztian.nagy15@gmail.hu','3ec2412fa9d5f454647d19ca698d386a38f85c98a4415a89759d8c117a49a620'),(4,'UsuarioPrueba','Usuario','Prueba','usuario@prueba.com','d9edf77a003854090bfaa9853c9b3f4e29bcf4722d0ccb849d61c38eeb11a3ed'),(5,'UsuarioPrueba2','Usuario2','Prueba2','usuario2@prueba2.com','72cfed2d3be7a93c4b9b564aca0157705bba5417d7d108ef0275803811ce0528');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-18  1:19:05
