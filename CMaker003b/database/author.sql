-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 30, 2014 at 01:18 AM
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
-- Table structure for table `author`
--

CREATE TABLE IF NOT EXISTS `author` (
  `authorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `dateRegistered` datetime DEFAULT NULL,
  `companyID` int(10) unsigned DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `activeFlag` int(11) DEFAULT NULL,
  `GCMRegistrationID` text,
  PRIMARY KEY (`authorID`),
  UNIQUE KEY `email` (`email`),
  KEY `index2` (`companyID`),
  KEY `fgcv` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`authorID`, `firstName`, `lastName`, `email`, `cellphone`, `dateRegistered`, `companyID`, `password`, `activeFlag`, `GCMRegistrationID`) VALUES
(1, 'Aubrey St Vincent', 'Malabie', 'malengadev@gmail.com', '0712193543', '2013-10-11 15:04:50', 1, 'dev', NULL, NULL),
(2, 'Malenga Tiger', 'Maxakadzi', 'malengatiger@gmail.com', '0712193543', '2013-10-16 00:00:00', 1, 'vvdi$741', NULL, NULL),
(3, 'Jimmy', 'Smith', 'aubrey@mlab.co.za', '0829996363', '2014-01-29 11:24:53', 1, 'ruxl@873', NULL, NULL),
(7, 'Daniella', 'Chauke', 'aubrey.malabie@gmail.com', '0875556663', '2014-01-29 12:09:28', 1, 'dev', NULL, NULL),
(8, 'Rembrandt', 'Van Rijn', 'rembrandt.vr@gmail.com', '0774556321', '2014-02-17 09:28:50', 1, 'smrf#473', NULL, NULL),
(11, 'Wendy', 'Writer', 'wendyw@gmail.com', '0965583232', '2014-02-26 22:22:40', 25, 'cdlm$582', NULL, NULL),
(12, 'Johnny', 'Author', 'j.author@gmail.com', '0986635252', '2014-02-28 05:56:40', 27, 'eeuq#625', NULL, NULL),
(13, 'Rulani', 'Nevhufumba', 'rulani@mlab.co.za', '0760940604', '2014-03-12 10:10:31', 28, 'r123', NULL, NULL),
(15, 'Mixo', 'Ngoveni', '4otune@gmail.com', '0786312453', '2014-03-12 19:22:07', 28, NULL, NULL, NULL),
(16, 'Nomakhepu', 'Goniwe', 'noms.gon@@gmsil.com', '0885523366', '2014-03-19 10:45:52', 1, 'ivuy$385', NULL, NULL),
(17, 'Obakeng', 'Matlhoko', 'obby.matlhoko@gmail.com', '0844685723', '2014-03-25 14:50:46', 1, 'nyvh@444', NULL, NULL),
(18, 'Test 1.1', 'Test 1.1', 'author@gmail.com', '0824692536', '2014-04-01 00:07:24', 1, NULL, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `author`
--
ALTER TABLE `author`
  ADD CONSTRAINT `fgcv` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
