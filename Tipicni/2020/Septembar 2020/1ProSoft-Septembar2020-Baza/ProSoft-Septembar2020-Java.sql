/*
SQLyog Ultimate v9.50 
MySQL - 5.6.20 : Database - prosoftsept2020
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftsept2020` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prosoftsept2020`;

/*Table structure for table `laborant` */

DROP TABLE IF EXISTS `laborant`;

CREATE TABLE `laborant` (
  `LaborantID` INT(11) NOT NULL,
  `Ime` VARCHAR(255) DEFAULT NULL,
  `Prezime` VARCHAR(255) DEFAULT NULL,
  `KorisnickoIme` VARCHAR(50) DEFAULT NULL,
  `Lozinka` VARCHAR(50) DEFAULT NULL,
  `LaboratorijaID` INT(11) DEFAULT NULL,
  PRIMARY KEY (`LaborantID`),
  KEY `LaboratorijaID` (`LaboratorijaID`),
  CONSTRAINT `laborant_ibfk_1` FOREIGN KEY (`LaboratorijaID`) REFERENCES `laboratorija` (`LaboratorijaID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `laborant` */

INSERT  INTO `laborant`(`LaborantID`,`Ime`,`Prezime`,`KorisnickoIme`,`Lozinka`,`LaboratorijaID`) VALUES (1,'Ana','Anic','ana','ana',1),(2,'Marko','Peric','marko','marko',2),(3,'Jovan','Jovic','jovan','jovan',3);

/*Table structure for table `laboratorija` */

DROP TABLE IF EXISTS `laboratorija`;

CREATE TABLE `laboratorija` (
  `LaboratorijaID` INT(11) NOT NULL,
  `Naziv` VARCHAR(255) DEFAULT NULL,
  `DnevniKapacitetTestova` INT(11) DEFAULT NULL,
  `Grad` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`LaboratorijaID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `laboratorija` */

INSERT  INTO `laboratorija`(`LaboratorijaID`,`Naziv`,`DnevniKapacitetTestova`,`Grad`) VALUES (1,'Vatreno oko BG',2000,'Beograd'),(2,'Vatreno oko Nis',1000,'Nis'),(3,'Institut Torlak',500,'Beograd');

/*Table structure for table `osiguranolice` */

DROP TABLE IF EXISTS `osiguranolice`;

CREATE TABLE `osiguranolice` (
  `OsiguranoLiceID` INT(11) NOT NULL,
  `Ime` VARCHAR(255) DEFAULT NULL,
  `Prezime` VARCHAR(255) DEFAULT NULL,
  `LBO` VARCHAR(20) DEFAULT NULL,
  `KrvnaGrupa` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`OsiguranoLiceID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `osiguranolice` */

INSERT  INTO `osiguranolice`(`OsiguranoLiceID`,`Ime`,`Prezime`,`LBO`,`KrvnaGrupa`) VALUES (1,'Marko','Markovic','1111','0+'),(2,'Dragan','Draganic','2222','A-'),(3,'Jovana','Jovanic','3333','AB+'),(4,'Marija','Markovic','4444','B+'),(5,'Petar','Petrovic','5555','A+'),(6,'Mirko','Mirkovic','6666','B-'),(7,'Milos','Milosevic','7777','0-'),(8,'Milos','Mitrovic','8888','0+');

/*Table structure for table `zahtev` */

DROP TABLE IF EXISTS `zahtev`;

CREATE TABLE `zahtev` (
  `ZahtevID` INT(11) NOT NULL,
  `DatumVremeTestiranja` DATETIME DEFAULT NULL,
  `Hitno` TINYINT(1) DEFAULT NULL,
  `Tip` VARCHAR(50) DEFAULT NULL,
  `Rezultat` VARCHAR(50) DEFAULT NULL,
  `DatumVremeRezultata` DATETIME DEFAULT NULL,
  `Napomena` VARCHAR(255) DEFAULT NULL,
  `Status` VARCHAR(50) DEFAULT NULL,
  `OsiguranoLiceID` INT(11) DEFAULT NULL,
  `LaboratorijaID` INT(11) DEFAULT NULL,
  `LaborantID` INT(11) DEFAULT NULL,
  PRIMARY KEY (`ZahtevID`),
  KEY `OsiguranoLiceID` (`OsiguranoLiceID`),
  KEY `LaboratorijaID` (`LaboratorijaID`),
  KEY `LaborantID` (`LaborantID`),
  CONSTRAINT `zahtev_ibfk_1` FOREIGN KEY (`OsiguranoLiceID`) REFERENCES `osiguranolice` (`OsiguranoLiceID`),
  CONSTRAINT `zahtev_ibfk_2` FOREIGN KEY (`LaboratorijaID`) REFERENCES `laboratorija` (`LaboratorijaID`),
  CONSTRAINT `zahtev_ibfk_3` FOREIGN KEY (`LaborantID`) REFERENCES `laborant` (`LaborantID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `zahtev` */

INSERT  INTO `zahtev`(`ZahtevID`,`DatumVremeTestiranja`,`Hitno`,`Tip`,`Rezultat`,`DatumVremeRezultata`,`Napomena`,`Status`,`OsiguranoLiceID`,`LaboratorijaID`,`LaborantID`) VALUES (1,'2020-08-23 11:15:00',1,NULL,NULL,NULL,NULL,'Neobradjen',1,1,NULL),(2,'2020-08-23 12:10:00',0,NULL,NULL,NULL,NULL,'Neobradjen',2,1,NULL),(3,'2020-08-24 07:10:00',1,NULL,NULL,NULL,NULL,'Neobradjen',3,1,NULL),(4,'2020-08-25 12:10:00',1,NULL,NULL,NULL,NULL,'Neobradjen',4,1,NULL),(5,'2020-08-25 10:50:00',0,NULL,NULL,NULL,NULL,'Neobradjen',5,2,NULL),(6,'2020-08-26 11:43:00',1,NULL,NULL,NULL,NULL,'Neobradjen',6,2,NULL),(7,'2020-08-24 07:20:00',1,NULL,NULL,NULL,NULL,'Neobradjen',7,2,NULL),(8,'2020-08-24 07:25:00',0,NULL,NULL,NULL,NULL,'Neobradjen',8,2,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
