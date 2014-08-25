-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:26 AM
-- Server version: 5.6.12
-- PHP Version: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `coursemaker-prod`
--

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE IF NOT EXISTS `province` (
  `provinceID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `countryID` int(10) unsigned DEFAULT NULL,
  `provinceName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`provinceID`),
  UNIQUE KEY `index3` (`countryID`,`provinceName`),
  KEY `ix88` (`countryID`),
  KEY `fg008` (`countryID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`provinceID`, `countryID`, `provinceName`) VALUES
(9, 3, 'Eastern Cape'),
(5, 3, 'Free State'),
(3, 3, 'Gauteng'),
(4, 3, 'Kwa Zulu Natal'),
(1, 3, 'Limpopo'),
(6, 3, 'Mpumalanga'),
(7, 3, 'North West'),
(2, 3, 'Northern Cape'),
(8, 3, 'Western Cape');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `province`
--
ALTER TABLE `province`
  ADD CONSTRAINT `province_ibfk_1` FOREIGN KEY (`countryID`) REFERENCES `country` (`countryID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
