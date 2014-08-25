-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:33 AM
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
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `categoryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) NOT NULL,
  `companyID` int(10) unsigned NOT NULL,
  `localID` bigint(20) DEFAULT NULL,
  `syncDate` datetime DEFAULT NULL,
  PRIMARY KEY (`categoryID`),
  UNIQUE KEY `idxs0` (`companyID`,`categoryName`),
  KEY `fks2` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryID`, `categoryName`, `companyID`, `localID`, `syncDate`) VALUES
(1, 'Android Development', 1, 1381496690874, NULL),
(2, 'Windows Phone Development', 1, 1381496690886, NULL),
(3, 'Database Development', 1, 1381496690878, NULL),
(4, 'Cloud Application Computing', 1, 1381496690867, NULL),
(5, 'Ubuntu Touch Development', 1, 1381496690894, NULL),
(6, 'Feature Phone Development optional', 1, 1381496690890, NULL),
(7, 'HTML5 App Development', 1, 1381496690882, NULL),
(9, 'Mobile Web Apps', 1, 1381565736508, NULL),
(10, 'Social Media Profile', 1, 1382120143883, NULL),
(11, 'Social Media Leverages', 1, 1382122356432, NULL),
(12, 'Test Category updated 1', 1, 1390994518790, NULL),
(13, 'Android', 28, 1394635870554, NULL),
(14, 'Test Ob 1', 1, 1396921203053, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
