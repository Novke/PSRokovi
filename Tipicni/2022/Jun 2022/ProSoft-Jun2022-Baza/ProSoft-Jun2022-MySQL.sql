/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.17-MariaDB : Database - prosoftjun22
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftjun22` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `prosoftjun22`;

/*Table structure for table `kategorija` */

DROP TABLE IF EXISTS `kategorija`;

CREATE TABLE `kategorija` (
  `KategorijaID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) NOT NULL,
  `NadredjenaKategorijaID` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`KategorijaID`),
  KEY `NadredjenaKategorijaID` (`NadredjenaKategorijaID`),
  CONSTRAINT `kategorija_ibfk_1` FOREIGN KEY (`NadredjenaKategorijaID`) REFERENCES `kategorija` (`KategorijaID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kategorija` */

insert  into `kategorija`(`KategorijaID`,`Naziv`,`NadredjenaKategorijaID`) values (1,'ISiT',NULL),(2,'Informacioni sistemi',1),(3,'Informacione tehnologije',1),(4,'Elektronsko poslovanje',1),(5,'Softversko inzenjerstvo',1),(6,'Menadzment i organizacija',NULL),(7,'Menadzment',6),(8,'Operacioni menadzment',6),(9,'Menadzment kvaliteta i standardizacija',6),(10,'Upravljanje sistemima',6),(11,'Matematika',NULL),(12,'Matematicke metode u menadzmentu',11),(13,'Matematicke metode u informatici',11),(14,'Numericka analiza',11),(15,'Diskretne matematicke strukture',11),(16,'Algebra',11),(17,'Geometrija',11),(18,'Kategorija 4',NULL),(19,'Kategorija 4.1',18),(20,'Kategorija 4.2',18),(21,'Kategorija 4.3',18);

/*Table structure for table `rad` */

DROP TABLE IF EXISTS `rad`;

CREATE TABLE `rad` (
  `RadID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) NOT NULL,
  `Autor1` varchar(255) NOT NULL,
  `Autor2` varchar(255) NOT NULL,
  `Autor3` varchar(255) NOT NULL,
  PRIMARY KEY (`RadID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `rad` */

insert  into `rad`(`RadID`,`Naziv`,`Autor1`,`Autor2`,`Autor3`) values (1,'Rad 1','Ana Anic','',''),(2,'Rad 2','Petar Petrovic','Dragan Draganic','Ivan Ivanic'),(3,'Rad 3','Jovana Jovic','Ivan Ivkovic',''),(4,'Rad 4','Pavle Pavlovic','',''),(5,'Rad 5','Dusan Dusanic','Jelena Jovic','Marko Markovic'),(6,'Rad 6','Marija Mitrovic','Slavisa Slavic',''),(7,'Rad 7','Jovan Pavlovic','Ana Markovic','Mirko Mirkovic'),(8,'Rad 8','Nenad Nenadic','Marija Markovic','Ivan Ivic'),(9,'Rad 9','Dragana Panic','',''),(10,'Rad 10','Dejana Dejanic','Sava Savic','Vladimir Vladimirovic');

/*Table structure for table `rasporedsekcije` */

DROP TABLE IF EXISTS `rasporedsekcije`;

CREATE TABLE `rasporedsekcije` (
  `SekcijaID` bigint(20) unsigned NOT NULL,
  `RB` int(10) unsigned NOT NULL,
  `Status` varchar(50) NOT NULL,
  `RadID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`SekcijaID`,`RB`),
  KEY `RadID` (`RadID`),
  CONSTRAINT `rasporedsekcije_ibfk_1` FOREIGN KEY (`SekcijaID`) REFERENCES `sekcija` (`SekcijaID`),
  CONSTRAINT `rasporedsekcije_ibfk_2` FOREIGN KEY (`RadID`) REFERENCES `rad` (`RadID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `rasporedsekcije` */

/*Table structure for table `sekcija` */

DROP TABLE IF EXISTS `sekcija`;

CREATE TABLE `sekcija` (
  `SekcijaID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) NOT NULL,
  `DatumVremeOd` datetime NOT NULL,
  `DatumVremeDo` datetime NOT NULL,
  `Sala` varchar(50) NOT NULL,
  `Moderator` varchar(50) NOT NULL,
  `KategorijaID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`SekcijaID`),
  KEY `KategorijaID` (`KategorijaID`),
  CONSTRAINT `sekcija_ibfk_1` FOREIGN KEY (`KategorijaID`) REFERENCES `kategorija` (`KategorijaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sekcija` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
