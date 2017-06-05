-- MySQL dump 10.13  Distrib 5.1.56, for Win32 (ia32)
--
-- Host: localhost    Database: hibernate
-- ------------------------------------------------------
-- Server version       5.1.56-community

--Copied only binaries (Not installed MySQL)
--start local mysql server
C:\mysql\mysql-5.1.56-win32\bin> "C:\mysql\mysql-5.1.56-win32\bin\mysqld" --console
--stop local mysql server
C:\mysql\mysql-5.1.56-win32\bin> "C:\mysql\mysql-5.1.56-win32\bin\mysqladmin" -u root shutdown

C:\mysql\mysql-5.1.56-win32\bin>mysql -u root


mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| hibernate          |
| mysql              |
| test               |
+--------------------+
4 rows in set (0.01 sec)

mysql> use hibernate;
Database changed
mysql>

--DDL generation in mysql - C:\mysql\mysql-5.1.56-win32\bin>mysqldump -d -u root -p -h localhost hibernate



/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `edu_course`
--

DROP TABLE IF EXISTS `edu_course_identity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edu_course_identity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `edu_course_generationtype_auto`
--

DROP TABLE IF EXISTS `edu_course_generationtype_auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edu_course_generationtype_auto` (
  `id` int(11) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `edu_course_generationtype_seq`
--

DROP TABLE IF EXISTS `edu_course_generationtype_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edu_course_generationtype_seq` (
  `id` int(11) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course_sequence`
--

DROP TABLE IF EXISTS `course_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Table structure for table `edu_course_generationtype_table`
--

DROP TABLE IF EXISTS `edu_course_generationtype_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edu_course_generationtype_table` (
  `id` int(11) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `educourse_sequence_table`
--

DROP TABLE IF EXISTS `educourse_sequence_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educourse_sequence_table` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `ID` int(11) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `FIRST_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_ardf0f11mfa6tujs3hflthwdv` (`EMAIL`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `identityidentifier`
--

DROP TABLE IF EXISTS `identityidentifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identityidentifier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(100) DEFAULT NULL,
  `CREATED_DATE` date DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
