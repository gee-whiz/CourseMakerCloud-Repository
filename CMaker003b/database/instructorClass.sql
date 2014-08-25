-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 01, 2014 at 03:04 PM
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
-- Table structure for table `instructorClass`
--

CREATE TABLE IF NOT EXISTS `instructorClass` (
  `instructorClassID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `instructorID` int(10) unsigned NOT NULL,
  `trainingClassID` int(10) unsigned NOT NULL,
  `dateRegistered` datetime NOT NULL,
  PRIMARY KEY (`instructorClassID`),
  UNIQUE KEY `instructorID_2` (`instructorID`,`trainingClassID`),
  KEY `instructorID` (`instructorID`),
  KEY `trainingClassID` (`trainingClassID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=40 ;

--
-- Dumping data for table `instructorClass`
--

INSERT INTO `instructorClass` (`instructorClassID`, `instructorID`, `trainingClassID`, `dateRegistered`) VALUES
(3, 13, 1, '2013-11-18 00:00:00'),
(4, 13, 2, '2013-11-05 06:00:00'),
(5, 13, 3, '2014-03-03 06:45:32'),
(6, 13, 4, '2014-03-03 06:59:08'),
(7, 13, 7, '2014-03-03 06:59:27'),
(8, 13, 9, '2014-03-03 07:00:02'),
(9, 15, 1, '2014-03-03 07:35:48'),
(10, 15, 2, '2014-03-03 07:36:01'),
(11, 15, 3, '2014-03-03 07:36:13'),
(12, 15, 4, '2014-03-03 07:36:20'),
(13, 13, 8, '2014-03-03 08:18:43'),
(14, 16, 1, '2014-03-03 20:19:30'),
(15, 14, 6, '2014-03-11 11:42:29'),
(16, 16, 2, '2014-03-15 19:27:29'),
(17, 16, 4, '2014-03-15 20:36:26'),
(18, 14, 1, '2014-03-16 10:56:20'),
(23, 22, 8, '2014-03-16 14:18:26'),
(24, 22, 10, '2014-03-16 14:18:33'),
(25, 22, 9, '2014-03-16 14:18:39'),
(26, 12, 3, '2014-03-18 16:38:18'),
(27, 12, 1, '2014-03-18 16:38:25'),
(28, 22, 1, '2014-03-19 09:21:31'),
(29, 22, 2, '2014-03-19 09:21:51'),
(30, 22, 4, '2014-03-19 09:21:59'),
(31, 22, 7, '2014-03-19 09:30:57'),
(32, 24, 6, '2014-03-19 10:40:13'),
(33, 24, 5, '2014-03-19 10:40:25'),
(34, 24, 10, '2014-03-19 10:42:47'),
(35, 24, 7, '2014-03-20 02:06:46'),
(36, 12, 8, '2014-03-20 13:52:16'),
(37, 16, 3, '2014-03-24 22:19:42'),
(38, 25, 29, '2014-03-31 23:59:09'),
(39, 25, 9, '2014-03-31 23:59:34');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `instructorClass`
--
ALTER TABLE `instructorClass`
  ADD CONSTRAINT `instructorClass_ibfk_1` FOREIGN KEY (`instructorID`) REFERENCES `instructor` (`instructorID`),
  ADD CONSTRAINT `instructorClass_ibfk_2` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
