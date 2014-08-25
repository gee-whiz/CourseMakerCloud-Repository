-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 30, 2014 at 01:33 AM
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
-- Table structure for table `trainingClassCourse`
--

CREATE TABLE IF NOT EXISTS `trainingClassCourse` (
  `trainingClassCourseID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courseID` int(10) unsigned NOT NULL,
  `trainingClassID` int(10) unsigned NOT NULL,
  `dateUpdated` datetime DEFAULT NULL,
  `priorityFlag` int(11) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  PRIMARY KEY (`trainingClassCourseID`),
  UNIQUE KEY `trainingClassID` (`trainingClassID`,`courseID`),
  KEY `ixop` (`courseID`),
  KEY `ixop2` (`trainingClassID`),
  KEY `fkop` (`courseID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=85 ;

--
-- Dumping data for table `trainingClassCourse`
--

INSERT INTO `trainingClassCourse` (`trainingClassCourseID`, `courseID`, `trainingClassID`, `dateUpdated`, `priorityFlag`, `startDate`, `endDate`) VALUES
(1, 2, 1, '2013-10-01 00:00:00', 1, NULL, NULL),
(2, 3, 1, '2013-10-01 00:00:00', 2, NULL, NULL),
(3, 4, 1, '2013-10-01 00:00:00', 3, NULL, NULL),
(4, 5, 1, '2013-10-01 00:00:00', 4, NULL, NULL),
(5, 6, 1, '2013-10-01 00:00:00', 5, NULL, NULL),
(6, 7, 1, '2013-10-01 00:00:00', 6, NULL, NULL),
(7, 8, 1, '2013-10-01 00:00:00', 7, NULL, NULL),
(8, 9, 1, '2013-10-01 00:00:00', 8, NULL, NULL),
(9, 10, 1, '2013-10-01 00:00:00', 9, NULL, NULL),
(12, 2, 2, '2013-10-02 00:00:00', 1, NULL, NULL),
(13, 3, 2, '2013-10-02 00:00:00', 2, NULL, NULL),
(14, 4, 2, '2013-10-02 00:00:00', 3, NULL, NULL),
(15, 5, 2, '2013-10-02 00:00:00', 4, NULL, NULL),
(16, 6, 2, '2013-10-02 00:00:00', 5, NULL, NULL),
(17, 7, 2, '2013-10-02 00:00:00', 6, NULL, NULL),
(18, 8, 2, '2013-10-02 00:00:00', 7, NULL, NULL),
(19, 9, 2, '2013-10-02 00:00:00', 8, NULL, NULL),
(20, 10, 2, '2013-10-02 00:00:00', 9, NULL, NULL),
(22, 3, 3, '2014-02-03 01:29:56', NULL, NULL, NULL),
(23, 4, 3, '2014-02-03 01:29:56', NULL, NULL, NULL),
(24, 8, 3, '2014-02-03 01:29:56', NULL, NULL, NULL),
(25, 6, 3, '2014-02-03 01:29:56', NULL, NULL, NULL),
(26, 9, 3, '2014-02-03 01:29:56', NULL, NULL, NULL),
(27, 5, 3, '2014-02-03 01:29:56', NULL, NULL, NULL),
(28, 2, 3, '2014-02-03 01:29:56', NULL, NULL, NULL),
(29, 7, 3, '2014-02-03 01:29:56', NULL, NULL, NULL),
(30, 4, 4, '2014-02-03 01:30:59', NULL, NULL, NULL),
(31, 2, 4, '2014-02-03 01:30:59', NULL, NULL, NULL),
(32, 3, 4, '2014-02-03 01:30:59', NULL, NULL, NULL),
(33, 6, 4, '2014-02-03 01:31:59', NULL, NULL, NULL),
(34, 9, 5, '2014-02-03 01:44:14', NULL, NULL, NULL),
(35, 6, 5, '2014-02-03 01:44:14', NULL, NULL, NULL),
(36, 5, 5, '2014-02-03 01:44:14', NULL, NULL, NULL),
(37, 4, 5, '2014-02-03 01:44:14', NULL, NULL, NULL),
(38, 3, 5, '2014-02-03 01:56:03', NULL, NULL, NULL),
(39, 9, 6, '2014-02-03 02:08:36', NULL, NULL, NULL),
(40, 4, 6, '2014-02-03 02:08:36', NULL, NULL, NULL),
(41, 5, 6, '2014-02-03 02:08:36', NULL, NULL, NULL),
(42, 6, 6, '2014-02-03 02:08:36', NULL, NULL, NULL),
(43, 8, 6, '2014-02-03 02:08:36', NULL, NULL, NULL),
(44, 3, 6, '2014-02-03 02:08:36', NULL, NULL, NULL),
(45, 10, 6, '2014-02-03 02:08:36', NULL, NULL, NULL),
(46, 2, 6, '2014-02-03 02:08:36', NULL, NULL, NULL),
(47, 7, 6, '2014-02-03 02:08:36', NULL, NULL, NULL),
(48, 5, 9, '2014-02-03 03:02:05', NULL, NULL, NULL),
(49, 7, 9, '2014-02-03 03:02:05', NULL, NULL, NULL),
(50, 9, 9, '2014-02-03 03:02:05', NULL, NULL, NULL),
(51, 6, 9, '2014-02-03 03:02:05', NULL, NULL, NULL),
(52, 10, 9, '2014-02-03 03:02:05', NULL, NULL, NULL),
(53, 8, 9, '2014-02-03 03:02:05', NULL, NULL, NULL),
(54, 4, 9, '2014-02-03 03:13:27', NULL, NULL, NULL),
(55, 9, 8, '2014-02-03 03:18:46', NULL, NULL, NULL),
(56, 3, 8, '2014-02-03 03:18:46', NULL, NULL, NULL),
(57, 8, 8, '2014-02-03 03:18:46', NULL, NULL, NULL),
(58, 10, 8, '2014-02-03 03:18:46', NULL, NULL, NULL),
(59, 6, 8, '2014-02-03 03:18:46', NULL, NULL, NULL),
(60, 5, 8, '2014-02-03 03:18:46', NULL, NULL, NULL),
(61, 4, 8, '2014-02-03 03:18:46', NULL, NULL, NULL),
(63, 2, 8, '2014-02-03 03:18:46', NULL, NULL, NULL),
(64, 7, 8, '2014-02-03 03:18:46', NULL, NULL, NULL),
(65, 14, 1, '2014-03-02 16:48:04', NULL, NULL, NULL),
(66, 15, 1, '2014-03-02 18:11:16', NULL, NULL, NULL),
(67, 14, 2, '2014-03-02 20:00:49', NULL, NULL, NULL),
(68, 15, 2, '2014-03-02 20:00:49', NULL, NULL, NULL),
(69, 10, 4, '2014-03-03 08:26:04', NULL, NULL, NULL),
(70, 8, 4, '2014-03-03 08:26:04', NULL, NULL, NULL),
(72, 7, 4, '2014-03-03 08:26:04', NULL, NULL, NULL),
(73, 9, 4, '2014-03-03 08:26:04', NULL, NULL, NULL),
(74, 14, 4, '2014-03-03 08:26:28', NULL, NULL, NULL),
(75, 15, 4, '2014-03-03 08:26:28', NULL, NULL, NULL),
(77, 15, 3, '2014-03-03 08:43:46', NULL, NULL, NULL),
(78, 14, 3, '2014-03-03 08:43:46', NULL, NULL, NULL),
(79, 16, 1, '2014-03-03 09:06:38', NULL, NULL, NULL),
(80, 16, 2, '2014-03-04 16:05:48', NULL, NULL, NULL),
(81, 5, 4, '2014-03-24 22:12:38', NULL, NULL, NULL),
(82, 16, 4, '2014-03-24 22:12:38', NULL, NULL, NULL),
(83, 16, 3, '2014-03-24 22:22:04', NULL, NULL, NULL),
(84, 10, 3, '2014-03-24 22:22:04', NULL, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trainingClassCourse`
--
ALTER TABLE `trainingClassCourse`
  ADD CONSTRAINT `trainingClassCourse_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`),
  ADD CONSTRAINT `trainingClassCourse_ibfk_2` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
