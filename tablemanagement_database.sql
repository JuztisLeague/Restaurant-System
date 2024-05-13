-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2024 at 02:10 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tablemanagement_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `customerorderlist`
--

CREATE TABLE `customerorderlist` (
  `customerCode` int(11) NOT NULL,
  `customerOrderList` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customerorderlist`
--

INSERT INTO `customerorderlist` (`customerCode`, `customerOrderList`) VALUES
(43215, '3pcs Chicken'),
(65432, '3pcs Chicken, 2pcs Burgersteak'),
(10909, '24 Burgers'),
(69083, '2 Fried Chickens\n2 Tempura\n1 Burger\n3 Siomai\n2 Rice'),
(41502, '3 Siopao\n5 Lumpia\n2 Siomai'),
(60386, '3 Chicken Meal\n20 Burger Steak'),
(61364, ''),
(68418, '3 BURGERS'),
(41629, '3 Burger\n2 Ice Tea\n1 Steam Rice');

-- --------------------------------------------------------

--
-- Table structure for table `password`
--

CREATE TABLE `password` (
  `role` varchar(100) NOT NULL,
  `password` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `password`
--

INSERT INTO `password` (`role`, `password`) VALUES
('Chef', 54321),
('Admin', 45312),
('Cashier', 22113);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
