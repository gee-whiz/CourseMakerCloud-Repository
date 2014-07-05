-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Jul 06, 2014 at 01:14 AM
-- Server version: 5.5.34
-- PHP Version: 5.5.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `coursemaker`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `activityID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `activityName` varchar(255) NOT NULL,
  `description` text,
  `courseID` int(10) unsigned NOT NULL,
  `priorityFlag` int(11) DEFAULT NULL,
  `localID` bigint(20) DEFAULT NULL,
  `syncDate` datetime DEFAULT NULL,
  `durationInDays` double DEFAULT NULL,
  PRIMARY KEY (`activityID`),
  KEY `ix011` (`courseID`),
  KEY `fxsds` (`courseID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=120 ;

--
-- Dumping data for table `activity`
--

INSERT INTO `activity` (`activityID`, `activityName`, `description`, `courseID`, `priorityFlag`, `localID`, `syncDate`, `durationInDays`) VALUES
(114, 'Register for developers'' account on the Google Cloud Platform', 'This account enables you to create access to Google API''s that are used by all your Android apps. It also allows you the ability to build Google App Engine or Google Compute applications', 26, 1, 1404123872270, NULL, 0),
(115, 'Set up initial Cloud Project', 'The initial project that will be the container for all related artifacts such as the API selections and the keys for Android apps.', 26, 2, 1404124104093, NULL, 0),
(116, 'Testing ', 'This account enables you to create access to Google API''s that are used by all your Android apps. It also allows you the ability to build Google App Engine or Google Compute applications', 25, 0, 1404125853716, NULL, 0),
(117, 'Create Android API keys', 'All Android apps that use Google Play Services API''s must have keys generated from within the developer console. ', 26, 4, 1404145433143, NULL, 0),
(118, 'Register Android developer account', 'In order to upload apps to the Google Play Store every developer needs to register an account.  At time of writing this account costs $25 and requires a credit card. ', 26, 3, 1404145740678, NULL, 0),
(119, 'Register developer account at Microsoft Azure', 'The development of Azure based applications requires a registered account.', 26, 5, 1404151310613, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `administratorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `companyID` int(10) unsigned NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cellphone` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `activeFlag` int(11) DEFAULT NULL,
  `superUserFlag` int(11) DEFAULT NULL,
  `GCMRegistrationID` text,
  PRIMARY KEY (`administratorID`),
  UNIQUE KEY `index4` (`email`),
  KEY `ixtx00` (`companyID`),
  KEY `fktcx00` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`administratorID`, `companyID`, `firstName`, `lastName`, `email`, `cellphone`, `password`, `dateRegistered`, `activeFlag`, `superUserFlag`, `GCMRegistrationID`) VALUES
(1, 1, 'Aubrey Vincent', 'Malabie', 'malengadev@gmail.com', '0712193543', 'kktiger3', '2013-10-11 15:04:50', 0, 1, NULL),
(2, 1, 'Mixo F', 'Fortune', 'mixo.f@gmail.com', '0886565623', 'bngi$412', '2014-02-17 22:51:04', 0, NULL, NULL),
(14, 25, 'Bernande Post', 'Dreesburg', 'malengatiger@gmail.com', '0856633', 'dev', '2014-02-26 22:12:28', 0, 1, NULL),
(15, 25, 'Daniella', 'Administrata', 'admnidan@gmail.com', '0889796565', 'epcv$135', '2014-02-26 23:43:21', 0, NULL, NULL),
(16, 25, 'Thuli', 'Madonsela', 'thuli.m@gmail.com', '0774444333', 'mbhv#863', '2014-02-27 08:43:33', 0, NULL, NULL),
(17, 27, 'Aubrey', 'Malabie', 'aubrey@mlab.co.za', '0712193543', 'dev', '2014-02-27 13:52:37', 0, 1, NULL),
(18, 28, 'Rulani', 'Nevhufumba', 'rulani@mlab.co.za', '0760940604', 'r123', '2014-03-12 10:04:00', 0, NULL, NULL),
(21, 1, 'Obakeng', 'Matlhoko', 'obby.matlhoko@gmail.com', '0996663333', 'mcmy#354', '2014-03-18 13:11:30', 0, NULL, NULL),
(22, 1, 'Mark', 'von Famous', 'aubrey.coursemaker@gmail.com', '0885552323', 'hyif@158', '2014-03-18 13:16:52', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `attendanceID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `trainingClassID` int(10) unsigned NOT NULL,
  `checkInDate` datetime NOT NULL,
  `checkOutDate` datetime NOT NULL,
  `checkInLatitude` double DEFAULT NULL,
  `checkInLongitude` double DEFAULT NULL,
  `checkOutLatitude` double DEFAULT NULL,
  `checkOutLongitude` double DEFAULT NULL,
  `traineeID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`attendanceID`),
  KEY `trainingClassID` (`trainingClassID`),
  KEY `traineeID` (`traineeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `authorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `dateRegistered` datetime DEFAULT NULL,
  `companyID` int(10) unsigned DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `activeFlag` int(11) DEFAULT NULL,
  `GCMRegistrationID` text,
  PRIMARY KEY (`authorID`),
  UNIQUE KEY `email` (`email`),
  KEY `index2` (`companyID`),
  KEY `fgcv` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`authorID`, `firstName`, `lastName`, `email`, `cellphone`, `dateRegistered`, `companyID`, `password`, `activeFlag`, `GCMRegistrationID`) VALUES
(1, 'Aubrey St Vincent', 'Malabie', 'malengadev@gmail.com', '0712193543', '2013-10-11 15:04:50', 1, 'dev', NULL, NULL),
(2, 'Malenga Tiger', 'Maxakadzi', 'malengatiger@gmail.com', '0712193543', '2013-10-16 00:00:00', 1, 'vvdi$741', NULL, NULL),
(3, 'Jimmy', 'Smith', 'aubrey@mlab.co.za', '0829996363', '2014-01-29 11:24:53', 1, 'ruxl@873', NULL, NULL),
(7, 'Daniella', 'Chauke', 'aubrey.malabie@gmail.com', '0875556663', '2014-01-29 12:09:28', 1, 'dev', NULL, NULL),
(8, 'Rembrandt', 'Van Rijn', 'rembrandt.vr@gmail.com', '0774556321', '2014-02-17 09:28:50', 1, 'smrf#473', NULL, NULL),
(11, 'Wendy', 'Writer', 'wendyw@gmail.com', '0965583232', '2014-02-26 22:22:40', 25, 'cdlm$582', NULL, NULL),
(12, 'Johnny', 'Author', 'j.author@gmail.com', '0986635252', '2014-02-28 05:56:40', 27, 'eeuq#625', NULL, NULL),
(13, 'Rulani', 'Nevhufumba', 'rulani@mlab.co.za', '0760940604', '2014-03-12 10:10:31', 28, 'r123', NULL, NULL),
(15, 'Mixo', 'Ngoveni', '4otune@gmail.com', '0786312453', '2014-03-12 19:22:07', 28, NULL, NULL, NULL),
(16, 'Nomakhepu', 'Goniwe', 'noms.gon@@gmsil.com', '0885523366', '2014-03-19 10:45:52', 1, 'ivuy$385', NULL, NULL),
(17, 'Obakeng', 'Matlhoko', 'obby.matlhoko@gmail.com', '0844685723', '2014-03-25 14:50:46', 1, 'nyvh@444', NULL, NULL),
(18, 'Test 1.1', 'Test 1.1', 'author@gmail.com', '0824692536', '2014-04-01 00:07:24', 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) NOT NULL,
  `companyID` int(10) unsigned NOT NULL,
  `localID` bigint(20) DEFAULT NULL,
  `syncDate` datetime DEFAULT NULL,
  PRIMARY KEY (`categoryID`),
  UNIQUE KEY `idxs0` (`companyID`,`categoryName`),
  KEY `fks2` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryID`, `categoryName`, `companyID`, `localID`, `syncDate`) VALUES
(1, 'Android Development', 1, 1381496690874, NULL),
(2, 'Windows Phone Development', 1, 1381496690886, NULL),
(3, 'Database Development', 1, 1381496690878, NULL),
(4, 'Cloud Application Computing', 1, 1381496690867, NULL),
(5, 'Ubuntu Touch Development', 1, 1381496690894, NULL),
(6, 'Feature Phone Development optional', 1, 1381496690890, NULL),
(7, 'HTML5 App Development', 1, 1381496690882, NULL),
(9, 'Mobile Web Apps', 1, 1381565736508, NULL),
(10, 'Social Media Profile', 1, 1382120143883, NULL),
(11, 'Social Media Leverages', 1, 1382122356432, NULL),
(12, 'Test Category updated 1', 1, 1390994518790, NULL),
(13, 'Android', 28, 1394635870554, NULL),
(14, 'Test Ob 1', 1, 1396921203053, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `cityID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `provinceID` int(10) unsigned DEFAULT NULL,
  `cityName` varchar(100) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`cityID`),
  UNIQUE KEY `index3` (`provinceID`,`cityName`),
  KEY `ix550` (`provinceID`),
  KEY `fk550` (`provinceID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=285 ;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`cityID`, `provinceID`, `cityName`, `latitude`, `longitude`) VALUES
(1, 3, 'Tshwane Metro', NULL, NULL),
(2, 3, 'Centurion', NULL, NULL),
(3, 3, 'Johannesburg', NULL, NULL),
(8, 3, 'Sandton', NULL, NULL),
(9, 3, 'Randfontein', NULL, NULL),
(10, 3, 'Midrand', NULL, NULL),
(11, 3, 'Alexandra', NULL, NULL),
(12, 3, 'Roodepoort', NULL, NULL),
(13, 3, 'Alberton', NULL, NULL),
(14, 3, 'Germiston', NULL, NULL),
(15, 3, 'Benoni', NULL, NULL),
(16, 3, 'Boksburg', NULL, NULL),
(17, 3, 'Mamelodi', NULL, NULL),
(18, 3, 'Daveyton', NULL, NULL),
(19, 3, 'Ekurhuleni Metro', NULL, NULL),
(20, 3, 'Kempton Park', NULL, NULL),
(21, 3, 'Tembisa', NULL, NULL),
(22, 3, 'Olifantsfontein', NULL, NULL),
(23, 3, 'Ga-Rankuwa', NULL, NULL),
(24, 3, 'Vereeniging', NULL, NULL),
(25, 3, 'Sedibeng District ', NULL, NULL),
(26, 3, 'Mogale City', NULL, NULL),
(27, 3, 'Krugersdorp', NULL, NULL),
(28, 3, 'Soweto', NULL, NULL),
(29, 1, 'Capricorn', NULL, NULL),
(30, 1, 'Musina', NULL, NULL),
(31, 1, 'Mokopane', NULL, NULL),
(32, 1, 'Seshego', NULL, NULL),
(33, 1, 'Thohoyandou', NULL, NULL),
(34, 1, 'Tzaneen', NULL, NULL),
(35, 1, 'Vhembe District', NULL, NULL),
(36, 1, 'Polokwane', NULL, NULL),
(37, 1, 'Modimolle', NULL, NULL),
(38, 1, 'Dendron', NULL, NULL),
(39, 1, 'Louis Trichardt', NULL, NULL),
(40, 1, 'Bela-Bela', NULL, NULL),
(41, 1, 'Mopani District', NULL, NULL),
(42, 1, 'Mookgophong', NULL, NULL),
(43, 1, 'Thabazimbi', NULL, NULL),
(44, 1, 'Sekhukhune', NULL, NULL),
(45, 1, 'Zebedeila', NULL, NULL),
(46, 4, 'Amajuba', NULL, NULL),
(47, 4, 'Charlestown', NULL, NULL),
(48, 4, 'Hattingspruit', NULL, NULL),
(49, 4, 'Madadeni', NULL, NULL),
(50, 4, 'Newcastle', NULL, NULL),
(51, 4, 'Utrecht', NULL, NULL),
(52, 4, 'eThekwini', NULL, NULL),
(53, 4, 'Amanzimtoti', NULL, NULL),
(54, 4, 'Cato Ridge', NULL, NULL),
(55, 4, 'Doonside', NULL, NULL),
(56, 4, 'Drummond', NULL, NULL),
(57, 4, 'Durban', NULL, NULL),
(58, 4, 'ekuPhakameni', NULL, NULL),
(59, 4, 'Hillcrest', NULL, NULL),
(60, 4, 'Kloof\r\n', NULL, NULL),
(61, 4, 'KwaMashu\r\n', NULL, NULL),
(62, 4, 'Queensburgh', NULL, NULL),
(63, 4, 'Pinetown', NULL, NULL),
(64, 4, 'Umhlanga Rocks', NULL, NULL),
(65, 4, 'Umlazi', NULL, NULL),
(66, 4, 'Chatsworth', NULL, NULL),
(67, 4, 'Umgababa', NULL, NULL),
(70, 4, 'iLembe', NULL, NULL),
(71, 4, 'Sisonke', NULL, NULL),
(72, 4, 'Bulwer', NULL, NULL),
(73, 4, 'Cedarville', NULL, NULL),
(74, 4, 'Franklin', NULL, NULL),
(75, 4, 'Himeville', NULL, NULL),
(76, 4, 'Ixopo', NULL, NULL),
(77, 4, 'Kokstad', NULL, NULL),
(78, 4, 'Umzimkulu', NULL, NULL),
(79, 4, 'Matatiele', NULL, NULL),
(80, 4, 'Underberg', NULL, NULL),
(81, 4, 'Ugu', NULL, NULL),
(82, 4, 'Harding', NULL, NULL),
(83, 4, 'Palm Beach', NULL, NULL),
(84, 4, 'Port Edward', NULL, NULL),
(85, 4, 'Ifafa Beach', NULL, NULL),
(86, 4, 'Port Shepstone', NULL, NULL),
(87, 4, 'uMgungundlovu', NULL, NULL),
(88, 4, 'Pietermaritzburg', NULL, NULL),
(89, 4, 'UMkhanyakude', NULL, NULL),
(90, 4, 'Umzinyathi', NULL, NULL),
(91, 4, 'uThukela', NULL, NULL),
(92, 4, 'Ladysmith', NULL, NULL),
(93, 4, 'Elandslaagte', NULL, NULL),
(94, 4, 'Winterton', NULL, NULL),
(95, 4, 'Zululand', NULL, NULL),
(96, 4, 'Richards Bay', NULL, NULL),
(97, 4, 'Nongoma', NULL, NULL),
(98, 4, 'Louwsburg', NULL, NULL),
(99, 4, 'Ulundi', NULL, NULL),
(100, 4, 'Paulpietersburg', NULL, NULL),
(101, 5, 'Arlington', NULL, NULL),
(102, 5, 'Bethlehem', NULL, NULL),
(103, 5, 'Clarens', NULL, NULL),
(104, 5, 'Clocolan', NULL, NULL),
(105, 5, 'Cornelia', NULL, NULL),
(106, 5, 'Excelsior', NULL, NULL),
(107, 5, 'Harrismith', NULL, NULL),
(108, 5, 'Lejweleputswa', NULL, NULL),
(109, 5, 'Allanridge', NULL, NULL),
(110, 5, 'Brandfort', NULL, NULL),
(111, 5, 'Welkom\r\n', NULL, NULL),
(112, 5, 'Virginia', NULL, NULL),
(113, 5, 'Northern Free State', NULL, NULL),
(114, 5, 'Edenville', NULL, NULL),
(115, 5, 'Kroonstad', NULL, NULL),
(116, 5, 'Oranjeville', NULL, NULL),
(117, 5, 'Transgariep', NULL, NULL),
(118, 5, 'Bethulie', NULL, NULL),
(119, 5, 'Bloemfontein', NULL, NULL),
(120, 5, 'Botshabelo', NULL, NULL),
(121, 5, 'Koffiefontein', NULL, NULL),
(122, 5, 'Mangaung', NULL, NULL),
(123, 5, 'Thaba ''Nchu', NULL, NULL),
(124, 5, 'Zastron', NULL, NULL),
(125, 7, 'Amalia', NULL, NULL),
(126, 7, 'Bray', NULL, NULL),
(127, 7, 'Ganyesa', NULL, NULL),
(128, 7, 'Mareetsane', NULL, NULL),
(129, 7, 'Mothibastad', NULL, NULL),
(130, 7, 'Pampierstad', NULL, NULL),
(131, 7, 'Reivilo', NULL, NULL),
(132, 7, 'Schweizer-Reneke', NULL, NULL),
(133, 7, 'Babelegi', NULL, NULL),
(134, 7, 'Beestekraal', NULL, NULL),
(135, 7, 'Brits', NULL, NULL),
(136, 7, 'Broederstroom', NULL, NULL),
(137, 7, 'Ga-Rankuwa', NULL, NULL),
(138, 7, 'Hartbeespoort', NULL, NULL),
(139, 7, 'Kroondal', NULL, NULL),
(140, 7, 'Maanhaarrand', NULL, NULL),
(141, 7, 'Mabopane', NULL, NULL),
(142, 7, 'Magaliesburg', NULL, NULL),
(143, 7, 'Marikana', NULL, NULL),
(144, 7, 'Rustenburg', NULL, NULL),
(145, 7, 'Haartebeesfontien', NULL, NULL),
(146, 7, 'Mafikeng', NULL, NULL),
(147, 7, 'Mmabatho', NULL, NULL),
(148, 7, 'Bloemhof', NULL, NULL),
(149, 7, 'Klerksdorp', NULL, NULL),
(150, 7, 'Potchefstroom', NULL, NULL),
(151, 7, 'Ventersdorp', NULL, NULL),
(152, 7, 'Wolmaransstad', NULL, NULL),
(153, 6, 'Aankoms', NULL, NULL),
(154, 6, 'Acornhoek', NULL, NULL),
(155, 6, 'Amersfoort', NULL, NULL),
(156, 6, 'Amsterdam', NULL, NULL),
(157, 6, 'Gras and Wetlands', NULL, NULL),
(158, 6, 'Bushbuckridge', NULL, NULL),
(159, 6, 'Balfour', NULL, NULL),
(160, 6, 'Balmoral\r\n', NULL, NULL),
(161, 6, 'Barberton', NULL, NULL),
(162, 6, 'Carolina', NULL, NULL),
(163, 6, 'Diepdale', NULL, NULL),
(164, 6, 'Dullstroom', NULL, NULL),
(165, 6, 'Ermelo', NULL, NULL),
(166, 6, 'KwaMhlanga', NULL, NULL),
(167, 6, 'Hartebeesko', NULL, NULL),
(168, 6, 'eNtokozweni', NULL, NULL),
(169, 6, 'Malalane', NULL, NULL),
(170, 6, 'Marble Hall', NULL, NULL),
(171, 6, 'Middelburg', NULL, NULL),
(172, 6, 'Nelspruit', NULL, NULL),
(173, 6, 'Secunda', NULL, NULL),
(174, 6, 'Skukuza', NULL, NULL),
(175, 6, 'Standerton', NULL, NULL),
(176, 6, 'Trichardt', NULL, NULL),
(177, 6, 'Vaalbank', NULL, NULL),
(178, 6, 'Volksrust', NULL, NULL),
(179, 6, 'Wakkerstroom', NULL, NULL),
(180, 6, 'Waterval Boven', NULL, NULL),
(181, 6, 'Waterval Onder', NULL, NULL),
(182, 6, 'White River', NULL, NULL),
(183, 6, 'Witbank/eMalahleni', NULL, NULL),
(184, 2, 'Frances Baard ', NULL, NULL),
(185, 2, 'Barkly West', NULL, NULL),
(186, 2, 'Delportshoop', NULL, NULL),
(187, 2, 'Griquatown', NULL, NULL),
(188, 2, 'Jan Kempdorp', NULL, NULL),
(189, 2, 'Kimberley', NULL, NULL),
(190, 2, 'Modder River', NULL, NULL),
(191, 2, 'Warrenton', NULL, NULL),
(192, 2, 'ZF Mgcawu ', NULL, NULL),
(193, 2, 'Andriesvale', NULL, NULL),
(194, 2, 'Kanoneiland', NULL, NULL),
(195, 2, 'Olifantshoek', NULL, NULL),
(196, 2, 'Goodwood', NULL, NULL),
(197, 2, 'Cape Town', NULL, NULL),
(200, 2, 'Upington', NULL, NULL),
(201, 2, 'Hantam Karoo', NULL, NULL),
(202, 2, 'Brandvlei', NULL, NULL),
(203, 2, 'Calvinia', NULL, NULL),
(204, 2, 'Nieuwoudtville', NULL, NULL),
(205, 2, 'Van Wyksvlei', NULL, NULL),
(206, 2, 'John Taolo Gaetsewe ', NULL, NULL),
(207, 2, 'Beeshoek', NULL, NULL),
(208, 2, 'Black Rock', NULL, NULL),
(209, 2, 'Kuruman', NULL, NULL),
(210, 2, 'Van Zylsrus', NULL, NULL),
(211, 2, 'Namakwa ', NULL, NULL),
(212, 2, 'Aggeneys\r\n\r\n', NULL, NULL),
(213, 2, 'Alexander Bay', NULL, NULL),
(214, 2, 'Gordon''s Bay', NULL, NULL),
(215, 2, 'Hondeklip', NULL, NULL),
(216, 2, 'Port Nolloth', NULL, NULL),
(217, 2, 'Springbok', NULL, NULL),
(218, 2, 'Pixley ka Seme ', NULL, NULL),
(219, 2, 'Guguletu', NULL, NULL),
(220, 2, 'Fish Hoek', NULL, NULL),
(221, 2, 'Colesberg\r\n\r\n', NULL, NULL),
(222, 2, 'Hopetown', NULL, NULL),
(223, 2, 'Khayelitsha', NULL, NULL),
(226, 2, 'Simon''s Town', NULL, NULL),
(227, 2, 'Southern Suburbs', NULL, NULL),
(228, 2, 'West Coast', NULL, NULL),
(229, 2, 'Chatsworth', NULL, NULL),
(230, 2, 'Grotto Bay', NULL, NULL),
(231, 2, 'Lamberts Bay', NULL, NULL),
(232, 2, 'Riebeek-Kasteel\r\n\r\n', NULL, NULL),
(233, 2, 'Riebeek West', NULL, NULL),
(234, 8, 'Cape Winelands District', NULL, NULL),
(235, 8, 'Ashton', NULL, NULL),
(236, 8, 'Bonnievale', NULL, NULL),
(237, 8, 'Denneburg', NULL, NULL),
(238, 8, 'Franschhoek', NULL, NULL),
(239, 8, 'Op-die-Berg', NULL, NULL),
(240, 8, 'Stellenbosch', NULL, NULL),
(241, 8, 'Wellington', NULL, NULL),
(242, 8, 'Wemmershoek', NULL, NULL),
(243, 8, 'Worcester', NULL, NULL),
(244, 8, 'Overberg District ', NULL, NULL),
(245, 8, 'Arniston', NULL, NULL),
(246, 8, 'Baardskeerdersbos', NULL, NULL),
(247, 8, 'Betty''s Bay', NULL, NULL),
(248, 8, 'Bredasdorp', NULL, NULL),
(249, 8, 'Villiersdorp', NULL, NULL),
(250, 8, 'Pearly Beach\r\n\r\n', NULL, NULL),
(251, 8, 'Pringle Bay', NULL, NULL),
(252, 8, 'George', NULL, NULL),
(253, 8, 'Knysna', NULL, NULL),
(254, 8, 'Mossel Bay', NULL, NULL),
(255, 8, 'Ladismith', NULL, NULL),
(256, 8, 'Plettenberg Bay', NULL, NULL),
(257, 8, 'Victoria Bay', NULL, NULL),
(258, 8, 'Central Karoo District ', NULL, NULL),
(259, 8, 'Beaufort West', NULL, NULL),
(260, 8, 'Murraysburg\r\n', NULL, NULL),
(261, 8, 'Nelspoort', NULL, NULL),
(262, 9, 'Adelaide', NULL, NULL),
(263, 9, 'Bhisho', NULL, NULL),
(264, 9, 'King William''s Town', NULL, NULL),
(265, 9, 'Mdantsane', NULL, NULL),
(266, 9, 'East London ', NULL, NULL),
(267, 9, 'Humansdorp', NULL, NULL),
(268, 9, 'Queenstown', NULL, NULL),
(269, 9, 'St Francis Bay', NULL, NULL),
(270, 9, 'Grahamstown', NULL, NULL),
(271, 9, 'Middelburg', NULL, NULL),
(272, 9, 'Port Elizabeth ', NULL, NULL),
(273, 9, 'Coffee Bay', NULL, NULL),
(274, 9, 'Mthatha', NULL, NULL),
(275, 9, 'Port St Johns', NULL, NULL),
(276, 9, 'Alice', NULL, NULL),
(277, 3, 'Pretoria', NULL, NULL),
(278, 3, 'Soshanguve', NULL, NULL),
(279, 3, 'Springs', NULL, NULL),
(280, 3, 'Sebokeng', NULL, NULL),
(283, 3, 'Vanderbijlpark', NULL, NULL),
(284, 3, 'Lenasia', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
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

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `countryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `countryName` varchar(100) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `countryCode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`countryID`),
  UNIQUE KEY `index2` (`countryName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`countryID`, `countryName`, `latitude`, `longitude`, `countryCode`) VALUES
(1, 'Mozambique', NULL, NULL, 'MZ'),
(2, 'Zimbabwe', NULL, NULL, 'ZW'),
(3, 'South Africa', NULL, NULL, 'ZA'),
(4, 'Namibia', NULL, NULL, 'NA'),
(5, 'Zambia', NULL, NULL, 'ZM');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

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
(22, 1, '2014-04-08 03:46:07', NULL, 14, 'Test Ob 2', 'Test case from Ob 2', NULL, NULL, NULL),
(25, 1, '2014-06-30 11:11:44', 0, 4, 'Developer Tool Chain', 'This unit introduces the developer tools needed to build cloud applications. ', 0, 0, NULL),
(26, 1, '2014-06-30 11:37:45', 0, 4, 'Developer Accounts', 'Every developer must register for accounts for all the cloud computing service providers. This allows the developer access to hosted services necessary for the creation of your own cloud applications. ', 0, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `courseAuthor`
--

CREATE TABLE `courseAuthor` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

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
(23, 22, 17, '2014-04-08 03:46:07'),
(24, 25, 1, '2014-06-30 11:11:44'),
(25, 26, 1, '2014-06-30 11:37:45');

-- --------------------------------------------------------

--
-- Table structure for table `courseTrainee`
--

CREATE TABLE `courseTrainee` (
  `courseTraineeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `trainingClassCourseID` int(10) unsigned NOT NULL,
  `traineeID` int(10) unsigned NOT NULL,
  `dateEnrolled` datetime NOT NULL,
  `ratingID` int(10) unsigned DEFAULT NULL,
  `ratingDate` datetime DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`courseTraineeID`),
  UNIQUE KEY `ix016` (`trainingClassCourseID`,`traineeID`),
  KEY `ix012` (`trainingClassCourseID`),
  KEY `ix013` (`traineeID`),
  KEY `fk012` (`trainingClassCourseID`),
  KEY `fk014` (`traineeID`),
  KEY `ix015` (`dateEnrolled`),
  KEY `ix014` (`ratingID`),
  KEY `fk015` (`ratingID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1111 ;

--
-- Dumping data for table `courseTrainee`
--

INSERT INTO `courseTrainee` (`courseTraineeID`, `trainingClassCourseID`, `traineeID`, `dateEnrolled`, `ratingID`, `ratingDate`, `comment`) VALUES
(791, 87, 25, '2014-07-02 11:05:54', NULL, NULL, NULL),
(792, 87, 86, '2014-07-02 11:05:54', NULL, NULL, NULL),
(793, 87, 87, '2014-07-02 11:05:54', NULL, NULL, NULL),
(794, 87, 88, '2014-07-02 11:05:55', NULL, NULL, NULL),
(795, 87, 89, '2014-07-02 11:05:55', NULL, NULL, NULL),
(796, 87, 90, '2014-07-02 11:05:55', NULL, NULL, NULL),
(797, 87, 91, '2014-07-02 11:05:55', NULL, NULL, NULL),
(798, 87, 92, '2014-07-02 11:05:55', NULL, NULL, NULL),
(799, 87, 93, '2014-07-02 11:05:55', NULL, NULL, NULL),
(800, 87, 94, '2014-07-02 11:05:55', NULL, NULL, NULL),
(801, 87, 95, '2014-07-02 11:05:55', NULL, NULL, NULL),
(802, 87, 96, '2014-07-02 11:05:55', NULL, NULL, NULL),
(803, 87, 97, '2014-07-02 11:05:55', NULL, NULL, NULL),
(804, 87, 98, '2014-07-02 11:05:55', NULL, NULL, NULL),
(805, 87, 99, '2014-07-02 11:05:55', NULL, NULL, NULL),
(806, 87, 115, '2014-07-02 11:05:55', NULL, NULL, NULL),
(807, 87, 117, '2014-07-02 11:05:55', NULL, NULL, NULL),
(808, 87, 118, '2014-07-02 11:05:55', NULL, NULL, NULL),
(809, 87, 137, '2014-07-02 11:05:55', NULL, NULL, NULL),
(810, 87, 139, '2014-07-02 11:05:55', NULL, NULL, NULL),
(811, 87, 140, '2014-07-02 11:05:55', NULL, NULL, NULL),
(812, 88, 25, '2014-07-02 11:05:55', NULL, NULL, NULL),
(813, 88, 86, '2014-07-02 11:05:55', NULL, NULL, NULL),
(814, 88, 87, '2014-07-02 11:05:55', NULL, NULL, NULL),
(815, 88, 88, '2014-07-02 11:05:55', NULL, NULL, NULL),
(816, 88, 89, '2014-07-02 11:05:55', NULL, NULL, NULL),
(817, 88, 90, '2014-07-02 11:05:55', NULL, NULL, NULL),
(818, 88, 91, '2014-07-02 11:05:55', NULL, NULL, NULL),
(819, 88, 92, '2014-07-02 11:05:55', NULL, NULL, NULL),
(820, 88, 93, '2014-07-02 11:05:55', NULL, NULL, NULL),
(821, 88, 94, '2014-07-02 11:05:55', NULL, NULL, NULL),
(822, 88, 95, '2014-07-02 11:05:55', NULL, NULL, NULL),
(823, 88, 96, '2014-07-02 11:05:55', NULL, NULL, NULL),
(824, 88, 97, '2014-07-02 11:05:55', NULL, NULL, NULL),
(825, 88, 98, '2014-07-02 11:05:55', NULL, NULL, NULL),
(826, 88, 99, '2014-07-02 11:05:55', NULL, NULL, NULL),
(827, 88, 115, '2014-07-02 11:05:55', NULL, NULL, NULL),
(828, 88, 117, '2014-07-02 11:05:55', NULL, NULL, NULL),
(829, 88, 118, '2014-07-02 11:05:55', NULL, NULL, NULL),
(830, 88, 137, '2014-07-02 11:05:55', NULL, NULL, NULL),
(831, 88, 139, '2014-07-02 11:05:55', NULL, NULL, NULL),
(832, 88, 140, '2014-07-02 11:05:55', NULL, NULL, NULL),
(833, 89, 25, '2014-07-02 11:05:55', NULL, NULL, NULL),
(834, 89, 86, '2014-07-02 11:05:55', NULL, NULL, NULL),
(835, 89, 87, '2014-07-02 11:05:55', NULL, NULL, NULL),
(836, 89, 88, '2014-07-02 11:05:55', NULL, NULL, NULL),
(837, 89, 89, '2014-07-02 11:05:55', NULL, NULL, NULL),
(838, 89, 90, '2014-07-02 11:05:55', NULL, NULL, NULL),
(839, 89, 91, '2014-07-02 11:05:55', NULL, NULL, NULL),
(840, 89, 92, '2014-07-02 11:05:55', NULL, NULL, NULL),
(841, 89, 93, '2014-07-02 11:05:55', NULL, NULL, NULL),
(842, 89, 94, '2014-07-02 11:05:55', NULL, NULL, NULL),
(843, 89, 95, '2014-07-02 11:05:55', NULL, NULL, NULL),
(844, 89, 96, '2014-07-02 11:05:55', NULL, NULL, NULL),
(845, 89, 97, '2014-07-02 11:05:55', NULL, NULL, NULL),
(846, 89, 98, '2014-07-02 11:05:55', NULL, NULL, NULL),
(847, 89, 99, '2014-07-02 11:05:55', NULL, NULL, NULL),
(848, 89, 115, '2014-07-02 11:05:55', NULL, NULL, NULL),
(849, 89, 117, '2014-07-02 11:05:55', NULL, NULL, NULL),
(850, 89, 118, '2014-07-02 11:05:55', NULL, NULL, NULL),
(851, 89, 137, '2014-07-02 11:05:55', NULL, NULL, NULL),
(852, 89, 139, '2014-07-02 11:05:55', NULL, NULL, NULL),
(853, 89, 140, '2014-07-02 11:05:55', NULL, NULL, NULL),
(854, 90, 25, '2014-07-02 11:05:55', NULL, NULL, NULL),
(855, 90, 86, '2014-07-02 11:05:55', NULL, NULL, NULL),
(856, 90, 87, '2014-07-02 11:05:55', NULL, NULL, NULL),
(857, 90, 88, '2014-07-02 11:05:55', NULL, NULL, NULL),
(858, 90, 89, '2014-07-02 11:05:55', NULL, NULL, NULL),
(859, 90, 90, '2014-07-02 11:05:55', NULL, NULL, NULL),
(860, 90, 91, '2014-07-02 11:05:55', NULL, NULL, NULL),
(861, 90, 92, '2014-07-02 11:05:55', NULL, NULL, NULL),
(862, 90, 93, '2014-07-02 11:05:55', NULL, NULL, NULL),
(863, 90, 94, '2014-07-02 11:05:55', NULL, NULL, NULL),
(864, 90, 95, '2014-07-02 11:05:55', NULL, NULL, NULL),
(865, 90, 96, '2014-07-02 11:05:55', NULL, NULL, NULL),
(866, 90, 97, '2014-07-02 11:05:55', NULL, NULL, NULL),
(867, 90, 98, '2014-07-02 11:05:55', NULL, NULL, NULL),
(868, 90, 99, '2014-07-02 11:05:55', NULL, NULL, NULL),
(869, 90, 115, '2014-07-02 11:05:55', NULL, NULL, NULL),
(870, 90, 117, '2014-07-02 11:05:55', NULL, NULL, NULL),
(871, 90, 118, '2014-07-02 11:05:55', NULL, NULL, NULL),
(872, 90, 137, '2014-07-02 11:05:55', NULL, NULL, NULL),
(873, 90, 139, '2014-07-02 11:05:55', NULL, NULL, NULL),
(874, 90, 140, '2014-07-02 11:05:56', NULL, NULL, NULL),
(875, 91, 25, '2014-07-02 11:05:56', NULL, NULL, NULL),
(876, 91, 86, '2014-07-02 11:05:56', NULL, NULL, NULL),
(877, 91, 87, '2014-07-02 11:05:56', NULL, NULL, NULL),
(878, 91, 88, '2014-07-02 11:05:56', NULL, NULL, NULL),
(879, 91, 89, '2014-07-02 11:05:56', NULL, NULL, NULL),
(880, 91, 90, '2014-07-02 11:05:56', NULL, NULL, NULL),
(881, 91, 91, '2014-07-02 11:05:56', NULL, NULL, NULL),
(882, 91, 92, '2014-07-02 11:05:56', NULL, NULL, NULL),
(883, 91, 93, '2014-07-02 11:05:56', NULL, NULL, NULL),
(884, 91, 94, '2014-07-02 11:05:56', NULL, NULL, NULL),
(885, 91, 95, '2014-07-02 11:05:56', NULL, NULL, NULL),
(886, 91, 96, '2014-07-02 11:05:56', NULL, NULL, NULL),
(887, 91, 97, '2014-07-02 11:05:56', NULL, NULL, NULL),
(888, 91, 98, '2014-07-02 11:05:56', NULL, NULL, NULL),
(889, 91, 99, '2014-07-02 11:05:56', NULL, NULL, NULL),
(890, 91, 115, '2014-07-02 11:05:56', NULL, NULL, NULL),
(891, 91, 117, '2014-07-02 11:05:56', NULL, NULL, NULL),
(892, 91, 118, '2014-07-02 11:05:56', NULL, NULL, NULL),
(893, 91, 137, '2014-07-02 11:05:56', NULL, NULL, NULL),
(894, 91, 139, '2014-07-02 11:05:56', NULL, NULL, NULL),
(895, 91, 140, '2014-07-02 11:05:56', NULL, NULL, NULL),
(896, 92, 25, '2014-07-02 11:05:56', NULL, NULL, NULL),
(897, 92, 86, '2014-07-02 11:05:56', NULL, NULL, NULL),
(898, 92, 87, '2014-07-02 11:05:56', NULL, NULL, NULL),
(899, 92, 88, '2014-07-02 11:05:56', NULL, NULL, NULL),
(900, 92, 89, '2014-07-02 11:05:56', NULL, NULL, NULL),
(901, 92, 90, '2014-07-02 11:05:56', NULL, NULL, NULL),
(902, 92, 91, '2014-07-02 11:05:56', NULL, NULL, NULL),
(903, 92, 92, '2014-07-02 11:05:56', NULL, NULL, NULL),
(904, 92, 93, '2014-07-02 11:05:56', NULL, NULL, NULL),
(905, 92, 94, '2014-07-02 11:05:56', NULL, NULL, NULL),
(906, 92, 95, '2014-07-02 11:05:56', NULL, NULL, NULL),
(907, 92, 96, '2014-07-02 11:05:56', NULL, NULL, NULL),
(908, 92, 97, '2014-07-02 11:05:56', NULL, NULL, NULL),
(909, 92, 98, '2014-07-02 11:05:56', NULL, NULL, NULL),
(910, 92, 99, '2014-07-02 11:05:56', NULL, NULL, NULL),
(911, 92, 115, '2014-07-02 11:05:56', NULL, NULL, NULL),
(912, 92, 117, '2014-07-02 11:05:56', NULL, NULL, NULL),
(913, 92, 118, '2014-07-02 11:05:56', NULL, NULL, NULL),
(914, 92, 137, '2014-07-02 11:05:56', NULL, NULL, NULL),
(915, 92, 139, '2014-07-02 11:05:56', NULL, NULL, NULL),
(916, 92, 140, '2014-07-02 11:05:56', NULL, NULL, NULL),
(917, 93, 100, '2014-07-03 19:22:33', NULL, NULL, NULL),
(918, 93, 101, '2014-07-03 19:22:33', NULL, NULL, NULL),
(919, 93, 102, '2014-07-03 19:22:33', NULL, NULL, NULL),
(920, 93, 103, '2014-07-03 19:22:33', NULL, NULL, NULL),
(921, 93, 104, '2014-07-03 19:22:33', NULL, NULL, NULL),
(922, 93, 105, '2014-07-03 19:22:33', NULL, NULL, NULL),
(923, 93, 106, '2014-07-03 19:22:33', NULL, NULL, NULL),
(924, 93, 107, '2014-07-03 19:22:33', NULL, NULL, NULL),
(925, 93, 108, '2014-07-03 19:22:33', NULL, NULL, NULL),
(926, 93, 109, '2014-07-03 19:22:33', NULL, NULL, NULL),
(927, 93, 110, '2014-07-03 19:22:33', NULL, NULL, NULL),
(928, 93, 111, '2014-07-03 19:22:33', NULL, NULL, NULL),
(929, 93, 112, '2014-07-03 19:22:33', NULL, NULL, NULL),
(930, 93, 113, '2014-07-03 19:22:33', NULL, NULL, NULL),
(931, 99, 100, '2014-07-03 19:22:33', NULL, NULL, NULL),
(932, 99, 101, '2014-07-03 19:22:33', NULL, NULL, NULL),
(933, 99, 102, '2014-07-03 19:22:33', NULL, NULL, NULL),
(934, 99, 103, '2014-07-03 19:22:33', NULL, NULL, NULL),
(935, 99, 104, '2014-07-03 19:22:33', NULL, NULL, NULL),
(936, 99, 105, '2014-07-03 19:22:33', NULL, NULL, NULL),
(937, 99, 106, '2014-07-03 19:22:33', NULL, NULL, NULL),
(938, 99, 107, '2014-07-03 19:22:33', NULL, NULL, NULL),
(939, 99, 108, '2014-07-03 19:22:33', NULL, NULL, NULL),
(940, 99, 109, '2014-07-03 19:22:33', NULL, NULL, NULL),
(941, 99, 110, '2014-07-03 19:22:33', NULL, NULL, NULL),
(942, 99, 111, '2014-07-03 19:22:33', NULL, NULL, NULL),
(943, 99, 112, '2014-07-03 19:22:33', NULL, NULL, NULL),
(944, 99, 113, '2014-07-03 19:22:33', NULL, NULL, NULL),
(945, 98, 100, '2014-07-03 19:22:33', NULL, NULL, NULL),
(946, 98, 101, '2014-07-03 19:22:33', NULL, NULL, NULL),
(947, 98, 102, '2014-07-03 19:22:33', NULL, NULL, NULL),
(948, 98, 103, '2014-07-03 19:22:33', NULL, NULL, NULL),
(949, 98, 104, '2014-07-03 19:22:33', NULL, NULL, NULL),
(950, 98, 105, '2014-07-03 19:22:33', NULL, NULL, NULL),
(951, 98, 106, '2014-07-03 19:22:33', NULL, NULL, NULL),
(952, 98, 107, '2014-07-03 19:22:33', NULL, NULL, NULL),
(953, 98, 108, '2014-07-03 19:22:33', NULL, NULL, NULL),
(954, 98, 109, '2014-07-03 19:22:33', NULL, NULL, NULL),
(955, 98, 110, '2014-07-03 19:22:33', NULL, NULL, NULL),
(956, 98, 111, '2014-07-03 19:22:33', NULL, NULL, NULL),
(957, 98, 112, '2014-07-03 19:22:33', NULL, NULL, NULL),
(958, 98, 113, '2014-07-03 19:22:33', NULL, NULL, NULL),
(959, 97, 100, '2014-07-03 19:22:33', NULL, NULL, NULL),
(960, 97, 101, '2014-07-03 19:22:33', NULL, NULL, NULL),
(961, 97, 102, '2014-07-03 19:22:33', NULL, NULL, NULL),
(962, 97, 103, '2014-07-03 19:22:33', NULL, NULL, NULL),
(963, 97, 104, '2014-07-03 19:22:33', NULL, NULL, NULL),
(964, 97, 105, '2014-07-03 19:22:33', NULL, NULL, NULL),
(965, 97, 106, '2014-07-03 19:22:33', NULL, NULL, NULL),
(966, 97, 107, '2014-07-03 19:22:33', NULL, NULL, NULL),
(967, 97, 108, '2014-07-03 19:22:33', NULL, NULL, NULL),
(968, 97, 109, '2014-07-03 19:22:33', NULL, NULL, NULL),
(969, 97, 110, '2014-07-03 19:22:33', NULL, NULL, NULL),
(970, 97, 111, '2014-07-03 19:22:33', NULL, NULL, NULL),
(971, 97, 112, '2014-07-03 19:22:33', NULL, NULL, NULL),
(972, 97, 113, '2014-07-03 19:22:33', NULL, NULL, NULL),
(973, 96, 100, '2014-07-03 19:22:33', NULL, NULL, NULL),
(974, 96, 101, '2014-07-03 19:22:33', NULL, NULL, NULL),
(975, 96, 102, '2014-07-03 19:22:33', NULL, NULL, NULL),
(976, 96, 103, '2014-07-03 19:22:33', NULL, NULL, NULL),
(977, 96, 104, '2014-07-03 19:22:33', NULL, NULL, NULL),
(978, 96, 105, '2014-07-03 19:22:33', NULL, NULL, NULL),
(979, 96, 106, '2014-07-03 19:22:33', NULL, NULL, NULL),
(980, 96, 107, '2014-07-03 19:22:33', NULL, NULL, NULL),
(981, 96, 108, '2014-07-03 19:22:33', NULL, NULL, NULL),
(982, 96, 109, '2014-07-03 19:22:33', NULL, NULL, NULL),
(983, 96, 110, '2014-07-03 19:22:33', NULL, NULL, NULL),
(984, 96, 111, '2014-07-03 19:22:33', NULL, NULL, NULL),
(985, 96, 112, '2014-07-03 19:22:33', NULL, NULL, NULL),
(986, 96, 113, '2014-07-03 19:22:33', NULL, NULL, NULL),
(987, 95, 100, '2014-07-03 19:22:33', NULL, NULL, NULL),
(988, 95, 101, '2014-07-03 19:22:33', NULL, NULL, NULL),
(989, 95, 102, '2014-07-03 19:22:33', NULL, NULL, NULL),
(990, 95, 103, '2014-07-03 19:22:33', NULL, NULL, NULL),
(991, 95, 104, '2014-07-03 19:22:33', NULL, NULL, NULL),
(992, 95, 105, '2014-07-03 19:22:33', NULL, NULL, NULL),
(993, 95, 106, '2014-07-03 19:22:33', NULL, NULL, NULL),
(994, 95, 107, '2014-07-03 19:22:34', NULL, NULL, NULL),
(995, 95, 108, '2014-07-03 19:22:34', NULL, NULL, NULL),
(996, 95, 109, '2014-07-03 19:22:34', NULL, NULL, NULL),
(997, 95, 110, '2014-07-03 19:22:34', NULL, NULL, NULL),
(998, 95, 111, '2014-07-03 19:22:34', NULL, NULL, NULL),
(999, 95, 112, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1000, 95, 113, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1001, 94, 100, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1002, 94, 101, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1003, 94, 102, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1004, 94, 103, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1005, 94, 104, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1006, 94, 105, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1007, 94, 106, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1008, 94, 107, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1009, 94, 108, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1010, 94, 109, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1011, 94, 110, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1012, 94, 111, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1013, 94, 112, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1014, 94, 113, '2014-07-03 19:22:34', NULL, NULL, NULL),
(1015, 92, 152, '2014-07-04 11:13:45', NULL, NULL, NULL),
(1016, 87, 152, '2014-07-04 11:13:45', NULL, NULL, NULL),
(1017, 88, 152, '2014-07-04 11:13:45', NULL, NULL, NULL),
(1018, 89, 152, '2014-07-04 11:13:45', NULL, NULL, NULL),
(1019, 91, 152, '2014-07-04 11:13:45', NULL, NULL, NULL),
(1020, 90, 152, '2014-07-04 11:13:45', NULL, NULL, NULL),
(1021, 88, 153, '2014-07-04 11:32:16', NULL, NULL, NULL),
(1022, 87, 153, '2014-07-04 11:32:16', NULL, NULL, NULL),
(1023, 92, 153, '2014-07-04 11:32:16', NULL, NULL, NULL),
(1024, 90, 153, '2014-07-04 11:32:16', NULL, NULL, NULL),
(1025, 91, 153, '2014-07-04 11:32:16', NULL, NULL, NULL),
(1026, 89, 153, '2014-07-04 11:32:16', NULL, NULL, NULL),
(1027, 90, 155, '2014-07-04 18:25:42', NULL, NULL, NULL),
(1028, 87, 155, '2014-07-04 18:25:43', NULL, NULL, NULL),
(1029, 88, 155, '2014-07-04 18:25:42', NULL, NULL, NULL),
(1030, 89, 155, '2014-07-04 18:25:42', NULL, NULL, NULL),
(1031, 92, 155, '2014-07-04 18:25:42', NULL, NULL, NULL),
(1032, 91, 155, '2014-07-04 18:25:42', NULL, NULL, NULL),
(1033, 88, 156, '2014-07-04 19:37:01', NULL, NULL, NULL),
(1034, 92, 156, '2014-07-04 19:37:01', NULL, NULL, NULL),
(1035, 89, 156, '2014-07-04 19:37:01', NULL, NULL, NULL),
(1036, 87, 156, '2014-07-04 19:37:01', NULL, NULL, NULL),
(1037, 91, 156, '2014-07-04 19:37:01', NULL, NULL, NULL),
(1038, 90, 156, '2014-07-04 19:37:01', NULL, NULL, NULL),
(1039, 91, 157, '2014-07-04 19:39:23', NULL, NULL, NULL),
(1040, 90, 157, '2014-07-04 19:39:23', NULL, NULL, NULL),
(1041, 87, 157, '2014-07-04 19:39:23', NULL, NULL, NULL),
(1042, 92, 157, '2014-07-04 19:39:23', NULL, NULL, NULL),
(1043, 88, 157, '2014-07-04 19:39:23', NULL, NULL, NULL),
(1044, 89, 157, '2014-07-04 19:39:23', NULL, NULL, NULL),
(1045, 106, 119, '2014-07-05 05:33:04', NULL, NULL, NULL),
(1046, 106, 120, '2014-07-05 05:33:04', NULL, NULL, NULL),
(1047, 106, 121, '2014-07-05 05:33:04', NULL, NULL, NULL),
(1048, 106, 124, '2014-07-05 05:33:04', NULL, NULL, NULL),
(1049, 106, 132, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1050, 106, 147, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1051, 105, 119, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1052, 105, 120, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1053, 105, 121, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1054, 105, 124, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1055, 105, 132, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1056, 105, 147, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1057, 104, 119, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1058, 104, 120, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1059, 104, 121, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1060, 104, 124, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1061, 104, 132, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1062, 104, 147, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1063, 102, 119, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1064, 102, 120, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1065, 102, 121, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1066, 102, 124, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1067, 102, 132, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1068, 102, 147, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1069, 103, 119, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1070, 103, 120, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1071, 103, 121, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1072, 103, 124, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1073, 103, 132, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1074, 103, 147, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1075, 101, 119, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1076, 101, 120, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1077, 101, 121, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1078, 101, 124, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1079, 101, 132, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1080, 101, 147, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1081, 100, 119, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1082, 100, 120, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1083, 100, 121, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1084, 100, 124, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1085, 100, 132, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1086, 100, 147, '2014-07-05 05:33:05', NULL, NULL, NULL),
(1087, 110, 119, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1088, 110, 120, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1089, 110, 121, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1090, 110, 124, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1091, 110, 132, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1092, 110, 147, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1093, 107, 119, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1094, 107, 120, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1095, 107, 121, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1096, 107, 124, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1097, 107, 132, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1098, 107, 147, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1099, 108, 119, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1100, 108, 120, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1101, 108, 121, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1102, 108, 124, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1103, 108, 132, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1104, 108, 147, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1105, 109, 119, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1106, 109, 120, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1107, 109, 121, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1108, 109, 124, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1109, 109, 132, '2014-07-05 05:35:58', NULL, NULL, NULL),
(1110, 109, 147, '2014-07-05 05:35:58', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `courseTraineeActivity`
--

CREATE TABLE `courseTraineeActivity` (
  `courseTraineeActivityID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courseTraineeID` int(10) unsigned NOT NULL,
  `activityID` int(10) unsigned NOT NULL,
  `ratingID` int(10) unsigned DEFAULT NULL,
  `completedFlag` int(11) DEFAULT NULL,
  `comment` text,
  `dateUpdated` datetime DEFAULT NULL,
  `completionDate` datetime DEFAULT NULL,
  `refreshRequested` int(11) DEFAULT NULL,
  `completionPercentage` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseTraineeActivityID`),
  KEY `ix020` (`courseTraineeID`),
  KEY `ix021` (`activityID`),
  KEY `fk020` (`activityID`),
  KEY `fk021` (`courseTraineeID`),
  KEY `ix022` (`ratingID`),
  KEY `fk022` (`ratingID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29630 ;

--
-- Dumping data for table `courseTraineeActivity`
--

INSERT INTO `courseTraineeActivity` (`courseTraineeActivityID`, `courseTraineeID`, `activityID`, `ratingID`, `completedFlag`, `comment`, `dateUpdated`, `completionDate`, `refreshRequested`, `completionPercentage`) VALUES
(29354, 791, 114, NULL, 1, NULL, '2014-07-02 12:48:38', '2014-07-02 12:48:38', 0, 0),
(29355, 791, 115, NULL, 1, NULL, '2014-07-03 07:51:35', '2014-07-03 07:51:35', 0, 0),
(29356, 791, 118, NULL, 1, NULL, '2014-07-03 08:32:10', '2014-07-03 08:32:10', 0, 0),
(29357, 791, 117, NULL, 1, NULL, '2014-07-03 10:11:14', '2014-07-03 10:11:14', 0, 0),
(29358, 791, 119, NULL, 1, NULL, '2014-07-05 22:54:14', '2014-07-05 22:54:14', 0, 0),
(29359, 792, 114, NULL, 1, NULL, '2014-07-03 08:34:30', '2014-07-03 08:34:30', 0, 0),
(29360, 792, 115, NULL, 1, NULL, '2014-07-03 08:34:58', '2014-07-03 08:34:58', 0, 0),
(29361, 792, 118, NULL, 0, NULL, '2014-07-02 11:05:54', NULL, 0, 0),
(29362, 792, 117, NULL, 0, NULL, '2014-07-02 11:05:54', NULL, 0, 0),
(29363, 792, 119, NULL, 0, NULL, '2014-07-02 11:05:54', NULL, 0, 0),
(29364, 793, 114, NULL, 1, NULL, '2014-07-03 08:44:39', '2014-07-03 08:44:39', 0, 0),
(29365, 793, 115, NULL, 1, NULL, '2014-07-03 08:50:45', '2014-07-03 08:50:45', 0, 0),
(29366, 793, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29367, 793, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29368, 793, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29369, 794, 114, NULL, 1, NULL, '2014-07-03 09:00:44', '2014-07-03 09:00:44', 0, 0),
(29370, 794, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29371, 794, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29372, 794, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29373, 794, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29374, 795, 114, NULL, 1, NULL, '2014-07-03 22:17:43', '2014-07-03 22:17:43', 0, 0),
(29375, 795, 115, NULL, 1, NULL, '2014-07-03 10:31:47', '2014-07-03 10:31:47', 0, 0),
(29376, 795, 118, NULL, 1, NULL, '2014-07-03 20:58:34', '2014-07-03 20:58:34', 0, 0),
(29377, 795, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29378, 795, 119, NULL, 1, NULL, '2014-07-03 22:19:01', '2014-07-03 22:19:01', 0, 0),
(29379, 796, 114, NULL, 1, NULL, '2014-07-03 20:10:05', '2014-07-03 20:10:05', 0, 0),
(29380, 796, 115, NULL, 1, NULL, '2014-07-03 20:10:31', '2014-07-03 20:10:31', 0, 0),
(29381, 796, 118, NULL, 1, NULL, '2014-07-03 20:11:55', '2014-07-03 20:11:55', 0, 0),
(29382, 796, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29383, 796, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29384, 797, 114, NULL, 1, NULL, '2014-07-03 10:36:11', '2014-07-03 10:36:11', 0, 0),
(29385, 797, 115, NULL, 1, NULL, '2014-07-03 10:36:27', '2014-07-03 10:36:27', 0, 0),
(29386, 797, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29387, 797, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29388, 797, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29389, 798, 114, NULL, 1, NULL, '2014-07-03 10:45:19', '2014-07-03 10:45:19', 0, 0),
(29390, 798, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29391, 798, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29392, 798, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29393, 798, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29394, 799, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29395, 799, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29396, 799, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29397, 799, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29398, 799, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29399, 800, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29400, 800, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29401, 800, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29402, 800, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29403, 800, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29404, 801, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29405, 801, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29406, 801, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29407, 801, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29408, 801, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29409, 802, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29410, 802, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29411, 802, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29412, 802, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29413, 802, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29414, 803, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29415, 803, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29416, 803, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29417, 803, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29418, 803, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29419, 804, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29420, 804, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29421, 804, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29422, 804, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29423, 804, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29424, 805, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29425, 805, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29426, 805, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29427, 805, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29428, 805, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29429, 806, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29430, 806, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29431, 806, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29432, 806, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29433, 806, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29434, 807, 114, 4, 1, NULL, '2014-07-05 22:33:10', '2014-07-05 22:33:10', 0, 0),
(29435, 807, 115, 1, 1, NULL, '2014-07-05 22:38:17', '2014-07-05 22:38:17', 0, 0),
(29436, 807, 118, 2, 0, NULL, '2014-07-05 15:13:19', NULL, 0, 0),
(29437, 807, 117, 1, 0, NULL, '2014-07-05 15:41:22', NULL, 0, 0),
(29438, 807, 119, 4, 0, NULL, '2014-07-05 23:19:07', NULL, 0, 0),
(29439, 808, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29440, 808, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29441, 808, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29442, 808, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29443, 808, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29444, 809, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29445, 809, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29446, 809, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29447, 809, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29448, 809, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29449, 810, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29450, 810, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29451, 810, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29452, 810, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29453, 810, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29454, 811, 114, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29455, 811, 115, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29456, 811, 118, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29457, 811, 117, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29458, 811, 119, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29459, 812, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29460, 813, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29461, 814, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29462, 815, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29463, 816, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29464, 817, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29465, 818, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29466, 819, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29467, 820, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29468, 821, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29469, 822, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29470, 823, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29471, 824, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29472, 825, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29473, 826, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29474, 827, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29475, 828, 116, 2, 0, NULL, '2014-07-05 18:36:30', NULL, 0, 0),
(29476, 829, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29477, 830, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29478, 831, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29479, 832, 116, NULL, 0, NULL, '2014-07-02 11:05:55', NULL, 0, 0),
(29480, 987, 116, NULL, 0, NULL, '2014-07-03 19:22:33', NULL, 0, 0),
(29481, 988, 116, NULL, 0, NULL, '2014-07-03 19:22:33', NULL, 0, 0),
(29482, 989, 116, NULL, 0, NULL, '2014-07-03 19:22:33', NULL, 0, 0),
(29483, 990, 116, NULL, 0, NULL, '2014-07-03 19:22:33', NULL, 0, 0),
(29484, 991, 116, NULL, 0, NULL, '2014-07-03 19:22:33', NULL, 0, 0),
(29485, 992, 116, NULL, 0, NULL, '2014-07-03 19:22:33', NULL, 0, 0),
(29486, 993, 116, NULL, 0, NULL, '2014-07-03 19:22:33', NULL, 0, 0),
(29487, 994, 116, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29488, 995, 116, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29489, 996, 116, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29490, 997, 116, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29491, 998, 116, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29492, 999, 116, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29493, 1000, 116, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29494, 1001, 114, NULL, 1, NULL, '2014-07-05 22:39:32', '2014-07-05 22:39:32', 0, 0),
(29495, 1001, 115, NULL, 1, NULL, '2014-07-05 22:55:27', '2014-07-05 22:55:27', 0, 0),
(29496, 1001, 118, NULL, 1, NULL, '2014-07-05 22:55:46', '2014-07-05 22:55:46', 0, 0),
(29497, 1001, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29498, 1001, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29499, 1002, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29500, 1002, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29501, 1002, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29502, 1002, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29503, 1002, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29504, 1003, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29505, 1003, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29506, 1003, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29507, 1003, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29508, 1003, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29509, 1004, 114, NULL, 1, NULL, '2014-07-05 23:06:11', '2014-07-05 23:06:11', 0, 0),
(29510, 1004, 115, NULL, 1, NULL, '2014-07-06 00:38:09', '2014-07-06 00:38:09', 0, 0),
(29511, 1004, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29512, 1004, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29513, 1004, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29514, 1005, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29515, 1005, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29516, 1005, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29517, 1005, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29518, 1005, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29519, 1006, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29520, 1006, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29521, 1006, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29522, 1006, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29523, 1006, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29524, 1007, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29525, 1007, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29526, 1007, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29527, 1007, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29528, 1007, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29529, 1008, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29530, 1008, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29531, 1008, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29532, 1008, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29533, 1008, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29534, 1009, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29535, 1009, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29536, 1009, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29537, 1009, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29538, 1009, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29539, 1010, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29540, 1010, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29541, 1010, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29542, 1010, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29543, 1010, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29544, 1011, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29545, 1011, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29546, 1011, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29547, 1011, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29548, 1011, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29549, 1012, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29550, 1012, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29551, 1012, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29552, 1012, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29553, 1012, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29554, 1013, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29555, 1013, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29556, 1013, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29557, 1013, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29558, 1013, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29559, 1014, 114, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29560, 1014, 115, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29561, 1014, 118, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29562, 1014, 117, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29563, 1014, 119, NULL, 0, NULL, '2014-07-03 19:22:34', NULL, 0, 0),
(29564, 1016, 118, NULL, 0, NULL, '2014-07-04 11:13:45', NULL, 0, 0),
(29565, 1016, 115, NULL, 0, NULL, '2014-07-04 11:13:45', NULL, 0, 0),
(29566, 1016, 114, NULL, 0, NULL, '2014-07-04 11:13:45', NULL, 0, 0),
(29567, 1017, 116, NULL, 0, NULL, '2014-07-04 11:13:45', NULL, 0, 0),
(29568, 1016, 119, NULL, 0, NULL, '2014-07-04 11:13:45', NULL, 0, 0),
(29569, 1016, 117, NULL, 0, NULL, '2014-07-04 11:13:45', NULL, 0, 0),
(29570, 1021, 116, NULL, 0, NULL, '2014-07-04 11:32:16', NULL, 0, 0),
(29571, 1022, 119, NULL, 0, NULL, '2014-07-04 11:32:16', NULL, 0, 0),
(29572, 1022, 118, NULL, 0, NULL, '2014-07-04 11:32:16', NULL, 0, 0),
(29573, 1022, 114, NULL, 0, NULL, '2014-07-04 11:32:16', NULL, 0, 0),
(29574, 1022, 115, NULL, 0, NULL, '2014-07-04 11:32:16', NULL, 0, 0),
(29575, 1022, 117, NULL, 0, NULL, '2014-07-04 11:32:16', NULL, 0, 0),
(29576, 1028, 119, NULL, 0, NULL, '2014-07-04 18:25:43', NULL, 0, 0),
(29577, 1029, 116, NULL, 0, NULL, '2014-07-04 18:25:42', NULL, 0, 0),
(29578, 1028, 118, NULL, 0, NULL, '2014-07-04 18:25:43', NULL, 0, 0),
(29579, 1028, 117, NULL, 0, NULL, '2014-07-04 18:25:43', NULL, 0, 0),
(29580, 1028, 114, NULL, 0, NULL, '2014-07-04 18:25:43', NULL, 0, 0),
(29581, 1028, 115, NULL, 0, NULL, '2014-07-04 18:25:43', NULL, 0, 0),
(29582, 1036, 118, NULL, 0, NULL, '2014-07-04 19:37:01', NULL, 0, 0),
(29583, 1036, 114, NULL, 0, NULL, '2014-07-04 19:37:01', NULL, 0, 0),
(29584, 1036, 115, NULL, 0, NULL, '2014-07-04 19:37:01', NULL, 0, 0),
(29585, 1033, 116, NULL, 0, NULL, '2014-07-04 19:37:01', NULL, 0, 0),
(29586, 1036, 119, NULL, 0, NULL, '2014-07-04 19:37:01', NULL, 0, 0),
(29587, 1036, 117, NULL, 0, NULL, '2014-07-04 19:37:01', NULL, 0, 0),
(29588, 1041, 118, NULL, 0, NULL, '2014-07-04 19:39:23', NULL, 0, 0),
(29589, 1041, 115, NULL, 0, NULL, '2014-07-04 19:39:23', NULL, 0, 0),
(29590, 1043, 116, NULL, 0, NULL, '2014-07-04 19:39:23', NULL, 0, 0),
(29591, 1041, 114, NULL, 0, NULL, '2014-07-04 19:39:23', NULL, 0, 0),
(29592, 1041, 119, NULL, 0, NULL, '2014-07-04 19:39:23', NULL, 0, 0),
(29593, 1041, 117, NULL, 0, NULL, '2014-07-04 19:39:23', NULL, 0, 0),
(29594, 1075, 116, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29595, 1076, 116, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29596, 1077, 116, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29597, 1078, 116, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29598, 1079, 116, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29599, 1080, 116, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29600, 1081, 114, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29601, 1081, 115, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29602, 1081, 118, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29603, 1081, 117, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29604, 1081, 119, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29605, 1082, 114, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29606, 1082, 115, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29607, 1082, 118, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29608, 1082, 117, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29609, 1082, 119, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29610, 1083, 114, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29611, 1083, 115, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29612, 1083, 118, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29613, 1083, 117, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29614, 1083, 119, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29615, 1084, 114, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29616, 1084, 115, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29617, 1084, 118, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29618, 1084, 117, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29619, 1084, 119, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29620, 1085, 114, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29621, 1085, 115, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29622, 1085, 118, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29623, 1085, 117, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29624, 1085, 119, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29625, 1086, 114, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29626, 1086, 115, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29627, 1086, 118, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29628, 1086, 117, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0),
(29629, 1086, 119, NULL, 0, NULL, '2014-07-05 05:33:05', NULL, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `demoAnnouncement`
--

CREATE TABLE `demoAnnouncement` (
  `demoAnnouncementID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `demoDate` datetime NOT NULL,
  `teamID` int(11) unsigned DEFAULT NULL,
  `traineeID` int(11) unsigned DEFAULT NULL,
  `trainingClassID` int(11) unsigned NOT NULL,
  `dateRequested` datetime NOT NULL,
  `description` text NOT NULL,
  `cancellationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`demoAnnouncementID`),
  KEY `traineeID` (`traineeID`),
  KEY `trainingClassID` (`trainingClassID`),
  KEY `teamID` (`teamID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
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

-- --------------------------------------------------------

--
-- Table structure for table `errorStore`
--

CREATE TABLE `errorStore` (
  `errorStoreID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `statusCode` int(11) NOT NULL,
  `message` text NOT NULL,
  `dateOccured` datetime NOT NULL,
  `origin` varchar(255) NOT NULL,
  PRIMARY KEY (`errorStoreID`),
  KEY `dateOccured` (`dateOccured`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1085 ;

--
-- Dumping data for table `errorStore`
--

INSERT INTO `errorStore` (`errorStoreID`, `statusCode`, `message`, `dateOccured`, `origin`) VALUES
(847, 0, 'Temporary files HouseKeeping task completed\nNumber of files cleaned up: 0\nTime elapsed: 0.193 seconds', '2014-06-29 16:33:19', 'Server HouseKeeping'),
(848, 0, 'Temporary files HouseKeeping task completed\nNumber of files cleaned up: 0\nTime elapsed: 0.149 seconds', '2014-06-29 16:58:53', 'Server HouseKeeping'),
(849, 0, 'Temporary files HouseKeeping task completed\nNumber of files cleaned up: 0\nTime elapsed: 0.018 seconds', '2014-06-29 16:59:33', 'Server HouseKeeping'),
(850, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 06:30:00', 'HouseKeeper'),
(851, 120, 'Server Database Error\nException [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''authorID'' cannot be null\nError Code: 1048\nCall: INSERT INTO courseAuthor (dateUpdated, authorID, courseID) VALUES (?, ?, ?)\n	bind => [3 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.CourseAuthor[ courseAuthorID=0 ])\n\njavax.persistence.PersistenceException: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''authorID'' cannot be null\nError Code: 1048\nCall: INSERT INTO courseAuthor (dateUpdated, authorID, courseID) VALUES (?, ?, ?)\n	bind => [3 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.CourseAuthor[ courseAuthorID=0 ])\n\nClass: org.eclipse.persistence.internal.jpa.EntityManagerImpl\nMethod: flush\nLine Number: 851\n', '2014-06-30 06:51:28', 'Author Services'),
(852, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 07:00:00', 'HouseKeeper'),
(853, 120, 'Server Database Error\nException [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''authorID'' cannot be null\nError Code: 1048\nCall: INSERT INTO courseAuthor (dateUpdated, authorID, courseID) VALUES (?, ?, ?)\n	bind => [3 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.CourseAuthor[ courseAuthorID=0 ])\n\njavax.persistence.PersistenceException: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''authorID'' cannot be null\nError Code: 1048\nCall: INSERT INTO courseAuthor (dateUpdated, authorID, courseID) VALUES (?, ?, ?)\n	bind => [3 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.CourseAuthor[ courseAuthorID=0 ])\n\nClass: org.eclipse.persistence.internal.jpa.EntityManagerImpl\nMethod: flush\nLine Number: 851\n', '2014-06-30 07:10:47', 'Author Services'),
(854, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 07:30:00', 'HouseKeeper'),
(855, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 08:00:00', 'HouseKeeper'),
(856, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 08:30:00', 'HouseKeeper'),
(857, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 11:04:18', 'HouseKeeper'),
(858, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 11:30:00', 'HouseKeeper'),
(859, 120, 'Server Database Error\nException [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\njavax.persistence.PersistenceException: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\nClass: org.eclipse.persistence.internal.jpa.EntityManagerImpl\nMethod: flush\nLine Number: 851\n', '2014-06-30 11:45:17', 'Author Services'),
(860, 120, 'Server Database Error\nException [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\njavax.persistence.PersistenceException: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\nClass: org.eclipse.persistence.internal.jpa.EntityManagerImpl\nMethod: flush\nLine Number: 851\n', '2014-06-30 11:54:53', 'Author Services'),
(861, 120, 'Server Database Error\nException [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\njavax.persistence.PersistenceException: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\nClass: org.eclipse.persistence.internal.jpa.EntityManagerImpl\nMethod: flush\nLine Number: 851\n', '2014-06-30 11:55:18', 'Author Services'),
(862, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 12:00:00', 'HouseKeeper'),
(863, 120, 'Server Database Error\nException [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\njavax.persistence.PersistenceException: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\nClass: org.eclipse.persistence.internal.jpa.EntityManagerImpl\nMethod: flush\nLine Number: 851\n', '2014-06-30 12:11:50', 'Author Services'),
(864, 120, 'Server Database Error\nException [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\njavax.persistence.PersistenceException: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column ''courseID'' cannot be null\nError Code: 1048\nCall: INSERT INTO activity (activityName, description, durationInDays, localID, priorityFlag, syncDate, courseID) VALUES (?, ?, ?, ?, ?, ?, ?)\n	bind => [7 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Activity[ activityID=0 ])\n\nClass: org.eclipse.persistence.internal.jpa.EntityManagerImpl\nMethod: flush\nLine Number: 851\n', '2014-06-30 12:15:54', 'Author Services'),
(865, 105, 'Unknown request detected. Ignored.', '2014-06-30 12:28:48', 'Author Services'),
(866, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 12:30:00', 'HouseKeeper'),
(867, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 13:00:00', 'HouseKeeper'),
(868, 100, 'Server Exception\nTransaction aborted\n\njavax.ejb.EJBException: Transaction aborted\n\nClass: com.sun.ejb.containers.EJBContainerTransactionManager\nMethod: completeNewTx\nLine Number: 725\n', '2014-06-30 13:23:11', 'Author Services'),
(869, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 13:30:00', 'HouseKeeper'),
(870, 100, 'Server Exception\nTransaction aborted\n\njavax.ejb.EJBException: Transaction aborted\n\nClass: com.sun.ejb.containers.EJBContainerTransactionManager\nMethod: completeNewTx\nLine Number: 725\n', '2014-06-30 13:37:56', 'Author Services'),
(871, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 14:30:00', 'HouseKeeper'),
(872, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 15:00:05', 'HouseKeeper'),
(873, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 15:30:00', 'HouseKeeper'),
(874, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 16:00:01', 'HouseKeeper'),
(875, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 16:30:02', 'HouseKeeper'),
(876, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 224\nElapsed time in seconds: 5.504', '2014-06-30 16:36:58', 'Author Services'),
(877, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 224\nElapsed time in seconds: 7.283', '2014-06-30 16:57:27', 'Author Services'),
(878, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 17:00:00', 'HouseKeeper'),
(879, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 17:30:01', 'HouseKeeper'),
(880, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 18:00:00', 'HouseKeeper'),
(881, 120, 'Server Database Error\nNamedQuery of name: Activity.findByLesson not found.\n\njava.lang.IllegalArgumentException: NamedQuery of name: Activity.findByLesson not found.\n\nClass: org.eclipse.persistence.internal.jpa.QueryImpl\nMethod: getDatabaseQueryInternal\nLine Number: 350\n', '2014-06-30 18:11:11', 'Author Services'),
(882, 120, 'Server Database Error\nNamedQuery of name: Activity.findByLesson not found.\n\njava.lang.IllegalArgumentException: NamedQuery of name: Activity.findByLesson not found.\n\nClass: org.eclipse.persistence.internal.jpa.QueryImpl\nMethod: getDatabaseQueryInternal\nLine Number: 350\n', '2014-06-30 18:15:20', 'Author Services'),
(883, 105, 'Unknown request detected. Ignored.', '2014-06-30 18:24:11', 'Author Services'),
(884, 105, 'Unknown request detected. Ignored.', '2014-06-30 18:29:07', 'Author Services'),
(885, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 18:30:01', 'HouseKeeper'),
(886, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 19:00:00', 'HouseKeeper'),
(887, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 19:30:01', 'HouseKeeper'),
(888, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 20:00:00', 'HouseKeeper'),
(889, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 20:30:00', 'HouseKeeper'),
(890, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 21:00:00', 'HouseKeeper'),
(891, 133, 'CourseMaker temporary files cleaned up', '2014-06-30 21:30:00', 'HouseKeeper'),
(892, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 07:08:49', 'HouseKeeper'),
(893, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 07:51:45', 'HouseKeeper'),
(894, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 08:00:00', 'HouseKeeper'),
(895, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 08:30:00', 'HouseKeeper'),
(896, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 09:00:00', 'HouseKeeper'),
(897, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 11:06:42', 'HouseKeeper'),
(898, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 11:30:00', 'HouseKeeper'),
(899, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 12:34:40', 'HouseKeeper'),
(900, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 13:00:00', 'HouseKeeper'),
(901, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 13:30:00', 'HouseKeeper'),
(902, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 14:00:01', 'HouseKeeper'),
(903, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 14:30:00', 'HouseKeeper'),
(904, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 16:33:33', 'HouseKeeper'),
(905, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 17:00:00', 'HouseKeeper'),
(906, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 17:30:00', 'HouseKeeper'),
(907, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 18:00:00', 'HouseKeeper'),
(908, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 18:30:00', 'HouseKeeper'),
(909, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 19:00:01', 'HouseKeeper'),
(910, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 19:30:00', 'HouseKeeper'),
(911, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 20:00:00', 'HouseKeeper'),
(912, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 20:36:36', 'HouseKeeper'),
(913, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 6181\nElapsed time in seconds: 8.589', '2014-07-01 20:54:36', 'Instructor Services'),
(914, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 21:00:01', 'HouseKeeper'),
(915, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 21:30:00', 'HouseKeeper'),
(916, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 6181\nElapsed time in seconds: 5.095', '2014-07-01 21:43:44', 'Instructor Services'),
(917, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 22:00:00', 'HouseKeeper'),
(918, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 22:30:00', 'HouseKeeper'),
(919, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 23:00:03', 'HouseKeeper'),
(920, 133, 'CourseMaker temporary files cleaned up', '2014-07-01 23:30:00', 'HouseKeeper'),
(921, 120, 'Server Database Error\nFailed to add trainee activity', '2014-07-01 23:59:08', 'Instructor Services'),
(922, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 00:00:06', 'HouseKeeper'),
(923, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 00:30:00', 'HouseKeeper'),
(924, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 303\nElapsed time in seconds: 868.37', '2014-07-02 00:53:26', 'Instructor Services'),
(925, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 303\nElapsed time in seconds: 628.202', '2014-07-02 00:53:26', 'Instructor Services'),
(926, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 303\nElapsed time in seconds: 216.406', '2014-07-02 00:53:26', 'Instructor Services'),
(927, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 303\nElapsed time in seconds: 927.342', '2014-07-02 00:53:26', 'Instructor Services'),
(928, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 303\nElapsed time in seconds: 808.353', '2014-07-02 00:53:26', 'Instructor Services'),
(929, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 01:00:01', 'HouseKeeper'),
(930, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 303\nElapsed time in seconds: 160.542', '2014-07-02 01:00:42', 'Instructor Services'),
(931, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 303\nElapsed time in seconds: 220.563', '2014-07-02 01:00:42', 'Instructor Services'),
(932, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 303\nElapsed time in seconds: 41.518', '2014-07-02 01:03:01', 'Instructor Services'),
(933, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 01:30:00', 'HouseKeeper'),
(934, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 04:45:58', 'HouseKeeper'),
(935, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 06:34:36', 'HouseKeeper'),
(936, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 10:02:51', 'HouseKeeper'),
(937, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 10:30:00', 'HouseKeeper'),
(938, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 11:00:04', 'HouseKeeper'),
(939, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 11:30:02', 'HouseKeeper'),
(940, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 6181\nElapsed time in seconds: 5.705', '2014-07-02 11:33:22', 'Instructor Services'),
(941, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 12:00:00', 'HouseKeeper'),
(942, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 12:30:07', 'HouseKeeper'),
(943, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 6.535', '2014-07-02 12:46:55', 'Instructor Services'),
(944, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 13:00:01', 'HouseKeeper'),
(945, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 13:30:00', 'HouseKeeper'),
(946, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 5.984', '2014-07-02 13:34:52', 'Instructor Services'),
(947, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 9.736', '2014-07-02 13:36:46', 'Instructor Services'),
(948, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 10.53', '2014-07-02 13:37:10', 'Instructor Services'),
(949, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 14:00:02', 'HouseKeeper'),
(950, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 14:30:00', 'HouseKeeper'),
(951, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 15:00:00', 'HouseKeeper'),
(952, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 15:30:00', 'HouseKeeper'),
(953, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 18:16:50', 'HouseKeeper'),
(954, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 19:21:17', 'HouseKeeper'),
(955, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 19:30:00', 'HouseKeeper'),
(956, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 20:00:02', 'HouseKeeper'),
(957, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 20:30:00', 'HouseKeeper'),
(958, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 21:00:00', 'HouseKeeper'),
(959, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 21:30:00', 'HouseKeeper'),
(960, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 22:00:00', 'HouseKeeper'),
(961, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 22:30:02', 'HouseKeeper'),
(962, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 6.557', '2014-07-02 22:57:52', 'Instructor Services'),
(963, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 23:00:01', 'HouseKeeper'),
(964, 133, 'CourseMaker temporary files cleaned up', '2014-07-02 23:30:07', 'HouseKeeper'),
(965, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 16.752', '2014-07-02 23:35:02', 'Instructor Services'),
(966, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 14.314', '2014-07-02 23:45:11', 'Instructor Services'),
(967, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 00:00:02', 'HouseKeeper'),
(968, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 12.243', '2014-07-03 00:19:57', 'Instructor Services'),
(969, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 01:48:01', 'HouseKeeper'),
(970, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 07:33:42', 'HouseKeeper'),
(971, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 08:00:00', 'HouseKeeper'),
(972, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 08:30:00', 'HouseKeeper'),
(973, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 10.586', '2014-07-03 08:56:46', 'Instructor Services'),
(974, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 09:00:07', 'HouseKeeper'),
(975, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 17.067', '2014-07-03 09:00:18', 'Instructor Services'),
(976, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 14.287', '2014-07-03 09:02:42', 'Instructor Services'),
(977, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 09:30:04', 'HouseKeeper'),
(978, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 10:00:01', 'HouseKeeper'),
(979, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 10:30:00', 'HouseKeeper'),
(980, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 6.464', '2014-07-03 10:44:15', 'Instructor Services'),
(981, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 11:00:04', 'HouseKeeper'),
(982, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 11:30:00', 'HouseKeeper'),
(983, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 12:55:00', 'HouseKeeper'),
(984, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 13:00:01', 'HouseKeeper'),
(985, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 13:30:00', 'HouseKeeper'),
(986, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 14:00:00', 'HouseKeeper'),
(987, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 14:30:00', 'HouseKeeper'),
(988, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 15:00:00', 'HouseKeeper'),
(989, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 15:30:00', 'HouseKeeper'),
(990, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 18:33:38', 'HouseKeeper'),
(991, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 19:00:00', 'HouseKeeper'),
(992, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 19:30:00', 'HouseKeeper'),
(993, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 5.598', '2014-07-03 19:41:51', 'Instructor Services'),
(994, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 20:00:02', 'HouseKeeper'),
(995, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 5.677', '2014-07-03 20:03:24', 'Instructor Services'),
(996, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 20:30:00', 'HouseKeeper'),
(997, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 21:00:00', 'HouseKeeper'),
(998, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 21:30:00', 'HouseKeeper'),
(999, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 22:00:00', 'HouseKeeper'),
(1000, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 22:30:00', 'HouseKeeper'),
(1001, 133, 'CourseMaker temporary files cleaned up', '2014-07-03 23:00:00', 'HouseKeeper'),
(1002, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 02:48:02', 'HouseKeeper'),
(1003, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 06:24:47', 'HouseKeeper'),
(1004, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 08:17:04', 'HouseKeeper'),
(1005, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 08:30:00', 'HouseKeeper'),
(1006, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 09:00:00', 'HouseKeeper'),
(1007, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 09:30:00', 'HouseKeeper'),
(1008, 0, 'Google Cloud Messaging device registered to Google successfully\nThis device can now participate in push messaging', '2014-07-04 10:38:30', 'Cloud Messaging Service'),
(1009, 0, 'Trainee logging in with new device\nBoha Hacker Academy\n\nAubrey Maluleke\n', '2014-07-04 10:38:31', 'Trainee Services'),
(1010, 0, 'New Trainee Registered\n\nBryan Malabie\nBoha Hacker Academy', '2014-07-04 11:13:45', 'Administrator Services'),
(1011, 0, 'New Trainee Registered\n\nFrankie Abalone\nBoha Hacker Academy', '2014-07-04 11:32:16', 'Administrator Services'),
(1012, 120, 'Server Database Error\nFailed to register Trainee\nException [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry ''tiger.malenga@gmail.com'' for key ''email''\nError Code: 1062\nCall: INSERT INTO trainee (activeFlag, address, cellphone, dateRegistered, dateUpdated, email, firstName, GCMRegistrationID, gender, IDNumber, lastName, middleName, password, administratorID, cityID, companyID, institutionID, trainingClassID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n	bind => [18 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Trainee[ traineeID=0 ])\n\njavax.persistence.PersistenceException: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry ''tiger.malenga@gmail.com'' for key ''email''\nError Code: 1062\nCall: INSERT INTO trainee (activeFlag, address, cellphone, dateRegistered, dateUpdated, email, firstName, GCMRegistrationID, gender, IDNumber, lastName, middleName, password, administratorID, cityID, companyID, institutionID, trainingClassID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n	bind => [18 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Trainee[ traineeID=0 ])\n\nClass: org.eclipse.persistence.internal.jpa.EntityManagerImpl\nMethod: flush\nLine Number: 851\n', '2014-07-04 18:24:27', 'Administrator Services'),
(1013, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 4\nElapsed time in seconds: 11.501', '2014-07-04 18:24:30', 'Administrator Services'),
(1014, 0, 'New Trainee Registered\n\nQwerty Trainee Smith\nBoha Hacker Academy', '2014-07-04 18:25:43', 'Administrator Services'),
(1015, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 107\nElapsed time in seconds: 58.842', '2014-07-04 19:30:00', 'Administrator Services'),
(1016, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 107\nElapsed time in seconds: 238.871', '2014-07-04 19:30:00', 'Administrator Services'),
(1017, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 19:30:05', 'HouseKeeper'),
(1018, 0, 'New Trainee Registered\n\nZachary Zuckerberg\nBoha Hacker Academy', '2014-07-04 19:37:01', 'Administrator Services'),
(1019, 0, 'New Trainee Registered\n\nThelma Louise Charlestown\nBoha Hacker Academy', '2014-07-04 19:39:23', 'Administrator Services'),
(1020, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 20:00:00', 'HouseKeeper'),
(1021, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 20:30:00', 'HouseKeeper'),
(1022, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 21:00:01', 'HouseKeeper'),
(1023, 0, 'Photo downloaded to web app\nfile: /Applications/NetBeans/glassfish-4.0/glassfish/domains/domain1/docroot/coursemaker_images/company1/trainee/153.jpg', '2014-07-04 21:04:51', 'PhotoServlet'),
(1024, 0, 'Photo downloaded to web app\nfile: /Applications/NetBeans/glassfish-4.0/glassfish/domains/domain1/docroot/coursemaker_images/company1/trainee/153.jpg', '2014-07-04 21:10:52', 'PhotoServlet'),
(1025, 0, 'Photo downloaded to web app\nfile: /Applications/NetBeans/glassfish-4.0/glassfish/domains/cmdomain/docroot/coursemaker_images/company1/trainee/153.jpg', '2014-07-04 21:12:41', 'PhotoServlet'),
(1026, 0, 'Photo downloaded to web app\nfile: /Applications/NetBeans/glassfish-4.0/glassfish/domains/cmdomain/docroot/coursemaker_images/company1/trainee/153.jpg', '2014-07-04 21:13:27', 'PhotoServlet'),
(1027, 0, 'Photo downloaded to web app\nfile: /Applications/NetBeans/glassfish-4.0/glassfish/domains/cmdomain/docroot/coursemaker_images/company1/instructor/24.jpg', '2014-07-04 21:14:48', 'PhotoServlet'),
(1028, 0, 'Photo downloaded to web app\nfile: /Applications/NetBeans/glassfish-4.0/glassfish/domains/cmdomain/docroot/coursemaker_images/company1/instructor/25.jpg', '2014-07-04 21:15:19', 'PhotoServlet'),
(1029, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 21:30:00', 'HouseKeeper'),
(1030, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 22:00:00', 'HouseKeeper'),
(1031, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 22:30:00', 'HouseKeeper'),
(1032, 0, 'Photo downloaded to web app\nfile: /Applications/NetBeans/glassfish-4.0/glassfish/domains/cmdomain/docroot/coursemaker_images/company1/trainee/153.jpg', '2014-07-04 22:49:19', 'PhotoServlet'),
(1033, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 23:00:00', 'HouseKeeper'),
(1034, 133, 'CourseMaker temporary files cleaned up', '2014-07-04 23:30:00', 'HouseKeeper'),
(1035, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 00:00:02', 'HouseKeeper'),
(1036, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 03:30:55', 'HouseKeeper'),
(1037, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 04:58:27', 'HouseKeeper'),
(1038, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 05:00:00', 'HouseKeeper'),
(1039, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 05:30:00', 'HouseKeeper'),
(1040, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 06:00:02', 'HouseKeeper'),
(1041, 0, 'Google Cloud Messaging device registered to Google successfully\nThis device can now participate in push messaging', '2014-07-05 06:13:50', 'Cloud Messaging Service'),
(1042, 0, 'Trainee logging in with new device\nBoha Hacker Academy\n\nTiger Malabie\n', '2014-07-05 06:13:50', 'Trainee Services'),
(1043, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 06:30:03', 'HouseKeeper'),
(1044, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 07:00:00', 'HouseKeeper'),
(1045, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 07:30:00', 'HouseKeeper'),
(1046, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 08:00:04', 'HouseKeeper'),
(1047, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 08:30:00', 'HouseKeeper'),
(1048, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 09:00:00', 'HouseKeeper'),
(1049, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 09:30:00', 'HouseKeeper'),
(1050, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 10:00:00', 'HouseKeeper'),
(1051, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 10:30:00', 'HouseKeeper'),
(1052, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 12:28:40', 'HouseKeeper'),
(1053, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 12:30:00', 'HouseKeeper'),
(1054, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 13:00:00', 'HouseKeeper'),
(1055, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 13:30:00', 'HouseKeeper'),
(1056, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 14:00:04', 'HouseKeeper'),
(1057, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 14:30:00', 'HouseKeeper'),
(1058, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 15:00:00', 'HouseKeeper'),
(1059, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 15:30:12', 'HouseKeeper'),
(1060, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 16:00:00', 'HouseKeeper'),
(1061, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 16:30:00', 'HouseKeeper'),
(1062, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 17:00:01', 'HouseKeeper'),
(1063, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 17:30:00', 'HouseKeeper'),
(1064, 120, 'Server Database Error\nFailed to add team\nException [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry ''1-Holistic Hackers'' for key ''trainingClassID_2''\nError Code: 1062\nCall: INSERT INTO team (dateRegistered, teamName, trainingClassID) VALUES (?, ?, ?)\n	bind => [3 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Team[ teamID=0 ])\n\njavax.persistence.PersistenceException: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.5.0.v20130507-3faac2b): org.eclipse.persistence.exceptions.DatabaseException\nInternal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry ''1-Holistic Hackers'' for key ''trainingClassID_2''\nError Code: 1062\nCall: INSERT INTO team (dateRegistered, teamName, trainingClassID) VALUES (?, ?, ?)\n	bind => [3 parameters bound]\nQuery: InsertObjectQuery(com.boha.coursemaker.data.Team[ teamID=0 ])\n\nClass: org.eclipse.persistence.internal.jpa.EntityManagerImpl\nMethod: flush\nLine Number: 851\n', '2014-07-05 17:38:12', 'Team Services'),
(1065, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 18:00:00', 'HouseKeeper'),
(1066, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 18:30:00', 'HouseKeeper'),
(1067, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 19:00:01', 'HouseKeeper'),
(1068, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 19:30:00', 'HouseKeeper'),
(1069, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 20:00:00', 'HouseKeeper'),
(1070, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 20:30:00', 'HouseKeeper'),
(1071, 888, 'Instructors not found for Cloud Messaging', '2014-07-05 20:47:15', 'Cloud Message Services'),
(1072, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 701\nElapsed time in seconds: 10.138', '2014-07-05 20:56:40', 'Trainee Services'),
(1073, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 21:00:07', 'HouseKeeper'),
(1074, 100, 'Unexpected Server Exception\njavax.ejb.EJBException\n\nClass: com.sun.ejb.containers.EJBContainerTransactionManager\nMethod: processSystemException\nLine Number: 748\n', '2014-07-05 21:03:48', 'Trainee Services'),
(1075, 100, 'Unexpected Server Exception\njavax.ejb.EJBException\n\nClass: com.sun.ejb.containers.EJBContainerTransactionManager\nMethod: processSystemException\nLine Number: 748\n', '2014-07-05 21:07:17', 'Trainee Services'),
(1076, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 21:30:00', 'HouseKeeper'),
(1077, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 22:00:02', 'HouseKeeper'),
(1078, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 22:30:00', 'HouseKeeper'),
(1079, 111, 'Servlet took more than 5 seconds to process request\nRequest type is 609\nElapsed time in seconds: 8.204', '2014-07-05 22:46:41', 'Instructor Services'),
(1080, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 23:00:03', 'HouseKeeper'),
(1081, 133, 'CourseMaker temporary files cleaned up', '2014-07-05 23:30:00', 'HouseKeeper'),
(1082, 120, 'java.lang.Long cannot be cast to java.lang.Integer', '2014-07-05 23:36:09', 'PlatformServlet'),
(1083, 120, 'java.lang.Long cannot be cast to java.lang.Integer', '2014-07-06 00:55:15', 'PlatformServlet'),
(1084, 133, 'CourseMaker temporary files cleaned up', '2014-07-06 01:00:02', 'HouseKeeper');

-- --------------------------------------------------------

--
-- Table structure for table `errorStoreAndroid`
--

CREATE TABLE `errorStoreAndroid` (
  `errorStoreAndroidID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `companyID` int(10) unsigned DEFAULT NULL,
  `errorDate` datetime NOT NULL,
  `packageName` varchar(150) NOT NULL,
  `appVersionName` varchar(10) NOT NULL,
  `appVersionCode` varchar(10) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `phoneModel` varchar(100) NOT NULL,
  `androidVersion` varchar(20) NOT NULL,
  `stackTrace` text NOT NULL,
  `logCat` text NOT NULL,
  PRIMARY KEY (`errorStoreAndroidID`),
  KEY `companyID` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `errorStoreAndroid`
--

INSERT INTO `errorStoreAndroid` (`errorStoreAndroidID`, `companyID`, `errorDate`, `packageName`, `appVersionName`, `appVersionCode`, `brand`, `phoneModel`, `androidVersion`, `stackTrace`, `logCat`) VALUES
(1, 1, '2014-07-05 06:06:24', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmtrainee.fragments.TraineeListFragment.onCreateView(TraineeListFragment.java:86)\n	at android.support.v4.app.Fragment.performCreateView(Fragment.java:1478)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:927)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1104)\n	at android.support.v4.app.BackStackRecord.run(BackStackRecord.java:682)\n	at android.support.v4.app.FragmentManagerImpl.execPendingActions(FragmentManager.java:1460)\n	at android.support.v4.app.FragmentManagerImpl.executePendingTransactions(FragmentManager.java:472)\n	at android.support.v4.app.FragmentStatePagerAdapter.finishUpdate(FragmentStatePagerAdapter.java:163)\n	at android.support.v4.view.ViewPager.populate(ViewPager.java:1068)\n	at android.support.v4.view.ViewPager.populate(ViewPager.java:914)\n	at android.support.v4.view.ViewPager.setAdapter(ViewPager.java:442)\n	at com.boha.cmtrainee.MainPagerActivity.initializePager(MainPagerActivity.java:159)\n	at com.boha.cmtrainee.MainPagerActivity.buildPages(MainPagerActivity.java:152)\n	at com.boha.cmtrainee.MainPagerActivity.access$100(MainPagerActivity.java:37)\n	at com.boha.cmtrainee.MainPagerActivity$1.onResponseReceived(MainPagerActivity.java:103)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:99)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:21)\n	at com.android.volley.ExecutorDelivery$ResponseDeliveryRunnable.run(ExecutorDelivery.java:99)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 06:04:48.436 D/ACRA    (24175): Using custom Report Fields\n07-05 06:04:48.446 I/ACRA    (24175): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 06:04:48.466 D/ACRA    (24175): Retrieving logcat output...\n07-05 06:04:48.501 D/ACRA    (24175): Writing crash report file 1404533088000.stacktrace.\n07-05 06:04:48.516 D/ACRA    (24175): About to start ReportSenderWorker from #handleException\n07-05 06:04:48.516 D/ACRA    (24175): Mark all pending reports as approved.\n07-05 06:04:48.516 D/ACRA    (24175): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 06:04:48.516 D/ACRA    (24175): Waiting for Toast + worker...\n07-05 06:04:48.516 D/ACRA    (24175): #checkAndSendReports - start\n07-05 06:04:48.516 D/ACRA    (24175): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 06:04:48.516 I/ACRA    (24175): Sending file 1404533088000-approved.stacktrace\n07-05 06:04:48.536 D/ACRA    (24175): Connect to http://192.168.1.111:8050/cm/crash\n07-05 06:04:48.566 D/ACRA    (24175): Sending request to http://192.168.1.111:8050/cm/crash\n07-05 06:04:48.656 I/System.out(24175): Thread-6967 calls detatch()\n07-05 06:04:48.656 D/ACRA    (24175): #checkAndSendReports - finish\n07-05 06:04:48.716 D/ACRA    (24175): Wait for Toast + worker ended. Kill Application ? true\n07-05 06:04:48.726 E/AndroidRuntime(24175): FATAL EXCEPTION: main\n07-05 06:04:48.726 E/AndroidRuntime(24175): Process: com.boha.cmtrainee, PID: 24175\n07-05 06:04:48.726 E/AndroidRuntime(24175): java.lang.NullPointerException\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.boha.cmtrainee.fragments.TraineeListFragment.onCreateView(TraineeListFragment.java:86)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.app.Fragment.performCreateView(Fragment.java:1478)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:927)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1104)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.app.BackStackRecord.run(BackStackRecord.java:682)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.app.FragmentManagerImpl.execPendingActions(FragmentManager.java:1460)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.app.FragmentManagerImpl.executePendingTransactions(FragmentManager.java:472)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.app.FragmentStatePagerAdapter.finishUpdate(FragmentStatePagerAdapter.java:163)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.view.ViewPager.populate(ViewPager.java:1068)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.view.ViewPager.populate(ViewPager.java:914)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.support.v4.view.ViewPager.setAdapter(ViewPager.java:442)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.boha.cmtrainee.MainPagerActivity.initializePager(MainPagerActivity.java:159)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.boha.cmtrainee.MainPagerActivity.buildPages(MainPagerActivity.java:152)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.boha.cmtrainee.MainPagerActivity.access$100(MainPagerActivity.java:37)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.boha.cmtrainee.MainPagerActivity$1.onResponseReceived(MainPagerActivity.java:103)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:99)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:91)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:91)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:21)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.android.volley.ExecutorDelivery$ResponseDeliveryRunnable.run(ExecutorDelivery.java:99)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.os.Handler.handleCallback(Handler.java:733)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.os.Handler.dispatchMessage(Handler.java:95)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.os.Looper.loop(Looper.java:157)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at android.app.ActivityThread.main(ActivityThread.java:5356)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at java.lang.reflect.Method.invokeNative(Native Method)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at java.lang.reflect.Method.invoke(Method.java:515)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n07-05 06:04:48.726 E/AndroidRuntime(24175): 	at dalvik.system.NativeStart.main(Native Method)\n07-05 06:06:18.371 I/Process (24175): Sending signal. PID: 24175 SIG: 9\n07-05 06:06:22.536 D/dalvikvm(24364): Late-enabling CheckJNI\n07-05 06:06:22.611 D/CMApp   (24364): ############################ onCreate CMApp has started ---------------->\n07-05 06:06:22.616 D/ACRA    (24364): ACRA is enabled for com.boha.cmtrainee, intializing...\n07-05 06:06:22.636 D/ACRA    (24364): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 06:06:22.636 E/CMApp   (24364): ###### ACRA Crash Reporting has been initiated\n07-05 06:06:22.636 E/CMApp   (24364): initializing Volley Networking ...\n07-05 06:06:22.641 I/CMApp   (24364): ********** Yebo! Volley Networking has been initialized, cache size: 16384 KB\n07-05 06:06:22.656 W/ApplicationPackageManager(24364): getCSCPackageItemText()\n07-05 06:06:22.721 E/BohaVolley(24364): initializing Volley Networking ...\n07-05 06:06:22.726 I/BohaVolley(24364): Yebo! Volley Networking has been initialized\n07-05 06:06:22.756 D/BaseRegistration(24364): -------> Returning user, not a virgin. OK!\n07-05 06:06:22.786 W/ApplicationPackageManager(24364): getCSCPackageItemText()\n07-05 06:06:22.786 E/MainPagerActivity(24364): ---- onCreate\n07-05 06:06:22.846 E/MainPagerActivity(24364): onResume ...nuthin be done\n07-05 06:06:22.951 D/OpenGLRenderer(24364): Enabling debug mode 0\n07-05 06:06:22.991 I/WebCheck(24364): ###### WIFI AVAILABLE on check\n07-05 06:06:22.991 I/WebCheck(24364): ###### WIFI CONNECTED on check\n07-05 06:06:22.991 I/WebCheck(24364): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:06:22.991 E/WebCheck(24364): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:06:22.991 D/WebCheck(24364): ###### Network check completed in 2 ms\n07-05 06:06:23.166 I/BaseVolley(24364): ...sending remote request: .......>\n07-05 06:06:23.166 I/BaseVolley(24364): http://192.168.1.111:8050/cm/trainee?JSON={"trainingClassID":3,"companyID":1,"traineeID":132,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":301,"returnEquipment":false}\n07-05 06:06:23.166 I/BohaRequest(24364): ...Cloud Server communication started ...\n07-05 06:06:23.186 D/ProgressBar(24364): updateDrawableBounds: left = 0\n07-05 06:06:23.186 D/ProgressBar(24364): updateDrawableBounds: top = 0\n07-05 06:06:23.186 D/ProgressBar(24364): updateDrawableBounds: right = 48\n07-05 06:06:23.186 D/ProgressBar(24364): updateDrawableBounds: bottom = 48\n07-05 06:06:23.276 I/System.out(24364): Thread-6957(HTTPLog):SmartBonding Enabling is false, log to file is false, DBG is false\n07-05 06:06:23.746 D/BohaRequest(24364): parsing response, elapsed since start: 0.581 seconds\n07-05 06:06:23.761 I/BohaRequest(24364): response string length returned: 2086\n07-05 06:06:23.956 D/dalvikvm(24364): GC_FOR_ALLOC freed 2067K, 19% free 17762K/21808K, paused 23ms, total 23ms\n07-05 06:06:24.006 I/BohaRequest(24364): ---- Comms elapsed time: 0.839 seconds\n07-05 06:06:24.006 E/BaseVolley(24364): Yup! ...response object received, status code: 0\n07-05 06:06:24.016 I/MainPagerActivity(24364): ############ --building first 3 pages\n07-05 06:06:24.021 D/DashboardFragment(24364): ---- onAttach\n07-05 06:06:24.021 I/DashboardFragment(24364): -- onCreateView ............\n07-05 06:06:24.036 D/dalvikvm(24364): GC_FOR_ALLOC freed 449K, 19% free 17686K/21808K, paused 13ms, total 13ms\n07-05 06:06:24.041 I/dalvikvm-heap(24364): Grow heap (frag case) to 19.694MB for 515824-byte allocation\n07-05 06:06:24.056 D/dalvikvm(24364): GC_FOR_ALLOC freed 9K, 19% free 18179K/22312K, paused 13ms, total 13ms\n07-05 06:06:24.076 D/ProgressBar(24364): setProgressDrawable drawableHeight = 0\n07-05 06:06:24.101 W/DashboardFragment(24364): Trainee activities found: 6\n07-05 06:06:24.101 I/DashboardFragment(24364): *** setData from response object \n07-05 06:06:24.116 D/TraineeListFragment(24364): ---- onAttach\n07-05 06:06:24.116 I/TraineeListFragment(24364): -- onCreateView ............\n07-05 06:06:24.126 D/AbsListView(24364): Get MotionRecognitionManager\n07-05 06:06:24.136 D/AndroidRuntime(24364): Shutting down VM\n07-05 06:06:24.136 W/dalvikvm(24364): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 06:06:24.136 E/ACRA    (24364): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 06:06:24.136 D/ACRA    (24364): Using custom Report Fields\n07-05 06:06:24.141 I/ACRA    (24364): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 06:06:24.161 D/ACRA    (24364): Retrieving logcat output...\n'),
(2, 1, '2014-07-05 06:13:52', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmtrainee.fragments.TraineeListFragment.onCreateView(TraineeListFragment.java:86)\n	at android.support.v4.app.Fragment.performCreateView(Fragment.java:1478)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:927)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1104)\n	at android.support.v4.app.BackStackRecord.run(BackStackRecord.java:682)\n	at android.support.v4.app.FragmentManagerImpl.execPendingActions(FragmentManager.java:1460)\n	at android.support.v4.app.FragmentManagerImpl.executePendingTransactions(FragmentManager.java:472)\n	at android.support.v4.app.FragmentStatePagerAdapter.finishUpdate(FragmentStatePagerAdapter.java:163)\n	at android.support.v4.view.ViewPager.populate(ViewPager.java:1068)\n	at android.support.v4.view.ViewPager.populate(ViewPager.java:914)\n	at android.support.v4.view.ViewPager.setAdapter(ViewPager.java:442)\n	at com.boha.cmtrainee.MainPagerActivity.initializePager(MainPagerActivity.java:159)\n	at com.boha.cmtrainee.MainPagerActivity.buildPages(MainPagerActivity.java:152)\n	at com.boha.cmtrainee.MainPagerActivity.access$100(MainPagerActivity.java:37)\n	at com.boha.cmtrainee.MainPagerActivity$1.onResponseReceived(MainPagerActivity.java:103)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:99)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:21)\n	at com.android.volley.ExecutorDelivery$ResponseDeliveryRunnable.run(ExecutorDelivery.java:99)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 06:13:00.466 D/CMApp   (25659): ############################ onCreate CMApp has started ---------------->\n07-05 06:13:00.476 D/ACRA    (25659): ACRA is enabled for com.boha.cmtrainee, intializing...\n07-05 06:13:00.496 D/ACRA    (25659): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 06:13:00.506 D/ACRA    (25659): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 06:13:00.511 E/CMApp   (25659): ###### ACRA Crash Reporting has been initiated\n07-05 06:13:00.511 E/CMApp   (25659): initializing Volley Networking ...\n07-05 06:13:00.541 I/CMApp   (25659): ********** Yebo! Volley Networking has been initialized, cache size: 16384 KB\n07-05 06:13:00.566 W/ApplicationPackageManager(25659): getCSCPackageItemText()\n07-05 06:13:00.861 E/BohaVolley(25659): initializing Volley Networking ...\n07-05 06:13:00.871 I/BohaVolley(25659): Yebo! Volley Networking has been initialized\n07-05 06:13:00.881 E/GCMUtil (25659): ... startin GCM registration\n07-05 06:13:00.911 I/BaseRegistration(25659): #################### onStart - locationClient connecting ... \n07-05 06:13:01.046 D/OpenGLRenderer(25659): Enabling debug mode 0\n07-05 06:13:01.246 I/BaseRegistration(25659): ### ---> PlayServices onConnected() - gotta go! >>\n07-05 06:13:01.601 D/Reg     (25659): ###### Email account selected is malengadev@gmail.com\n07-05 06:13:01.606 I/GCMUtil (25659): Saving regId on app version 1\n07-05 06:13:01.611 E/GCMUtil (25659): GCM regId saved in prefs! Yebo!!!\n07-05 06:13:01.611 I/GCMUtil (25659): Device registered, registration ID = \n07-05 06:13:01.611 I/GCMUtil (25659): APA91bFTX00swutYXARgwsOHPbcYdZ-X7pMRgrEWdlFU2rtwGE8shKLTQeIKmsvpTp6EKhcvgtb26Q5z0NFUdFZR1ePe6jAfs-ZS2pnb-KJ44eOdSLz4VMih65j1cI7B7ekEt5fEGxBgjRfOun_OvKD1luOeUUiNxQ\n07-05 06:13:01.646 I/GCMUtil (25659): ... ending GCM registration\n07-05 06:13:01.646 W/BaseRegistration(25659): onDeviceRegistered - stored in variable: APA91bFTX00swutYXARgwsOHPbcYdZ-X7pMRgrEWdlFU2rtwGE8shKLTQeIKmsvpTp6EKhcvgtb26Q5z0NFUdFZR1ePe6jAfs-ZS2pnb-KJ44eOdSLz4VMih65j1cI7B7ekEt5fEGxBgjRfOun_OvKD1luOeUUiNxQ\n07-05 06:13:06.366 D/AbsListView(25659): Get MotionRecognitionManager\n07-05 06:13:06.391 D/AbsListView(25659): unregisterIRListener() is called \n07-05 06:13:06.441 D/AbsListView(25659): unregisterIRListener() is called \n07-05 06:13:06.441 D/AbsListView(25659): unregisterIRListener() is called \n07-05 06:13:06.446 D/AbsListView(25659): unregisterIRListener() is called \n07-05 06:13:06.491 D/AbsListView(25659): unregisterIRListener() is called \n07-05 06:13:08.431 D/AbsListView(25659): onDetachedFromWindow\n07-05 06:13:08.431 D/AbsListView(25659): unregisterIRListener() is called \n07-05 06:13:08.481 E/ViewRootImpl(25659): sendUserActionEvent() mView == null\n07-05 06:13:08.481 D/Reg     (25659): ###### Email account selected is aubrey.malabie@gmail.com\n07-05 06:13:47.526 D/BaseRegistration(25659): ....getRemoteData ...type: 502 -- BaseRegistration\n07-05 06:13:47.531 I/WebCheck(25659): ###### WIFI AVAILABLE on check\n07-05 06:13:47.531 I/WebCheck(25659): ###### WIFI CONNECTED on check\n07-05 06:13:47.531 I/WebCheck(25659): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:13:47.531 E/WebCheck(25659): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:13:47.531 D/WebCheck(25659): ###### Network check completed in 3 ms\n07-05 06:13:47.706 I/BaseVolley(25659): ...sending remote request: .......>\n07-05 06:13:47.706 I/BaseVolley(25659): http://192.168.1.111:8050/cm/trainee?JSON={"email":"aubrey.malabie@gmail.com","gcmDevice":{"registrationID":"APA91bFTX00swutYXARgwsOHPbcYdZ-X7pMRgrEWdlFU2rtwGE8shKLTQeIKmsvpTp6EKhcvgtb26Q5z0NFUdFZR1ePe6jAfs-ZS2pnb-KJ44eOdSLz4VMih65j1cI7B7ekEt5fEGxBgjRfOun_OvKD1luOeUUiNxQ","dateRegistered":0},"password":"kktiger3","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":502,"returnEquipment":false}\n07-05 06:13:47.706 I/BohaRequest(25659): ...Cloud Server communication started ...\n07-05 06:13:47.706 D/ProgressBar(25659): updateDrawableBounds: left = 0\n07-05 06:13:47.706 D/ProgressBar(25659): updateDrawableBounds: top = 0\n07-05 06:13:47.706 D/ProgressBar(25659): updateDrawableBounds: right = 48\n07-05 06:13:47.706 D/ProgressBar(25659): updateDrawableBounds: bottom = 48\n07-05 06:13:47.771 I/System.out(25659): Thread-7082(HTTPLog):SmartBonding Enabling is false, log to file is false, DBG is false\n07-05 06:13:51.046 D/Volley  (25659): [7082] BasicNetwork.logSlowRequests: HTTP response for request=<[ ] http://192.168.1.111:8050/cm/trainee?JSON=%7B%22email%22%3A%22aubrey.malabie%40gmail.com%22%2C%22gcmDevice%22%3A%7B%22registrationID%22%3A%22APA91bFTX00swutYXARgwsOHPbcYdZ-X7pMRgrEWdlFU2rtwGE8shKLTQeIKmsvpTp6EKhcvgtb26Q5z0NFUdFZR1ePe6jAfs-ZS2pnb-KJ44eOdSLz4VMih65j1cI7B7ekEt5fEGxBgjRfOun_OvKD1luOeUUiNxQ%22%2C%22dateRegistered%22%3A0%7D%2C%22password%22%3A%22kktiger3%22%2C%22zippedResponse%22%3Atrue%2C%22startDate%22%3A0%2C%22calendarID%22%3A0%2C%22endDate%22%3A0%2C%22dateTo%22%3A0%2C%22dateFrom%22%3A0%2C%22requestType%22%3A502%2C%22returnEquipment%22%3Afalse%7D 0x85bc0df5 NORMAL 1> [lifetime=3336], [size=2225], [rc=200], [retryCount=0]\n07-05 06:13:51.046 D/BohaRequest(25659): parsing response, elapsed since start: 3.341 seconds\n07-05 06:13:51.056 I/BohaRequest(25659): response string length returned: 2085\n07-05 06:13:51.281 D/dalvikvm(25659): GC_FOR_ALLOC freed 2088K, 19% free 17741K/21808K, paused 21ms, total 21ms\n07-05 06:13:51.291 D/AbsListView(25659): [unregisterDoubleTapMotionListener]\n07-05 06:13:51.291 I/MotionRecognitionManager(25659):   .unregisterListener : / listener count = 0->0,  \n07-05 06:13:51.291 D/AbsListView(25659): unregisterIRListener() is called \n07-05 06:13:51.341 I/BohaRequest(25659): ---- Comms elapsed time: 3.633 seconds\n07-05 06:13:51.341 E/BaseVolley(25659): Yup! ...response object received, status code: 0\n07-05 06:13:51.346 E/BaseRegistration(25659): ....Yup! got a response from the server, type = 502\n07-05 06:13:51.361 I/BaseRegistration(25659): Company saved by SharedUtil\n07-05 06:13:51.386 I/BaseRegistration(25659): Trainee saved by SharedUtil\n07-05 06:13:51.411 I/BaseRegistration(25659): Training Class saved by SharedUtil\n07-05 06:13:51.411 W/BaseRegistration(25659): ###### APP actor Preferences saved. Cool!\n07-05 06:13:51.436 I/RegistrationAct trainee(25659): processRemoteResponse - startMain comin up!\n07-05 06:13:51.456 D/Volley  (25659): [1] Request.finish: 3747 ms: [ ] http://192.168.1.111:8050/cm/trainee?JSON=%7B%22email%22%3A%22aubrey.malabie%40gmail.com%22%2C%22gcmDevice%22%3A%7B%22registrationID%22%3A%22APA91bFTX00swutYXARgwsOHPbcYdZ-X7pMRgrEWdlFU2rtwGE8shKLTQeIKmsvpTp6EKhcvgtb26Q5z0NFUdFZR1ePe6jAfs-ZS2pnb-KJ44eOdSLz4VMih65j1cI7B7ekEt5fEGxBgjRfOun_OvKD1luOeUUiNxQ%22%2C%22dateRegistered%22%3A0%7D%2C%22password%22%3A%22kktiger3%22%2C%22zippedResponse%22%3Atrue%2C%22startDate%22%3A0%2C%22calendarID%22%3A0%2C%22endDate%22%3A0%2C%22dateTo%22%3A0%2C%22dateFrom%22%3A0%2C%22requestType%22%3A502%2C%22returnEquipment%22%3Afalse%7D 0x85bc0df5 NORMAL 1\n07-05 06:13:51.466 I/REG     (25659): -- onPause ---\n07-05 06:13:51.481 W/ApplicationPackageManager(25659): getCSCPackageItemText()\n07-05 06:13:51.486 E/MainPagerActivity(25659): ---- onCreate\n07-05 06:13:51.531 E/MainPagerActivity(25659): onResume ...nuthin be done\n07-05 06:13:51.636 I/WebCheck(25659): ###### WIFI AVAILABLE on check\n07-05 06:13:51.636 I/WebCheck(25659): ###### WIFI CONNECTED on check\n07-05 06:13:51.636 I/WebCheck(25659): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:13:51.636 E/WebCheck(25659): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:13:51.636 D/WebCheck(25659): ###### Network check completed in 1 ms\n07-05 06:13:51.696 I/BaseVolley(25659): ...sending remote request: .......>\n07-05 06:13:51.696 I/BaseVolley(25659): http://192.168.1.111:8050/cm/trainee?JSON={"trainingClassID":1,"companyID":1,"traineeID":117,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":301,"returnEquipment":false}\n07-05 06:13:51.696 I/BohaRequest(25659): ...Cloud Server communication started ...\n07-05 06:13:51.706 D/ProgressBar(25659): updateDrawableBounds: left = 0\n07-05 06:13:51.706 D/ProgressBar(25659): updateDrawableBounds: top = 0\n07-05 06:13:51.706 D/ProgressBar(25659): updateDrawableBounds: right = 48\n07-05 06:13:51.706 D/ProgressBar(25659): updateDrawableBounds: bottom = 48\n07-05 06:13:51.906 D/BohaRequest(25659): parsing response, elapsed since start: 0.212 seconds\n07-05 06:13:51.906 I/BohaRequest(25659): response string length returned: 1496\n07-05 06:13:52.086 D/dalvikvm(25659): GC_FOR_ALLOC freed 1905K, 18% free 17883K/21808K, paused 28ms, total 29ms\n07-05 06:13:52.131 I/BohaRequest(25659): ---- Comms elapsed time: 0.435 seconds\n07-05 06:13:52.131 E/BaseVolley(25659): Yup! ...response object received, status code: 0\n07-05 06:13:52.146 I/MainPagerActivity(25659): ############ --building first 3 pages\n07-05 06:13:52.151 D/DashboardFragment(25659): ---- onAttach\n07-05 06:13:52.151 I/DashboardFragment(25659): -- onCreateView ............\n07-05 06:13:52.186 D/dalvikvm(25659): GC_FOR_ALLOC freed 341K, 19% free 17817K/21808K, paused 24ms, total 24ms\n07-05 06:13:52.186 I/dalvikvm-heap(25659): Grow heap (frag case) to 19.822MB for 515824-byte allocation\n07-05 06:13:52.211 D/dalvikvm(25659): GC_FOR_ALLOC freed 3K, 18% free 18317K/22312K, paused 24ms, total 24ms\n07-05 06:13:52.246 D/ProgressBar(25659): setProgressDrawable drawableHeight = 0\n07-05 06:13:52.261 W/DashboardFragment(25659): Trainee activities found: 6\n07-05 06:13:52.261 I/DashboardFragment(25659): *** setData from response object \n07-05 06:13:52.271 D/TraineeListFragment(25659): ---- onAttach\n07-05 06:13:52.271 I/TraineeListFragment(25659): -- onCreateView ............\n07-05 06:13:52.281 D/AbsListView(25659): Get MotionRecognitionManager\n07-05 06:13:52.281 D/AndroidRuntime(25659): Shutting down VM\n07-05 06:13:52.281 W/dalvikvm(25659): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 06:13:52.281 E/ACRA    (25659): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 06:13:52.286 D/ACRA    (25659): Using custom Report Fields\n07-05 06:13:52.291 I/ACRA    (25659): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 06:13:52.311 D/ACRA    (25659): Retrieving logcat output...\n'),
(3, 1, '2014-07-05 06:14:35', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmtrainee.fragments.TraineeListFragment.onCreateView(TraineeListFragment.java:86)\n	at android.support.v4.app.Fragment.performCreateView(Fragment.java:1478)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:927)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1104)\n	at android.support.v4.app.BackStackRecord.run(BackStackRecord.java:682)\n	at android.support.v4.app.FragmentManagerImpl.execPendingActions(FragmentManager.java:1460)\n	at android.support.v4.app.FragmentManagerImpl.executePendingTransactions(FragmentManager.java:472)\n	at android.support.v4.app.FragmentStatePagerAdapter.finishUpdate(FragmentStatePagerAdapter.java:163)\n	at android.support.v4.view.ViewPager.populate(ViewPager.java:1068)\n	at android.support.v4.view.ViewPager.populate(ViewPager.java:914)\n	at android.support.v4.view.ViewPager.setAdapter(ViewPager.java:442)\n	at com.boha.cmtrainee.MainPagerActivity.initializePager(MainPagerActivity.java:159)\n	at com.boha.cmtrainee.MainPagerActivity.buildPages(MainPagerActivity.java:152)\n	at com.boha.cmtrainee.MainPagerActivity.access$100(MainPagerActivity.java:37)\n	at com.boha.cmtrainee.MainPagerActivity$1.onResponseReceived(MainPagerActivity.java:103)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:99)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:21)\n	at com.android.volley.ExecutorDelivery$ResponseDeliveryRunnable.run(ExecutorDelivery.java:99)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 06:13:52.281 E/ACRA    (25659): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 06:13:52.286 D/ACRA    (25659): Using custom Report Fields\n07-05 06:13:52.291 I/ACRA    (25659): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 06:13:52.311 D/ACRA    (25659): Retrieving logcat output...\n07-05 06:13:52.336 D/ACRA    (25659): Writing crash report file 1404533632000.stacktrace.\n07-05 06:13:52.346 D/ACRA    (25659): About to start ReportSenderWorker from #handleException\n07-05 06:13:52.346 D/ACRA    (25659): Mark all pending reports as approved.\n07-05 06:13:52.346 D/ACRA    (25659): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 06:13:52.346 D/ACRA    (25659): Waiting for Toast + worker...\n07-05 06:13:52.351 D/ACRA    (25659): #checkAndSendReports - start\n07-05 06:13:52.351 D/ACRA    (25659): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 06:13:52.351 I/ACRA    (25659): Sending file 1404533632000-approved.stacktrace\n07-05 06:13:52.366 D/ACRA    (25659): Connect to http://192.168.1.111:8050/cm/crash\n07-05 06:13:52.391 D/ACRA    (25659): Sending request to http://192.168.1.111:8050/cm/crash\n07-05 06:13:52.506 I/System.out(25659): Thread-7098 calls detatch()\n07-05 06:13:52.506 D/ACRA    (25659): #checkAndSendReports - finish\n07-05 06:13:52.551 D/ACRA    (25659): Wait for Toast + worker ended. Kill Application ? true\n--------- beginning of /dev/log/system\n07-05 06:13:52.551 E/AndroidRuntime(25659): FATAL EXCEPTION: main\n07-05 06:13:52.551 E/AndroidRuntime(25659): Process: com.boha.cmtrainee, PID: 25659\n07-05 06:13:52.551 E/AndroidRuntime(25659): java.lang.NullPointerException\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.boha.cmtrainee.fragments.TraineeListFragment.onCreateView(TraineeListFragment.java:86)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.app.Fragment.performCreateView(Fragment.java:1478)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:927)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1104)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.app.BackStackRecord.run(BackStackRecord.java:682)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.app.FragmentManagerImpl.execPendingActions(FragmentManager.java:1460)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.app.FragmentManagerImpl.executePendingTransactions(FragmentManager.java:472)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.app.FragmentStatePagerAdapter.finishUpdate(FragmentStatePagerAdapter.java:163)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.view.ViewPager.populate(ViewPager.java:1068)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.view.ViewPager.populate(ViewPager.java:914)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.support.v4.view.ViewPager.setAdapter(ViewPager.java:442)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.boha.cmtrainee.MainPagerActivity.initializePager(MainPagerActivity.java:159)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.boha.cmtrainee.MainPagerActivity.buildPages(MainPagerActivity.java:152)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.boha.cmtrainee.MainPagerActivity.access$100(MainPagerActivity.java:37)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.boha.cmtrainee.MainPagerActivity$1.onResponseReceived(MainPagerActivity.java:103)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:99)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:91)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:91)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:21)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.android.volley.ExecutorDelivery$ResponseDeliveryRunnable.run(ExecutorDelivery.java:99)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.os.Handler.handleCallback(Handler.java:733)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.os.Handler.dispatchMessage(Handler.java:95)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.os.Looper.loop(Looper.java:157)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at android.app.ActivityThread.main(ActivityThread.java:5356)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at java.lang.reflect.Method.invokeNative(Native Method)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at java.lang.reflect.Method.invoke(Method.java:515)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n07-05 06:13:52.551 E/AndroidRuntime(25659): 	at dalvik.system.NativeStart.main(Native Method)\n07-05 06:14:32.846 I/Process (25659): Sending signal. PID: 25659 SIG: 9\n07-05 06:14:32.921 D/dalvikvm(25912): Late-enabling CheckJNI\n07-05 06:14:32.991 D/CMApp   (25912): ############################ onCreate CMApp has started ---------------->\n07-05 06:14:33.001 D/ACRA    (25912): ACRA is enabled for com.boha.cmtrainee, intializing...\n07-05 06:14:33.031 D/ACRA    (25912): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 06:14:33.031 E/CMApp   (25912): ###### ACRA Crash Reporting has been initiated\n07-05 06:14:33.031 E/CMApp   (25912): initializing Volley Networking ...\n07-05 06:14:33.041 I/CMApp   (25912): ********** Yebo! Volley Networking has been initialized, cache size: 16384 KB\n07-05 06:14:33.056 W/ApplicationPackageManager(25912): getCSCPackageItemText()\n07-05 06:14:33.061 E/MainPagerActivity(25912): ---- onCreate\n07-05 06:14:33.181 E/MainPagerActivity(25912): onResume ...nuthin be done\n07-05 06:14:33.316 D/OpenGLRenderer(25912): Enabling debug mode 0\n07-05 06:14:33.361 I/WebCheck(25912): ###### WIFI AVAILABLE on check\n07-05 06:14:33.361 I/WebCheck(25912): ###### WIFI CONNECTED on check\n07-05 06:14:33.361 I/WebCheck(25912): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:14:33.361 E/WebCheck(25912): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:14:33.361 D/WebCheck(25912): ###### Network check completed in 4 ms\n07-05 06:14:33.366 E/BohaVolley(25912): initializing Volley Networking ...\n07-05 06:14:33.371 I/BohaVolley(25912): Yebo! Volley Networking has been initialized\n07-05 06:14:33.501 I/BaseVolley(25912): ...sending remote request: .......>\n07-05 06:14:33.501 I/BaseVolley(25912): http://192.168.1.111:8050/cm/trainee?JSON={"trainingClassID":1,"companyID":1,"traineeID":117,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":301,"returnEquipment":false}\n07-05 06:14:33.506 I/BohaRequest(25912): ...Cloud Server communication started ...\n07-05 06:14:33.526 D/ProgressBar(25912): updateDrawableBounds: left = 0\n07-05 06:14:33.526 D/ProgressBar(25912): updateDrawableBounds: top = 0\n07-05 06:14:33.526 D/ProgressBar(25912): updateDrawableBounds: right = 48\n07-05 06:14:33.526 D/ProgressBar(25912): updateDrawableBounds: bottom = 48\n07-05 06:14:33.626 I/System.out(25912): Thread-7091(HTTPLog):SmartBonding Enabling is false, log to file is false, DBG is false\n07-05 06:14:34.381 D/BohaRequest(25912): parsing response, elapsed since start: 0.872 seconds\n07-05 06:14:34.396 I/BohaRequest(25912): response string length returned: 1496\n07-05 06:14:34.621 D/dalvikvm(25912): GC_FOR_ALLOC freed 2120K, 19% free 17709K/21808K, paused 22ms, total 22ms\n07-05 06:14:34.666 I/BohaRequest(25912): ---- Comms elapsed time: 1.16 seconds\n07-05 06:14:34.666 E/BaseVolley(25912): Yup! ...response object received, status code: 0\n07-05 06:14:34.681 I/MainPagerActivity(25912): ############ --building first 3 pages\n07-05 06:14:34.681 D/DashboardFragment(25912): ---- onAttach\n07-05 06:14:34.681 I/DashboardFragment(25912): -- onCreateView ............\n07-05 06:14:34.706 D/dalvikvm(25912): GC_FOR_ALLOC freed 315K, 20% free 17606K/21808K, paused 15ms, total 16ms\n07-05 06:14:34.706 I/dalvikvm-heap(25912): Grow heap (frag case) to 19.616MB for 515824-byte allocation\n07-05 06:14:34.721 D/dalvikvm(25912): GC_FOR_ALLOC freed 4K, 19% free 18106K/22312K, paused 14ms, total 14ms\n07-05 06:14:34.741 D/ProgressBar(25912): setProgressDrawable drawableHeight = 0\n07-05 06:14:34.766 W/DashboardFragment(25912): Trainee activities found: 6\n07-05 06:14:34.766 I/DashboardFragment(25912): *** setData from response object \n07-05 06:14:34.776 D/TraineeListFragment(25912): ---- onAttach\n07-05 06:14:34.776 I/TraineeListFragment(25912): -- onCreateView ............\n07-05 06:14:34.786 D/AbsListView(25912): Get MotionRecognitionManager\n07-05 06:14:34.796 D/AndroidRuntime(25912): Shutting down VM\n07-05 06:14:34.796 W/dalvikvm(25912): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 06:14:34.796 E/ACRA    (25912): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 06:14:34.796 D/ACRA    (25912): Using custom Report Fields\n07-05 06:14:34.801 I/ACRA    (25912): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 06:14:34.821 D/ACRA    (25912): Retrieving logcat output...\n'),
(4, 1, '2014-07-05 06:43:39', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'android.content.ActivityNotFoundException: Unable to find explicit activity class {com.boha.cmtrainee/com.boha.cmlibrary.ActivityListActivity}; have you declared this activity in your AndroidManifest.xml?\n	at android.app.Instrumentation.checkStartActivityResult(Instrumentation.java:1648)\n	at android.app.Instrumentation.execStartActivity(Instrumentation.java:1442)\n	at android.app.Activity.startActivityForResult(Activity.java:3511)\n	at android.app.Activity.startActivityForResult(Activity.java:3472)\n	at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:824)\n	at com.boha.cmtrainee.MainPagerActivity.onCoursePicked(MainPagerActivity.java:322)\n	at com.boha.cmtrainee.fragments.CourseListFragment$1.onItemClick(CourseListFragment.java:127)\n	at android.widget.AdapterView.performItemClick(AdapterView.java:308)\n	at android.widget.AbsListView.performItemClick(AbsListView.java:1483)\n	at android.widget.AbsListView$PerformClick.run(AbsListView.java:3485)\n	at android.widget.AbsListView$3.run(AbsListView.java:4843)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 06:42:33.841 I/TraineeListFragment(28062): onSaveInstanceState\n07-05 06:42:33.846 D/AbsListView(28062): onDetachedFromWindow\n07-05 06:42:33.846 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:42:33.851 E/TraineeProfileFragment(28062): ## onCreateView \n07-05 06:42:33.961 E/BohaVolley(28062): initializing Volley Networking ...\n07-05 06:42:33.981 I/BohaVolley(28062): Yebo! Volley Networking has been initialized\n07-05 06:42:33.991 D/TraineeProfileFragment(28062): *** attempting to set profile picture\n07-05 06:42:34.021 D/TraineeProfileFragment(28062): setting provinceSpinner ...\n07-05 06:42:34.031 D/TraineeProfileFragment(28062): loadForm - detected province, setting selection\n07-05 06:42:34.061 E/TraineeProfileFragment(28062): ## onResume in TraineeProfileFragment\n07-05 06:42:34.181 D/dalvikvm(28062): GC_EXPLICIT freed 25115K, 52% free 24941K/51932K, paused 8ms+22ms, total 185ms\n07-05 06:42:34.186 D/AbsListView(28062): [unregisterDoubleTapMotionListener]\n07-05 06:42:34.186 I/MotionRecognitionManager(28062):   .unregisterListener : / listener count = 0->0,  \n07-05 06:42:34.191 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:42:34.196 W/System.err(28062): java.lang.NullPointerException\n07-05 06:42:34.206 W/System.err(28062): 	at com.boha.coursemaker.util.ImageUtil.getResizedBitmap(ImageUtil.java:201)\n07-05 06:42:34.206 W/System.err(28062): 	at com.boha.coursemaker.util.FileTask$DTask.doInBackground(FileTask.java:31)\n07-05 06:42:34.211 W/System.err(28062): 	at com.boha.coursemaker.util.FileTask$DTask.doInBackground(FileTask.java:25)\n07-05 06:42:34.211 W/System.err(28062): 	at android.os.AsyncTask$2.call(AsyncTask.java:288)\n07-05 06:42:34.211 W/System.err(28062): 	at java.util.concurrent.FutureTask.run(FutureTask.java:237)\n07-05 06:42:34.211 W/System.err(28062): 	at android.os.AsyncTask$SerialExecutor$1.run(AsyncTask.java:231)\n07-05 06:42:34.211 W/System.err(28062): 	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1112)\n07-05 06:42:34.211 W/System.err(28062): 	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:587)\n07-05 06:42:34.211 W/System.err(28062): 	at java.lang.Thread.run(Thread.java:841)\n07-05 06:42:34.216 D/TraineeProfileFragment(28062): setting citySpinner ...-\n07-05 06:42:34.216 D/TraineeProfileFragment(28062): prov cities: 28\n07-05 06:42:34.216 D/TraineeProfileFragment(28062): Trainee city found: Broederstroom index: 6\n07-05 06:42:34.221 V/Vibrator(28062): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 06:42:34.221 V/Vibrator(28062): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 50, mag: -1\n07-05 06:42:34.231 E/ToastUtil(28062): Unable to save picture to disk. Please try again\n07-05 06:42:34.551 D/dalvikvm(28062): GC_EXPLICIT freed 819K, 53% free 24672K/51932K, paused 4ms+14ms, total 104ms\n07-05 06:42:34.551 D/ImageUtil(28062): ### Original Bitmap width: 210 height: 240\n07-05 06:42:34.556 D/ImageUtil(28062): ### Resized Bitmap width: 140 height: 160 rowBytes: 280\n07-05 06:42:34.611 D/dalvikvm(28062): GC_EXPLICIT freed 23K, 53% free 24694K/51932K, paused 3ms+8ms, total 53ms\n07-05 06:42:34.611 D/ImageUtil(28062): ### Original Bitmap width: 210 height: 240\n07-05 06:42:34.611 D/ImageUtil(28062): ### Resized Bitmap width: 175 height: 200 rowBytes: 350\n07-05 06:42:34.611 I/ImageUtil(28062): Directory for photos: /storage/emulated/0/Pictures/coursemaker\n07-05 06:42:34.611 I/ImageUtil(28062): File to be filled with bitmap: /storage/emulated/0/Pictures/coursemaker/picM1404535354617.jpg\n07-05 06:42:34.626 E/ImageUtil(28062): File saved from bitmap: /storage/emulated/0/Pictures/coursemaker/picM1404535354617.jpg\n07-05 06:42:34.626 I/ImageUtil(28062): Directory for photos: /storage/emulated/0/Pictures/coursemaker\n07-05 06:42:34.631 I/ImageUtil(28062): File to be filled with bitmap: /storage/emulated/0/Pictures/coursemaker/picT1404535354634.jpg\n07-05 06:42:34.636 E/ImageUtil(28062): File saved from bitmap: /storage/emulated/0/Pictures/coursemaker/picT1404535354634.jpg\n07-05 06:42:34.661 V/Vibrator(28062): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 06:42:34.661 V/Vibrator(28062): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 06:42:45.436 I/CourseListFragment(28062): ##### onSaveInstanceState  fired ....\n07-05 06:42:45.436 D/AbsListView(28062): onDetachedFromWindow\n07-05 06:42:45.436 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:04.196 D/AbsListView(28062): Get MotionRecognitionManager\n07-05 06:43:04.201 I/CourseListFragment(28062): saved is not null\n07-05 06:43:04.206 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:04.206 E/CourseListFragment(28062): ## onResume\n07-05 06:43:04.366 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:06.486 I/TraineeProfileFragment(28062): ##### onSaveInstanceState  fired ....TraineeProfileFragment\n07-05 06:43:06.491 D/TraineeListFragment(28062): ---- onAttach\n07-05 06:43:06.491 I/TraineeListFragment(28062): -- onCreateView ............\n07-05 06:43:06.496 D/AbsListView(28062): Get MotionRecognitionManager\n07-05 06:43:06.501 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:06.501 D/TraineeListFragment(28062): ---- onResume - nothing to be done\n07-05 06:43:06.561 D/dalvikvm(28062): GC_FOR_ALLOC freed 467K, 53% free 24820K/51932K, paused 32ms, total 32ms\n07-05 06:43:06.566 D/AbsListView(28062): [unregisterDoubleTapMotionListener]\n07-05 06:43:06.566 I/dalvikvm-heap(28062): Grow heap (frag case) to 36.780MB for 11059216-byte allocation\n07-05 06:43:06.591 D/dalvikvm(28062): GC_FOR_ALLOC freed <1K, 32% free 35620K/51932K, paused 26ms, total 26ms\n07-05 06:43:06.596 I/MotionRecognitionManager(28062):   .unregisterListener : / listener count = 0->0,  \n07-05 06:43:06.596 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:06.596 D/AbsListView(28062): [unregisterDoubleTapMotionListener]\n07-05 06:43:06.596 I/MotionRecognitionManager(28062):   .unregisterListener : / listener count = 0->0,  \n07-05 06:43:06.596 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:06.676 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:06.711 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:09.721 W/TeamListFragment(28062): ## onSaveInstanceState\n07-05 06:43:09.721 D/AbsListView(28062): onDetachedFromWindow\n07-05 06:43:09.721 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:09.726 D/DashboardFragment(28062): ---- onAttach\n07-05 06:43:09.726 I/DashboardFragment(28062): -- onCreateView ............\n07-05 06:43:09.746 D/ProgressBar(28062): setProgressDrawable drawableHeight = 0\n07-05 06:43:09.761 W/DashboardFragment(28062): Trainee activities found: 6\n07-05 06:43:09.761 I/DashboardFragment(28062): *** setData from response object \n07-05 06:43:09.791 D/ProgressBar(28062): updateDrawableBounds: left = 0\n07-05 06:43:09.791 D/ProgressBar(28062): updateDrawableBounds: top = 0\n07-05 06:43:09.791 D/ProgressBar(28062): updateDrawableBounds: right = 876\n07-05 06:43:09.791 D/ProgressBar(28062): updateDrawableBounds: bottom = 60\n07-05 06:43:09.791 D/ProgressBar(28062): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 06:43:12.446 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:12.641 E/Volley  (28062): [7151] BasicNetwork.performRequest: Unexpected response code 404 for http://192.168.1.111:8050/coursemaker_images/company1/trainee/157.jpg\n07-05 06:43:17.066 I/TeamListFragment(28062): ##### onCreateView\n07-05 06:43:17.066 E/TeamListFragment(28062): TrainingClassID = 1\n07-05 06:43:17.101 D/AbsListView(28062): Get MotionRecognitionManager\n07-05 06:43:17.106 V/Vibrator(28062): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 06:43:17.106 V/Vibrator(28062): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 06:43:17.131 E/TeamListFragment(28062): TeamList is fucked!\n07-05 06:43:17.131 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:17.136 W/TeamListFragment(28062): ## onResume\n07-05 06:43:17.146 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:38.751 D/AbsListView(28062): unregisterIRListener() is called \n07-05 06:43:38.971 D/AndroidRuntime(28062): Shutting down VM\n07-05 06:43:38.971 W/dalvikvm(28062): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 06:43:38.971 E/ACRA    (28062): ACRA caught a ActivityNotFoundException exception for com.boha.cmtrainee. Building report.\n07-05 06:43:38.971 D/ACRA    (28062): Using custom Report Fields\n07-05 06:43:38.981 I/ACRA    (28062): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 06:43:39.016 D/ACRA    (28062): Retrieving logcat output...\n');
INSERT INTO `errorStoreAndroid` (`errorStoreAndroidID`, `companyID`, `errorDate`, `packageName`, `appVersionName`, `appVersionCode`, `brand`, `phoneModel`, `androidVersion`, `stackTrace`, `logCat`) VALUES
(5, 1, '2014-07-05 06:46:45', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'android.content.ActivityNotFoundException: Unable to find explicit activity class {com.boha.cmtrainee/com.boha.cmlibrary.ActivityListActivity}; have you declared this activity in your AndroidManifest.xml?\n	at android.app.Instrumentation.checkStartActivityResult(Instrumentation.java:1648)\n	at android.app.Instrumentation.execStartActivity(Instrumentation.java:1442)\n	at android.app.Activity.startActivityForResult(Activity.java:3511)\n	at android.app.Activity.startActivityForResult(Activity.java:3472)\n	at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:824)\n	at com.boha.cmtrainee.MainPagerActivity.onCoursePicked(MainPagerActivity.java:322)\n	at com.boha.cmtrainee.fragments.CourseListFragment$1.onItemClick(CourseListFragment.java:127)\n	at android.widget.AdapterView.performItemClick(AdapterView.java:308)\n	at android.widget.AbsListView.performItemClick(AbsListView.java:1483)\n	at android.widget.AbsListView$PerformClick.run(AbsListView.java:3485)\n	at android.widget.AbsListView$3.run(AbsListView.java:4843)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 06:46:32.311 D/BaseRegistration(28543): -------> Returning user, not a virgin. OK!\n07-05 06:46:32.341 W/ApplicationPackageManager(28543): getCSCPackageItemText()\n07-05 06:46:32.341 E/MainPagerActivity(28543): ---- onCreate\n07-05 06:46:32.411 E/MainPagerActivity(28543): onResume ...nuthin be done\n07-05 06:46:32.516 D/OpenGLRenderer(28543): Enabling debug mode 0\n07-05 06:46:32.551 I/WebCheck(28543): ###### WIFI AVAILABLE on check\n07-05 06:46:32.551 I/WebCheck(28543): ###### WIFI CONNECTED on check\n07-05 06:46:32.551 I/WebCheck(28543): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:46:32.551 E/WebCheck(28543): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:46:32.551 D/WebCheck(28543): ###### Network check completed in 4 ms\n07-05 06:46:32.686 I/BaseVolley(28543): ...sending remote request: .......>\n07-05 06:46:32.686 I/BaseVolley(28543): http://192.168.1.111:8050/cm/trainee?JSON={"trainingClassID":1,"companyID":1,"traineeID":117,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":301,"returnEquipment":false}\n07-05 06:46:32.686 I/BohaRequest(28543): ...Cloud Server communication started ...\n07-05 06:46:32.706 D/ProgressBar(28543): updateDrawableBounds: left = 0\n07-05 06:46:32.706 D/ProgressBar(28543): updateDrawableBounds: top = 0\n07-05 06:46:32.706 D/ProgressBar(28543): updateDrawableBounds: right = 48\n07-05 06:46:32.706 D/ProgressBar(28543): updateDrawableBounds: bottom = 48\n07-05 06:46:32.826 D/dalvikvm(28543): GC_FOR_ALLOC freed 2182K, 20% free 17647K/21808K, paused 23ms, total 23ms\n07-05 06:46:32.871 I/System.out(28543): Thread-7160(HTTPLog):SmartBonding Enabling is false, log to file is false, DBG is false\n07-05 06:46:33.356 D/BohaRequest(28543): parsing response, elapsed since start: 0.667 seconds\n07-05 06:46:33.361 I/BohaRequest(28543): response string length returned: 2868\n07-05 06:46:33.631 I/BohaRequest(28543): ---- Comms elapsed time: 0.943 seconds\n07-05 06:46:33.631 E/BaseVolley(28543): Yup! ...response object received, status code: 0\n07-05 06:46:33.636 I/MainPagerActivity(28543): ############ --building first 3 pages\n07-05 06:46:33.641 D/DashboardFragment(28543): ---- onAttach\n07-05 06:46:33.641 I/DashboardFragment(28543): -- onCreateView ............\n07-05 06:46:33.666 D/dalvikvm(28543): GC_FOR_ALLOC freed 1210K, 19% free 17802K/21808K, paused 16ms, total 17ms\n07-05 06:46:33.666 I/dalvikvm-heap(28543): Grow heap (frag case) to 19.807MB for 515824-byte allocation\n07-05 06:46:33.681 D/dalvikvm(28543): GC_FOR_ALLOC freed 3K, 18% free 18302K/22312K, paused 14ms, total 14ms\n07-05 06:46:33.701 D/ProgressBar(28543): setProgressDrawable drawableHeight = 0\n07-05 06:46:33.726 W/DashboardFragment(28543): Trainee activities found: 6\n07-05 06:46:33.726 I/DashboardFragment(28543): *** setData from response object \n07-05 06:46:33.741 D/TraineeListFragment(28543): ---- onAttach\n07-05 06:46:33.741 I/TraineeListFragment(28543): -- onCreateView ............\n07-05 06:46:33.751 D/AbsListView(28543): Get MotionRecognitionManager\n07-05 06:46:33.766 D/AbsListView(28543): unregisterIRListener() is called \n07-05 06:46:33.766 D/TraineeListFragment(28543): ---- onResume - nothing to be done\n07-05 06:46:33.766 I/MainPagerActivity(28543): ---- getting class teams\n07-05 06:46:33.766 I/WebCheck(28543): ###### WIFI AVAILABLE on check\n07-05 06:46:33.766 I/WebCheck(28543): ###### WIFI CONNECTED on check\n07-05 06:46:33.766 I/WebCheck(28543): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:46:33.766 E/WebCheck(28543): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:46:33.766 D/WebCheck(28543): ###### Network check completed in 2 ms\n07-05 06:46:33.851 I/BaseVolley(28543): ...sending remote request: .......>\n07-05 06:46:33.851 I/BaseVolley(28543): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 06:46:33.851 I/BohaRequest(28543): ...Cloud Server communication started ...\n07-05 06:46:33.891 D/ProgressBar(28543): updateDrawableBounds: left = 0\n07-05 06:46:33.891 D/ProgressBar(28543): updateDrawableBounds: top = 0\n07-05 06:46:33.891 D/ProgressBar(28543): updateDrawableBounds: right = 876\n07-05 06:46:33.891 D/ProgressBar(28543): updateDrawableBounds: bottom = 60\n07-05 06:46:33.891 D/ProgressBar(28543): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 06:46:33.971 D/dalvikvm(28543): GC_FOR_ALLOC freed 998K, 17% free 18558K/22312K, paused 37ms, total 37ms\n07-05 06:46:34.021 I/dalvikvm-heap(28543): Grow heap (frag case) to 30.601MB for 11059216-byte allocation\n07-05 06:46:34.041 D/dalvikvm(28543): GC_FOR_ALLOC freed 5K, 12% free 29352K/33116K, paused 17ms, total 18ms\n07-05 06:46:34.056 D/BohaRequest(28543): parsing response, elapsed since start: 0.202 seconds\n07-05 06:46:34.056 I/BohaRequest(28543): response string length returned: 219\n07-05 06:46:34.151 D/AbsListView(28543): unregisterIRListener() is called \n07-05 06:46:34.151 D/ProgressBar(28543): updateDrawableBounds: left = 0\n07-05 06:46:34.151 D/ProgressBar(28543): updateDrawableBounds: top = 0\n07-05 06:46:34.151 D/ProgressBar(28543): updateDrawableBounds: right = 48\n07-05 06:46:34.151 D/ProgressBar(28543): updateDrawableBounds: bottom = 48\n07-05 06:46:34.186 D/AbsListView(28543): unregisterIRListener() is called \n07-05 06:46:34.266 W/CacheUtil(28543): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 06:46:34.306 I/BohaRequest(28543): ---- Comms elapsed time: 0.454 seconds\n07-05 06:46:34.306 E/BaseVolley(28543): Yup! ...response object received, status code: 0\n07-05 06:46:34.316 W/MainPagerActivity(28543): getting provinces ...\n07-05 06:46:34.316 I/MainPagerActivity(28543): Country code is ZA\n07-05 06:46:34.321 I/WebCheck(28543): ###### WIFI AVAILABLE on check\n07-05 06:46:34.321 I/WebCheck(28543): ###### WIFI CONNECTED on check\n07-05 06:46:34.321 I/WebCheck(28543): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:46:34.321 E/WebCheck(28543): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:46:34.321 D/WebCheck(28543): ###### Network check completed in 2 ms\n07-05 06:46:34.396 I/BaseVolley(28543): ...sending remote request: .......>\n07-05 06:46:34.396 I/BaseVolley(28543): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 06:46:34.396 I/BohaRequest(28543): ...Cloud Server communication started ...\n07-05 06:46:34.421 D/AbsListView(28543): unregisterIRListener() is called \n07-05 06:46:34.541 D/BohaRequest(28543): parsing response, elapsed since start: 0.148 seconds\n07-05 06:46:34.546 I/BohaRequest(28543): response string length returned: 3064\n07-05 06:46:34.846 I/BohaRequest(28543): ---- Comms elapsed time: 0.452 seconds\n07-05 06:46:34.846 E/BaseVolley(28543): Yup! ...response object received, status code: 0\n07-05 06:46:38.111 D/AbsListView(28543): Get MotionRecognitionManager\n07-05 06:46:38.121 D/AbsListView(28543): unregisterIRListener() is called \n07-05 06:46:38.121 E/CourseListFragment(28543): ## onResume\n07-05 06:46:38.241 D/AbsListView(28543): unregisterIRListener() is called \n07-05 06:46:40.031 I/TeamListFragment(28543): ##### onCreateView\n07-05 06:46:40.031 E/TeamListFragment(28543): TrainingClassID = 1\n07-05 06:46:40.041 D/AbsListView(28543): Get MotionRecognitionManager\n07-05 06:46:40.046 V/Vibrator(28543): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 06:46:40.046 V/Vibrator(28543): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 06:46:40.061 E/TeamListFragment(28543): TeamList is fucked!\n07-05 06:46:40.061 D/AbsListView(28543): unregisterIRListener() is called \n07-05 06:46:40.061 W/TeamListFragment(28543): ## onResume\n07-05 06:46:40.076 D/AbsListView(28543): unregisterIRListener() is called \n07-05 06:46:45.571 D/AbsListView(28543): unregisterIRListener() is called \n07-05 06:46:45.681 D/AndroidRuntime(28543): Shutting down VM\n07-05 06:46:45.681 W/dalvikvm(28543): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 06:46:45.681 E/ACRA    (28543): ACRA caught a ActivityNotFoundException exception for com.boha.cmtrainee. Building report.\n07-05 06:46:45.686 D/ACRA    (28543): Using custom Report Fields\n07-05 06:46:45.691 I/ACRA    (28543): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 06:46:45.721 D/ACRA    (28543): Retrieving logcat output...\n'),
(6, 1, '2014-07-05 06:51:13', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.RuntimeException: Unable to start activity ComponentInfo{com.boha.cmtrainee/com.boha.cmlibrary.ActivityListActivity}: java.lang.NullPointerException\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2305)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\nCaused by: java.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.setTrainingClassCourse(ActivityPageFragment.java:144)\n	at com.boha.cmlibrary.ActivityListActivity.onCreate(ActivityListActivity.java:27)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	... 11 more\njava.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.setTrainingClassCourse(ActivityPageFragment.java:144)\n	at com.boha.cmlibrary.ActivityListActivity.onCreate(ActivityListActivity.java:27)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 06:50:46.326 I/WebCheck(29038): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:50:46.326 E/WebCheck(29038): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:50:46.326 D/WebCheck(29038): ###### Network check completed in 2 ms\n07-05 06:50:46.456 I/BaseVolley(29038): ...sending remote request: .......>\n07-05 06:50:46.456 I/BaseVolley(29038): http://192.168.1.111:8050/cm/trainee?JSON={"trainingClassID":1,"companyID":1,"traineeID":117,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":301,"returnEquipment":false}\n07-05 06:50:46.456 I/BohaRequest(29038): ...Cloud Server communication started ...\n07-05 06:50:46.471 D/ProgressBar(29038): updateDrawableBounds: left = 0\n07-05 06:50:46.471 D/ProgressBar(29038): updateDrawableBounds: top = 0\n07-05 06:50:46.471 D/ProgressBar(29038): updateDrawableBounds: right = 48\n07-05 06:50:46.471 D/ProgressBar(29038): updateDrawableBounds: bottom = 48\n07-05 06:50:46.621 D/dalvikvm(29038): GC_FOR_ALLOC freed 2182K, 20% free 17647K/21808K, paused 24ms, total 24ms\n07-05 06:50:46.676 I/System.out(29038): Thread-7181(HTTPLog):SmartBonding Enabling is false, log to file is false, DBG is false\n07-05 06:50:47.001 D/BohaRequest(29038): parsing response, elapsed since start: 0.54 seconds\n07-05 06:50:47.001 I/BohaRequest(29038): response string length returned: 2868\n07-05 06:50:47.256 I/BohaRequest(29038): ---- Comms elapsed time: 0.8 seconds\n07-05 06:50:47.256 E/BaseVolley(29038): Yup! ...response object received, status code: 0\n07-05 06:50:47.276 I/MainPagerActivity(29038): ############ --building first 3 pages\n07-05 06:50:47.281 D/DashboardFragment(29038): ---- onAttach\n07-05 06:50:47.281 I/DashboardFragment(29038): -- onCreateView ............\n07-05 06:50:47.316 D/dalvikvm(29038): GC_FOR_ALLOC freed 1210K, 19% free 17799K/21808K, paused 26ms, total 27ms\n07-05 06:50:47.316 I/dalvikvm-heap(29038): Grow heap (frag case) to 19.804MB for 515824-byte allocation\n07-05 06:50:47.336 D/dalvikvm(29038): GC_FOR_ALLOC freed 4K, 18% free 18298K/22312K, paused 18ms, total 18ms\n07-05 06:50:47.366 D/ProgressBar(29038): setProgressDrawable drawableHeight = 0\n07-05 06:50:47.421 W/DashboardFragment(29038): Trainee activities found: 6\n07-05 06:50:47.421 I/DashboardFragment(29038): *** setData from response object \n07-05 06:50:47.441 D/TraineeListFragment(29038): ---- onAttach\n07-05 06:50:47.441 I/TraineeListFragment(29038): -- onCreateView ............\n07-05 06:50:47.466 D/AbsListView(29038): Get MotionRecognitionManager\n07-05 06:50:47.486 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:50:47.491 D/TraineeListFragment(29038): ---- onResume - nothing to be done\n07-05 06:50:47.491 I/MainPagerActivity(29038): ---- getting class teams\n07-05 06:50:47.496 I/WebCheck(29038): ###### WIFI AVAILABLE on check\n07-05 06:50:47.496 I/WebCheck(29038): ###### WIFI CONNECTED on check\n07-05 06:50:47.496 I/WebCheck(29038): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:50:47.496 E/WebCheck(29038): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:50:47.496 D/WebCheck(29038): ###### Network check completed in 1 ms\n07-05 06:50:47.596 I/BaseVolley(29038): ...sending remote request: .......>\n07-05 06:50:47.596 I/BaseVolley(29038): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 06:50:47.596 I/BohaRequest(29038): ...Cloud Server communication started ...\n07-05 06:50:47.621 D/ProgressBar(29038): updateDrawableBounds: left = 0\n07-05 06:50:47.621 D/ProgressBar(29038): updateDrawableBounds: top = 0\n07-05 06:50:47.621 D/ProgressBar(29038): updateDrawableBounds: right = 876\n07-05 06:50:47.621 D/ProgressBar(29038): updateDrawableBounds: bottom = 60\n07-05 06:50:47.621 D/ProgressBar(29038): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 06:50:47.666 D/dalvikvm(29038): GC_FOR_ALLOC freed 911K, 17% free 18533K/22312K, paused 21ms, total 21ms\n07-05 06:50:47.701 I/dalvikvm-heap(29038): Grow heap (frag case) to 30.577MB for 11059216-byte allocation\n07-05 06:50:47.726 D/dalvikvm(29038): GC_FOR_ALLOC freed 5K, 12% free 29328K/33116K, paused 24ms, total 24ms\n07-05 06:50:47.831 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:50:47.831 D/ProgressBar(29038): updateDrawableBounds: left = 0\n07-05 06:50:47.831 D/ProgressBar(29038): updateDrawableBounds: top = 0\n07-05 06:50:47.831 D/ProgressBar(29038): updateDrawableBounds: right = 48\n07-05 06:50:47.831 D/ProgressBar(29038): updateDrawableBounds: bottom = 48\n07-05 06:50:47.851 D/BohaRequest(29038): parsing response, elapsed since start: 0.256 seconds\n07-05 06:50:47.856 I/BohaRequest(29038): response string length returned: 219\n07-05 06:50:47.861 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:50:48.071 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:50:48.091 W/CacheUtil(29038): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 06:50:48.121 I/BohaRequest(29038): ---- Comms elapsed time: 0.527 seconds\n07-05 06:50:48.121 E/BaseVolley(29038): Yup! ...response object received, status code: 0\n07-05 06:50:48.136 W/MainPagerActivity(29038): getting provinces ...\n07-05 06:50:48.136 I/MainPagerActivity(29038): Country code is ZA\n07-05 06:50:48.136 I/WebCheck(29038): ###### WIFI AVAILABLE on check\n07-05 06:50:48.136 I/WebCheck(29038): ###### WIFI CONNECTED on check\n07-05 06:50:48.136 I/WebCheck(29038): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:50:48.136 E/WebCheck(29038): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:50:48.136 D/WebCheck(29038): ###### Network check completed in 2 ms\n07-05 06:50:48.201 I/BaseVolley(29038): ...sending remote request: .......>\n07-05 06:50:48.201 I/BaseVolley(29038): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 06:50:48.201 I/BohaRequest(29038): ...Cloud Server communication started ...\n07-05 06:50:48.366 D/BohaRequest(29038): parsing response, elapsed since start: 0.163 seconds\n07-05 06:50:48.371 I/BohaRequest(29038): response string length returned: 3064\n07-05 06:50:48.521 I/BohaRequest(29038): ---- Comms elapsed time: 0.318 seconds\n07-05 06:50:48.521 E/BaseVolley(29038): Yup! ...response object received, status code: 0\n07-05 06:51:07.451 D/AbsListView(29038): Get MotionRecognitionManager\n07-05 06:51:07.461 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:51:07.461 E/CourseListFragment(29038): ## onResume\n07-05 06:51:07.586 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:51:09.606 I/TeamListFragment(29038): ##### onCreateView\n07-05 06:51:09.611 E/TeamListFragment(29038): TrainingClassID = 1\n07-05 06:51:09.651 D/AbsListView(29038): Get MotionRecognitionManager\n07-05 06:51:09.661 V/Vibrator(29038): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 06:51:09.661 V/Vibrator(29038): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 06:51:09.691 E/TeamListFragment(29038): TeamList is fucked!\n07-05 06:51:09.691 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:51:09.691 W/TeamListFragment(29038): ## onResume\n07-05 06:51:09.716 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:51:13.016 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:51:13.326 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:51:13.326 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:51:13.331 D/AbsListView(29038): unregisterIRListener() is called \n07-05 06:51:13.331 W/ApplicationPackageManager(29038): getCSCPackageItemText()\n07-05 06:51:13.366 W/ActivityPageFragment(29038): ############################# onCreateView\n07-05 06:51:13.396 D/AbsListView(29038): Get MotionRecognitionManager\n07-05 06:51:13.411 W/ActivityPageFragment(29038): ############## setTrainingClassCourse\n07-05 06:51:13.411 D/AndroidRuntime(29038): Shutting down VM\n07-05 06:51:13.411 W/dalvikvm(29038): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 06:51:13.411 E/ACRA    (29038): ACRA caught a RuntimeException exception for com.boha.cmtrainee. Building report.\n07-05 06:51:13.411 D/ACRA    (29038): Using custom Report Fields\n07-05 06:51:13.421 I/ACRA    (29038): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 06:51:13.451 D/ACRA    (29038): Retrieving logcat output...\n'),
(7, 1, '2014-07-05 07:00:03', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.RuntimeException: Unable to start activity ComponentInfo{com.boha.cmtrainee/com.boha.cmlibrary.ActivityListActivity}: java.lang.NullPointerException\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2305)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\nCaused by: java.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.setTrainingClassCourse(ActivityPageFragment.java:144)\n	at com.boha.cmlibrary.ActivityListActivity.onCreate(ActivityListActivity.java:27)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	... 11 more\njava.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.setTrainingClassCourse(ActivityPageFragment.java:144)\n	at com.boha.cmlibrary.ActivityListActivity.onCreate(ActivityListActivity.java:27)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 06:59:14.281 E/WebCheck(30420): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:59:14.281 D/WebCheck(30420): ###### Network check completed in 2 ms\n07-05 06:59:14.421 I/BaseVolley(30420): ...sending remote request: .......>\n07-05 06:59:14.421 I/BaseVolley(30420): http://192.168.1.111:8050/cm/trainee?JSON={"trainingClassID":1,"companyID":1,"traineeID":117,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":301,"returnEquipment":false}\n07-05 06:59:14.421 I/BohaRequest(30420): ...Cloud Server communication started ...\n07-05 06:59:14.436 D/ProgressBar(30420): updateDrawableBounds: left = 0\n07-05 06:59:14.436 D/ProgressBar(30420): updateDrawableBounds: top = 0\n07-05 06:59:14.436 D/ProgressBar(30420): updateDrawableBounds: right = 48\n07-05 06:59:14.436 D/ProgressBar(30420): updateDrawableBounds: bottom = 48\n07-05 06:59:14.601 D/dalvikvm(30420): GC_FOR_ALLOC freed 2163K, 19% free 17666K/21808K, paused 25ms, total 26ms\n07-05 06:59:14.626 I/System.out(30420): Thread-7292(HTTPLog):SmartBonding Enabling is false, log to file is false, DBG is false\n07-05 06:59:15.016 D/BohaRequest(30420): parsing response, elapsed since start: 0.592 seconds\n07-05 06:59:15.016 I/BohaRequest(30420): response string length returned: 2868\n07-05 06:59:15.211 I/BohaRequest(30420): ---- Comms elapsed time: 0.787 seconds\n07-05 06:59:15.211 E/BaseVolley(30420): Yup! ...response object received, status code: 0\n07-05 06:59:15.221 I/MainPagerActivity(30420): ############ --building first 3 pages\n07-05 06:59:15.226 D/DashboardFragment(30420): ---- onAttach\n07-05 06:59:15.226 I/DashboardFragment(30420): -- onCreateView ............\n07-05 06:59:15.251 D/dalvikvm(30420): GC_FOR_ALLOC freed 1211K, 19% free 17789K/21808K, paused 19ms, total 19ms\n07-05 06:59:15.251 I/dalvikvm-heap(30420): Grow heap (frag case) to 19.794MB for 515824-byte allocation\n07-05 06:59:15.266 D/dalvikvm(30420): GC_FOR_ALLOC freed 11K, 19% free 18282K/22312K, paused 14ms, total 14ms\n07-05 06:59:15.286 D/ProgressBar(30420): setProgressDrawable drawableHeight = 0\n07-05 06:59:15.311 W/DashboardFragment(30420): Trainee activities found: 6\n07-05 06:59:15.311 I/DashboardFragment(30420): *** setData from response object \n07-05 06:59:15.321 D/TraineeListFragment(30420): ---- onAttach\n07-05 06:59:15.321 I/TraineeListFragment(30420): -- onCreateView ............\n07-05 06:59:15.341 D/AbsListView(30420): Get MotionRecognitionManager\n07-05 06:59:15.361 D/AbsListView(30420): unregisterIRListener() is called \n07-05 06:59:15.366 D/TraineeListFragment(30420): ---- onResume - nothing to be done\n07-05 06:59:15.366 I/MainPagerActivity(30420): ---- getting class teams\n07-05 06:59:15.366 I/WebCheck(30420): ###### WIFI AVAILABLE on check\n07-05 06:59:15.366 I/WebCheck(30420): ###### WIFI CONNECTED on check\n07-05 06:59:15.366 I/WebCheck(30420): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:59:15.366 E/WebCheck(30420): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:59:15.366 D/WebCheck(30420): ###### Network check completed in 2 ms\n07-05 06:59:15.441 I/BaseVolley(30420): ...sending remote request: .......>\n07-05 06:59:15.441 I/BaseVolley(30420): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 06:59:15.441 I/BohaRequest(30420): ...Cloud Server communication started ...\n07-05 06:59:15.461 D/ProgressBar(30420): updateDrawableBounds: left = 0\n07-05 06:59:15.461 D/ProgressBar(30420): updateDrawableBounds: top = 0\n07-05 06:59:15.461 D/ProgressBar(30420): updateDrawableBounds: right = 876\n07-05 06:59:15.461 D/ProgressBar(30420): updateDrawableBounds: bottom = 60\n07-05 06:59:15.461 D/ProgressBar(30420): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 06:59:15.501 D/dalvikvm(30420): GC_FOR_ALLOC freed 909K, 17% free 18540K/22312K, paused 17ms, total 17ms\n07-05 06:59:15.516 I/dalvikvm-heap(30420): Grow heap (frag case) to 30.583MB for 11059216-byte allocation\n07-05 06:59:15.531 D/dalvikvm(30420): GC_FOR_ALLOC freed 5K, 12% free 29335K/33116K, paused 15ms, total 15ms\n07-05 06:59:15.576 D/BohaRequest(30420): parsing response, elapsed since start: 0.131 seconds\n07-05 06:59:15.581 I/BohaRequest(30420): response string length returned: 219\n07-05 06:59:15.616 D/AbsListView(30420): unregisterIRListener() is called \n07-05 06:59:15.616 D/ProgressBar(30420): updateDrawableBounds: left = 0\n07-05 06:59:15.616 D/ProgressBar(30420): updateDrawableBounds: top = 0\n07-05 06:59:15.616 D/ProgressBar(30420): updateDrawableBounds: right = 48\n07-05 06:59:15.616 D/ProgressBar(30420): updateDrawableBounds: bottom = 48\n07-05 06:59:15.656 D/AbsListView(30420): unregisterIRListener() is called \n07-05 06:59:15.791 D/AbsListView(30420): unregisterIRListener() is called \n07-05 06:59:15.816 W/CacheUtil(30420): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 06:59:15.856 I/BohaRequest(30420): ---- Comms elapsed time: 0.413 seconds\n07-05 06:59:15.856 E/BaseVolley(30420): Yup! ...response object received, status code: 0\n07-05 06:59:15.866 W/MainPagerActivity(30420): getting provinces ...\n07-05 06:59:15.866 I/MainPagerActivity(30420): Country code is ZA\n07-05 06:59:15.866 I/WebCheck(30420): ###### WIFI AVAILABLE on check\n07-05 06:59:15.866 I/WebCheck(30420): ###### WIFI CONNECTED on check\n07-05 06:59:15.866 I/WebCheck(30420): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 06:59:15.866 E/WebCheck(30420): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 06:59:15.866 D/WebCheck(30420): ###### Network check completed in 2 ms\n07-05 06:59:15.926 I/BaseVolley(30420): ...sending remote request: .......>\n07-05 06:59:15.926 I/BaseVolley(30420): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 06:59:15.926 I/BohaRequest(30420): ...Cloud Server communication started ...\n07-05 06:59:15.946 D/AbsListView(30420): unregisterIRListener() is called \n07-05 06:59:16.046 D/BohaRequest(30420): parsing response, elapsed since start: 0.117 seconds\n07-05 06:59:16.046 I/BohaRequest(30420): response string length returned: 3064\n07-05 06:59:16.191 I/BohaRequest(30420): ---- Comms elapsed time: 0.261 seconds\n07-05 06:59:16.191 E/BaseVolley(30420): Yup! ...response object received, status code: 0\n07-05 06:59:49.686 D/AbsListView(30420): Get MotionRecognitionManager\n07-05 06:59:49.696 D/AbsListView(30420): unregisterIRListener() is called \n07-05 06:59:49.696 E/CourseListFragment(30420): ## onResume\n07-05 06:59:49.801 D/AbsListView(30420): unregisterIRListener() is called \n07-05 06:59:50.856 I/TeamListFragment(30420): ##### onCreateView\n07-05 06:59:50.856 E/TeamListFragment(30420): TrainingClassID = 1\n07-05 06:59:50.876 D/AbsListView(30420): Get MotionRecognitionManager\n07-05 06:59:50.881 V/Vibrator(30420): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 06:59:50.881 V/Vibrator(30420): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 06:59:50.896 E/TeamListFragment(30420): TeamList is fucked!\n07-05 06:59:50.901 D/AbsListView(30420): unregisterIRListener() is called \n07-05 06:59:50.901 W/TeamListFragment(30420): ## onResume\n07-05 06:59:50.911 D/AbsListView(30420): unregisterIRListener() is called \n07-05 07:00:03.041 D/AbsListView(30420): unregisterIRListener() is called \n07-05 07:00:03.261 D/AbsListView(30420): unregisterIRListener() is called \n07-05 07:00:03.266 D/AbsListView(30420): unregisterIRListener() is called \n07-05 07:00:03.271 D/AbsListView(30420): unregisterIRListener() is called \n07-05 07:00:03.271 W/ApplicationPackageManager(30420): getCSCPackageItemText()\n07-05 07:00:03.306 W/ActivityPageFragment(30420): ############################# onCreateView\n07-05 07:00:03.331 D/AbsListView(30420): Get MotionRecognitionManager\n07-05 07:00:03.351 W/ActivityPageFragment(30420): ############## setTrainingClassCourse\n07-05 07:00:03.351 D/AndroidRuntime(30420): Shutting down VM\n07-05 07:00:03.351 W/dalvikvm(30420): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 07:00:03.351 E/ACRA    (30420): ACRA caught a RuntimeException exception for com.boha.cmtrainee. Building report.\n07-05 07:00:03.351 D/ACRA    (30420): Using custom Report Fields\n07-05 07:00:03.361 I/ACRA    (30420): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 07:00:03.391 D/ACRA    (30420): Retrieving logcat output...\n'),
(8, 1, '2014-07-05 07:12:21', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.RuntimeException: Unable to start activity ComponentInfo{com.boha.cmtrainee/com.boha.cmlibrary.ActivityListActivity}: java.lang.NullPointerException\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2305)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\nCaused by: java.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.setTrainingClassCourse(ActivityPageFragment.java:144)\n	at com.boha.cmlibrary.ActivityListActivity.onCreate(ActivityListActivity.java:27)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	... 11 more\njava.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.setTrainingClassCourse(ActivityPageFragment.java:144)\n	at com.boha.cmlibrary.ActivityListActivity.onCreate(ActivityListActivity.java:27)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 07:01:59.776 D/dalvikvm(31364): GC_FOR_ALLOC freed 2171K, 20% free 17658K/21808K, paused 27ms, total 27ms\n07-05 07:02:00.011 I/System.out(31364): Thread-7398(HTTPLog):SmartBonding Enabling is false, log to file is false, DBG is false\n07-05 07:02:01.956 D/Volley  (31364): [7398] BasicNetwork.logSlowRequests: HTTP response for request=<[ ] http://192.168.1.111:8050/cm/trainee?JSON=%7B%22trainingClassID%22%3A1%2C%22companyID%22%3A1%2C%22traineeID%22%3A117%2C%22zippedResponse%22%3Atrue%2C%22startDate%22%3A0%2C%22calendarID%22%3A0%2C%22endDate%22%3A0%2C%22dateTo%22%3A0%2C%22dateFrom%22%3A0%2C%22requestType%22%3A301%2C%22returnEquipment%22%3Afalse%7D 0x85bc0df5 NORMAL 1> [lifetime=3387], [size=3060], [rc=200], [retryCount=0]\n07-05 07:02:01.966 D/BohaRequest(31364): parsing response, elapsed since start: 3.613 seconds\n07-05 07:02:01.976 I/BohaRequest(31364): response string length returned: 2868\n07-05 07:02:03.861 I/BohaRequest(31364): ---- Comms elapsed time: 5.513 seconds\n07-05 07:02:03.861 E/BaseVolley(31364): Yup! ...response object received, status code: 0\n07-05 07:02:34.366 I/MainPagerActivity(31364): ############ --building first 3 pages\n07-05 07:02:34.441 D/DashboardFragment(31364): ---- onAttach\n07-05 07:02:34.441 I/DashboardFragment(31364): -- onCreateView ............\n07-05 07:02:34.551 D/dalvikvm(31364): GC_FOR_ALLOC freed 1064K, 18% free 17937K/21808K, paused 57ms, total 58ms\n07-05 07:02:34.551 I/dalvikvm-heap(31364): Grow heap (frag case) to 19.939MB for 515824-byte allocation\n07-05 07:02:34.576 D/dalvikvm(31364): GC_FOR_ALLOC freed 3K, 18% free 18437K/22312K, paused 18ms, total 18ms\n07-05 07:02:34.691 D/ProgressBar(31364): setProgressDrawable drawableHeight = 0\n07-05 07:02:34.896 W/DashboardFragment(31364): Trainee activities found: 6\n07-05 07:02:34.896 I/DashboardFragment(31364): *** setData from response object \n07-05 07:02:34.926 D/TraineeListFragment(31364): ---- onAttach\n07-05 07:02:34.926 I/TraineeListFragment(31364): -- onCreateView ............\n07-05 07:02:34.966 D/AbsListView(31364): Get MotionRecognitionManager\n07-05 07:03:19.571 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:03:19.576 D/TraineeListFragment(31364): ---- onResume - nothing to be done\n07-05 07:03:19.606 I/MainPagerActivity(31364): ---- getting class teams\n07-05 07:03:19.631 I/WebCheck(31364): ###### WIFI AVAILABLE on check\n07-05 07:03:19.631 I/WebCheck(31364): ###### WIFI CONNECTED on check\n07-05 07:03:19.631 I/WebCheck(31364): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:03:19.631 E/WebCheck(31364): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:03:19.631 D/WebCheck(31364): ###### Network check completed in 7 ms\n07-05 07:03:20.391 I/BaseVolley(31364): ...sending remote request: .......>\n07-05 07:03:20.391 I/BaseVolley(31364): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 07:03:20.391 I/BohaRequest(31364): ...Cloud Server communication started ...\n07-05 07:03:20.411 D/Volley  (31364): [1] Request.finish: 82060 ms: [ ] http://192.168.1.111:8050/cm/trainee?JSON=%7B%22trainingClassID%22%3A1%2C%22companyID%22%3A1%2C%22traineeID%22%3A117%2C%22zippedResponse%22%3Atrue%2C%22startDate%22%3A0%2C%22calendarID%22%3A0%2C%22endDate%22%3A0%2C%22dateTo%22%3A0%2C%22dateFrom%22%3A0%2C%22requestType%22%3A301%2C%22returnEquipment%22%3Afalse%7D 0x85bc0df5 NORMAL 1\n07-05 07:03:20.416 I/Choreographer(31364): Skipped 4591 frames!  The application may be doing too much work on its main thread.\n07-05 07:03:21.111 D/ProgressBar(31364): updateDrawableBounds: left = 0\n07-05 07:03:21.111 D/ProgressBar(31364): updateDrawableBounds: top = 0\n07-05 07:03:21.111 D/ProgressBar(31364): updateDrawableBounds: right = 876\n07-05 07:03:21.111 D/ProgressBar(31364): updateDrawableBounds: bottom = 60\n07-05 07:03:21.111 D/ProgressBar(31364): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 07:03:21.231 D/dalvikvm(31364): GC_FOR_ALLOC freed 765K, 17% free 18655K/22312K, paused 39ms, total 39ms\n07-05 07:03:21.261 I/dalvikvm-heap(31364): Grow heap (frag case) to 30.695MB for 11059216-byte allocation\n07-05 07:03:21.276 D/dalvikvm(31364): GC_FOR_ALLOC freed 7K, 12% free 29447K/33116K, paused 17ms, total 17ms\n07-05 07:03:22.086 D/BohaRequest(31364): parsing response, elapsed since start: 1.672 seconds\n07-05 07:03:22.096 I/BohaRequest(31364): response string length returned: 219\n07-05 07:03:25.416 D/dalvikvm(31364): GC_FOR_ALLOC freed 1706K, 14% free 30443K/35116K, paused 30ms, total 32ms\n07-05 07:03:26.066 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:03:26.076 D/ProgressBar(31364): updateDrawableBounds: left = 0\n07-05 07:03:26.076 D/ProgressBar(31364): updateDrawableBounds: top = 0\n07-05 07:03:26.076 D/ProgressBar(31364): updateDrawableBounds: right = 48\n07-05 07:03:26.076 D/ProgressBar(31364): updateDrawableBounds: bottom = 48\n07-05 07:03:26.421 D/Volley  (31364): [1] Request.finish: 4238 ms: [ ] http://192.168.1.111:8050/coursemaker_images/company1/trainee/153.jpg 0x85bc0df5 LOW 3\n07-05 07:03:27.091 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:03:27.821 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:03:28.041 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:03:31.331 I/BohaRequest(31364): ---- Comms elapsed time: 10.92 seconds\n07-05 07:03:31.331 E/BaseVolley(31364): Yup! ...response object received, status code: 0\n07-05 07:03:31.641 W/MainPagerActivity(31364): getting provinces ...\n07-05 07:03:31.646 I/MainPagerActivity(31364): Country code is ZA\n07-05 07:03:31.656 I/WebCheck(31364): ###### WIFI AVAILABLE on check\n07-05 07:03:31.656 I/WebCheck(31364): ###### WIFI CONNECTED on check\n07-05 07:03:31.656 I/WebCheck(31364): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:03:31.656 E/WebCheck(31364): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:03:31.656 D/WebCheck(31364): ###### Network check completed in 12 ms\n07-05 07:03:32.351 W/CacheUtil(31364): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 07:03:32.846 I/BaseVolley(31364): ...sending remote request: .......>\n07-05 07:03:32.846 I/BaseVolley(31364): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 07:03:32.846 I/BohaRequest(31364): ...Cloud Server communication started ...\n07-05 07:03:32.861 D/Volley  (31364): [1] Request.finish: 12457 ms: [ ] http://192.168.1.111:8050/cm/team?JSON=%7B%22trainingClassID%22%3A1%2C%22zippedResponse%22%3Atrue%2C%22startDate%22%3A0%2C%22calendarID%22%3A0%2C%22endDate%22%3A0%2C%22dateTo%22%3A0%2C%22dateFrom%22%3A0%2C%22requestType%22%3A116%2C%22returnEquipment%22%3Afalse%7D 0x85bc0df5 NORMAL 2\n07-05 07:03:32.861 I/Choreographer(31364): Skipped 82 frames!  The application may be doing too much work on its main thread.\n07-05 07:03:33.281 D/BohaRequest(31364): parsing response, elapsed since start: 0.423 seconds\n07-05 07:03:33.306 I/BohaRequest(31364): response string length returned: 3062\n07-05 07:03:34.426 I/BohaRequest(31364): ---- Comms elapsed time: 1.574 seconds\n07-05 07:03:34.426 E/BaseVolley(31364): Yup! ...response object received, status code: 0\n07-05 07:04:45.051 D/AbsListView(31364): Get MotionRecognitionManager\n07-05 07:04:45.091 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:04:45.096 E/CourseListFragment(31364): ## onResume\n07-05 07:04:45.321 D/dalvikvm(31364): GC_FOR_ALLOC freed 14501K, 45% free 20508K/36988K, paused 38ms, total 38ms\n07-05 07:04:45.521 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:04:45.981 I/TeamListFragment(31364): ##### onCreateView\n07-05 07:04:45.991 E/TeamListFragment(31364): TrainingClassID = 1\n07-05 07:04:46.061 D/AbsListView(31364): Get MotionRecognitionManager\n07-05 07:04:46.071 V/Vibrator(31364): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 07:04:46.071 V/Vibrator(31364): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 07:04:46.101 E/TeamListFragment(31364): TeamList is fucked!\n07-05 07:04:46.111 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:04:46.116 W/TeamListFragment(31364): ## onResume\n07-05 07:04:46.156 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:05:38.536 I/Choreographer(31364): Skipped 2964 frames!  The application may be doing too much work on its main thread.\n07-05 07:05:38.561 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:05:38.571 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:05:38.576 D/AbsListView(31364): unregisterIRListener() is called \n07-05 07:05:38.591 W/ApplicationPackageManager(31364): getCSCPackageItemText()\n07-05 07:05:38.701 W/ActivityPageFragment(31364): ############################# onCreateView\n07-05 07:05:38.766 D/AbsListView(31364): Get MotionRecognitionManager\n07-05 07:07:24.211 W/ActivityPageFragment(31364): ############## setTrainingClassCourse\n07-05 07:12:21.451 D/AndroidRuntime(31364): Shutting down VM\n07-05 07:12:21.451 W/dalvikvm(31364): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 07:12:21.451 E/ACRA    (31364): ACRA caught a RuntimeException exception for com.boha.cmtrainee. Building report.\n07-05 07:12:21.456 D/ACRA    (31364): Using custom Report Fields\n07-05 07:12:21.461 D/dalvikvm(31364): Debugger has detached; object registry had 4691 entries\n07-05 07:12:21.476 I/ACRA    (31364): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 07:12:21.536 D/ACRA    (31364): Retrieving logcat output...\n');
INSERT INTO `errorStoreAndroid` (`errorStoreAndroidID`, `companyID`, `errorDate`, `packageName`, `appVersionName`, `appVersionCode`, `brand`, `phoneModel`, `androidVersion`, `stackTrace`, `logCat`) VALUES
(9, 1, '2014-07-05 07:21:40', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.RuntimeException: Unable to start activity ComponentInfo{com.boha.cmtrainee/com.boha.cmlibrary.ActivityListActivity}: android.view.InflateException: Binary XML file line #15: Error inflating class fragment\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2305)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\nCaused by: android.view.InflateException: Binary XML file line #15: Error inflating class fragment\n	at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:719)\n	at android.view.LayoutInflater.rInflate(LayoutInflater.java:761)\n	at android.view.LayoutInflater.rInflate(LayoutInflater.java:769)\n	at android.view.LayoutInflater.inflate(LayoutInflater.java:498)\n	at android.view.LayoutInflater.inflate(LayoutInflater.java:398)\n	at android.view.LayoutInflater.inflate(LayoutInflater.java:354)\n	at com.android.internal.policy.impl.PhoneWindow.setContentView(PhoneWindow.java:359)\n	at android.app.Activity.setContentView(Activity.java:2010)\n	at com.boha.cmlibrary.ActivityListActivity.onCreate(ActivityListActivity.java:19)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	... 11 more\nCaused by: java.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.setList(ActivityPageFragment.java:97)\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.onCreateView(ActivityPageFragment.java:76)\n	at android.support.v4.app.Fragment.performCreateView(Fragment.java:1478)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:900)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1082)\n	at android.support.v4.app.FragmentManagerImpl.addFragment(FragmentManager.java:1184)\n	at android.support.v4.app.FragmentActivity.onCreateView(FragmentActivity.java:285)\n	at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:691)\n	... 22 more\nandroid.view.InflateException: Binary XML file line #15: Error inflating class fragment\n	at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:719)\n	at android.view.LayoutInflater.rInflate(LayoutInflater.java:761)\n	at android.view.LayoutInflater.rInflate(LayoutInflater.java:769)\n	at android.view.LayoutInflater.inflate(LayoutInflater.java:498)\n	at android.view.LayoutInflater.inflate(LayoutInflater.java:398)\n	at android.view.LayoutInflater.inflate(LayoutInflater.java:354)\n	at com.android.internal.policy.impl.PhoneWindow.setContentView(PhoneWindow.java:359)\n	at android.app.Activity.setContentView(Activity.java:2010)\n	at com.boha.cmlibrary.ActivityListActivity.onCreate(ActivityListActivity.java:19)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\nCaused by: java.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.setList(ActivityPageFragment.java:97)\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.onCreateView(ActivityPageFragment.java:76)\n	at android.support.v4.app.Fragment.performCreateView(Fragment.java:1478)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:900)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1082)\n	at android.support.v4.app.FragmentManagerImpl.addFragment(FragmentManager.java:1184)\n	at android.support.v4.app.FragmentActivity.onCreateView(FragmentActivity.java:285)\n	at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:691)\n	... 22 more\njava.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.setList(ActivityPageFragment.java:97)\n	at com.boha.cmlibrary.fragments.ActivityPageFragment.onCreateView(ActivityPageFragment.java:76)\n	at android.support.v4.app.Fragment.performCreateView(Fragment.java:1478)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:900)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1082)\n	at android.support.v4.app.FragmentManagerImpl.addFragment(FragmentManager.java:1184)\n	at android.support.v4.app.FragmentActivity.onCreateView(FragmentActivity.java:285)\n	at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:691)\n	at android.view.LayoutInflater.rInflate(LayoutInflater.java:761)\n	at android.view.LayoutInflater.rInflate(LayoutInflater.java:769)\n	at android.view.LayoutInflater.inflate(LayoutInflater.java:498)\n	at android.view.LayoutInflater.inflate(LayoutInflater.java:398)\n	at android.view.LayoutInflater.inflate(LayoutInflater.java:354)\n	at com.android.internal.policy.impl.PhoneWindow.setContentView(PhoneWindow.java:359)\n	at android.app.Activity.setContentView(Activity.java:2010)\n	at com.boha.cmlibrary.ActivityListActivity.onCreate(ActivityListActivity.java:19)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 07:20:42.946 I/BaseVolley( 1074): http://192.168.1.111:8050/cm/trainee?JSON={"trainingClassID":1,"companyID":1,"traineeID":117,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":301,"returnEquipment":false}\n07-05 07:20:42.946 I/BohaRequest( 1074): ...Cloud Server communication started ...\n07-05 07:20:42.976 D/ProgressBar( 1074): updateDrawableBounds: left = 0\n07-05 07:20:42.976 D/ProgressBar( 1074): updateDrawableBounds: top = 0\n07-05 07:20:42.976 D/ProgressBar( 1074): updateDrawableBounds: right = 48\n07-05 07:20:42.976 D/ProgressBar( 1074): updateDrawableBounds: bottom = 48\n07-05 07:20:43.131 D/dalvikvm( 1074): GC_FOR_ALLOC freed 2154K, 19% free 17675K/21808K, paused 24ms, total 24ms\n07-05 07:20:43.156 I/System.out( 1074): Thread-7515(HTTPLog):SmartBonding Enabling is false, log to file is false, DBG is false\n07-05 07:20:43.371 D/BohaRequest( 1074): parsing response, elapsed since start: 0.423 seconds\n07-05 07:20:43.376 I/BohaRequest( 1074): response string length returned: 2868\n07-05 07:20:43.566 I/BohaRequest( 1074): ---- Comms elapsed time: 0.618 seconds\n07-05 07:20:43.566 E/BaseVolley( 1074): Yup! ...response object received, status code: 0\n07-05 07:20:43.581 I/MainPagerActivity( 1074): ############ --building first 3 pages\n07-05 07:20:43.581 D/DashboardFragment( 1074): ---- onAttach\n07-05 07:20:43.581 I/DashboardFragment( 1074): -- onCreateView ............\n07-05 07:20:43.611 D/dalvikvm( 1074): GC_FOR_ALLOC freed 1211K, 19% free 17787K/21808K, paused 22ms, total 22ms\n07-05 07:20:43.611 I/dalvikvm-heap( 1074): Grow heap (frag case) to 19.792MB for 515824-byte allocation\n07-05 07:20:43.626 D/dalvikvm( 1074): GC_FOR_ALLOC freed 3K, 19% free 18286K/22312K, paused 15ms, total 15ms\n07-05 07:20:43.646 D/ProgressBar( 1074): setProgressDrawable drawableHeight = 0\n07-05 07:20:43.686 W/DashboardFragment( 1074): Trainee activities found: 6\n07-05 07:20:43.686 I/DashboardFragment( 1074): *** setData from response object \n07-05 07:20:43.696 D/TraineeListFragment( 1074): ---- onAttach\n07-05 07:20:43.696 I/TraineeListFragment( 1074): -- onCreateView ............\n07-05 07:20:43.711 D/AbsListView( 1074): Get MotionRecognitionManager\n07-05 07:20:43.726 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:20:43.726 D/TraineeListFragment( 1074): ---- onResume - nothing to be done\n07-05 07:20:43.726 I/MainPagerActivity( 1074): ---- getting class teams\n07-05 07:20:43.731 I/WebCheck( 1074): ###### WIFI AVAILABLE on check\n07-05 07:20:43.731 I/WebCheck( 1074): ###### WIFI CONNECTED on check\n07-05 07:20:43.731 I/WebCheck( 1074): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:20:43.731 E/WebCheck( 1074): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:20:43.731 D/WebCheck( 1074): ###### Network check completed in 1 ms\n07-05 07:20:43.796 I/BaseVolley( 1074): ...sending remote request: .......>\n07-05 07:20:43.796 I/BaseVolley( 1074): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 07:20:43.796 I/BohaRequest( 1074): ...Cloud Server communication started ...\n07-05 07:20:43.826 D/ProgressBar( 1074): updateDrawableBounds: left = 0\n07-05 07:20:43.826 D/ProgressBar( 1074): updateDrawableBounds: top = 0\n07-05 07:20:43.826 D/ProgressBar( 1074): updateDrawableBounds: right = 876\n07-05 07:20:43.826 D/ProgressBar( 1074): updateDrawableBounds: bottom = 60\n07-05 07:20:43.826 D/ProgressBar( 1074): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 07:20:43.871 D/dalvikvm( 1074): GC_FOR_ALLOC freed 850K, 17% free 18523K/22312K, paused 24ms, total 24ms\n07-05 07:20:43.896 I/dalvikvm-heap( 1074): Grow heap (frag case) to 30.567MB for 11059216-byte allocation\n07-05 07:20:43.916 D/dalvikvm( 1074): GC_FOR_ALLOC freed 6K, 12% free 29317K/33116K, paused 20ms, total 21ms\n07-05 07:20:44.026 D/BohaRequest( 1074): parsing response, elapsed since start: 0.202 seconds\n07-05 07:20:44.026 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:20:44.026 I/BohaRequest( 1074): response string length returned: 219\n07-05 07:20:44.026 D/ProgressBar( 1074): updateDrawableBounds: left = 0\n07-05 07:20:44.026 D/ProgressBar( 1074): updateDrawableBounds: top = 0\n07-05 07:20:44.026 D/ProgressBar( 1074): updateDrawableBounds: right = 48\n07-05 07:20:44.026 D/ProgressBar( 1074): updateDrawableBounds: bottom = 48\n07-05 07:20:44.051 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:20:44.261 I/BohaRequest( 1074): ---- Comms elapsed time: 0.463 seconds\n07-05 07:20:44.261 E/BaseVolley( 1074): Yup! ...response object received, status code: 0\n07-05 07:20:44.276 W/MainPagerActivity( 1074): getting provinces ...\n07-05 07:20:44.276 I/MainPagerActivity( 1074): Country code is ZA\n07-05 07:20:44.276 I/WebCheck( 1074): ###### WIFI AVAILABLE on check\n07-05 07:20:44.276 I/WebCheck( 1074): ###### WIFI CONNECTED on check\n07-05 07:20:44.276 I/WebCheck( 1074): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:20:44.276 E/WebCheck( 1074): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:20:44.276 D/WebCheck( 1074): ###### Network check completed in 1 ms\n07-05 07:20:44.296 W/CacheUtil( 1074): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 07:20:44.341 I/BaseVolley( 1074): ...sending remote request: .......>\n07-05 07:20:44.341 I/BaseVolley( 1074): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 07:20:44.341 I/BohaRequest( 1074): ...Cloud Server communication started ...\n07-05 07:20:44.386 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:20:44.451 D/BohaRequest( 1074): parsing response, elapsed since start: 0.105 seconds\n07-05 07:20:44.451 I/BohaRequest( 1074): response string length returned: 3064\n07-05 07:20:44.596 I/BohaRequest( 1074): ---- Comms elapsed time: 0.254 seconds\n07-05 07:20:44.596 E/BaseVolley( 1074): Yup! ...response object received, status code: 0\n07-05 07:21:28.006 D/AbsListView( 1074): Get MotionRecognitionManager\n07-05 07:21:28.016 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:21:28.016 E/CourseListFragment( 1074): ## onResume\n07-05 07:21:28.146 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:21:35.256 I/TeamListFragment( 1074): ##### onCreateView\n07-05 07:21:35.261 E/TeamListFragment( 1074): TrainingClassID = 1\n07-05 07:21:35.276 D/AbsListView( 1074): Get MotionRecognitionManager\n07-05 07:21:35.281 V/Vibrator( 1074): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 07:21:35.281 V/Vibrator( 1074): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 07:21:35.296 E/TeamListFragment( 1074): TeamList is fucked!\n07-05 07:21:35.301 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:21:35.301 W/TeamListFragment( 1074): ## onResume\n07-05 07:21:35.311 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:21:39.721 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:21:39.726 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:21:39.726 D/AbsListView( 1074): unregisterIRListener() is called \n07-05 07:21:39.726 W/ApplicationPackageManager( 1074): getCSCPackageItemText()\n07-05 07:21:39.766 W/ActivityPageFragment( 1074): ############################# onCreateView\n07-05 07:21:39.791 D/AbsListView( 1074): Get MotionRecognitionManager\n07-05 07:21:39.791 W/ActivityPageFragment( 1074): ############## setList\n07-05 07:21:39.796 D/dalvikvm( 1074): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_traineeRating\n07-05 07:21:39.796 W/dalvikvm( 1074): VFY: unable to resolve static field 3102 (AR_traineeRating) in Lcom/boha/cmlibrary/R$id;\n07-05 07:21:39.796 D/dalvikvm( 1074): VFY: replacing opcode 0x60 at 0x0040\n07-05 07:21:39.796 D/dalvikvm( 1074): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_instructorRating\n07-05 07:21:39.796 I/dalvikvm( 1074): DexOpt: unable to optimize static field ref 0x0c1c at 0x48 in Lcom/boha/cmlibrary/adapters/ActivityAdapter;.getView\n07-05 07:21:39.796 D/AndroidRuntime( 1074): Shutting down VM\n07-05 07:21:39.796 W/dalvikvm( 1074): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 07:21:39.796 E/ACRA    ( 1074): ACRA caught a RuntimeException exception for com.boha.cmtrainee. Building report.\n07-05 07:21:39.796 D/ACRA    ( 1074): Using custom Report Fields\n07-05 07:21:39.816 I/ACRA    ( 1074): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 07:21:39.851 D/ACRA    ( 1074): Retrieving logcat output...\n'),
(10, 1, '2014-07-05 07:26:15', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NoSuchFieldError: com.boha.cmlibrary.R$id.AR_traineeRating\n	at com.boha.cmlibrary.adapters.ActivityAdapter.getView(ActivityAdapter.java:58)\n	at android.widget.AbsListView.obtainView(AbsListView.java:2720)\n	at android.widget.ListView.makeAndAddView(ListView.java:1801)\n	at android.widget.ListView.fillDown(ListView.java:697)\n	at android.widget.ListView.fillFromTop(ListView.java:763)\n	at android.widget.ListView.layoutChildren(ListView.java:1641)\n	at android.widget.AbsListView.onLayout(AbsListView.java:2533)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1677)\n	at android.widget.LinearLayout.layoutHorizontal(LinearLayout.java:1666)\n	at android.widget.LinearLayout.onLayout(LinearLayout.java:1442)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at com.android.internal.widget.ActionBarOverlayLayout.onLayout(ActionBarOverlayLayout.java:438)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.view.ViewRootImpl.performLayout(ViewRootImpl.java:2284)\n	at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:2004)\n	at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1234)\n	at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6467)\n	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:803)\n	at android.view.Choreographer.doCallbacks(Choreographer.java:603)\n	at android.view.Choreographer.doFrame(Choreographer.java:573)\n	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:789)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 07:25:25.466 D/BohaRequest( 2203): parsing response, elapsed since start: 0.457 seconds\n07-05 07:25:25.471 I/BohaRequest( 2203): response string length returned: 2868\n07-05 07:25:25.756 I/BohaRequest( 2203): ---- Comms elapsed time: 0.747 seconds\n07-05 07:25:25.756 E/BaseVolley( 2203): Yup! ...response object received, status code: 0\n07-05 07:25:25.766 I/MainPagerActivity( 2203): ############ --building first 3 pages\n07-05 07:25:25.766 D/DashboardFragment( 2203): ---- onAttach\n07-05 07:25:25.766 I/DashboardFragment( 2203): -- onCreateView ............\n07-05 07:25:25.791 D/dalvikvm( 2203): GC_FOR_ALLOC freed 1211K, 19% free 17789K/21808K, paused 17ms, total 17ms\n07-05 07:25:25.796 I/dalvikvm-heap( 2203): Grow heap (frag case) to 19.794MB for 515824-byte allocation\n07-05 07:25:25.811 D/dalvikvm( 2203): GC_FOR_ALLOC freed <1K, 19% free 18293K/22312K, paused 16ms, total 16ms\n07-05 07:25:25.826 D/ProgressBar( 2203): setProgressDrawable drawableHeight = 0\n07-05 07:25:25.861 W/DashboardFragment( 2203): Trainee activities found: 6\n07-05 07:25:25.861 I/DashboardFragment( 2203): *** setData from response object \n07-05 07:25:25.876 D/TraineeListFragment( 2203): ---- onAttach\n07-05 07:25:25.876 I/TraineeListFragment( 2203): -- onCreateView ............\n07-05 07:25:25.891 D/AbsListView( 2203): Get MotionRecognitionManager\n07-05 07:25:25.906 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:25:25.906 D/TraineeListFragment( 2203): ---- onResume - nothing to be done\n07-05 07:25:25.906 I/MainPagerActivity( 2203): ---- getting class teams\n07-05 07:25:25.911 I/WebCheck( 2203): ###### WIFI AVAILABLE on check\n07-05 07:25:25.911 I/WebCheck( 2203): ###### WIFI CONNECTED on check\n07-05 07:25:25.911 I/WebCheck( 2203): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:25:25.911 E/WebCheck( 2203): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:25:25.911 D/WebCheck( 2203): ###### Network check completed in 1 ms\n07-05 07:25:25.981 I/BaseVolley( 2203): ...sending remote request: .......>\n07-05 07:25:25.981 I/BaseVolley( 2203): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 07:25:25.981 I/BohaRequest( 2203): ...Cloud Server communication started ...\n07-05 07:25:26.011 D/ProgressBar( 2203): updateDrawableBounds: left = 0\n07-05 07:25:26.011 D/ProgressBar( 2203): updateDrawableBounds: top = 0\n07-05 07:25:26.011 D/ProgressBar( 2203): updateDrawableBounds: right = 876\n07-05 07:25:26.011 D/ProgressBar( 2203): updateDrawableBounds: bottom = 60\n07-05 07:25:26.011 D/ProgressBar( 2203): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 07:25:26.056 D/dalvikvm( 2203): GC_FOR_ALLOC freed 764K, 18% free 18500K/22312K, paused 24ms, total 24ms\n07-05 07:25:26.081 I/dalvikvm-heap( 2203): Grow heap (frag case) to 30.543MB for 11059216-byte allocation\n07-05 07:25:26.101 D/dalvikvm( 2203): GC_FOR_ALLOC freed 5K, 12% free 29295K/33116K, paused 19ms, total 19ms\n07-05 07:25:26.121 D/BohaRequest( 2203): parsing response, elapsed since start: 0.142 seconds\n07-05 07:25:26.136 I/BohaRequest( 2203): response string length returned: 219\n07-05 07:25:26.216 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:25:26.216 D/ProgressBar( 2203): updateDrawableBounds: left = 0\n07-05 07:25:26.216 D/ProgressBar( 2203): updateDrawableBounds: top = 0\n07-05 07:25:26.216 D/ProgressBar( 2203): updateDrawableBounds: right = 48\n07-05 07:25:26.216 D/ProgressBar( 2203): updateDrawableBounds: bottom = 48\n07-05 07:25:26.251 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:25:26.471 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:25:26.481 I/BohaRequest( 2203): ---- Comms elapsed time: 0.5 seconds\n07-05 07:25:26.481 E/BaseVolley( 2203): Yup! ...response object received, status code: 0\n07-05 07:25:26.491 W/MainPagerActivity( 2203): getting provinces ...\n07-05 07:25:26.491 I/MainPagerActivity( 2203): Country code is ZA\n07-05 07:25:26.496 I/WebCheck( 2203): ###### WIFI AVAILABLE on check\n07-05 07:25:26.496 I/WebCheck( 2203): ###### WIFI CONNECTED on check\n07-05 07:25:26.496 I/WebCheck( 2203): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:25:26.496 E/WebCheck( 2203): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:25:26.496 D/WebCheck( 2203): ###### Network check completed in 1 ms\n07-05 07:25:26.501 W/CacheUtil( 2203): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 07:25:26.546 I/BaseVolley( 2203): ...sending remote request: .......>\n07-05 07:25:26.546 I/BaseVolley( 2203): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 07:25:26.546 I/BohaRequest( 2203): ...Cloud Server communication started ...\n07-05 07:25:26.661 D/BohaRequest( 2203): parsing response, elapsed since start: 0.115 seconds\n07-05 07:25:26.661 I/BohaRequest( 2203): response string length returned: 3062\n07-05 07:25:26.786 I/BohaRequest( 2203): ---- Comms elapsed time: 0.237 seconds\n07-05 07:25:26.786 E/BaseVolley( 2203): Yup! ...response object received, status code: 0\n07-05 07:26:08.331 D/AbsListView( 2203): Get MotionRecognitionManager\n07-05 07:26:08.336 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:08.341 E/CourseListFragment( 2203): ## onResume\n07-05 07:26:08.466 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:09.456 I/TeamListFragment( 2203): ##### onCreateView\n07-05 07:26:09.456 E/TeamListFragment( 2203): TrainingClassID = 1\n07-05 07:26:09.476 D/AbsListView( 2203): Get MotionRecognitionManager\n07-05 07:26:09.481 V/Vibrator( 2203): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 07:26:09.481 V/Vibrator( 2203): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 07:26:09.491 E/TeamListFragment( 2203): TeamList is fucked!\n07-05 07:26:09.496 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:09.496 W/TeamListFragment( 2203): ## onResume\n07-05 07:26:09.506 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:14.951 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:14.951 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:14.951 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:14.951 W/ApplicationPackageManager( 2203): getCSCPackageItemText()\n07-05 07:26:14.991 W/ActivityPageFragment( 2203): ############################# onCreateView\n07-05 07:26:15.011 D/AbsListView( 2203): Get MotionRecognitionManager\n07-05 07:26:15.036 W/ActivityPageFragment( 2203): ############## setTrainingClassCourse\n07-05 07:26:15.036 W/ActivityPageFragment( 2203): ############## setList\n07-05 07:26:15.036 D/dalvikvm( 2203): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_traineeRating\n07-05 07:26:15.036 W/dalvikvm( 2203): VFY: unable to resolve static field 3102 (AR_traineeRating) in Lcom/boha/cmlibrary/R$id;\n07-05 07:26:15.036 D/dalvikvm( 2203): VFY: replacing opcode 0x60 at 0x0040\n07-05 07:26:15.036 D/dalvikvm( 2203): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_instructorRating\n07-05 07:26:15.036 I/dalvikvm( 2203): DexOpt: unable to optimize static field ref 0x0c1c at 0x48 in Lcom/boha/cmlibrary/adapters/ActivityAdapter;.getView\n07-05 07:26:15.046 I/ActivityListActivity( 2203): *** onResume - doin nuthin'' \n07-05 07:26:15.046 E/ActivityPageFragment( 2203): onResume in ActivityPageFragment\n07-05 07:26:15.046 D/AbsListView( 2203): onVisibilityChanged() is called, visibility : 4\n07-05 07:26:15.046 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:15.051 D/AbsListView( 2203): onVisibilityChanged() is called, visibility : 0\n07-05 07:26:15.051 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:15.061 D/AbsListView( 2203): unregisterIRListener() is called \n07-05 07:26:15.161 D/AndroidRuntime( 2203): Shutting down VM\n07-05 07:26:15.161 W/dalvikvm( 2203): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 07:26:15.161 E/ACRA    ( 2203): ACRA caught a NoSuchFieldError exception for com.boha.cmtrainee. Building report.\n07-05 07:26:15.161 D/ACRA    ( 2203): Using custom Report Fields\n07-05 07:26:15.181 I/ACRA    ( 2203): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 07:26:15.211 D/ACRA    ( 2203): Retrieving logcat output...\n'),
(11, 1, '2014-07-05 07:33:33', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NoSuchFieldError: com.boha.cmlibrary.R$id.AR_traineeRating\n	at com.boha.cmlibrary.adapters.ActivityAdapter.getView(ActivityAdapter.java:58)\n	at android.widget.AbsListView.obtainView(AbsListView.java:2720)\n	at android.widget.ListView.makeAndAddView(ListView.java:1801)\n	at android.widget.ListView.fillDown(ListView.java:697)\n	at android.widget.ListView.fillFromTop(ListView.java:763)\n	at android.widget.ListView.layoutChildren(ListView.java:1641)\n	at android.widget.AbsListView.onLayout(AbsListView.java:2533)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1677)\n	at android.widget.LinearLayout.layoutHorizontal(LinearLayout.java:1666)\n	at android.widget.LinearLayout.onLayout(LinearLayout.java:1442)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at com.android.internal.widget.ActionBarOverlayLayout.onLayout(ActionBarOverlayLayout.java:438)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.view.ViewRootImpl.performLayout(ViewRootImpl.java:2284)\n	at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:2004)\n	at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1234)\n	at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6467)\n	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:803)\n	at android.view.Choreographer.doCallbacks(Choreographer.java:603)\n	at android.view.Choreographer.doFrame(Choreographer.java:573)\n	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:789)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 07:32:59.086 I/BohaRequest( 3869): response string length returned: 2868\n07-05 07:32:59.316 I/BohaRequest( 3869): ---- Comms elapsed time: 0.698 seconds\n07-05 07:32:59.316 E/BaseVolley( 3869): Yup! ...response object received, status code: 0\n07-05 07:32:59.351 I/MainPagerActivity( 3869): ############ --building first 3 pages\n07-05 07:32:59.351 D/DashboardFragment( 3869): ---- onAttach\n07-05 07:32:59.351 I/DashboardFragment( 3869): -- onCreateView ............\n07-05 07:32:59.391 D/dalvikvm( 3869): GC_FOR_ALLOC freed 1209K, 19% free 17778K/21808K, paused 23ms, total 23ms\n07-05 07:32:59.396 I/dalvikvm-heap( 3869): Grow heap (frag case) to 19.784MB for 515824-byte allocation\n07-05 07:32:59.416 D/dalvikvm( 3869): GC_FOR_ALLOC freed 11K, 19% free 18270K/22312K, paused 22ms, total 22ms\n07-05 07:32:59.436 D/ProgressBar( 3869): setProgressDrawable drawableHeight = 0\n07-05 07:32:59.466 W/DashboardFragment( 3869): Trainee activities found: 6\n07-05 07:32:59.466 I/DashboardFragment( 3869): *** setData from response object \n07-05 07:32:59.476 D/TraineeListFragment( 3869): ---- onAttach\n07-05 07:32:59.476 I/TraineeListFragment( 3869): -- onCreateView ............\n07-05 07:32:59.491 D/AbsListView( 3869): Get MotionRecognitionManager\n07-05 07:32:59.506 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:32:59.506 D/TraineeListFragment( 3869): ---- onResume - nothing to be done\n07-05 07:32:59.506 I/MainPagerActivity( 3869): ---- getting class teams\n07-05 07:32:59.506 I/WebCheck( 3869): ###### WIFI AVAILABLE on check\n07-05 07:32:59.506 I/WebCheck( 3869): ###### WIFI CONNECTED on check\n07-05 07:32:59.506 I/WebCheck( 3869): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:32:59.506 E/WebCheck( 3869): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:32:59.506 D/WebCheck( 3869): ###### Network check completed in 2 ms\n07-05 07:32:59.581 I/BaseVolley( 3869): ...sending remote request: .......>\n07-05 07:32:59.581 I/BaseVolley( 3869): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 07:32:59.581 I/BohaRequest( 3869): ...Cloud Server communication started ...\n07-05 07:32:59.631 D/ProgressBar( 3869): updateDrawableBounds: left = 0\n07-05 07:32:59.631 D/ProgressBar( 3869): updateDrawableBounds: top = 0\n07-05 07:32:59.631 D/ProgressBar( 3869): updateDrawableBounds: right = 876\n07-05 07:32:59.631 D/ProgressBar( 3869): updateDrawableBounds: bottom = 60\n07-05 07:32:59.631 D/ProgressBar( 3869): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 07:32:59.676 D/dalvikvm( 3869): GC_FOR_ALLOC freed 933K, 17% free 18537K/22312K, paused 17ms, total 17ms\n07-05 07:32:59.696 I/dalvikvm-heap( 3869): Grow heap (frag case) to 30.580MB for 11059216-byte allocation\n07-05 07:32:59.716 D/dalvikvm( 3869): GC_FOR_ALLOC freed 10K, 12% free 29327K/33116K, paused 16ms, total 16ms\n07-05 07:32:59.736 D/BohaRequest( 3869): parsing response, elapsed since start: 0.155 seconds\n07-05 07:32:59.736 I/BohaRequest( 3869): response string length returned: 217\n07-05 07:32:59.826 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:32:59.826 D/ProgressBar( 3869): updateDrawableBounds: left = 0\n07-05 07:32:59.826 D/ProgressBar( 3869): updateDrawableBounds: top = 0\n07-05 07:32:59.826 D/ProgressBar( 3869): updateDrawableBounds: right = 48\n07-05 07:32:59.826 D/ProgressBar( 3869): updateDrawableBounds: bottom = 48\n07-05 07:32:59.856 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:00.001 W/CacheUtil( 3869): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 07:33:00.071 I/BohaRequest( 3869): ---- Comms elapsed time: 0.49 seconds\n07-05 07:33:00.071 E/BaseVolley( 3869): Yup! ...response object received, status code: 0\n07-05 07:33:00.081 W/MainPagerActivity( 3869): getting provinces ...\n07-05 07:33:00.081 I/MainPagerActivity( 3869): Country code is ZA\n07-05 07:33:00.086 I/WebCheck( 3869): ###### WIFI AVAILABLE on check\n07-05 07:33:00.086 I/WebCheck( 3869): ###### WIFI CONNECTED on check\n07-05 07:33:00.086 I/WebCheck( 3869): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:33:00.086 E/WebCheck( 3869): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:33:00.086 D/WebCheck( 3869): ###### Network check completed in 2 ms\n07-05 07:33:00.146 I/BaseVolley( 3869): ...sending remote request: .......>\n07-05 07:33:00.146 I/BaseVolley( 3869): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 07:33:00.151 I/BohaRequest( 3869): ...Cloud Server communication started ...\n07-05 07:33:00.161 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:00.256 D/BohaRequest( 3869): parsing response, elapsed since start: 0.109 seconds\n07-05 07:33:00.261 I/BohaRequest( 3869): response string length returned: 3064\n07-05 07:33:00.386 I/BohaRequest( 3869): ---- Comms elapsed time: 0.239 seconds\n07-05 07:33:00.386 E/BaseVolley( 3869): Yup! ...response object received, status code: 0\n07-05 07:33:17.696 D/AbsListView( 3869): Get MotionRecognitionManager\n07-05 07:33:17.701 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:17.706 E/CourseListFragment( 3869): ## onResume\n07-05 07:33:17.821 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:18.406 I/TeamListFragment( 3869): ##### onCreateView\n07-05 07:33:18.406 E/TeamListFragment( 3869): TrainingClassID = 1\n07-05 07:33:18.431 D/AbsListView( 3869): Get MotionRecognitionManager\n07-05 07:33:18.431 V/Vibrator( 3869): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 07:33:18.431 V/Vibrator( 3869): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 07:33:18.456 E/TeamListFragment( 3869): TeamList is fucked!\n07-05 07:33:18.456 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:18.456 W/TeamListFragment( 3869): ## onResume\n07-05 07:33:18.466 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:33.161 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:33.416 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:33.416 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:33.421 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:33.421 W/ApplicationPackageManager( 3869): getCSCPackageItemText()\n07-05 07:33:33.461 W/ActivityPageFragment( 3869): ############################# onCreateView\n07-05 07:33:33.486 D/AbsListView( 3869): Get MotionRecognitionManager\n07-05 07:33:33.506 W/ActivityPageFragment( 3869): ############## setTrainingClassCourse\n07-05 07:33:33.506 W/ActivityPageFragment( 3869): ############## setList\n07-05 07:33:33.506 D/dalvikvm( 3869): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_traineeRating\n07-05 07:33:33.506 W/dalvikvm( 3869): VFY: unable to resolve static field 3102 (AR_traineeRating) in Lcom/boha/cmlibrary/R$id;\n07-05 07:33:33.506 D/dalvikvm( 3869): VFY: replacing opcode 0x60 at 0x0040\n07-05 07:33:33.506 D/dalvikvm( 3869): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_instructorRating\n07-05 07:33:33.506 I/dalvikvm( 3869): DexOpt: unable to optimize static field ref 0x0c1c at 0x48 in Lcom/boha/cmlibrary/adapters/ActivityAdapter;.getView\n07-05 07:33:33.516 I/ActivityListActivity( 3869): *** onResume - doin nuthin'' \n07-05 07:33:33.516 E/ActivityPageFragment( 3869): onResume in ActivityPageFragment\n07-05 07:33:33.516 D/AbsListView( 3869): onVisibilityChanged() is called, visibility : 4\n07-05 07:33:33.516 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:33.521 D/AbsListView( 3869): onVisibilityChanged() is called, visibility : 0\n07-05 07:33:33.521 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:33.526 D/AbsListView( 3869): unregisterIRListener() is called \n07-05 07:33:33.621 D/AndroidRuntime( 3869): Shutting down VM\n07-05 07:33:33.621 W/dalvikvm( 3869): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 07:33:33.621 E/ACRA    ( 3869): ACRA caught a NoSuchFieldError exception for com.boha.cmtrainee. Building report.\n07-05 07:33:33.621 D/ACRA    ( 3869): Using custom Report Fields\n07-05 07:33:33.636 I/ACRA    ( 3869): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 07:33:33.666 D/ACRA    ( 3869): Retrieving logcat output...\n');
INSERT INTO `errorStoreAndroid` (`errorStoreAndroidID`, `companyID`, `errorDate`, `packageName`, `appVersionName`, `appVersionCode`, `brand`, `phoneModel`, `androidVersion`, `stackTrace`, `logCat`) VALUES
(12, 1, '2014-07-05 07:36:46', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NoSuchFieldError: com.boha.cmlibrary.R$id.AR_tRating\n	at com.boha.cmlibrary.adapters.ActivityAdapter.getView(ActivityAdapter.java:58)\n	at android.widget.AbsListView.obtainView(AbsListView.java:2720)\n	at android.widget.ListView.makeAndAddView(ListView.java:1801)\n	at android.widget.ListView.fillDown(ListView.java:697)\n	at android.widget.ListView.fillFromTop(ListView.java:763)\n	at android.widget.ListView.layoutChildren(ListView.java:1641)\n	at android.widget.AbsListView.onLayout(AbsListView.java:2533)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1677)\n	at android.widget.LinearLayout.layoutHorizontal(LinearLayout.java:1666)\n	at android.widget.LinearLayout.onLayout(LinearLayout.java:1442)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at com.android.internal.widget.ActionBarOverlayLayout.onLayout(ActionBarOverlayLayout.java:438)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.view.ViewRootImpl.performLayout(ViewRootImpl.java:2284)\n	at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:2004)\n	at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1234)\n	at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6467)\n	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:803)\n	at android.view.Choreographer.doCallbacks(Choreographer.java:603)\n	at android.view.Choreographer.doFrame(Choreographer.java:573)\n	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:789)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 07:36:29.026 D/BohaRequest( 5003): parsing response, elapsed since start: 0.633 seconds\n07-05 07:36:29.036 I/BohaRequest( 5003): response string length returned: 2868\n07-05 07:36:29.326 I/BohaRequest( 5003): ---- Comms elapsed time: 0.933 seconds\n07-05 07:36:29.326 E/BaseVolley( 5003): Yup! ...response object received, status code: 0\n07-05 07:36:29.341 I/MainPagerActivity( 5003): ############ --building first 3 pages\n07-05 07:36:29.341 D/DashboardFragment( 5003): ---- onAttach\n07-05 07:36:29.346 I/DashboardFragment( 5003): -- onCreateView ............\n07-05 07:36:29.376 D/dalvikvm( 5003): GC_FOR_ALLOC freed 1210K, 19% free 17789K/21808K, paused 24ms, total 24ms\n07-05 07:36:29.381 I/dalvikvm-heap( 5003): Grow heap (frag case) to 19.794MB for 515824-byte allocation\n07-05 07:36:29.401 D/dalvikvm( 5003): GC_FOR_ALLOC freed 3K, 19% free 18289K/22312K, paused 21ms, total 21ms\n07-05 07:36:29.421 D/ProgressBar( 5003): setProgressDrawable drawableHeight = 0\n07-05 07:36:29.451 W/DashboardFragment( 5003): Trainee activities found: 6\n07-05 07:36:29.451 I/DashboardFragment( 5003): *** setData from response object \n07-05 07:36:29.461 D/TraineeListFragment( 5003): ---- onAttach\n07-05 07:36:29.461 I/TraineeListFragment( 5003): -- onCreateView ............\n07-05 07:36:29.476 D/AbsListView( 5003): Get MotionRecognitionManager\n07-05 07:36:29.491 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:29.496 D/TraineeListFragment( 5003): ---- onResume - nothing to be done\n07-05 07:36:29.496 I/MainPagerActivity( 5003): ---- getting class teams\n07-05 07:36:29.496 I/WebCheck( 5003): ###### WIFI AVAILABLE on check\n07-05 07:36:29.496 I/WebCheck( 5003): ###### WIFI CONNECTED on check\n07-05 07:36:29.496 I/WebCheck( 5003): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:36:29.496 E/WebCheck( 5003): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:36:29.496 D/WebCheck( 5003): ###### Network check completed in 1 ms\n07-05 07:36:29.556 I/BaseVolley( 5003): ...sending remote request: .......>\n07-05 07:36:29.556 I/BaseVolley( 5003): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 07:36:29.556 I/BohaRequest( 5003): ...Cloud Server communication started ...\n07-05 07:36:29.581 D/ProgressBar( 5003): updateDrawableBounds: left = 0\n07-05 07:36:29.581 D/ProgressBar( 5003): updateDrawableBounds: top = 0\n07-05 07:36:29.581 D/ProgressBar( 5003): updateDrawableBounds: right = 876\n07-05 07:36:29.581 D/ProgressBar( 5003): updateDrawableBounds: bottom = 60\n07-05 07:36:29.581 D/ProgressBar( 5003): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 07:36:29.631 D/dalvikvm( 5003): GC_FOR_ALLOC freed 843K, 17% free 18519K/22312K, paused 20ms, total 20ms\n07-05 07:36:29.656 I/dalvikvm-heap( 5003): Grow heap (frag case) to 30.563MB for 11059216-byte allocation\n07-05 07:36:29.671 D/dalvikvm( 5003): GC_FOR_ALLOC freed 5K, 12% free 29314K/33116K, paused 17ms, total 17ms\n07-05 07:36:29.771 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:29.771 D/ProgressBar( 5003): updateDrawableBounds: left = 0\n07-05 07:36:29.771 D/ProgressBar( 5003): updateDrawableBounds: top = 0\n07-05 07:36:29.771 D/ProgressBar( 5003): updateDrawableBounds: right = 48\n07-05 07:36:29.771 D/ProgressBar( 5003): updateDrawableBounds: bottom = 48\n07-05 07:36:29.801 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:29.881 D/BohaRequest( 5003): parsing response, elapsed since start: 0.317 seconds\n07-05 07:36:29.886 I/BohaRequest( 5003): response string length returned: 219\n07-05 07:36:29.966 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:29.991 W/CacheUtil( 5003): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 07:36:30.041 I/BohaRequest( 5003): ---- Comms elapsed time: 0.484 seconds\n07-05 07:36:30.041 E/BaseVolley( 5003): Yup! ...response object received, status code: 0\n07-05 07:36:30.051 W/MainPagerActivity( 5003): getting provinces ...\n07-05 07:36:30.051 I/MainPagerActivity( 5003): Country code is ZA\n07-05 07:36:30.051 I/WebCheck( 5003): ###### WIFI AVAILABLE on check\n07-05 07:36:30.051 I/WebCheck( 5003): ###### WIFI CONNECTED on check\n07-05 07:36:30.051 I/WebCheck( 5003): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:36:30.051 E/WebCheck( 5003): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:36:30.051 D/WebCheck( 5003): ###### Network check completed in 0 ms\n07-05 07:36:30.111 I/BaseVolley( 5003): ...sending remote request: .......>\n07-05 07:36:30.111 I/BaseVolley( 5003): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 07:36:30.111 I/BohaRequest( 5003): ...Cloud Server communication started ...\n07-05 07:36:30.266 D/BohaRequest( 5003): parsing response, elapsed since start: 0.151 seconds\n07-05 07:36:30.266 I/BohaRequest( 5003): response string length returned: 3064\n07-05 07:36:30.396 I/BohaRequest( 5003): ---- Comms elapsed time: 0.283 seconds\n07-05 07:36:30.396 E/BaseVolley( 5003): Yup! ...response object received, status code: 0\n07-05 07:36:39.946 D/AbsListView( 5003): Get MotionRecognitionManager\n07-05 07:36:39.956 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:39.956 E/CourseListFragment( 5003): ## onResume\n07-05 07:36:40.086 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:41.336 I/TeamListFragment( 5003): ##### onCreateView\n07-05 07:36:41.336 E/TeamListFragment( 5003): TrainingClassID = 1\n07-05 07:36:41.356 D/AbsListView( 5003): Get MotionRecognitionManager\n07-05 07:36:41.361 V/Vibrator( 5003): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 07:36:41.361 V/Vibrator( 5003): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 07:36:41.381 E/TeamListFragment( 5003): TeamList is fucked!\n07-05 07:36:41.381 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:41.381 W/TeamListFragment( 5003): ## onResume\n07-05 07:36:41.391 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:46.061 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:46.061 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:46.061 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:46.066 W/ApplicationPackageManager( 5003): getCSCPackageItemText()\n07-05 07:36:46.091 W/ActivityPageFragment( 5003): ############################# onCreateView\n07-05 07:36:46.111 D/AbsListView( 5003): Get MotionRecognitionManager\n07-05 07:36:46.131 W/ActivityPageFragment( 5003): ############## setTrainingClassCourse\n07-05 07:36:46.131 W/ActivityPageFragment( 5003): ############## setList\n07-05 07:36:46.131 D/dalvikvm( 5003): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_tRating\n07-05 07:36:46.131 W/dalvikvm( 5003): VFY: unable to resolve static field 3102 (AR_tRating) in Lcom/boha/cmlibrary/R$id;\n07-05 07:36:46.131 D/dalvikvm( 5003): VFY: replacing opcode 0x60 at 0x0040\n07-05 07:36:46.131 D/dalvikvm( 5003): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_instructorRating\n07-05 07:36:46.131 I/dalvikvm( 5003): DexOpt: unable to optimize static field ref 0x0c1c at 0x48 in Lcom/boha/cmlibrary/adapters/ActivityAdapter;.getView\n07-05 07:36:46.136 I/ActivityListActivity( 5003): *** onResume - doin nuthin'' \n07-05 07:36:46.141 E/ActivityPageFragment( 5003): onResume in ActivityPageFragment\n07-05 07:36:46.141 D/AbsListView( 5003): onVisibilityChanged() is called, visibility : 4\n07-05 07:36:46.141 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:46.146 D/AbsListView( 5003): onVisibilityChanged() is called, visibility : 0\n07-05 07:36:46.146 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:46.161 D/AbsListView( 5003): unregisterIRListener() is called \n07-05 07:36:46.261 D/AndroidRuntime( 5003): Shutting down VM\n07-05 07:36:46.261 W/dalvikvm( 5003): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 07:36:46.261 E/ACRA    ( 5003): ACRA caught a NoSuchFieldError exception for com.boha.cmtrainee. Building report.\n07-05 07:36:46.261 D/ACRA    ( 5003): Using custom Report Fields\n07-05 07:36:46.271 I/ACRA    ( 5003): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 07:36:46.306 D/ACRA    ( 5003): Retrieving logcat output...\n'),
(13, 1, '2014-07-05 07:58:25', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'android.content.ActivityNotFoundException: Unable to find explicit activity class {com.boha.cmtrainee/com.boha.cmlibrary.RatingActivity}; have you declared this activity in your AndroidManifest.xml?\n	at android.app.Instrumentation.checkStartActivityResult(Instrumentation.java:1648)\n	at android.app.Instrumentation.execStartActivity(Instrumentation.java:1442)\n	at android.app.Activity.startActivityForResult(Activity.java:3511)\n	at android.app.Activity.startActivityForResult(Activity.java:3472)\n	at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:824)\n	at com.boha.cmlibrary.ActivityListActivity.onRatingRequested(ActivityListActivity.java:94)\n	at com.boha.cmlibrary.fragments.ActivityPageFragment$1.onItemClick(ActivityPageFragment.java:110)\n	at android.widget.AdapterView.performItemClick(AdapterView.java:308)\n	at android.widget.AbsListView.performItemClick(AbsListView.java:1483)\n	at android.widget.AbsListView$PerformClick.run(AbsListView.java:3485)\n	at android.widget.AbsListView$3.run(AbsListView.java:4843)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 07:44:34.231 W/DashboardFragment( 6927): Trainee activities found: 6\n07-05 07:44:34.231 I/DashboardFragment( 6927): *** setData from response object \n07-05 07:44:34.241 D/TraineeListFragment( 6927): ---- onAttach\n07-05 07:44:34.246 I/TraineeListFragment( 6927): -- onCreateView ............\n07-05 07:44:34.256 D/AbsListView( 6927): Get MotionRecognitionManager\n07-05 07:44:34.271 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:34.271 D/TraineeListFragment( 6927): ---- onResume - nothing to be done\n07-05 07:44:34.271 I/MainPagerActivity( 6927): ---- getting class teams\n07-05 07:44:34.271 I/WebCheck( 6927): ###### WIFI AVAILABLE on check\n07-05 07:44:34.271 I/WebCheck( 6927): ###### WIFI CONNECTED on check\n07-05 07:44:34.271 I/WebCheck( 6927): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:44:34.271 E/WebCheck( 6927): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:44:34.271 D/WebCheck( 6927): ###### Network check completed in 1 ms\n07-05 07:44:34.351 I/BaseVolley( 6927): ...sending remote request: .......>\n07-05 07:44:34.351 I/BaseVolley( 6927): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 07:44:34.351 I/BohaRequest( 6927): ...Cloud Server communication started ...\n07-05 07:44:34.376 D/ProgressBar( 6927): updateDrawableBounds: left = 0\n07-05 07:44:34.376 D/ProgressBar( 6927): updateDrawableBounds: top = 0\n07-05 07:44:34.376 D/ProgressBar( 6927): updateDrawableBounds: right = 876\n07-05 07:44:34.376 D/ProgressBar( 6927): updateDrawableBounds: bottom = 60\n07-05 07:44:34.381 D/ProgressBar( 6927): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 07:44:34.431 D/dalvikvm( 6927): GC_FOR_ALLOC freed 903K, 17% free 18534K/22312K, paused 18ms, total 19ms\n07-05 07:44:34.466 I/dalvikvm-heap( 6927): Grow heap (frag case) to 30.577MB for 11059216-byte allocation\n07-05 07:44:34.486 D/dalvikvm( 6927): GC_FOR_ALLOC freed 5K, 12% free 29329K/33116K, paused 20ms, total 20ms\n07-05 07:44:34.606 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:34.606 D/ProgressBar( 6927): updateDrawableBounds: left = 0\n07-05 07:44:34.606 D/ProgressBar( 6927): updateDrawableBounds: top = 0\n07-05 07:44:34.606 D/ProgressBar( 6927): updateDrawableBounds: right = 48\n07-05 07:44:34.606 D/ProgressBar( 6927): updateDrawableBounds: bottom = 48\n07-05 07:44:34.631 D/BohaRequest( 6927): parsing response, elapsed since start: 0.269 seconds\n07-05 07:44:34.631 I/BohaRequest( 6927): response string length returned: 219\n07-05 07:44:34.631 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:34.966 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:34.991 W/CacheUtil( 6927): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 07:44:35.146 I/BohaRequest( 6927): ---- Comms elapsed time: 0.795 seconds\n07-05 07:44:35.146 E/BaseVolley( 6927): Yup! ...response object received, status code: 0\n07-05 07:44:35.156 W/MainPagerActivity( 6927): getting provinces ...\n07-05 07:44:35.156 I/MainPagerActivity( 6927): Country code is ZA\n07-05 07:44:35.156 I/WebCheck( 6927): ###### WIFI AVAILABLE on check\n07-05 07:44:35.156 I/WebCheck( 6927): ###### WIFI CONNECTED on check\n07-05 07:44:35.156 I/WebCheck( 6927): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:44:35.156 E/WebCheck( 6927): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:44:35.156 D/WebCheck( 6927): ###### Network check completed in 1 ms\n07-05 07:44:35.226 I/BaseVolley( 6927): ...sending remote request: .......>\n07-05 07:44:35.226 I/BaseVolley( 6927): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 07:44:35.226 I/BohaRequest( 6927): ...Cloud Server communication started ...\n07-05 07:44:35.251 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:35.376 D/BohaRequest( 6927): parsing response, elapsed since start: 0.135 seconds\n07-05 07:44:35.376 I/BohaRequest( 6927): response string length returned: 3062\n07-05 07:44:35.566 I/BohaRequest( 6927): ---- Comms elapsed time: 0.339 seconds\n07-05 07:44:35.566 E/BaseVolley( 6927): Yup! ...response object received, status code: 0\n07-05 07:45:05.771 D/AbsListView( 6927): Get MotionRecognitionManager\n07-05 07:45:05.781 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:05.781 E/CourseListFragment( 6927): ## onResume\n07-05 07:45:05.901 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:06.691 I/TeamListFragment( 6927): ##### onCreateView\n07-05 07:45:06.691 E/TeamListFragment( 6927): TrainingClassID = 1\n07-05 07:45:06.711 D/AbsListView( 6927): Get MotionRecognitionManager\n07-05 07:45:06.711 V/Vibrator( 6927): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 07:45:06.711 V/Vibrator( 6927): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 07:45:06.731 E/TeamListFragment( 6927): TeamList is fucked!\n07-05 07:45:06.731 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:06.731 W/TeamListFragment( 6927): ## onResume\n07-05 07:45:06.746 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.481 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.641 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.646 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.646 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.651 W/ApplicationPackageManager( 6927): getCSCPackageItemText()\n07-05 07:45:10.686 W/ActivityPageFragment( 6927): ############################# onCreateView\n07-05 07:45:10.716 D/AbsListView( 6927): Get MotionRecognitionManager\n07-05 07:45:10.736 W/ActivityPageFragment( 6927): ############## setTrainingClassCourse\n07-05 07:45:10.736 W/ActivityPageFragment( 6927): ############## setList\n07-05 07:45:10.746 I/ActivityListActivity( 6927): *** onResume - doin nuthin'' \n07-05 07:45:10.746 E/ActivityPageFragment( 6927): onResume in ActivityPageFragment\n07-05 07:45:10.746 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 4\n07-05 07:45:10.746 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.756 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 0\n07-05 07:45:10.756 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.761 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.011 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.021 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.096 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.121 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.686 W/MainPagerActivity( 6927): onSaveInstanceState\n07-05 07:45:11.691 W/TeamListFragment( 6927): ## onSaveInstanceState\n07-05 07:45:11.691 I/TraineeListFragment( 6927): onSaveInstanceState\n07-05 07:45:11.691 I/CourseListFragment( 6927): ##### onSaveInstanceState  fired ....\n07-05 07:45:11.696 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 4\n07-05 07:45:11.696 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.696 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 4\n07-05 07:45:11.696 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.696 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 4\n07-05 07:45:11.696 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:58:24.646 D/AndroidRuntime( 6927): Shutting down VM\n07-05 07:58:24.646 W/dalvikvm( 6927): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 07:58:24.651 E/ACRA    ( 6927): ACRA caught a ActivityNotFoundException exception for com.boha.cmtrainee. Building report.\n07-05 07:58:24.651 D/ACRA    ( 6927): Using custom Report Fields\n07-05 07:58:24.661 I/ACRA    ( 6927): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 07:58:24.696 D/ACRA    ( 6927): Retrieving logcat output...\n'),
(14, 1, '2014-07-05 07:58:28', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'android.content.ActivityNotFoundException: Unable to find explicit activity class {com.boha.cmtrainee/com.boha.cmlibrary.RatingActivity}; have you declared this activity in your AndroidManifest.xml?\n	at android.app.Instrumentation.checkStartActivityResult(Instrumentation.java:1648)\n	at android.app.Instrumentation.execStartActivity(Instrumentation.java:1442)\n	at android.app.Activity.startActivityForResult(Activity.java:3511)\n	at android.app.Activity.startActivityForResult(Activity.java:3472)\n	at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:824)\n	at com.boha.cmlibrary.ActivityListActivity.onRatingRequested(ActivityListActivity.java:94)\n	at com.boha.cmlibrary.fragments.ActivityPageFragment$1.onItemClick(ActivityPageFragment.java:110)\n	at android.widget.AdapterView.performItemClick(AdapterView.java:308)\n	at android.widget.AbsListView.performItemClick(AbsListView.java:1483)\n	at android.widget.AbsListView$PerformClick.run(AbsListView.java:3485)\n	at android.widget.AbsListView$3.run(AbsListView.java:4843)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 07:44:34.231 W/DashboardFragment( 6927): Trainee activities found: 6\n07-05 07:44:34.231 I/DashboardFragment( 6927): *** setData from response object \n07-05 07:44:34.241 D/TraineeListFragment( 6927): ---- onAttach\n07-05 07:44:34.246 I/TraineeListFragment( 6927): -- onCreateView ............\n07-05 07:44:34.256 D/AbsListView( 6927): Get MotionRecognitionManager\n07-05 07:44:34.271 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:34.271 D/TraineeListFragment( 6927): ---- onResume - nothing to be done\n07-05 07:44:34.271 I/MainPagerActivity( 6927): ---- getting class teams\n07-05 07:44:34.271 I/WebCheck( 6927): ###### WIFI AVAILABLE on check\n07-05 07:44:34.271 I/WebCheck( 6927): ###### WIFI CONNECTED on check\n07-05 07:44:34.271 I/WebCheck( 6927): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:44:34.271 E/WebCheck( 6927): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:44:34.271 D/WebCheck( 6927): ###### Network check completed in 1 ms\n07-05 07:44:34.351 I/BaseVolley( 6927): ...sending remote request: .......>\n07-05 07:44:34.351 I/BaseVolley( 6927): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 07:44:34.351 I/BohaRequest( 6927): ...Cloud Server communication started ...\n07-05 07:44:34.376 D/ProgressBar( 6927): updateDrawableBounds: left = 0\n07-05 07:44:34.376 D/ProgressBar( 6927): updateDrawableBounds: top = 0\n07-05 07:44:34.376 D/ProgressBar( 6927): updateDrawableBounds: right = 876\n07-05 07:44:34.376 D/ProgressBar( 6927): updateDrawableBounds: bottom = 60\n07-05 07:44:34.381 D/ProgressBar( 6927): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 07:44:34.431 D/dalvikvm( 6927): GC_FOR_ALLOC freed 903K, 17% free 18534K/22312K, paused 18ms, total 19ms\n07-05 07:44:34.466 I/dalvikvm-heap( 6927): Grow heap (frag case) to 30.577MB for 11059216-byte allocation\n07-05 07:44:34.486 D/dalvikvm( 6927): GC_FOR_ALLOC freed 5K, 12% free 29329K/33116K, paused 20ms, total 20ms\n07-05 07:44:34.606 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:34.606 D/ProgressBar( 6927): updateDrawableBounds: left = 0\n07-05 07:44:34.606 D/ProgressBar( 6927): updateDrawableBounds: top = 0\n07-05 07:44:34.606 D/ProgressBar( 6927): updateDrawableBounds: right = 48\n07-05 07:44:34.606 D/ProgressBar( 6927): updateDrawableBounds: bottom = 48\n07-05 07:44:34.631 D/BohaRequest( 6927): parsing response, elapsed since start: 0.269 seconds\n07-05 07:44:34.631 I/BohaRequest( 6927): response string length returned: 219\n07-05 07:44:34.631 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:34.966 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:34.991 W/CacheUtil( 6927): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 07:44:35.146 I/BohaRequest( 6927): ---- Comms elapsed time: 0.795 seconds\n07-05 07:44:35.146 E/BaseVolley( 6927): Yup! ...response object received, status code: 0\n07-05 07:44:35.156 W/MainPagerActivity( 6927): getting provinces ...\n07-05 07:44:35.156 I/MainPagerActivity( 6927): Country code is ZA\n07-05 07:44:35.156 I/WebCheck( 6927): ###### WIFI AVAILABLE on check\n07-05 07:44:35.156 I/WebCheck( 6927): ###### WIFI CONNECTED on check\n07-05 07:44:35.156 I/WebCheck( 6927): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 07:44:35.156 E/WebCheck( 6927): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 07:44:35.156 D/WebCheck( 6927): ###### Network check completed in 1 ms\n07-05 07:44:35.226 I/BaseVolley( 6927): ...sending remote request: .......>\n07-05 07:44:35.226 I/BaseVolley( 6927): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 07:44:35.226 I/BohaRequest( 6927): ...Cloud Server communication started ...\n07-05 07:44:35.251 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:44:35.376 D/BohaRequest( 6927): parsing response, elapsed since start: 0.135 seconds\n07-05 07:44:35.376 I/BohaRequest( 6927): response string length returned: 3062\n07-05 07:44:35.566 I/BohaRequest( 6927): ---- Comms elapsed time: 0.339 seconds\n07-05 07:44:35.566 E/BaseVolley( 6927): Yup! ...response object received, status code: 0\n07-05 07:45:05.771 D/AbsListView( 6927): Get MotionRecognitionManager\n07-05 07:45:05.781 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:05.781 E/CourseListFragment( 6927): ## onResume\n07-05 07:45:05.901 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:06.691 I/TeamListFragment( 6927): ##### onCreateView\n07-05 07:45:06.691 E/TeamListFragment( 6927): TrainingClassID = 1\n07-05 07:45:06.711 D/AbsListView( 6927): Get MotionRecognitionManager\n07-05 07:45:06.711 V/Vibrator( 6927): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 07:45:06.711 V/Vibrator( 6927): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 07:45:06.731 E/TeamListFragment( 6927): TeamList is fucked!\n07-05 07:45:06.731 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:06.731 W/TeamListFragment( 6927): ## onResume\n07-05 07:45:06.746 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.481 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.641 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.646 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.646 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.651 W/ApplicationPackageManager( 6927): getCSCPackageItemText()\n07-05 07:45:10.686 W/ActivityPageFragment( 6927): ############################# onCreateView\n07-05 07:45:10.716 D/AbsListView( 6927): Get MotionRecognitionManager\n07-05 07:45:10.736 W/ActivityPageFragment( 6927): ############## setTrainingClassCourse\n07-05 07:45:10.736 W/ActivityPageFragment( 6927): ############## setList\n07-05 07:45:10.746 I/ActivityListActivity( 6927): *** onResume - doin nuthin'' \n07-05 07:45:10.746 E/ActivityPageFragment( 6927): onResume in ActivityPageFragment\n07-05 07:45:10.746 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 4\n07-05 07:45:10.746 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.756 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 0\n07-05 07:45:10.756 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:10.761 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.011 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.021 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.096 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.121 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.686 W/MainPagerActivity( 6927): onSaveInstanceState\n07-05 07:45:11.691 W/TeamListFragment( 6927): ## onSaveInstanceState\n07-05 07:45:11.691 I/TraineeListFragment( 6927): onSaveInstanceState\n07-05 07:45:11.691 I/CourseListFragment( 6927): ##### onSaveInstanceState  fired ....\n07-05 07:45:11.696 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 4\n07-05 07:45:11.696 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.696 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 4\n07-05 07:45:11.696 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:45:11.696 D/AbsListView( 6927): onVisibilityChanged() is called, visibility : 4\n07-05 07:45:11.696 D/AbsListView( 6927): unregisterIRListener() is called \n07-05 07:58:24.646 D/AndroidRuntime( 6927): Shutting down VM\n07-05 07:58:24.646 W/dalvikvm( 6927): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 07:58:24.651 E/ACRA    ( 6927): ACRA caught a ActivityNotFoundException exception for com.boha.cmtrainee. Building report.\n07-05 07:58:24.651 D/ACRA    ( 6927): Using custom Report Fields\n07-05 07:58:24.661 I/ACRA    ( 6927): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 07:58:24.696 D/ACRA    ( 6927): Retrieving logcat output...\n'),
(15, 1, '2014-07-05 08:03:32', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.android.volley.toolbox.NetworkImageView.loadImageIfNecessary(NetworkImageView.java:149)\n	at com.android.volley.toolbox.NetworkImageView.onLayout(NetworkImageView.java:198)\n	at android.view.View.layout(View.java:15655)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.ListView.setupChild(ListView.java:1895)\n	at android.widget.ListView.makeAndAddView(ListView.java:1806)\n	at android.widget.ListView.fillDown(ListView.java:697)\n	at android.widget.ListView.fillFromTop(ListView.java:763)\n	at android.widget.ListView.layoutChildren(ListView.java:1641)\n	at android.widget.AbsListView.onLayout(AbsListView.java:2533)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1677)\n	at android.widget.LinearLayout.layoutVertical(LinearLayout.java:1531)\n	at android.widget.LinearLayout.onLayout(LinearLayout.java:1440)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.support.v4.view.ViewPager.onLayout(ViewPager.java:1589)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1677)\n	at android.widget.LinearLayout.layoutVertical(LinearLayout.java:1531)\n	at android.widget.LinearLayout.onLayout(LinearLayout.java:1440)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at com.android.internal.widget.ActionBarOverlayLayout.onLayout(ActionBarOverlayLayout.java:438)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.view.ViewRootImpl.performLayout(ViewRootImpl.java:2284)\n	at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:2004)\n	at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1234)\n	at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6467)\n	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:803)\n	at android.view.Choreographer.doCallbacks(Choreographer.java:603)\n	at android.view.Choreographer.doFrame(Choreographer.java:573)\n	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:789)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 07:58:24.646 D/AndroidRuntime( 6927): Shutting down VM\n07-05 07:58:24.646 W/dalvikvm( 6927): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 07:58:24.651 E/ACRA    ( 6927): ACRA caught a ActivityNotFoundException exception for com.boha.cmtrainee. Building report.\n07-05 07:58:24.651 D/ACRA    ( 6927): Using custom Report Fields\n07-05 07:58:24.661 I/ACRA    ( 6927): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 07:58:24.696 D/ACRA    ( 6927): Retrieving logcat output...\n07-05 07:58:24.741 D/ACRA    ( 6927): Writing crash report file 1404539904000.stacktrace.\n07-05 07:58:24.751 D/ACRA    ( 6927): About to start ReportSenderWorker from #handleException\n07-05 07:58:24.756 D/ACRA    ( 6927): Mark all pending reports as approved.\n07-05 07:58:24.756 D/ACRA    ( 6927): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 07:58:24.756 D/ACRA    ( 6927): Waiting for Toast + worker...\n07-05 07:58:24.756 D/ACRA    ( 6927): #checkAndSendReports - start\n07-05 07:58:24.756 D/ACRA    ( 6927): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 07:58:24.756 I/ACRA    ( 6927): Sending file 1404539904000-approved.stacktrace\n07-05 07:58:24.781 D/ACRA    ( 6927): Connect to http://192.168.1.111:8050/cm/crash\n07-05 07:58:24.806 D/ACRA    ( 6927): Sending request to http://192.168.1.111:8050/cm/crash\n07-05 07:58:27.841 D/ACRA    ( 6927): SocketTimeOut - increasing time out to 6000 millis and trying again\n07-05 07:58:30.201 I/System.out( 6927): Thread-8009 calls detatch()\n07-05 07:58:30.206 D/ACRA    ( 6927): #checkAndSendReports - finish\n07-05 07:58:30.281 D/ACRA    ( 6927): Wait for Toast + worker ended. Kill Application ? true\n--------- beginning of /dev/log/system\n07-05 07:58:30.281 E/AndroidRuntime( 6927): FATAL EXCEPTION: main\n07-05 07:58:30.281 E/AndroidRuntime( 6927): Process: com.boha.cmtrainee, PID: 6927\n07-05 07:58:30.281 E/AndroidRuntime( 6927): android.content.ActivityNotFoundException: Unable to find explicit activity class {com.boha.cmtrainee/com.boha.cmlibrary.RatingActivity}; have you declared this activity in your AndroidManifest.xml?\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.app.Instrumentation.checkStartActivityResult(Instrumentation.java:1648)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.app.Instrumentation.execStartActivity(Instrumentation.java:1442)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.app.Activity.startActivityForResult(Activity.java:3511)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.app.Activity.startActivityForResult(Activity.java:3472)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:824)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at com.boha.cmlibrary.ActivityListActivity.onRatingRequested(ActivityListActivity.java:94)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at com.boha.cmlibrary.fragments.ActivityPageFragment$1.onItemClick(ActivityPageFragment.java:110)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.widget.AdapterView.performItemClick(AdapterView.java:308)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.widget.AbsListView.performItemClick(AbsListView.java:1483)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.widget.AbsListView$PerformClick.run(AbsListView.java:3485)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.widget.AbsListView$3.run(AbsListView.java:4843)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.os.Handler.handleCallback(Handler.java:733)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.os.Handler.dispatchMessage(Handler.java:95)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.os.Looper.loop(Looper.java:157)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at android.app.ActivityThread.main(ActivityThread.java:5356)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at java.lang.reflect.Method.invokeNative(Native Method)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at java.lang.reflect.Method.invoke(Method.java:515)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n07-05 07:58:30.281 E/AndroidRuntime( 6927): 	at dalvik.system.NativeStart.main(Native Method)\n07-05 08:03:30.351 I/Process ( 6927): Sending signal. PID: 6927 SIG: 9\n07-05 08:03:30.676 D/dalvikvm( 8796): Late-enabling CheckJNI\n07-05 08:03:30.756 D/CMApp   ( 8796): ############################ onCreate CMApp has started ---------------->\n07-05 08:03:30.766 D/ACRA    ( 8796): ACRA is enabled for com.boha.cmtrainee, intializing...\n07-05 08:03:30.796 D/ACRA    ( 8796): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 08:03:30.801 E/CMApp   ( 8796): ###### ACRA Crash Reporting has been initiated\n07-05 08:03:30.801 E/CMApp   ( 8796): initializing Volley Networking ...\n07-05 08:03:30.806 I/CMApp   ( 8796): ********** Yebo! Volley Networking has been initialized, cache size: 16384 KB\n07-05 08:03:30.831 W/ApplicationPackageManager( 8796): getCSCPackageItemText()\n07-05 08:03:30.966 D/TraineeListFragment( 8796): ---- onAttach\n07-05 08:03:31.011 E/MainPagerActivity( 8796): ---- onCreate\n07-05 08:03:31.156 I/MainPagerActivity( 8796): restored instance state, fragments to be set\n07-05 08:03:31.156 I/MainPagerActivity( 8796): ############ --building first 3 pages\n07-05 08:03:31.156 E/BohaVolley( 8796): initializing Volley Networking ...\n07-05 08:03:31.161 I/BohaVolley( 8796): Yebo! Volley Networking has been initialized\n07-05 08:03:31.166 I/TeamListFragment( 8796): ##### onCreateView\n07-05 08:03:31.201 E/TeamListFragment( 8796): TrainingClassID = 1\n07-05 08:03:31.241 D/AbsListView( 8796): Get MotionRecognitionManager\n07-05 08:03:31.421 D/dalvikvm( 8796): GC_FOR_ALLOC freed 2181K, 20% free 17648K/21808K, paused 34ms, total 35ms\n07-05 08:03:31.426 V/Vibrator( 8796): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 08:03:31.431 V/Vibrator( 8796): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 08:03:31.446 E/TeamListFragment( 8796): TeamList is fucked!\n07-05 08:03:31.451 I/TraineeListFragment( 8796): -- onCreateView ............\n07-05 08:03:31.461 D/AbsListView( 8796): Get MotionRecognitionManager\n07-05 08:03:31.491 D/AbsListView( 8796): Get MotionRecognitionManager\n07-05 08:03:31.496 I/CourseListFragment( 8796): saved is not null\n07-05 08:03:31.511 E/MainPagerActivity( 8796): onResume ...nuthin be done\n07-05 08:03:31.511 W/TeamListFragment( 8796): ## onResume\n07-05 08:03:31.511 D/TraineeListFragment( 8796): ---- onResume - nothing to be done\n07-05 08:03:31.511 E/CourseListFragment( 8796): ## onResume\n07-05 08:03:31.511 D/AbsListView( 8796): onVisibilityChanged() is called, visibility : 4\n07-05 08:03:31.511 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.511 D/AbsListView( 8796): onVisibilityChanged() is called, visibility : 4\n07-05 08:03:31.511 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.511 D/AbsListView( 8796): onVisibilityChanged() is called, visibility : 4\n07-05 08:03:31.511 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.516 D/AbsListView( 8796): onVisibilityChanged() is called, visibility : 0\n07-05 08:03:31.516 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.516 D/AbsListView( 8796): onVisibilityChanged() is called, visibility : 0\n07-05 08:03:31.516 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.516 D/AbsListView( 8796): onVisibilityChanged() is called, visibility : 0\n07-05 08:03:31.516 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.541 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.541 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.541 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.666 D/OpenGLRenderer( 8796): Enabling debug mode 0\n07-05 08:03:31.681 D/AbsListView( 8796): unregisterIRListener() is called \n07-05 08:03:31.736 D/dalvikvm( 8796): GC_FOR_ALLOC freed 495K, 19% free 17744K/21808K, paused 27ms, total 27ms\n07-05 08:03:31.766 I/dalvikvm-heap( 8796): Grow heap (frag case) to 29.806MB for 11059216-byte allocation\n07-05 08:03:31.786 D/dalvikvm( 8796): GC_FOR_ALLOC freed 1K, 13% free 28543K/32612K, paused 21ms, total 21ms\n07-05 08:03:31.811 D/AndroidRuntime( 8796): Shutting down VM\n07-05 08:03:31.811 W/dalvikvm( 8796): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 08:03:31.811 E/ACRA    ( 8796): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 08:03:31.811 D/ACRA    ( 8796): Using custom Report Fields\n07-05 08:03:31.816 I/ACRA    ( 8796): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 08:03:31.841 D/ACRA    ( 8796): Retrieving logcat output...\n');
INSERT INTO `errorStoreAndroid` (`errorStoreAndroidID`, `companyID`, `errorDate`, `packageName`, `appVersionName`, `appVersionCode`, `brand`, `phoneModel`, `androidVersion`, `stackTrace`, `logCat`) VALUES
(16, 1, '2014-07-05 08:33:48', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NoSuchFieldError: com.boha.cmlibrary.R$id.rating_fragment\n	at com.boha.cmlibrary.RatingActivity.onCreate(RatingActivity.java:27)\n	at android.app.Activity.performCreate(Activity.java:5426)\n	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1105)\n	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2269)\n	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2363)\n	at android.app.ActivityThread.access$900(ActivityThread.java:161)\n	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1265)\n	at android.os.Handler.dispatchMessage(Handler.java:102)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 08:07:00.256 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:07:00.256 D/TraineeListFragment( 9328): ---- onResume - nothing to be done\n07-05 08:07:00.261 I/MainPagerActivity( 9328): ---- getting class teams\n07-05 08:07:00.261 I/WebCheck( 9328): ###### WIFI AVAILABLE on check\n07-05 08:07:00.261 I/WebCheck( 9328): ###### WIFI CONNECTED on check\n07-05 08:07:00.261 I/WebCheck( 9328): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 08:07:00.261 E/WebCheck( 9328): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 08:07:00.261 D/WebCheck( 9328): ###### Network check completed in 2 ms\n07-05 08:07:00.341 I/BaseVolley( 9328): ...sending remote request: .......>\n07-05 08:07:00.341 I/BaseVolley( 9328): http://192.168.1.111:8050/cm/team?JSON={"trainingClassID":1,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":116,"returnEquipment":false}\n07-05 08:07:00.341 I/BohaRequest( 9328): ...Cloud Server communication started ...\n07-05 08:07:00.366 D/ProgressBar( 9328): updateDrawableBounds: left = 0\n07-05 08:07:00.366 D/ProgressBar( 9328): updateDrawableBounds: top = 0\n07-05 08:07:00.366 D/ProgressBar( 9328): updateDrawableBounds: right = 876\n07-05 08:07:00.366 D/ProgressBar( 9328): updateDrawableBounds: bottom = 60\n07-05 08:07:00.366 D/ProgressBar( 9328): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 08:07:00.426 D/dalvikvm( 9328): GC_FOR_ALLOC freed 908K, 17% free 18538K/22312K, paused 22ms, total 22ms\n07-05 08:07:00.456 I/dalvikvm-heap( 9328): Grow heap (frag case) to 30.581MB for 11059216-byte allocation\n07-05 08:07:00.471 D/dalvikvm( 9328): GC_FOR_ALLOC freed 9K, 12% free 29329K/33116K, paused 15ms, total 16ms\n07-05 08:07:00.546 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:07:00.546 D/ProgressBar( 9328): updateDrawableBounds: left = 0\n07-05 08:07:00.546 D/ProgressBar( 9328): updateDrawableBounds: top = 0\n07-05 08:07:00.546 D/ProgressBar( 9328): updateDrawableBounds: right = 48\n07-05 08:07:00.546 D/ProgressBar( 9328): updateDrawableBounds: bottom = 48\n07-05 08:07:00.581 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:07:00.716 W/CacheUtil( 9328): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 20489\n07-05 08:07:00.801 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:07:01.021 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:07:01.076 D/BohaRequest( 9328): parsing response, elapsed since start: 0.732 seconds\n07-05 08:07:01.076 I/BohaRequest( 9328): response string length returned: 219\n07-05 08:07:01.216 I/BohaRequest( 9328): ---- Comms elapsed time: 0.875 seconds\n07-05 08:07:01.216 E/BaseVolley( 9328): Yup! ...response object received, status code: 0\n07-05 08:07:01.231 W/MainPagerActivity( 9328): getting provinces ...\n07-05 08:07:01.231 I/MainPagerActivity( 9328): Country code is ZA\n07-05 08:07:01.231 I/WebCheck( 9328): ###### WIFI AVAILABLE on check\n07-05 08:07:01.231 I/WebCheck( 9328): ###### WIFI CONNECTED on check\n07-05 08:07:01.231 I/WebCheck( 9328): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 08:07:01.231 E/WebCheck( 9328): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 08:07:01.231 D/WebCheck( 9328): ###### Network check completed in 2 ms\n07-05 08:07:01.301 I/BaseVolley( 9328): ...sending remote request: .......>\n07-05 08:07:01.301 I/BaseVolley( 9328): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 08:07:01.301 I/BohaRequest( 9328): ...Cloud Server communication started ...\n07-05 08:07:03.136 D/BohaRequest( 9328): parsing response, elapsed since start: 1.833 seconds\n07-05 08:07:03.136 I/BohaRequest( 9328): response string length returned: 3064\n07-05 08:07:03.301 I/BohaRequest( 9328): ---- Comms elapsed time: 1.996 seconds\n07-05 08:07:03.301 E/BaseVolley( 9328): Yup! ...response object received, status code: 0\n07-05 08:07:18.066 D/AbsListView( 9328): Get MotionRecognitionManager\n07-05 08:07:18.076 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:07:18.076 E/CourseListFragment( 9328): ## onResume\n07-05 08:07:18.186 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:38.436 I/TeamListFragment( 9328): ##### onCreateView\n07-05 08:33:38.436 E/TeamListFragment( 9328): TrainingClassID = 1\n07-05 08:33:38.461 D/AbsListView( 9328): Get MotionRecognitionManager\n07-05 08:33:38.466 V/Vibrator( 9328): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 08:33:38.466 V/Vibrator( 9328): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 08:33:38.486 E/TeamListFragment( 9328): TeamList is fucked!\n07-05 08:33:38.486 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:38.486 W/TeamListFragment( 9328): ## onResume\n07-05 08:33:38.506 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.566 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.566 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.571 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.571 W/ApplicationPackageManager( 9328): getCSCPackageItemText()\n07-05 08:33:43.616 W/ActivityPageFragment( 9328): ############################# onCreateView\n07-05 08:33:43.646 D/AbsListView( 9328): Get MotionRecognitionManager\n07-05 08:33:43.671 W/ActivityPageFragment( 9328): ############## setTrainingClassCourse\n07-05 08:33:43.671 W/ActivityPageFragment( 9328): ############## setList\n07-05 08:33:43.676 I/ActivityListActivity( 9328): *** onResume - doin nuthin'' \n07-05 08:33:43.676 E/ActivityPageFragment( 9328): onResume in ActivityPageFragment\n07-05 08:33:43.676 D/AbsListView( 9328): onVisibilityChanged() is called, visibility : 4\n07-05 08:33:43.676 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.681 D/AbsListView( 9328): onVisibilityChanged() is called, visibility : 0\n07-05 08:33:43.681 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.691 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.856 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.861 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.906 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:43.926 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:44.481 W/MainPagerActivity( 9328): onSaveInstanceState\n07-05 08:33:44.486 W/TeamListFragment( 9328): ## onSaveInstanceState\n07-05 08:33:44.486 I/TraineeListFragment( 9328): onSaveInstanceState\n07-05 08:33:44.486 I/CourseListFragment( 9328): ##### onSaveInstanceState  fired ....\n07-05 08:33:44.491 D/AbsListView( 9328): onVisibilityChanged() is called, visibility : 4\n07-05 08:33:44.491 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:44.491 D/AbsListView( 9328): onVisibilityChanged() is called, visibility : 4\n07-05 08:33:44.491 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:44.491 D/AbsListView( 9328): onVisibilityChanged() is called, visibility : 4\n07-05 08:33:44.491 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:47.256 I/REG     ( 9328): -- onPause ---\n07-05 08:33:47.286 D/AbsListView( 9328): unregisterIRListener() is called \n07-05 08:33:47.286 D/dalvikvm( 9328): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.rating_fragment\n07-05 08:33:47.286 W/dalvikvm( 9328): VFY: unable to resolve static field 3217 (rating_fragment) in Lcom/boha/cmlibrary/R$id;\n07-05 08:33:47.286 D/dalvikvm( 9328): VFY: replacing opcode 0x60 at 0x000c\n07-05 08:33:47.286 W/ApplicationPackageManager( 9328): getCSCPackageItemText()\n07-05 08:33:47.366 D/AndroidRuntime( 9328): Shutting down VM\n07-05 08:33:47.366 W/dalvikvm( 9328): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 08:33:47.366 E/ACRA    ( 9328): ACRA caught a NoSuchFieldError exception for com.boha.cmtrainee. Building report.\n07-05 08:33:47.366 D/ACRA    ( 9328): Using custom Report Fields\n07-05 08:33:47.371 I/ACRA    ( 9328): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 08:33:47.406 D/ACRA    ( 9328): Retrieving logcat output...\n'),
(17, 1, '2014-07-05 12:56:07', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmlibrary.fragments.RatingFragment.sendTraineeRating(RatingFragment.java:258)\n	at com.boha.cmlibrary.fragments.RatingFragment.access$200(RatingFragment.java:39)\n	at com.boha.cmlibrary.fragments.RatingFragment$2.onClick(RatingFragment.java:140)\n	at android.view.View.performClick(View.java:4633)\n	at android.view.View$PerformClick.run(View.java:19330)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 12:53:22.186 D/ProgressBar(29735): updateDrawableBounds: left = 0\n07-05 12:53:22.186 D/ProgressBar(29735): updateDrawableBounds: top = 0\n07-05 12:53:22.186 D/ProgressBar(29735): updateDrawableBounds: right = 876\n07-05 12:53:22.186 D/ProgressBar(29735): updateDrawableBounds: bottom = 60\n07-05 12:53:22.186 D/ProgressBar(29735): updateDrawableBounds: mProgressDrawable.setBounds()\n07-05 12:53:22.186 D/ProgressBar(29735): updateDrawableBounds: left = 0\n07-05 12:53:22.186 D/ProgressBar(29735): updateDrawableBounds: top = 0\n07-05 12:53:22.186 D/ProgressBar(29735): updateDrawableBounds: right = 48\n07-05 12:53:22.186 D/ProgressBar(29735): updateDrawableBounds: bottom = 48\n07-05 12:53:22.201 W/CacheUtil(29735): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/ratings.json - length: 588 items: 7\n07-05 12:53:22.216 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:22.221 W/CacheUtil(29735): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/helptypes.json - length: 760 items: 10\n07-05 12:53:22.251 D/BohaRequest(29735): parsing response, elapsed since start: 0.185 seconds\n07-05 12:53:22.251 I/BohaRequest(29735): response string length returned: 219\n07-05 12:53:22.361 I/BohaRequest(29735): ---- Comms elapsed time: 0.294 seconds\n07-05 12:53:22.361 E/BaseVolley(29735): Yup! ...response object received, status code: 0\n07-05 12:53:22.371 W/MainPagerActivity(29735): getting provinces ...\n07-05 12:53:22.371 I/MainPagerActivity(29735): Country code is ZA\n07-05 12:53:22.376 I/WebCheck(29735): ###### WIFI AVAILABLE on check\n07-05 12:53:22.376 I/WebCheck(29735): ###### WIFI CONNECTED on check\n07-05 12:53:22.376 I/WebCheck(29735): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 12:53:22.376 E/WebCheck(29735): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 12:53:22.376 D/WebCheck(29735): ###### Network check completed in 1 ms\n07-05 12:53:22.421 I/BaseVolley(29735): ...sending remote request: .......>\n07-05 12:53:22.421 I/BaseVolley(29735): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 12:53:22.421 I/BohaRequest(29735): ...Cloud Server communication started ...\n07-05 12:53:22.566 D/BohaRequest(29735): parsing response, elapsed since start: 0.144 seconds\n07-05 12:53:22.566 I/BohaRequest(29735): response string length returned: 3064\n07-05 12:53:22.741 I/BohaRequest(29735): ---- Comms elapsed time: 0.322 seconds\n07-05 12:53:22.746 E/BaseVolley(29735): Yup! ...response object received, status code: 0\n07-05 12:53:51.081 D/AbsListView(29735): Get MotionRecognitionManager\n07-05 12:53:51.096 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:51.096 E/CourseListFragment(29735): ## onResume\n07-05 12:53:51.241 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:53.116 I/TeamListFragment(29735): ##### onCreateView\n07-05 12:53:53.121 E/TeamListFragment(29735): TrainingClassID = 1\n07-05 12:53:53.141 D/AbsListView(29735): Get MotionRecognitionManager\n07-05 12:53:53.141 V/Vibrator(29735): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 12:53:53.141 V/Vibrator(29735): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 12:53:53.171 E/TeamListFragment(29735): TeamList is fucked!\n07-05 12:53:53.171 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:53.176 W/TeamListFragment(29735): ## onResume\n07-05 12:53:53.201 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.466 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.466 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.466 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.466 W/ApplicationPackageManager(29735): getCSCPackageItemText()\n07-05 12:53:58.496 W/ActivityPageFragment(29735): ############################# onCreateView\n07-05 12:53:58.511 D/AbsListView(29735): Get MotionRecognitionManager\n07-05 12:53:58.536 W/ActivityPageFragment(29735): ############## setTrainingClassCourse\n07-05 12:53:58.536 W/ActivityPageFragment(29735): ############## setList\n07-05 12:53:58.541 I/ActivityListActivity(29735): *** onResume - doin nuthin'' \n07-05 12:53:58.541 E/ActivityPageFragment(29735): onResume in ActivityPageFragment\n07-05 12:53:58.541 D/AbsListView(29735): onVisibilityChanged() is called, visibility : 4\n07-05 12:53:58.541 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.546 D/AbsListView(29735): onVisibilityChanged() is called, visibility : 0\n07-05 12:53:58.546 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.561 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.756 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.761 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.826 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:58.846 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:59.406 W/MainPagerActivity(29735): onSaveInstanceState\n07-05 12:53:59.416 I/TraineeListFragment(29735): onSaveInstanceState\n07-05 12:53:59.416 W/TeamListFragment(29735): ## onSaveInstanceState\n07-05 12:53:59.421 I/CourseListFragment(29735): ##### onSaveInstanceState  fired ....\n07-05 12:53:59.421 D/AbsListView(29735): onVisibilityChanged() is called, visibility : 4\n07-05 12:53:59.421 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:59.421 D/AbsListView(29735): onVisibilityChanged() is called, visibility : 4\n07-05 12:53:59.421 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:53:59.421 D/AbsListView(29735): onVisibilityChanged() is called, visibility : 4\n07-05 12:53:59.421 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:54:02.251 I/REG     (29735): -- onPause ---\n07-05 12:54:02.276 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:54:02.276 W/ApplicationPackageManager(29735): getCSCPackageItemText()\n07-05 12:54:02.311 E/RatingFragment(29735): ############### onCreateView in RatingFragment\n07-05 12:54:02.356 D/CacheUtil(29735): ################ getting cached data ..................\n07-05 12:54:02.356 E/CacheUtil(29735): ########### doInBackground: getting cached data ....\n07-05 12:54:02.366 D/RatingFragment(29735): setting courseTraineeActivity. ...\n07-05 12:54:02.371 E/RatingFragment(29735): ############### resuming in RatingFragment\n07-05 12:54:02.376 W/CacheUtil(29735): $$$$$$$$$$$$ cached data retrieved\n07-05 12:54:03.086 D/ActivityPageFragment(29735): #onSaveInstanceState,  \n07-05 12:54:03.086 D/AbsListView(29735): onVisibilityChanged() is called, visibility : 4\n07-05 12:54:03.086 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:54:42.191 D/AbsListView(29735): Get MotionRecognitionManager\n07-05 12:54:42.211 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:54:42.266 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:54:42.276 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:54:42.276 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:54:42.321 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:54:44.226 D/AbsListView(29735): onDetachedFromWindow\n07-05 12:54:44.226 D/AbsListView(29735): unregisterIRListener() is called \n07-05 12:54:44.286 E/ViewRootImpl(29735): sendUserActionEvent() mView == null\n07-05 12:56:08.666 W/RatingFragment(29735): ###################...sending trainee rating .... \n07-05 12:56:08.666 D/AndroidRuntime(29735): Shutting down VM\n07-05 12:56:08.666 W/dalvikvm(29735): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 12:56:08.666 E/ACRA    (29735): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 12:56:08.671 D/ACRA    (29735): Using custom Report Fields\n07-05 12:56:08.681 I/ACRA    (29735): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 12:56:08.721 D/ACRA    (29735): Retrieving logcat output...\n'),
(18, 1, '2014-07-05 17:15:09', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmtrainee.TeamMemberActivity.onTeamMemberAdded(TeamMemberActivity.java:98)\n	at com.boha.cmtrainee.fragments.TeamMemberListFragment$4.onResponseReceived(TeamMemberListFragment.java:180)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:99)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:21)\n	at com.android.volley.ExecutorDelivery$ResponseDeliveryRunnable.run(ExecutorDelivery.java:99)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 17:13:56.856 W/TeamListFragment( 9498): ## onSaveInstanceState\n07-05 17:13:56.856 I/TraineeListFragment( 9498): onSaveInstanceState\n07-05 17:13:56.856 I/CourseListFragment( 9498): ##### onSaveInstanceState  fired ....\n07-05 17:13:56.861 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 4\n07-05 17:13:56.861 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:13:56.861 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 4\n07-05 17:13:56.861 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:13:56.861 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 4\n07-05 17:13:56.861 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:00.551 I/ActivityListActivity( 9498): onBackPressed, count = 0\n07-05 17:14:00.561 I/REG     ( 9498): -- onPause ---\n07-05 17:14:00.586 W/MainPagerActivity( 9498): --- *** onActivityResult resultCode = -1 requestCode = 1\n07-05 17:14:00.586 E/MainPagerActivity( 9498): onResume ...nuthin be done\n07-05 17:14:00.586 W/TeamListFragment( 9498): ## onResume\n07-05 17:14:00.586 D/TraineeListFragment( 9498): ---- onResume - nothing to be done\n07-05 17:14:00.586 E/CourseListFragment( 9498): ## onResume\n07-05 17:14:00.591 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 0\n07-05 17:14:00.591 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:00.591 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 0\n07-05 17:14:00.591 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:00.591 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 0\n07-05 17:14:00.591 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:00.631 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:00.631 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:00.636 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:00.636 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:00.756 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:01.156 D/AbsListView( 9498): onDetachedFromWindow\n07-05 17:14:01.156 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:04.046 I/TraineeListFragment( 9498): onSaveInstanceState\n07-05 17:14:04.056 D/AbsListView( 9498): onDetachedFromWindow\n07-05 17:14:04.056 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:04.056 E/TraineeProfileFragment( 9498): ## onCreateView \n07-05 17:14:04.176 E/BohaVolley( 9498): initializing Volley Networking ...\n07-05 17:14:04.196 I/BohaVolley( 9498): Yebo! Volley Networking has been initialized\n07-05 17:14:04.201 D/TraineeProfileFragment( 9498): *** attempting to set profile picture\n07-05 17:14:04.236 D/TraineeProfileFragment( 9498): setting provinceSpinner ...\n07-05 17:14:04.246 D/TraineeProfileFragment( 9498): loadForm - detected province, setting selection\n07-05 17:14:04.266 E/TraineeProfileFragment( 9498): ## onResume in TraineeProfileFragment\n07-05 17:14:04.366 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:04.391 D/TraineeProfileFragment( 9498): setting citySpinner ...-\n07-05 17:14:04.391 D/TraineeProfileFragment( 9498): prov cities: 28\n07-05 17:14:04.391 D/TraineeProfileFragment( 9498): Trainee city found: Broederstroom index: 6\n07-05 17:14:16.181 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:16.181 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:16.191 W/ApplicationPackageManager( 9498): getCSCPackageItemText()\n07-05 17:14:16.221 I/TeamMemberListFragment( 9498): #### onCreateView\n07-05 17:14:16.246 D/AbsListView( 9498): Get MotionRecognitionManager\n07-05 17:14:16.296 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 4\n07-05 17:14:16.296 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:16.301 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 0\n07-05 17:14:16.301 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:16.316 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:16.371 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:16.416 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:16.446 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:16.956 W/MainPagerActivity( 9498): onSaveInstanceState\n07-05 17:14:16.956 W/TeamListFragment( 9498): ## onSaveInstanceState\n07-05 17:14:16.956 I/TraineeProfileFragment( 9498): ##### onSaveInstanceState  fired ....TraineeProfileFragment\n07-05 17:14:16.956 I/CourseListFragment( 9498): ##### onSaveInstanceState  fired ....\n07-05 17:14:16.961 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 4\n07-05 17:14:16.961 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:16.961 D/AbsListView( 9498): onVisibilityChanged() is called, visibility : 4\n07-05 17:14:16.961 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:26.111 D/AbsListView( 9498): Get MotionRecognitionManager\n07-05 17:14:26.126 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:26.176 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:26.181 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:26.186 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:26.221 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:14:26.236 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:15:01.356 D/AbsListView( 9498): onDetachedFromWindow\n07-05 17:15:01.356 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:15:01.401 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:15:01.406 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:15:01.411 E/ViewRootImpl( 9498): sendUserActionEvent() mView == null\n07-05 17:15:01.426 D/AbsListView( 9498): unregisterIRListener() is called \n07-05 17:15:09.641 I/WebCheck( 9498): ###### WIFI AVAILABLE on check\n07-05 17:15:09.641 I/WebCheck( 9498): ###### WIFI CONNECTED on check\n07-05 17:15:09.641 I/WebCheck( 9498): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 17:15:09.641 E/WebCheck( 9498): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 17:15:09.641 D/WebCheck( 9498): ###### Network check completed in 2 ms\n07-05 17:15:09.706 I/BaseVolley( 9498): ...sending remote request: .......>\n07-05 17:15:09.706 I/BaseVolley( 9498): http://192.168.1.111:8050/cm/team?JSON={"teamMember":{"traineeID":115,"teamID":1,"dateRegistered":0},"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":111,"returnEquipment":false}\n07-05 17:15:09.706 I/BohaRequest( 9498): ...Cloud Server communication started ...\n07-05 17:15:09.706 D/ProgressBar( 9498): updateDrawableBounds: left = 0\n07-05 17:15:09.706 D/ProgressBar( 9498): updateDrawableBounds: top = 0\n07-05 17:15:09.706 D/ProgressBar( 9498): updateDrawableBounds: right = 48\n07-05 17:15:09.706 D/ProgressBar( 9498): updateDrawableBounds: bottom = 48\n07-05 17:15:10.031 D/BohaRequest( 9498): parsing response, elapsed since start: 0.328 seconds\n07-05 17:15:10.036 I/BohaRequest( 9498): response string length returned: 347\n07-05 17:15:10.261 I/BohaRequest( 9498): ---- Comms elapsed time: 0.558 seconds\n07-05 17:15:10.261 E/BaseVolley( 9498): Yup! ...response object received, status code: 0\n07-05 17:15:10.271 I/TeamMemberListFragment( 9498): tell teamMemberAddedListener, member just added\n07-05 17:15:10.271 D/AndroidRuntime( 9498): Shutting down VM\n07-05 17:15:10.271 W/dalvikvm( 9498): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 17:15:10.271 E/ACRA    ( 9498): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 17:15:10.276 D/ACRA    ( 9498): Using custom Report Fields\n07-05 17:15:10.281 I/ACRA    ( 9498): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 17:15:10.311 D/ACRA    ( 9498): Retrieving logcat output...\n'),
(19, 1, '2014-07-05 17:18:48', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmtrainee.fragments.TraineeListFragment.onCreateView(TraineeListFragment.java:86)\n	at android.support.v4.app.Fragment.performCreateView(Fragment.java:1478)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:927)\n	at android.support.v4.app.FragmentManagerImpl.moveToState(FragmentManager.java:1104)\n	at android.support.v4.app.BackStackRecord.run(BackStackRecord.java:682)\n	at android.support.v4.app.FragmentManagerImpl.execPendingActions(FragmentManager.java:1460)\n	at android.support.v4.app.FragmentManagerImpl.executePendingTransactions(FragmentManager.java:472)\n	at android.support.v4.app.FragmentStatePagerAdapter.finishUpdate(FragmentStatePagerAdapter.java:163)\n	at android.support.v4.view.ViewPager.populate(ViewPager.java:1068)\n	at android.support.v4.view.ViewPager.populate(ViewPager.java:914)\n	at android.support.v4.view.ViewPager$3.run(ViewPager.java:244)\n	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:803)\n	at android.view.Choreographer.doCallbacks(Choreographer.java:603)\n	at android.view.Choreographer.doFrame(Choreographer.java:572)\n	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:789)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 17:15:10.416 I/dalvikvm( 9498): Jit: resizing JitTable from 4096 to 8192\n07-05 17:15:10.651 I/System.out( 9498): Thread-11256 calls detatch()\n07-05 17:15:10.651 D/ACRA    ( 9498): #checkAndSendReports - finish\n07-05 17:15:10.661 D/ACRA    ( 9498): Wait for Toast + worker ended. Kill Application ? true\n--------- beginning of /dev/log/system\n07-05 17:15:10.661 E/AndroidRuntime( 9498): FATAL EXCEPTION: main\n07-05 17:15:10.661 E/AndroidRuntime( 9498): Process: com.boha.cmtrainee, PID: 9498\n07-05 17:15:10.661 E/AndroidRuntime( 9498): java.lang.NullPointerException\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at com.boha.cmtrainee.TeamMemberActivity.onTeamMemberAdded(TeamMemberActivity.java:98)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at com.boha.cmtrainee.fragments.TeamMemberListFragment$4.onResponseReceived(TeamMemberListFragment.java:180)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:99)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:91)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:91)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:21)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at com.android.volley.ExecutorDelivery$ResponseDeliveryRunnable.run(ExecutorDelivery.java:99)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at android.os.Handler.handleCallback(Handler.java:733)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at android.os.Handler.dispatchMessage(Handler.java:95)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at android.os.Looper.loop(Looper.java:157)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at android.app.ActivityThread.main(ActivityThread.java:5356)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at java.lang.reflect.Method.invokeNative(Native Method)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at java.lang.reflect.Method.invoke(Method.java:515)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n07-05 17:15:10.661 E/AndroidRuntime( 9498): 	at dalvik.system.NativeStart.main(Native Method)\n07-05 17:16:38.096 I/Process ( 9498): Sending signal. PID: 9498 SIG: 9\n07-05 17:16:38.156 D/dalvikvm(10258): Late-enabling CheckJNI\n07-05 17:16:38.271 D/CMApp   (10258): ############################ onCreate CMApp has started ---------------->\n07-05 17:16:38.276 D/ACRA    (10258): ACRA is enabled for com.boha.cmtrainee, intializing...\n07-05 17:16:38.296 D/ACRA    (10258): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 17:16:38.296 E/CMApp   (10258): ###### ACRA Crash Reporting has been initiated\n07-05 17:16:38.296 E/CMApp   (10258): initializing Volley Networking ...\n07-05 17:16:38.306 I/CMApp   (10258): ********** Yebo! Volley Networking has been initialized, cache size: 16384 KB\n07-05 17:16:38.321 W/ApplicationPackageManager(10258): getCSCPackageItemText()\n07-05 17:16:38.431 E/MainPagerActivity(10258): ---- onCreate\n07-05 17:16:38.541 I/MainPagerActivity(10258): restored instance state, fragments to be set\n07-05 17:16:38.541 I/MainPagerActivity(10258): ############ --building first 3 pages\n07-05 17:16:38.546 E/BohaVolley(10258): initializing Volley Networking ...\n07-05 17:16:38.551 I/BohaVolley(10258): Yebo! Volley Networking has been initialized\n07-05 17:16:38.551 I/TeamListFragment(10258): ##### onCreateView\n07-05 17:16:38.586 E/TeamListFragment(10258): TrainingClassID = 1\n07-05 17:16:38.616 D/AbsListView(10258): Get MotionRecognitionManager\n07-05 17:16:38.811 D/dalvikvm(10258): GC_FOR_ALLOC freed 2173K, 20% free 17656K/21808K, paused 34ms, total 35ms\n07-05 17:16:38.831 E/TraineeProfileFragment(10258): ## onCreateView \n07-05 17:16:38.881 D/dalvikvm(10258): GC_FOR_ALLOC freed 269K, 20% free 17656K/21808K, paused 24ms, total 24ms\n07-05 17:16:38.926 I/dalvikvm-heap(10258): Grow heap (frag case) to 29.720MB for 11059216-byte allocation\n07-05 17:16:38.941 D/dalvikvm(10258): GC_FOR_ALLOC freed <1K, 13% free 28456K/32612K, paused 16ms, total 16ms\n07-05 17:16:38.971 E/BohaVolley(10258): initializing Volley Networking ...\n07-05 17:16:38.971 I/BohaVolley(10258): Yebo! Volley Networking has been initialized\n07-05 17:16:38.976 D/TraineeProfileFragment(10258): *** attempting to set profile picture\n07-05 17:16:39.021 D/TraineeProfileFragment(10258): setting provinceSpinner ...\n07-05 17:16:39.026 D/TraineeProfileFragment(10258): loadForm - detected province, setting selection\n07-05 17:16:39.041 D/AbsListView(10258): Get MotionRecognitionManager\n07-05 17:16:39.046 I/CourseListFragment(10258): saved is not null\n07-05 17:16:39.076 E/MainPagerActivity(10258): onResume ...nuthin be done\n07-05 17:16:39.076 W/TeamListFragment(10258): ## onResume\n07-05 17:16:39.076 E/TraineeProfileFragment(10258): ## onResume in TraineeProfileFragment\n07-05 17:16:39.076 E/CourseListFragment(10258): ## onResume\n07-05 17:16:39.076 D/AbsListView(10258): onVisibilityChanged() is called, visibility : 4\n07-05 17:16:39.076 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.076 D/AbsListView(10258): onVisibilityChanged() is called, visibility : 4\n07-05 17:16:39.076 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.091 D/AbsListView(10258): onVisibilityChanged() is called, visibility : 0\n07-05 17:16:39.091 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.091 D/AbsListView(10258): onVisibilityChanged() is called, visibility : 0\n07-05 17:16:39.091 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.116 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.121 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.266 D/OpenGLRenderer(10258): Enabling debug mode 0\n07-05 17:16:39.306 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.366 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.416 D/TraineeProfileFragment(10258): setting citySpinner ...-\n07-05 17:16:39.416 D/TraineeProfileFragment(10258): prov cities: 28\n07-05 17:16:39.416 D/TraineeProfileFragment(10258): Trainee city found: Broederstroom index: 6\n07-05 17:16:39.436 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.436 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.496 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:16:39.501 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:17:40.181 D/dalvikvm(10258): Debugger has detached; object registry had 1 entries\n07-05 17:18:36.351 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:18:36.401 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:18:39.341 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:18:39.421 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:18:44.841 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:18:44.851 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:18:44.886 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:18:44.891 D/AbsListView(10258): unregisterIRListener() is called \n07-05 17:18:44.971 E/MainPagerActivity(10258): onResume ...nuthin be done\n07-05 17:18:44.981 W/TeamListFragment(10258): ## onResume\n07-05 17:18:44.981 E/TraineeProfileFragment(10258): ## onResume in TraineeProfileFragment\n07-05 17:18:44.981 E/CourseListFragment(10258): ## onResume\n07-05 17:18:49.106 I/TraineeProfileFragment(10258): ##### onSaveInstanceState  fired ....TraineeProfileFragment\n07-05 17:18:49.191 D/TraineeListFragment(10258): ---- onAttach\n07-05 17:18:49.191 I/TraineeListFragment(10258): -- onCreateView ............\n07-05 17:18:49.211 D/AbsListView(10258): Get MotionRecognitionManager\n07-05 17:18:49.221 D/AndroidRuntime(10258): Shutting down VM\n07-05 17:18:49.221 W/dalvikvm(10258): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 17:18:49.221 E/ACRA    (10258): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 17:18:49.226 D/ACRA    (10258): Using custom Report Fields\n07-05 17:18:49.246 I/ACRA    (10258): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 17:18:49.296 D/ACRA    (10258): Retrieving logcat output...\n'),
(20, 1, '2014-07-05 17:40:44', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmtrainee.TeamMemberActivity.onTeamMemberAdded(TeamMemberActivity.java:98)\n	at com.boha.cmtrainee.fragments.TeamMemberListFragment$4.onResponseReceived(TeamMemberListFragment.java:180)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:99)\n	at com.boha.coursemaker.base.BaseVolley$1.onResponse(BaseVolley.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:91)\n	at com.boha.volley.toolbox.BohaRequest.deliverResponse(BohaRequest.java:21)\n	at com.android.volley.ExecutorDelivery$ResponseDeliveryRunnable.run(ExecutorDelivery.java:99)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 17:38:42.126 I/TeamListFragment(12730): ##### onCreateView\n07-05 17:38:42.126 E/TeamListFragment(12730): TrainingClassID = 1\n07-05 17:38:42.141 D/AbsListView(12730): Get MotionRecognitionManager\n07-05 17:38:42.141 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:38:42.141 W/TeamListFragment(12730): ## onResume\n07-05 17:38:42.191 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:38:43.356 I/TraineeListFragment(12730): onSaveInstanceState\n07-05 17:38:43.361 D/AbsListView(12730): onDetachedFromWindow\n07-05 17:38:43.361 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:38:43.361 E/TraineeProfileFragment(12730): ## onCreateView \n07-05 17:38:43.446 E/BohaVolley(12730): initializing Volley Networking ...\n07-05 17:38:43.456 I/BohaVolley(12730): Yebo! Volley Networking has been initialized\n07-05 17:38:43.461 D/TraineeProfileFragment(12730): *** attempting to set profile picture\n07-05 17:38:43.471 D/TraineeProfileFragment(12730): setting provinceSpinner ...\n07-05 17:38:43.481 D/TraineeProfileFragment(12730): loadForm - detected province, setting selection\n07-05 17:38:43.511 E/TraineeProfileFragment(12730): ## onResume in TraineeProfileFragment\n07-05 17:38:43.646 D/dalvikvm(12730): GC_FOR_ALLOC freed 6241K, 30% free 39253K/55932K, paused 77ms, total 78ms\n07-05 17:38:43.681 D/TraineeProfileFragment(12730): setting citySpinner ...-\n07-05 17:38:43.681 D/TraineeProfileFragment(12730): prov cities: 28\n07-05 17:38:43.681 D/TraineeProfileFragment(12730): Trainee city found: Broederstroom index: 6\n07-05 17:38:54.106 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:38:54.106 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:39:31.826 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:39:31.826 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:39:33.481 I/WebCheck(12730): ###### WIFI AVAILABLE on check\n07-05 17:39:33.481 I/WebCheck(12730): ###### WIFI CONNECTED on check\n07-05 17:39:33.481 I/WebCheck(12730): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 17:39:33.481 E/WebCheck(12730): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 17:39:33.481 D/WebCheck(12730): ###### Network check completed in 1 ms\n07-05 17:39:33.541 I/BaseVolley(12730): ...sending remote request: .......>\n07-05 17:39:33.541 I/BaseVolley(12730): http://192.168.1.111:8050/cm/team?JSON={"team":{"teamMemberList":[{"traineeID":117,"dateRegistered":0}],"teamName":"Jabula Coders","trainingClassID":1,"dateRegistered":0},"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":110,"returnEquipment":false}\n07-05 17:39:33.541 I/BohaRequest(12730): ...Cloud Server communication started ...\n07-05 17:39:33.541 D/ProgressBar(12730): updateDrawableBounds: left = 0\n07-05 17:39:33.541 D/ProgressBar(12730): updateDrawableBounds: top = 0\n07-05 17:39:33.541 D/ProgressBar(12730): updateDrawableBounds: right = 48\n07-05 17:39:33.541 D/ProgressBar(12730): updateDrawableBounds: bottom = 48\n07-05 17:39:33.751 D/BohaRequest(12730): parsing response, elapsed since start: 0.209 seconds\n07-05 17:39:33.751 I/BohaRequest(12730): response string length returned: 307\n07-05 17:39:33.846 I/BohaRequest(12730): ---- Comms elapsed time: 0.306 seconds\n07-05 17:39:33.846 E/BaseVolley(12730): Yup! ...response object received, status code: 0\n07-05 17:39:33.901 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:19.456 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:19.461 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:19.466 W/ApplicationPackageManager(12730): getCSCPackageItemText()\n07-05 17:40:19.501 I/TeamMemberListFragment(12730): #### onCreateView\n07-05 17:40:19.521 D/AbsListView(12730): Get MotionRecognitionManager\n07-05 17:40:19.576 D/AbsListView(12730): onVisibilityChanged() is called, visibility : 4\n07-05 17:40:19.576 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:19.581 D/AbsListView(12730): onVisibilityChanged() is called, visibility : 0\n07-05 17:40:19.581 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:19.586 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:19.666 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:19.681 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:19.721 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:19.746 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:20.006 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:20.171 W/MainPagerActivity(12730): onSaveInstanceState\n07-05 17:40:20.171 I/TraineeProfileFragment(12730): ##### onSaveInstanceState  fired ....TraineeProfileFragment\n07-05 17:40:20.171 W/TeamListFragment(12730): ## onSaveInstanceState\n07-05 17:40:20.171 I/CourseListFragment(12730): ##### onSaveInstanceState  fired ....\n07-05 17:40:20.176 D/AbsListView(12730): onVisibilityChanged() is called, visibility : 4\n07-05 17:40:20.176 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:20.176 D/AbsListView(12730): onVisibilityChanged() is called, visibility : 4\n07-05 17:40:20.176 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:29.961 D/AbsListView(12730): Get MotionRecognitionManager\n07-05 17:40:29.981 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:30.066 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:30.066 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:30.066 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:30.116 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:30.131 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:35.956 D/AbsListView(12730): onDetachedFromWindow\n07-05 17:40:35.956 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:36.011 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:36.021 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:36.031 E/ViewRootImpl(12730): sendUserActionEvent() mView == null\n07-05 17:40:36.051 D/AbsListView(12730): unregisterIRListener() is called \n07-05 17:40:44.611 I/WebCheck(12730): ###### WIFI AVAILABLE on check\n07-05 17:40:44.611 I/WebCheck(12730): ###### WIFI CONNECTED on check\n07-05 17:40:44.611 I/WebCheck(12730): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 17:40:44.611 E/WebCheck(12730): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 17:40:44.611 D/WebCheck(12730): ###### Network check completed in 2 ms\n07-05 17:40:44.671 I/BaseVolley(12730): ...sending remote request: .......>\n07-05 17:40:44.671 I/BaseVolley(12730): http://192.168.1.111:8050/cm/team?JSON={"teamMember":{"traineeID":115,"teamID":2,"dateRegistered":0},"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":111,"returnEquipment":false}\n07-05 17:40:44.671 I/BohaRequest(12730): ...Cloud Server communication started ...\n07-05 17:40:44.671 D/ProgressBar(12730): updateDrawableBounds: left = 0\n07-05 17:40:44.671 D/ProgressBar(12730): updateDrawableBounds: top = 0\n07-05 17:40:44.671 D/ProgressBar(12730): updateDrawableBounds: right = 48\n07-05 17:40:44.671 D/ProgressBar(12730): updateDrawableBounds: bottom = 48\n07-05 17:40:44.866 D/BohaRequest(12730): parsing response, elapsed since start: 0.192 seconds\n07-05 17:40:44.866 I/BohaRequest(12730): response string length returned: 398\n07-05 17:40:44.981 I/BohaRequest(12730): ---- Comms elapsed time: 0.311 seconds\n07-05 17:40:44.981 E/BaseVolley(12730): Yup! ...response object received, status code: 0\n07-05 17:40:44.991 I/TeamMemberListFragment(12730): tell teamMemberAddedListener, member just added\n07-05 17:40:44.991 D/AndroidRuntime(12730): Shutting down VM\n07-05 17:40:44.991 W/dalvikvm(12730): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 17:40:44.991 E/ACRA    (12730): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 17:40:44.991 D/ACRA    (12730): Using custom Report Fields\n07-05 17:40:44.996 I/ACRA    (12730): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 17:40:45.046 D/ACRA    (12730): Retrieving logcat output...\n');
INSERT INTO `errorStoreAndroid` (`errorStoreAndroidID`, `companyID`, `errorDate`, `packageName`, `appVersionName`, `appVersionCode`, `brand`, `phoneModel`, `androidVersion`, `stackTrace`, `logCat`) VALUES
(21, 1, '2014-07-05 20:34:21', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmlibrary.HelpRequestDialog.sendHelpRequest(HelpRequestDialog.java:69)\n	at com.boha.cmlibrary.HelpRequestDialog.access$000(HelpRequestDialog.java:24)\n	at com.boha.cmlibrary.HelpRequestDialog$1.onClick(HelpRequestDialog.java:46)\n	at android.view.View.performClick(View.java:4633)\n	at android.view.View$PerformClick.run(View.java:19330)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 20:29:54.646 I/WebCheck( 3105): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 20:29:54.646 E/WebCheck( 3105): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 20:29:54.646 D/WebCheck( 3105): ###### Network check completed in 1 ms\n07-05 20:29:54.696 I/BaseVolley( 3105): ...sending remote request: .......>\n07-05 20:29:54.696 I/BaseVolley( 3105): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 20:29:54.696 I/BohaRequest( 3105): ...Cloud Server communication started ...\n07-05 20:29:54.716 W/CacheUtil( 3105): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/ratings.json - length: 588 items: 7\n07-05 20:29:54.726 W/CacheUtil( 3105): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/helptypes.json - length: 760 items: 10\n07-05 20:29:54.841 D/BohaRequest( 3105): parsing response, elapsed since start: 0.146 seconds\n07-05 20:29:54.846 I/BohaRequest( 3105): response string length returned: 3064\n07-05 20:29:54.951 I/BohaRequest( 3105): ---- Comms elapsed time: 0.257 seconds\n07-05 20:29:54.951 E/BaseVolley( 3105): Yup! ...response object received, status code: 0\n07-05 20:30:09.686 D/AbsListView( 3105): Get MotionRecognitionManager\n07-05 20:30:09.696 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:09.696 E/CourseListFragment( 3105): ## onResume\n07-05 20:30:09.786 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:13.951 I/TeamListFragment( 3105): ##### onCreateView\n07-05 20:30:13.951 E/TeamListFragment( 3105): TrainingClassID = 1\n07-05 20:30:13.971 D/AbsListView( 3105): Get MotionRecognitionManager\n07-05 20:30:13.976 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:13.976 W/TeamListFragment( 3105): ## onResume\n07-05 20:30:14.056 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.116 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.116 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.121 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.126 W/ApplicationPackageManager( 3105): getCSCPackageItemText()\n07-05 20:30:22.166 W/ActivityPageFragment( 3105): ############################# onCreateView\n07-05 20:30:22.191 D/AbsListView( 3105): Get MotionRecognitionManager\n07-05 20:30:22.221 W/ActivityPageFragment( 3105): ############## setTrainingClassCourse\n07-05 20:30:22.221 W/ActivityPageFragment( 3105): ############## setList\n07-05 20:30:22.226 I/ActivityListActivity( 3105): *** onResume - doin nuthin'' \n07-05 20:30:22.226 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 4\n07-05 20:30:22.226 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.231 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 0\n07-05 20:30:22.231 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.251 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.436 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.441 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.571 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.596 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.766 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:23.036 W/MainPagerActivity( 3105): onSaveInstanceState\n07-05 20:30:23.041 W/TeamListFragment( 3105): ## onSaveInstanceState\n07-05 20:30:23.041 I/TraineeListFragment( 3105): onSaveInstanceState\n07-05 20:30:23.041 I/CourseListFragment( 3105): ##### onSaveInstanceState  fired ....\n07-05 20:30:23.046 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 4\n07-05 20:30:23.046 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:23.051 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 4\n07-05 20:30:23.051 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:23.051 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 4\n07-05 20:30:23.051 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:32.206 I/HelpRequestDialog( 3105): onCreateView of Dialog\n07-05 20:30:32.221 D/CacheUtil( 3105): ################ getting cached data ..................\n07-05 20:30:32.221 E/CacheUtil( 3105): ########### doInBackground: getting cached data ....\n07-05 20:30:32.291 W/CacheUtil( 3105): $$$$$$$$$$$$ cached data retrieved\n07-05 20:30:32.471 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:47.086 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:47.091 E/ViewRootImpl( 3105): sendUserActionEvent() mView == null\n07-05 20:30:51.616 I/HelpRequestDialog( 3105): onCreateView of Dialog\n07-05 20:30:51.626 D/CacheUtil( 3105): ################ getting cached data ..................\n07-05 20:30:51.626 E/CacheUtil( 3105): ########### doInBackground: getting cached data ....\n07-05 20:30:51.681 W/CacheUtil( 3105): $$$$$$$$$$$$ cached data retrieved\n07-05 20:30:51.816 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.636 D/AbsListView( 3105): Get MotionRecognitionManager\n07-05 20:31:00.646 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.696 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.701 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.701 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.751 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:20.556 D/AbsListView( 3105): onDetachedFromWindow\n07-05 20:31:20.556 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:20.581 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:31:20.601 E/ViewRootImpl( 3105): sendUserActionEvent() mView == null\n07-05 20:33:33.956 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:33.956 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:33.956 D/AbsListView( 3105): unregisterIRListener() is called \n--------- beginning of /dev/log/system\n07-05 20:33:33.956 W/ViewRootImpl( 3105): Dropping event due to root view being removed: MotionEvent { action=ACTION_MOVE, id[0]=0, x[0]=867.0, y[0]=-89.0, toolType[0]=TOOL_TYPE_FINGER, buttonState=0, metaState=0, flags=0x0, edgeFlags=0x0, pointerCount=1, historySize=1, eventTime=172926388, downTime=172926365, deviceId=2, source=0x1002 }\n07-05 20:33:33.966 E/ViewRootImpl( 3105): sendUserActionEvent() mView == null\n07-05 20:33:37.356 I/HelpRequestDialog( 3105): onCreateView of Dialog\n07-05 20:33:37.366 D/CacheUtil( 3105): ################ getting cached data ..................\n07-05 20:33:37.366 E/CacheUtil( 3105): ########### doInBackground: getting cached data ....\n07-05 20:33:37.421 W/CacheUtil( 3105): $$$$$$$$$$$$ cached data retrieved\n07-05 20:33:37.566 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:33:38.821 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:38.821 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:38.821 W/ViewRootImpl( 3105): Dropping event due to root view being removed: MotionEvent { action=ACTION_MOVE, id[0]=0, x[0]=1002.0, y[0]=-137.0, toolType[0]=TOOL_TYPE_FINGER, buttonState=0, metaState=0, flags=0x0, edgeFlags=0x0, pointerCount=1, historySize=1, eventTime=172931263, downTime=172931239, deviceId=2, source=0x1002 }\n07-05 20:33:38.826 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:33:38.826 E/ViewRootImpl( 3105): sendUserActionEvent() mView == null\n07-05 20:33:43.696 I/HelpRequestDialog( 3105): onCreateView of Dialog\n07-05 20:33:43.706 D/CacheUtil( 3105): ################ getting cached data ..................\n07-05 20:33:43.706 E/CacheUtil( 3105): ########### doInBackground: getting cached data ....\n07-05 20:33:43.756 W/CacheUtil( 3105): $$$$$$$$$$$$ cached data retrieved\n07-05 20:33:43.866 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:34:21.346 D/AndroidRuntime( 3105): Shutting down VM\n07-05 20:34:21.346 W/dalvikvm( 3105): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 20:34:21.346 E/ACRA    ( 3105): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 20:34:21.346 D/ACRA    ( 3105): Using custom Report Fields\n07-05 20:34:21.351 I/ACRA    ( 3105): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 20:34:21.381 D/ACRA    ( 3105): Retrieving logcat output...\n'),
(22, 1, '2014-07-05 20:34:24', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmlibrary.HelpRequestDialog.sendHelpRequest(HelpRequestDialog.java:69)\n	at com.boha.cmlibrary.HelpRequestDialog.access$000(HelpRequestDialog.java:24)\n	at com.boha.cmlibrary.HelpRequestDialog$1.onClick(HelpRequestDialog.java:46)\n	at android.view.View.performClick(View.java:4633)\n	at android.view.View$PerformClick.run(View.java:19330)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 20:29:54.646 I/WebCheck( 3105): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 20:29:54.646 E/WebCheck( 3105): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 20:29:54.646 D/WebCheck( 3105): ###### Network check completed in 1 ms\n07-05 20:29:54.696 I/BaseVolley( 3105): ...sending remote request: .......>\n07-05 20:29:54.696 I/BaseVolley( 3105): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 20:29:54.696 I/BohaRequest( 3105): ...Cloud Server communication started ...\n07-05 20:29:54.716 W/CacheUtil( 3105): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/ratings.json - length: 588 items: 7\n07-05 20:29:54.726 W/CacheUtil( 3105): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/helptypes.json - length: 760 items: 10\n07-05 20:29:54.841 D/BohaRequest( 3105): parsing response, elapsed since start: 0.146 seconds\n07-05 20:29:54.846 I/BohaRequest( 3105): response string length returned: 3064\n07-05 20:29:54.951 I/BohaRequest( 3105): ---- Comms elapsed time: 0.257 seconds\n07-05 20:29:54.951 E/BaseVolley( 3105): Yup! ...response object received, status code: 0\n07-05 20:30:09.686 D/AbsListView( 3105): Get MotionRecognitionManager\n07-05 20:30:09.696 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:09.696 E/CourseListFragment( 3105): ## onResume\n07-05 20:30:09.786 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:13.951 I/TeamListFragment( 3105): ##### onCreateView\n07-05 20:30:13.951 E/TeamListFragment( 3105): TrainingClassID = 1\n07-05 20:30:13.971 D/AbsListView( 3105): Get MotionRecognitionManager\n07-05 20:30:13.976 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:13.976 W/TeamListFragment( 3105): ## onResume\n07-05 20:30:14.056 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.116 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.116 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.121 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.126 W/ApplicationPackageManager( 3105): getCSCPackageItemText()\n07-05 20:30:22.166 W/ActivityPageFragment( 3105): ############################# onCreateView\n07-05 20:30:22.191 D/AbsListView( 3105): Get MotionRecognitionManager\n07-05 20:30:22.221 W/ActivityPageFragment( 3105): ############## setTrainingClassCourse\n07-05 20:30:22.221 W/ActivityPageFragment( 3105): ############## setList\n07-05 20:30:22.226 I/ActivityListActivity( 3105): *** onResume - doin nuthin'' \n07-05 20:30:22.226 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 4\n07-05 20:30:22.226 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.231 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 0\n07-05 20:30:22.231 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.251 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.436 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.441 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.571 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.596 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:22.766 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:23.036 W/MainPagerActivity( 3105): onSaveInstanceState\n07-05 20:30:23.041 W/TeamListFragment( 3105): ## onSaveInstanceState\n07-05 20:30:23.041 I/TraineeListFragment( 3105): onSaveInstanceState\n07-05 20:30:23.041 I/CourseListFragment( 3105): ##### onSaveInstanceState  fired ....\n07-05 20:30:23.046 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 4\n07-05 20:30:23.046 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:23.051 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 4\n07-05 20:30:23.051 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:23.051 D/AbsListView( 3105): onVisibilityChanged() is called, visibility : 4\n07-05 20:30:23.051 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:32.206 I/HelpRequestDialog( 3105): onCreateView of Dialog\n07-05 20:30:32.221 D/CacheUtil( 3105): ################ getting cached data ..................\n07-05 20:30:32.221 E/CacheUtil( 3105): ########### doInBackground: getting cached data ....\n07-05 20:30:32.291 W/CacheUtil( 3105): $$$$$$$$$$$$ cached data retrieved\n07-05 20:30:32.471 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:47.086 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:30:47.091 E/ViewRootImpl( 3105): sendUserActionEvent() mView == null\n07-05 20:30:51.616 I/HelpRequestDialog( 3105): onCreateView of Dialog\n07-05 20:30:51.626 D/CacheUtil( 3105): ################ getting cached data ..................\n07-05 20:30:51.626 E/CacheUtil( 3105): ########### doInBackground: getting cached data ....\n07-05 20:30:51.681 W/CacheUtil( 3105): $$$$$$$$$$$$ cached data retrieved\n07-05 20:30:51.816 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.636 D/AbsListView( 3105): Get MotionRecognitionManager\n07-05 20:31:00.646 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.696 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.701 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.701 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:00.751 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:20.556 D/AbsListView( 3105): onDetachedFromWindow\n07-05 20:31:20.556 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:31:20.581 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:31:20.601 E/ViewRootImpl( 3105): sendUserActionEvent() mView == null\n07-05 20:33:33.956 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:33.956 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:33.956 D/AbsListView( 3105): unregisterIRListener() is called \n--------- beginning of /dev/log/system\n07-05 20:33:33.956 W/ViewRootImpl( 3105): Dropping event due to root view being removed: MotionEvent { action=ACTION_MOVE, id[0]=0, x[0]=867.0, y[0]=-89.0, toolType[0]=TOOL_TYPE_FINGER, buttonState=0, metaState=0, flags=0x0, edgeFlags=0x0, pointerCount=1, historySize=1, eventTime=172926388, downTime=172926365, deviceId=2, source=0x1002 }\n07-05 20:33:33.966 E/ViewRootImpl( 3105): sendUserActionEvent() mView == null\n07-05 20:33:37.356 I/HelpRequestDialog( 3105): onCreateView of Dialog\n07-05 20:33:37.366 D/CacheUtil( 3105): ################ getting cached data ..................\n07-05 20:33:37.366 E/CacheUtil( 3105): ########### doInBackground: getting cached data ....\n07-05 20:33:37.421 W/CacheUtil( 3105): $$$$$$$$$$$$ cached data retrieved\n07-05 20:33:37.566 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:33:38.821 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:38.821 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:38.821 W/ViewRootImpl( 3105): Dropping event due to root view being removed: MotionEvent { action=ACTION_MOVE, id[0]=0, x[0]=1002.0, y[0]=-137.0, toolType[0]=TOOL_TYPE_FINGER, buttonState=0, metaState=0, flags=0x0, edgeFlags=0x0, pointerCount=1, historySize=1, eventTime=172931263, downTime=172931239, deviceId=2, source=0x1002 }\n07-05 20:33:38.826 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:33:38.826 E/ViewRootImpl( 3105): sendUserActionEvent() mView == null\n07-05 20:33:43.696 I/HelpRequestDialog( 3105): onCreateView of Dialog\n07-05 20:33:43.706 D/CacheUtil( 3105): ################ getting cached data ..................\n07-05 20:33:43.706 E/CacheUtil( 3105): ########### doInBackground: getting cached data ....\n07-05 20:33:43.756 W/CacheUtil( 3105): $$$$$$$$$$$$ cached data retrieved\n07-05 20:33:43.866 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:34:21.346 D/AndroidRuntime( 3105): Shutting down VM\n07-05 20:34:21.346 W/dalvikvm( 3105): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 20:34:21.346 E/ACRA    ( 3105): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 20:34:21.346 D/ACRA    ( 3105): Using custom Report Fields\n07-05 20:34:21.351 I/ACRA    ( 3105): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 20:34:21.381 D/ACRA    ( 3105): Retrieving logcat output...\n'),
(23, 1, '2014-07-05 20:35:17', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.android.volley.toolbox.NetworkImageView.loadImageIfNecessary(NetworkImageView.java:149)\n	at com.android.volley.toolbox.NetworkImageView.onLayout(NetworkImageView.java:198)\n	at android.view.View.layout(View.java:15655)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.ListView.setupChild(ListView.java:1895)\n	at android.widget.ListView.makeAndAddView(ListView.java:1806)\n	at android.widget.ListView.fillDown(ListView.java:697)\n	at android.widget.ListView.fillFromTop(ListView.java:763)\n	at android.widget.ListView.layoutChildren(ListView.java:1641)\n	at android.widget.AbsListView.onLayout(AbsListView.java:2533)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1677)\n	at android.widget.LinearLayout.layoutVertical(LinearLayout.java:1531)\n	at android.widget.LinearLayout.onLayout(LinearLayout.java:1440)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.support.v4.view.ViewPager.onLayout(ViewPager.java:1589)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1677)\n	at android.widget.LinearLayout.layoutVertical(LinearLayout.java:1531)\n	at android.widget.LinearLayout.onLayout(LinearLayout.java:1440)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at com.android.internal.widget.ActionBarOverlayLayout.onLayout(ActionBarOverlayLayout.java:438)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.view.ViewRootImpl.performLayout(ViewRootImpl.java:2284)\n	at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:2004)\n	at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1234)\n	at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6467)\n	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:803)\n	at android.view.Choreographer.doCallbacks(Choreographer.java:603)\n	at android.view.Choreographer.doFrame(Choreographer.java:573)\n	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:789)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 20:33:38.821 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:38.821 W/InputEventReceiver( 3105): Attempted to finish an input event but the input event receiver has already been disposed.\n07-05 20:33:38.821 W/ViewRootImpl( 3105): Dropping event due to root view being removed: MotionEvent { action=ACTION_MOVE, id[0]=0, x[0]=1002.0, y[0]=-137.0, toolType[0]=TOOL_TYPE_FINGER, buttonState=0, metaState=0, flags=0x0, edgeFlags=0x0, pointerCount=1, historySize=1, eventTime=172931263, downTime=172931239, deviceId=2, source=0x1002 }\n07-05 20:33:38.826 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:33:38.826 E/ViewRootImpl( 3105): sendUserActionEvent() mView == null\n07-05 20:33:43.696 I/HelpRequestDialog( 3105): onCreateView of Dialog\n07-05 20:33:43.706 D/CacheUtil( 3105): ################ getting cached data ..................\n07-05 20:33:43.706 E/CacheUtil( 3105): ########### doInBackground: getting cached data ....\n07-05 20:33:43.756 W/CacheUtil( 3105): $$$$$$$$$$$$ cached data retrieved\n07-05 20:33:43.866 D/AbsListView( 3105): unregisterIRListener() is called \n07-05 20:34:21.346 D/AndroidRuntime( 3105): Shutting down VM\n07-05 20:34:21.346 W/dalvikvm( 3105): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 20:34:21.346 E/ACRA    ( 3105): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 20:34:21.346 D/ACRA    ( 3105): Using custom Report Fields\n07-05 20:34:21.351 I/ACRA    ( 3105): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 20:34:21.381 D/ACRA    ( 3105): Retrieving logcat output...\n07-05 20:34:21.411 D/ACRA    ( 3105): Writing crash report file 1404585261000.stacktrace.\n07-05 20:34:21.421 D/ACRA    ( 3105): About to start ReportSenderWorker from #handleException\n07-05 20:34:21.421 D/ACRA    ( 3105): Mark all pending reports as approved.\n07-05 20:34:21.421 D/ACRA    ( 3105): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 20:34:21.421 D/ACRA    ( 3105): Waiting for Toast + worker...\n07-05 20:34:21.421 D/ACRA    ( 3105): #checkAndSendReports - start\n07-05 20:34:21.426 D/ACRA    ( 3105): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 20:34:21.426 I/ACRA    ( 3105): Sending file 1404585261000-approved.stacktrace\n07-05 20:34:21.441 D/ACRA    ( 3105): Connect to http://192.168.1.111:8050/cm/crash\n07-05 20:34:21.466 D/ACRA    ( 3105): Sending request to http://192.168.1.111:8050/cm/crash\n07-05 20:34:24.496 D/ACRA    ( 3105): SocketTimeOut - increasing time out to 6000 millis and trying again\n07-05 20:34:25.351 I/System.out( 3105): Thread-12489 calls detatch()\n07-05 20:34:25.356 D/ACRA    ( 3105): #checkAndSendReports - finish\n07-05 20:34:25.441 D/ACRA    ( 3105): Wait for Toast + worker ended. Kill Application ? true\n07-05 20:34:25.441 E/AndroidRuntime( 3105): FATAL EXCEPTION: main\n07-05 20:34:25.441 E/AndroidRuntime( 3105): Process: com.boha.cmtrainee, PID: 3105\n07-05 20:34:25.441 E/AndroidRuntime( 3105): java.lang.NullPointerException\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at com.boha.cmlibrary.HelpRequestDialog.sendHelpRequest(HelpRequestDialog.java:69)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at com.boha.cmlibrary.HelpRequestDialog.access$000(HelpRequestDialog.java:24)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at com.boha.cmlibrary.HelpRequestDialog$1.onClick(HelpRequestDialog.java:46)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at android.view.View.performClick(View.java:4633)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at android.view.View$PerformClick.run(View.java:19330)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at android.os.Handler.handleCallback(Handler.java:733)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at android.os.Handler.dispatchMessage(Handler.java:95)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at android.os.Looper.loop(Looper.java:157)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at android.app.ActivityThread.main(ActivityThread.java:5356)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at java.lang.reflect.Method.invokeNative(Native Method)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at java.lang.reflect.Method.invoke(Method.java:515)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n07-05 20:34:25.441 E/AndroidRuntime( 3105): 	at dalvik.system.NativeStart.main(Native Method)\n07-05 20:35:16.321 I/Process ( 3105): Sending signal. PID: 3105 SIG: 9\n07-05 20:35:16.391 D/dalvikvm( 4579): Late-enabling CheckJNI\n07-05 20:35:16.511 D/CMApp   ( 4579): ############################ onCreate CMApp has started ---------------->\n07-05 20:35:16.521 D/ACRA    ( 4579): ACRA is enabled for com.boha.cmtrainee, intializing...\n07-05 20:35:16.546 D/ACRA    ( 4579): Looking for error files in /data/data/com.boha.cmtrainee/files\n07-05 20:35:16.551 E/CMApp   ( 4579): ###### ACRA Crash Reporting has been initiated\n07-05 20:35:16.551 E/CMApp   ( 4579): initializing Volley Networking ...\n07-05 20:35:16.561 I/CMApp   ( 4579): ********** Yebo! Volley Networking has been initialized, cache size: 16384 KB\n07-05 20:35:16.576 W/ApplicationPackageManager( 4579): getCSCPackageItemText()\n07-05 20:35:16.676 D/TraineeListFragment( 4579): ---- onAttach\n07-05 20:35:16.726 E/MainPagerActivity( 4579): ---- onCreate\n07-05 20:35:16.836 I/MainPagerActivity( 4579): restored instance state, fragments to be set\n07-05 20:35:16.836 I/MainPagerActivity( 4579): ############ --building first 3 pages\n07-05 20:35:16.836 E/BohaVolley( 4579): initializing Volley Networking ...\n07-05 20:35:16.841 I/BohaVolley( 4579): Yebo! Volley Networking has been initialized\n07-05 20:35:16.846 I/TeamListFragment( 4579): ##### onCreateView\n07-05 20:35:16.886 E/TeamListFragment( 4579): TrainingClassID = 1\n07-05 20:35:16.941 D/AbsListView( 4579): Get MotionRecognitionManager\n07-05 20:35:16.996 D/dalvikvm( 4579): GC_FOR_ALLOC freed 2190K, 20% free 17629K/21800K, paused 31ms, total 31ms\n07-05 20:35:17.036 I/TraineeListFragment( 4579): -- onCreateView ............\n07-05 20:35:17.046 D/AbsListView( 4579): Get MotionRecognitionManager\n07-05 20:35:17.081 D/AbsListView( 4579): Get MotionRecognitionManager\n07-05 20:35:17.086 I/CourseListFragment( 4579): saved is not null\n07-05 20:35:17.106 E/MainPagerActivity( 4579): onResume ...nuthin be done\n07-05 20:35:17.106 W/TeamListFragment( 4579): ## onResume\n07-05 20:35:17.106 D/TraineeListFragment( 4579): ---- onResume - nothing to be done\n07-05 20:35:17.106 E/CourseListFragment( 4579): ## onResume\n07-05 20:35:17.106 D/AbsListView( 4579): onVisibilityChanged() is called, visibility : 4\n07-05 20:35:17.106 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.106 D/AbsListView( 4579): onVisibilityChanged() is called, visibility : 4\n07-05 20:35:17.106 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.106 D/AbsListView( 4579): onVisibilityChanged() is called, visibility : 4\n07-05 20:35:17.106 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.116 D/AbsListView( 4579): onVisibilityChanged() is called, visibility : 0\n07-05 20:35:17.116 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.116 D/AbsListView( 4579): onVisibilityChanged() is called, visibility : 0\n07-05 20:35:17.116 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.116 D/AbsListView( 4579): onVisibilityChanged() is called, visibility : 0\n07-05 20:35:17.116 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.131 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.131 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.131 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.261 D/OpenGLRenderer( 4579): Enabling debug mode 0\n07-05 20:35:17.331 D/AbsListView( 4579): unregisterIRListener() is called \n07-05 20:35:17.381 D/dalvikvm( 4579): GC_FOR_ALLOC freed 1185K, 18% free 17893K/21800K, paused 23ms, total 23ms\n07-05 20:35:17.406 I/dalvikvm-heap( 4579): Grow heap (frag case) to 29.951MB for 11059216-byte allocation\n07-05 20:35:17.426 D/dalvikvm( 4579): GC_FOR_ALLOC freed 2K, 13% free 28691K/32604K, paused 17ms, total 17ms\n07-05 20:35:17.441 D/AndroidRuntime( 4579): Shutting down VM\n07-05 20:35:17.441 W/dalvikvm( 4579): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 20:35:17.441 E/ACRA    ( 4579): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 20:35:17.441 D/ACRA    ( 4579): Using custom Report Fields\n07-05 20:35:17.451 I/ACRA    ( 4579): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 20:35:17.471 D/ACRA    ( 4579): Retrieving logcat output...\n'),
(24, 1, '2014-07-05 20:35:47', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmlibrary.HelpRequestDialog.sendHelpRequest(HelpRequestDialog.java:69)\n	at com.boha.cmlibrary.HelpRequestDialog.access$000(HelpRequestDialog.java:24)\n	at com.boha.cmlibrary.HelpRequestDialog$1.onClick(HelpRequestDialog.java:46)\n	at android.view.View.performClick(View.java:4633)\n	at android.view.View$PerformClick.run(View.java:19330)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 20:35:26.876 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:26.951 I/BohaRequest( 4842): ---- Comms elapsed time: 0.486 seconds\n07-05 20:35:26.951 E/BaseVolley( 4842): Yup! ...response object received, status code: 0\n07-05 20:35:26.956 W/CacheUtil( 4842): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 25342\n07-05 20:35:26.961 W/MainPagerActivity( 4842): getting provinces ...\n07-05 20:35:26.961 I/MainPagerActivity( 4842): Country code is ZA\n07-05 20:35:26.966 I/WebCheck( 4842): ###### WIFI AVAILABLE on check\n07-05 20:35:26.966 I/WebCheck( 4842): ###### WIFI CONNECTED on check\n07-05 20:35:26.966 I/WebCheck( 4842): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 20:35:26.966 E/WebCheck( 4842): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 20:35:26.966 D/WebCheck( 4842): ###### Network check completed in 1 ms\n07-05 20:35:27.016 I/BaseVolley( 4842): ...sending remote request: .......>\n07-05 20:35:27.016 I/BaseVolley( 4842): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 20:35:27.016 I/BohaRequest( 4842): ...Cloud Server communication started ...\n07-05 20:35:27.026 W/CacheUtil( 4842): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/ratings.json - length: 588 items: 7\n07-05 20:35:27.041 W/CacheUtil( 4842): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/helptypes.json - length: 760 items: 10\n07-05 20:35:27.416 D/BohaRequest( 4842): parsing response, elapsed since start: 0.399 seconds\n07-05 20:35:27.421 I/BohaRequest( 4842): response string length returned: 3064\n07-05 20:35:27.686 I/BohaRequest( 4842): ---- Comms elapsed time: 0.673 seconds\n07-05 20:35:27.686 E/BaseVolley( 4842): Yup! ...response object received, status code: 0\n07-05 20:35:29.066 D/AbsListView( 4842): Get MotionRecognitionManager\n07-05 20:35:29.086 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:29.086 E/CourseListFragment( 4842): ## onResume\n07-05 20:35:29.186 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:29.886 I/TeamListFragment( 4842): ##### onCreateView\n07-05 20:35:29.886 E/TeamListFragment( 4842): TrainingClassID = 1\n07-05 20:35:29.906 D/AbsListView( 4842): Get MotionRecognitionManager\n07-05 20:35:29.906 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:29.911 W/TeamListFragment( 4842): ## onResume\n07-05 20:35:29.981 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:32.621 I/TraineeListFragment( 4842): onSaveInstanceState\n07-05 20:35:32.626 D/AbsListView( 4842): onDetachedFromWindow\n07-05 20:35:32.626 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:32.626 E/TraineeProfileFragment( 4842): ## onCreateView \n07-05 20:35:32.736 E/BohaVolley( 4842): initializing Volley Networking ...\n07-05 20:35:32.756 I/BohaVolley( 4842): Yebo! Volley Networking has been initialized\n07-05 20:35:32.761 D/TraineeProfileFragment( 4842): *** attempting to set profile picture\n07-05 20:35:32.786 D/TraineeProfileFragment( 4842): setting provinceSpinner ...\n07-05 20:35:32.796 D/TraineeProfileFragment( 4842): loadForm - detected province, setting selection\n07-05 20:35:32.816 E/TraineeProfileFragment( 4842): ## onResume in TraineeProfileFragment\n07-05 20:35:32.891 D/TraineeProfileFragment( 4842): setting citySpinner ...-\n07-05 20:35:32.891 D/TraineeProfileFragment( 4842): prov cities: 28\n07-05 20:35:32.891 D/TraineeProfileFragment( 4842): Trainee city found: Broederstroom index: 6\n07-05 20:35:35.541 I/TraineeProfileFragment( 4842): ##### onSaveInstanceState  fired ....TraineeProfileFragment\n07-05 20:35:35.546 D/TraineeListFragment( 4842): ---- onAttach\n07-05 20:35:35.546 I/TraineeListFragment( 4842): -- onCreateView ............\n07-05 20:35:35.561 D/AbsListView( 4842): Get MotionRecognitionManager\n07-05 20:35:35.576 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:35.576 D/TraineeListFragment( 4842): ---- onResume - nothing to be done\n07-05 20:35:35.736 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:35.761 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.496 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.496 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.501 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.511 W/ApplicationPackageManager( 4842): getCSCPackageItemText()\n07-05 20:35:38.551 W/ActivityPageFragment( 4842): ############################# onCreateView\n07-05 20:35:38.571 D/AbsListView( 4842): Get MotionRecognitionManager\n07-05 20:35:38.591 W/ActivityPageFragment( 4842): ############## setTrainingClassCourse\n07-05 20:35:38.591 W/ActivityPageFragment( 4842): ############## setList\n07-05 20:35:38.596 I/ActivityListActivity( 4842): *** onResume - doin nuthin'' \n07-05 20:35:38.596 D/AbsListView( 4842): onVisibilityChanged() is called, visibility : 4\n07-05 20:35:38.596 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.601 D/AbsListView( 4842): onVisibilityChanged() is called, visibility : 0\n07-05 20:35:38.601 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.606 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.776 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.791 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.931 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:38.961 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:39.096 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:39.381 W/MainPagerActivity( 4842): onSaveInstanceState\n07-05 20:35:39.386 W/TeamListFragment( 4842): ## onSaveInstanceState\n07-05 20:35:39.386 I/CourseListFragment( 4842): ##### onSaveInstanceState  fired ....\n07-05 20:35:39.386 I/TraineeListFragment( 4842): onSaveInstanceState\n07-05 20:35:39.391 D/AbsListView( 4842): onVisibilityChanged() is called, visibility : 4\n07-05 20:35:39.391 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:39.391 D/AbsListView( 4842): onVisibilityChanged() is called, visibility : 4\n07-05 20:35:39.391 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:39.396 D/AbsListView( 4842): onVisibilityChanged() is called, visibility : 4\n07-05 20:35:39.396 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:41.291 I/HelpRequestDialog( 4842): onCreateView of Dialog\n07-05 20:35:41.306 D/CacheUtil( 4842): ################ getting cached data ..................\n07-05 20:35:41.306 E/CacheUtil( 4842): ########### doInBackground: getting cached data ....\n07-05 20:35:41.371 W/CacheUtil( 4842): $$$$$$$$$$$$ cached data retrieved\n07-05 20:35:41.546 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:43.761 D/AbsListView( 4842): Get MotionRecognitionManager\n07-05 20:35:43.771 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:43.816 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:43.821 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:43.826 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:43.871 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:45.481 D/AbsListView( 4842): onDetachedFromWindow\n07-05 20:35:45.481 D/AbsListView( 4842): unregisterIRListener() is called \n07-05 20:35:45.566 E/ViewRootImpl( 4842): sendUserActionEvent() mView == null\n07-05 20:35:47.521 D/AndroidRuntime( 4842): Shutting down VM\n07-05 20:35:47.521 W/dalvikvm( 4842): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 20:35:47.521 E/ACRA    ( 4842): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 20:35:47.521 D/ACRA    ( 4842): Using custom Report Fields\n07-05 20:35:47.531 I/ACRA    ( 4842): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 20:35:47.556 D/ACRA    ( 4842): Retrieving logcat output...\n');
INSERT INTO `errorStoreAndroid` (`errorStoreAndroidID`, `companyID`, `errorDate`, `packageName`, `appVersionName`, `appVersionCode`, `brand`, `phoneModel`, `androidVersion`, `stackTrace`, `logCat`) VALUES
(25, 1, '2014-07-05 20:44:38', 'com.boha.cmtrainee', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NullPointerException\n	at com.boha.cmlibrary.HelpRequestDialog.sendHelpRequest(HelpRequestDialog.java:70)\n	at com.boha.cmlibrary.HelpRequestDialog.access$000(HelpRequestDialog.java:24)\n	at com.boha.cmlibrary.HelpRequestDialog$1.onClick(HelpRequestDialog.java:47)\n	at android.view.View.performClick(View.java:4633)\n	at android.view.View$PerformClick.run(View.java:19330)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 20:40:24.581 W/CacheUtil( 5416): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/traineeActivity - length: 25342\n07-05 20:40:24.991 I/BaseVolley( 5416): ...sending remote request: .......>\n07-05 20:40:24.991 I/BaseVolley( 5416): http://192.168.1.111:8050/cm/admin?JSON={"countryCode":"ZA","zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":100,"returnEquipment":false}\n07-05 20:40:24.991 I/BohaRequest( 5416): ...Cloud Server communication started ...\n07-05 20:40:25.006 D/Volley  ( 5416): [1] Request.finish: 10986 ms: [ ] http://192.168.1.111:8050/cm/team?JSON=%7B%22trainingClassID%22%3A1%2C%22zippedResponse%22%3Atrue%2C%22startDate%22%3A0%2C%22calendarID%22%3A0%2C%22endDate%22%3A0%2C%22dateTo%22%3A0%2C%22dateFrom%22%3A0%2C%22requestType%22%3A116%2C%22returnEquipment%22%3Afalse%7D 0x85bc0df5 NORMAL 2\n07-05 20:40:25.011 I/Choreographer( 5416): Skipped 81 frames!  The application may be doing too much work on its main thread.\n07-05 20:40:25.241 W/CacheUtil( 5416): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/ratings.json - length: 588 items: 7\n07-05 20:40:25.281 W/CacheUtil( 5416): ......Data cache json written to disk,  - path: /data/data/com.boha.cmtrainee/files/helptypes.json - length: 760 items: 10\n07-05 20:40:26.296 D/BohaRequest( 5416): parsing response, elapsed since start: 1.294 seconds\n07-05 20:40:26.321 I/BohaRequest( 5416): response string length returned: 3064\n07-05 20:40:27.356 I/BohaRequest( 5416): ---- Comms elapsed time: 2.359 seconds\n07-05 20:40:27.356 E/BaseVolley( 5416): Yup! ...response object received, status code: 0\n07-05 20:42:01.336 D/AbsListView( 5416): Get MotionRecognitionManager\n07-05 20:42:01.391 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:01.391 E/CourseListFragment( 5416): ## onResume\n07-05 20:42:01.496 D/dalvikvm( 5416): GC_FOR_ALLOC freed 14592K, 45% free 20504K/37076K, paused 47ms, total 47ms\n07-05 20:42:01.726 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:02.466 I/TeamListFragment( 5416): ##### onCreateView\n07-05 20:42:02.471 E/TeamListFragment( 5416): TrainingClassID = 1\n07-05 20:42:02.561 D/AbsListView( 5416): Get MotionRecognitionManager\n07-05 20:42:02.576 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:02.576 W/TeamListFragment( 5416): ## onResume\n07-05 20:42:02.771 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:07.116 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:07.126 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:07.131 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:07.136 W/ApplicationPackageManager( 5416): getCSCPackageItemText()\n07-05 20:42:07.231 W/ActivityPageFragment( 5416): ############################# onCreateView\n07-05 20:42:07.301 D/dalvikvm( 5416): GC_FOR_ALLOC freed 372K, 44% free 21010K/37076K, paused 43ms, total 43ms\n07-05 20:42:07.326 I/dalvikvm-heap( 5416): Grow heap (frag case) to 32.996MB for 11059216-byte allocation\n07-05 20:42:07.361 D/dalvikvm( 5416): GC_FOR_ALLOC freed 7K, 15% free 31803K/37076K, paused 23ms, total 23ms\n07-05 20:42:07.516 D/AbsListView( 5416): Get MotionRecognitionManager\n07-05 20:42:07.776 W/ActivityPageFragment( 5416): ############## setTrainingClassCourse\n07-05 20:42:07.776 W/ActivityPageFragment( 5416): ############## setList\n07-05 20:42:07.791 I/ActivityListActivity( 5416): *** onResume - doin nuthin'' \n07-05 20:42:07.796 D/AbsListView( 5416): onVisibilityChanged() is called, visibility : 4\n07-05 20:42:07.796 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:07.811 D/AbsListView( 5416): onVisibilityChanged() is called, visibility : 0\n07-05 20:42:07.811 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:07.836 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:09.006 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:09.011 I/Choreographer( 5416): Skipped 70 frames!  The application may be doing too much work on its main thread.\n07-05 20:42:09.031 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:09.196 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:09.421 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:09.531 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:09.771 W/MainPagerActivity( 5416): onSaveInstanceState\n07-05 20:42:09.781 W/TeamListFragment( 5416): ## onSaveInstanceState\n07-05 20:42:09.786 I/TraineeListFragment( 5416): onSaveInstanceState\n07-05 20:42:09.786 I/CourseListFragment( 5416): ##### onSaveInstanceState  fired ....\n07-05 20:42:09.791 D/AbsListView( 5416): onVisibilityChanged() is called, visibility : 4\n07-05 20:42:09.791 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:09.796 D/AbsListView( 5416): onVisibilityChanged() is called, visibility : 4\n07-05 20:42:09.796 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:09.796 D/AbsListView( 5416): onVisibilityChanged() is called, visibility : 4\n07-05 20:42:09.796 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:11.196 I/Choreographer( 5416): Skipped 83 frames!  The application may be doing too much work on its main thread.\n07-05 20:42:11.356 I/REG     ( 5416): -- onPause ---\n07-05 20:42:11.386 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:11.396 W/ApplicationPackageManager( 5416): getCSCPackageItemText()\n07-05 20:42:11.506 E/RatingFragment( 5416): ############### onCreateView in RatingFragment\n07-05 20:42:11.681 D/CacheUtil( 5416): ################ getting cached data ..................\n07-05 20:42:11.691 E/CacheUtil( 5416): ########### doInBackground: getting cached data ....\n07-05 20:42:11.796 D/RatingFragment( 5416): setting courseTraineeActivity. ...\n07-05 20:42:11.806 E/RatingFragment( 5416): ############### resuming in RatingFragment\n07-05 20:42:12.156 W/CacheUtil( 5416): $$$$$$$$$$$$ cached data retrieved\n07-05 20:42:13.046 W/RatingFragment( 5416): ###################...sending trainee rating .... \n07-05 20:42:13.051 V/Vibrator( 5416): Called vibrate(long) API - PUID: 10339, PackageName: com.boha.cmtrainee\n07-05 20:42:13.051 V/Vibrator( 5416): vibrate - PUID: 10339, PackageName: com.boha.cmtrainee, ms: 30, mag: -1\n07-05 20:42:13.456 D/ActivityPageFragment( 5416): #onSaveInstanceState,  \n07-05 20:42:13.466 D/AbsListView( 5416): onVisibilityChanged() is called, visibility : 4\n07-05 20:42:13.466 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:17.016 W/RatingActivity( 5416): ################ onBackPressed\n07-05 20:42:17.021 I/RA      ( 5416): -- onPause ---\n07-05 20:42:17.041 E/ActivityListActivity( 5416): ################ onActivityResult requestCode: 763 resultCode: 0\n07-05 20:42:17.046 I/ActivityListActivity( 5416): *** onResume - doin nuthin'' \n07-05 20:42:17.046 D/AbsListView( 5416): onVisibilityChanged() is called, visibility : 0\n07-05 20:42:17.046 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:17.091 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:18.871 I/HelpRequestDialog( 5416): onCreateView of Dialog\n07-05 20:42:18.936 D/CacheUtil( 5416): ################ getting cached data ..................\n07-05 20:42:18.936 E/CacheUtil( 5416): ########### doInBackground: getting cached data ....\n07-05 20:42:19.011 W/CacheUtil( 5416): $$$$$$$$$$$$ cached data retrieved\n07-05 20:42:19.381 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:27.116 D/AbsListView( 5416): Get MotionRecognitionManager\n07-05 20:42:27.171 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:27.291 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:27.326 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:27.331 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:27.416 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:28.561 D/AbsListView( 5416): onDetachedFromWindow\n07-05 20:42:28.561 D/AbsListView( 5416): unregisterIRListener() is called \n07-05 20:42:28.706 E/ViewRootImpl( 5416): sendUserActionEvent() mView == null\n07-05 20:44:38.901 D/AndroidRuntime( 5416): Shutting down VM\n07-05 20:44:38.901 W/dalvikvm( 5416): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 20:44:38.901 E/ACRA    ( 5416): ACRA caught a NullPointerException exception for com.boha.cmtrainee. Building report.\n07-05 20:44:38.906 D/dalvikvm( 5416): Debugger has detached; object registry had 4708 entries\n07-05 20:44:38.911 D/ACRA    ( 5416): Using custom Report Fields\n07-05 20:44:38.921 I/ACRA    ( 5416): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 20:44:38.991 D/ACRA    ( 5416): Retrieving logcat output...\n'),
(26, 1, '2014-07-05 22:46:58', 'com.boha.cminstructor', '1.0', '1', 'samsung', 'GT-I9500', '4.4.2', 'java.lang.NoSuchFieldError: com.boha.cmlibrary.R$id.AR_tRating\n	at com.boha.cmlibrary.adapters.ActivityAdapter.getView(ActivityAdapter.java:65)\n	at android.widget.AbsListView.obtainView(AbsListView.java:2720)\n	at android.widget.ListView.makeAndAddView(ListView.java:1801)\n	at android.widget.ListView.fillDown(ListView.java:697)\n	at android.widget.ListView.fillFromTop(ListView.java:763)\n	at android.widget.ListView.layoutChildren(ListView.java:1641)\n	at android.widget.AbsListView.onLayout(AbsListView.java:2533)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1677)\n	at android.widget.LinearLayout.layoutHorizontal(LinearLayout.java:1666)\n	at android.widget.LinearLayout.onLayout(LinearLayout.java:1442)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.RelativeLayout.onLayout(RelativeLayout.java:1055)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at com.android.internal.widget.ActionBarOverlayLayout.onLayout(ActionBarOverlayLayout.java:438)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.widget.FrameLayout.layoutChildren(FrameLayout.java:453)\n	at android.widget.FrameLayout.onLayout(FrameLayout.java:388)\n	at android.view.View.layout(View.java:15655)\n	at android.view.ViewGroup.layout(ViewGroup.java:4856)\n	at android.view.ViewRootImpl.performLayout(ViewRootImpl.java:2284)\n	at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:2004)\n	at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1234)\n	at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6467)\n	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:803)\n	at android.view.Choreographer.doCallbacks(Choreographer.java:603)\n	at android.view.Choreographer.doFrame(Choreographer.java:573)\n	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:789)\n	at android.os.Handler.handleCallback(Handler.java:733)\n	at android.os.Handler.dispatchMessage(Handler.java:95)\n	at android.os.Looper.loop(Looper.java:157)\n	at android.app.ActivityThread.main(ActivityThread.java:5356)\n	at java.lang.reflect.Method.invokeNative(Native Method)\n	at java.lang.reflect.Method.invoke(Method.java:515)\n	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1265)\n	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1081)\n	at dalvik.system.NativeStart.main(Native Method)\n', '07-05 22:46:33.741 D/dalvikvm(21289): GC_FOR_ALLOC freed 689K, 36% free 21578K/33476K, paused 29ms, total 29ms\n07-05 22:46:33.761 I/dalvikvm-heap(21289): Grow heap (frag case) to 33.549MB for 11059216-byte allocation\n07-05 22:46:33.791 D/dalvikvm(21289): GC_FOR_ALLOC freed <1K, 27% free 32377K/44280K, paused 29ms, total 29ms\n07-05 22:46:33.896 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:33.946 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:34.056 I/MainPagerActivity(21289): onSaveInstanceState\n07-05 22:46:34.061 I/DashboardFragment(21289): ##### onSaveInstanceState  fired ...not saving...\n07-05 22:46:34.061 I/ClassListFragment(21289): ##### onSaveInstanceState  fired, not saving anything! ....ClassListFragment\n07-05 22:46:34.061 D/AbsListView(21289): onVisibilityChanged() is called, visibility : 4\n07-05 22:46:34.061 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:34.341 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:36.691 I/dalvikvm-heap(21289): Grow heap (frag case) to 38.911MB for 366016-byte allocation\n07-05 22:46:36.696 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:36.861 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:36.881 I/dalvikvm-heap(21289): Grow heap (frag case) to 39.376MB for 415016-byte allocation\n07-05 22:46:37.061 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:37.291 I/dalvikvm-heap(21289): Grow heap (frag case) to 40.639MB for 921616-byte allocation\n07-05 22:46:37.306 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:37.461 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:38.926 D/dalvikvm(21289): GC_FOR_ALLOC freed 5064K, 28% free 35652K/49152K, paused 73ms, total 74ms\n07-05 22:46:39.081 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:39.676 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:39.976 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:41.696 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:41.931 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:41.931 D/Volley  (21289): [13407] BasicNetwork.logSlowRequests: HTTP response for request=<[ ] http://192.168.1.111:8050/cm/instructor?JSON=%7B%22trainingClassID%22%3A1%2C%22zippedResponse%22%3Atrue%2C%22startDate%22%3A0%2C%22calendarID%22%3A0%2C%22endDate%22%3A0%2C%22dateTo%22%3A0%2C%22dateFrom%22%3A0%2C%22requestType%22%3A609%2C%22returnEquipment%22%3Afalse%7D 0x85bc0df5 NORMAL 2> [lifetime=8244], [size=1867], [rc=200], [retryCount=0]\n07-05 22:46:41.936 D/BohaRequest(21289): parsing response, elapsed since start: 8.255 seconds\n07-05 22:46:41.936 I/BohaRequest(21289): response string length returned: 1744\n07-05 22:46:42.161 I/BohaRequest(21289): ---- Comms elapsed time: 8.481 seconds\n07-05 22:46:42.161 E/BaseVolley(21289): Yup! ...response object received, status code: 0\n07-05 22:46:42.161 D/Volley  (21289): [1] Request.finish: 8482 ms: [ ] http://192.168.1.111:8050/cm/instructor?JSON=%7B%22trainingClassID%22%3A1%2C%22zippedResponse%22%3Atrue%2C%22startDate%22%3A0%2C%22calendarID%22%3A0%2C%22endDate%22%3A0%2C%22dateTo%22%3A0%2C%22dateFrom%22%3A0%2C%22requestType%22%3A609%2C%22returnEquipment%22%3Afalse%7D 0x85bc0df5 NORMAL 2\n07-05 22:46:42.191 W/CacheUtil(21289): ......Data cache json written to disk,  - path: /data/data/com.boha.cminstructor/files/traineeList.json1 - length: 13679\n07-05 22:46:42.211 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:42.811 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:42.946 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:43.281 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:44.346 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:44.716 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:52.426 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:52.536 I/TraineeListActivity(21289): onTraineePicked - starting CourseActivity\n07-05 22:46:52.576 I/REG     (21289): -- onPause ---\n07-05 22:46:52.601 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:52.606 W/ApplicationPackageManager(21289): getCSCPackageItemText()\n07-05 22:46:52.671 D/AbsListView(21289): Get MotionRecognitionManager\n07-05 22:46:52.681 D/CourseListFragment(21289): #### onResume() ...\n07-05 22:46:52.681 D/AbsListView(21289): onVisibilityChanged() is called, visibility : 4\n07-05 22:46:52.681 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:52.691 D/AbsListView(21289): onVisibilityChanged() is called, visibility : 0\n07-05 22:46:52.691 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:52.701 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:52.776 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:52.781 I/WebCheck(21289): ###### WIFI AVAILABLE on check\n07-05 22:46:52.781 I/WebCheck(21289): ###### WIFI CONNECTED on check\n07-05 22:46:52.781 I/WebCheck(21289): ###### MOBILE_NETWORK AVAILABLE on check\n07-05 22:46:52.781 E/WebCheck(21289): @@@ MOBILE_NETWORK NOT CONNECTED on check\n07-05 22:46:52.781 D/WebCheck(21289): ###### Network check completed in 1 ms\n07-05 22:46:52.841 D/dalvikvm(21289): GC_FOR_ALLOC freed 5678K, 26% free 37783K/50992K, paused 44ms, total 44ms\n07-05 22:46:52.901 I/BaseVolley(21289): ...sending remote request: .......>\n07-05 22:46:52.901 I/BaseVolley(21289): http://192.168.1.111:8050/cm/trainee?JSON={"trainingClassID":1,"companyID":1,"traineeID":118,"zippedResponse":true,"startDate":0,"calendarID":0,"endDate":0,"dateTo":0,"dateFrom":0,"requestType":301,"returnEquipment":false}\n07-05 22:46:52.901 I/BohaRequest(21289): ...Cloud Server communication started ...\n07-05 22:46:52.906 D/ProgressBar(21289): updateDrawableBounds: left = 0\n07-05 22:46:52.906 D/ProgressBar(21289): updateDrawableBounds: top = 0\n07-05 22:46:52.906 D/ProgressBar(21289): updateDrawableBounds: right = 48\n07-05 22:46:52.906 D/ProgressBar(21289): updateDrawableBounds: bottom = 48\n07-05 22:46:52.941 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:52.966 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:53.071 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:53.261 D/BohaRequest(21289): parsing response, elapsed since start: 0.356 seconds\n07-05 22:46:53.261 I/BohaRequest(21289): response string length returned: 3148\n07-05 22:46:53.466 I/TraineeListFragment(21289): ##### onSaveInstanceState  saving list: \n07-05 22:46:53.466 D/AbsListView(21289): onVisibilityChanged() is called, visibility : 4\n07-05 22:46:53.466 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:53.521 I/BohaRequest(21289): ---- Comms elapsed time: 0.619 seconds\n07-05 22:46:53.521 E/BaseVolley(21289): Yup! ...response object received, status code: 0\n07-05 22:46:53.616 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:58.376 W/CourseActivity(21289): ####################### Course selected. Developer Accounts\n07-05 22:46:58.456 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:58.456 W/ApplicationPackageManager(21289): getCSCPackageItemText()\n07-05 22:46:58.491 W/ActivityPageFragment(21289): ############################# onCreateView\n07-05 22:46:58.521 D/AbsListView(21289): Get MotionRecognitionManager\n07-05 22:46:58.536 W/ActivityPageFragment(21289): ############## setTrainingClassCourse\n07-05 22:46:58.536 W/ActivityPageFragment(21289): ############## setList\n07-05 22:46:58.536 D/dalvikvm(21289): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_tRating\n07-05 22:46:58.536 W/dalvikvm(21289): VFY: unable to resolve static field 4896 (AR_tRating) in Lcom/boha/cmlibrary/R$id;\n07-05 22:46:58.536 D/dalvikvm(21289): VFY: replacing opcode 0x60 at 0x0048\n07-05 22:46:58.536 D/dalvikvm(21289): DexOpt: couldn''t find static field Lcom/boha/cmlibrary/R$id;.AR_imageHelp\n07-05 22:46:58.536 I/dalvikvm(21289): DexOpt: unable to optimize static field ref 0x131c at 0x58 in Lcom/boha/cmlibrary/adapters/ActivityAdapter;.getView\n07-05 22:46:58.541 I/ActivityListActivity(21289): *** onResume - doin nuthin'' \n07-05 22:46:58.541 D/AbsListView(21289): onVisibilityChanged() is called, visibility : 4\n07-05 22:46:58.541 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:58.546 D/AbsListView(21289): onVisibilityChanged() is called, visibility : 0\n07-05 22:46:58.546 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:58.556 D/AbsListView(21289): unregisterIRListener() is called \n07-05 22:46:58.616 D/AndroidRuntime(21289): Shutting down VM\n07-05 22:46:58.616 W/dalvikvm(21289): threadid=1: thread exiting with uncaught exception (group=0x42072c08)\n07-05 22:46:58.616 E/ACRA    (21289): ACRA caught a NoSuchFieldError exception for com.boha.cminstructor. Building report.\n07-05 22:46:58.616 D/ACRA    (21289): Using custom Report Fields\n07-05 22:46:58.646 I/dalvikvm(21289): Jit: resizing JitTable from 4096 to 8192\n07-05 22:46:58.651 I/ACRA    (21289): READ_LOGS granted! ACRA can include LogCat and DropBox data.\n07-05 22:46:58.726 D/ACRA    (21289): Retrieving logcat output...\n');

-- --------------------------------------------------------

--
-- Table structure for table `gcmDevice`
--

CREATE TABLE `gcmDevice` (
  `gcmDeviceID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `administratorID` int(10) unsigned DEFAULT NULL,
  `authorID` int(10) unsigned DEFAULT NULL,
  `instructorID` int(10) unsigned DEFAULT NULL,
  `traineeID` int(10) unsigned DEFAULT NULL,
  `reportUserID` int(10) unsigned DEFAULT NULL,
  `registrationID` text NOT NULL,
  `manufacturer` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `messageCount` int(10) unsigned DEFAULT NULL,
  `dateRegistered` datetime NOT NULL,
  `serialNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gcmDeviceID`),
  KEY `administratorID` (`administratorID`),
  KEY `authorID` (`authorID`),
  KEY `instructorID` (`instructorID`),
  KEY `traineeID` (`traineeID`),
  KEY `reportUserID` (`reportUserID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=72 ;

--
-- Dumping data for table `gcmDevice`
--

INSERT INTO `gcmDevice` (`gcmDeviceID`, `administratorID`, `authorID`, `instructorID`, `traineeID`, `reportUserID`, `registrationID`, `manufacturer`, `model`, `product`, `messageCount`, `dateRegistered`, `serialNumber`) VALUES
(1, NULL, NULL, 12, NULL, NULL, 'APA91bGKqlgRWFT38bHNsY3om2Tx_Wrs_u21UYqrhI2czb2ZGiZACjT5Oj4KVsgT7-j4ECOKiAoDAJhQ2otIOG3INbZvBTSMwJi3EB9HI6BsaCLQgLpP-3kwwxoGdJt8ItKt538-gEYGjV1iWhwkkNyqb9aBJuBPng', 'HTC', 'HTC Flyer P510e', 'HTK75C', NULL, '2013-11-17 23:54:46', 'HT15ET400661'),
(2, NULL, NULL, 13, NULL, NULL, 'APA91bGKqlgRWFT38bHNsY3om2Tx_Wrs_u21UYqrhI2czb2ZGiZACjT5Oj4KVsgT7-j4ECOKiAoDAJhQ2otIOG3INbZvBTSMwJi3EB9HI6BsaCLQgLpP-3kwwxoGdJt8ItKt538-gEYGjV1iWhwkkNyqb9aBJuBPng', 'HTC', 'HTC Flyer P510e', 'HTK75C', NULL, '2013-11-18 00:08:46', 'HT15ET400661'),
(3, NULL, NULL, NULL, 115, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', 'HTC', 'HTC Flyer P510e', 'HTK75C', NULL, '2013-11-18 00:23:26', 'HT15ET400661'),
(4, NULL, NULL, NULL, 117, NULL, 'APA91bG5vpsWjCpyXBK1QdGMLT8H-7Uj0oqni5EhUEj5qiB4rNUKi6GHwyMZeJAxJK4Drsx70qHx9-LynNP4ul5SH6FUJEnIPoHgDx3kF53vsG5IWTxzHIUML8f0hZhqfx0WltKopCk4h89MJ50IMInJxjW3JZKwuw', 'samsung', 'GT-I9300', 'JZO54K.I9300XXEMA2', NULL, '2013-11-18 15:58:27', '4df09f6203265f9f'),
(5, NULL, NULL, NULL, 118, NULL, 'APA91bG5vpsWjCpyXBK1QdGMLT8H-7Uj0oqni5EhUEj5qiB4rNUKi6GHwyMZeJAxJK4Drsx70qHx9-LynNP4ul5SH6FUJEnIPoHgDx3kF53vsG5IWTxzHIUML8f0hZhqfx0WltKopCk4h89MJ50IMInJxjW3JZKwuw', 'samsung', 'GT-I9300', 'JZO54K.I9300XXEMA2', NULL, '2013-11-18 16:02:39', '4df09f6203265f9f'),
(6, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-02-17 22:02:54', NULL),
(7, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-02-17 22:08:30', NULL),
(8, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-02-17 22:10:38', NULL),
(9, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-02-17 22:14:47', NULL),
(10, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-02-17 22:18:10', NULL),
(11, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-02-17 22:36:36', NULL),
(12, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-02-17 22:36:42', NULL),
(13, NULL, 2, NULL, NULL, NULL, 'APA91bEVIk_7Nf4GrDpKNcTub9B1gyKwOe-M31R3U6hZX8KOKSSnLF9Nj6fLzlFZHATqeGCeNuyiMIWHPxK6zYe6DBm5gzMlH2o8bfg5f9R-sJiuZQldbNtW2URIihsJxFSjsv_yO3J_Vw8zw-VRifI-IyS-1tTVHA', NULL, NULL, NULL, NULL, '2014-02-18 11:06:10', NULL),
(14, NULL, NULL, 13, NULL, NULL, 'APA91bGKqlgRWFT38bHNsY3om2Tx_Wrs_u21UYqrhI2czb2ZGiZACjT5Oj4KVsgT7-j4ECOKiAoDAJhQ2otIOG3INbZvBTSMwJi3EB9HI6BsaCLQgLpP-3kwwxoGdJt8ItKt538-gEYGjV1iWhwkkNyqb9aBJuBPng', NULL, NULL, NULL, NULL, '2014-02-18 11:10:48', NULL),
(15, NULL, NULL, NULL, 124, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-02-18 11:18:16', NULL),
(16, NULL, 1, NULL, NULL, NULL, 'APA91bEVIk_7Nf4GrDpKNcTub9B1gyKwOe-M31R3U6hZX8KOKSSnLF9Nj6fLzlFZHATqeGCeNuyiMIWHPxK6zYe6DBm5gzMlH2o8bfg5f9R-sJiuZQldbNtW2URIihsJxFSjsv_yO3J_Vw8zw-VRifI-IyS-1tTVHA', NULL, NULL, NULL, NULL, '2014-02-25 08:16:07', NULL),
(17, NULL, 1, NULL, NULL, NULL, 'APA91bEVIk_7Nf4GrDpKNcTub9B1gyKwOe-M31R3U6hZX8KOKSSnLF9Nj6fLzlFZHATqeGCeNuyiMIWHPxK6zYe6DBm5gzMlH2o8bfg5f9R-sJiuZQldbNtW2URIihsJxFSjsv_yO3J_Vw8zw-VRifI-IyS-1tTVHA', NULL, NULL, NULL, NULL, '2014-02-25 08:16:12', NULL),
(18, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-02-25 08:21:11', NULL),
(19, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-03-01 01:43:56', NULL),
(20, NULL, NULL, NULL, 117, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-03-01 09:28:20', NULL),
(21, NULL, NULL, NULL, 117, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-03-01 17:19:24', NULL),
(22, NULL, NULL, NULL, 117, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-03-01 17:39:51', NULL),
(23, NULL, NULL, NULL, 117, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-03-01 17:51:19', NULL),
(24, NULL, NULL, NULL, 117, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-03-01 18:10:07', NULL),
(25, NULL, NULL, NULL, 117, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-03-01 18:19:36', NULL),
(26, NULL, NULL, NULL, 117, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-03-01 21:07:12', NULL),
(27, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-03-10 14:37:57', NULL),
(28, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-03-10 15:01:38', NULL),
(29, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-03-10 17:10:00', NULL),
(30, 18, NULL, NULL, NULL, NULL, 'APA91bHrdDgd-u5u-uBuFwSCF7isdxWfKhUNoBHCm9YXJzqUZIBhK3RRCcSMUXZ-Y9I7E0W6nIUqdiSn8UddLd0khZkqXw6hrL6mwwBO49s88_Ss32Atq8QMqAMLi2GwW4FSZznlnRCgvl6FBRvl4oBfnIzNeSbU0Q', NULL, NULL, NULL, NULL, '2014-03-12 10:05:26', NULL),
(31, 18, NULL, NULL, NULL, NULL, 'APA91bHrdDgd-u5u-uBuFwSCF7isdxWfKhUNoBHCm9YXJzqUZIBhK3RRCcSMUXZ-Y9I7E0W6nIUqdiSn8UddLd0khZkqXw6hrL6mwwBO49s88_Ss32Atq8QMqAMLi2GwW4FSZznlnRCgvl6FBRvl4oBfnIzNeSbU0Q', NULL, NULL, NULL, NULL, '2014-03-12 10:08:40', NULL),
(32, NULL, NULL, 19, NULL, NULL, 'APA91bGsQIieFP2iPjJzx8fCcJ5DMtl3XuDi8vvBAunUsU9r6riq9JjeLwYrZqvzGrKf53U3X57yXlbzcVWh3YkZsf_oDoDIe2LcLtBn_Wz5eRRxD9jBhpDNDLTIcyU2RSXEpF_hqGb8lhf3oEaOZwpyWlkHmFxZhg', NULL, NULL, NULL, NULL, '2014-03-12 11:03:48', NULL),
(33, NULL, NULL, 19, NULL, NULL, 'APA91bGsQIieFP2iPjJzx8fCcJ5DMtl3XuDi8vvBAunUsU9r6riq9JjeLwYrZqvzGrKf53U3X57yXlbzcVWh3YkZsf_oDoDIe2LcLtBn_Wz5eRRxD9jBhpDNDLTIcyU2RSXEpF_hqGb8lhf3oEaOZwpyWlkHmFxZhg', NULL, NULL, NULL, NULL, '2014-03-12 11:03:51', NULL),
(34, NULL, 13, NULL, NULL, NULL, 'APA91bF1eNa_5LXgrhmAPknUXLhUSDLNLtyyl2pJP5r4dzwXeQj45bQVM4k4oWo9YRovu14ut6KudE-29hi9cqHVgVP2-WnYbaM2_5yWvA5x2Wace9lsUDy_UBdGCAqdgQfF9nbf9a9fokipRirh9n7-XAxJZTzPWA', NULL, NULL, NULL, NULL, '2014-03-12 16:39:43', NULL),
(35, 18, NULL, NULL, NULL, NULL, 'APA91bHrdDgd-u5u-uBuFwSCF7isdxWfKhUNoBHCm9YXJzqUZIBhK3RRCcSMUXZ-Y9I7E0W6nIUqdiSn8UddLd0khZkqXw6hrL6mwwBO49s88_Ss32Atq8QMqAMLi2GwW4FSZznlnRCgvl6FBRvl4oBfnIzNeSbU0Q', NULL, NULL, NULL, NULL, '2014-03-12 18:34:39', NULL),
(36, 18, NULL, NULL, NULL, NULL, 'APA91bHrdDgd-u5u-uBuFwSCF7isdxWfKhUNoBHCm9YXJzqUZIBhK3RRCcSMUXZ-Y9I7E0W6nIUqdiSn8UddLd0khZkqXw6hrL6mwwBO49s88_Ss32Atq8QMqAMLi2GwW4FSZznlnRCgvl6FBRvl4oBfnIzNeSbU0Q', NULL, NULL, NULL, NULL, '2014-03-12 18:43:38', NULL),
(37, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-03-13 21:21:01', NULL),
(38, 1, NULL, NULL, NULL, NULL, 'APA91bEz0PHGAjW0ETrB6IyZe70mHa0eh_PZKEcrqi112Cw4lLLAIbeC1mZ2n6ssmHUG-4qYXGntzdimv5-J4_qSqfI5g_pSKFyko_n0osxEq7f83hOfmZUFUdE4UrV_Z2EVvPAnTdD26a-iLoHrc4p68CQd2IlSnA', NULL, NULL, NULL, NULL, '2014-03-13 21:22:17', NULL),
(39, 1, NULL, NULL, NULL, NULL, 'APA91bEz0PHGAjW0ETrB6IyZe70mHa0eh_PZKEcrqi112Cw4lLLAIbeC1mZ2n6ssmHUG-4qYXGntzdimv5-J4_qSqfI5g_pSKFyko_n0osxEq7f83hOfmZUFUdE4UrV_Z2EVvPAnTdD26a-iLoHrc4p68CQd2IlSnA', NULL, NULL, NULL, NULL, '2014-03-14 13:21:11', NULL),
(40, 1, NULL, NULL, NULL, NULL, 'APA91bEz0PHGAjW0ETrB6IyZe70mHa0eh_PZKEcrqi112Cw4lLLAIbeC1mZ2n6ssmHUG-4qYXGntzdimv5-J4_qSqfI5g_pSKFyko_n0osxEq7f83hOfmZUFUdE4UrV_Z2EVvPAnTdD26a-iLoHrc4p68CQd2IlSnA', NULL, NULL, NULL, NULL, '2014-03-14 13:55:01', NULL),
(41, NULL, NULL, NULL, 117, NULL, 'APA91bFTX00swutYXARgwsOHPbcYdZ-X7pMRgrEWdlFU2rtwGE8shKLTQeIKmsvpTp6EKhcvgtb26Q5z0NFUdFZR1ePe6jAfs-ZS2pnb-KJ44eOdSLz4VMih65j1cI7B7ekEt5fEGxBgjRfOun_OvKD1luOeUUiNxQ', NULL, NULL, NULL, NULL, '2014-03-14 19:24:11', NULL),
(42, NULL, NULL, 16, NULL, NULL, 'APA91bG1LX5WSG91HRCarv-ARN-ehbbGFDG3lBkjY30NUn7Rb2ObQRIqXilcTvIP8goevL_tIu0AXCIVJDCEhbcfbB680qZZzTHOXW3qUokG8969XPjJXa5YHVpoHaRhEpkFjmUtPJP2UG4my1cGKyyu5ILyLZkkEw', NULL, NULL, NULL, NULL, '2014-03-15 03:03:46', NULL),
(43, NULL, 1, NULL, NULL, NULL, 'APA91bEsfkdkbk0O8CRfZKIfOuWrZFtsXwLLAPD_hiff3yAz9DEZCZTxQYHZzsOcjCDRlvqhbRFB1PvB5hC_eQmlYrNQoTerEUXnWz56jSpi6biRPAddC0b0ouOFUauOEsFClBK_wjF4Uw19Ys5I-SHzwdXN4e_BXw', NULL, NULL, NULL, NULL, '2014-03-15 12:54:29', NULL),
(44, 1, NULL, NULL, NULL, NULL, 'APA91bEz0PHGAjW0ETrB6IyZe70mHa0eh_PZKEcrqi112Cw4lLLAIbeC1mZ2n6ssmHUG-4qYXGntzdimv5-J4_qSqfI5g_pSKFyko_n0osxEq7f83hOfmZUFUdE4UrV_Z2EVvPAnTdD26a-iLoHrc4p68CQd2IlSnA', NULL, NULL, NULL, NULL, '2014-03-17 02:09:10', NULL),
(45, NULL, 1, NULL, NULL, NULL, 'APA91bEsfkdkbk0O8CRfZKIfOuWrZFtsXwLLAPD_hiff3yAz9DEZCZTxQYHZzsOcjCDRlvqhbRFB1PvB5hC_eQmlYrNQoTerEUXnWz56jSpi6biRPAddC0b0ouOFUauOEsFClBK_wjF4Uw19Ys5I-SHzwdXN4e_BXw', NULL, NULL, NULL, NULL, '2014-03-17 02:13:27', NULL),
(46, NULL, NULL, 16, NULL, NULL, 'APA91bG1LX5WSG91HRCarv-ARN-ehbbGFDG3lBkjY30NUn7Rb2ObQRIqXilcTvIP8goevL_tIu0AXCIVJDCEhbcfbB680qZZzTHOXW3qUokG8969XPjJXa5YHVpoHaRhEpkFjmUtPJP2UG4my1cGKyyu5ILyLZkkEw', NULL, NULL, NULL, NULL, '2014-03-17 02:17:11', NULL),
(47, NULL, NULL, NULL, 117, NULL, 'APA91bFTX00swutYXARgwsOHPbcYdZ-X7pMRgrEWdlFU2rtwGE8shKLTQeIKmsvpTp6EKhcvgtb26Q5z0NFUdFZR1ePe6jAfs-ZS2pnb-KJ44eOdSLz4VMih65j1cI7B7ekEt5fEGxBgjRfOun_OvKD1luOeUUiNxQ', NULL, NULL, NULL, NULL, '2014-03-17 02:29:04', NULL),
(48, 1, NULL, NULL, NULL, NULL, 'APA91bFjU8_zALg95MxwPzjJGgLAXMpjtSpHHZilYufowORGyVfeUx7PRXVvhQwztt8of_reU42X14TNp7IiEPgyJ9wt5jG5uwxmhPssCXDgoaNeURqfo-EkMqfxx2MEvYC3hTIusm0Vm1_AtPfmJo95YrACn_K1Pw', NULL, NULL, NULL, NULL, '2014-03-17 10:11:20', NULL),
(49, NULL, 1, NULL, NULL, NULL, 'APA91bEVIk_7Nf4GrDpKNcTub9B1gyKwOe-M31R3U6hZX8KOKSSnLF9Nj6fLzlFZHATqeGCeNuyiMIWHPxK6zYe6DBm5gzMlH2o8bfg5f9R-sJiuZQldbNtW2URIihsJxFSjsv_yO3J_Vw8zw-VRifI-IyS-1tTVHA', NULL, NULL, NULL, NULL, '2014-03-17 10:15:50', NULL),
(50, NULL, NULL, 13, NULL, NULL, 'APA91bGKqlgRWFT38bHNsY3om2Tx_Wrs_u21UYqrhI2czb2ZGiZACjT5Oj4KVsgT7-j4ECOKiAoDAJhQ2otIOG3INbZvBTSMwJi3EB9HI6BsaCLQgLpP-3kwwxoGdJt8ItKt538-gEYGjV1iWhwkkNyqb9aBJuBPng', NULL, NULL, NULL, NULL, '2014-03-17 10:19:04', NULL),
(51, NULL, NULL, NULL, 117, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-03-17 10:22:52', NULL),
(52, 18, NULL, NULL, NULL, NULL, 'APA91bHrdDgd-u5u-uBuFwSCF7isdxWfKhUNoBHCm9YXJzqUZIBhK3RRCcSMUXZ-Y9I7E0W6nIUqdiSn8UddLd0khZkqXw6hrL6mwwBO49s88_Ss32Atq8QMqAMLi2GwW4FSZznlnRCgvl6FBRvl4oBfnIzNeSbU0Q', NULL, NULL, NULL, NULL, '2014-03-17 12:37:03', NULL),
(53, NULL, 13, NULL, NULL, NULL, 'APA91bF1eNa_5LXgrhmAPknUXLhUSDLNLtyyl2pJP5r4dzwXeQj45bQVM4k4oWo9YRovu14ut6KudE-29hi9cqHVgVP2-WnYbaM2_5yWvA5x2Wace9lsUDy_UBdGCAqdgQfF9nbf9a9fokipRirh9n7-XAxJZTzPWA', NULL, NULL, NULL, NULL, '2014-03-17 13:23:42', NULL),
(54, NULL, NULL, 19, NULL, NULL, 'APA91bGsQIieFP2iPjJzx8fCcJ5DMtl3XuDi8vvBAunUsU9r6riq9JjeLwYrZqvzGrKf53U3X57yXlbzcVWh3YkZsf_oDoDIe2LcLtBn_Wz5eRRxD9jBhpDNDLTIcyU2RSXEpF_hqGb8lhf3oEaOZwpyWlkHmFxZhg', NULL, NULL, NULL, NULL, '2014-03-17 13:27:22', NULL),
(55, NULL, NULL, NULL, 141, NULL, 'APA91bFPaQXyDc0vEXiDhuFMyTPTIc0iN74tdRq7fW9yOAlqWoAyp_ZU_6HjAeRAm-480DSRUdmFQgWEKwKgl69Pqp0LyZnLfLRPM6yN2w-Ali4oUWg7O5eWhq_EUeRl3nOco0Myl7n12gCQyn_K-O86PQoK16VTaw', NULL, NULL, NULL, NULL, '2014-03-17 13:38:49', NULL),
(56, NULL, NULL, NULL, 141, NULL, 'APA91bHlpYYx3ioejhv6qXE4g-UtOQYnTGFJElAD26wxoVn5QURKMtmNl1RrgXYsYqnCODCPcDcpfwg4anxhuh2HJDbV8_xv4rDlhOOK1Pf3uU6getedjdwZ-kOx1bCWKG79C1u_L8FfM0Mv6TQCvM-1TxuPDFjo_g', NULL, NULL, NULL, NULL, '2014-03-17 14:45:16', NULL),
(57, NULL, NULL, NULL, 117, NULL, 'APA91bG5vpsWjCpyXBK1QdGMLT8H-7Uj0oqni5EhUEj5qiB4rNUKi6GHwyMZeJAxJK4Drsx70qHx9-LynNP4ul5SH6FUJEnIPoHgDx3kF53vsG5IWTxzHIUML8f0hZhqfx0WltKopCk4h89MJ50IMInJxjW3JZKwuw', NULL, NULL, NULL, NULL, '2014-03-19 07:44:53', NULL),
(58, 21, NULL, NULL, NULL, NULL, 'APA91bFT_SGVFr2GymwMDjXG7U9oP0H3OKiQQ3D9X1xYtBbVJ62FGLnTaUVPzP3zEhUcc5hvhZQKX2ERHbz9qwlLqpX75HlBeoaytIjJFpQfMuraRcoBTSj99hdhxWQCBAckgL5tRzByB6s-iDgxdc57mdiHsSI_vg', NULL, NULL, NULL, NULL, '2014-03-19 07:46:27', NULL),
(59, NULL, NULL, NULL, 118, NULL, 'APA91bG5vpsWjCpyXBK1QdGMLT8H-7Uj0oqni5EhUEj5qiB4rNUKi6GHwyMZeJAxJK4Drsx70qHx9-LynNP4ul5SH6FUJEnIPoHgDx3kF53vsG5IWTxzHIUML8f0hZhqfx0WltKopCk4h89MJ50IMInJxjW3JZKwuw', NULL, NULL, NULL, NULL, '2014-03-19 07:51:49', NULL),
(60, 22, NULL, NULL, NULL, NULL, 'APA91bE8wup7njrPBIsxS5o7eGwrfSEHENZkSVdorzANAw0b1FmjfMqlE3MYDaW64ftpS3IxYE4hHoPpGxExcrsFLikEzEvpKhq-bTlhQTsa_5unS_IYWq3e0Kov-chamrvv0FiPvKXBB5PyfOa2cBXAXrKVkoaI9w', NULL, NULL, NULL, NULL, '2014-03-19 08:00:23', NULL),
(61, NULL, 2, NULL, NULL, NULL, 'APA91bFfyVgNaxZu-bcxyruLnO9rLTD7V8p_VM3rcAy3L6jPv2KytyhqfHeiAUDntYiQbJ-0xKotlzftmZu8H4XjC_hTKMteiLLq93y5LnemY2z0e2L6A2o4lSGgyHtRTSmU0xkL6drAn6HUzMSq-WnmFOGYYPRW_w', NULL, NULL, NULL, NULL, '2014-03-19 08:04:19', NULL),
(62, NULL, NULL, 12, NULL, NULL, 'APA91bFPOFUY36pcQn3_gcNhKr1k2svCs3gemdxvH2MsyObJzchnieqYgkYuF05ST7xpLyVnqGlpolbupBGwR1VrmnH3TBZs9WvfqEh77kUT5Fvg1IB6Yv66o_DSjJOL-abqKXECELOx7QEv0eU7Hm4bdfkmMchgWw', NULL, NULL, NULL, NULL, '2014-03-19 08:05:48', NULL),
(63, 21, NULL, NULL, NULL, NULL, 'APA91bFT_SGVFr2GymwMDjXG7U9oP0H3OKiQQ3D9X1xYtBbVJ62FGLnTaUVPzP3zEhUcc5hvhZQKX2ERHbz9qwlLqpX75HlBeoaytIjJFpQfMuraRcoBTSj99hdhxWQCBAckgL5tRzByB6s-iDgxdc57mdiHsSI_vg', NULL, NULL, NULL, NULL, '2014-03-19 23:30:16', NULL),
(64, 22, NULL, NULL, NULL, NULL, 'APA91bE8wup7njrPBIsxS5o7eGwrfSEHENZkSVdorzANAw0b1FmjfMqlE3MYDaW64ftpS3IxYE4hHoPpGxExcrsFLikEzEvpKhq-bTlhQTsa_5unS_IYWq3e0Kov-chamrvv0FiPvKXBB5PyfOa2cBXAXrKVkoaI9w', NULL, NULL, NULL, NULL, '2014-03-24 22:47:56', NULL),
(65, NULL, 2, NULL, NULL, NULL, 'APA91bFfyVgNaxZu-bcxyruLnO9rLTD7V8p_VM3rcAy3L6jPv2KytyhqfHeiAUDntYiQbJ-0xKotlzftmZu8H4XjC_hTKMteiLLq93y5LnemY2z0e2L6A2o4lSGgyHtRTSmU0xkL6drAn6HUzMSq-WnmFOGYYPRW_w', NULL, NULL, NULL, NULL, '2014-03-24 23:23:11', NULL),
(66, NULL, NULL, NULL, 132, NULL, 'APA91bHQKstMSFDo4BV63cyJpnEtckGahfYhnsaR-M1czVyUrXHh01i0e5FykEPVo48rz6TZBZ748LU2a4vgxF3e6uIz7KJWr51Hs8vEIEtN8B9bqRdVQRFl_f5eUq8d-nCOpnEe-KDJzAODHou4xKPtURo2Q-RWEg', NULL, NULL, NULL, NULL, '2014-03-25 08:46:32', NULL),
(67, NULL, NULL, 15, NULL, NULL, 'APA91bGfZMOkSKJ9DqNuMTmz2QrLCfnSfEHOJw8C6LgLcLOiUz2LeK7tQDuyC1UAytT7kcCWgfFFrmaHAdSVLST51H-YdtkOpKzEfmNd8PjnJDdaeJ4eTL4Dm1HITgVBkBLTkjOmpX_cWGqfgIuf_AfOCO5mYSjihA', NULL, NULL, NULL, NULL, '2014-03-25 14:47:19', NULL),
(68, NULL, 17, NULL, NULL, NULL, 'APA91bG-BLYf2mBLQqDwyW4yM3f2m0CfII2wE9XTgitY_7ZSdvbJprznGcGHsGyu28SXq_F4n1ehxEdd38Qa_PC5jEjaP9723f4paza-fn7StnvfZuP3POzqKHB-BO4toSNV3OSNIGADq9ZfinmoHuNpIRmRXo4Kaw', NULL, NULL, NULL, NULL, '2014-03-25 14:53:56', NULL),
(69, NULL, NULL, NULL, 147, NULL, 'APA91bEBkp6qqCKs56WonI2ru1ULoYw1aou-24XtKDpMv9pLJmSkVJPMFdTZSQzyCotzBIz3VJ5VerHirdgXPISjvrGZWMHIPM3t2_vGFNS8b0TMnczENWxwTXm-JncFyelt2SWG2110o1kpsFG4NrkTyWODq4Rb2w', NULL, NULL, NULL, NULL, '2014-03-25 16:00:14', NULL),
(70, NULL, 13, NULL, NULL, NULL, 'APA91bFrbUxOG8ZyD6W26YPpyTdpgyfds1_jyro4M2_BXOOvHoJEhURWgeYcteJ30tDRePBrS1n1_-HflQSkocBbxzH0paFkH5R86oYdBUTb-0Gt1yBxRwFy-L0qpz0MYtbfvPmSrQ8S-gIZFA84EUt7wmUYgsgYbg', NULL, NULL, NULL, NULL, '2014-04-11 17:38:30', NULL),
(71, NULL, NULL, 19, NULL, NULL, 'APA91bEm38cAghRQU6PNJ3VVWgLXmwUO-RXPJZgTsMVG4heLKe1fn0ddIXfCgmykScG12TTHMvEZ5sAm4GJ9XstkKxtNQJHLukxtB9ZSidh2nVot9jl1-y0ZALBjIhM_lAc7CjNIuvdAqPTLJA9ATwwt0QfSQHxbLQ', NULL, NULL, NULL, NULL, '2014-04-11 17:41:48', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `guardian`
--

CREATE TABLE `guardian` (
  `guardianID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `cellphone` varchar(50) NOT NULL,
  `dateRegistered` datetime NOT NULL,
  PRIMARY KEY (`guardianID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `guardianTrainee`
--

CREATE TABLE `guardianTrainee` (
  `guardianTraineeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `guardianID` int(10) unsigned NOT NULL,
  `traineeID` int(10) unsigned NOT NULL,
  `activeFlag` int(10) unsigned NOT NULL,
  PRIMARY KEY (`guardianTraineeID`),
  KEY `guardianID` (`guardianID`),
  KEY `traineeID` (`traineeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `helpRequest`
--

CREATE TABLE `helpRequest` (
  `helpRequestID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courseTraineeActivityID` int(10) unsigned DEFAULT NULL,
  `dateRequested` datetime NOT NULL,
  `comment` text,
  `helpTypeID` int(10) unsigned NOT NULL,
  `trainingClassID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`helpRequestID`),
  KEY `fdd` (`helpTypeID`),
  KEY `fddx` (`courseTraineeActivityID`),
  KEY `trainingClassID` (`trainingClassID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `helpRequest`
--

INSERT INTO `helpRequest` (`helpRequestID`, `courseTraineeActivityID`, `dateRequested`, `comment`, `helpTypeID`, `trainingClassID`) VALUES
(1, 29435, '2014-07-05 20:47:14', NULL, 3, 1),
(2, 29435, '2014-07-05 20:56:30', NULL, 3, 1),
(3, 29437, '2014-07-05 21:13:17', NULL, 9, 1),
(4, 29436, '2014-07-05 21:16:01', NULL, 6, 1),
(5, 29438, '2014-07-05 21:16:17', NULL, 5, 1),
(6, 29436, '2014-07-05 21:17:07', NULL, 2, 1),
(7, 29434, '2014-07-05 22:34:14', NULL, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `helpResponse`
--

CREATE TABLE `helpResponse` (
  `helpResponseID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `helpRequestID` int(10) unsigned NOT NULL,
  `message` text,
  `dateResponse` datetime DEFAULT NULL,
  `scheduleMeeting` int(10) unsigned DEFAULT NULL,
  `problemSorted` int(10) unsigned DEFAULT NULL,
  `meetingDate` datetime DEFAULT NULL,
  `instructorID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`helpResponseID`),
  KEY `helpRequestID` (`helpRequestID`),
  KEY `instructorID` (`instructorID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `helpType`
--

CREATE TABLE `helpType` (
  `helpTypeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `companyID` int(10) unsigned NOT NULL,
  `helpTypeName` varchar(100) NOT NULL,
  PRIMARY KEY (`helpTypeID`),
  UNIQUE KEY `index2` (`helpTypeName`),
  KEY `companyID` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `helpType`
--

INSERT INTO `helpType` (`helpTypeID`, `companyID`, `helpTypeName`) VALUES
(1, 1, 'I do not understand'),
(2, 1, 'I have network/WIFI problems'),
(3, 1, 'I have equipment problems'),
(4, 1, 'Code does not work'),
(5, 1, 'I have issues!'),
(6, 1, 'I Have Transportation Problems'),
(7, 1, 'I Have Health Issues'),
(8, 1, 'I Have Financial Issues'),
(9, 1, 'I Have Team Problems'),
(10, 1, 'I Have Run Out Of Time');

-- --------------------------------------------------------

--
-- Table structure for table `institution`
--

CREATE TABLE `institution` (
  `institutionID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `institutionName` varchar(100) NOT NULL,
  `cityID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`institutionID`),
  KEY `fkcit` (`cityID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `instructorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cellphone` varchar(45) NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `cityID` int(10) unsigned NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `companyID` int(10) unsigned NOT NULL,
  `activeFlag` int(11) DEFAULT '0',
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
(12, 'Ronnelle', 'Makhubela', 'aubrey@mlab.co.za', '0125668899', '2013-11-17 23:54:46', 1, 'exqd$583', 1, 0, NULL, NULL),
(13, 'Gwen Marianne', 'Ramokgopa', 'malengatiger@gmail.com', '0712193543', '2013-11-18 00:08:46', 1, 'dgpl#382', 1, 0, NULL, NULL),
(14, 'Tsietsi Frank', 'Malenga', 'tsietsi.m@gmail.com', '0856699898', '2014-02-16 19:48:17', 1, NULL, 1, 0, NULL, NULL),
(15, 'Obakeng ', 'Matlhoko', 'obby.matlhoko@gmail.com', '0844685723', '2014-02-16 20:12:55', 1, 'ssdr#354', 1, 0, NULL, NULL),
(16, 'Aubrey', 'Malabie', 'aubrey.malabie@gmail.com', '0712193543', '2014-02-16 20:20:01', 1, 'bxuf@417', 1, 0, NULL, NULL),
(17, 'Joey', 'Charles', 'cjchar@gmail.com', '0996653232', '2014-02-26 22:21:15', 2, 'kdxf@745', 25, 0, NULL, NULL),
(18, 'Aubrey', 'Malabie', 'instructor.m@gmail.com', '0712195623', '2014-02-28 05:55:47', 2, 'tmms@214', 27, 0, NULL, NULL),
(19, 'Rulani', 'Nevhufumba', 'rulani@mlab.co.za', '0760940604', '2014-03-12 10:28:07', 2, 'r123', 28, 0, NULL, NULL),
(20, 'Mixo', 'Ngoveni', '4otune@gmail.com', '0736521188', '2014-03-12 10:46:19', 2, ' ', 28, 0, NULL, NULL),
(21, 'Khathu', 'Mulalo', 'rulanho@gmail.com', '0821234567', '2014-03-12 17:53:00', 2, ' ', 28, 0, NULL, NULL),
(22, 'Jonathan', 'Zinstructor', 'zins.j@gmail.com', '0885562233', '2014-03-15 23:57:03', 1, ' ', 1, 0, NULL, NULL),
(24, 'Melvin', 'Hackersen', 'mel.hack@gmail.com', '0996639966', '2014-03-19 10:21:01', 1, 'thka$528', 1, 0, NULL, NULL),
(25, 'Test 1.1', 'Instructor 1.1', 'instructor1@gmail.com', '0125694578', '2014-03-31 23:40:34', 1, NULL, 1, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `instructorClass`
--

CREATE TABLE `instructorClass` (
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

-- --------------------------------------------------------

--
-- Table structure for table `instructorRating`
--

CREATE TABLE `instructorRating` (
  `instructorRatingID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `instructorID` int(10) unsigned NOT NULL,
  `courseTraineeActivityID` int(10) unsigned NOT NULL,
  `dateUpdated` datetime NOT NULL,
  `ratingID` int(10) unsigned NOT NULL,
  `comment` text,
  `completedFlag` int(11) DEFAULT NULL,
  PRIMARY KEY (`instructorRatingID`),
  KEY `ix90` (`instructorID`),
  KEY `ix91` (`courseTraineeActivityID`),
  KEY `ix92` (`ratingID`),
  KEY `fk91` (`courseTraineeActivityID`),
  KEY `fk92` (`ratingID`),
  KEY `fk93` (`instructorID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=490 ;

--
-- Dumping data for table `instructorRating`
--

INSERT INTO `instructorRating` (`instructorRatingID`, `instructorID`, `courseTraineeActivityID`, `dateUpdated`, `ratingID`, `comment`, `completedFlag`) VALUES
(460, 16, 29354, '2014-07-02 12:47:21', 1, NULL, 0),
(461, 16, 29354, '2014-07-02 12:48:38', 2, NULL, 1),
(462, 16, 29355, '2014-07-03 07:51:35', 1, NULL, 1),
(463, 16, 29356, '2014-07-03 08:32:10', 4, NULL, 1),
(464, 16, 29359, '2014-07-03 08:34:30', 2, NULL, 1),
(465, 16, 29360, '2014-07-03 08:34:58', 1, NULL, 1),
(466, 16, 29364, '2014-07-03 08:44:39', 1, NULL, 1),
(467, 16, 29365, '2014-07-03 08:50:45', 1, NULL, 1),
(468, 16, 29369, '2014-07-03 09:00:44', 1, NULL, 1),
(469, 16, 29357, '2014-07-03 10:11:14', 1, NULL, 1),
(470, 16, 29374, '2014-07-03 10:31:32', 2, NULL, 1),
(471, 16, 29375, '2014-07-03 10:31:47', 2, NULL, 1),
(472, 16, 29384, '2014-07-03 10:36:11', 1, NULL, 1),
(473, 16, 29385, '2014-07-03 10:36:27', 2, NULL, 1),
(474, 16, 29389, '2014-07-03 10:45:19', 1, NULL, 1),
(475, 16, 29379, '2014-07-03 20:10:05', 3, NULL, 1),
(476, 16, 29380, '2014-07-03 20:10:31', 2, NULL, 1),
(477, 16, 29381, '2014-07-03 20:11:55', 2, NULL, 1),
(478, 16, 29376, '2014-07-03 20:58:34', 1, NULL, 1),
(479, 16, 29374, '2014-07-03 22:17:43', 3, NULL, 1),
(480, 16, 29378, '2014-07-03 22:19:01', 2, NULL, 1),
(481, 16, 29434, '2014-07-05 21:20:24', 2, NULL, 1),
(482, 16, 29435, '2014-07-05 21:20:45', 2, NULL, 1),
(483, 16, 29435, '2014-07-05 22:38:17', 1, NULL, 1),
(484, 16, 29494, '2014-07-05 22:39:32', 1, NULL, 1),
(485, 16, 29358, '2014-07-05 22:54:14', 2, NULL, 1),
(486, 16, 29495, '2014-07-05 22:55:27', 4, NULL, 1),
(487, 16, 29496, '2014-07-05 22:55:46', 2, NULL, 1),
(488, 16, 29509, '2014-07-05 23:06:11', 4, NULL, 1),
(489, 16, 29510, '2014-07-06 00:38:09', 1, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
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

-- --------------------------------------------------------

--
-- Table structure for table `lessonResource`
--

CREATE TABLE `lessonResource` (
  `lessonResourceID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courseID` int(10) unsigned NOT NULL,
  `url` varchar(255) NOT NULL,
  `dateUpdated` datetime NOT NULL,
  `resourceName` varchar(255) DEFAULT NULL,
  `authorID` int(10) unsigned DEFAULT NULL,
  `traineeID` int(10) unsigned DEFAULT NULL,
  `instructorID` int(10) unsigned DEFAULT NULL,
  `localID` bigint(20) DEFAULT NULL,
  `syncDate` datetime DEFAULT NULL,
  PRIMARY KEY (`lessonResourceID`),
  KEY `index5` (`authorID`),
  KEY `index6` (`traineeID`),
  KEY `index7` (`instructorID`),
  KEY `fktrain` (`traineeID`),
  KEY `fkauth` (`authorID`),
  KEY `fkinst` (`instructorID`),
  KEY `courseID` (`courseID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=113 ;

--
-- Dumping data for table `lessonResource`
--

INSERT INTO `lessonResource` (`lessonResourceID`, `courseID`, `url`, `dateUpdated`, `resourceName`, `authorID`, `traineeID`, `instructorID`, `localID`, `syncDate`) VALUES
(110, 26, 'https://cloud.google.com/', '2014-06-30 15:35:33', 'Cloud Computing & Cloud Hosting Services â?? Google Cloud Platform â?? Google Cloud Platform', NULL, NULL, NULL, 0, NULL),
(111, 26, 'http://techcrunch.com/2014/06/25/googles-cloud-platform-gets-new-tools-for-monitoring-and-debugging-apps/', '2014-06-30 15:36:41', 'Googleâ??s Cloud Platform Gets New Tools For Monitoring And Debugging Apps | TechCrunch', NULL, NULL, NULL, 0, NULL),
(112, 26, 'http://en.m.wikipedia.org/wiki/Google_Cloud_Platform', '2014-06-30 15:37:37', 'Google Cloud Platform - Wikipedia, the free encyclopedia', NULL, NULL, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lessonSchedule`
--

CREATE TABLE `lessonSchedule` (
  `lessonScheduleID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `trainingClassID` int(10) unsigned DEFAULT NULL,
  `activityID` int(10) unsigned DEFAULT NULL,
  `scheduleDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  PRIMARY KEY (`lessonScheduleID`),
  KEY `ixll0` (`trainingClassID`),
  KEY `fkllx` (`activityID`),
  KEY `lessact` (`activityID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `objective`
--

CREATE TABLE `objective` (
  `objectiveID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courseID` int(10) unsigned NOT NULL,
  `objectiveName` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`objectiveID`),
  KEY `courseID` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `provinceID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `countryID` int(10) unsigned DEFAULT NULL,
  `provinceName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`provinceID`),
  UNIQUE KEY `index3` (`countryID`,`provinceName`),
  KEY `ix88` (`countryID`),
  KEY `fg008` (`countryID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`provinceID`, `countryID`, `provinceName`) VALUES
(9, 3, 'Eastern Cape'),
(5, 3, 'Free State'),
(3, 3, 'Gauteng'),
(4, 3, 'Kwa Zulu Natal'),
(1, 3, 'Limpopo'),
(6, 3, 'Mpumalanga'),
(7, 3, 'North West'),
(2, 3, 'Northern Cape'),
(8, 3, 'Western Cape');

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `ratingID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ratingName` varchar(50) DEFAULT NULL,
  `ratingNumber` int(11) DEFAULT NULL,
  `companyID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ratingID`),
  UNIQUE KEY `ix211` (`ratingName`),
  KEY `companyID` (`companyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`ratingID`, `ratingName`, `ratingNumber`, `companyID`) VALUES
(1, 'Very Good (80)', 80, 1),
(2, 'Excellent (100)', 100, 1),
(3, 'Fair (40)', 40, 1),
(4, 'Good (60)', 60, 1),
(5, 'Poor (20)', 20, 1),
(6, 'Did Not Present (0)', 0, 1),
(7, 'Beyond The Call Of Duty', 125, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reportUser`
--

CREATE TABLE `reportUser` (
  `reportUserID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `dateRegistered` datetime DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `GCMRegistrationID` text,
  PRIMARY KEY (`reportUserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `teamID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `teamName` varchar(255) NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `trainingClassID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`teamID`),
  UNIQUE KEY `trainingClassID_2` (`trainingClassID`,`teamName`),
  KEY `trainingClassID` (`trainingClassID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`teamID`, `teamName`, `dateRegistered`, `trainingClassID`) VALUES
(2, 'Holistic Hackers', '2014-07-05 17:38:05', 1),
(4, 'Jabula Coders', '2014-07-05 17:39:32', 1);

-- --------------------------------------------------------

--
-- Table structure for table `teamMember`
--

CREATE TABLE `teamMember` (
  `teamMemberID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `teamID` int(10) unsigned NOT NULL,
  `traineeID` int(10) unsigned NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `activeFlag` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`teamMemberID`),
  UNIQUE KEY `teamID_2` (`teamID`,`traineeID`),
  KEY `teamID` (`teamID`),
  KEY `traineeID` (`traineeID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `teamMember`
--

INSERT INTO `teamMember` (`teamMemberID`, `teamID`, `traineeID`, `dateRegistered`, `activeFlag`) VALUES
(2, 2, 117, '2014-07-05 17:38:05', 0),
(3, 4, 117, '2014-07-05 17:39:32', 0),
(4, 2, 115, '2014-07-05 17:40:44', 0),
(5, 2, 87, '2014-07-05 18:04:14', 0),
(6, 2, 95, '2014-07-05 18:04:33', 0),
(7, 2, 152, '2014-07-05 18:23:57', 0),
(8, 2, 92, '2014-07-05 18:28:04', 0),
(9, 4, 89, '2014-07-05 18:32:39', 0),
(10, 4, 25, '2014-07-05 18:32:56', 0),
(11, 2, 86, '2014-07-05 18:49:10', 0),
(12, 2, 118, '2014-07-05 18:49:57', 0);

-- --------------------------------------------------------

--
-- Table structure for table `trainee`
--

CREATE TABLE `trainee` (
  `traineeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `middleName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cellphone` varchar(45) NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `gender` int(10) unsigned DEFAULT NULL,
  `institutionID` int(10) unsigned DEFAULT NULL,
  `companyID` int(10) unsigned DEFAULT NULL,
  `IDNumber` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `cityID` int(10) unsigned NOT NULL,
  `trainingClassID` int(10) unsigned DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `activeFlag` int(11) unsigned DEFAULT '0',
  `administratorID` int(10) unsigned DEFAULT NULL,
  `GCMRegistrationID` text,
  `dateUpdated` datetime DEFAULT NULL,
  PRIMARY KEY (`traineeID`),
  UNIQUE KEY `email` (`email`),
  KEY `ix004` (`institutionID`),
  KEY `fk004` (`institutionID`),
  KEY `fk004a` (`companyID`),
  KEY `ix004C` (`cityID`),
  KEY `fk004c` (`cityID`),
  KEY `ix004D` (`trainingClassID`),
  KEY `fk004D` (`trainingClassID`),
  KEY `ix004ff` (`administratorID`),
  KEY `fk004xx` (`administratorID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=158 ;

--
-- Dumping data for table `trainee`
--

INSERT INTO `trainee` (`traineeID`, `firstName`, `middleName`, `lastName`, `email`, `cellphone`, `dateRegistered`, `gender`, `institutionID`, `companyID`, `IDNumber`, `address`, `cityID`, `trainingClassID`, `password`, `activeFlag`, `administratorID`, `GCMRegistrationID`, `dateUpdated`) VALUES
(25, 'Barack Hussein', NULL, 'Obama', 'barack123@gmail.com', '0778556633', '2013-10-21 15:37:49', 1, NULL, 1, NULL, NULL, 1, 1, 'dev', 0, NULL, NULL, NULL),
(86, 'William T', NULL, 'Maluleke', 'William.Maluleke1@gmail.com', '0828006369', '2013-10-24 01:44:56', 1, NULL, 1, NULL, NULL, 3, 1, 'trainee', 0, NULL, NULL, NULL),
(87, 'Omar James', NULL, 'Black', 'Omar.Black2@gmail.com', '0999990000', '2013-10-24 01:45:02', 1, NULL, 1, NULL, NULL, 2, 1, 'trainee', 0, NULL, NULL, NULL),
(88, 'Samuel', NULL, 'Zulu', 'Samuel.Zulu3@gmail.com', '0999990000', '2013-10-24 01:45:03', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', 0, NULL, NULL, NULL),
(89, 'Bobby', NULL, 'Ringane', 'Bobby.Ringane4@gmail.com', '0999990000', '2013-10-24 01:45:04', 1, NULL, 1, NULL, NULL, 2, 1, 'trainee', 0, NULL, NULL, NULL),
(90, 'Bakithi', NULL, 'Ngobeni', 'Bakithi.Ngobeni5@gmail.com', '0999990000', '2013-10-24 01:45:04', 1, NULL, 1, NULL, NULL, 3, 1, 'trainee', 0, NULL, NULL, NULL),
(91, 'Jean', NULL, 'Venter', 'Jean.Venter6@gmail.com', '0999990000', '2013-10-24 01:45:05', 2, NULL, 1, NULL, NULL, 1, 1, 'trainee', 0, NULL, NULL, NULL),
(92, 'Bennie Bam', NULL, 'Mathebula', 'Bennie.Mathebula7@gmail.com', '0999990000', '2013-10-24 01:45:05', 1, NULL, 1, NULL, NULL, 2, 1, 'trainee', 0, NULL, NULL, NULL),
(93, 'Robert', NULL, 'Phiri', 'Robert.Phiri8@gmail.com', '0999990000', '2013-10-24 01:45:06', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', 0, NULL, NULL, NULL),
(94, 'Obakeng', NULL, 'Nkosi', 'Obakeng.Nkosi9@gmail.com', '0999990000', '2013-10-24 01:45:06', 1, NULL, 1, NULL, NULL, 2, 1, 'trainee', 0, NULL, NULL, NULL),
(95, 'Robert S', NULL, 'Bodibe', 'Robert.Bodibe10@gmail.com', '0999990000', '2013-10-24 01:45:07', 1, NULL, 1, NULL, NULL, 3, 1, 'trainee', 0, NULL, NULL, NULL),
(96, 'Harry Charles', NULL, 'Ntemi', 'Harry.Ntemi11@gmail.com', '0999990000', '2013-10-24 01:45:08', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', 0, NULL, NULL, NULL),
(97, 'Jack Daniel', NULL, 'Ntemi', 'Jack.Ntemi12@gmail.com', '0999990000', '2013-10-24 01:45:08', 1, NULL, 1, NULL, NULL, 3, 1, 'trainee', 0, NULL, NULL, NULL),
(98, 'MacDonald', NULL, 'Thobane', 'macDonald.thobane13@gmail.com', '0999990000', '2013-10-24 01:45:09', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', 0, NULL, NULL, NULL),
(99, 'Sipho', NULL, 'Ringane', 'Sipho.Ringane14@gmail.com', '0999990000', '2013-10-24 01:45:10', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', 0, NULL, NULL, NULL),
(100, 'Shane', NULL, 'Gray', 'Shane.Gray1@gmail.com', '0999990000', '2013-10-24 02:05:23', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(101, 'Mark', NULL, 'Gray', 'Mark.Gray2@gmail.com', '0999990000', '2013-10-24 02:05:25', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(102, 'Noonan', NULL, 'Ngwenya', 'Noonan.Ngwenya3@gmail.com', '0999990000', '2013-10-24 02:05:26', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(103, 'Vusi', NULL, 'Ntemi', 'Vusi.Ntemi4@gmail.com', '0999990000', '2013-10-24 02:05:27', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(104, 'Bakithi', NULL, 'Thobela', 'Bakithi.Thobela5@gmail.com', '0999990000', '2013-10-24 02:05:28', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(105, 'Oupa', NULL, 'Ntemi', 'Oupa.Ntemi6@gmail.com', '0999990000', '2013-10-24 02:05:29', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(106, 'Jonty', NULL, 'Fumani', 'Jonty.Fumani7@gmail.com', '0999990000', '2013-10-24 02:05:30', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(107, 'Jeremiah', NULL, 'Maleho', 'Jeremiah.Maleho8@gmail.com', '0999990000', '2013-10-24 02:05:31', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(108, 'Andrew', NULL, 'Marule', 'Andrew.Marule9@gmail.com', '0999990000', '2013-10-24 02:05:32', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(109, 'Johnny', NULL, 'Thobela', 'Johnny.Thobela10@gmail.com', '0999990000', '2013-10-24 02:05:33', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(110, 'Newton', NULL, 'Ringane', 'Newton.Ringane11@gmail.com', '0999990000', '2013-10-24 02:05:34', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(111, 'Caleb', NULL, 'Bodibe', 'Caleb.Bodibe12@gmail.com', '0999990000', '2013-10-24 02:05:35', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(112, 'McLean', NULL, 'Ringane', 'McLean.Ringane13@gmail.com', '0999990000', '2013-10-24 02:05:36', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(113, 'Jerry', NULL, 'Bala', 'Jerry.Bala14@gmail.com', '0999990000', '2013-10-24 02:05:37', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', 0, NULL, NULL, NULL),
(115, 'Cheri', NULL, 'Bamuza-Smith', 'someemail@gmail.com', '0712196532', '2013-11-18 00:23:26', 2, NULL, 1, NULL, NULL, 3, 1, 'dev', 0, NULL, NULL, NULL),
(117, 'Tiger', NULL, 'Malabie', 'aubrey.malabie@gmail.com', '0712193543', '2013-11-18 15:58:27', 1, NULL, 1, '8802035660085', '30 Kingfisher Drive, Pecanwood', 136, 1, 'kktiger3', 0, NULL, NULL, '2014-03-15 16:21:52'),
(118, 'Portia ', NULL, 'Marule-Thamage', 'info.bohatmx@gmail.com', '0712193543', '2013-11-18 16:02:39', 2, NULL, 1, NULL, NULL, 2, 1, 'dev', 0, NULL, NULL, NULL),
(119, 'Mmaphefo', NULL, 'Nkuna', 'mmaphefo@gmail.com', '085663321', '2014-02-16 02:25:49', 2, NULL, 1, NULL, NULL, 2, 3, NULL, 0, NULL, NULL, NULL),
(120, 'Franklin', NULL, 'Bamuza', 'franklin.b@gmail.com', '0824111122', '2014-02-16 02:40:58', 1, NULL, 1, NULL, NULL, 2, 3, NULL, 0, NULL, NULL, NULL),
(121, 'Jonathan', NULL, 'Dlamani', 'malengax@gmail.com', '0712335566', '2014-02-16 02:47:53', 1, NULL, 1, NULL, NULL, 2, 3, 'vmhg#572', 0, NULL, NULL, NULL),
(124, 'Aubrey', NULL, 'Nkosi-Smythe', 'aubrey@mlab.co.za', '0712193544', '2014-02-16 03:14:34', 1, NULL, 1, NULL, NULL, 2, 3, 'hshn@466', 0, NULL, NULL, NULL),
(125, 'Robert', NULL, 'Malenga', 'robet@gmail.com', '0784452211', '2014-02-26 22:19:51', 1, NULL, 25, NULL, NULL, 2, 12, 'fama$767', 0, NULL, NULL, NULL),
(126, 'Joanne', NULL, 'Mngadi', 'j.mngadi@gmail.com', '0896653322', '2014-02-27 08:45:06', 2, NULL, 25, NULL, NULL, 3, 12, 'ndba$282', 0, NULL, NULL, NULL),
(127, 'Abram', NULL, 'Chauke', 'abramchauke@gmail.com', '0875523636', '2014-02-27 12:25:24', 1, NULL, 25, NULL, NULL, 3, 14, 'bnss#321', 0, NULL, NULL, NULL),
(129, 'Thokozile', NULL, 'Majola-Snyder', 'thokozile.mse@gmail.com', '0875523636', '2014-02-27 12:30:15', 2, NULL, 25, NULL, NULL, 1, 19, 'yryl$255', 0, NULL, NULL, NULL),
(130, 'Ellen', NULL, 'Bodibe', 'ebodibe.m@gmail.com', '0825663236', '2014-02-27 21:21:33', 2, NULL, 27, NULL, NULL, 3, 22, 'adsb#156', 0, NULL, NULL, NULL),
(131, 'Daniel', NULL, 'Khoza', 'dkhoza.m@gmail.com', '0825559999', '2014-02-28 05:54:27', 1, NULL, 27, NULL, NULL, 2, 20, 'wxfk@411', 0, NULL, NULL, NULL),
(132, 'Aubrey', NULL, 'Maluleke', 'malengadev@gmail.com', '0986653322', '2014-03-01 06:39:16', 1, NULL, 1, NULL, NULL, 3, 3, 'fyjp$685', 0, NULL, NULL, NULL),
(133, 'Jacques', NULL, 'Venter', 'jac.vm@gmail.com', '0825586969', '2014-03-03 07:13:16', 1, NULL, 1, NULL, NULL, 2, 4, 'esyw$686', 0, NULL, NULL, NULL),
(134, 'Wendy Wench', NULL, 'Weir', 'wendysweir.c@gmail.com', '0774441112', '2014-03-03 07:38:47', 2, NULL, 1, NULL, NULL, 3, 4, 'yylx@667', 0, NULL, NULL, NULL),
(135, 'Maria', NULL, 'Mathebula', 'm.mathebu@gmail.com', '0885656569', '2014-03-03 07:40:55', 2, NULL, 1, NULL, NULL, 1, 4, 'pugs@443', 0, NULL, NULL, NULL),
(136, 'Jennifer', NULL, 'Zondi', 'jenn.zo@gmail.com', '099885632', '2014-03-03 07:42:20', 2, NULL, 1, NULL, NULL, 1, 4, 'sdrw$588', 0, NULL, NULL, NULL),
(137, 'Jackson Mthembu', NULL, 'Bala', 'jacksob.mthembu@gmail.com', '0774552121', '2014-03-09 13:39:48', 1, NULL, 1, NULL, NULL, 3, 1, 'qwmv$746', 0, NULL, NULL, NULL),
(138, 'Sipho', NULL, 'Xaba', 'rulanho@gmail.com', '0761234567', '2014-03-12 16:27:20', 1, NULL, 28, NULL, NULL, 3, 25, 'gabf$146', 0, NULL, NULL, NULL),
(139, 'Jonathan', NULL, 'Zuckerberg', 'zuck.j@gmail.com', '0889963322', '2014-03-15 18:32:36', 1, NULL, 1, NULL, NULL, 54, 1, NULL, 0, NULL, NULL, NULL),
(140, 'Bokgabane', NULL, 'Thamae', 'bokgabane@gmail.com', '0996635252', '2014-03-15 18:33:57', 2, NULL, 1, NULL, NULL, 39, 1, 'dev', 0, 1, NULL, NULL),
(141, 'Rulani', NULL, 'Nevhufumba', 'rulani@mlab.co.za', '0831476982', '2014-03-17 12:58:17', 1, NULL, 28, NULL, NULL, 8, 25, 'jswv@766', 0, NULL, NULL, NULL),
(142, 'Tshiwela', NULL, 'Tshivhasa', 'tshiwela@gmail.com', '0720846312', '2014-03-17 13:00:20', 2, NULL, 28, NULL, NULL, 33, 25, NULL, 0, NULL, NULL, NULL),
(143, 'Christiaan', NULL, 'Tshilenga', 'tctshilenga@passriview.co.za', '0831234567', '2014-03-17 13:10:24', 1, NULL, 28, NULL, NULL, 95, 26, NULL, 0, NULL, NULL, NULL),
(144, 'Helen', NULL, 'Booysen', 'biioo@gmail.com', '0845552322', '2014-03-19 09:51:09', 2, NULL, 1, NULL, NULL, 248, 6, 'xhpr$847', 0, NULL, NULL, NULL),
(145, 'Desiree', NULL, 'Bopape', 'desiree.bop@gmail.com', '0845552322', '2014-03-19 10:10:56', 2, NULL, 1, NULL, NULL, 254, 6, 'trfs$272', 0, NULL, NULL, NULL),
(146, 'Daniella', NULL, 'Bamuza', 'dan.bsm@gmsil.com', '099666335', '2014-03-19 10:47:21', 2, NULL, 1, NULL, NULL, 15, 6, 'ugja#468', 0, NULL, NULL, NULL),
(147, 'Obakeng ', NULL, 'Matlhoko', 'obby.matlhoko@gmail.com', '0844685723', '2014-03-25 15:26:08', 1, NULL, 1, NULL, NULL, 19, 3, 'ygpv$631', 0, NULL, NULL, NULL),
(148, 'Test', NULL, 'Trainee', 'info@sowertech.com', '0817366150', '2014-03-31 09:41:35', 2, NULL, 1, NULL, NULL, 277, 28, 'cdvx$853', 0, NULL, NULL, NULL),
(151, 'Test 2.1', NULL, 'Trainee 2.1', 'train@gmail.com', '0113942434', '2014-03-31 22:53:18', 1, NULL, 1, NULL, NULL, 2, 29, 'vcfq$785', 0, NULL, NULL, NULL),
(152, 'Bryan', NULL, 'Malabie', 'tiger.malenga@gmail.com', '0712193543', '2014-07-04 11:13:44', 1, NULL, 1, NULL, NULL, 2, 1, 'dmxq@773', 0, NULL, NULL, NULL),
(153, 'Frankie', NULL, 'Abalone', 'malengatiger@gmail.com', '0889996633', '2014-07-04 11:32:15', 1, NULL, 1, NULL, NULL, 2, 1, 'nnjv#318', 0, NULL, NULL, NULL),
(155, 'Qwerty', NULL, 'Trainee Smith', 'qwerty@gmail.com', '5689908552', '2014-07-04 18:25:42', 1, NULL, 1, NULL, NULL, 161, 1, 'uxxq@161', 0, NULL, NULL, NULL),
(156, 'Zachary', NULL, 'Zuckerberg', 'zuckz.zu@suckz.zu', '08896633', '2014-07-04 19:37:01', 1, NULL, 1, NULL, NULL, 47, 1, 'yxfe$721', 0, NULL, NULL, NULL),
(157, 'Thelma Louise', NULL, 'Charlestown', 'thelm@fgh.com', '8558996655', '2014-07-04 19:39:23', 2, NULL, 1, NULL, NULL, 16, 1, 'whct$515', 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `traineeEquipment`
--

CREATE TABLE `traineeEquipment` (
  `traineeEquipmentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `traineeID` int(10) unsigned NOT NULL,
  `inventoryID` int(10) unsigned NOT NULL,
  `dateRegistered` datetime DEFAULT NULL,
  `dateReturned` datetime DEFAULT NULL,
  `conditionFlag` int(11) DEFAULT NULL,
  `administratorID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`traineeEquipmentID`),
  KEY `ixtr` (`traineeID`),
  KEY `ixeq` (`inventoryID`),
  KEY `fkadm` (`administratorID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=100 ;

--
-- Dumping data for table `traineeEquipment`
--

INSERT INTO `traineeEquipment` (`traineeEquipmentID`, `traineeID`, `inventoryID`, `dateRegistered`, `dateReturned`, `conditionFlag`, `administratorID`) VALUES
(1, 92, 23, '2014-02-22 03:12:06', '2014-02-22 14:26:42', 0, 1),
(2, 117, 23, '2014-02-22 03:15:16', '2014-02-22 14:29:45', 0, 1),
(3, 115, 23, '2014-02-22 10:41:50', '2014-02-22 14:33:44', 0, 1),
(4, 124, 23, '2014-02-22 10:59:45', '2014-02-22 14:35:33', 0, 1),
(5, 86, 23, '2014-02-22 11:12:57', '2014-02-22 15:10:43', 0, 1),
(6, 87, 23, '2014-02-22 15:14:04', '2014-02-22 15:28:15', 0, 1),
(7, 87, 23, '2014-02-22 15:27:42', '2014-02-22 17:09:51', 0, 1),
(8, 117, 1, '2014-02-22 16:45:18', '2014-02-22 16:46:04', 0, 1),
(9, 25, 1, '2014-02-22 16:46:19', '2014-02-22 16:52:49', 0, 1),
(10, 118, 3, '2014-02-22 16:53:38', '2014-02-22 16:54:37', 1, 1),
(11, 93, 3, '2014-02-22 16:55:09', '2014-02-22 23:40:39', 0, 1),
(12, 95, 1, '2014-02-22 16:56:03', '2014-02-22 23:39:20', 1, 1),
(13, 115, 2, '2014-02-22 16:56:28', '2014-02-22 23:40:02', 0, 1),
(14, 94, 4, '2014-02-22 16:57:08', '2014-02-22 23:41:47', 1, 1),
(15, 97, 6, '2014-02-22 16:57:38', '2014-02-22 23:45:16', 0, 1),
(16, 99, 7, '2014-02-22 16:58:04', '2014-02-22 16:59:41', 0, 1),
(17, 117, 9, '2014-02-22 16:58:41', NULL, NULL, 1),
(18, 96, 8, '2014-02-22 16:59:12', '2014-02-22 23:38:41', 0, 1),
(19, 91, 7, '2014-02-22 17:00:12', '2014-02-22 23:42:26', 0, 1),
(20, 87, 23, '2014-02-22 17:09:57', '2014-02-22 17:10:39', 0, 1),
(21, 92, 23, '2014-02-22 17:11:05', '2014-02-23 14:03:47', 0, 1),
(22, 98, 24, '2014-02-22 17:16:13', '2014-02-22 17:16:25', 0, 1),
(23, 88, 24, '2014-02-22 17:16:43', '2014-02-22 17:17:05', 0, 1),
(24, 115, 24, '2014-02-22 17:17:26', '2014-02-24 02:08:09', 0, 1),
(25, 99, 17, '2014-02-22 19:37:27', '2014-02-24 02:17:18', 0, 1),
(26, 117, 18, '2014-02-22 19:37:56', '2014-02-24 01:02:25', 0, 1),
(27, 87, 19, '2014-02-22 19:38:17', '2014-02-24 02:17:52', 0, 1),
(28, 25, 20, '2014-02-22 19:38:41', '2014-02-24 02:11:10', 0, 1),
(29, 88, 21, '2014-02-22 19:39:13', '2014-02-23 13:59:26', 0, 1),
(30, 91, 22, '2014-02-22 19:39:37', '2014-02-24 02:10:32', 0, 1),
(31, 87, 8, '2014-02-22 23:38:54', '2014-02-22 23:43:11', 0, 1),
(32, 118, 1, '2014-02-22 23:39:37', NULL, NULL, 1),
(33, 90, 2, '2014-02-22 23:40:19', NULL, NULL, 1),
(34, 98, 3, '2014-02-22 23:40:58', NULL, NULL, 1),
(35, 91, 4, '2014-02-22 23:42:01', NULL, NULL, 1),
(36, 86, 7, '2014-02-22 23:42:40', '2014-02-23 07:49:26', 0, 1),
(37, 92, 8, '2014-02-22 23:43:24', NULL, NULL, 1),
(38, 118, 25, '2014-02-23 07:14:59', '2014-02-23 16:12:36', 0, 1),
(39, 115, 26, '2014-02-23 07:15:31', '2014-02-23 14:44:54', 0, 1),
(40, 95, 27, '2014-02-23 07:15:57', '2014-02-23 15:22:59', 0, 1),
(41, 98, 28, '2014-02-23 07:16:28', '2014-02-23 15:06:53', 0, 1),
(42, 25, 7, '2014-02-23 07:49:40', '2014-02-23 13:30:31', 1, 1),
(43, 117, 7, '2014-02-23 13:31:00', NULL, NULL, 1),
(44, 118, 21, '2014-02-23 13:59:44', '2014-02-23 14:31:28', 0, 1),
(45, 115, 21, '2014-02-23 14:31:54', '2014-02-24 02:18:28', 0, 1),
(46, 87, 26, '2014-02-23 14:45:12', '2014-02-23 14:57:05', 0, 1),
(47, 117, 28, '2014-02-23 15:07:17', '2014-02-24 02:19:36', 0, 1),
(48, 89, 27, '2014-02-23 15:23:31', '2014-02-23 15:52:34', 0, 1),
(49, 118, 27, '2014-02-23 15:52:57', '2014-02-24 02:19:59', 0, 1),
(50, 117, 30, '2014-02-23 15:54:20', '2014-02-24 01:00:29', 0, 1),
(51, 90, 29, '2014-02-23 15:55:37', '2014-02-24 00:59:09', 0, 1),
(52, 91, 25, '2014-02-23 16:12:53', '2014-02-24 01:16:50', 0, 1),
(53, 93, 29, '2014-02-24 00:59:27', '2014-02-24 02:19:13', 0, 1),
(54, 118, 30, '2014-02-24 01:00:49', '2014-02-24 02:09:21', 0, 1),
(55, 92, 18, '2014-02-24 01:02:41', '2014-02-24 02:16:42', 0, 1),
(56, 98, 25, '2014-02-24 01:17:01', '2014-02-24 02:20:41', 0, 1),
(57, 124, 24, '2014-02-24 02:08:25', '2014-02-24 02:21:22', 0, 1),
(58, 87, 30, '2014-02-24 02:09:41', '2014-02-24 02:18:56', 0, 1),
(59, 119, 22, '2014-02-24 02:10:46', '2014-02-24 02:21:58', 0, 1),
(60, 86, 23, '2014-02-24 02:11:54', '2014-02-24 02:22:21', 0, 1),
(61, 92, 17, '2014-02-24 02:23:00', NULL, NULL, 1),
(62, 87, 18, '2014-02-24 02:23:23', NULL, NULL, 1),
(63, 95, 19, '2014-02-24 02:23:53', NULL, NULL, 1),
(64, 115, 20, '2014-02-24 02:24:27', '2014-03-17 16:34:37', 0, 1),
(65, 99, 21, '2014-02-24 02:25:14', '2014-02-25 07:40:15', 0, 1),
(66, 91, 22, '2014-02-24 02:25:46', '2014-03-17 02:11:04', 0, 1),
(67, 117, 23, '2014-02-24 02:26:26', '2014-02-24 20:29:21', 0, 1),
(68, 118, 24, '2014-02-24 02:27:00', '2014-02-25 22:51:58', 0, 1),
(69, 90, 25, '2014-02-24 02:27:33', '2014-02-24 20:30:03', 0, 1),
(70, 89, 26, '2014-02-24 02:28:21', '2014-03-26 22:36:44', 0, 1),
(71, 88, 27, '2014-02-24 02:28:50', '2014-03-15 02:13:58', 0, 1),
(72, 96, 28, '2014-02-24 02:29:21', '2014-03-15 02:28:58', 0, 1),
(73, 94, 29, '2014-02-24 02:29:47', NULL, NULL, 1),
(74, 97, 30, '2014-02-24 02:30:20', '2014-03-18 16:33:24', 0, 1),
(75, 93, 25, '2014-02-24 20:30:26', '2014-03-09 04:39:38', 0, 1),
(76, 117, 21, '2014-02-25 07:40:40', NULL, NULL, 1),
(77, 131, 41, '2014-03-01 01:31:30', NULL, NULL, 17),
(78, 130, 42, '2014-03-01 01:33:15', NULL, NULL, 17),
(79, 117, 25, '2014-03-09 04:39:55', '2014-03-17 18:08:13', 0, 1),
(80, 86, 5, '2014-03-11 11:58:39', NULL, NULL, NULL),
(81, 118, 45, '2014-03-11 12:01:57', '2014-03-20 02:05:05', 0, 1),
(82, 115, 23, '2014-03-11 14:50:26', '2014-03-11 14:51:23', 0, 1),
(83, 87, 43, '2014-03-11 15:30:45', '2014-03-11 15:31:02', 0, 1),
(84, 117, 43, '2014-03-11 15:31:16', '2014-03-26 01:27:38', 0, 1),
(85, 117, 22, '2014-03-17 02:11:19', NULL, NULL, 1),
(86, 138, 47, '2014-03-17 12:46:15', '2014-03-17 13:13:16', 1, 18),
(87, 90, 20, '2014-03-17 16:34:54', NULL, NULL, 1),
(88, 137, 30, '2014-03-18 16:33:38', '2014-03-20 13:59:32', 0, 1),
(89, 132, 45, '2014-03-20 02:05:32', NULL, NULL, 1),
(90, 108, 30, '2014-03-20 13:59:56', '2014-03-24 22:48:50', 1, 22),
(91, 119, 30, '2014-03-24 22:49:14', '2014-03-26 01:33:34', 0, 1),
(92, 104, 28, '2014-03-25 12:49:03', '2014-03-25 12:49:25', 0, 22),
(93, 117, 43, '2014-03-26 01:27:44', '2014-03-26 01:27:59', 0, 1),
(94, 120, 43, '2014-03-26 01:28:16', NULL, NULL, 1),
(95, 102, 30, '2014-03-26 01:34:22', NULL, NULL, 1),
(96, 109, 25, '2014-03-26 22:33:35', '2014-03-30 05:35:58', 0, 1),
(97, 117, 26, '2014-03-26 22:37:03', NULL, NULL, 1),
(98, 107, 25, '2014-03-30 05:36:54', '2014-04-02 23:28:12', 0, 1),
(99, 135, 25, '2014-04-02 23:28:27', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `traineeRating`
--

CREATE TABLE `traineeRating` (
  `traineeRatingID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courseTraineeActivityID` int(10) unsigned NOT NULL,
  `ratingID` int(10) unsigned NOT NULL,
  `dateUpdated` datetime NOT NULL,
  `comment` text,
  `traineeID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`traineeRatingID`),
  KEY `ixz00` (`courseTraineeActivityID`),
  KEY `ixz01` (`ratingID`),
  KEY `fkcc1` (`courseTraineeActivityID`),
  KEY `fkcc2` (`ratingID`),
  KEY `ixz03` (`traineeID`),
  KEY `fkcc3` (`traineeID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `traineeRating`
--

INSERT INTO `traineeRating` (`traineeRatingID`, `courseTraineeActivityID`, `ratingID`, `dateUpdated`, `comment`, `traineeID`) VALUES
(1, 29434, 5, '2014-07-05 14:26:52', NULL, 117),
(2, 29435, 1, '2014-07-05 15:01:29', NULL, 117),
(3, 29436, 2, '2014-07-05 15:13:19', NULL, 117),
(4, 29437, 4, '2014-07-05 15:41:02', NULL, 117),
(5, 29437, 1, '2014-07-05 15:41:22', NULL, 117),
(6, 29434, 2, '2014-07-05 16:21:18', NULL, 117),
(7, 29434, 2, '2014-07-05 16:21:45', NULL, 117),
(8, 29438, 3, '2014-07-05 16:22:12', NULL, 117),
(9, 29438, 1, '2014-07-05 16:23:08', NULL, 117),
(10, 29475, 1, '2014-07-05 18:35:23', NULL, 117),
(11, 29475, 2, '2014-07-05 18:35:51', NULL, 117),
(12, 29475, 2, '2014-07-05 18:36:16', NULL, 117),
(13, 29475, 2, '2014-07-05 18:36:30', NULL, 117),
(14, 29434, 4, '2014-07-05 22:33:10', NULL, 117),
(15, 29438, 1, '2014-07-05 22:33:27', NULL, 117),
(16, 29438, 4, '2014-07-05 23:19:07', NULL, 117);

-- --------------------------------------------------------

--
-- Table structure for table `traineeShout`
--

CREATE TABLE `traineeShout` (
  `traineeShoutID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `traineeID` int(10) unsigned NOT NULL,
  `helpTypeID` int(10) unsigned NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `remarks` varchar(255) NOT NULL,
  PRIMARY KEY (`traineeShoutID`),
  KEY `traineeID` (`traineeID`),
  KEY `helpTypeID` (`helpTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `traineeStatus`
--

CREATE TABLE `traineeStatus` (
  `traineeStatusID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `traineeID` int(10) unsigned NOT NULL,
  `dateUpdated` datetime NOT NULL,
  `traineeStatusTypeID` int(10) unsigned NOT NULL,
  `remarks` text,
  PRIMARY KEY (`traineeStatusID`),
  KEY `ix040` (`traineeID`),
  KEY `ix041` (`traineeStatusTypeID`),
  KEY `fk040` (`traineeID`),
  KEY `fk041` (`traineeStatusTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `traineeStatusType`
--

CREATE TABLE `traineeStatusType` (
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

-- --------------------------------------------------------

--
-- Table structure for table `trainingClass`
--

CREATE TABLE `trainingClass` (
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

-- --------------------------------------------------------

--
-- Table structure for table `trainingClassCourse`
--

CREATE TABLE `trainingClassCourse` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=111 ;

--
-- Dumping data for table `trainingClassCourse`
--

INSERT INTO `trainingClassCourse` (`trainingClassCourseID`, `courseID`, `trainingClassID`, `dateUpdated`, `priorityFlag`, `startDate`, `endDate`) VALUES
(87, 26, 1, '2014-07-02 01:02:01', 0, NULL, NULL),
(88, 25, 1, '2014-07-02 01:02:01', 0, NULL, NULL),
(89, 9, 1, '2014-07-02 01:02:01', 0, NULL, NULL),
(90, 8, 1, '2014-07-02 01:02:01', 0, NULL, NULL),
(91, 7, 1, '2014-07-02 01:02:01', 0, NULL, NULL),
(92, 6, 1, '2014-07-02 01:02:01', 0, NULL, NULL),
(93, 5, 2, '2014-07-03 19:22:06', 0, NULL, NULL),
(94, 26, 2, '2014-07-03 19:22:06', 0, NULL, NULL),
(95, 25, 2, '2014-07-03 19:22:06', 0, NULL, NULL),
(96, 9, 2, '2014-07-03 19:22:06', 0, NULL, NULL),
(97, 8, 2, '2014-07-03 19:22:06', 0, NULL, NULL),
(98, 7, 2, '2014-07-03 19:22:06', 0, NULL, NULL),
(99, 6, 2, '2014-07-03 19:22:06', 0, NULL, NULL),
(100, 26, 3, '2014-07-05 05:32:40', 0, NULL, NULL),
(101, 25, 3, '2014-07-05 05:32:40', 0, NULL, NULL),
(102, 9, 3, '2014-07-05 05:32:40', 0, NULL, NULL),
(103, 10, 3, '2014-07-05 05:32:40', 0, NULL, NULL),
(104, 8, 3, '2014-07-05 05:32:40', 0, NULL, NULL),
(105, 7, 3, '2014-07-05 05:32:40', 0, NULL, NULL),
(106, 6, 3, '2014-07-05 05:32:40', 0, NULL, NULL),
(107, 5, 3, '2014-07-05 05:35:18', 0, NULL, NULL),
(108, 4, 3, '2014-07-05 05:35:18', 0, NULL, NULL),
(109, 3, 3, '2014-07-05 05:35:18', 0, NULL, NULL),
(110, 2, 3, '2014-07-05 05:35:18', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `trainingClassEvent`
--

CREATE TABLE `trainingClassEvent` (
  `trainingClassEventID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `eventName` text,
  `description` text,
  `trainingClassID` int(10) unsigned NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `location` text,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `trainingClassCourseID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`trainingClassEventID`),
  KEY `trainingClassID` (`trainingClassID`),
  KEY `trainingClassCourseID` (`trainingClassCourseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `activity`
--
ALTER TABLE `activity`
  ADD CONSTRAINT `fxsds` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `fktcx00` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`),
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`);

--
-- Constraints for table `author`
--
ALTER TABLE `author`
  ADD CONSTRAINT `fgcv` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `fk550` FOREIGN KEY (`provinceID`) REFERENCES `province` (`provinceID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `fkb01` FOREIGN KEY (`cityID`) REFERENCES `city` (`cityID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `fkd90` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkd91` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `courseAuthor`
--
ALTER TABLE `courseAuthor`
  ADD CONSTRAINT `fk78` FOREIGN KEY (`authorID`) REFERENCES `author` (`authorID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk7878` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `courseTrainee`
--
ALTER TABLE `courseTrainee`
  ADD CONSTRAINT `courseTrainee_ibfk_1` FOREIGN KEY (`trainingClassCourseID`) REFERENCES `trainingClassCourse` (`trainingClassCourseID`) ON DELETE CASCADE,
  ADD CONSTRAINT `courseTrainee_ibfk_2` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`) ON DELETE CASCADE,
  ADD CONSTRAINT `courseTrainee_ibfk_3` FOREIGN KEY (`ratingID`) REFERENCES `rating` (`ratingID`) ON DELETE CASCADE;

--
-- Constraints for table `courseTraineeActivity`
--
ALTER TABLE `courseTraineeActivity`
  ADD CONSTRAINT `courseTraineeActivity_ibfk_1` FOREIGN KEY (`courseTraineeID`) REFERENCES `courseTrainee` (`courseTraineeID`) ON DELETE CASCADE,
  ADD CONSTRAINT `courseTraineeActivity_ibfk_2` FOREIGN KEY (`activityID`) REFERENCES `activity` (`activityID`) ON DELETE CASCADE,
  ADD CONSTRAINT `courseTraineeActivity_ibfk_3` FOREIGN KEY (`ratingID`) REFERENCES `rating` (`ratingID`) ON DELETE CASCADE;

--
-- Constraints for table `demoAnnouncement`
--
ALTER TABLE `demoAnnouncement`
  ADD CONSTRAINT `demoAnnouncement_ibfk_1` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`) ON DELETE CASCADE,
  ADD CONSTRAINT `demoAnnouncement_ibfk_2` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`) ON DELETE CASCADE,
  ADD CONSTRAINT `demoAnnouncement_ibfk_3` FOREIGN KEY (`teamID`) REFERENCES `team` (`teamID`) ON DELETE CASCADE;

--
-- Constraints for table `equipment`
--
ALTER TABLE `equipment`
  ADD CONSTRAINT `equipment_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE,
  ADD CONSTRAINT `equipment_ibfk_2` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

--
-- Constraints for table `errorStoreAndroid`
--
ALTER TABLE `errorStoreAndroid`
  ADD CONSTRAINT `errorstoreandroid_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE;

--
-- Constraints for table `gcmDevice`
--
ALTER TABLE `gcmDevice`
  ADD CONSTRAINT `gcmDevice_ibfk_1` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`) ON DELETE CASCADE,
  ADD CONSTRAINT `gcmDevice_ibfk_2` FOREIGN KEY (`authorID`) REFERENCES `author` (`authorID`) ON DELETE CASCADE,
  ADD CONSTRAINT `gcmDevice_ibfk_3` FOREIGN KEY (`instructorID`) REFERENCES `instructor` (`instructorID`) ON DELETE CASCADE,
  ADD CONSTRAINT `gcmDevice_ibfk_4` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`) ON DELETE CASCADE,
  ADD CONSTRAINT `gcmDevice_ibfk_5` FOREIGN KEY (`reportUserID`) REFERENCES `reportUser` (`reportUserID`) ON DELETE CASCADE;

--
-- Constraints for table `guardianTrainee`
--
ALTER TABLE `guardianTrainee`
  ADD CONSTRAINT `guardianTrainee_ibfk_1` FOREIGN KEY (`guardianID`) REFERENCES `guardian` (`guardianID`) ON DELETE CASCADE,
  ADD CONSTRAINT `guardianTrainee_ibfk_2` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`) ON DELETE CASCADE;

--
-- Constraints for table `helpRequest`
--
ALTER TABLE `helpRequest`
  ADD CONSTRAINT `helpRequest_ibfk_1` FOREIGN KEY (`helpTypeID`) REFERENCES `helpType` (`helpTypeID`) ON DELETE CASCADE,
  ADD CONSTRAINT `helpRequest_ibfk_3` FOREIGN KEY (`courseTraineeActivityID`) REFERENCES `courseTraineeActivity` (`courseTraineeActivityID`) ON DELETE CASCADE,
  ADD CONSTRAINT `helpRequest_ibfk_4` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`) ON DELETE CASCADE;

--
-- Constraints for table `helpResponse`
--
ALTER TABLE `helpResponse`
  ADD CONSTRAINT `helpResponse_ibfk_1` FOREIGN KEY (`helpRequestID`) REFERENCES `helpRequest` (`helpRequestID`) ON DELETE CASCADE,
  ADD CONSTRAINT `helpResponse_ibfk_2` FOREIGN KEY (`instructorID`) REFERENCES `instructor` (`instructorID`) ON DELETE CASCADE;

--
-- Constraints for table `helpType`
--
ALTER TABLE `helpType`
  ADD CONSTRAINT `helpType_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE;

--
-- Constraints for table `institution`
--
ALTER TABLE `institution`
  ADD CONSTRAINT `institution_ibfk_1` FOREIGN KEY (`cityID`) REFERENCES `city` (`cityID`);

--
-- Constraints for table `instructor`
--
ALTER TABLE `instructor`
  ADD CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`cityID`) REFERENCES `city` (`cityID`),
  ADD CONSTRAINT `instructor_ibfk_2` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE,
  ADD CONSTRAINT `instructor_ibfk_3` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

--
-- Constraints for table `instructorClass`
--
ALTER TABLE `instructorClass`
  ADD CONSTRAINT `instructorClass_ibfk_1` FOREIGN KEY (`instructorID`) REFERENCES `instructor` (`instructorID`) ON DELETE CASCADE,
  ADD CONSTRAINT `instructorClass_ibfk_2` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`) ON DELETE CASCADE;

--
-- Constraints for table `instructorRating`
--
ALTER TABLE `instructorRating`
  ADD CONSTRAINT `instructorRating_ibfk_1` FOREIGN KEY (`instructorID`) REFERENCES `instructor` (`instructorID`) ON DELETE CASCADE,
  ADD CONSTRAINT `instructorRating_ibfk_2` FOREIGN KEY (`courseTraineeActivityID`) REFERENCES `courseTraineeActivity` (`courseTraineeActivityID`) ON DELETE CASCADE,
  ADD CONSTRAINT `instructorRating_ibfk_3` FOREIGN KEY (`ratingID`) REFERENCES `rating` (`ratingID`) ON DELETE CASCADE;

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`equipmentID`) REFERENCES `equipment` (`equipmentID`) ON DELETE CASCADE,
  ADD CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

--
-- Constraints for table `lessonResource`
--
ALTER TABLE `lessonResource`
  ADD CONSTRAINT `lessonresource_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE,
  ADD CONSTRAINT `lessonResource_ibfk_2` FOREIGN KEY (`authorID`) REFERENCES `author` (`authorID`),
  ADD CONSTRAINT `lessonResource_ibfk_3` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`),
  ADD CONSTRAINT `lessonResource_ibfk_4` FOREIGN KEY (`instructorID`) REFERENCES `instructor` (`instructorID`);

--
-- Constraints for table `lessonSchedule`
--
ALTER TABLE `lessonSchedule`
  ADD CONSTRAINT `lessact` FOREIGN KEY (`activityID`) REFERENCES `activity` (`activityID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `lessonSchedule_ibfk_1` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`) ON DELETE CASCADE;

--
-- Constraints for table `objective`
--
ALTER TABLE `objective`
  ADD CONSTRAINT `objective_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE;

--
-- Constraints for table `province`
--
ALTER TABLE `province`
  ADD CONSTRAINT `province_ibfk_1` FOREIGN KEY (`countryID`) REFERENCES `country` (`countryID`) ON DELETE CASCADE;

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE;

--
-- Constraints for table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `team_ibfk_1` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`) ON DELETE CASCADE;

--
-- Constraints for table `teamMember`
--
ALTER TABLE `teamMember`
  ADD CONSTRAINT `teamMember_ibfk_1` FOREIGN KEY (`teamID`) REFERENCES `team` (`teamID`) ON DELETE CASCADE,
  ADD CONSTRAINT `teamMember_ibfk_2` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`) ON DELETE CASCADE;

--
-- Constraints for table `trainee`
--
ALTER TABLE `trainee`
  ADD CONSTRAINT `trainee_ibfk_1` FOREIGN KEY (`institutionID`) REFERENCES `institution` (`institutionID`),
  ADD CONSTRAINT `trainee_ibfk_2` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE,
  ADD CONSTRAINT `trainee_ibfk_3` FOREIGN KEY (`cityID`) REFERENCES `city` (`cityID`),
  ADD CONSTRAINT `trainee_ibfk_5` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`),
  ADD CONSTRAINT `trainee_ibfk_6` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`);

--
-- Constraints for table `traineeEquipment`
--
ALTER TABLE `traineeEquipment`
  ADD CONSTRAINT `traineeEquipment_ibfk_1` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`) ON DELETE CASCADE,
  ADD CONSTRAINT `traineeEquipment_ibfk_2` FOREIGN KEY (`inventoryID`) REFERENCES `inventory` (`inventoryID`),
  ADD CONSTRAINT `traineeEquipment_ibfk_3` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

--
-- Constraints for table `traineeRating`
--
ALTER TABLE `traineeRating`
  ADD CONSTRAINT `traineeRating_ibfk_1` FOREIGN KEY (`courseTraineeActivityID`) REFERENCES `courseTraineeActivity` (`courseTraineeActivityID`) ON DELETE CASCADE,
  ADD CONSTRAINT `traineeRating_ibfk_2` FOREIGN KEY (`ratingID`) REFERENCES `rating` (`ratingID`) ON DELETE CASCADE,
  ADD CONSTRAINT `traineeRating_ibfk_3` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`) ON DELETE CASCADE;

--
-- Constraints for table `traineeShout`
--
ALTER TABLE `traineeShout`
  ADD CONSTRAINT `traineeShout_ibfk_1` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`) ON DELETE CASCADE,
  ADD CONSTRAINT `traineeShout_ibfk_2` FOREIGN KEY (`helpTypeID`) REFERENCES `helpType` (`helpTypeID`) ON DELETE CASCADE;

--
-- Constraints for table `traineeStatus`
--
ALTER TABLE `traineeStatus`
  ADD CONSTRAINT `traineeStatus_ibfk_1` FOREIGN KEY (`traineeID`) REFERENCES `trainee` (`traineeID`),
  ADD CONSTRAINT `traineeStatus_ibfk_2` FOREIGN KEY (`traineeStatusTypeID`) REFERENCES `traineeStatusType` (`traineeStatusTypeID`);

--
-- Constraints for table `trainingClass`
--
ALTER TABLE `trainingClass`
  ADD CONSTRAINT `trainingClass_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE,
  ADD CONSTRAINT `trainingClass_ibfk_2` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

--
-- Constraints for table `trainingClassCourse`
--
ALTER TABLE `trainingClassCourse`
  ADD CONSTRAINT `trainingClassCourse_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE,
  ADD CONSTRAINT `trainingClassCourse_ibfk_2` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`) ON DELETE CASCADE;

--
-- Constraints for table `trainingClassEvent`
--
ALTER TABLE `trainingClassEvent`
  ADD CONSTRAINT `trainingClassEvent_ibfk_1` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`) ON DELETE CASCADE,
  ADD CONSTRAINT `trainingClassEvent_ibfk_2` FOREIGN KEY (`trainingClassCourseID`) REFERENCES `trainingClassCourse` (`trainingClassCourseID`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
