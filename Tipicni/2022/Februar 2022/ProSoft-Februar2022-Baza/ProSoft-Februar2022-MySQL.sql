/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.17-MariaDB : Database - prosoftfeb22
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftfeb22` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `prosoftfeb22`;

/*Table structure for table `dnevnaproizvodnjaizvestaj` */

DROP TABLE IF EXISTS `dnevnaproizvodnjaizvestaj`;

CREATE TABLE `dnevnaproizvodnjaizvestaj` (
  `DnevnaProizvodnjaIzvestajID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Datum` date NOT NULL,
  `Opis` varchar(255) NOT NULL,
  `ProizvodjacID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`DnevnaProizvodnjaIzvestajID`),
  KEY `ProizvodjacID` (`ProizvodjacID`),
  CONSTRAINT `dnevnaproizvodnjaizvestaj_ibfk_1` FOREIGN KEY (`ProizvodjacID`) REFERENCES `proizvodjac` (`ProizvodjacID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `dnevnaproizvodnjaizvestaj` */

/*Table structure for table `dnevnaproizvodnjastavkaizvestaja` */

DROP TABLE IF EXISTS `dnevnaproizvodnjastavkaizvestaja`;

CREATE TABLE `dnevnaproizvodnjastavkaizvestaja` (
  `DnevnaProizvodnjaIzvestajID` bigint(20) unsigned NOT NULL,
  `RB` int(10) unsigned NOT NULL,
  `VrstaKapaciteta` varchar(50) NOT NULL,
  `Kolicina` decimal(10,2) NOT NULL,
  `JedinicaMere` varchar(50) NOT NULL,
  `Napomena` varchar(255) NOT NULL,
  PRIMARY KEY (`DnevnaProizvodnjaIzvestajID`,`RB`),
  CONSTRAINT `dnevnaproizvodnjastavkaizvestaja_ibfk_1` FOREIGN KEY (`DnevnaProizvodnjaIzvestajID`) REFERENCES `dnevnaproizvodnjaizvestaj` (`DnevnaProizvodnjaIzvestajID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `dnevnaproizvodnjastavkaizvestaja` */

/*Table structure for table `proizvodjac` */

DROP TABLE IF EXISTS `proizvodjac`;

CREATE TABLE `proizvodjac` (
  `ProizvodjacID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) NOT NULL,
  `Adresa` varchar(255) NOT NULL,
  `KorisnickoIme` varchar(50) NOT NULL,
  `Lozinka` varchar(50) NOT NULL,
  PRIMARY KEY (`ProizvodjacID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `proizvodjac` */

insert  into `proizvodjac`(`ProizvodjacID`,`Naziv`,`Adresa`,`KorisnickoIme`,`Lozinka`) values (1,'Elektroprivreda Srbije','Balkanska 13','eps','eps1'),(2,'Proizvodjac 1','Adresa 1','p1','p1'),(3,'Proizvodjac 2','Adresa 2','p2','p2'),(4,'Proizvodjac 3','Adresa 3','p3','p3'),(5,'Proizvodjac 4','Adresa 4','p4','p4'),(6,'Proizvodjac 5','Adresa 5','p5','p5');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
