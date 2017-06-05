-- MySQL dump 10.13  Distrib 5.1.56, for Win32 (ia32)
--
-- Host: localhost    Database: hibernate
-- ------------------------------------------------------
-- Server version	5.1.56-community

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `ID` int(11) NOT NULL,
  `ACC_NO` varchar(100) NOT NULL,
  `employee_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK4bp9gwhcqx8171pvsf3sxgu9p` (`employee_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `ARTICLE_ID` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ARTICLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `CATEGORY_ID` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category_article`
--

DROP TABLE IF EXISTS `category_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_article` (
  `CATEGORY_ID` bigint(20) NOT NULL,
  `ARTICLE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`,`ARTICLE_ID`),
  UNIQUE KEY `UK_jdxe045mtylksx7hikv8442kq` (`ARTICLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contact_number`
--

DROP TABLE IF EXISTS `contact_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_number` (
  `id` int(11) NOT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contractemployee_tableperconcrete`
--

DROP TABLE IF EXISTS `contractemployee_tableperconcrete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contractemployee_tableperconcrete` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `contract_duration` varchar(255) DEFAULT NULL,
  `pay_per_hour` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contractemployee_tablepersubclass`
--

DROP TABLE IF EXISTS `contractemployee_tablepersubclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contractemployee_tablepersubclass` (
  `contract_duration` varchar(255) DEFAULT NULL,
  `pay_per_hour` float DEFAULT NULL,
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
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
-- Table structure for table `edu_course_identity`
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
-- Table structure for table `employee_perhierarchy`
--

DROP TABLE IF EXISTS `employee_perhierarchy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_perhierarchy` (
  `type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `bonus` int(11) DEFAULT NULL,
  `salary` float DEFAULT NULL,
  `contract_duration` varchar(255) DEFAULT NULL,
  `pay_per_hour` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_tableperconcrete`
--

DROP TABLE IF EXISTS `employee_tableperconcrete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_tableperconcrete` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_tablepersubclass`
--

DROP TABLE IF EXISTS `employee_tablepersubclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_tablepersubclass` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employeeorphan`
--

DROP TABLE IF EXISTS `employeeorphan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeeorphan` (
  `ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `discriminator` varchar(31) NOT NULL,
  `PERSON_ID` bigint(20) NOT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  `joining_date` datetime DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhrji42ibifddunolwn59pafwr` (`address_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `regularemployee_tableperconcrete`
--

DROP TABLE IF EXISTS `regularemployee_tableperconcrete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regularemployee_tableperconcrete` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `bonus` int(11) DEFAULT NULL,
  `salary` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `regularemployee_tablepersubclass`
--

DROP TABLE IF EXISTS `regularemployee_tablepersubclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regularemployee_tablepersubclass` (
  `bonus` int(11) DEFAULT NULL,
  `salary` float DEFAULT NULL,
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `STOCK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(10) NOT NULL,
  `STOCK_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`STOCK_ID`),
  UNIQUE KEY `UK_j1y49jqhck84j782fojvrk55w` (`STOCK_CODE`),
  UNIQUE KEY `UK_id2u76pv39wuq1txaomuw9ita` (`STOCK_NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stock_daily_record`
--

DROP TABLE IF EXISTS `stock_daily_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_daily_record` (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` date DEFAULT NULL,
  `PRICE_CHANGE` float DEFAULT NULL,
  `PRICE_CLOSE` float DEFAULT NULL,
  `PRICE_OPEN` float DEFAULT NULL,
  `VOLUME` bigint(20) DEFAULT NULL,
  `STOCK_ID` int(11) NOT NULL,
  PRIMARY KEY (`RECORD_ID`),
  KEY `FKha4n7aajs37dplx0c4dyyjk52` (`STOCK_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-25 16:48:30
