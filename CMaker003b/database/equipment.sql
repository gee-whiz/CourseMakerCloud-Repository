-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:48 AM
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
-- Table structure for table `equipment`
--

CREATE TABLE IF NOT EXISTS `equipment` (
  `equipmentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `equipmentName` varchar(100) DEFAULT NULL,
  `companyID` int(10) unsigned NOT NULL,
  `administratorID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`equipmentID`),
  UNIQUE KEY `companyID` (`companyID`,`equipmentName`),
  KEY `index3` (`companyID`),
  KEY `fktrc` (`companyID`),
  KEY `index5` (`administratorID`),
  KEY `jkad` (`administratorID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=113 ;

--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`equipmentID`, `equipmentName`, `companyID`, `administratorID`) VALUES
(1, 'Whiteboard', 1, 1),
(2, 'Tablet', 1, 1),
(3, 'Feature Phone', 1, 1),
(4, 'Desktop Computer', 1, 1),
(5, 'Laptop Computer', 1, 1),
(6, 'Server Computer', 1, 1),
(7, 'Stationery', 1, 1),
(8, 'WIFI Router', 1, 1),
(9, 'Smartphone', 1, 1),
(10, 'High Res Display Monitor', 1, 1),
(11, 'Projector', 1, 1),
(14, 'Laser Pointer', 1, 1),
(15, 'Television ', 1, 1),
(16, 'WiFi Range Extender', 1, 1),
(17, 'Smart Watch', 1, 1),
(87, 'Whiteboard', 25, 14),
(88, 'Display Monitor', 25, 14),
(89, 'Tablet', 25, 14),
(90, 'Laptop Computer', 25, 14),
(91, 'Projector', 25, 14),
(92, 'Smartphone', 25, 14),
(93, 'WIFI Router', 25, 14),
(94, 'Desktop Computer', 25, 14),
(95, 'Stationery', 25, 14),
(96, 'Server Computer', 25, 14),
(97, 'Feature Phone', 25, 14),
(98, 'Server Computer', 27, 17),
(99, 'Projector', 27, 17),
(100, 'Stationery', 27, 17),
(101, 'Feature Phone', 27, 17),
(102, 'Laptop Computer', 27, 17),
(103, 'Whiteboard', 27, 17),
(104, 'Smartphone', 27, 17),
(105, 'Display Monitor', 27, 17),
(106, 'Desktop Computer', 27, 17),
(107, 'WIFI Router', 27, 17),
(108, 'Tablet', 27, 17),
(109, 'Acardia Group', 28, 18),
(110, 'MLab', 28, 18),
(111, 'Huawei LTE Router', 1, 22),
(112, 'Test 1 Equipment 1', 1, 22);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `equipment`
--
ALTER TABLE `equipment`
  ADD CONSTRAINT `equipment_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`),
  ADD CONSTRAINT `equipment_ibfk_2` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
