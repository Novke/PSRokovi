/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.17-MariaDB : Database - prosoftjul21
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftjul21` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `prosoftjul21`;

/*Table structure for table `organizator` */

DROP TABLE IF EXISTS `organizator`;

CREATE TABLE `organizator` (
  `OrganizatorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(50) NOT NULL,
  `Prezime` varchar(50) NOT NULL,
  `KorisnickoIme` varchar(50) NOT NULL,
  `Lozinka` varchar(50) NOT NULL,
  PRIMARY KEY (`OrganizatorID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `organizator` */

insert  into `organizator`(`OrganizatorID`,`Ime`,`Prezime`,`KorisnickoIme`,`Lozinka`) values (1,'Ana','Anic','ana','ana1'),(2,'Dragan','Draganic','dragan','dragan1'),(3,'Marko','Markovic','marko','marko1');

/*Table structure for table `takmicar` */

DROP TABLE IF EXISTS `takmicar`;

CREATE TABLE `takmicar` (
  `TakmicarID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(50) NOT NULL,
  `Prezime` varchar(50) NOT NULL,
  `Pol` char(1) NOT NULL,
  `Kontakt` varchar(50) NOT NULL,
  PRIMARY KEY (`TakmicarID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `takmicar` */

insert  into `takmicar`(`TakmicarID`,`Ime`,`Prezime`,`Pol`,`Kontakt`) values (1,'Dragan','Petrovic','M','011-111-111'),(2,'Ivana','Ivkovic','Z','011-222-222'),(3,'Marko','Mitrovic','M','011-333-333'),(4,'Pavle','Petrovic','M','011-444-444'),(5,'Dusan','Jovic','M','011-555-555'),(6,'Jelena','Mitrovic','Z','011-666-666'),(7,'Marija','Markovic','Z','011-777-777'),(8,'Miljan','Matic','M','011-888-888'),(9,'Milica','Pavlovic','Z','011-999-999');

/*Table structure for table `takmicenje` */

DROP TABLE IF EXISTS `takmicenje`;

CREATE TABLE `takmicenje` (
  `TakmicenjeD` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivTakmicenja` varchar(255) NOT NULL,
  `VrstaTrke` varchar(50) NOT NULL,
  `Opis` varchar(255) NOT NULL,
  `Datum` datetime NOT NULL,
  PRIMARY KEY (`TakmicenjeD`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `takmicenje` */

insert  into `takmicenje`(`TakmicenjeD`,`NazivTakmicenja`,`VrstaTrke`,`Opis`,`Datum`) values (1,'BG maraton 21 - polumaraton (Z)','Polumaraton','Polumaraton 21km, zene','2021-06-06 09:00:00'),(2,'BG maraton 21 - maraton (Z)','Maraton','Maraton 42km, zene','2021-06-06 10:00:00'),(3,'BG maraton 21 - polumaraton (M)','Polumaraton','Polumaraton 21km, muskarci','2021-06-07 09:00:00'),(4,'BG maraton 21 - maraton (M)','Maraton','Maraton 42km, muskarci','2021-06-07 10:00:00');

/*Table structure for table `ucesce` */

DROP TABLE IF EXISTS `ucesce`;

CREATE TABLE `ucesce` (
  `UcesceID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `VrstaTrke` varchar(50) NOT NULL,
  `DatumVremePocetka` datetime NOT NULL,
  `DatumVremeZavrsetka` datetime NOT NULL,
  `TakmicenjeID` int(10) unsigned NOT NULL,
  `TakmicarID` int(10) unsigned NOT NULL,
  `OrganizatorID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`UcesceID`),
  KEY `TakmicenjeID` (`TakmicenjeID`),
  KEY `TakmicarID` (`TakmicarID`),
  KEY `OrganizatorID` (`OrganizatorID`),
  CONSTRAINT `ucesce_ibfk_1` FOREIGN KEY (`TakmicenjeID`) REFERENCES `takmicenje` (`TakmicenjeD`),
  CONSTRAINT `ucesce_ibfk_2` FOREIGN KEY (`TakmicarID`) REFERENCES `takmicar` (`TakmicarID`),
  CONSTRAINT `ucesce_ibfk_3` FOREIGN KEY (`OrganizatorID`) REFERENCES `organizator` (`OrganizatorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `ucesce` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
