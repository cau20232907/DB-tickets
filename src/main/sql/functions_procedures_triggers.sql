-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: tickets
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `cast`
--

DROP TABLE IF EXISTS `cast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cast` (
  `seq_order` tinyint NOT NULL,
  `event_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjm1g2cui8toqa9pt37uvu9cp` (`event_id`),
  CONSTRAINT `FKjm1g2cui8toqa9pt37uvu9cp` FOREIGN KEY (`event_id`) REFERENCES `concert` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cast`
--

LOCK TABLES `cast` WRITE;
/*!40000 ALTER TABLE `cast` DISABLE KEYS */;
/*!40000 ALTER TABLE `cast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cast_seq`
--

DROP TABLE IF EXISTS `cast_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cast_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cast_seq`
--

LOCK TABLES `cast_seq` WRITE;
/*!40000 ALTER TABLE `cast_seq` DISABLE KEYS */;
INSERT INTO `cast_seq` VALUES (1);
/*!40000 ALTER TABLE `cast_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert`
--

DROP TABLE IF EXISTS `concert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concert` (
  `id` bigint NOT NULL,
  `stadium_id` bigint DEFAULT NULL,
  `staff_id` bigint DEFAULT NULL,
  `explaination` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKddyx3p9trfo07rbmeikbdr5ok` (`stadium_id`),
  KEY `FK334ltnc5rwu6dy2q6vg015evl` (`staff_id`),
  CONSTRAINT `FK334ltnc5rwu6dy2q6vg015evl` FOREIGN KEY (`staff_id`) REFERENCES `event_staff` (`id`),
  CONSTRAINT `FKddyx3p9trfo07rbmeikbdr5ok` FOREIGN KEY (`stadium_id`) REFERENCES `stadium` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert`
--

LOCK TABLES `concert` WRITE;
/*!40000 ALTER TABLE `concert` DISABLE KEYS */;
INSERT INTO `concert` VALUES (1,1,5,'no expl','bts concert');
/*!40000 ALTER TABLE `concert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert_date`
--

DROP TABLE IF EXISTS `concert_date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concert_date` (
  `concert_id` bigint DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnmco54sgwsi48fv6ocomc9dk2` (`concert_id`),
  CONSTRAINT `FKnmco54sgwsi48fv6ocomc9dk2` FOREIGN KEY (`concert_id`) REFERENCES `concert` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert_date`
--

LOCK TABLES `concert_date` WRITE;
/*!40000 ALTER TABLE `concert_date` DISABLE KEYS */;
INSERT INTO `concert_date` VALUES (1,'2024-01-01 12:00:00.000000',1,'2024-01-01 10:00:00.000000'),(1,'2024-01-03 16:00:00.000000',2,'2024-01-03 18:00:00.000000');
/*!40000 ALTER TABLE `concert_date` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert_date_seq`
--

DROP TABLE IF EXISTS `concert_date_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concert_date_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert_date_seq`
--

LOCK TABLES `concert_date_seq` WRITE;
/*!40000 ALTER TABLE `concert_date_seq` DISABLE KEYS */;
INSERT INTO `concert_date_seq` VALUES (1);
/*!40000 ALTER TABLE `concert_date_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert_seq`
--

DROP TABLE IF EXISTS `concert_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concert_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert_seq`
--

LOCK TABLES `concert_seq` WRITE;
/*!40000 ALTER TABLE `concert_seq` DISABLE KEYS */;
INSERT INTO `concert_seq` VALUES (1);
/*!40000 ALTER TABLE `concert_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credential`
--

DROP TABLE IF EXISTS `credential`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credential` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userinfo_id` bigint DEFAULT NULL,
  `hash_value` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK3hhystqjjvuj9y452qgxiw7dj` (`userinfo_id`),
  CONSTRAINT `FK1dmr86ak8yw1osggn9f8tb29t` FOREIGN KEY (`userinfo_id`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credential`
--

LOCK TABLES `credential` WRITE;
/*!40000 ALTER TABLE `credential` DISABLE KEYS */;
INSERT INTO `credential` VALUES (1,3,'newARRFDARJFRRETEDW','ARRFDARJFRRETEDW'),(2,4,'123EGRDdEERAGIAFAHF','EGRDdEERAGIAFAHF'),(3,5,'bbb123','123'),(4,6,'444AjjUdFFJRdUjbADA','AjjUdFFJRdUjaADA');
/*!40000 ALTER TABLE `credential` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credential_seq`
--

DROP TABLE IF EXISTS `credential_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credential_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credential_seq`
--

LOCK TABLES `credential_seq` WRITE;
/*!40000 ALTER TABLE `credential_seq` DISABLE KEYS */;
INSERT INTO `credential_seq` VALUES (1);
/*!40000 ALTER TABLE `credential_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery` (
  `id` bigint NOT NULL,
  `arrival_address` varchar(255) DEFAULT NULL,
  `delivery_code` varchar(255) DEFAULT NULL,
  `delivery_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (1,'seoul','b09ca70d-30e4-4f65-83f5-69e11c5ac381','company');
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_record`
--

DROP TABLE IF EXISTS `delivery_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_record` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `arrival_address` varchar(255) DEFAULT NULL,
  `delivery_code` varchar(255) DEFAULT NULL,
  `delivery_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_record`
--

LOCK TABLES `delivery_record` WRITE;
/*!40000 ALTER TABLE `delivery_record` DISABLE KEYS */;
INSERT INTO `delivery_record` VALUES (13,'seoul','b09ca70d-30e4-4f65-83f5-69e11c5ac381','company');
/*!40000 ALTER TABLE `delivery_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_seq`
--

DROP TABLE IF EXISTS `delivery_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_seq`
--

LOCK TABLES `delivery_seq` WRITE;
/*!40000 ALTER TABLE `delivery_seq` DISABLE KEYS */;
INSERT INTO `delivery_seq` VALUES (51);
/*!40000 ALTER TABLE `delivery_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount_options`
--

DROP TABLE IF EXISTS `discount_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount_options` (
  `discount_rate` decimal(4,3) NOT NULL,
  `id` bigint NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount_options`
--

LOCK TABLES `discount_options` WRITE;
/*!40000 ALTER TABLE `discount_options` DISABLE KEYS */;
INSERT INTO `discount_options` VALUES (0.900,1,'army'),(0.950,2,'card');
/*!40000 ALTER TABLE `discount_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount_options_seq`
--

DROP TABLE IF EXISTS `discount_options_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount_options_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount_options_seq`
--

LOCK TABLES `discount_options_seq` WRITE;
/*!40000 ALTER TABLE `discount_options_seq` DISABLE KEYS */;
INSERT INTO `discount_options_seq` VALUES (1);
/*!40000 ALTER TABLE `discount_options_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_staff`
--

DROP TABLE IF EXISTS `event_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_staff` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK9rly4r3bf4amalpqmkhyihhmw` FOREIGN KEY (`id`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_staff`
--

LOCK TABLES `event_staff` WRITE;
/*!40000 ALTER TABLE `event_staff` DISABLE KEYS */;
INSERT INTO `event_staff` VALUES (5);
/*!40000 ALTER TABLE `event_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_seat_limit`
--

DROP TABLE IF EXISTS `free_seat_limit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `free_seat_limit` (
  `value` int NOT NULL,
  `id` bigint NOT NULL,
  `seat_grade_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8ma10n0y5vr14nirovbu5f0q5` (`seat_grade_id`),
  CONSTRAINT `FKdg80cj76juf096cv3247w7l7b` FOREIGN KEY (`seat_grade_id`) REFERENCES `seat_grade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_seat_limit`
--

LOCK TABLES `free_seat_limit` WRITE;
/*!40000 ALTER TABLE `free_seat_limit` DISABLE KEYS */;
/*!40000 ALTER TABLE `free_seat_limit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_seat_limit_seq`
--

DROP TABLE IF EXISTS `free_seat_limit_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `free_seat_limit_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_seat_limit_seq`
--

LOCK TABLES `free_seat_limit_seq` WRITE;
/*!40000 ALTER TABLE `free_seat_limit_seq` DISABLE KEYS */;
INSERT INTO `free_seat_limit_seq` VALUES (1);
/*!40000 ALTER TABLE `free_seat_limit_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_seat_nonpaid_ticket`
--

DROP TABLE IF EXISTS `free_seat_nonpaid_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `free_seat_nonpaid_ticket` (
  `id` bigint NOT NULL,
  `seat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5rn3ly0hjsxpupsso84kuwnbr` (`seat_id`),
  CONSTRAINT `FK5rn3ly0hjsxpupsso84kuwnbr` FOREIGN KEY (`seat_id`) REFERENCES `seat_grade` (`id`),
  CONSTRAINT `FKpcfgkrsy17jtfl8ta9gkdtht4` FOREIGN KEY (`id`) REFERENCES `nonpaid_ticket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_seat_nonpaid_ticket`
--

LOCK TABLES `free_seat_nonpaid_ticket` WRITE;
/*!40000 ALTER TABLE `free_seat_nonpaid_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `free_seat_nonpaid_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_seat_ticket`
--

DROP TABLE IF EXISTS `free_seat_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `free_seat_ticket` (
  `id` bigint NOT NULL,
  `seat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqyficytp25mkw5q6pxvghsy85` (`seat_id`),
  CONSTRAINT `FKf7xsbptu55202795dtbej4o48` FOREIGN KEY (`id`) REFERENCES `ticket` (`id`),
  CONSTRAINT `FKqyficytp25mkw5q6pxvghsy85` FOREIGN KEY (`seat_id`) REFERENCES `seat_grade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_seat_ticket`
--

LOCK TABLES `free_seat_ticket` WRITE;
/*!40000 ALTER TABLE `free_seat_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `free_seat_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_seat_ticket_record`
--

DROP TABLE IF EXISTS `free_seat_ticket_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `free_seat_ticket_record` (
  `id` bigint NOT NULL,
  `seat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkiblebbwbhoij2i5h4c8pkmex` (`seat_id`),
  CONSTRAINT `FKk3dg70cgcvshc4p8b88m6tklg` FOREIGN KEY (`id`) REFERENCES `ticket_record` (`id`),
  CONSTRAINT `FKkiblebbwbhoij2i5h4c8pkmex` FOREIGN KEY (`seat_id`) REFERENCES `seat_grade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_seat_ticket_record`
--

LOCK TABLES `free_seat_ticket_record` WRITE;
/*!40000 ALTER TABLE `free_seat_ticket_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `free_seat_ticket_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequences` (
  `next_val` bigint DEFAULT NULL,
  `sequence_name` varchar(255) NOT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES (0,'default');
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKm5qu4ynhlawrd6uq9omdbl6tn` FOREIGN KEY (`id`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (3),(4),(6);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nonpaid_ticket`
--

DROP TABLE IF EXISTS `nonpaid_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nonpaid_ticket` (
  `is_online` bit(1) DEFAULT NULL,
  `concert_date_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `member_id` bigint DEFAULT NULL,
  `purchase_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcbusxun1w54kqmihyvk1yyrgn` (`concert_date_id`),
  KEY `FKn1xrapgav7j9qp3ur01acv5kx` (`member_id`),
  CONSTRAINT `FKcbusxun1w54kqmihyvk1yyrgn` FOREIGN KEY (`concert_date_id`) REFERENCES `concert_date` (`id`),
  CONSTRAINT `FKn1xrapgav7j9qp3ur01acv5kx` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nonpaid_ticket`
--

LOCK TABLES `nonpaid_ticket` WRITE;
/*!40000 ALTER TABLE `nonpaid_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `nonpaid_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nonpaid_ticket_seq`
--

DROP TABLE IF EXISTS `nonpaid_ticket_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nonpaid_ticket_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nonpaid_ticket_seq`
--

LOCK TABLES `nonpaid_ticket_seq` WRITE;
/*!40000 ALTER TABLE `nonpaid_ticket_seq` DISABLE KEYS */;
INSERT INTO `nonpaid_ticket_seq` VALUES (1);
/*!40000 ALTER TABLE `nonpaid_ticket_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `total_balance` int NOT NULL,
  `id` bigint NOT NULL,
  `member_id` bigint DEFAULT NULL,
  `payment_time` datetime(6) DEFAULT NULL,
  `selected_discount_options_id` bigint DEFAULT NULL,
  `payment_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4pswry4r5sx6j57cdeulh1hx8` (`member_id`),
  KEY `FKohy4ca7nd4bhqxmefuyjew7su` (`selected_discount_options_id`),
  CONSTRAINT `FK4pswry4r5sx6j57cdeulh1hx8` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `FKohy4ca7nd4bhqxmefuyjew7su` FOREIGN KEY (`selected_discount_options_id`) REFERENCES `discount_options` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (188100,1,4,'2024-12-05 05:57:46.726391',1,'92d44ff6-6f2d-4d4f-9c24-4f767e8dce73');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_record`
--

DROP TABLE IF EXISTS `payment_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_record` (
  `total_balance` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `member_id` bigint DEFAULT NULL,
  `payment_time` datetime(6) DEFAULT NULL,
  `selected_discount_options_id` bigint DEFAULT NULL,
  `payment_code` varchar(255) DEFAULT NULL,
  `change_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7omivfirakitf2xin4jm7xy7` (`member_id`),
  KEY `FKg818clafxth9sv3gt0h7f7vxq` (`selected_discount_options_id`),
  CONSTRAINT `FK7omivfirakitf2xin4jm7xy7` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `FKg818clafxth9sv3gt0h7f7vxq` FOREIGN KEY (`selected_discount_options_id`) REFERENCES `discount_options` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_record`
--

LOCK TABLES `payment_record` WRITE;
/*!40000 ALTER TABLE `payment_record` DISABLE KEYS */;
INSERT INTO `payment_record` VALUES (188100,14,4,'2024-12-05 05:57:46.726391',1,'92d44ff6-6f2d-4d4f-9c24-4f767e8dce73','2024-12-05 09:59:02',0);
/*!40000 ALTER TABLE `payment_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_record_seq`
--

DROP TABLE IF EXISTS `payment_record_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_record_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_record_seq`
--

LOCK TABLES `payment_record_seq` WRITE;
/*!40000 ALTER TABLE `payment_record_seq` DISABLE KEYS */;
INSERT INTO `payment_record_seq` VALUES (1);
/*!40000 ALTER TABLE `payment_record_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_seq`
--

DROP TABLE IF EXISTS `payment_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_seq`
--

LOCK TABLES `payment_seq` WRITE;
/*!40000 ALTER TABLE `payment_seq` DISABLE KEYS */;
INSERT INTO `payment_seq` VALUES (51);
/*!40000 ALTER TABLE `payment_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserved_seat_nonpaid_ticket`
--

DROP TABLE IF EXISTS `reserved_seat_nonpaid_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserved_seat_nonpaid_ticket` (
  `id` bigint NOT NULL,
  `seat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr54lsu3ujjkgsymayfhej1sa6` (`seat_id`),
  CONSTRAINT `FKcfnugdi8dd4ynyycafdmwellu` FOREIGN KEY (`id`) REFERENCES `nonpaid_ticket` (`id`),
  CONSTRAINT `FKr54lsu3ujjkgsymayfhej1sa6` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserved_seat_nonpaid_ticket`
--

LOCK TABLES `reserved_seat_nonpaid_ticket` WRITE;
/*!40000 ALTER TABLE `reserved_seat_nonpaid_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserved_seat_nonpaid_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserved_seat_ticket`
--

DROP TABLE IF EXISTS `reserved_seat_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserved_seat_ticket` (
  `id` bigint NOT NULL,
  `seat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjup3d1n9g9a4f583rqfg3cqvv` (`seat_id`),
  CONSTRAINT `FKjup3d1n9g9a4f583rqfg3cqvv` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`),
  CONSTRAINT `FKkly8mgxedh2sjutng37kusrt9` FOREIGN KEY (`id`) REFERENCES `ticket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserved_seat_ticket`
--

LOCK TABLES `reserved_seat_ticket` WRITE;
/*!40000 ALTER TABLE `reserved_seat_ticket` DISABLE KEYS */;
INSERT INTO `reserved_seat_ticket` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `reserved_seat_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserved_seat_ticket_record`
--

DROP TABLE IF EXISTS `reserved_seat_ticket_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserved_seat_ticket_record` (
  `id` bigint NOT NULL,
  `seat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7dyma61bhwnw45lxmj0uxt6jw` (`seat_id`),
  CONSTRAINT `FK7dyma61bhwnw45lxmj0uxt6jw` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`),
  CONSTRAINT `FKe0k3819ecm3y52r8gq505p459` FOREIGN KEY (`id`) REFERENCES `ticket_record` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserved_seat_ticket_record`
--

LOCK TABLES `reserved_seat_ticket_record` WRITE;
/*!40000 ALTER TABLE `reserved_seat_ticket_record` DISABLE KEYS */;
INSERT INTO `reserved_seat_ticket_record` VALUES (35,1),(36,2);
/*!40000 ALTER TABLE `reserved_seat_ticket_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `grade_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `seat_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk24d9cbytt7764kdw7nll8bj1` (`grade_id`),
  CONSTRAINT `FKk24d9cbytt7764kdw7nll8bj1` FOREIGN KEY (`grade_id`) REFERENCES `seat_grade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (2,1,'S1'),(2,2,'S2');
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_grade`
--

DROP TABLE IF EXISTS `seat_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_grade` (
  `is_free` bit(1) DEFAULT NULL,
  `price` int NOT NULL,
  `id` bigint NOT NULL,
  `stadium_id` bigint DEFAULT NULL,
  `grade_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7aylexphwxc4w9ebd560qparj` (`stadium_id`),
  CONSTRAINT `FK7aylexphwxc4w9ebd560qparj` FOREIGN KEY (`stadium_id`) REFERENCES `stadium` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_grade`
--

LOCK TABLES `seat_grade` WRITE;
/*!40000 ALTER TABLE `seat_grade` DISABLE KEYS */;
INSERT INTO `seat_grade` VALUES (_binary '',120000,1,1,'R'),(_binary '\0',99000,2,1,'S');
/*!40000 ALTER TABLE `seat_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_grade_seq`
--

DROP TABLE IF EXISTS `seat_grade_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_grade_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_grade_seq`
--

LOCK TABLES `seat_grade_seq` WRITE;
/*!40000 ALTER TABLE `seat_grade_seq` DISABLE KEYS */;
INSERT INTO `seat_grade_seq` VALUES (1);
/*!40000 ALTER TABLE `seat_grade_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_seq`
--

DROP TABLE IF EXISTS `seat_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_seq`
--

LOCK TABLES `seat_seq` WRITE;
/*!40000 ALTER TABLE `seat_seq` DISABLE KEYS */;
INSERT INTO `seat_seq` VALUES (1);
/*!40000 ALTER TABLE `seat_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stadium`
--

DROP TABLE IF EXISTS `stadium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stadium` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `explaination` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stadium`
--

LOCK TABLES `stadium` WRITE;
/*!40000 ALTER TABLE `stadium` DISABLE KEYS */;
INSERT INTO `stadium` VALUES (1,'1234','kintex','no expl');
/*!40000 ALTER TABLE `stadium` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stadium_seq`
--

DROP TABLE IF EXISTS `stadium_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stadium_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stadium_seq`
--

LOCK TABLES `stadium_seq` WRITE;
/*!40000 ALTER TABLE `stadium_seq` DISABLE KEYS */;
INSERT INTO `stadium_seq` VALUES (1);
/*!40000 ALTER TABLE `stadium_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `is_online` bit(1) DEFAULT NULL,
  `concert_date_id` bigint DEFAULT NULL,
  `delivery_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `payment_id` bigint DEFAULT NULL,
  `purchase_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsabbtn09qddd7jdhyep5p0qhq` (`concert_date_id`),
  KEY `FKksvt4tgnlwi1n5ckvd8lcgws5` (`payment_id`),
  KEY `FKq2clfq51wo60sknwdetivlmdw` (`delivery_id`),
  CONSTRAINT `FKksvt4tgnlwi1n5ckvd8lcgws5` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`),
  CONSTRAINT `FKq2clfq51wo60sknwdetivlmdw` FOREIGN KEY (`delivery_id`) REFERENCES `delivery` (`id`),
  CONSTRAINT `FKsabbtn09qddd7jdhyep5p0qhq` FOREIGN KEY (`concert_date_id`) REFERENCES `concert_date` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (_binary '\0',1,1,1,1,'2024-12-05 05:57:28.175919'),(_binary '\0',1,1,2,1,'2024-12-05 05:57:28.175919');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_record`
--

DROP TABLE IF EXISTS `ticket_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_record` (
  `is_online` bit(1) DEFAULT NULL,
  `concert_date_id` bigint DEFAULT NULL,
  `delivery_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `payment_id` bigint DEFAULT NULL,
  `purchase_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj0fu1xkapwohd0gs348wak89r` (`concert_date_id`),
  KEY `FKdu5ey2mkfl1yxryxcoeuu7lw8_idx` (`delivery_id`),
  KEY `FKmcfg55x6xqp0qo13qsuv5hhb5_idx` (`payment_id`),
  CONSTRAINT `FKdu5ey2mkfl1yxryxcoeuu7lw8_idx` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_record` (`id`),
  CONSTRAINT `FKj0fu1xkapwohd0gs348wak89r` FOREIGN KEY (`concert_date_id`) REFERENCES `concert_date` (`id`),
  CONSTRAINT `FKmcfg55x6xqp0qo13qsuv5hhb5` FOREIGN KEY (`payment_id`) REFERENCES `payment_record` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_record`
--

LOCK TABLES `ticket_record` WRITE;
/*!40000 ALTER TABLE `ticket_record` DISABLE KEYS */;
INSERT INTO `ticket_record` VALUES (_binary '\0',1,13,35,14,'2024-12-05 05:57:28.175919'),(_binary '\0',1,13,36,14,'2024-12-05 05:57:28.175919');
/*!40000 ALTER TABLE `ticket_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_record_seq`
--

DROP TABLE IF EXISTS `ticket_record_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_record_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_record_seq`
--

LOCK TABLES `ticket_record_seq` WRITE;
/*!40000 ALTER TABLE `ticket_record_seq` DISABLE KEYS */;
INSERT INTO `ticket_record_seq` VALUES (1);
/*!40000 ALTER TABLE `ticket_record_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_seq`
--

DROP TABLE IF EXISTS `ticket_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_seq`
--

LOCK TABLES `ticket_seq` WRITE;
/*!40000 ALTER TABLE `ticket_seq` DISABLE KEYS */;
INSERT INTO `ticket_seq` VALUES (1);
/*!40000 ALTER TABLE `ticket_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_queue`
--

DROP TABLE IF EXISTS `transaction_queue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_queue` (
  `concert_date_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `member_id` bigint DEFAULT NULL,
  `seat_grade_id` bigint DEFAULT NULL,
  `seat_id` bigint DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl4frpm6qqdb4hj882ctfqqoop` (`concert_date_id`),
  KEY `FKklexr8j6otta1o1fod85q8yrv` (`member_id`),
  KEY `FK9u3h02rqo73pwvncb8ooyky47` (`seat_id`),
  KEY `FKscny5jeiakt65j02nbd8agwwt` (`seat_grade_id`),
  CONSTRAINT `FK9u3h02rqo73pwvncb8ooyky47` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`),
  CONSTRAINT `FKklexr8j6otta1o1fod85q8yrv` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `FKl4frpm6qqdb4hj882ctfqqoop` FOREIGN KEY (`concert_date_id`) REFERENCES `concert_date` (`id`),
  CONSTRAINT `FKscny5jeiakt65j02nbd8agwwt` FOREIGN KEY (`seat_grade_id`) REFERENCES `seat_grade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_queue`
--

LOCK TABLES `transaction_queue` WRITE;
/*!40000 ALTER TABLE `transaction_queue` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_queue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_queue_record`
--

DROP TABLE IF EXISTS `transaction_queue_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_queue_record` (
  `if_succeed` bit(1) DEFAULT NULL,
  `concert_date_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `member_id` bigint DEFAULT NULL,
  `seat_grade_id` bigint DEFAULT NULL,
  `seat_id` bigint DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK69hxtu0m2dr0e8t1tokoui3jh` (`concert_date_id`),
  KEY `FKte4jwg2xdrgv32urq81f06e9s` (`member_id`),
  KEY `FKk0yjn9pxq0cgjpb4d3rbrh6d5` (`seat_id`),
  KEY `FK96x2bp0g90usuk4mixgwdo2q8` (`seat_grade_id`),
  CONSTRAINT `FK69hxtu0m2dr0e8t1tokoui3jh` FOREIGN KEY (`concert_date_id`) REFERENCES `concert_date` (`id`),
  CONSTRAINT `FK96x2bp0g90usuk4mixgwdo2q8` FOREIGN KEY (`seat_grade_id`) REFERENCES `seat_grade` (`id`),
  CONSTRAINT `FKk0yjn9pxq0cgjpb4d3rbrh6d5` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`),
  CONSTRAINT `FKte4jwg2xdrgv32urq81f06e9s` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_queue_record`
--

LOCK TABLES `transaction_queue_record` WRITE;
/*!40000 ALTER TABLE `transaction_queue_record` DISABLE KEYS */;
INSERT INTO `transaction_queue_record` VALUES (_binary '',1,1,4,2,1,'2024-12-05 05:57:28.175919'),(_binary '',1,2,4,2,2,'2024-12-05 05:57:28.175919');
/*!40000 ALTER TABLE `transaction_queue_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_queue_record_seq`
--

DROP TABLE IF EXISTS `transaction_queue_record_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_queue_record_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_queue_record_seq`
--

LOCK TABLES `transaction_queue_record_seq` WRITE;
/*!40000 ALTER TABLE `transaction_queue_record_seq` DISABLE KEYS */;
INSERT INTO `transaction_queue_record_seq` VALUES (1);
/*!40000 ALTER TABLE `transaction_queue_record_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_queue_seq`
--

DROP TABLE IF EXISTS `transaction_queue_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_queue_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_queue_seq`
--

LOCK TABLES `transaction_queue_seq` WRITE;
/*!40000 ALTER TABLE `transaction_queue_seq` DISABLE KEYS */;
INSERT INTO `transaction_queue_seq` VALUES (101);
/*!40000 ALTER TABLE `transaction_queue_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (3,'new'),(4,'john'),(5,'staff'),(6,'man');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo_seq`
--

DROP TABLE IF EXISTS `userinfo_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo_seq`
--

LOCK TABLES `userinfo_seq` WRITE;
/*!40000 ALTER TABLE `userinfo_seq` DISABLE KEYS */;
INSERT INTO `userinfo_seq` VALUES (1);
/*!40000 ALTER TABLE `userinfo_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tickets'
--
/*!50003 DROP FUNCTION IF EXISTS `randomStr` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `randomStr`() RETURNS varchar(16) CHARSET utf8mb4
    NO SQL
BEGIN
	DECLARE seed VARCHAR(32) DEFAULT "NWandfjIARUETARHFADFBDFJAEKEAREG";
	DECLARE str VARCHAR(16) DEFAULT "";
    DECLARE num INT DEFAULT 0;
    DECLARE i INT default 0;
    WHILE i < 16 DO
		SET num = FLOOR(RAND() * 32 + 1);
        SET str = CONCAT(str, SUBSTR(seed, num, 1));
        SET i = i + 1;
	END WHILE;
RETURN str;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `replaceEncryp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `replaceEncryp`(input VARCHAR(255)) RETURNS varchar(255) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
    DECLARE transCode VARCHAR(255) DEFAULT input; 
    DECLARE firstChar CHAR(1) DEFAULT 'a';  
    DECLARE secondChar CHAR(1) DEFAULT 'b'; 

    RETURN REPLACE(transCode, firstChar, secondChar);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `saltEncryp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `saltEncryp`(intStr VARCHAR(255), salt VARCHAR(16), encryStr VARCHAR(255)) RETURNS tinyint(1)
    DETERMINISTIC
BEGIN
	DECLARE tempCode VARCHAR(255) DEFAULT "";
    DECLARE result BOOL DEFAULT false;
    SET tempCode = CONCAT(intStr, salt);
    SET tempCode = replaceEncryp(tempCode);
    SET result = STRCMP(encryStr, tempCode);
RETURN result;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `copy_related_records` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `copy_related_records`(
    IN payment_id BIGINT,
    IN isDeleted tinyint(1)
)
BEGIN
	DECLARE payment_record_id BIGINT;
	DECLARE ticket_record_id BIGINT;
	DECLARE delivery_record_id BIGINT;
    -- Payment 복사
    INSERT INTO payment_record (member_id, selected_discount_options_id, payment_code, payment_time, total_balance, change_time, deleted)
    SELECT member_id, selected_discount_options_id, payment_code, payment_time, total_balance,
    CURRENT_TIMESTAMP AS change_time, isDeleted as deleted FROM payment WHERE id = payment_id;
    
    SET payment_record_id = LAST_INSERT_ID();

    -- Delivery 복사 (Ticket과 연결된 Delivery)
    INSERT INTO delivery_record (delivery_company, arrival_address, delivery_code)
    SELECT delivery_company, arrival_address, delivery_code FROM delivery 
    WHERE id IN (SELECT delivery_id FROM ticket WHERE payment_id = payment_id);
    
    SET delivery_record_id = LAST_INSERT_ID();
    
    -- Ticket 복사 및 ID 매핑
    DROP TEMPORARY TABLE IF EXISTS ticket_id_mapping;

    CREATE TEMPORARY TABLE ticket_id_mapping (
        old_id BIGINT,
        new_id BIGINT
    );

    -- Ticket 복사 (Payment과 연결된 모든 Ticket)
    INSERT INTO ticket_record (payment_id, concert_date_id, purchase_time, is_online, delivery_id)
    SELECT payment_record_id as payment_id, concert_date_id, purchase_time, is_online,
    delivery_record_id as delivery_id FROM ticket WHERE payment_id = payment_id;
    
    INSERT INTO ticket_id_mapping (old_id, new_id)
    SELECT id AS old_id, LAST_INSERT_ID() + ROW_NUMBER() OVER (ORDER BY id) - 1 AS new_id
    FROM ticket
    WHERE payment_id = payment_id;

    -- Reserved Seat Ticket 복사
    INSERT INTO reserved_seat_ticket_record (id, seat_id)
    SELECT t.new_id AS id, rst.seat_id
    FROM reserved_seat_ticket rst
    JOIN ticket_id_mapping t ON rst.id = t.old_id;

    -- Free Seat Ticket 복사
    INSERT INTO free_seat_ticket_record (id, seat_id)
    SELECT t.new_id AS id, fst.seat_id
    FROM free_seat_ticket fst
    JOIN ticket_id_mapping t ON fst.id = t.old_id;

    DROP TEMPORARY TABLE ticket_id_mapping;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetUserinfoByCredentials` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetUserinfoByCredentials`(
    IN input_username VARCHAR(255),
    IN input_password VARCHAR(255)
)
BEGIN
    -- 선언된 변수
    DECLARE found_salt VARCHAR(255);
    DECLARE found_hash VARCHAR(255);
    DECLARE user_id BIGINT;

    -- 비밀번호와 연관된 정보를 가져옵니다.
    SELECT c.salt, c.hash_value, u.id
    INTO found_salt, found_hash, user_id
    FROM credential c
    INNER JOIN userinfo u ON c.userinfo_id = u.id
    WHERE u.username = input_username;

    -- 비밀번호 비교
    IF found_hash IS NOT NULL AND found_salt IS NOT NULL THEN
        IF saltEncryp(input_password, found_salt, found_hash) = 0 THEN
            -- 일치하는 경우 사용자 정보를 반환
            SELECT u.id 
            FROM userinfo u 
            WHERE u.id = user_id;
        ELSE
            -- 일치하지 않는 경우 빈 결과를 반환
            SELECT NULL AS id LIMIT 0;
        END IF;
    ELSE
        -- 사용자가 없거나 비밀번호가 누락된 경우 빈 결과 반환
        SELECT NULL AS id LIMIT 0;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertUserWithCredentials` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertUserWithCredentials`(
    IN input_username VARCHAR(255),
    IN input_password VARCHAR(255)
)
BEGIN
    -- 선언된 변수
    DECLARE generated_salt VARCHAR(255);
    DECLARE encrypted_password VARCHAR(255);
    DECLARE new_user_id BIGINT;
    
    start transaction;

    -- 1. 무작위 salt 생성
    SET generated_salt = randomStr();

    -- 2. 비밀번호에 salt 추가 및 암호화
    SET encrypted_password = replaceEncryp(CONCAT(input_password, generated_salt));

    -- 3. userinfo 테이블에 username 삽입
    INSERT INTO userinfo (username)
    VALUES (input_username);

    -- 4. 방금 삽입한 사용자의 ID 가져오기
    SET new_user_id = LAST_INSERT_ID();

    -- 5. credential 테이블에 암호화된 비밀번호와 salt 삽입
    INSERT INTO credential (userinfo_id, hash_value, salt)
    VALUES (new_user_id, encrypted_password, generated_salt);
    
    -- 6. Member 테이블에 데이터 삽입
    INSERT INTO Member (id)
    VALUES (new_user_id);
    
    commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ProcessTransactionQueue` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ProcessTransactionQueue`()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_id BIGINT;
    DECLARE v_concert_date_id BIGINT;
    DECLARE v_member_id BIGINT;
    DECLARE v_seat_id BIGINT;
    DECLARE v_seat_grade_id BIGINT;
    DECLARE v_time DATETIME(6);
    DECLARE is_reserved_duplicate INT DEFAULT 0;
    DECLARE free_seat_count INT DEFAULT 0;
    DECLARE free_seat_limit_value INT DEFAULT 0;
    DECLARE process_result TINYINT(1);

    -- 커서 선언
    DECLARE cur CURSOR FOR
    SELECT id, concert_date_id, member_id, seat_id, seat_grade_id, time
    FROM transaction_queue
    ORDER BY time ASC LIMIT 1;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;

    -- 반복 처리
    FETCH cur INTO v_id, v_concert_date_id, v_member_id, v_seat_id, v_seat_grade_id, v_time;

    WHILE done = 0 DO
        -- 트랜잭션 시작
        START TRANSACTION;

        -- **reserved_seat 중복 확인**: 동일한 concert_date_id와 seat_id가 존재하는지
        IF v_seat_id IS NOT NULL THEN
            SET is_reserved_duplicate = (
                SELECT EXISTS (
                    SELECT 1
                    FROM (
                        SELECT n.concert_date_id as concert_date_id, rn.seat_id as seat_id
                        FROM reserved_seat_nonpaid_ticket as rn inner join nonpaid_ticket as n on rn.id = n.id
                        UNION ALL
                        SELECT t.concert_date_id as concert_date_id, r.seat_id as seat_id
                        FROM reserved_seat_ticket as r inner join ticket as t on r.id = t.id
                    ) AS all_reserved
                    WHERE concert_date_id = v_concert_date_id AND seat_id = v_seat_id
                )
            );

            -- 중복이면 데이터 삭제만
            IF is_reserved_duplicate = 1 THEN
                DELETE FROM transaction_queue WHERE id = v_id;
                SET process_result=0;
            ELSE
                -- 데이터 이동
                INSERT INTO nonpaid_ticket (id, is_online, purchase_time, concert_date_id, member_id)
                VALUES (v_id, b'1', v_time, v_concert_date_id, v_member_id);

                INSERT INTO reserved_seat_nonpaid_ticket (id, seat_id)
                VALUES (v_id, v_seat_id);

                DELETE FROM transaction_queue WHERE id = v_id;
                SET process_result=1;
            END IF;

        ELSEIF v_seat_grade_id IS NOT NULL THEN
            -- **free_seat 중복 확인 및 제한 조회**
            SET free_seat_count = (
                SELECT COUNT(*)
                FROM (
                    SELECT n.concert_date_id as concert_date_id, fn.seat_id as seat_grade_id
                    FROM free_seat_nonpaid_ticket as fn inner join nonpaid_ticket as n on fn.id = n.id
                    UNION ALL
                    SELECT t.concert_date_id as concert_date_id, f.seat_id as seat_grade_id
                    FROM free_seat_ticket as f inner join ticket as t on f.id = t.id
                ) AS all_free
                WHERE concert_date_id = v_concert_date_id AND seat_grade_id = v_seat_grade_id
            );

            SET free_seat_limit_value = (
                SELECT value
                FROM free_seat_limit
                WHERE seat_grade_id = v_seat_grade_id
            );

            -- 제한 초과 여부 판단
            IF free_seat_count >= free_seat_limit_value THEN
                -- 제한 초과: 데이터 삭제만
                DELETE FROM transaction_queue WHERE id = v_id;
                SET process_result=0;
            ELSE
                -- 제한 미달: 데이터 이동
                INSERT INTO nonpaid_ticket (id, is_online, purchase_time, concert_date_id, member_id)
                VALUES (v_id, b'1', v_time, v_concert_date_id, v_member_id);

                INSERT INTO free_seat_nonpaid_ticket (id, seat_id)
                VALUES (v_id, v_seat_grade_id);

                DELETE FROM transaction_queue WHERE id = v_id;
                SET process_result=1;
            END IF;
        END IF;

		-- 이력 기록
		INSERT INTO transaction_queue_record (
			id, concert_date_id, member_id, seat_id, seat_grade_id, time, if_succeed
		) VALUES (
			v_id, v_concert_date_id, v_member_id, v_seat_id, v_seat_grade_id, v_time, process_result
		);

        -- 트랜잭션 커밋
        COMMIT;
        
        CLOSE cur;
        OPEN cur;

        -- 다음 데이터 처리
        FETCH cur INTO v_id, v_concert_date_id, v_member_id, v_seat_id, v_seat_grade_id, v_time;
    END WHILE;

    CLOSE cur;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-05 10:16:13
