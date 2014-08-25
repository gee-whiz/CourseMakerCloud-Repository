-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 30, 2014 at 01:23 AM
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
-- Table structure for table `inventory`
--

CREATE TABLE IF NOT EXISTS `inventory` (
  `inventoryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `equipmentID` int(10) unsigned NOT NULL,
  `serialNumber` varchar(45) NOT NULL,
  `dateRegistered` datetime DEFAULT NULL,
  `conditionFlag` int(11) DEFAULT NULL,
  `dateUpdated` datetime DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `yearPurchased` int(11) DEFAULT NULL,
  `administratorID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`inventoryID`),
  UNIQUE KEY `index4` (`serialNumber`),
  KEY `fkijh` (`equipmentID`),
  KEY `index5` (`administratorID`),
  KEY `fkadmnss` (`administratorID`),
  KEY `iinvx` (`equipmentID`,`serialNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=50 ;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`inventoryID`, `equipmentID`, `serialNumber`, `dateRegistered`, `conditionFlag`, `dateUpdated`, `model`, `yearPurchased`, `administratorID`) VALUES
(1, 2, '999999999', '2014-02-19 00:00:00', NULL, NULL, 'Samsung Tab 3', 2014, 1),
(2, 2, '888888888', '2014-02-19 00:00:00', NULL, NULL, 'Samsung Tab 10.1', 2014, 1),
(3, 2, '67676767676', '2014-02-19 00:00:00', NULL, NULL, 'HTC Flyer 7"', NULL, 1),
(4, 2, '07t87876787655', '2014-02-19 00:00:00', NULL, NULL, 'Samsung Tab 3', 2013, 1),
(5, 2, '46765496587', '2014-02-20 00:00:00', NULL, NULL, 'Samsung Tab 3', 2013, 1),
(6, 2, '965876987986', '2014-02-20 00:00:00', NULL, NULL, 'Samsung Tab 3', 2014, 1),
(7, 2, 'hfjhgfhf6776', '2014-02-20 00:00:00', NULL, NULL, 'Samsung Tab 7', 2014, 1),
(8, 2, '8278hiu34p987', '2014-02-19 00:00:00', NULL, NULL, 'Samsung Tab 7', 2014, 1),
(9, 2, '0827972744323', '2014-02-19 00:00:00', NULL, NULL, 'Samsung Tab 7', 2014, 1),
(17, 9, 'u765865876t', '2014-02-20 00:00:00', NULL, NULL, 'Galaxy S2', 2012, 1),
(18, 9, '54ujfj6576t8g', '2014-02-20 00:00:00', NULL, NULL, 'Galaxy SIII', 2012, 1),
(19, 9, '6376497694', '2014-02-20 00:00:00', NULL, NULL, 'Galaxy S2', 2012, 1),
(20, 9, '865238658765', '2014-02-20 00:00:00', NULL, NULL, 'Galaxy S4', 2013, 1),
(21, 9, '5364746435735', '2014-02-20 00:00:00', NULL, NULL, 'Sony Experia Z', 2014, 1),
(22, 9, '7685876587', '2014-02-20 00:00:00', NULL, NULL, 'Sony Experia S', 2014, 1),
(23, 9, '679879879876', '2014-02-20 00:00:00', NULL, NULL, 'Galaxy S4', 2014, 1),
(24, 9, '42343243254', '2014-02-20 00:00:00', NULL, NULL, 'Galaxy SIII', 2013, 1),
(25, 9, '5757677DfZ', '2014-02-22 21:49:56', NULL, '2014-02-22 21:49:56', 'Samsung Galaxy Mini', 2012, 1),
(26, 9, 'T56576786SD', '2014-02-22 21:51:13', NULL, '2014-02-22 21:51:13', 'HTC One X', 2014, 1),
(27, 9, 'T566777AW66', '2014-02-22 21:53:36', NULL, '2014-02-22 21:53:36', 'HTC Desire', 2014, 1),
(28, 9, 'T6767866777', '2014-02-22 21:54:13', NULL, '2014-02-22 21:54:13', 'LG Pro', 2014, 1),
(29, 9, 'Z5746567868', '2014-02-23 07:24:34', NULL, '2014-02-23 07:24:34', 'ZTE Ascend', 2014, 1),
(30, 9, 'X57577667243', '2014-02-23 07:43:49', NULL, '2014-02-23 07:43:49', 'Xiaomi Redmi', 2014, 1),
(31, 104, 'G7677668cvvg7878', '2014-02-28 05:58:14', NULL, '2014-02-28 05:58:14', 'Galaxy S4', 2014, 17),
(32, 104, 'H5646567757766', '2014-02-28 06:01:22', NULL, '2014-02-28 06:01:22', 'HTC One', 2014, 17),
(33, 104, '4567546556556', '2014-02-28 06:02:21', NULL, '2014-02-28 06:02:21', 'Sony Experia S', 2014, 17),
(34, 104, 'G676877766755', '2014-02-28 06:22:43', NULL, '2014-02-28 06:22:43', 'Galaxy S4', 2014, 17),
(35, 104, 'G465656566', '2014-02-28 08:18:20', NULL, '2014-02-28 08:18:20', 'Galaxy S4', 2014, 17),
(36, 104, 'G343056628477', '2014-02-28 08:20:00', NULL, '2014-02-28 08:20:00', 'Galaxy S3', 2014, 17),
(37, 104, 'X2648385674657', '2014-02-28 08:20:50', NULL, '2014-02-28 08:20:50', 'Xiaomi Redmi', 2014, 17),
(38, 104, 'G6779787567532', '2014-02-28 08:21:39', NULL, '2014-02-28 08:21:39', 'Galaxy S3', 2014, 17),
(39, 104, 'S5724457067656', '2014-02-28 08:23:12', NULL, '2014-02-28 08:23:12', 'Sony Experia Z', 2014, 17),
(40, 104, 'S677775654555', '2014-02-28 08:23:51', NULL, '2014-02-28 08:23:51', 'Sony Experia Z', 2014, 17),
(41, 108, 'H568888464577', '2014-03-01 01:30:53', NULL, '2014-03-01 01:30:53', 'HTC Flyer', 2014, 17),
(42, 108, 'G478886766454', '2014-03-01 01:32:53', NULL, '2014-03-01 01:32:53', 'Galaxy Tab 7', 2014, 17),
(43, 9, 'X568664566678', '2014-03-01 01:46:02', NULL, '2014-03-01 01:46:02', 'Xiaomi Redmi', 2014, 1),
(44, 6, 'DX9675656667', '2014-03-01 01:50:37', NULL, '2014-03-01 01:50:37', 'Dell Server', 2013, 1),
(45, 9, 'Hdbdhdbdhdbdhd', '2014-03-11 12:01:33', NULL, '2014-03-11 12:01:33', 'Sony Xperia Z2', 2014, NULL),
(46, 109, '354084052214877', '2014-03-17 12:42:37', NULL, '2014-03-17 12:42:37', 'Samsung Ativ S', 2013, 18),
(47, 109, '351939053251165', '2014-03-17 12:45:22', NULL, '2014-03-17 12:45:34', 'Nokia Lumia 900', 2012, 18),
(48, 110, '53738927266', '2014-03-17 13:12:08', NULL, '2014-03-17 13:12:08', 'Nokia Asha 306', 2013, 18),
(49, 112, 'Fghbcfbnj', '2014-04-01 00:27:43', NULL, '2014-04-01 00:27:43', 'Test', 2014, 22);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`equipmentID`) REFERENCES `equipment` (`equipmentID`),
  ADD CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
