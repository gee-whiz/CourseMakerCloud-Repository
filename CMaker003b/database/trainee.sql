-- phpMyAdmin SQL Dump
-- version 4.0.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 29, 2014 at 06:50 AM
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
-- Table structure for table `trainee`
--

CREATE TABLE IF NOT EXISTS `trainee` (
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
  `activeFlag` int(11) DEFAULT NULL,
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=152 ;

--
-- Dumping data for table `trainee`
--

INSERT INTO `trainee` (`traineeID`, `firstName`, `middleName`, `lastName`, `email`, `cellphone`, `dateRegistered`, `gender`, `institutionID`, `companyID`, `IDNumber`, `address`, `cityID`, `trainingClassID`, `password`, `activeFlag`, `administratorID`, `GCMRegistrationID`, `dateUpdated`) VALUES
(25, 'Barack Hussein', NULL, 'Obama', 'barack123@gmail.com', '0778556633', '2013-10-21 15:37:49', 1, NULL, 1, NULL, NULL, 1, 1, 'dev', NULL, NULL, NULL, NULL),
(86, 'William T', NULL, 'Maluleke', 'William.Maluleke1@gmail.com', '0828006369', '2013-10-24 01:44:56', 1, NULL, 1, NULL, NULL, 3, 1, 'trainee', NULL, NULL, NULL, NULL),
(87, 'Omar James', NULL, 'Black', 'Omar.Black2@gmail.com', '0999990000', '2013-10-24 01:45:02', 1, NULL, 1, NULL, NULL, 2, 1, 'trainee', NULL, NULL, NULL, NULL),
(88, 'Samuel', NULL, 'Zulu', 'Samuel.Zulu3@gmail.com', '0999990000', '2013-10-24 01:45:03', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', NULL, NULL, NULL, NULL),
(89, 'Bobby', NULL, 'Ringane', 'Bobby.Ringane4@gmail.com', '0999990000', '2013-10-24 01:45:04', 1, NULL, 1, NULL, NULL, 2, 1, 'trainee', NULL, NULL, NULL, NULL),
(90, 'Bakithi', NULL, 'Ngobeni', 'Bakithi.Ngobeni5@gmail.com', '0999990000', '2013-10-24 01:45:04', 1, NULL, 1, NULL, NULL, 3, 1, 'trainee', NULL, NULL, NULL, NULL),
(91, 'Jean', NULL, 'Venter', 'Jean.Venter6@gmail.com', '0999990000', '2013-10-24 01:45:05', 2, NULL, 1, NULL, NULL, 1, 1, 'trainee', NULL, NULL, NULL, NULL),
(92, 'Bennie Bam', NULL, 'Mathebula', 'Bennie.Mathebula7@gmail.com', '0999990000', '2013-10-24 01:45:05', 1, NULL, 1, NULL, NULL, 2, 1, 'trainee', NULL, NULL, NULL, NULL),
(93, 'Robert', NULL, 'Phiri', 'Robert.Phiri8@gmail.com', '0999990000', '2013-10-24 01:45:06', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', NULL, NULL, NULL, NULL),
(94, 'Obakeng', NULL, 'Nkosi', 'Obakeng.Nkosi9@gmail.com', '0999990000', '2013-10-24 01:45:06', 1, NULL, 1, NULL, NULL, 2, 1, 'trainee', NULL, NULL, NULL, NULL),
(95, 'Robert S', NULL, 'Bodibe', 'Robert.Bodibe10@gmail.com', '0999990000', '2013-10-24 01:45:07', 1, NULL, 1, NULL, NULL, 3, 1, 'trainee', NULL, NULL, NULL, NULL),
(96, 'Harry Charles', NULL, 'Ntemi', 'Harry.Ntemi11@gmail.com', '0999990000', '2013-10-24 01:45:08', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', NULL, NULL, NULL, NULL),
(97, 'Jack Daniel', NULL, 'Ntemi', 'Jack.Ntemi12@gmail.com', '0999990000', '2013-10-24 01:45:08', 1, NULL, 1, NULL, NULL, 3, 1, 'trainee', NULL, NULL, NULL, NULL),
(98, 'MacDonald', NULL, 'Thobane', 'macDonald.thobane13@gmail.com', '0999990000', '2013-10-24 01:45:09', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', NULL, NULL, NULL, NULL),
(99, 'Sipho', NULL, 'Ringane', 'Sipho.Ringane14@gmail.com', '0999990000', '2013-10-24 01:45:10', 1, NULL, 1, NULL, NULL, 1, 1, 'trainee', NULL, NULL, NULL, NULL),
(100, 'Shane', NULL, 'Gray', 'Shane.Gray1@gmail.com', '0999990000', '2013-10-24 02:05:23', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(101, 'Mark', NULL, 'Gray', 'Mark.Gray2@gmail.com', '0999990000', '2013-10-24 02:05:25', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(102, 'Noonan', NULL, 'Ngwenya', 'Noonan.Ngwenya3@gmail.com', '0999990000', '2013-10-24 02:05:26', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(103, 'Vusi', NULL, 'Ntemi', 'Vusi.Ntemi4@gmail.com', '0999990000', '2013-10-24 02:05:27', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(104, 'Bakithi', NULL, 'Thobela', 'Bakithi.Thobela5@gmail.com', '0999990000', '2013-10-24 02:05:28', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(105, 'Oupa', NULL, 'Ntemi', 'Oupa.Ntemi6@gmail.com', '0999990000', '2013-10-24 02:05:29', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(106, 'Jonty', NULL, 'Fumani', 'Jonty.Fumani7@gmail.com', '0999990000', '2013-10-24 02:05:30', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(107, 'Jeremiah', NULL, 'Maleho', 'Jeremiah.Maleho8@gmail.com', '0999990000', '2013-10-24 02:05:31', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(108, 'Andrew', NULL, 'Marule', 'Andrew.Marule9@gmail.com', '0999990000', '2013-10-24 02:05:32', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(109, 'Johnny', NULL, 'Thobela', 'Johnny.Thobela10@gmail.com', '0999990000', '2013-10-24 02:05:33', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(110, 'Newton', NULL, 'Ringane', 'Newton.Ringane11@gmail.com', '0999990000', '2013-10-24 02:05:34', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(111, 'Caleb', NULL, 'Bodibe', 'Caleb.Bodibe12@gmail.com', '0999990000', '2013-10-24 02:05:35', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(112, 'McLean', NULL, 'Ringane', 'McLean.Ringane13@gmail.com', '0999990000', '2013-10-24 02:05:36', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(113, 'Jerry', NULL, 'Bala', 'Jerry.Bala14@gmail.com', '0999990000', '2013-10-24 02:05:37', 1, NULL, 1, NULL, NULL, 1, 2, 'trainee', NULL, NULL, NULL, NULL),
(115, 'Cheri', NULL, 'Bamuza-Smith', 'someemail@gmail.com', '0712196532', '2013-11-18 00:23:26', 2, NULL, 1, NULL, NULL, 3, 1, 'dev', NULL, NULL, NULL, NULL),
(117, 'Tiger', NULL, 'Malabie', 'aubrey.malabie@gmail.com', '0712193543', '2013-11-18 15:58:27', 1, NULL, 1, '8802035660085', '30 Kingfisher Drive, Pecanwood', 136, 1, 'kktiger3', NULL, NULL, NULL, '2014-03-15 16:21:52'),
(118, 'Portia ', NULL, 'Marule-Thamage', 'info.bohatmx@gmail.com', '0712193543', '2013-11-18 16:02:39', 2, NULL, 1, NULL, NULL, 2, 1, 'dev', NULL, NULL, NULL, NULL),
(119, 'Mmaphefo', NULL, 'Nkuna', 'mmaphefo@gmail.com', '085663321', '2014-02-16 02:25:49', 2, NULL, 1, NULL, NULL, 2, 3, NULL, NULL, NULL, NULL, NULL),
(120, 'Franklin', NULL, 'Bamuza', 'franklin.b@gmail.com', '0824111122', '2014-02-16 02:40:58', 1, NULL, 1, NULL, NULL, 2, 3, NULL, NULL, NULL, NULL, NULL),
(121, 'Jonathan', NULL, 'Dlamani', 'malengax@gmail.com', '0712335566', '2014-02-16 02:47:53', 1, NULL, 1, NULL, NULL, 2, 3, 'vmhg#572', NULL, NULL, NULL, NULL),
(124, 'Aubrey', NULL, 'Nkosi-Smythe', 'aubrey@mlab.co.za', '0712193544', '2014-02-16 03:14:34', 1, NULL, 1, NULL, NULL, 2, 3, 'hshn@466', NULL, NULL, NULL, NULL),
(125, 'Robert', NULL, 'Malenga', 'robet@gmail.com', '0784452211', '2014-02-26 22:19:51', 1, NULL, 25, NULL, NULL, 2, 12, 'fama$767', NULL, NULL, NULL, NULL),
(126, 'Joanne', NULL, 'Mngadi', 'j.mngadi@gmail.com', '0896653322', '2014-02-27 08:45:06', 2, NULL, 25, NULL, NULL, 3, 12, 'ndba$282', NULL, NULL, NULL, NULL),
(127, 'Abram', NULL, 'Chauke', 'abramchauke@gmail.com', '0875523636', '2014-02-27 12:25:24', 1, NULL, 25, NULL, NULL, 3, 14, 'bnss#321', NULL, NULL, NULL, NULL),
(129, 'Thokozile', NULL, 'Majola-Snyder', 'thokozile.mse@gmail.com', '0875523636', '2014-02-27 12:30:15', 2, NULL, 25, NULL, NULL, 1, 19, 'yryl$255', NULL, NULL, NULL, NULL),
(130, 'Ellen', NULL, 'Bodibe', 'ebodibe.m@gmail.com', '0825663236', '2014-02-27 21:21:33', 2, NULL, 27, NULL, NULL, 3, 22, 'adsb#156', NULL, NULL, NULL, NULL),
(131, 'Daniel', NULL, 'Khoza', 'dkhoza.m@gmail.com', '0825559999', '2014-02-28 05:54:27', 1, NULL, 27, NULL, NULL, 2, 20, 'wxfk@411', NULL, NULL, NULL, NULL),
(132, 'Aubrey', NULL, 'Maluleke', 'malengadev@gmail.com', '0986653322', '2014-03-01 06:39:16', 1, NULL, 1, NULL, NULL, 3, 3, 'fyjp$685', NULL, NULL, NULL, NULL),
(133, 'Jacques', NULL, 'Venter', 'jac.vm@gmail.com', '0825586969', '2014-03-03 07:13:16', 1, NULL, 1, NULL, NULL, 2, 4, 'esyw$686', NULL, NULL, NULL, NULL),
(134, 'Wendy Wench', NULL, 'Weir', 'wendysweir.c@gmail.com', '0774441112', '2014-03-03 07:38:47', 2, NULL, 1, NULL, NULL, 3, 4, 'yylx@667', NULL, NULL, NULL, NULL),
(135, 'Maria', NULL, 'Mathebula', 'm.mathebu@gmail.com', '0885656569', '2014-03-03 07:40:55', 2, NULL, 1, NULL, NULL, 1, 4, 'pugs@443', NULL, NULL, NULL, NULL),
(136, 'Jennifer', NULL, 'Zondi', 'jenn.zo@gmail.com', '099885632', '2014-03-03 07:42:20', 2, NULL, 1, NULL, NULL, 1, 4, 'sdrw$588', NULL, NULL, NULL, NULL),
(137, 'Jackson Mthembu', NULL, 'Bala', 'jacksob.mthembu@gmail.com', '0774552121', '2014-03-09 13:39:48', 1, NULL, 1, NULL, NULL, 3, 1, 'qwmv$746', NULL, NULL, NULL, NULL),
(138, 'Sipho', NULL, 'Xaba', 'rulanho@gmail.com', '0761234567', '2014-03-12 16:27:20', 1, NULL, 28, NULL, NULL, 3, 25, 'gabf$146', NULL, NULL, NULL, NULL),
(139, 'Jonathan', NULL, 'Zuckerberg', 'zuck.j@gmail.com', '0889963322', '2014-03-15 18:32:36', 1, NULL, 1, NULL, NULL, 54, 1, NULL, NULL, NULL, NULL, NULL),
(140, 'Bokgabane', NULL, 'Thamae', 'bokgabane@gmail.com', '0996635252', '2014-03-15 18:33:57', 2, NULL, 1, NULL, NULL, 39, 1, 'dev', NULL, 1, NULL, NULL),
(141, 'Rulani', NULL, 'Nevhufumba', 'rulani@mlab.co.za', '0831476982', '2014-03-17 12:58:17', 1, NULL, 28, NULL, NULL, 8, 25, 'jswv@766', NULL, NULL, NULL, NULL),
(142, 'Tshiwela', NULL, 'Tshivhasa', 'tshiwela@gmail.com', '0720846312', '2014-03-17 13:00:20', 2, NULL, 28, NULL, NULL, 33, 25, NULL, NULL, NULL, NULL, NULL),
(143, 'Christiaan', NULL, 'Tshilenga', 'tctshilenga@passriview.co.za', '0831234567', '2014-03-17 13:10:24', 1, NULL, 28, NULL, NULL, 95, 26, NULL, NULL, NULL, NULL, NULL),
(144, 'Helen', NULL, 'Booysen', 'biioo@gmail.com', '0845552322', '2014-03-19 09:51:09', 2, NULL, 1, NULL, NULL, 248, 6, 'xhpr$847', NULL, NULL, NULL, NULL),
(145, 'Desiree', NULL, 'Bopape', 'desiree.bop@gmail.com', '0845552322', '2014-03-19 10:10:56', 2, NULL, 1, NULL, NULL, 254, 6, 'trfs$272', NULL, NULL, NULL, NULL),
(146, 'Daniella', NULL, 'Bamuza', 'dan.bsm@gmsil.com', '099666335', '2014-03-19 10:47:21', 2, NULL, 1, NULL, NULL, 15, 6, 'ugja#468', NULL, NULL, NULL, NULL),
(147, 'Obakeng ', NULL, 'Matlhoko', 'obby.matlhoko@gmail.com', '0844685723', '2014-03-25 15:26:08', 1, NULL, 1, NULL, NULL, 19, 3, 'ygpv$631', NULL, NULL, NULL, NULL),
(148, 'Test', NULL, 'Trainee', 'info@sowertech.com', '0817366150', '2014-03-31 09:41:35', 2, NULL, 1, NULL, NULL, 277, 28, 'cdvx$853', NULL, NULL, NULL, NULL),
(151, 'Test 2.1', NULL, 'Trainee 2.1', 'train@gmail.com', '0113942434', '2014-03-31 22:53:18', 1, NULL, 1, NULL, NULL, 2, 29, 'vcfq$785', NULL, NULL, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trainee`
--
ALTER TABLE `trainee`
  ADD CONSTRAINT `trainee_ibfk_1` FOREIGN KEY (`institutionID`) REFERENCES `institution` (`institutionID`),
  ADD CONSTRAINT `trainee_ibfk_2` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`),
  ADD CONSTRAINT `trainee_ibfk_3` FOREIGN KEY (`cityID`) REFERENCES `city` (`cityID`),
  ADD CONSTRAINT `trainee_ibfk_4` FOREIGN KEY (`trainingClassID`) REFERENCES `trainingClass` (`trainingClassID`),
  ADD CONSTRAINT `trainee_ibfk_5` FOREIGN KEY (`administratorID`) REFERENCES `administrator` (`administratorID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
