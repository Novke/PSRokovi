/*
SQLyog Ultimate v9.50 
MySQL - 5.6.20 : Database - prosoftnov20
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftnov20` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prosoftnov20`;

/*Table structure for table `dogadjaj` */

DROP TABLE IF EXISTS `dogadjaj`;

CREATE TABLE `dogadjaj` (
  `DogadjajID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) DEFAULT NULL,
  `Opis` varchar(500) DEFAULT NULL,
  `DatumOd` datetime DEFAULT NULL,
  `DatumDo` datetime DEFAULT NULL,
  `TipDogadjaja` varchar(50) DEFAULT NULL,
  `KorisnikOrganizatorID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DogadjajID`),
  KEY `KorisnikOrganizatorID` (`KorisnikOrganizatorID`),
  CONSTRAINT `dogadjaj_ibfk_1` FOREIGN KEY (`KorisnikOrganizatorID`) REFERENCES `korisnik` (`KorisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `dogadjaj` */

insert  into `dogadjaj`(`DogadjajID`,`Naziv`,`Opis`,`DatumOd`,`DatumDo`,`TipDogadjaja`,`KorisnikOrganizatorID`) values (1,'IT projekat','Inicijalni sastanak','2020-11-22 11:00:00','2020-11-22 11:30:00','Sastanak',1);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `KorisnikID` bigint(20) NOT NULL,
  `Ime` varchar(255) DEFAULT NULL,
  `Prezime` varchar(255) DEFAULT NULL,
  `KorisnickoIme` varchar(50) DEFAULT NULL,
  `Lozinka` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`KorisnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `korisnik` */

insert  into `korisnik`(`KorisnikID`,`Ime`,`Prezime`,`KorisnickoIme`,`Lozinka`) values (1,'Marko','Markovic','marko','marko123'),(2,'Ivana','Ivanovic','ivana','ivana123'),(3,'Dragan','Draganic','dragan','dragan123'),(4,'Petra','Petrovic','petra','petra'),(5,'Dusan','Dusanic','dusan','dusan123'),(6,'Marija','Maric','marija','marija123');

/*Table structure for table `ucesce` */

DROP TABLE IF EXISTS `ucesce`;

CREATE TABLE `ucesce` (
  `DogadjajID` bigint(20) NOT NULL,
  `RB` bigint(20) NOT NULL,
  `OpisUcesca` varchar(500) DEFAULT NULL,
  `ObaveznoPrisustvo` tinyint(1) DEFAULT NULL,
  `KorisnikID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DogadjajID`,`RB`),
  KEY `KorisnikID` (`KorisnikID`),
  CONSTRAINT `ucesce_ibfk_1` FOREIGN KEY (`DogadjajID`) REFERENCES `dogadjaj` (`DogadjajID`),
  CONSTRAINT `ucesce_ibfk_2` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ucesce` */

insert  into `ucesce`(`DogadjajID`,`RB`,`OpisUcesca`,`ObaveznoPrisustvo`,`KorisnikID`) values (1,1,'Izrada zapisnika',1,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
