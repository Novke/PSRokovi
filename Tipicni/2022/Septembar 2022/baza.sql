/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.24-MariaDB : Database - septembar2022ari
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`septembar2022ari` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `septembar2022ari`;

/*Table structure for table `komponenta` */

DROP TABLE IF EXISTS `komponenta`;

CREATE TABLE `komponenta` (
  `KomponentaID` bigint(10) NOT NULL,
  `Naziv` varchar(50) DEFAULT NULL,
  `Opis` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`KomponentaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `komponenta` */

insert  into `komponenta`(`KomponentaID`,`Naziv`,`Opis`) values 
(1,'Sasija','Opis 1'),
(2,'Motor Diesel','Opis 2'),
(3,'Gume','Opis 3'),
(4,'Instrument tabla','Opis 4');

/*Table structure for table `prevoznosredstvo` */

DROP TABLE IF EXISTS `prevoznosredstvo`;

CREATE TABLE `prevoznosredstvo` (
  `PrevoznoSredstvoID` bigint(10) NOT NULL AUTO_INCREMENT,
  `Model` varchar(50) DEFAULT NULL,
  `DatumVremePocetka` datetime DEFAULT NULL,
  `DatumVremeZavrsetka` datetime DEFAULT NULL,
  `OcekivaniRadniVek` int(7) DEFAULT NULL,
  `Rukovodilac` varchar(50) DEFAULT NULL,
  `TipPrevoznogSredstva` varchar(50) DEFAULT NULL,
  `ProizvodniPogonID` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`PrevoznoSredstvoID`),
  KEY `fk_pp_id` (`ProizvodniPogonID`),
  CONSTRAINT `fk_pp_id` FOREIGN KEY (`ProizvodniPogonID`) REFERENCES `proizvodnipogon` (`ProizvodniPogonID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `prevoznosredstvo` */

insert  into `prevoznosredstvo`(`PrevoznoSredstvoID`,`Model`,`DatumVremePocetka`,`DatumVremeZavrsetka`,`OcekivaniRadniVek`,`Rukovodilac`,`TipPrevoznogSredstva`,`ProizvodniPogonID`) values 
(1,'Model 1','2022-09-10 00:37:00','2022-10-10 18:00:00',10,'ari','Automobil',1),
(2,'Model 1','2022-09-10 00:47:00','2022-10-10 18:00:00',10,'ari','Automobil',1),
(3,'Model 1','2022-09-10 00:47:00','2022-10-10 18:00:00',10,'ari','Kombi',1),
(4,'Model 1','2022-09-13 21:23:00','2022-10-10 18:00:00',10,'ari','Automobil',1);

/*Table structure for table `proizvodnipogon` */

DROP TABLE IF EXISTS `proizvodnipogon`;

CREATE TABLE `proizvodnipogon` (
  `ProizvodniPogonID` bigint(10) NOT NULL,
  `Naziv` varchar(50) DEFAULT NULL,
  `Adresa` varbinary(50) DEFAULT NULL,
  PRIMARY KEY (`ProizvodniPogonID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `proizvodnipogon` */

insert  into `proizvodnipogon`(`ProizvodniPogonID`,`Naziv`,`Adresa`) values 
(1,'Pogon Kosmaj','Adresa 1'),
(2,'Pogon Golija','Adresa 2'),
(3,'Pogon Tara','Adresa 3');

/*Table structure for table `stavkaprevoznogsredstva` */

DROP TABLE IF EXISTS `stavkaprevoznogsredstva`;

CREATE TABLE `stavkaprevoznogsredstva` (
  `PrevoznoSredstvoID` bigint(10) NOT NULL,
  `Rb` int(7) NOT NULL,
  `Kolicina` int(7) DEFAULT NULL,
  `Kontrolisano` tinyint(1) DEFAULT NULL,
  `KomponentaID` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`PrevoznoSredstvoID`,`Rb`),
  KEY `fk_komponenta_id` (`KomponentaID`),
  CONSTRAINT `fk_komponenta_id` FOREIGN KEY (`KomponentaID`) REFERENCES `komponenta` (`KomponentaID`),
  CONSTRAINT `fk_ps_id` FOREIGN KEY (`PrevoznoSredstvoID`) REFERENCES `prevoznosredstvo` (`PrevoznoSredstvoID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavkaprevoznogsredstva` */

insert  into `stavkaprevoznogsredstva`(`PrevoznoSredstvoID`,`Rb`,`Kolicina`,`Kontrolisano`,`KomponentaID`) values 
(1,1,1,0,1),
(1,2,1,0,2),
(1,3,2,0,3),
(2,1,1,0,1),
(2,2,1,0,2),
(3,1,1,0,1),
(3,2,1,0,2),
(4,1,1,0,1),
(4,2,1,0,2),
(4,3,1,0,3),
(4,4,1,0,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
