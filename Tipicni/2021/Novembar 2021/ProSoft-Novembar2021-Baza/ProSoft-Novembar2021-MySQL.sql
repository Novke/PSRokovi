/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.17-MariaDB : Database - prosoftnov21
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftnov21` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `prosoftnov21`;

/*Table structure for table `angazovanje` */

DROP TABLE IF EXISTS `angazovanje`;

CREATE TABLE `angazovanje` (
  `AngazovanjeID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `VrstaAngazovanja` VARCHAR(50) NOT NULL,
  `OpisPosla` VARCHAR(255) NOT NULL,
  `BrojSati` INT(11) NOT NULL,
  `EmisijaID` INT(10) UNSIGNED NOT NULL,
  `RadnikID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`AngazovanjeID`),
  KEY `EmisijaID` (`EmisijaID`),
  KEY `RadnikID` (`RadnikID`),
  CONSTRAINT `angazovanje_ibfk_1` FOREIGN KEY (`EmisijaID`) REFERENCES `emisija` (`EmisijaID`),
  CONSTRAINT `angazovanje_ibfk_2` FOREIGN KEY (`RadnikID`) REFERENCES `radnik` (`RadnikID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

/*Data for the table `angazovanje` */

/*Table structure for table `emisija` */

DROP TABLE IF EXISTS `emisija`;

CREATE TABLE `emisija` (
  `EmisijaID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivEmisije` VARCHAR(255) NOT NULL,
  `DatumVremePocetka` datetime NOT NULL,
  `DatumVremeKraja` datetime NOT NULL,
  `NacinEmitovanja` varchar(50) NOT NULL,
  `Producent` varchar(50) NOT NULL,
  `VoditeljRadnikID` int(10) unsigned NOT NULL,
  `StudioID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`EmisijaID`),
  KEY `VoditeljRadnikID` (`VoditeljRadnikID`),
  KEY `StudioID` (`StudioID`),
  CONSTRAINT `emisija_ibfk_1` FOREIGN KEY (`VoditeljRadnikID`) REFERENCES `radnik` (`RadnikID`),
  CONSTRAINT `emisija_ibfk_2` FOREIGN KEY (`StudioID`) REFERENCES `studio` (`StudioID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `emisija` */

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `RadnikID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(255) NOT NULL,
  `Prezime` varchar(255) NOT NULL,
  `BrojLicence` int(11) NOT NULL,
  `StrucnaSprema` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  PRIMARY KEY (`RadnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `radnik` */

insert  into `radnik`(`RadnikID`,`Ime`,`Prezime`,`BrojLicence`,`StrucnaSprema`,`Status`) values (1,'Marija','Markovic',1,'VSS','Aktivan'),(2,'Dragan','Draganic',2,'VSS','Aktivan'),(3,'Ivana','Ivanovic',3,'SSS','Neaktivan'),(4,'Petar','Petrovic',4,'VSS','Aktivan'),(5,'Jovana','Jovanic',5,'SSS','Aktivan'),(6,'Marija','Marjanovic',6,'VSS','Aktivan'),(7,'Milos','Milosevic',7,'SSS','Neaktivan'),(8,'Jovan','Jovic',8,'VSS','Aktivan'),(9,'Ana','Anic',9,'SSS','Aktivan'),(10,'Marko','Markovic',10,'VSS','Aktivan');

/*Table structure for table `studio` */

DROP TABLE IF EXISTS `studio`;

CREATE TABLE `studio` (
  `StudioID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) NOT NULL,
  `Lokacija` varchar(255) NOT NULL,
  `Status` varchar(50) NOT NULL,
  PRIMARY KEY (`StudioID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `studio` */

insert  into `studio`(`StudioID`,`Naziv`,`Lokacija`,`Status`) values (1,'Studio 1','Takovska 10','Aktivan'),(2,'Studio 2','Takovska 10','Aktivan'),(3,'Studio 3','Kosutnjak 1','Aktivan'),(4,'Studio 4','Kosutnjak 2','Aktivan'),(5,'Studio 5','Kosutnjak 3','Neaktivan');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
