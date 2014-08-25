-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:41 AM
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
-- Table structure for table `trainingClass`
--

CREATE TABLE IF NOT EXISTS `trainingClass` (
  `trainingClassID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `trainingClassName` varchar(100) NOT NULL,
  `companyID` int(10) unsigned NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `administratorID` int(10) unsigned NOT NULL,
  `isOpen` int(11) DEFAULT NULL,
  `calendarID` int(11) DEFAULT NULL,
  PRIMARY KEY (`trainingClassID`),
  KEY `fktcc` (`companyID`),
  KEY `fk1ad` (`administratorID`),
  KEY `fktrcla` (`administratorID`),
  KEY `ixtcc` (`companyID`,`trainingClassName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Dumping data for table `trainingClass`
--

INSERT INTO `trainingClass` (`trainingClassID`, `trainingClassName`, `companyID`, `startDate`, `endDate`, `administratorID`, `isOpen`, `calendarID`) VALUES
(1, 'Famous First Intake', 1, '2013-10-01 00:00:00', '2014-09-30 00:00:00', 1, 1, NULL),
(2, 'Second Intake 2014', 1, '2014-01-10 00:00:00', '2014-09-30 00:00:00', 1, 1, NULL),
(3, 'Fun Hacks Club', 1, '2014-02-02 15:55:08', '2014-07-30 15:55:08', 1, 1, NULL),
(4, 'Dead Trees Society', 1, '2014-02-02 15:57:22', '2014-03-02 15:57:22', 1, 1, NULL),
(5, 'The Legion Of Code', 1, '2014-06-02 16:21:26', '2014-11-30 16:21:26', 1, 1, NULL),
(6, 'Super Coders United', 1, '2014-08-02 16:45:35', '2015-01-31 16:45:35', 1, 1, NULL),
(7, 'Crazy Code Society', 1, '2014-02-02 17:15:55', '2015-02-02 17:15:55', 1, 1, NULL),
(8, 'Glory Seekers', 1, '2014-02-13 17:17:33', '2015-03-02 17:17:33', 1, 1, NULL),
(9, 'The Sorcerers', 1, '2014-02-02 18:14:16', '2015-02-02 18:14:16', 1, 1, NULL),
(10, 'The Best Hackers 2014', 1, '2014-02-15 23:45:45', '2015-02-15 23:45:45', 1, 1, NULL),
(12, 'The Code Slingers', 25, '2014-04-28 22:16:13', '2015-02-26 22:16:13', 14, 1, NULL),
(13, 'The Crazy Hacking Club', 25, '2014-03-01 08:48:34', '2015-01-26 08:48:34', 14, 1, NULL),
(14, 'Freaky Coders', 25, '2014-02-27 11:59:58', '2014-04-27 11:59:58', 14, 1, NULL),
(15, 'Last Train Bangers', 25, '2014-02-27 12:08:12', '2014-06-30 12:08:12', 14, 1, NULL),
(16, 'Winter Blues Devs', 25, '2014-06-27 12:14:11', '2015-02-27 12:14:11', 14, 1, NULL),
(17, 'Great Teamsters', 25, '2014-06-27 12:16:47', '2015-02-27 12:16:47', 14, 1, NULL),
(18, 'Coders Africa', 25, '2014-07-27 12:23:45', '2015-02-27 12:23:45', 14, 1, NULL),
(19, 'Brilliant Dev United', 25, '2014-07-27 12:27:54', '2015-02-27 12:27:54', 14, 1, NULL),
(20, 'Original Hacker Team', 27, '2014-02-27 21:06:58', '2015-06-27 21:06:58', 17, 1, NULL),
(21, 'Keyboard Stars', 27, '2014-02-26 21:18:43', '2014-07-25 21:18:43', 17, 1, NULL),
(22, 'Ladies Only HackTeam', 27, '2014-02-17 21:19:59', '2014-07-25 21:19:59', 17, 1, NULL),
(23, 'Viral Coders', 27, '2014-03-01 17:24:52', '2014-05-28 17:24:52', 17, 1, NULL),
(24, 'Daring United', 27, '2014-03-01 01:39:55', '2014-05-01 01:39:55', 17, 1, NULL),
(25, 'Creating First APP', 28, '2014-03-12 16:26:17', '2014-03-26 16:26:17', 18, 1, NULL),
(26, 'Test', 28, '2014-03-25 18:26:23', '2014-04-02 18:26:23', 18, 1, NULL),
(27, 'Tiger Hack United', 1, '2014-04-01 00:00:00', '2014-06-27 00:00:00', 1, 1, NULL),
(28, 'Test Class 1', 1, '2014-04-14 09:34:15', '2014-10-27 09:34:15', 22, 0, NULL),
(29, 'Test 2', 1, '2014-04-15 22:35:56', '2014-10-28 22:35:56', 22, 1, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trainingClass`
--
ALTER TABLE `trainingClass`
  ADD CONSTRAINT `trainingClass_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`),
  ADD CONSTRAINT `trainingClass_ibfk_2` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
