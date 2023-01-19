/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.17-MariaDB : Database - prosoftjul22
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftjul22` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `prosoftjul22`;

/*Table structure for table `programskivodic` */

DROP TABLE IF EXISTS `programskivodic`;

CREATE TABLE `programskivodic` (
  `ProgramskiVodicID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Dan` date NOT NULL,
  `Opis` varchar(1000) NOT NULL,
  `Urednik` varchar(50) NOT NULL,
  PRIMARY KEY (`ProgramskiVodicID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `programskivodic` */

/*Table structure for table `stanica` */

DROP TABLE IF EXISTS `stanica`;

CREATE TABLE `stanica` (
  `StanicaID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) NOT NULL,
  `Tip` varchar(50) NOT NULL,
  `Kontakt` varchar(255) NOT NULL,
  PRIMARY KEY (`StanicaID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `stanica` */

insert  into `stanica`(`StanicaID`,`Naziv`,`Tip`,`Kontakt`) values (1,'RTS1','TV','rts1@rts.rs'),(2,'RTS2','TV','rts2@rts.rs'),(3,'RTS3','TV','rts3@rts.rs'),(4,'Radio 202','Radio','radio202@rts.rs'),(5,'Radio N','Radio','kontakt@n.net'),(6,'FOX','TV','kontakt@fox.net'),(7,'Svitel','TV','kontakt@svitel.net');

/*Table structure for table `stavkaprogramskogvodica` */

DROP TABLE IF EXISTS `stavkaprogramskogvodica`;

CREATE TABLE `stavkaprogramskogvodica` (
  `ProgramskiVodicID` bigint(20) unsigned NOT NULL,
  `RB` int(10) unsigned NOT NULL,
  `NazivEmisije` varchar(255) NOT NULL,
  `DatumVremeOd` datetime NOT NULL,
  `DatumVremeDo` datetime NOT NULL,
  `StanicaID` bigint(20) unsigned NOT NULL,
  `TipEmisijeID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`ProgramskiVodicID`,`RB`),
  KEY `StanicaID` (`StanicaID`),
  KEY `TipEmisijeID` (`TipEmisijeID`),
  CONSTRAINT `stavkaprogramskogvodica_ibfk_1` FOREIGN KEY (`ProgramskiVodicID`) REFERENCES `programskivodic` (`ProgramskiVodicID`),
  CONSTRAINT `stavkaprogramskogvodica_ibfk_2` FOREIGN KEY (`StanicaID`) REFERENCES `stanica` (`StanicaID`),
  CONSTRAINT `stavkaprogramskogvodica_ibfk_3` FOREIGN KEY (`TipEmisijeID`) REFERENCES `tipemisije` (`TipEmisijeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavkaprogramskogvodica` */

/*Table structure for table `tipemisije` */

DROP TABLE IF EXISTS `tipemisije`;

CREATE TABLE `tipemisije` (
  `TipEmisijeID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) NOT NULL,
  `NadtipEmisijeID` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`TipEmisijeID`),
  KEY `NadtipEmisijeID` (`NadtipEmisijeID`),
  CONSTRAINT `tipemisije_ibfk_1` FOREIGN KEY (`NadtipEmisijeID`) REFERENCES `tipemisije` (`TipEmisijeID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tipemisije` */

insert  into `tipemisije`(`TipEmisijeID`,`Naziv`,`NadtipEmisijeID`) values (1,'Informativni',NULL),(2,'Vesti',1),(3,'IT',1),(4,'Talk Show',1),(5,'Magazin',1),(6,'Sportski',NULL),(7,'Fudbal',6),(8,'Kosarka',6),(9,'Odbojka',6),(10,'Rukomet',6),(11,'Tenis',6),(12,'Atletika',6),(13,'Veterpolo',6),(14,'Zabava',NULL),(15,'Muzika',14),(16,'Film',14),(17,'Kviz',14),(18,'Evrosong',14);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
