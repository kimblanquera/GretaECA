-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 05, 2015 at 01:05 AM
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
-- Table structure for table `symptom_list_table`
--

CREATE TABLE IF NOT EXISTS `symptom_list_table` (
  `symptom_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `symptom_name_english` varchar(100) NOT NULL,
  `symptom_name_tagalog` varchar(100) NOT NULL,
  PRIMARY KEY (`symptom_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `symptom_list_table`
--

INSERT INTO `symptom_list_table` (`symptom_id`, `symptom_name_english`, `symptom_name_tagalog`) VALUES
(1, 'Fever', 'Lagnat'),
(2, 'Cough', 'Ubo'),
(3, 'Tummy Pain', 'Sakit ng Tiyan'),
(4, 'Diarrhea', 'Pagdudumi'),
(5, 'Ear Problem', 'Problema sa Tenga'),
(6, 'Skin Problem', 'Problema sa balat'),
(7, 'Eye Problem', 'Problema sa Mata');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
