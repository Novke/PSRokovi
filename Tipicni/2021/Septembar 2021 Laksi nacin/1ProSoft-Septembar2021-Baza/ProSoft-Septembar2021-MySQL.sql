/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.17-MariaDB : Database - prosoftseptembar21
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftseptembar21` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `prosoftseptembar21`;

/*Table structure for table `intervencija` */

DROP TABLE IF EXISTS `intervencija`;

CREATE TABLE `intervencija` (
  `IntervencijaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DatumVremePocetka` datetime NOT NULL,
  `DatumVremeZavrsetka` datetime DEFAULT NULL,
  `Opis` varchar(255) NOT NULL,
  `AngazovanjeIzvodjacaRadova` tinyint(1) NOT NULL,
  `Cena` decimal(10,2) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `VrstaIntervencijeID` int(10) unsigned NOT NULL,
  `StambenaZajednicaID` int(10) unsigned NOT NULL,
  `UpravnikID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`IntervencijaID`),
  KEY `VrstaIntervencijeID` (`VrstaIntervencijeID`),
  KEY `StambenaZajednicaID` (`StambenaZajednicaID`),
  KEY `UpravnikID` (`UpravnikID`),
  CONSTRAINT `intervencija_ibfk_1` FOREIGN KEY (`VrstaIntervencijeID`) REFERENCES `vrstaintervencije` (`VrstaIntervencijeID`),
  CONSTRAINT `intervencija_ibfk_2` FOREIGN KEY (`StambenaZajednicaID`) REFERENCES `stambenazajednica` (`StambenaZajednicaID`),
  CONSTRAINT `intervencija_ibfk_3` FOREIGN KEY (`UpravnikID`) REFERENCES `upravnik` (`UpravnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `intervencija` */

insert  into `intervencija`(`IntervencijaID`,`DatumVremePocetka`,`DatumVremeZavrsetka`,`Opis`,`AngazovanjeIzvodjacaRadova`,`Cena`,`Status`,`VrstaIntervencijeID`,`StambenaZajednicaID`,`UpravnikID`) values (1,'2021-08-19 09:00:00',NULL,'Godisnji servis',1,'12000.00','Ceka',1,1,1),(2,'2021-08-20 11:00:00',NULL,'Ciscenje ulaza zgrade',1,'10000.00','Aktivna',5,2,1),(3,'2021-08-21 11:00:00','2021-08-21 13:00:00','Servis lifta (sredjivanje okna)',0,'20000.00','Zavrsena',3,3,1),(4,'2021-08-22 10:00:00',NULL,'Servis agregata (rezervno napajanje)',1,'8000.00','Aktivna',4,4,2),(5,'2021-08-23 09:00:00','2021-08-23 11:00:00','Ciscenje ulaza',1,'9500.00','Zavrsena',5,5,2),(6,'2021-08-24 08:00:00','2021-08-24 11:00:00','Zamena LED sijalica u hodniku',0,'2000.00','Zavrsena',2,6,2),(7,'2021-08-01 00:00:00',NULL,'Avgust - Upravljanje SZ Jove Ilica 154',0,'30000.00','Aktivna',6,1,1),(8,'2021-08-01 00:00:00',NULL,'Avgust - Upravljanje SZ Maksima Gorkog 21',0,'30000.00','Aktivna',6,2,1),(9,'2021-08-01 00:00:00',NULL,'Avgust - Upravljanje SZ Takovska 20',0,'30000.00','Aktivna',6,3,1),(10,'2021-08-01 00:00:00',NULL,'Avgust - Upravljanje SZ Nehruova 11',0,'25000.00','Aktivna',6,4,2),(11,'2021-08-01 00:00:00',NULL,'Avgust - Upravljanje SZ Jurija Gagarina 10',0,'25000.00','Aktivna',6,5,2),(12,'2021-08-01 00:00:00',NULL,'Avgust - Upravljanje SZ Milutina Milankovica 37b',0,'25000.00','Aktivna',6,6,2);

/*Table structure for table `stambenazajednica` */

DROP TABLE IF EXISTS `stambenazajednica`;

CREATE TABLE `stambenazajednica` (
  `StambenaZajednicaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) NOT NULL,
  `Adresa` varchar(255) NOT NULL,
  `Mesto` varchar(100) NOT NULL,
  `UpravnikID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`StambenaZajednicaID`),
  KEY `UpravnikID` (`UpravnikID`),
  CONSTRAINT `stambenazajednica_ibfk_1` FOREIGN KEY (`UpravnikID`) REFERENCES `upravnik` (`UpravnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `stambenazajednica` */

insert  into `stambenazajednica`(`StambenaZajednicaID`,`Naziv`,`Adresa`,`Mesto`,`UpravnikID`) values (1,'SZ Jove Ilica 154','Jove Ilica 154','Beograd',1),(2,'SZ Maksima Gorkog 21','Maksima Gorkog 21','Beograd',1),(3,'SZ Takovska 20','Takovska 20','Beograd',1),(4,'SZ Nehruova 11','Nehruova 11','Beograd',2),(5,'SZ Jurija Gagarina 10','Jurija Gagarina 10','Beograd',2),(6,'SZ Milutina Milankovica 37b','Milutina Milankovica 37b','Beograd',2);

/*Table structure for table `upravnik` */

DROP TABLE IF EXISTS `upravnik`;

CREATE TABLE `upravnik` (
  `UpravnikID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(255) NOT NULL,
  `Prezime` varchar(255) NOT NULL,
  `KorisnickoIme` varchar(50) NOT NULL,
  `Lozinka` varchar(50) NOT NULL,
  PRIMARY KEY (`UpravnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `upravnik` */

insert  into `upravnik`(`UpravnikID`,`Ime`,`Prezime`,`KorisnickoIme`,`Lozinka`) values (1,'Ana','Antic','ana','ana1'),(2,'Marko','Markovic','marko','marko1');

/*Table structure for table `vrstaintervencije` */

DROP TABLE IF EXISTS `vrstaintervencije`;

CREATE TABLE `vrstaintervencije` (
  `VrstaIntervencijeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivVrste` varchar(255) NOT NULL,
  PRIMARY KEY (`VrstaIntervencijeID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `vrstaintervencije` */

insert  into `vrstaintervencije`(`VrstaIntervencijeID`,`NazivVrste`) values (1,'Servis PP aparata i hidranata'),(2,'Popravka  elektro instalacija'),(3,'Odrzavanje lifta'),(4,'Odrzavanje agregata'),(5,'Ciscenje'),(6,'Upravljanje stambenom zajednicom');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
