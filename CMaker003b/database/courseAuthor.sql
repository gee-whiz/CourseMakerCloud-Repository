-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 30, 2014 at 01:19 AM
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
-- Table structure for table `courseAuthor`
--

CREATE TABLE IF NOT EXISTS `courseAuthor` (
  `courseAuthorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courseID` int(10) unsigned NOT NULL,
  `authorID` int(10) unsigned NOT NULL,
  `dateUpdated` datetime NOT NULL,
  PRIMARY KEY (`courseAuthorID`),
  UNIQUE KEY `index6` (`courseID`,`authorID`),
  KEY `zx77` (`courseID`),
  KEY `fk78` (`authorID`),
  KEY `index5` (`authorID`),
  KEY `fk7878` (`courseID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `courseAuthor`
--

INSERT INTO `courseAuthor` (`courseAuthorID`, `courseID`, `authorID`, `dateUpdated`) VALUES
(2, 2, 1, '2013-10-11 21:06:34'),
(3, 3, 1, '2013-10-11 23:45:52'),
(4, 4, 1, '2013-10-12 01:12:09'),
(5, 5, 1, '2013-10-12 01:15:24'),
(6, 6, 1, '2013-10-12 10:28:47'),
(7, 7, 1, '2013-10-12 10:29:27'),
(8, 8, 1, '2013-10-12 10:30:15'),
(9, 9, 1, '2013-10-12 10:31:39'),
(10, 10, 1, '2013-10-12 14:33:51'),
(15, 14, 1, '2014-03-02 16:38:20'),
(16, 15, 1, '2014-03-02 18:07:18'),
(17, 16, 1, '2014-03-03 08:59:31'),
(18, 17, 13, '2014-03-12 16:54:02'),
(19, 18, 13, '2014-03-12 16:55:03'),
(20, 19, 13, '2014-03-12 16:57:45'),
(21, 20, 13, '2014-03-12 17:15:51'),
(22, 21, 13, '2014-03-12 17:24:15'),
(23, 22, 17, '2014-04-08 03:46:07');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `courseAuthor`
--
ALTER TABLE `courseAuthor`
  ADD CONSTRAINT `fk78` FOREIGN KEY (`authorID`) REFERENCES `author` (`authorID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk7878` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
