-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:37 AM
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
-- Table structure for table `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `administratorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `companyID` int(10) unsigned NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cellphone` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `activeFlag` int(11) DEFAULT NULL,
  `superUserFlag` int(11) DEFAULT NULL,
  `GCMRegistrationID` text,
  PRIMARY KEY (`administratorID`),
  UNIQUE KEY `index4` (`email`),
  KEY `ixtx00` (`companyID`),
  KEY `fktcx00` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`administratorID`, `companyID`, `firstName`, `lastName`, `email`, `cellphone`, `password`, `dateRegistered`, `activeFlag`, `superUserFlag`, `GCMRegistrationID`) VALUES
(1, 1, 'Aubrey Vincent', 'Malabie', 'malengadev@gmail.com', '0712193543', 'kktiger3', '2013-10-11 15:04:50', NULL, 1, NULL),
(2, 1, 'Mixo F', 'Fortune', 'mixo.f@gmail.com', '0886565623', 'bngi$412', '2014-02-17 22:51:04', NULL, NULL, NULL),
(14, 25, 'Bernande Post', 'Dreesburg', 'malengatiger@gmail.com', '0856633', 'dev', '2014-02-26 22:12:28', NULL, 1, NULL),
(15, 25, 'Daniella', 'Administrata', 'admnidan@gmail.com', '0889796565', 'epcv$135', '2014-02-26 23:43:21', NULL, NULL, NULL),
(16, 25, 'Thuli', 'Madonsela', 'thuli.m@gmail.com', '0774444333', 'mbhv#863', '2014-02-27 08:43:33', NULL, NULL, NULL),
(17, 27, 'Aubrey', 'Malabie', 'aubrey@mlab.co.za', '0712193543', 'dev', '2014-02-27 13:52:37', NULL, 1, NULL),
(18, 28, 'Rulani', 'Nevhufumba', 'rulani@mlab.co.za', '0760940604', 'r123', '2014-03-12 10:04:00', NULL, NULL, NULL),
(21, 1, 'Obakeng', 'Matlhoko', 'obby.matlhoko@gmail.com', '0996663333', 'mcmy#354', '2014-03-18 13:11:30', NULL, NULL, NULL),
(22, 1, 'Mark', 'von Famous', 'aubrey.coursemaker@gmail.com', '0885552323', 'hyif@158', '2014-03-18 13:16:52', NULL, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `fktcx00` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
