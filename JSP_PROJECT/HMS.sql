-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--user akalanka
--user online
--
-- Host: 127.0.0.1    Database: hms
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `docid` int NOT NULL,
  `specialization` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`docid`),
  CONSTRAINT `fk_doctor` FOREIGN KEY (`docid`) REFERENCES `user` (`uid`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'surgeon'),(7,'wet');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctornotice`
--

DROP TABLE IF EXISTS `doctornotice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctornotice` (
  `noteid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `docid` int DEFAULT NULL,
  PRIMARY KEY (`noteid`),
  KEY `fk_docid_note_idx` (`docid`),
  CONSTRAINT `fk_docid_note` FOREIGN KEY (`docid`) REFERENCES `doctor` (`docid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctornotice`
--

LOCK TABLES `doctornotice` WRITE;
/*!40000 ALTER TABLE `doctornotice` DISABLE KEYS */;
INSERT INTO `doctornotice` VALUES (7,'first notice updated new','first notice first notice first notice first notice first notice',1);
/*!40000 ALTER TABLE `doctornotice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS `nurse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nurse` (
  `nurseid` int NOT NULL,
  `rank` varchar(45) DEFAULT NULL,
  `wordid` int NOT NULL,
  PRIMARY KEY (`nurseid`),
  KEY `fk_nurse_idx` (`nurseid`),
  KEY `fk_nurse1_idx` (`wordid`),
  CONSTRAINT `fk_nurse` FOREIGN KEY (`nurseid`) REFERENCES `user` (`uid`),
  CONSTRAINT `fk_nurse1` FOREIGN KEY (`wordid`) REFERENCES `ward` (`wardnumber`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nurse`
--

LOCK TABLES `nurse` WRITE;
/*!40000 ALTER TABLE `nurse` DISABLE KEYS */;
/*!40000 ALTER TABLE `nurse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patientid` int NOT NULL AUTO_INCREMENT,
  `specialnote` varchar(100) DEFAULT NULL,
  `bloodgroup` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `tpno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`patientid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,NULL,'A','akalanka','sakalasooriya','no 13','1999-01-23','0772454123'),(2,NULL,'A','himesha','sakalasooriya','no 13','1999-01-23','0772454123'),(3,NULL,'A','mahinda','sakalasooriya','no 13','1999-01-23','0772454123');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_guardian`
--

DROP TABLE IF EXISTS `patient_guardian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_guardian` (
  `patient_id` int NOT NULL,
  `guardian_name` varchar(45) DEFAULT NULL,
  `guardian_nic` varchar(45) NOT NULL,
  PRIMARY KEY (`patient_id`,`guardian_nic`),
  CONSTRAINT `fk_guardian_pid` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_guardian`
--

LOCK TABLES `patient_guardian` WRITE;
/*!40000 ALTER TABLE `patient_guardian` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_guardian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patienttreatmentsperiod`
--

DROP TABLE IF EXISTS `patienttreatmentsperiod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patienttreatmentsperiod` (
  `periodid` int NOT NULL AUTO_INCREMENT,
  `patientid` int DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  PRIMARY KEY (`periodid`),
  KEY `fk_patient_id_idx` (`patientid`),
  CONSTRAINT `fk_patient_id` FOREIGN KEY (`patientid`) REFERENCES `patient` (`patientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patienttreatmentsperiod`
--

LOCK TABLES `patienttreatmentsperiod` WRITE;
/*!40000 ALTER TABLE `patienttreatmentsperiod` DISABLE KEYS */;
/*!40000 ALTER TABLE `patienttreatmentsperiod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescribe`
--

DROP TABLE IF EXISTS `prescribe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescribe` (
  `prescriptionid` int NOT NULL,
  `patientid` int NOT NULL,
  `docid` int NOT NULL,
  PRIMARY KEY (`prescriptionid`,`patientid`,`docid`),
  KEY `fk_priscribe_2_idx` (`docid`),
  KEY `fk_priscribe_3_idx` (`patientid`),
  CONSTRAINT `fk_priscribe_1` FOREIGN KEY (`prescriptionid`) REFERENCES `prescription` (`prescriptionid`),
  CONSTRAINT `fk_priscribe_2` FOREIGN KEY (`docid`) REFERENCES `doctor` (`docid`),
  CONSTRAINT `fk_priscribe_3` FOREIGN KEY (`patientid`) REFERENCES `patient` (`patientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescribe`
--

LOCK TABLES `prescribe` WRITE;
/*!40000 ALTER TABLE `prescribe` DISABLE KEYS */;
INSERT INTO `prescribe` VALUES (4,1,1),(5,1,1),(6,2,1),(7,3,1),(8,2,1);
/*!40000 ALTER TABLE `prescribe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `prescriptionid` int NOT NULL AUTO_INCREMENT,
  `details` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`prescriptionid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (4,'afwe','2020-04-27','pending'),(5,'sfbsbwv','2020-04-27','pending'),(6,' dvveve','2020-04-27','pending'),(7,'fvrbr    rwbwev','2020-04-27','pending'),(8,'anjana anjana anjana ','2020-04-28','pending');
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `roomid` int NOT NULL AUTO_INCREMENT,
  `availability` varchar(45) DEFAULT NULL,
  `wordid` int DEFAULT NULL,
  `patientid` int DEFAULT NULL,
  PRIMARY KEY (`roomid`),
  KEY `fk_room1_idx` (`wordid`),
  KEY `fk_room2_idx` (`patientid`),
  CONSTRAINT `fk_room1` FOREIGN KEY (`wordid`) REFERENCES `ward` (`wardnumber`),
  CONSTRAINT `fk_room2` FOREIGN KEY (`patientid`) REFERENCES `patient` (`patientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialnote`
--

DROP TABLE IF EXISTS `specialnote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialnote` (
  `noteid` int NOT NULL AUTO_INCREMENT,
  `discription` varchar(100) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`noteid`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialnote`
--

LOCK TABLES `specialnote` WRITE;
/*!40000 ALTER TABLE `specialnote` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialnote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spnotewrite`
--

DROP TABLE IF EXISTS `spnotewrite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spnotewrite` (
  `spnoteid` int NOT NULL,
  `patientid` int NOT NULL,
  `nurseid` int NOT NULL,
  PRIMARY KEY (`spnoteid`,`patientid`,`nurseid`),
  KEY `fk_spnote1_idx` (`patientid`),
  KEY `fk_spnote2_idx` (`nurseid`),
  CONSTRAINT `fk_spnote1` FOREIGN KEY (`patientid`) REFERENCES `patient` (`patientid`),
  CONSTRAINT `fk_spnote2` FOREIGN KEY (`nurseid`) REFERENCES `nurse` (`nurseid`),
  CONSTRAINT `fk_spnote3` FOREIGN KEY (`spnoteid`) REFERENCES `specialnote` (`noteid`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spnotewrite`
--

LOCK TABLES `spnotewrite` WRITE;
/*!40000 ALTER TABLE `spnotewrite` DISABLE KEYS */;
/*!40000 ALTER TABLE `spnotewrite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `tpno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'akalanka','123','akalanka','sakalasooriya','doctor','no 14','1998-11-09','0112234678'),(3,'malith','1234','malith','anjana','nurse','no 16','1997-01-09','0112234678'),(4,'kavindi','12345','kavindi','fernandu','rep','no 23/b','1998-07-11','0112234678'),(5,'yasiru','123456','yasiru','sajith','admin','no 23/2','1997-10-12','0112234678'),(7,'anjana','akalanka','anjana','de seram','doctor','no 221b','1998-01-06',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ward`
--

DROP TABLE IF EXISTS `ward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ward` (
  `wardnumber` int NOT NULL AUTO_INCREMENT,
  `discription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`wardnumber`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ward`
--

LOCK TABLES `ward` WRITE;
/*!40000 ALTER TABLE `ward` DISABLE KEYS */;
/*!40000 ALTER TABLE `ward` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-03 12:59:26
