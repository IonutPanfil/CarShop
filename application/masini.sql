-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for masini
CREATE DATABASE IF NOT EXISTS `masini` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `masini`;

-- Dumping structure for table masini.auto
CREATE TABLE IF NOT EXISTS `auto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `denumire` varchar(50) DEFAULT NULL,
  `anFab` varchar(50) DEFAULT NULL,
  `capacitateMotor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table masini.auto: ~4 rows (approximately)
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
REPLACE INTO `auto` (`id`, `denumire`, `anFab`, `capacitateMotor`) VALUES
	(1, 'Civic Sedan 2014', '2014', '2.0'),
	(2, 'Civic 5D 2021', '2021', '3.0'),
	(3, 'Civic Sedan 2021', '2021', '4.6'),
	(4, 'HR-V 2021', '2009', '3.2');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;

-- Dumping structure for table masini.consultant_raport
CREATE TABLE IF NOT EXISTS `consultant_raport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idConsultant` int(11) DEFAULT NULL,
  `raport` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_consultant_raport_conturi` (`idConsultant`),
  CONSTRAINT `FK_consultant_raport_conturi` FOREIGN KEY (`idConsultant`) REFERENCES `conturi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table masini.consultant_raport: ~1 rows (approximately)
/*!40000 ALTER TABLE `consultant_raport` DISABLE KEYS */;
REPLACE INTO `consultant_raport` (`id`, `idConsultant`, `raport`) VALUES
	(1, 3, 'In acest raport'),
	(3, 3, 'In ziua asta khg');
/*!40000 ALTER TABLE `consultant_raport` ENABLE KEYS */;

-- Dumping structure for table masini.conturi
CREATE TABLE IF NOT EXISTS `conturi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `passworD` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tip` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table masini.conturi: ~3 rows (approximately)
/*!40000 ALTER TABLE `conturi` DISABLE KEYS */;
REPLACE INTO `conturi` (`id`, `username`, `passworD`, `email`, `tip`) VALUES
	(1, 'adm', 'admin', 'admin@ad.com', 'admin'),
	(2, 'user', 'pass', 'user@mail.com', 'client'),
	(3, 'cons', 'pasc', 'cons@mail.com', 'consultant');
/*!40000 ALTER TABLE `conturi` ENABLE KEYS */;

-- Dumping structure for table masini.tranzactii
CREATE TABLE IF NOT EXISTS `tranzactii` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAuto` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `pret` int(11) DEFAULT NULL,
  `data` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tranzactii_auto` (`idAuto`),
  KEY `FK_tranzactii_conturi` (`idClient`),
  CONSTRAINT `FK_tranzactii_auto` FOREIGN KEY (`idAuto`) REFERENCES `auto` (`id`),
  CONSTRAINT `FK_tranzactii_conturi` FOREIGN KEY (`idClient`) REFERENCES `conturi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table masini.tranzactii: ~1 rows (approximately)
/*!40000 ALTER TABLE `tranzactii` DISABLE KEYS */;
REPLACE INTO `tranzactii` (`id`, `idAuto`, `idClient`, `pret`, `data`) VALUES
	(1, 2, 2, 10000, '20.10.2020'),
	(2, 1, 2, 10000, '2021-01-15');
/*!40000 ALTER TABLE `tranzactii` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
