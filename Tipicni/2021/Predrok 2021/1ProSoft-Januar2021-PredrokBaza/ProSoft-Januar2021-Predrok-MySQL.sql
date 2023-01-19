/*
SQLyog Ultimate v9.50 
MySQL - 5.6.20 : Database - prosoftjan21predrok
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftjan21predrok` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prosoftjan21predrok`;

/*Table structure for table `aerodrom` */

DROP TABLE IF EXISTS `aerodrom`;

CREATE TABLE `aerodrom` (
  `AerodromID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) DEFAULT NULL,
  `Kod` varchar(3) DEFAULT NULL,
  `Adresa` varchar(255) DEFAULT NULL,
  `Drzava` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AerodromID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `aerodrom` */

insert  into `aerodrom`(`AerodromID`,`Naziv`,`Kod`,`Adresa`,`Drzava`) values (1,'Nikola Tesla Airport','BEG','Surcinska BB','Serbia'),(2,'Leonardo da Vinci International Airportonal Airport','FCO','Via dell\' Aeroporto di Fiumicino','Italy'),(3,'Henri Coanda International Airport','OTP','Calea Bucurestilor nr. 224 E','Romania'),(4,'Skopje International Airport','SKP','Aleksandar Makedonski, Petrovec 1043','North Macedonia'),(5,'Sheremetyevo International Airport','SVO','Khimki 141400, Moskovskaya oblast','Russia'),(6,'Heathrow Airport','LHR','Longford TW6','United Kingdom'),(7,'Frankfurt am Main Airport','FRA','60547 Frankfurt','Germany'),(8,'Sofia International Airport','SOF','Christopher Columbus 1','Bulgaria'),(9,'Sydney Kingsford Smith Airport','SYD','Sydney NSW 2020','Australia');

/*Table structure for table `interkonekcija` */

DROP TABLE IF EXISTS `interkonekcija`;

CREATE TABLE `interkonekcija` (
  `LetID` bigint(20) NOT NULL,
  `RB` bigint(20) NOT NULL,
  `AerodromID` bigint(20) DEFAULT NULL,
  `DatumVremeLeta` datetime DEFAULT NULL,
  PRIMARY KEY (`LetID`,`RB`),
  KEY `AerodromID` (`AerodromID`),
  CONSTRAINT `interkonekcija_ibfk_1` FOREIGN KEY (`AerodromID`) REFERENCES `aerodrom` (`AerodromID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `interkonekcija` */

/*Table structure for table `let` */

DROP TABLE IF EXISTS `let`;

CREATE TABLE `let` (
  `LetID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DatumVremePocetka` datetime DEFAULT NULL,
  `DatumVremeKraja` datetime DEFAULT NULL,
  `Opis` varchar(255) DEFAULT NULL,
  `TipAviona` varchar(50) DEFAULT NULL,
  `RedovanLet` tinyint(1) DEFAULT NULL,
  `PocetniAerodromID` bigint(20) DEFAULT NULL,
  `KrajnjiAerodromID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`LetID`),
  KEY `PocetniAerodromID` (`PocetniAerodromID`),
  KEY `KrajnjiAerodromID` (`KrajnjiAerodromID`),
  CONSTRAINT `let_ibfk_1` FOREIGN KEY (`PocetniAerodromID`) REFERENCES `aerodrom` (`AerodromID`),
  CONSTRAINT `let_ibfk_2` FOREIGN KEY (`KrajnjiAerodromID`) REFERENCES `aerodrom` (`AerodromID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `let` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
