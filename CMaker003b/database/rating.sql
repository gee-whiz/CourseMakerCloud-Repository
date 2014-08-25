-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:39 AM
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
-- Table structure for table `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `ratingID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ratingName` varchar(50) DEFAULT NULL,
  `ratingNumber` int(11) DEFAULT NULL,
  `companyID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ratingID`),
  UNIQUE KEY `ix211` (`ratingName`),
  KEY `companyID` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`ratingID`, `ratingName`, `ratingNumber`, `companyID`) VALUES
(1, 'Very Good (80)', 80, 1),
(2, 'Excellent (100)', 100, 1),
(3, 'Fair (40)', 40, 1),
(4, 'Good (60)', 60, 1),
(5, 'Poor (20)', 20, 1),
(6, 'Did Not Present (0)', 0, 1),
(7, 'Beyond The Call Of Duty', 125, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
