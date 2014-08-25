-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:34 AM
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
-- Table structure for table `company`
--

CREATE TABLE IF NOT EXISTS `company` (
  `companyID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `companyName` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `dateRegistered` datetime NOT NULL,
  `cityID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`companyID`),
  UNIQUE KEY `index4` (`cityID`,`companyName`),
  KEY `ixb01` (`cityID`),
  KEY `fkb01` (`cityID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`companyID`, `companyName`, `email`, `dateRegistered`, `cityID`) VALUES
(1, 'Boha Hacker Academy', 'malengadev@gmail.com', '2013-10-11 15:04:50', 1),
(25, 'Bernie Hackers', 'malengatiger@gmail.com', '2014-02-26 22:12:28', 2),
(27, 'CodeTribe Academy', 'aubrey@mlab.co.za', '2014-02-27 13:52:37', 2),
(28, 'Rulani Group', 'rulani@mlab.co.za', '2014-03-12 10:02:00', 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `fkb01` FOREIGN KEY (`cityID`) REFERENCES `city` (`cityID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
