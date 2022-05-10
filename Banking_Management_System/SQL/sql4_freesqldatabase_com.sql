-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql4.freesqldatabase.com
-- Generation Time: May 09, 2022 at 08:11 PM
-- Server version: 5.5.54-0ubuntu0.12.04.1
-- PHP Version: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql4490229`
--
CREATE DATABASE IF NOT EXISTS `sql4490229` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sql4490229`;

-- --------------------------------------------------------

--
-- Table structure for table `Account`
--

CREATE TABLE `Account` (
  `Acc` int(200) NOT NULL,
  `Name` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Pin` int(200) DEFAULT NULL,
  `Acc_Type` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `Nationality` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `State` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `MICR_No` int(200) DEFAULT NULL,
  `Gender` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Mobile` bigint(200) DEFAULT NULL,
  `Address` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Sec_Q',
  `Sec_Q` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Sec_A` varchar(200) DEFAULT NULL,
  `Balance` int(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Account`
--

INSERT INTO `Account` (`Acc`, `Name`, `DOB`, `Pin`, `Acc_Type`, `Nationality`, `State`, `MICR_No`, `Gender`, `Mobile`, `Address`, `Sec_Q`, `Sec_A`, `Balance`) VALUES
(5670, 'Alexander ', '2001-10-13', 1234, 'Savings', 'Nigeria', 'Alex', 400, 'Male', 8109766518, '118, Olaniyi Street', 'What is your nick name?', 'a', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `Balances`
--

CREATE TABLE `Balances` (
  `Name` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Acc` int(200) DEFAULT NULL,
  `MICR_No` int(200) DEFAULT NULL,
  `Balance` int(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Balances`
--

INSERT INTO `Balances` (`Name`, `Acc`, `MICR_No`, `Balance`) VALUES
('Alexander ', 5670, 400, 1000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Account`
--
ALTER TABLE `Account`
  ADD PRIMARY KEY (`Acc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
