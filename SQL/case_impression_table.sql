-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 05, 2015 at 01:04 AM
-- Server version: 5.5.41-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `get_better`
--

-- --------------------------------------------------------

--
-- Table structure for table `case_impression_table`
--

CREATE TABLE IF NOT EXISTS `case_impression_table` (
  `impression_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `medical_term` varchar(100) NOT NULL,
  `scientific_name` varchar(100) DEFAULT NULL,
  `local_name` varchar(100) DEFAULT NULL,
  `treatment_protocol` varchar(100) NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`impression_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `case_impression_table`
--

INSERT INTO `case_impression_table` (`impression_id`, `medical_term`, `scientific_name`, `local_name`, `treatment_protocol`, `remarks`) VALUES
(1, 'Measles', 'Rubeola', 'Tigdas', 'Refer to Treatment of Fever, Rest', 'Drink plenty of fluids.'),
(2, 'Typhoid Fever', 'Salmonella typhi', 'Tipus', 'Prescribed antibiotics by doctor', NULL),
(3, 'Dengue Fever', NULL, 'Dengue', 'Intravenous volume replacement', 'Rest and drink plenty of fluids'),
(4, 'Tonsilitis', NULL, NULL, 'Doctor''s prescription of antibiotics', 'Rest'),
(5, 'Malaria', 'Plasmodium', NULL, 'Drugs prescribed by doctor', NULL),
(6, 'Tuberculosis', 'Mycobacterium tuberculosis', 'TB', 'Doctor''s prescription drug', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
