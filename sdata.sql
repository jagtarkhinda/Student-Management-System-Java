-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2018 at 12:57 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studata`
--

-- --------------------------------------------------------

--
-- Table structure for table `sdata`
--

CREATE TABLE `sdata` (
  `Student_ID` varchar(10) COLLATE utf8_unicode_520_ci NOT NULL,
  `Student_First_Name` varchar(30) COLLATE utf8_unicode_520_ci NOT NULL,
  `Student_Last_Name` varchar(30) COLLATE utf8_unicode_520_ci NOT NULL,
  `Major` varchar(50) COLLATE utf8_unicode_520_ci NOT NULL,
  `Phone` varchar(12) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `GPA` varchar(5) COLLATE utf8_unicode_520_ci NOT NULL,
  `DOB` varchar(30) COLLATE utf8_unicode_520_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

--
-- Dumping data for table `sdata`
--

INSERT INTO `sdata` (`Student_ID`, `Student_First_Name`, `Student_Last_Name`, `Major`, `Phone`, `GPA`, `DOB`) VALUES
('1', 'a', 'b', 'c', '668', '4.0', '1955-5-5'),
('1001', 'yyyy', 'Mr.', 'Springfield', '445', '6', '1992-05-04'),
('11005298', 'JJJJJ', 'iol', 'CSE MADT', '765434567', '3.7', '1212-12-12'),
('1112', 'JJJJJ', 'iol', 'CSE MADT', '98765456', '3.9', '1212-12-12'),
('11501440', 'JJJJJ', 'iol', 'CSE MADT', '555', '1', '8888-8-8'),
('12', 'ajay', 'bobdes', 'madt', '5678765456', '7.0', '0.0-1994.0-0.0'),
('123', 'abc def', 'ghi jk', 'in mtech', '56', '5', '6789-6-5'),
('2', 'a', 'g', 'k', '67', '2', '7890-5-4'),
('43', 'rer rere', 'er', 'err', '44', '5', '5454-4-4'),
('45', 'rt', 'fg', 'vb', '5', '5.0', '5555-5-5'),
('545', 'Prince', 'ety', 'ryr', '56', '6', '0-1992-0'),
('556', 'ggf', 'gfg', 'fhf', '765', '88.0', '5467-8-4'),
('7890', 'abcd', 'rtyu', 'cse', '7898767890', '4', '0.0-1998.0-0.0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sdata`
--
ALTER TABLE `sdata`
  ADD UNIQUE KEY `Student ID` (`Student_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
