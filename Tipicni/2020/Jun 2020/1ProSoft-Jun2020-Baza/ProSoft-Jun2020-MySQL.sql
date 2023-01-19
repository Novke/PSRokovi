/*
SQLyog Ultimate v9.50 
MySQL - 5.6.20 : Database - prosoftjun20
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftjun20` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prosoftjun20`;

/*Table structure for table `banka` */

DROP TABLE IF EXISTS `banka`;

CREATE TABLE `banka` (
  `BankaID` BIGINT(20) NOT NULL,
  `Naziv` VARCHAR(255) DEFAULT NULL,
  `Adresa` VARCHAR(255) DEFAULT NULL,
  `JedinstveniBrojPlatnogPrometa` INT(11) DEFAULT NULL,
  PRIMARY KEY (`BankaID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `banka` */

INSERT  INTO `banka`(`BankaID`,`Naziv`,`Adresa`,`JedinstveniBrojPlatnogPrometa`) VALUES (1,'Banka Postanska Stedionica','Kraljice Marije 3, Beograd',200),(2,'Komercijalna Banka','Svetog Save 14, Beograd',205),(3,'Raiffeisen Bank','Djordja Stanojevica 16, Novi Beograd',265),(4,'Banca Intesa','Milentija Popovica 7b, Novi Beograd',160),(5,'Mobi Banka','Omladinskih Brigada 88, Novi Beograd',115),(6,'UniCredit Bank','Rajiceva 27-29',170);

/*Table structure for table `kompanija` */

DROP TABLE IF EXISTS `kompanija`;

CREATE TABLE `kompanija` (
  `KompanijaID` BIGINT(20) NOT NULL,
  `Naziv` VARCHAR(255) DEFAULT NULL,
  `TipKompanije` VARCHAR(50) DEFAULT NULL,
  `PDVObveznik` TINYINT(1) DEFAULT NULL,
  `MaticniBroj` VARCHAR(10) DEFAULT NULL,
  `DatumVremeEvidentiranja` DATETIME DEFAULT NULL,
  `BrojZaposlenih` INT(11) DEFAULT NULL,
  `KorisnikID` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`KompanijaID`),
  KEY `KorisnikID` (`KorisnikID`),
  CONSTRAINT `kompanija_ibfk_1` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `kompanija` */

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `KorisnikID` BIGINT(11) NOT NULL,
  `Ime` VARCHAR(255) DEFAULT NULL,
  `Prezime` VARCHAR(255) DEFAULT NULL,
  `KorisnickoIme` VARCHAR(50) DEFAULT NULL,
  `Lozinka` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`KorisnikID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `korisnik` */

INSERT  INTO `korisnik`(`KorisnikID`,`Ime`,`Prezime`,`KorisnickoIme`,`Lozinka`) VALUES (1,'Ivana','Ivanovic','ivana','ivana123'),(2,'Dragan','Draganic','dragan','dragan123'),(3,'Jovana','Jovanic','jovana','jovana123'),(4,'Petar','Petrovic','petar','petar123');

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `ZaposleniID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(255) DEFAULT NULL,
  `Prezime` VARCHAR(255) DEFAULT NULL,
  `JMBG` VARCHAR(13) DEFAULT NULL,
  `ZiroRacun` VARCHAR(20) DEFAULT NULL,
  `Iznos` DECIMAL(10,2) DEFAULT NULL,
  `KompanijaID` BIGINT(20) DEFAULT NULL,
  `BankaID` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`ZaposleniID`),
  KEY `KompanijaID` (`KompanijaID`),
  KEY `BankaID` (`BankaID`),
  CONSTRAINT `zaposleni_ibfk_1` FOREIGN KEY (`KompanijaID`) REFERENCES `kompanija` (`KompanijaID`),
  CONSTRAINT `zaposleni_ibfk_2` FOREIGN KEY (`BankaID`) REFERENCES `banka` (`BankaID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `zaposleni` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
