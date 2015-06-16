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
-- Table structure for table `symptoms_of_impression_table`
--

CREATE TABLE IF NOT EXISTS `symptoms_of_impression_table` (
  `impression_id` int(11) unsigned NOT NULL,
  `symptom_id` int(11) unsigned NOT NULL,
  KEY `impression_id` (`impression_id`,`symptom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `symptoms_of_impression_table`
--

INSERT INTO `symptoms_of_impression_table` (`impression_id`, `symptom_id`) VALUES
(1, 1),
(1, 6),
(2, 1),
(3, 1),
(3, 4),
(6, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
