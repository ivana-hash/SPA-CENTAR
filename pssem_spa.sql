/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 8.0.35 : Database - pssem_spa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pssem_spa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `pssem_spa`;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `idKlijent` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prezime` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `emailAdresa` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kontaktTelefon` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idStatus` int NOT NULL,
  PRIMARY KEY (`idKlijent`),
  UNIQUE KEY `uq_klijent_email` (`emailAdresa`),
  KEY `fk_klijent_status` (`idStatus`),
  CONSTRAINT `fk_klijent_status` FOREIGN KEY (`idStatus`) REFERENCES `status` (`idStatus`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `klijent` */

insert  into `klijent`(`idKlijent`,`ime`,`prezime`,`emailAdresa`,`kontaktTelefon`,`idStatus`) values 
(1,'Milica','Petrović','milica.petrovic@gmail.com','0641112223',1),
(2,'Jovana','Jovanović','jovana.jovanovic@gmail.com','0652223334',2),
(3,'Ana','Nikolić','ana.nikolic@gmail.com','0633334445',3),
(4,'Marija','Marković','marija.markovic@gmail.com','0624445556',4),
(5,'Teodora','Stojanović','teodora.stojanovic@gmail.com','0615556667',1),
(6,'novi','klijent','novi@gmail.com','061234555',1);

/*Table structure for table `kvalifikacija` */

DROP TABLE IF EXISTS `kvalifikacija`;

CREATE TABLE `kvalifikacija` (
  `idKvalifikacija` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `opis` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idKvalifikacija`),
  UNIQUE KEY `uq_kvalifikacija_naziv` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `kvalifikacija` */

insert  into `kvalifikacija`(`idKvalifikacija`,`naziv`,`opis`) values 
(1,'Sertifikovani maser','Obuka za izvođenje različitih vrsta masaža'),
(2,'Kozmetičar','Obuka za profesionalne kozmetičke tretmane'),
(3,'Fizioterapeut','Stručna kvalifikacija iz oblasti fizioterapije'),
(4,'Spa menadžer','Upravljanje spa centrom i organizacija rada'),
(5,'Manikir i pedikir','Obuka za profesionalni manikir i pedikir');

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `idRadnik` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prezime` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `datumZaposlenja` date NOT NULL,
  `pozicija` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `korisnickoIme` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sifra` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idRadnik`),
  UNIQUE KEY `uq_radnik_korisnicko_ime` (`korisnickoIme`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `radnik` */

insert  into `radnik`(`idRadnik`,`ime`,`prezime`,`datumZaposlenja`,`pozicija`,`korisnickoIme`,`sifra`) values 
(1,'Jelena','Ilić','2022-03-15','Recepcioner','jelena','jelena123'),
(2,'Nikola','Pavlović','2021-06-10','Maser','nikola','nikola123'),
(3,'Sara','Đorđević','2023-02-01','Kozmetičar','sara','sara123'),
(4,'Marko','Milošević','2020-09-20','Menadžer','marko','marko123');

/*Table structure for table `radnikkvalifikacija` */

DROP TABLE IF EXISTS `radnikkvalifikacija`;

CREATE TABLE `radnikkvalifikacija` (
  `idRadnik` int NOT NULL,
  `idKvalifikacija` int NOT NULL,
  `datumPostizanja` date NOT NULL,
  PRIMARY KEY (`idRadnik`,`idKvalifikacija`),
  KEY `fk_radnikkvalifikacija_kvalifikacija` (`idKvalifikacija`),
  CONSTRAINT `fk_radnikkvalifikacija_kvalifikacija` FOREIGN KEY (`idKvalifikacija`) REFERENCES `kvalifikacija` (`idKvalifikacija`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_radnikkvalifikacija_radnik` FOREIGN KEY (`idRadnik`) REFERENCES `radnik` (`idRadnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `radnikkvalifikacija` */

insert  into `radnikkvalifikacija`(`idRadnik`,`idKvalifikacija`,`datumPostizanja`) values 
(2,1,'2020-05-10'),
(2,3,'2021-02-15'),
(3,2,'2022-11-20'),
(3,5,'2023-01-10'),
(4,4,'2019-06-01');

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `idRezervacija` int NOT NULL AUTO_INCREMENT,
  `ukupanIznos` decimal(10,2) NOT NULL,
  `datumKreiranja` date NOT NULL,
  `idRadnik` int NOT NULL,
  `idKlijent` int NOT NULL,
  PRIMARY KEY (`idRezervacija`),
  KEY `fk_rezervacija_radnik` (`idRadnik`),
  KEY `fk_rezervacija_klijent` (`idKlijent`),
  CONSTRAINT `fk_rezervacija_klijent` FOREIGN KEY (`idKlijent`) REFERENCES `klijent` (`idKlijent`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_rezervacija_radnik` FOREIGN KEY (`idRadnik`) REFERENCES `radnik` (`idRadnik`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `chk_rezervacija_iznos` CHECK ((`ukupanIznos` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`idRezervacija`,`ukupanIznos`,`datumKreiranja`,`idRadnik`,`idKlijent`) values 
(1,8500.00,'2026-08-25',1,1),
(2,5000.00,'2026-08-26',1,2),
(3,4500.00,'2026-08-27',4,3),
(4,6800.00,'2026-08-28',1,4),
(5,3500.00,'2026-08-30',1,2);

/*Table structure for table `status` */

DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `idStatus` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `datumPostizanja` date NOT NULL,
  `pogodnosti` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `status` */

insert  into `status`(`idStatus`,`naziv`,`datumPostizanja`,`pogodnosti`) values 
(1,'Standardni','2026-01-01','Osnovni pristup svim tretmanima'),
(2,'Srebrni','2026-01-01','Popust od 10% na izabrane tretmane'),
(3,'Zlatni','2026-01-01','Popust od 20% i prioritetno zakazivanje'),
(4,'VIP','2026-01-01','Popust od 25%, prioritetno zakazivanje i besplatne konsultacije');

/*Table structure for table `stavkarezervacije` */

DROP TABLE IF EXISTS `stavkarezervacije`;

CREATE TABLE `stavkarezervacije` (
  `idRezervacija` int NOT NULL,
  `rb` int NOT NULL,
  `cena` decimal(10,2) NOT NULL,
  `brojPaketaTretmana` int NOT NULL,
  `iznosStavke` decimal(10,2) NOT NULL,
  `idTretman` int NOT NULL,
  PRIMARY KEY (`idRezervacija`,`rb`),
  KEY `fk_stavkarezervacije_tretman` (`idTretman`),
  CONSTRAINT `fk_stavkarezervacije_rezervacija` FOREIGN KEY (`idRezervacija`) REFERENCES `rezervacija` (`idRezervacija`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stavkarezervacije_tretman` FOREIGN KEY (`idTretman`) REFERENCES `tretman` (`idTretman`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `chk_stavka_broj_paketa` CHECK ((`brojPaketaTretmana` > 0)),
  CONSTRAINT `chk_stavka_cena` CHECK ((`cena` >= 0)),
  CONSTRAINT `chk_stavka_iznos` CHECK ((`iznosStavke` >= 0)),
  CONSTRAINT `chk_stavka_rb` CHECK ((`rb` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `stavkarezervacije` */

insert  into `stavkarezervacije`(`idRezervacija`,`rb`,`cena`,`brojPaketaTretmana`,`iznosStavke`,`idTretman`) values 
(1,1,3500.00,2,7000.00,1),
(1,2,1500.00,1,1500.00,4),
(2,1,2800.00,1,2800.00,3),
(2,2,2200.00,1,2200.00,5),
(3,1,1500.00,3,4500.00,4),
(4,1,4200.00,1,4200.00,2),
(4,2,2600.00,1,2600.00,6),
(5,1,3500.00,1,3500.00,1);

/*Table structure for table `tretman` */

DROP TABLE IF EXISTS `tretman`;

CREATE TABLE `tretman` (
  `idTretman` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cena` decimal(10,2) NOT NULL,
  `trajanjeUMin` int NOT NULL,
  `benefitiTretmana` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idTretman`),
  UNIQUE KEY `uq_tretman_naziv` (`naziv`),
  CONSTRAINT `chk_tretman_cena` CHECK ((`cena` >= 0)),
  CONSTRAINT `chk_tretman_trajanje` CHECK ((`trajanjeUMin` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `tretman` */

insert  into `tretman`(`idTretman`,`naziv`,`cena`,`trajanjeUMin`,`benefitiTretmana`) values 
(1,'Relax masaža',3500.00,60,'Smanjuje stres i opušta mišiće'),
(2,'Sportska masaža',4200.00,60,'Smanjuje napetost i ubrzava oporavak mišića'),
(3,'Tretman lica',2800.00,45,'Čisti, hidrira i osvežava kožu lica'),
(4,'Sauna',1500.00,30,'Podstiče cirkulaciju i detoksikaciju organizma'),
(5,'Manikir',2200.00,45,'Nega noktiju i kože ruku'),
(6,'Pedikir',2600.00,60,'Nega stopala i noktiju'),
(7,'Aromaterapija',3000.00,50,'Opuštanje pomoću prirodnih eteričnih ulja');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
