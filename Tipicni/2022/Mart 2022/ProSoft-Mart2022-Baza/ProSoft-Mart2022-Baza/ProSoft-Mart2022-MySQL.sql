/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.17-MariaDB : Database - prosoftmart22
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftmart22` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `prosoftmart22`;

/*Table structure for table `delo` */

DROP TABLE IF EXISTS `delo`;

CREATE TABLE `delo` (
  `DeloID` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`DeloID`)
) ENGINE=INNODB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `delo` */

INSERT  INTO `delo`(`DeloID`,`Naziv`) VALUES (1,'Klasici'),(2,'BEMUS podijum mladih'),(3,'Dečja soba'),(4,'Antigona'),(5,'Legenda o hrabrosti'),(6,'S ove strane muzike'),(7,'Kao da sam te sanjao'),(8,'Crvenkapa');

/*Table structure for table `festival` */

DROP TABLE IF EXISTS `festival`;

CREATE TABLE `festival` (
  `FestivalID` BIGINT(20) UNSIGNED NOT NULL,
  `Naziv` VARCHAR(255) NOT NULL,
  `DatumOd` DATE NOT NULL,
  `DatumDo` DATE NOT NULL,
  `Opis` VARCHAR(500) NOT NULL,
  `Korisnik` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`FestivalID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `festival` */

insert  into `festival`(`FestivalID`,`Naziv`,`DatumOd`,`DatumDo`,`Opis`,`Korisnik`) values (1,'BELEF 2022','2022-07-01','2022-07-11','Beogradski letnji festival',NULL),(2,'BEMUS 2022','2022-11-01','2022-11-11','Beogradske muzičke svečanosti',NULL),(3,'BEKUS 2022','2022-03-31','2022-04-07','Beogradske kulturne svečanosti',NULL);

/*Table structure for table `izvodjenje` */

DROP TABLE IF EXISTS `izvodjenje`;

CREATE TABLE `izvodjenje` (
  `FestivalID` bigint(20) unsigned NOT NULL,
  `DeloID` bigint(20) unsigned NOT NULL,
  `DatumVremePocetka` date NOT NULL,
  `DatumVremeKraja` date NOT NULL,
  `Sala` varchar(255) NOT NULL,
  PRIMARY KEY (`FestivalID`,`DeloID`),
  KEY `DeloID` (`DeloID`),
  CONSTRAINT `izvodjenje_ibfk_1` FOREIGN KEY (`FestivalID`) REFERENCES `festival` (`FestivalID`),
  CONSTRAINT `izvodjenje_ibfk_2` FOREIGN KEY (`DeloID`) REFERENCES `delo` (`DeloID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `izvodjenje` */

/*Table structure for table `koncert` */

DROP TABLE IF EXISTS `koncert`;

CREATE TABLE `koncert` (
  `DeloID` bigint(20) unsigned NOT NULL,
  `Izvodjac` varchar(255) NOT NULL,
  `Program` varchar(500) NOT NULL,
  PRIMARY KEY (`DeloID`),
  CONSTRAINT `koncert_ibfk_1` FOREIGN KEY (`DeloID`) REFERENCES `delo` (`DeloID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `koncert` */

insert  into `koncert`(`DeloID`,`Izvodjac`,`Program`) values (1,'Nemanja Radulović','Glinka, Prokofjev, Rahmanjinov'),(2,'Petar Pejčić, Natalija Mladenović','Šubert, Kasado, Pjacola'),(3,'Muzičko opersko teatarska organizacija MOTO','Opera Dečja soba Milenka Živkovića');

/*Table structure for table `predstava` */

DROP TABLE IF EXISTS `predstava`;

CREATE TABLE `predstava` (
  `DeloID` bigint(20) unsigned NOT NULL,
  `Reditelj` varchar(255) NOT NULL,
  `Podela` varchar(500) NOT NULL,
  `Size` varchar(500) NOT NULL,
  PRIMARY KEY (`DeloID`),
  CONSTRAINT `predstava_ibfk_1` FOREIGN KEY (`DeloID`) REFERENCES `delo` (`DeloID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `predstava` */

insert  into `predstava`(`DeloID`,`Reditelj`,`Podela`,`Size`) values (4,'Lenka Udovički','Antigona - Maja Izetbegović, Izmena - Dženana Džanić, Kreont - Rade Šerbedžija','Predstava scenski ispituje mitsku priču iz Sofokleovog komada'),(5,'Mateja Popović','Krungla - Vaja Dujović, Nemezi - Anđela Jovanović, Gljinko Alkrah - Ivan Mihajlović','U sebičnoj i nesebičnoj poteri protagonista i antagonista za onim za čime žude obrađena je ideja morala i pravih vrednosti'),(6,'Nevena Ivanović','Hor Dečjeg kulturnog centra u Beogradu','Muzička predstava približava tonove i odnose među njima deci'),(7,'Dragana Draganić','Vladan Savić, Kristina Savić, Uroš Ranković','Predstava je zamišljena kao muzičko-poetsko veče, protagonosti u formi monologa govore i pevaju stihove poznatih srpskih i svetskih pesnika'),(8,'Sonja Knežević','Crvenkapa - Zlatija Ivanović-Ocokoljić, Baka i mama - Sonja Knežević, Vuk - Dejan Stojaković','Priča o poverenju i prijateljstvu');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
