CREATE DATABASE  IF NOT EXISTS `transpotravel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `transpotravel`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: transpotravel
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
-- Table structure for table `contacteinfo`
--

DROP TABLE IF EXISTS `contacteinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacteinfo` (
  `idcontacteInfo` int NOT NULL AUTO_INCREMENT,
  `missatge` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idcontacteInfo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacteinfo`
--

LOCK TABLES `contacteinfo` WRITE;
/*!40000 ALTER TABLE `contacteinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `contacteinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `desplacament`
--

DROP TABLE IF EXISTS `desplacament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `desplacament` (
  `idDesplacament` int NOT NULL,
  `idpuntRecollida` int DEFAULT NULL,
  `dni` int DEFAULT NULL,
  `idDesti` int DEFAULT NULL,
  `idOrigen` int DEFAULT NULL,
  `preu` float DEFAULT NULL,
  `oferta` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idDesplacament`),
  KEY `idpuntRecollida` (`idpuntRecollida`),
  KEY `dni` (`dni`),
  KEY `idDesti` (`idDesti`),
  KEY `idOrigen` (`idOrigen`),
  CONSTRAINT `desplacament_ibfk_1` FOREIGN KEY (`idpuntRecollida`) REFERENCES `puntrecollida` (`idPunt`),
  CONSTRAINT `desplacament_ibfk_3` FOREIGN KEY (`idDesti`) REFERENCES `localitzacio` (`idLocalitzacio`),
  CONSTRAINT `desplacament_ibfk_4` FOREIGN KEY (`idOrigen`) REFERENCES `localitzacio` (`idLocalitzacio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desplacament`
--

LOCK TABLES `desplacament` WRITE;
/*!40000 ALTER TABLE `desplacament` DISABLE KEYS */;
INSERT INTO `desplacament` VALUES (1,1,1,1,1,23,1);
/*!40000 ALTER TABLE `desplacament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuciovols`
--

DROP TABLE IF EXISTS `distribuciovols`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribuciovols` (
  `iddistribuciovols` int NOT NULL AUTO_INCREMENT,
  `idorigen` int DEFAULT NULL,
  `iddesti` int DEFAULT NULL,
  `preu` int DEFAULT NULL,
  `horaSortida` datetime DEFAULT NULL,
  `horaArribada` datetime DEFAULT NULL,
  `oferta` tinyint(1) DEFAULT NULL,
  `idPuntRecollida` int DEFAULT NULL,
  `descripcio` varchar(150) DEFAULT NULL,
  `estat` int DEFAULT NULL,
  PRIMARY KEY (`iddistribuciovols`),
  KEY `iddesti` (`iddesti`),
  KEY `idorigen` (`idorigen`),
  KEY `idPuntRecollida` (`idPuntRecollida`),
  KEY `estat` (`estat`),
  CONSTRAINT `distribuciovols_ibfk_1` FOREIGN KEY (`idorigen`) REFERENCES `localitzacio` (`idLocalitzacio`),
  CONSTRAINT `distribuciovols_ibfk_2` FOREIGN KEY (`iddesti`) REFERENCES `localitzacio` (`idLocalitzacio`),
  CONSTRAINT `distribuciovols_ibfk_3` FOREIGN KEY (`idorigen`) REFERENCES `localitzacio` (`idLocalitzacio`),
  CONSTRAINT `distribuciovols_ibfk_4` FOREIGN KEY (`iddesti`) REFERENCES `localitzacio` (`idLocalitzacio`),
  CONSTRAINT `distribuciovols_ibfk_5` FOREIGN KEY (`idorigen`) REFERENCES `localitzacio` (`idLocalitzacio`),
  CONSTRAINT `distribuciovols_ibfk_6` FOREIGN KEY (`idPuntRecollida`) REFERENCES `puntrecollida` (`idPunt`),
  CONSTRAINT `distribuciovols_ibfk_7` FOREIGN KEY (`estat`) REFERENCES `estat` (`idEstat`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuciovols`
--

LOCK TABLES `distribuciovols` WRITE;
/*!40000 ALTER TABLE `distribuciovols` DISABLE KEYS */;
INSERT INTO `distribuciovols` VALUES (1,1,2,23,'2025-12-01 00:00:00','2026-12-01 00:00:00',1,1,'grgregerger',1);
/*!40000 ALTER TABLE `distribuciovols` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipatge`
--

DROP TABLE IF EXISTS `equipatge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipatge` (
  `idEquipatge` int NOT NULL,
  `dni` int DEFAULT NULL,
  `idDesti` int DEFAULT NULL,
  `idOrigen` int DEFAULT NULL,
  `pes` varchar(5) DEFAULT NULL,
  `idEstat` int DEFAULT NULL,
  `idPunt` int DEFAULT NULL,
  PRIMARY KEY (`idEquipatge`),
  KEY `dni` (`dni`),
  KEY `idDesti` (`idDesti`),
  KEY `idOrigen` (`idOrigen`),
  KEY `idEstat` (`idEstat`),
  KEY `idPunt` (`idPunt`),
  CONSTRAINT `equipatge_ibfk_2` FOREIGN KEY (`idDesti`) REFERENCES `localitzacio` (`idLocalitzacio`),
  CONSTRAINT `equipatge_ibfk_3` FOREIGN KEY (`idOrigen`) REFERENCES `localitzacio` (`idLocalitzacio`),
  CONSTRAINT `equipatge_ibfk_4` FOREIGN KEY (`idEstat`) REFERENCES `estat` (`idEstat`),
  CONSTRAINT `equipatge_ibfk_5` FOREIGN KEY (`idPunt`) REFERENCES `puntrecollida` (`idPunt`),
  CONSTRAINT `equipatge_ibfk_6` FOREIGN KEY (`dni`) REFERENCES `persona` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipatge`
--

LOCK TABLES `equipatge` WRITE;
/*!40000 ALTER TABLE `equipatge` DISABLE KEYS */;
INSERT INTO `equipatge` VALUES (1,11,1,1,'1',1,1);
/*!40000 ALTER TABLE `equipatge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estat`
--

DROP TABLE IF EXISTS `estat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estat` (
  `idEstat` int NOT NULL,
  `descripcio` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idEstat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estat`
--

LOCK TABLES `estat` WRITE;
/*!40000 ALTER TABLE `estat` DISABLE KEYS */;
INSERT INTO `estat` VALUES (1,'En espera');
/*!40000 ALTER TABLE `estat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localitzacio`
--

DROP TABLE IF EXISTS `localitzacio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localitzacio` (
  `idLocalitzacio` int NOT NULL,
  `ciutat` varchar(15) DEFAULT NULL,
  `codiPostal` int DEFAULT NULL,
  `descripcio` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idLocalitzacio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localitzacio`
--

LOCK TABLES `localitzacio` WRITE;
/*!40000 ALTER TABLE `localitzacio` DISABLE KEYS */;
INSERT INTO `localitzacio` VALUES (1,'madrid',12212,'frefrfer'),(2,'sevilla',121213,'ereberver'),(3,'barcelona',32423,'frefref');
/*!40000 ALTER TABLE `localitzacio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `dni` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(15) DEFAULT NULL,
  `cognom1` varchar(20) DEFAULT NULL,
  `cognom2` varchar(20) DEFAULT NULL,
  `adreca` varchar(20) DEFAULT NULL,
  `contrasenya` varchar(45) DEFAULT NULL,
  `correu` varchar(40) DEFAULT NULL,
  `telefon` int DEFAULT NULL,
  `esGold` tinyint(1) DEFAULT NULL,
  `supervisor` tinyint(1) DEFAULT NULL,
  `repartidor` tinyint(1) DEFAULT NULL,
  `proveidor` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (11,'Douglas','Portillo Almendares',NULL,NULL,'1234','prova@gmail.com',NULL,NULL,NULL,NULL,NULL),(13,'alejandro','perez',NULL,NULL,'1234','alejandro@gmail.com',NULL,NULL,NULL,NULL,NULL),(14,'douglas','portillo almendares',NULL,NULL,'1234','admin@gmail.com',NULL,NULL,NULL,NULL,NULL),(15,'1234','1234',NULL,NULL,'admin','admin',NULL,NULL,NULL,NULL,NULL),(16,'123','123',NULL,NULL,'123','123',NULL,NULL,NULL,NULL,NULL),(17,'prova','prova',NULL,NULL,'prova','prova',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntrecollida`
--

DROP TABLE IF EXISTS `puntrecollida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puntrecollida` (
  `idPunt` int NOT NULL,
  `idLocalitzacio` int DEFAULT NULL,
  `adreca` varchar(20) DEFAULT NULL,
  `descripcio` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idPunt`),
  KEY `idLocalitzacio` (`idLocalitzacio`),
  CONSTRAINT `puntrecollida_ibfk_1` FOREIGN KEY (`idLocalitzacio`) REFERENCES `localitzacio` (`idLocalitzacio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntrecollida`
--

LOCK TABLES `puntrecollida` WRITE;
/*!40000 ALTER TABLE `puntrecollida` DISABLE KEYS */;
INSERT INTO `puntrecollida` VALUES (1,3,'Carrer palamos','bfdbdf');
/*!40000 ALTER TABLE `puntrecollida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguiment`
--

DROP TABLE IF EXISTS `seguiment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguiment` (
  `idSeguiment` int NOT NULL,
  `idEquipatge` int DEFAULT NULL,
  `idDesplacament` int DEFAULT NULL,
  `idEstat` int DEFAULT NULL,
  PRIMARY KEY (`idSeguiment`),
  KEY `idEquipatge` (`idEquipatge`),
  KEY `idDesplacament` (`idDesplacament`),
  KEY `idEstat` (`idEstat`),
  CONSTRAINT `seguiment_ibfk_1` FOREIGN KEY (`idEquipatge`) REFERENCES `equipatge` (`idEquipatge`),
  CONSTRAINT `seguiment_ibfk_2` FOREIGN KEY (`idDesplacament`) REFERENCES `desplacament` (`idDesplacament`),
  CONSTRAINT `seguiment_ibfk_3` FOREIGN KEY (`idEstat`) REFERENCES `estat` (`idEstat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguiment`
--

LOCK TABLES `seguiment` WRITE;
/*!40000 ALTER TABLE `seguiment` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguiment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-05 15:38:53
