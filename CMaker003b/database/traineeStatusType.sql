-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 30, 2014 at 01:27 AM
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
-- Table structure for table `traineeStatusType`
--

CREATE TABLE IF NOT EXISTS `traineeStatusType` (
  `traineeStatusTypeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `traineeStatusTypeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`traineeStatusTypeID`),
  UNIQUE KEY `ix030` (`traineeStatusTypeName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `traineeStatusType`
--

INSERT INTO `traineeStatusType` (`traineeStatusTypeID`, `traineeStatusTypeName`) VALUES
(2, 'Dishounourable Discharge'),
(5, 'Dropped Out'),
(3, 'Registered'),
(4, 'Successful Completion'),
(1, 'Suspended');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
