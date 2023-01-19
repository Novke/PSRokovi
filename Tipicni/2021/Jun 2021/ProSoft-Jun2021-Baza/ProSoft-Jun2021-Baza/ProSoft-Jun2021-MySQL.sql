/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.17-MariaDB : Database - prosoftjun21
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftjun21` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `prosoftjun21`;

/*Table structure for table `poreskaprijava` */

DROP TABLE IF EXISTS `poreskaprijava`;

CREATE TABLE `poreskaprijava` (
  `PoreskaPrijavaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Adresa` varchar(255) NOT NULL,
  `MestoNepokretnosti` varchar(255) NOT NULL,
  `MestoPrebivalista` tinyint(1) NOT NULL,
  `BrojListaNepokretnosti` int(10) unsigned NOT NULL,
  `GodinaIzgradnje` int(10) unsigned NOT NULL,
  `DatumPocetkaKoriscenja` date NOT NULL,
  `Povrsina` decimal(10,2) unsigned NOT NULL,
  `DatumPodnosenjaPrijave` date NOT NULL,
  `PoreskiObveznikID` int(10) unsigned NOT NULL,
  `VrstaNepokretnostiID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`PoreskaPrijavaID`),
  KEY `PoreskiObveznikID` (`PoreskiObveznikID`),
  KEY `VrstaNepokretnostiID` (`VrstaNepokretnostiID`),
  CONSTRAINT `poreskaprijava_ibfk_1` FOREIGN KEY (`PoreskiObveznikID`) REFERENCES `poreskiobveznik` (`PoreskiObveznikID`),
  CONSTRAINT `poreskaprijava_ibfk_2` FOREIGN KEY (`VrstaNepokretnostiID`) REFERENCES `vrstanepokretnosti` (`VrstaNepokretnostiID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `poreskaprijava` */

/*Table structure for table `poreskiobveznik` */

DROP TABLE IF EXISTS `poreskiobveznik`;

CREATE TABLE `poreskiobveznik` (
  `PoreskiObveznikID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(255) NOT NULL,
  `Prezime` varchar(255) NOT NULL,
  `JMBG` varchar(13) NOT NULL,
  `KorisnickoIme` varchar(50) NOT NULL,
  `Lozinka` varchar(50) NOT NULL,
  `Telefon` varchar(50) NOT NULL,
  PRIMARY KEY (`PoreskiObveznikID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `poreskiobveznik` */

insert  into `poreskiobveznik`(`PoreskiObveznikID`,`Ime`,`Prezime`,`JMBG`,`KorisnickoIme`,`Lozinka`,`Telefon`) values (1,'Ana','Anic','111199911111','ana','ana1','011-111-111'),(2,'Ivan','Ivic','121299922222','ivan','ivan1','011-222-222'),(3,'Dragana','Dragic','131299933333','dragana','dragana1','011-333-333'),(4,'Marko','Markovic','141299944444','marko','marko1','011-444-444');

/*Table structure for table `vrstanepokretnosti` */

DROP TABLE IF EXISTS `vrstanepokretnosti`;

CREATE TABLE `vrstanepokretnosti` (
  `VrstaNepokretnostiID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivVrsteNepokretnosti` varchar(100) NOT NULL,
  `PoreskaGrupa` varchar(10) NOT NULL,
  PRIMARY KEY (`VrstaNepokretnostiID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `vrstanepokretnosti` */

insert  into `vrstanepokretnosti`(`VrstaNepokretnostiID`,`NazivVrsteNepokretnosti`,`PoreskaGrupa`) values (1,'Stan','G1'),(2,'Kuca za stanovanje','G2'),(3,'Poslovna zgrada ili objekat za obavljanje delatnosti','G3'),(4,'Garaza','G4'),(5,'Garazno mesto','G5');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
