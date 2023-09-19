-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: normativas
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `conducao_cabos`
--

DROP TABLE IF EXISTS `conducao_cabos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conducao_cabos` (
  `material` text,
  `sessao_nominal` double DEFAULT NULL,
  `instalacao` text,
  `condutores_carregados` int DEFAULT NULL,
  `corrente_nominal` double DEFAULT NULL,
  `isolacao` varchar(10) DEFAULT 'PVC'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conducao_cabos`
--

LOCK TABLES `conducao_cabos` WRITE;
/*!40000 ALTER TABLE `conducao_cabos` DISABLE KEYS */;
INSERT INTO `conducao_cabos` VALUES ('COBRE',0.5,'A1',2,10,'EPR'),('COBRE',0.5,'A1',3,9,'EPR'),('COBRE',0.5,'A2',2,10,'EPR'),('COBRE',0.5,'A2',3,9,'EPR'),('COBRE',0.5,'B1',2,12,'EPR'),('COBRE',0.5,'B1',3,10,'EPR'),('COBRE',0.5,'B2',2,11,'EPR'),('COBRE',0.5,'B2',3,10,'EPR'),('COBRE',0.5,'C',2,12,'EPR'),('COBRE',0.5,'C',3,11,'EPR'),('COBRE',0.5,'D',2,14,'EPR'),('COBRE',0.5,'D',3,12,'EPR'),('COBRE',0.75,'A1',2,12,'EPR'),('COBRE',0.75,'A1',3,11,'EPR'),('COBRE',0.75,'A2',2,12,'EPR'),('COBRE',0.75,'A2',3,11,'EPR'),('COBRE',0.75,'B1',2,15,'EPR'),('COBRE',0.75,'B1',3,13,'EPR'),('COBRE',0.75,'B2',2,15,'EPR'),('COBRE',0.75,'B2',3,13,'EPR'),('COBRE',0.75,'C',2,16,'EPR'),('COBRE',0.75,'C',3,14,'EPR'),('COBRE',0.75,'D',2,18,'EPR'),('COBRE',0.75,'D',3,15,'EPR'),('COBRE',1,'A1',2,15,'EPR'),('COBRE',1,'A1',3,13,'EPR'),('COBRE',1,'A2',2,14,'EPR'),('COBRE',1,'A2',3,13,'EPR'),('COBRE',1,'B1',2,18,'EPR'),('COBRE',1,'B1',3,16,'EPR'),('COBRE',1,'B2',2,17,'EPR'),('COBRE',1,'B2',3,15,'EPR'),('COBRE',1,'C',2,19,'EPR'),('COBRE',1,'C',3,17,'EPR'),('COBRE',1,'D',2,21,'EPR'),('COBRE',1,'D',3,17,'EPR'),('COBRE',1.5,'A1',2,19,'EPR'),('COBRE',1.5,'A1',3,17,'EPR'),('COBRE',1.5,'A2',2,18,'EPR'),('COBRE',1.5,'A2',3,16,'EPR'),('COBRE',1.5,'B1',2,23,'EPR'),('COBRE',1.5,'B1',3,20,'EPR'),('COBRE',1.5,'B2',2,22,'EPR'),('COBRE',1.5,'B2',3,19,'EPR'),('COBRE',1.5,'C',2,24,'EPR'),('COBRE',1.5,'C',3,22,'EPR'),('COBRE',1.5,'D',2,26,'EPR'),('COBRE',1.5,'D',3,22,'EPR'),('COBRE',2.5,'A1',2,26,'EPR'),('COBRE',2.5,'A1',3,23,'EPR'),('COBRE',2.5,'A2',2,25,'EPR'),('COBRE',2.5,'A2',3,22,'EPR'),('COBRE',2.5,'B1',2,31,'EPR'),('COBRE',2.5,'B1',3,28,'EPR'),('COBRE',2.5,'B2',2,30,'EPR'),('COBRE',2.5,'B2',3,26,'EPR'),('COBRE',2.5,'C',2,33,'EPR'),('COBRE',2.5,'C',3,30,'EPR'),('COBRE',2.5,'D',2,34,'EPR'),('COBRE',2.5,'D',3,29,'EPR'),('COBRE',4,'A1',2,35,'EPR'),('COBRE',4,'A1',3,31,'EPR'),('COBRE',4,'A2',2,33,'EPR'),('COBRE',4,'A2',3,30,'EPR'),('COBRE',4,'B1',2,42,'EPR'),('COBRE',4,'B1',3,37,'EPR'),('COBRE',4,'B2',2,40,'EPR'),('COBRE',4,'B2',3,35,'EPR'),('COBRE',4,'C',2,45,'EPR'),('COBRE',4,'C',3,40,'EPR'),('COBRE',4,'D',2,44,'EPR'),('COBRE',4,'D',3,37,'EPR'),('COBRE',6,'A1',2,45,'EPR'),('COBRE',6,'A1',3,40,'EPR'),('COBRE',6,'A2',2,42,'EPR'),('COBRE',6,'A2',3,38,'EPR'),('COBRE',6,'B1',2,54,'EPR'),('COBRE',6,'B1',3,48,'EPR'),('COBRE',6,'B2',2,51,'EPR'),('COBRE',6,'B2',3,44,'EPR'),('COBRE',6,'C',2,58,'EPR'),('COBRE',6,'C',3,52,'EPR'),('COBRE',6,'D',2,56,'EPR'),('COBRE',6,'D',3,46,'EPR'),('COBRE',10,'A1',2,61,'EPR'),('COBRE',10,'A1',3,54,'EPR'),('COBRE',10,'A2',2,57,'EPR'),('COBRE',10,'A2',3,51,'EPR'),('COBRE',10,'B1',2,75,'EPR'),('COBRE',10,'B1',3,66,'EPR'),('COBRE',10,'B2',2,69,'EPR'),('COBRE',10,'B2',3,60,'EPR'),('COBRE',10,'C',2,80,'EPR'),('COBRE',10,'C',3,71,'EPR'),('COBRE',10,'D',2,73,'EPR'),('COBRE',10,'D',3,61,'EPR'),('COBRE',16,'A1',2,81,'EPR'),('COBRE',16,'A1',3,73,'EPR'),('COBRE',16,'A2',2,76,'EPR'),('COBRE',16,'A2',3,68,'EPR'),('COBRE',16,'B1',2,100,'EPR'),('COBRE',16,'B1',3,88,'EPR'),('COBRE',16,'B2',2,91,'EPR'),('COBRE',16,'B2',3,80,'EPR'),('COBRE',16,'C',2,107,'EPR'),('COBRE',16,'C',3,96,'EPR'),('COBRE',16,'D',2,95,'EPR'),('COBRE',16,'D',3,79,'EPR'),('COBRE',25,'A1',2,106,'EPR'),('COBRE',25,'A1',3,95,'EPR'),('COBRE',25,'A2',2,99,'EPR'),('COBRE',25,'A2',3,89,'EPR'),('COBRE',25,'B1',2,133,'EPR'),('COBRE',25,'B1',3,117,'EPR'),('COBRE',25,'B2',2,119,'EPR'),('COBRE',25,'B2',3,105,'EPR'),('COBRE',25,'C',2,138,'EPR'),('COBRE',25,'C',3,119,'EPR'),('COBRE',25,'D',2,121,'EPR'),('COBRE',25,'D',3,101,'EPR'),('COBRE',35,'A1',2,131,'EPR'),('COBRE',35,'A1',3,117,'EPR'),('COBRE',35,'A2',2,121,'EPR'),('COBRE',35,'A2',3,109,'EPR'),('COBRE',35,'B1',2,164,'EPR'),('COBRE',35,'B1',3,144,'EPR'),('COBRE',35,'B2',2,146,'EPR'),('COBRE',35,'B2',3,128,'EPR'),('COBRE',35,'C',2,171,'EPR'),('COBRE',35,'C',3,147,'EPR'),('COBRE',35,'D',2,146,'EPR'),('COBRE',35,'D',3,122,'EPR'),('COBRE',50,'A1',2,158,'EPR'),('COBRE',50,'A1',3,141,'EPR'),('COBRE',50,'A2',2,145,'EPR'),('COBRE',50,'A2',3,130,'EPR'),('COBRE',50,'B1',2,198,'EPR'),('COBRE',50,'B1',3,175,'EPR'),('COBRE',50,'B2',2,175,'EPR'),('COBRE',50,'B2',3,154,'EPR'),('COBRE',50,'C',2,209,'EPR'),('COBRE',50,'C',3,179,'EPR'),('COBRE',50,'D',2,173,'EPR'),('COBRE',50,'D',3,144,'EPR'),('COBRE',70,'A1',2,200,'EPR'),('COBRE',70,'A1',3,179,'EPR'),('COBRE',70,'A2',2,183,'EPR'),('COBRE',70,'A2',3,164,'EPR'),('COBRE',70,'B1',2,253,'EPR'),('COBRE',70,'B1',3,222,'EPR'),('COBRE',70,'B2',2,221,'EPR'),('COBRE',70,'B2',3,194,'EPR'),('COBRE',70,'C',2,269,'EPR'),('COBRE',70,'C',3,229,'EPR'),('COBRE',70,'D',2,213,'EPR'),('COBRE',70,'D',3,178,'EPR'),('COBRE',95,'A1',2,241,'EPR'),('COBRE',95,'A1',3,216,'EPR'),('COBRE',95,'A2',2,220,'EPR'),('COBRE',95,'A2',3,197,'EPR'),('COBRE',95,'B1',2,306,'EPR'),('COBRE',95,'B1',3,269,'EPR'),('COBRE',95,'B2',2,265,'EPR'),('COBRE',95,'B2',3,233,'EPR'),('COBRE',95,'C',2,328,'EPR'),('COBRE',95,'C',3,278,'EPR'),('COBRE',95,'D',2,252,'EPR'),('COBRE',95,'D',3,211,'EPR'),('COBRE',120,'A1',2,278,'EPR'),('COBRE',120,'A1',3,249,'EPR'),('COBRE',120,'A2',2,253,'EPR'),('COBRE',120,'A2',3,227,'EPR'),('COBRE',120,'B1',2,354,'EPR'),('COBRE',120,'B1',3,312,'EPR'),('COBRE',120,'B2',2,305,'EPR'),('COBRE',120,'B2',3,268,'EPR'),('COBRE',120,'C',2,382,'EPR'),('COBRE',120,'C',3,322,'EPR'),('COBRE',120,'D',2,287,'EPR'),('COBRE',120,'D',3,240,'EPR'),('COBRE',150,'A1',2,318,'EPR'),('COBRE',150,'A1',3,285,'EPR'),('COBRE',150,'A2',2,290,'EPR'),('COBRE',150,'A2',3,259,'EPR'),('COBRE',150,'B1',2,407,'EPR'),('COBRE',150,'B1',3,358,'EPR'),('COBRE',150,'B2',2,349,'EPR'),('COBRE',150,'B2',3,307,'EPR'),('COBRE',150,'C',2,441,'EPR'),('COBRE',150,'C',3,371,'EPR'),('COBRE',150,'D',2,324,'EPR'),('COBRE',150,'D',3,271,'EPR'),('COBRE',185,'A1',2,362,'EPR'),('COBRE',185,'A1',3,324,'EPR'),('COBRE',185,'A2',2,329,'EPR'),('COBRE',185,'A2',3,295,'EPR'),('COBRE',185,'B1',2,464,'EPR'),('COBRE',185,'B1',3,408,'EPR'),('COBRE',185,'B2',2,395,'EPR'),('COBRE',185,'B2',3,348,'EPR'),('COBRE',185,'C',2,506,'EPR'),('COBRE',185,'C',3,424,'EPR'),('COBRE',185,'D',2,363,'EPR'),('COBRE',185,'D',3,304,'EPR'),('COBRE',240,'A1',2,424,'EPR'),('COBRE',240,'A1',3,380,'EPR'),('COBRE',240,'A2',2,386,'EPR'),('COBRE',240,'A2',3,346,'EPR'),('COBRE',240,'B1',2,546,'EPR'),('COBRE',240,'B1',3,481,'EPR'),('COBRE',240,'B2',2,462,'EPR'),('COBRE',240,'B2',3,407,'EPR'),('COBRE',240,'C',2,599,'EPR'),('COBRE',240,'C',3,500,'EPR'),('COBRE',240,'D',2,419,'EPR'),('COBRE',240,'D',3,351,'EPR'),('COBRE',300,'A1',2,486,'EPR'),('COBRE',300,'A1',3,435,'EPR'),('COBRE',300,'A2',2,442,'EPR'),('COBRE',300,'A2',3,396,'EPR'),('COBRE',300,'B1',2,628,'EPR'),('COBRE',300,'B1',3,553,'EPR'),('COBRE',300,'B2',2,529,'EPR'),('COBRE',300,'B2',3,465,'EPR'),('COBRE',300,'C',2,693,'EPR'),('COBRE',300,'C',3,576,'EPR'),('COBRE',300,'D',2,474,'EPR'),('COBRE',300,'D',3,396,'EPR'),('COBRE',400,'A1',2,579,'EPR'),('COBRE',400,'A1',3,519,'EPR'),('COBRE',400,'A2',2,527,'EPR'),('COBRE',400,'A2',3,472,'EPR'),('COBRE',400,'B1',2,751,'EPR'),('COBRE',400,'B1',3,661,'EPR'),('COBRE',400,'B2',2,628,'EPR'),('COBRE',400,'B2',3,552,'EPR'),('COBRE',400,'C',2,835,'EPR'),('COBRE',400,'C',3,692,'EPR'),('COBRE',400,'D',2,555,'EPR'),('COBRE',400,'D',3,464,'EPR'),('COBRE',500,'A1',2,664,'EPR'),('COBRE',500,'A1',3,595,'EPR'),('COBRE',500,'A2',2,604,'EPR'),('COBRE',500,'A2',3,541,'EPR'),('COBRE',500,'B1',2,864,'EPR'),('COBRE',500,'B1',3,760,'EPR'),('COBRE',500,'B2',2,718,'EPR'),('COBRE',500,'B2',3,631,'EPR'),('COBRE',500,'C',2,966,'EPR'),('COBRE',500,'C',3,797,'EPR'),('COBRE',500,'D',2,627,'EPR'),('COBRE',500,'D',3,525,'EPR'),('COBRE',630,'A1',2,765,'EPR'),('COBRE',630,'A1',3,685,'EPR'),('COBRE',630,'A2',2,696,'EPR'),('COBRE',630,'A2',3,623,'EPR'),('COBRE',630,'B1',2,998,'EPR'),('COBRE',630,'B1',3,879,'EPR'),('COBRE',630,'B2',2,825,'EPR'),('COBRE',630,'B2',3,725,'EPR'),('COBRE',630,'C',2,1122,'EPR'),('COBRE',630,'C',3,923,'EPR'),('COBRE',630,'D',2,711,'EPR'),('COBRE',630,'D',3,596,'EPR'),('COBRE',800,'A1',2,885,'EPR'),('COBRE',800,'A1',3,792,'EPR'),('COBRE',800,'A2',2,805,'EPR'),('COBRE',800,'A2',3,721,'EPR'),('COBRE',800,'B1',2,1158,'EPR'),('COBRE',800,'B1',3,1020,'EPR'),('COBRE',800,'B2',2,952,'EPR'),('COBRE',800,'B2',3,837,'EPR'),('COBRE',800,'C',2,1311,'EPR'),('COBRE',800,'C',3,1074,'EPR'),('COBRE',800,'D',2,811,'EPR'),('COBRE',800,'D',3,679,'EPR'),('COBRE',1000,'A1',2,1014,'EPR'),('COBRE',1000,'A1',3,908,'EPR'),('COBRE',1000,'A2',2,923,'EPR'),('COBRE',1000,'A2',3,826,'EPR'),('COBRE',1000,'B1',2,1332,'EPR'),('COBRE',1000,'B1',3,1173,'EPR'),('COBRE',1000,'B2',2,1088,'EPR'),('COBRE',1000,'B2',3,957,'EPR'),('COBRE',1000,'C',2,1515,'EPR'),('COBRE',1000,'C',3,1237,'EPR'),('COBRE',1000,'D',2,916,'EPR'),('COBRE',1000,'D',3,767,'EPR'),('ALUMINIO',16,'A1',2,64,'EPR'),('ALUMINIO',16,'A1',3,58,'EPR'),('ALUMINIO',16,'A2',2,60,'EPR'),('ALUMINIO',16,'A2',3,55,'EPR'),('ALUMINIO',16,'B1',2,79,'EPR'),('ALUMINIO',16,'B1',3,71,'EPR'),('ALUMINIO',16,'B2',2,72,'EPR'),('ALUMINIO',16,'B2',3,64,'EPR'),('ALUMINIO',16,'C',2,84,'EPR'),('ALUMINIO',16,'C',3,76,'EPR'),('ALUMINIO',16,'D',2,73,'EPR'),('ALUMINIO',16,'D',3,61,'EPR'),('ALUMINIO',25,'A1',2,84,'EPR'),('ALUMINIO',25,'A1',3,76,'EPR'),('ALUMINIO',25,'A2',2,78,'EPR'),('ALUMINIO',25,'A2',3,71,'EPR'),('ALUMINIO',25,'B1',2,105,'EPR'),('ALUMINIO',25,'B1',3,93,'EPR'),('ALUMINIO',25,'B2',2,94,'EPR'),('ALUMINIO',25,'B2',3,84,'EPR'),('ALUMINIO',25,'C',2,101,'EPR'),('ALUMINIO',25,'C',3,90,'EPR'),('ALUMINIO',25,'D',2,93,'EPR'),('ALUMINIO',25,'D',3,78,'EPR'),('ALUMINIO',35,'A1',2,103,'EPR'),('ALUMINIO',35,'A1',3,94,'EPR'),('ALUMINIO',35,'A2',2,96,'EPR'),('ALUMINIO',35,'A2',3,87,'EPR'),('ALUMINIO',35,'B1',2,130,'EPR'),('ALUMINIO',35,'B1',3,116,'EPR'),('ALUMINIO',35,'B2',2,115,'EPR'),('ALUMINIO',35,'B2',3,103,'EPR'),('ALUMINIO',35,'C',2,126,'EPR'),('ALUMINIO',35,'C',3,112,'EPR'),('ALUMINIO',35,'D',2,112,'EPR'),('ALUMINIO',35,'D',3,94,'EPR'),('ALUMINIO',50,'A1',2,125,'EPR'),('ALUMINIO',50,'A1',3,113,'EPR'),('ALUMINIO',50,'A2',2,115,'EPR'),('ALUMINIO',50,'A2',3,104,'EPR'),('ALUMINIO',50,'B1',2,157,'EPR'),('ALUMINIO',50,'B1',3,140,'EPR'),('ALUMINIO',50,'B2',2,138,'EPR'),('ALUMINIO',50,'B2',3,124,'EPR'),('ALUMINIO',50,'C',2,154,'EPR'),('ALUMINIO',50,'C',3,136,'EPR'),('ALUMINIO',50,'D',2,132,'EPR'),('ALUMINIO',50,'D',3,112,'EPR'),('ALUMINIO',70,'A1',2,158,'EPR'),('ALUMINIO',70,'A1',3,142,'EPR'),('ALUMINIO',70,'A2',2,145,'EPR'),('ALUMINIO',70,'A2',3,131,'EPR'),('ALUMINIO',70,'B1',2,200,'EPR'),('ALUMINIO',70,'B1',3,179,'EPR'),('ALUMINIO',70,'B2',2,175,'EPR'),('ALUMINIO',70,'B2',3,156,'EPR'),('ALUMINIO',70,'C',2,198,'EPR'),('ALUMINIO',70,'C',3,174,'EPR'),('ALUMINIO',70,'D',2,163,'EPR'),('ALUMINIO',70,'D',3,138,'EPR'),('ALUMINIO',95,'A1',2,191,'EPR'),('ALUMINIO',95,'A1',3,171,'EPR'),('ALUMINIO',95,'A2',2,175,'EPR'),('ALUMINIO',95,'A2',3,157,'EPR'),('ALUMINIO',95,'B1',2,242,'EPR'),('ALUMINIO',95,'B1',3,217,'EPR'),('ALUMINIO',95,'B2',2,210,'EPR'),('ALUMINIO',95,'B2',3,188,'EPR'),('ALUMINIO',95,'C',2,241,'EPR'),('ALUMINIO',95,'C',3,211,'EPR'),('ALUMINIO',95,'D',2,193,'EPR'),('ALUMINIO',95,'D',3,164,'EPR'),('ALUMINIO',120,'A1',2,220,'EPR'),('ALUMINIO',120,'A1',3,197,'EPR'),('ALUMINIO',120,'A2',2,201,'EPR'),('ALUMINIO',120,'A2',3,180,'EPR'),('ALUMINIO',120,'B1',2,281,'EPR'),('ALUMINIO',120,'B1',3,251,'EPR'),('ALUMINIO',120,'B2',2,242,'EPR'),('ALUMINIO',120,'B2',3,216,'EPR'),('ALUMINIO',120,'C',2,280,'EPR'),('ALUMINIO',120,'C',3,245,'EPR'),('ALUMINIO',120,'D',2,220,'EPR'),('ALUMINIO',120,'D',3,186,'EPR'),('ALUMINIO',150,'A1',2,253,'EPR'),('ALUMINIO',150,'A1',3,226,'EPR'),('ALUMINIO',150,'A2',2,230,'EPR'),('ALUMINIO',150,'A2',3,206,'EPR'),('ALUMINIO',150,'B1',2,323,'EPR'),('ALUMINIO',150,'B1',3,289,'EPR'),('ALUMINIO',150,'B2',2,277,'EPR'),('ALUMINIO',150,'B2',3,248,'EPR'),('ALUMINIO',150,'C',2,324,'EPR'),('ALUMINIO',150,'C',3,283,'EPR'),('ALUMINIO',150,'D',2,249,'EPR'),('ALUMINIO',150,'D',3,210,'EPR'),('ALUMINIO',185,'A1',2,288,'EPR'),('ALUMINIO',185,'A1',3,256,'EPR'),('ALUMINIO',185,'A2',2,262,'EPR'),('ALUMINIO',185,'A2',3,233,'EPR'),('ALUMINIO',185,'B1',2,368,'EPR'),('ALUMINIO',185,'B1',3,330,'EPR'),('ALUMINIO',185,'B2',2,314,'EPR'),('ALUMINIO',185,'B2',3,281,'EPR'),('ALUMINIO',185,'C',2,371,'EPR'),('ALUMINIO',185,'C',3,323,'EPR'),('ALUMINIO',185,'D',2,279,'EPR'),('ALUMINIO',185,'D',3,236,'EPR'),('ALUMINIO',240,'A1',2,338,'EPR'),('ALUMINIO',240,'A1',3,300,'EPR'),('ALUMINIO',240,'A2',2,307,'EPR'),('ALUMINIO',240,'A2',3,273,'EPR'),('ALUMINIO',240,'B1',2,433,'EPR'),('ALUMINIO',240,'B1',3,389,'EPR'),('ALUMINIO',240,'B2',2,368,'EPR'),('ALUMINIO',240,'B2',3,329,'EPR'),('ALUMINIO',240,'C',2,439,'EPR'),('ALUMINIO',240,'C',3,382,'EPR'),('ALUMINIO',240,'D',2,322,'EPR'),('ALUMINIO',240,'D',3,272,'EPR'),('ALUMINIO',300,'A1',2,387,'EPR'),('ALUMINIO',300,'A1',3,344,'EPR'),('ALUMINIO',300,'A2',2,352,'EPR'),('ALUMINIO',300,'A2',3,313,'EPR'),('ALUMINIO',300,'B1',2,499,'EPR'),('ALUMINIO',300,'B1',3,447,'EPR'),('ALUMINIO',300,'B2',2,421,'EPR'),('ALUMINIO',300,'B2',3,377,'EPR'),('ALUMINIO',300,'C',2,508,'EPR'),('ALUMINIO',300,'C',3,440,'EPR'),('ALUMINIO',300,'D',2,364,'EPR'),('ALUMINIO',300,'D',3,308,'EPR'),('ALUMINIO',400,'A1',2,462,'EPR'),('ALUMINIO',400,'A1',3,409,'EPR'),('ALUMINIO',400,'A2',2,421,'EPR'),('ALUMINIO',400,'A2',3,372,'EPR'),('ALUMINIO',400,'B1',2,597,'EPR'),('ALUMINIO',400,'B1',3,536,'EPR'),('ALUMINIO',400,'B2',2,500,'EPR'),('ALUMINIO',400,'B2',3,448,'EPR'),('ALUMINIO',400,'C',2,612,'EPR'),('ALUMINIO',400,'C',3,529,'EPR'),('ALUMINIO',400,'D',2,426,'EPR'),('ALUMINIO',400,'D',3,361,'EPR'),('ALUMINIO',500,'A1',2,530,'EPR'),('ALUMINIO',500,'A1',3,468,'EPR'),('ALUMINIO',500,'A2',2,483,'EPR'),('ALUMINIO',500,'A2',3,426,'EPR'),('ALUMINIO',500,'B1',2,687,'EPR'),('ALUMINIO',500,'B1',3,617,'EPR'),('ALUMINIO',500,'B2',2,573,'EPR'),('ALUMINIO',500,'B2',3,513,'EPR'),('ALUMINIO',500,'C',2,707,'EPR'),('ALUMINIO',500,'C',3,610,'EPR'),('ALUMINIO',500,'D',2,482,'EPR'),('ALUMINIO',500,'D',3,408,'EPR'),('ALUMINIO',630,'A1',2,611,'EPR'),('ALUMINIO',630,'A1',3,538,'EPR'),('ALUMINIO',630,'A2',2,556,'EPR'),('ALUMINIO',630,'A2',3,490,'EPR'),('ALUMINIO',630,'B1',2,794,'EPR'),('ALUMINIO',630,'B1',3,714,'EPR'),('ALUMINIO',630,'B2',2,658,'EPR'),('ALUMINIO',630,'B2',3,590,'EPR'),('ALUMINIO',630,'C',2,821,'EPR'),('ALUMINIO',630,'C',3,707,'EPR'),('ALUMINIO',630,'D',2,547,'EPR'),('ALUMINIO',630,'D',3,464,'EPR'),('ALUMINIO',800,'A1',2,708,'EPR'),('ALUMINIO',800,'A1',3,622,'EPR'),('ALUMINIO',800,'A2',2,644,'EPR'),('ALUMINIO',800,'A2',3,566,'EPR'),('ALUMINIO',800,'B1',2,922,'EPR'),('ALUMINIO',800,'B1',3,830,'EPR'),('ALUMINIO',800,'B2',2,760,'EPR'),('ALUMINIO',800,'B2',3,682,'EPR'),('ALUMINIO',800,'C',2,958,'EPR'),('ALUMINIO',800,'C',3,824,'EPR'),('ALUMINIO',800,'D',2,624,'EPR'),('ALUMINIO',800,'D',3,529,'EPR'),('ALUMINIO',1000,'A1',2,812,'EPR'),('ALUMINIO',1000,'A1',3,712,'EPR'),('ALUMINIO',1000,'A2',2,739,'EPR'),('ALUMINIO',1000,'A2',3,648,'EPR'),('ALUMINIO',1000,'B1',2,1061,'EPR'),('ALUMINIO',1000,'B1',3,955,'EPR'),('ALUMINIO',1000,'B2',2,870,'EPR'),('ALUMINIO',1000,'B2',3,780,'EPR'),('ALUMINIO',1000,'C',2,1108,'EPR'),('ALUMINIO',1000,'C',3,950,'EPR'),('ALUMINIO',1000,'D',2,706,'EPR'),('ALUMINIO',1000,'D',3,598,'EPR'),('COBRE',0.5,'A1',2,7,'PVC'),('COBRE',0.5,'A1',3,7,'PVC'),('COBRE',0.5,'A2',2,7,'PVC'),('COBRE',0.5,'A2',3,7,'PVC'),('COBRE',0.5,'B1',2,9,'PVC'),('COBRE',0.5,'B1',3,8,'PVC'),('COBRE',0.5,'B2',2,9,'PVC'),('COBRE',0.5,'B2',3,8,'PVC'),('COBRE',0.5,'C',2,10,'PVC'),('COBRE',0.5,'C',3,9,'PVC'),('COBRE',0.5,'D',2,12,'PVC'),('COBRE',0.5,'D',3,10,'PVC'),('COBRE',0.75,'A1',2,9,'PVC'),('COBRE',0.75,'A1',3,9,'PVC'),('COBRE',0.75,'A2',2,9,'PVC'),('COBRE',0.75,'A2',3,9,'PVC'),('COBRE',0.75,'B1',2,11,'PVC'),('COBRE',0.75,'B1',3,10,'PVC'),('COBRE',0.75,'B2',2,11,'PVC'),('COBRE',0.75,'B2',3,10,'PVC'),('COBRE',0.75,'C',2,13,'PVC'),('COBRE',0.75,'C',3,11,'PVC'),('COBRE',0.75,'D',2,15,'PVC'),('COBRE',0.75,'D',3,12,'PVC'),('COBRE',1,'A1',2,11,'PVC'),('COBRE',1,'A1',3,10,'PVC'),('COBRE',1,'A2',2,11,'PVC'),('COBRE',1,'A2',3,10,'PVC'),('COBRE',1,'B1',2,14,'PVC'),('COBRE',1,'B1',3,12,'PVC'),('COBRE',1,'B2',2,13,'PVC'),('COBRE',1,'B2',3,12,'PVC'),('COBRE',1,'C',2,15,'PVC'),('COBRE',1,'C',3,14,'PVC'),('COBRE',1,'D',2,18,'PVC'),('COBRE',1,'D',3,15,'PVC'),('COBRE',1.5,'A1',2,14.5,'PVC'),('COBRE',1.5,'A1',3,13.5,'PVC'),('COBRE',1.5,'A2',2,14,'PVC'),('COBRE',1.5,'A2',3,13,'PVC'),('COBRE',1.5,'B1',2,17.5,'PVC'),('COBRE',1.5,'B1',3,15.5,'PVC'),('COBRE',1.5,'B2',2,16.5,'PVC'),('COBRE',1.5,'B2',3,15,'PVC'),('COBRE',1.5,'C',2,19.5,'PVC'),('COBRE',1.5,'C',3,17.5,'PVC'),('COBRE',1.5,'D',2,22,'PVC'),('COBRE',1.5,'D',3,18,'PVC'),('COBRE',2.5,'A1',2,19.5,'PVC'),('COBRE',2.5,'A1',3,18,'PVC'),('COBRE',2.5,'A2',2,18.5,'PVC'),('COBRE',2.5,'A2',3,17.5,'PVC'),('COBRE',2.5,'B1',2,24,'PVC'),('COBRE',2.5,'B1',3,21,'PVC'),('COBRE',2.5,'B2',2,23,'PVC'),('COBRE',2.5,'B2',3,20,'PVC'),('COBRE',2.5,'C',2,27,'PVC'),('COBRE',2.5,'C',3,24,'PVC'),('COBRE',2.5,'D',2,29,'PVC'),('COBRE',2.5,'D',3,24,'PVC'),('COBRE',4,'A1',2,26,'PVC'),('COBRE',4,'A1',3,24,'PVC'),('COBRE',4,'A2',2,25,'PVC'),('COBRE',4,'A2',3,23,'PVC'),('COBRE',4,'B1',2,32,'PVC'),('COBRE',4,'B1',3,28,'PVC'),('COBRE',4,'B2',2,30,'PVC'),('COBRE',4,'B2',3,27,'PVC'),('COBRE',4,'C',2,36,'PVC'),('COBRE',4,'C',3,32,'PVC'),('COBRE',4,'D',2,38,'PVC'),('COBRE',4,'D',3,31,'PVC'),('COBRE',6,'A1',2,34,'PVC'),('COBRE',6,'A1',3,31,'PVC'),('COBRE',6,'A2',2,32,'PVC'),('COBRE',6,'A2',3,29,'PVC'),('COBRE',6,'B1',2,41,'PVC'),('COBRE',6,'B1',3,36,'PVC'),('COBRE',6,'B2',2,38,'PVC'),('COBRE',6,'B2',3,34,'PVC'),('COBRE',6,'C',2,46,'PVC'),('COBRE',6,'C',3,41,'PVC'),('COBRE',6,'D',2,47,'PVC'),('COBRE',6,'D',3,39,'PVC'),('COBRE',10,'A1',2,46,'PVC'),('COBRE',10,'A1',3,42,'PVC'),('COBRE',10,'A2',2,43,'PVC'),('COBRE',10,'A2',3,39,'PVC'),('COBRE',10,'B1',2,57,'PVC'),('COBRE',10,'B1',3,50,'PVC'),('COBRE',10,'B2',2,52,'PVC'),('COBRE',10,'B2',3,46,'PVC'),('COBRE',10,'C',2,63,'PVC'),('COBRE',10,'C',3,57,'PVC'),('COBRE',10,'D',2,63,'PVC'),('COBRE',10,'D',3,52,'PVC'),('COBRE',16,'A1',2,61,'PVC'),('COBRE',16,'A1',3,56,'PVC'),('COBRE',16,'A2',2,57,'PVC'),('COBRE',16,'A2',3,52,'PVC'),('COBRE',16,'B1',2,76,'PVC'),('COBRE',16,'B1',3,68,'PVC'),('COBRE',16,'B2',2,69,'PVC'),('COBRE',16,'B2',3,62,'PVC'),('COBRE',16,'C',2,85,'PVC'),('COBRE',16,'C',3,76,'PVC'),('COBRE',16,'D',2,81,'PVC'),('COBRE',16,'D',3,67,'PVC'),('COBRE',25,'A1',2,80,'PVC'),('COBRE',25,'A1',3,73,'PVC'),('COBRE',25,'A2',2,75,'PVC'),('COBRE',25,'A2',3,68,'PVC'),('COBRE',25,'B1',2,101,'PVC'),('COBRE',25,'B1',3,89,'PVC'),('COBRE',25,'B2',2,90,'PVC'),('COBRE',25,'B2',3,80,'PVC'),('COBRE',25,'C',2,112,'PVC'),('COBRE',25,'C',3,96,'PVC'),('COBRE',25,'D',2,104,'PVC'),('COBRE',25,'D',3,86,'PVC'),('COBRE',35,'A1',2,99,'PVC'),('COBRE',35,'A1',3,89,'PVC'),('COBRE',35,'A2',2,92,'PVC'),('COBRE',35,'A2',3,83,'PVC'),('COBRE',35,'B1',2,125,'PVC'),('COBRE',35,'B1',3,110,'PVC'),('COBRE',35,'B2',2,111,'PVC'),('COBRE',35,'B2',3,99,'PVC'),('COBRE',35,'C',2,138,'PVC'),('COBRE',35,'C',3,119,'PVC'),('COBRE',35,'D',2,125,'PVC'),('COBRE',35,'D',3,103,'PVC'),('COBRE',50,'A1',2,119,'PVC'),('COBRE',50,'A1',3,108,'PVC'),('COBRE',50,'A2',2,110,'PVC'),('COBRE',50,'A2',3,99,'PVC'),('COBRE',50,'B1',2,151,'PVC'),('COBRE',50,'B1',3,134,'PVC'),('COBRE',50,'B2',2,133,'PVC'),('COBRE',50,'B2',3,118,'PVC'),('COBRE',50,'C',2,168,'PVC'),('COBRE',50,'C',3,144,'PVC'),('COBRE',50,'D',2,148,'PVC'),('COBRE',50,'D',3,122,'PVC'),('COBRE',70,'A1',2,151,'PVC'),('COBRE',70,'A1',3,136,'PVC'),('COBRE',70,'A2',2,139,'PVC'),('COBRE',70,'A2',3,125,'PVC'),('COBRE',70,'B1',2,192,'PVC'),('COBRE',70,'B1',3,171,'PVC'),('COBRE',70,'B2',2,168,'PVC'),('COBRE',70,'B2',3,149,'PVC'),('COBRE',70,'C',2,213,'PVC'),('COBRE',70,'C',3,184,'PVC'),('COBRE',70,'D',2,183,'PVC'),('COBRE',70,'D',3,151,'PVC'),('COBRE',95,'A1',2,182,'PVC'),('COBRE',95,'A1',3,164,'PVC'),('COBRE',95,'A2',2,167,'PVC'),('COBRE',95,'A2',3,150,'PVC'),('COBRE',95,'B1',2,232,'PVC'),('COBRE',95,'B1',3,207,'PVC'),('COBRE',95,'B2',2,201,'PVC'),('COBRE',95,'B2',3,179,'PVC'),('COBRE',95,'C',2,258,'PVC'),('COBRE',95,'C',3,223,'PVC'),('COBRE',95,'D',2,216,'PVC'),('COBRE',95,'D',3,179,'PVC'),('COBRE',120,'A1',2,210,'PVC'),('COBRE',120,'A1',3,188,'PVC'),('COBRE',120,'A2',2,192,'PVC'),('COBRE',120,'A2',3,172,'PVC'),('COBRE',120,'B1',2,269,'PVC'),('COBRE',120,'B1',3,239,'PVC'),('COBRE',120,'B2',2,232,'PVC'),('COBRE',120,'B2',3,206,'PVC'),('COBRE',120,'C',2,299,'PVC'),('COBRE',120,'C',3,259,'PVC'),('COBRE',120,'D',2,246,'PVC'),('COBRE',120,'D',3,203,'PVC'),('COBRE',150,'A1',2,240,'PVC'),('COBRE',150,'A1',3,216,'PVC'),('COBRE',150,'A2',2,219,'PVC'),('COBRE',150,'A2',3,196,'PVC'),('COBRE',150,'B1',2,309,'PVC'),('COBRE',150,'B1',3,275,'PVC'),('COBRE',150,'B2',2,265,'PVC'),('COBRE',150,'B2',3,236,'PVC'),('COBRE',150,'C',2,344,'PVC'),('COBRE',150,'C',3,299,'PVC'),('COBRE',150,'D',2,278,'PVC'),('COBRE',150,'D',3,230,'PVC'),('COBRE',185,'A1',2,273,'PVC'),('COBRE',185,'A1',3,245,'PVC'),('COBRE',185,'A2',2,248,'PVC'),('COBRE',185,'A2',3,223,'PVC'),('COBRE',185,'B1',2,353,'PVC'),('COBRE',185,'B1',3,314,'PVC'),('COBRE',185,'B2',2,300,'PVC'),('COBRE',185,'B2',3,268,'PVC'),('COBRE',185,'C',2,392,'PVC'),('COBRE',185,'C',3,341,'PVC'),('COBRE',185,'D',2,312,'PVC'),('COBRE',185,'D',3,258,'PVC'),('COBRE',240,'A1',2,321,'PVC'),('COBRE',240,'A1',3,286,'PVC'),('COBRE',240,'A2',2,291,'PVC'),('COBRE',240,'A2',3,261,'PVC'),('COBRE',240,'B1',2,415,'PVC'),('COBRE',240,'B1',3,370,'PVC'),('COBRE',240,'B2',2,351,'PVC'),('COBRE',240,'B2',3,313,'PVC'),('COBRE',240,'C',2,461,'PVC'),('COBRE',240,'C',3,403,'PVC'),('COBRE',240,'D',2,361,'PVC'),('COBRE',240,'D',3,297,'PVC'),('COBRE',300,'A1',2,367,'PVC'),('COBRE',300,'A1',3,328,'PVC'),('COBRE',300,'A2',2,334,'PVC'),('COBRE',300,'A2',3,298,'PVC'),('COBRE',300,'B1',2,477,'PVC'),('COBRE',300,'B1',3,426,'PVC'),('COBRE',300,'B2',2,401,'PVC'),('COBRE',300,'B2',3,358,'PVC'),('COBRE',300,'C',2,530,'PVC'),('COBRE',300,'C',3,464,'PVC'),('COBRE',300,'D',2,408,'PVC'),('COBRE',300,'D',3,336,'PVC'),('COBRE',400,'A1',2,438,'PVC'),('COBRE',400,'A1',3,390,'PVC'),('COBRE',400,'A2',2,398,'PVC'),('COBRE',400,'A2',3,355,'PVC'),('COBRE',400,'B1',2,571,'PVC'),('COBRE',400,'B1',3,510,'PVC'),('COBRE',400,'B2',2,477,'PVC'),('COBRE',400,'B2',3,425,'PVC'),('COBRE',400,'C',2,634,'PVC'),('COBRE',400,'C',3,557,'PVC'),('COBRE',400,'D',2,478,'PVC'),('COBRE',400,'D',3,394,'PVC'),('COBRE',500,'A1',2,502,'PVC'),('COBRE',500,'A1',3,447,'PVC'),('COBRE',500,'A2',2,456,'PVC'),('COBRE',500,'A2',3,406,'PVC'),('COBRE',500,'B1',2,656,'PVC'),('COBRE',500,'B1',3,587,'PVC'),('COBRE',500,'B2',2,545,'PVC'),('COBRE',500,'B2',3,486,'PVC'),('COBRE',500,'C',2,729,'PVC'),('COBRE',500,'C',3,642,'PVC'),('COBRE',500,'D',2,540,'PVC'),('COBRE',500,'D',3,445,'PVC'),('COBRE',630,'A1',2,578,'PVC'),('COBRE',630,'A1',3,514,'PVC'),('COBRE',630,'A2',2,526,'PVC'),('COBRE',630,'A2',3,467,'PVC'),('COBRE',630,'B1',2,758,'PVC'),('COBRE',630,'B1',3,678,'PVC'),('COBRE',630,'B2',2,626,'PVC'),('COBRE',630,'B2',3,559,'PVC'),('COBRE',630,'C',2,843,'PVC'),('COBRE',630,'C',3,743,'PVC'),('COBRE',630,'D',2,614,'PVC'),('COBRE',630,'D',3,506,'PVC'),('COBRE',800,'A1',2,669,'PVC'),('COBRE',800,'A1',3,593,'PVC'),('COBRE',800,'A2',2,609,'PVC'),('COBRE',800,'A2',3,540,'PVC'),('COBRE',800,'B1',2,881,'PVC'),('COBRE',800,'B1',3,788,'PVC'),('COBRE',800,'B2',2,723,'PVC'),('COBRE',800,'B2',3,645,'PVC'),('COBRE',800,'C',2,978,'PVC'),('COBRE',800,'C',3,865,'PVC'),('COBRE',800,'D',2,700,'PVC'),('COBRE',800,'D',3,577,'PVC'),('COBRE',1000,'A1',2,767,'PVC'),('COBRE',1000,'A1',3,679,'PVC'),('COBRE',1000,'A2',2,698,'PVC'),('COBRE',1000,'A2',3,618,'PVC'),('COBRE',1000,'B1',2,1012,'PVC'),('COBRE',1000,'B1',3,906,'PVC'),('COBRE',1000,'B2',2,827,'PVC'),('COBRE',1000,'B2',3,738,'PVC'),('COBRE',1000,'C',2,1125,'PVC'),('COBRE',1000,'C',3,996,'PVC'),('COBRE',1000,'D',2,792,'PVC'),('COBRE',1000,'D',3,652,'PVC'),('ALUMINIO',16,'A1',2,48,'PVC'),('ALUMINIO',16,'A1',3,43,'PVC'),('ALUMINIO',16,'A2',2,44,'PVC'),('ALUMINIO',16,'A2',3,41,'PVC'),('ALUMINIO',16,'B1',2,60,'PVC'),('ALUMINIO',16,'B1',3,53,'PVC'),('ALUMINIO',16,'B2',2,54,'PVC'),('ALUMINIO',16,'B2',3,48,'PVC'),('ALUMINIO',16,'C',2,66,'PVC'),('ALUMINIO',16,'C',3,59,'PVC'),('ALUMINIO',16,'D',2,62,'PVC'),('ALUMINIO',16,'D',2,52,'PVC'),('ALUMINIO',25,'A1',2,63,'PVC'),('ALUMINIO',25,'A1',3,57,'PVC'),('ALUMINIO',25,'A2',2,58,'PVC'),('ALUMINIO',25,'A2',3,53,'PVC'),('ALUMINIO',25,'B1',2,79,'PVC'),('ALUMINIO',25,'B1',3,70,'PVC'),('ALUMINIO',25,'B2',2,71,'PVC'),('ALUMINIO',25,'B2',3,62,'PVC'),('ALUMINIO',25,'C',2,83,'PVC'),('ALUMINIO',25,'C',3,73,'PVC'),('ALUMINIO',25,'D',2,80,'PVC'),('ALUMINIO',25,'D',2,66,'PVC'),('ALUMINIO',35,'A1',2,77,'PVC'),('ALUMINIO',35,'A1',3,70,'PVC'),('ALUMINIO',35,'A2',2,71,'PVC'),('ALUMINIO',35,'A2',3,65,'PVC'),('ALUMINIO',35,'B1',2,97,'PVC'),('ALUMINIO',35,'B1',3,86,'PVC'),('ALUMINIO',35,'B2',2,86,'PVC'),('ALUMINIO',35,'B2',3,77,'PVC'),('ALUMINIO',35,'C',2,103,'PVC'),('ALUMINIO',35,'C',3,90,'PVC'),('ALUMINIO',35,'D',2,96,'PVC'),('ALUMINIO',35,'D',2,80,'PVC'),('ALUMINIO',50,'A1',2,93,'PVC'),('ALUMINIO',50,'A1',3,84,'PVC'),('ALUMINIO',50,'A2',2,86,'PVC'),('ALUMINIO',50,'A2',3,78,'PVC'),('ALUMINIO',50,'B1',2,118,'PVC'),('ALUMINIO',50,'B1',3,104,'PVC'),('ALUMINIO',50,'B2',2,104,'PVC'),('ALUMINIO',50,'B2',3,92,'PVC'),('ALUMINIO',50,'C',2,125,'PVC'),('ALUMINIO',50,'C',3,110,'PVC'),('ALUMINIO',50,'D',2,113,'PVC'),('ALUMINIO',50,'D',2,94,'PVC'),('ALUMINIO',70,'A1',2,118,'PVC'),('ALUMINIO',70,'A1',3,107,'PVC'),('ALUMINIO',70,'A2',2,108,'PVC'),('ALUMINIO',70,'A2',3,98,'PVC'),('ALUMINIO',70,'B1',2,150,'PVC'),('ALUMINIO',70,'B1',3,133,'PVC'),('ALUMINIO',70,'B2',2,131,'PVC'),('ALUMINIO',70,'B2',3,116,'PVC'),('ALUMINIO',70,'C',2,160,'PVC'),('ALUMINIO',70,'C',3,140,'PVC'),('ALUMINIO',70,'D',2,140,'PVC'),('ALUMINIO',70,'D',2,117,'PVC'),('ALUMINIO',95,'A1',2,142,'PVC'),('ALUMINIO',95,'A1',3,129,'PVC'),('ALUMINIO',95,'A2',2,130,'PVC'),('ALUMINIO',95,'A2',3,118,'PVC'),('ALUMINIO',95,'B1',2,181,'PVC'),('ALUMINIO',95,'B1',3,161,'PVC'),('ALUMINIO',95,'B2',2,157,'PVC'),('ALUMINIO',95,'B2',3,139,'PVC'),('ALUMINIO',95,'C',2,195,'PVC'),('ALUMINIO',95,'C',3,170,'PVC'),('ALUMINIO',95,'D',2,166,'PVC'),('ALUMINIO',95,'D',2,138,'PVC'),('ALUMINIO',120,'A1',2,164,'PVC'),('ALUMINIO',120,'A1',3,149,'PVC'),('ALUMINIO',120,'A2',2,150,'PVC'),('ALUMINIO',120,'A2',3,135,'PVC'),('ALUMINIO',120,'B1',2,210,'PVC'),('ALUMINIO',120,'B1',3,186,'PVC'),('ALUMINIO',120,'B2',2,181,'PVC'),('ALUMINIO',120,'B2',3,160,'PVC'),('ALUMINIO',120,'C',2,226,'PVC'),('ALUMINIO',120,'C',3,197,'PVC'),('ALUMINIO',120,'D',2,189,'PVC'),('ALUMINIO',120,'D',2,157,'PVC'),('ALUMINIO',150,'A1',2,189,'PVC'),('ALUMINIO',150,'A1',3,170,'PVC'),('ALUMINIO',150,'A2',2,172,'PVC'),('ALUMINIO',150,'A2',3,155,'PVC'),('ALUMINIO',150,'B1',2,241,'PVC'),('ALUMINIO',150,'B1',3,214,'PVC'),('ALUMINIO',150,'B2',2,206,'PVC'),('ALUMINIO',150,'B2',3,183,'PVC'),('ALUMINIO',150,'C',2,261,'PVC'),('ALUMINIO',150,'C',3,227,'PVC'),('ALUMINIO',150,'D',2,213,'PVC'),('ALUMINIO',150,'D',2,178,'PVC'),('ALUMINIO',185,'A1',2,215,'PVC'),('ALUMINIO',185,'A1',3,194,'PVC'),('ALUMINIO',185,'A2',2,195,'PVC'),('ALUMINIO',185,'A2',3,176,'PVC'),('ALUMINIO',185,'B1',2,275,'PVC'),('ALUMINIO',185,'B1',3,245,'PVC'),('ALUMINIO',185,'B2',2,234,'PVC'),('ALUMINIO',185,'B2',3,208,'PVC'),('ALUMINIO',185,'C',2,298,'PVC'),('ALUMINIO',185,'C',3,259,'PVC'),('ALUMINIO',185,'D',2,240,'PVC'),('ALUMINIO',185,'D',2,200,'PVC'),('ALUMINIO',240,'A1',2,252,'PVC'),('ALUMINIO',240,'A1',3,227,'PVC'),('ALUMINIO',240,'A2',2,229,'PVC'),('ALUMINIO',240,'A2',3,207,'PVC'),('ALUMINIO',240,'B1',2,324,'PVC'),('ALUMINIO',240,'B1',3,288,'PVC'),('ALUMINIO',240,'B2',2,274,'PVC'),('ALUMINIO',240,'B2',3,243,'PVC'),('ALUMINIO',240,'C',2,352,'PVC'),('ALUMINIO',240,'C',3,305,'PVC'),('ALUMINIO',240,'D',2,277,'PVC'),('ALUMINIO',240,'D',2,230,'PVC'),('ALUMINIO',300,'A1',2,289,'PVC'),('ALUMINIO',300,'A1',3,261,'PVC'),('ALUMINIO',300,'A2',2,263,'PVC'),('ALUMINIO',300,'A2',3,237,'PVC'),('ALUMINIO',300,'B1',2,372,'PVC'),('ALUMINIO',300,'B1',3,331,'PVC'),('ALUMINIO',300,'B2',2,313,'PVC'),('ALUMINIO',300,'B2',3,278,'PVC'),('ALUMINIO',300,'C',2,406,'PVC'),('ALUMINIO',300,'C',3,351,'PVC'),('ALUMINIO',300,'D',2,313,'PVC'),('ALUMINIO',300,'D',2,260,'PVC'),('ALUMINIO',400,'A1',2,345,'PVC'),('ALUMINIO',400,'A1',3,311,'PVC'),('ALUMINIO',400,'A2',2,314,'PVC'),('ALUMINIO',400,'A2',3,283,'PVC'),('ALUMINIO',400,'B1',2,446,'PVC'),('ALUMINIO',400,'B1',3,397,'PVC'),('ALUMINIO',400,'B2',2,372,'PVC'),('ALUMINIO',400,'B2',3,331,'PVC'),('ALUMINIO',400,'C',2,488,'PVC'),('ALUMINIO',400,'C',3,422,'PVC'),('ALUMINIO',400,'D',2,366,'PVC'),('ALUMINIO',400,'D',2,305,'PVC'),('ALUMINIO',500,'A1',2,396,'PVC'),('ALUMINIO',500,'A1',3,356,'PVC'),('ALUMINIO',500,'A2',2,360,'PVC'),('ALUMINIO',500,'A2',3,324,'PVC'),('ALUMINIO',500,'B1',2,512,'PVC'),('ALUMINIO',500,'B1',3,456,'PVC'),('ALUMINIO',500,'B2',2,425,'PVC'),('ALUMINIO',500,'B2',3,378,'PVC'),('ALUMINIO',500,'C',2,563,'PVC'),('ALUMINIO',500,'C',3,486,'PVC'),('ALUMINIO',500,'D',2,414,'PVC'),('ALUMINIO',500,'D',2,345,'PVC'),('ALUMINIO',630,'A1',2,456,'PVC'),('ALUMINIO',630,'A1',3,410,'PVC'),('ALUMINIO',630,'A2',2,416,'PVC'),('ALUMINIO',630,'A2',3,373,'PVC'),('ALUMINIO',630,'B1',2,592,'PVC'),('ALUMINIO',630,'B1',3,527,'PVC'),('ALUMINIO',630,'B2',2,488,'PVC'),('ALUMINIO',630,'B2',3,435,'PVC'),('ALUMINIO',630,'C',2,653,'PVC'),('ALUMINIO',630,'C',3,562,'PVC'),('ALUMINIO',630,'D',2,471,'PVC'),('ALUMINIO',630,'D',2,391,'PVC'),('ALUMINIO',800,'A1',2,529,'PVC'),('ALUMINIO',800,'A1',3,475,'PVC'),('ALUMINIO',800,'A2',2,482,'PVC'),('ALUMINIO',800,'A2',3,432,'PVC'),('ALUMINIO',800,'B1',2,687,'PVC'),('ALUMINIO',800,'B1',3,612,'PVC'),('ALUMINIO',800,'B2',2,563,'PVC'),('ALUMINIO',800,'B2',3,502,'PVC'),('ALUMINIO',800,'C',2,761,'PVC'),('ALUMINIO',800,'C',3,654,'PVC'),('ALUMINIO',800,'D',2,537,'PVC'),('ALUMINIO',800,'D',2,446,'PVC'),('ALUMINIO',1000,'A1',2,607,'PVC'),('ALUMINIO',1000,'A1',3,544,'PVC'),('ALUMINIO',1000,'A2',2,552,'PVC'),('ALUMINIO',1000,'A2',3,495,'PVC'),('ALUMINIO',1000,'B1',2,790,'PVC'),('ALUMINIO',1000,'B1',3,704,'PVC'),('ALUMINIO',1000,'B2',2,643,'PVC'),('ALUMINIO',1000,'B2',3,574,'PVC'),('ALUMINIO',1000,'C',2,878,'PVC'),('ALUMINIO',1000,'C',3,753,'PVC'),('ALUMINIO',1000,'D',2,607,'PVC'),('ALUMINIO',1000,'D',2,505,'PVC');
/*!40000 ALTER TABLE `conducao_cabos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dados_eletroduto`
--

DROP TABLE IF EXISTS `dados_eletroduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dados_eletroduto` (
  `diametro_nominal_eletroduto_sugerido_polegadas` varchar(255) NOT NULL,
  `diametro_externo_eletroduto_sugerido` decimal(19,2) DEFAULT NULL,
  `diametro_interno_eletroduto_sugerido` decimal(19,2) DEFAULT NULL,
  `diametro_nominal_eletroduto_sugerido_milimetros` int NOT NULL,
  PRIMARY KEY (`diametro_nominal_eletroduto_sugerido_polegadas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_eletroduto`
--

LOCK TABLES `dados_eletroduto` WRITE;
/*!40000 ALTER TABLE `dados_eletroduto` DISABLE KEYS */;
/*!40000 ALTER TABLE `dados_eletroduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dados_entrada`
--

DROP TABLE IF EXISTS `dados_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dados_entrada` (
  `utilizacao_circuito` varchar(255) NOT NULL,
  `comprimento_fio` int DEFAULT NULL,
  `fases_voltagem` varchar(255) DEFAULT NULL,
  `fator_de_potencia` decimal(19,2) DEFAULT NULL,
  `metodo_instalacao` varchar(255) DEFAULT NULL,
  `potencia_aparente` decimal(19,2) DEFAULT NULL,
  `potencia_ativa` decimal(19,2) DEFAULT NULL,
  `quantidade_circuitos_agrupados` int DEFAULT NULL,
  `temperatura_ambiente` int DEFAULT NULL,
  `tipo_cabo` varchar(255) DEFAULT NULL,
  `tipo_circuito` varchar(255) DEFAULT NULL,
  `voltagem` int DEFAULT NULL,
  PRIMARY KEY (`utilizacao_circuito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_entrada`
--

LOCK TABLES `dados_entrada` WRITE;
/*!40000 ALTER TABLE `dados_entrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `dados_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dados_entrada_disjuntores`
--

DROP TABLE IF EXISTS `dados_entrada_disjuntores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dados_entrada_disjuntores` (
  `corrente_projeto` decimal(19,2) NOT NULL,
  `corrente_maxima_cabo` decimal(19,2) DEFAULT NULL,
  `fases_voltagem` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`corrente_projeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_entrada_disjuntores`
--

LOCK TABLES `dados_entrada_disjuntores` WRITE;
/*!40000 ALTER TABLE `dados_entrada_disjuntores` DISABLE KEYS */;
/*!40000 ALTER TABLE `dados_entrada_disjuntores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dados_entrada_eletrodutos`
--

DROP TABLE IF EXISTS `dados_entrada_eletrodutos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dados_entrada_eletrodutos` (
  `diametro_cabo` decimal(19,2) NOT NULL,
  `quantidade_condutores` int DEFAULT NULL,
  PRIMARY KEY (`diametro_cabo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_entrada_eletrodutos`
--

LOCK TABLES `dados_entrada_eletrodutos` WRITE;
/*!40000 ALTER TABLE `dados_entrada_eletrodutos` DISABLE KEYS */;
/*!40000 ALTER TABLE `dados_entrada_eletrodutos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exemplos_cabos`
--

DROP TABLE IF EXISTS `exemplos_cabos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exemplos_cabos` (
  `cabos_carregados` int NOT NULL,
  `secao_nominal` decimal(5,2) NOT NULL,
  `diametro_nominal_condutor` decimal(5,2) DEFAULT NULL,
  `diametro_nominal_externo` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`cabos_carregados`,`secao_nominal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exemplos_cabos`
--

LOCK TABLES `exemplos_cabos` WRITE;
/*!40000 ALTER TABLE `exemplos_cabos` DISABLE KEYS */;
INSERT INTO `exemplos_cabos` VALUES (1,1.50,1.50,4.50),(1,2.50,2.00,5.20),(1,4.00,2.40,5.50),(1,6.00,2.90,6.10),(1,10.00,3.90,7.60),(1,16.00,5.00,8.40),(1,25.00,6.50,10.30),(1,35.00,7.50,11.40),(1,50.00,9.00,13.30),(1,70.00,10.60,15.70),(1,95.00,12.20,17.60),(1,120.00,14.20,19.50),(1,150.00,15.80,21.80),(1,185.00,17.00,23.80),(1,240.00,20.00,26.80),(1,300.00,23.10,30.50),(2,1.50,1.50,8.00),(2,2.50,2.00,9.20),(2,4.00,2.40,9.90),(2,6.00,2.90,10.90),(2,10.00,3.90,13.30),(2,16.00,5.00,15.10),(2,25.00,6.50,19.20),(2,35.00,7.50,21.40),(2,50.00,9.00,25.00),(3,1.50,1.50,8.10),(3,2.50,2.00,9.40),(3,4.00,2.40,10.40),(3,6.00,2.90,11.50),(3,10.00,3.90,14.10),(3,16.00,5.00,16.30),(3,25.00,6.50,19.90),(3,35.00,7.50,22.80),(3,50.00,9.00,28.00),(3,70.00,10.60,31.30),(3,95.00,12.20,36.40),(3,120.00,14.20,41.10),(4,1.50,1.50,9.10),(4,2.50,2.00,10.40),(4,4.00,2.40,11.30),(4,6.00,2.90,12.60),(4,10.00,3.90,15.90),(4,16.00,5.00,18.50),(4,25.00,6.50,22.50),(4,35.00,7.50,25.40),(4,50.00,9.00,29.90),(4,70.00,10.60,36.00),(4,95.00,12.20,41.60),(4,120.00,14.20,46.30),(5,1.50,1.50,10.60),(5,2.50,2.00,12.20),(5,4.00,2.40,12.80),(5,6.00,2.90,14.40),(5,10.00,3.90,17.70),(5,16.00,5.00,20.00);
/*!40000 ALTER TABLE `exemplos_cabos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exemplos_disjuntores`
--

DROP TABLE IF EXISTS `exemplos_disjuntores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exemplos_disjuntores` (
  `corrente_nominal` int NOT NULL,
  `condutores_carregados` int NOT NULL,
  `nome_disjuntor` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`corrente_nominal`,`condutores_carregados`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exemplos_disjuntores`
--

LOCK TABLES `exemplos_disjuntores` WRITE;
/*!40000 ALTER TABLE `exemplos_disjuntores` DISABLE KEYS */;
INSERT INTO `exemplos_disjuntores` VALUES (2,1,'5SL1 102-7MB'),(2,2,'5SL1 202-7MB'),(2,3,'5SL1 302-7MB'),(4,1,'5SL1 104-7MB'),(4,2,'5SL1 204-7MB'),(4,3,'5SL1 304-7MB'),(6,1,'5SL1 106-7MB'),(6,2,'5SL1 206-7MB'),(6,3,'5SL1 306-7MB'),(10,1,'5SL1 110-7MB'),(10,2,'5SL1 210-7MB'),(10,3,'5SL1 310-7MB'),(13,1,'5SL1 113-7MB'),(13,2,'5SL1 213-7MB'),(13,3,'5SL1 313-7MB'),(16,1,'5SL1 116-7MB'),(16,2,'5SL1 216-7MB'),(16,3,'5SL1 316-7MB'),(20,1,'5SL1 120-7MB'),(20,2,'5SL1 220-7MB'),(20,3,'5SL1 320-7MB'),(25,1,'5SL1 125-7MB'),(25,2,'5SL1 225-7MB'),(25,3,'5SL1 325-7MB'),(32,1,'5SL1 132-7MB'),(32,2,'5SL1 232-7MB'),(32,3,'5SL1 332-7MB'),(40,1,'5SL1 140-7MB'),(40,2,'5SL1 240-7MB'),(40,3,'5SL1 340-7MB'),(50,1,'5SL1 150-7MB'),(50,2,'5SL1 250-7MB'),(50,3,'5SL1 350-7MB'),(63,1,'5SL1 163-7MB'),(63,2,'5SL1 263-7MB'),(63,3,'5SL1 363-7MB'),(70,1,'5SL1 170-7MB'),(70,2,'5SL1 270-7MB'),(70,3,'5SL1 370-7MB'),(80,1,'5SL1 180-7MB'),(80,2,'5SL1 280-7MB'),(80,3,'5SL1 380-7MB');
/*!40000 ALTER TABLE `exemplos_disjuntores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exemplos_eletrodutos`
--

DROP TABLE IF EXISTS `exemplos_eletrodutos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exemplos_eletrodutos` (
  `diametro_nominal_polegadas` varchar(10) DEFAULT NULL,
  `diametro_nominal_milimetros` int NOT NULL,
  `diametro_externo` decimal(5,2) DEFAULT NULL,
  `diametro_interno` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`diametro_nominal_milimetros`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exemplos_eletrodutos`
--

LOCK TABLES `exemplos_eletrodutos` WRITE;
/*!40000 ALTER TABLE `exemplos_eletrodutos` DISABLE KEYS */;
INSERT INTO `exemplos_eletrodutos` VALUES ('1.1/4\"',30,41.30,31.50),('1.1/2\"',40,56.00,43.00),('2\"',50,63.40,50.80),('3\"',75,89.50,75.00),('4\"',100,124.50,103.00),('5\"',125,155.00,128.00),('6\"',150,190.00,155.00),('7\"',175,202.00,176.00),('8\"',200,250.00,205.00);
/*!40000 ALTER TABLE `exemplos_eletrodutos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fator_temperatura`
--

DROP TABLE IF EXISTS `fator_temperatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fator_temperatura` (
  `temperatura` int NOT NULL,
  `isolacao` varchar(3) NOT NULL,
  `fator_correcao` double DEFAULT NULL,
  PRIMARY KEY (`temperatura`,`isolacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fator_temperatura`
--

LOCK TABLES `fator_temperatura` WRITE;
/*!40000 ALTER TABLE `fator_temperatura` DISABLE KEYS */;
INSERT INTO `fator_temperatura` VALUES (10,'EPR',1.15),(10,'PVC',1.22),(15,'EPR',1.12),(15,'PVC',1.17),(20,'EPR',1.08),(20,'PVC',1.12),(25,'EPR',1.04),(25,'PVC',1.06),(30,'EPR',1),(30,'PVC',1),(35,'EPR',0.96),(35,'PVC',0.94),(40,'EPR',0.91),(40,'PVC',0.87),(45,'EPR',0.87),(45,'PVC',0.79),(50,'EPR',0.82),(50,'PVC',0.71),(55,'EPR',0.76),(55,'PVC',0.61),(60,'EPR',0.71),(60,'PVC',0.5),(65,'EPR',0.65),(70,'EPR',0.58),(75,'EPR',0.5),(80,'EPR',0.41);
/*!40000 ALTER TABLE `fator_temperatura` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-19 16:56:51
