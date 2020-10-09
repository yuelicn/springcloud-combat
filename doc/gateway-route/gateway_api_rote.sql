-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 47.94.211.209    Database: gateway
-- ------------------------------------------------------
-- Server version	5.7.25

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
-- Table structure for table `gateway_api_route`
--

DROP TABLE IF EXISTS `gateway_api_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gateway_api_route` (
  `id` varchar(50) NOT NULL COMMENT '路由的ID(默认情况下与映射键相同)',
  `path` varchar(255) NOT NULL COMMENT '路径(模式)，例如/foo/**。',
  `service_id` varchar(50) DEFAULT NULL COMMENT '映射到此路由的服务ID(如果有的话)。可以指定物理URL或服务，但不能同时指定两者。',
  `url` varchar(255) DEFAULT NULL COMMENT '要映射到路由的完整物理URL。另一种选择是使用服务ID和服务发现来查找物理地址。',
  `retryable` tinyint(1) DEFAULT NULL COMMENT '标志，指示此路由应该重试(如果支持的话)。一般重试需要一个服务ID和功能区。0:false 1:true',
  `enabled` tinyint(1) NOT NULL,
  `strip_prefix` int(11) DEFAULT NULL COMMENT '标记来确定该路径的前缀是否为该路径(路径，减模式)补丁)应剥离前转发。0:false 1:true',
  `api_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gateway_api_route`
--

LOCK TABLES `gateway_api_route` WRITE;
/*!40000 ALTER TABLE `gateway_api_route` DISABLE KEYS */;
INSERT INTO `gateway_api_route` VALUES ('mall-service','/mall/**','mall-service',NULL,0,1,1,NULL),('order-service','/order/**','order-service',NULL,0,1,1,NULL);
/*!40000 ALTER TABLE `gateway_api_route` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-09  9:44:28
