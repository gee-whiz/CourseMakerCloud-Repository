-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:44 AM
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
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `courseID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `companyID` int(10) unsigned NOT NULL,
  `dateUpdated` datetime NOT NULL,
  `activeFlag` int(11) DEFAULT NULL,
  `categoryID` int(10) unsigned DEFAULT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  `description` text,
  `shareFlag` int(11) DEFAULT NULL,
  `localID` bigint(20) DEFAULT NULL,
  `syncDate` datetime DEFAULT NULL,
  PRIMARY KEY (`courseID`),
  UNIQUE KEY `index6aa` (`companyID`,`courseName`),
  KEY `ixd90` (`companyID`),
  KEY `fkd90` (`companyID`),
  KEY `index4` (`categoryID`),
  KEY `fkd91` (`categoryID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`courseID`, `companyID`, `dateUpdated`, `activeFlag`, `categoryID`, `courseName`, `description`, `shareFlag`, `localID`, `syncDate`) VALUES
(2, 1, '2013-10-11 21:06:33', NULL, 1, 'Development Tools Setup', 'This course unit prepares the trainee''s development machine and introduces the trainees to the environment and the frameworks available on local servers as well as on the Net. It is quite important that the tasks and activities be completed successfully. Progress will be significantly hindered if the tools are not set up right.', NULL, 1381518393425, NULL),
(3, 1, '2013-10-11 23:45:51', NULL, 1, 'User interface design', 'Beauty is more than skin deep. Android apps are sleek and aesthetically pleasing on multiple levels. Transitions are fast and clear; layout and typography are crisp and meaningful. App icons are works of art in their own right. Just like a well-made tool, your app should strive to combine beauty, simplicity and purpose to create a magical experience that is effortless and powerful.', NULL, 1381527953497, NULL),
(4, 1, '2013-10-12 01:12:08', NULL, 1, 'Location Dependent Apps', 'Beauty is more than skin deep. Android apps are sleek and aesthetically pleasing on multiple levels. Transitions are fast and clear; layout and typography are crisp and meaningful. App icons are works of art in their own right. Just like a well-made tool, your app should strive to combine beauty, simplicity and purpose to create a magical experience that is effortless and powerful.', NULL, 1381533130216, NULL),
(5, 1, '2013-10-12 01:15:24', NULL, 1, 'SQLite and Offline Operations', 'Beauty is more than skin deep. Android apps are sleek and aesthetically pleasing on multiple levels. Transitions are fast and clear; layout and typography are crisp and meaningful. App icons are works of art in their own right. Just like a well-made tool, your app should strive to combine beauty, simplicity and purpose to create a magical experience that is effortless and powerful.', NULL, 1381533326332, NULL),
(6, 1, '2013-10-12 10:28:47', NULL, 4, 'Amazon Web Services AWS', 'Android apps make life easier and are easy to understand. When people use your app for the first time, they should intuitively grasp the most important features. The design work doesn''t stop at the first use, though. Android apps remove ongoing chores like file management and syncing. Simple tasks never require complex procedures, and complex tasks are tailored to the human hand and mind. People of all ages and cultures feel firmly in control, and are never overwhelmed by too many choices or irrelevant flash.', NULL, 1381566529256, NULL),
(7, 1, '2013-10-12 10:29:27', NULL, 4, 'Microsoft Azure', 'Android apps make life easier and are easy to understand. When people use your app for the first time, they should intuitively grasp the most important features. The design work doesn''t stop at the first use, though. Android apps remove ongoing chores like file management and syncing. Simple tasks never require complex procedures, and complex tasks are tailored to the human hand and mind. People of all ages and cultures feel firmly in control, and are never overwhelmed by too many choices or irrelevant flash.', NULL, 1381566569532, NULL),
(8, 1, '2013-10-12 10:30:15', NULL, 4, 'Google Cloud Platform', 'Android apps make life easier and are easy to understand. When people use your app for the first time, they should intuitively grasp the most important features. The design work doesn''t stop at the first use, though. Android apps remove ongoing chores like file management and syncing. Simple tasks never require complex procedures, and complex tasks are tailored to the human hand and mind. People of all ages and cultures feel firmly in control, and are never overwhelmed by too many choices or irrelevant flash.', NULL, 1381566617225, NULL),
(9, 1, '2013-10-15 22:29:11', NULL, 4, 'BohaTMX Back End Platform Concepts', 'Android apps make life easier and are easy to understand. When people use your app for the first time, they should intuitively grasp the most important features. The design work doesn''t stop at the first use, though. Android apps remove ongoing chores like file management and syncing. Simple tasks never require complex procedures, and complex tasks are tailored to the human hand and mind. People of all ages and cultures feel firmly in control, and are never overwhelmed by too many choices or irrelevant flash.', NULL, 1381566701338, NULL),
(10, 1, '2013-10-12 14:33:50', NULL, 4, 'Cloud Performance Monitoring and Configuration', 'Real objects are more fun than buttons and menus\n\nAllow people to directly touch and manipulate objects in your app. It reduces the cognitive effort needed to perform a task while making it more emotionally satisfying.', NULL, 1381581232703, NULL),
(14, 1, '2014-03-02 16:38:20', NULL, 3, 'Data Models', 'Data modelling is the foundation for working with all kinds of data sets. The modelling process helps you understand your business or project and the data needed to support the initiative.', NULL, 1393771096056, NULL),
(15, 1, '2014-03-02 18:07:17', NULL, 3, 'MySQL Database', 'The course will use MySQL for most database operations', NULL, 1393776436771, NULL),
(16, 1, '2014-03-03 08:59:31', NULL, 3, 'CourseMaker Data Model', 'The data model for the CourseMaker forms the basis of all the data managed by the suite of mobile apps and the web application hosted in the cloud.', NULL, 1393829969603, NULL),
(17, 28, '2014-03-12 16:54:02', NULL, 13, 'Getting Started', 'Welcome to training for Android developers', NULL, NULL, NULL),
(18, 28, '2014-03-12 16:55:03', NULL, 13, 'Building your first app', 'Welcome to Android application development', NULL, NULL, NULL),
(19, 28, '2014-03-12 16:57:45', NULL, 13, 'Adding Action Bar', 'the action bar Is one of the most ', NULL, NULL, NULL),
(20, 28, '2014-03-12 17:15:51', NULL, 13, 'Building  your Fisrt App', 'This course teaches you how to build your first Android app. You''ll learn how to create and Android an Android project and run a debuggable version of the app.', NULL, NULL, NULL),
(21, 28, '2014-03-12 17:24:15', NULL, 13, 'Supporting Different Devices', 'This course teaches you how to use basic platform features that leverage alternative resources and other features so your app can provide an optimized user experience on variety of android-compatible devices, using a single application package (APK).', NULL, NULL, NULL),
(22, 1, '2014-04-08 03:46:07', NULL, 14, 'Test Ob 2', 'Test case from Ob 2', NULL, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `fkd90` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkd91` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
