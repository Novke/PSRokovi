/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.35-MariaDB : Database - prosoftjan22
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftjan22` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `prosoftjan22`;

/*Table structure for table `dostupnost` */

DROP TABLE IF EXISTS `dostupnost`;

CREATE TABLE `dostupnost` (
  `IgraID` int(10) unsigned NOT NULL,
  `RB` int(10) unsigned NOT NULL,
  `Platforma` varchar(50) CHARACTER SET latin1 NOT NULL,
  `DatumObjave` date NOT NULL,
  `Status` varchar(50) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`IgraID`,`RB`),
  CONSTRAINT `dostupnost_ibfk_1` FOREIGN KEY (`IgraID`) REFERENCES `igra` (`IgraID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dostupnost` */

/*Table structure for table `igra` */

DROP TABLE IF EXISTS `igra`;

CREATE TABLE `igra` (
  `IgraID` int(10) unsigned NOT NULL,
  `Naziv` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Zanr` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Opis` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Korisnik` varchar(50) CHARACTER SET latin1 NOT NULL,
  `IzdavacID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`IgraID`),
  KEY `IzdavacID` (`IzdavacID`),
  CONSTRAINT `igra_ibfk_1` FOREIGN KEY (`IzdavacID`) REFERENCES `izdavac` (`IzdavacID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `igra` */

/*Table structure for table `izdavac` */

DROP TABLE IF EXISTS `izdavac`;

CREATE TABLE `izdavac` (
  `IzdavacID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Adresa` varchar(255) CHARACTER SET latin1 NOT NULL,
  `URL` varchar(255) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`IzdavacID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `izdavac` */

insert  into `izdavac`(`IzdavacID`,`Naziv`,`Adresa`,`URL`) values 
(1,'Ubisoft','Adresa 1','https://www.ubisoft.com'),
(2,'Electronic Arts','Adresa 2','https://www.ea.com'),
(3,'CD Projekt','Adresa 3','https://www.cdprojekt.com'),
(4,'Capcom Company','Adresa 4','https://www.capcom.com'),
(5,'Epic Games','Adresa 5','https://www.epicgames.com'),
(6,'Take-Two Interactive Software','Adresa 6','https://www.take2games.com'),
(7,'Gameloft','Adresa 7','https://www.gameloft.com'),
(8,'Blizzard Entertainment','Adresa 8','https://www.blizzard.com'),
(9,'Zynga','Adresa 9','https://www.zynga.com'),
(10,'Konami Holdings Corporations','Adresa 10','https://www.konami.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
