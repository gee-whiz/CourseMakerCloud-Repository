-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:38 AM
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
-- Table structure for table `instructor`
--

CREATE TABLE IF NOT EXISTS `instructor` (
  `instructorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cellphone` varchar(45) NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `cityID` int(10) unsigned NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `companyID` int(10) unsigned NOT NULL,
  `activeFlag` int(11) DEFAULT NULL,
  `administratorID` int(10) unsigned DEFAULT NULL,
  `GCMRegistrationID` text,
  PRIMARY KEY (`instructorID`),
  UNIQUE KEY `index6` (`email`),
  KEY `ixc09` (`cityID`),
  KEY `fkc09` (`cityID`),
  KEY `ixc010` (`companyID`),
  KEY `fkc010` (`companyID`),
  KEY `ix09p` (`administratorID`),
  KEY `fkc011x` (`administratorID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`instructorID`, `firstName`, `lastName`, `email`, `cellphone`, `dateRegistered`, `cityID`, `password`, `companyID`, `activeFlag`, `administratorID`, `GCMRegistrationID`) VALUES
(12, 'Ronnelle', 'Makhubela', 'aubrey@mlab.co.za', '0125668899', '2013-11-17 23:54:46', 1, 'exqd$583', 1, NULL, NULL, NULL),
(13, 'Gwen Marianne', 'Ramokgopa', 'malengatiger@gmail.com', '0712193543', '2013-11-18 00:08:46', 1, 'dgpl#382', 1, NULL, NULL, NULL),
(14, 'Tsietsi Frank', 'Malenga', 'tsietsi.m@gmail.com', '0856699898', '2014-02-16 19:48:17', 1, NULL, 1, NULL, NULL, NULL),
(15, 'Obakeng ', 'Matlhoko', 'obby.matlhoko@gmail.com', '0844685723', '2014-02-16 20:12:55', 1, 'ssdr#354', 1, NULL, NULL, NULL),
(16, 'Aubrey', 'Malabie', 'aubrey.malabie@gmail.com', '0712193543', '2014-02-16 20:20:01', 1, 'bxuf@417', 1, NULL, NULL, NULL),
(17, 'Joey', 'Charles', 'cjchar@gmail.com', '0996653232', '2014-02-26 22:21:15', 2, 'kdxf@745', 25, NULL, NULL, NULL),
(18, 'Aubrey', 'Malabie', 'instructor.m@gmail.com', '0712195623', '2014-02-28 05:55:47', 2, 'tmms@214', 27, NULL, NULL, NULL),
(19, 'Rulani', 'Nevhufumba', 'rulani@mlab.co.za', '0760940604', '2014-03-12 10:28:07', 2, 'r123', 28, NULL, NULL, NULL),
(20, 'Mixo', 'Ngoveni', '4otune@gmail.com', '0736521188', '2014-03-12 10:46:19', 2, ' ', 28, NULL, NULL, NULL),
(21, 'Khathu', 'Mulalo', 'rulanho@gmail.com', '0821234567', '2014-03-12 17:53:00', 2, ' ', 28, NULL, NULL, NULL),
(22, 'Jonathan', 'Zinstructor', 'zins.j@gmail.com', '0885562233', '2014-03-15 23:57:03', 1, ' ', 1, NULL, NULL, NULL),
(24, 'Melvin', 'Hackersen', 'mel.hack@gmail.com', '0996639966', '2014-03-19 10:21:01', 1, 'thka$528', 1, NULL, NULL, NULL),
(25, 'Test 1.1', 'Instructor 1.1', 'instructor1@gmail.com', '0125694578', '2014-03-31 23:40:34', 1, NULL, 1, NULL, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `instructor`
--
ALTER TABLE `instructor`
  ADD CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`cityID`) REFERENCES `city` (`cityID`),
  ADD CONSTRAINT `instructor_ibfk_2` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`),
  ADD CONSTRAINT `instructor_ibfk_3` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
