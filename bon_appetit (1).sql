-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2024 at 09:49 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bon_appetit`
--

-- --------------------------------------------------------

--
-- Table structure for table `appetizer`
--

CREATE TABLE `appetizer` (
  `id` int(11) NOT NULL,
  `dish_name` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appetizer`
--

INSERT INTO `appetizer` (`id`, `dish_name`, `description`, `price`) VALUES
(4, 'aw', 'awd', 23.00),
(5, 'pancake', 'soft', 35.00),
(6, 'cool', 'nice', 2000.00),
(7, 'nice', 'disk', 501.00),
(9, 'mango', 'fruit', 23.00),
(10, 'hey', 'wow', 90.00);

-- --------------------------------------------------------

--
-- Table structure for table `dessert`
--

CREATE TABLE `dessert` (
  `id` int(11) NOT NULL,
  `dish_name` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dessert`
--

INSERT INTO `dessert` (`id`, `dish_name`, `description`, `price`) VALUES
(1, 'brownies', 'chocolate', 50.00),
(2, 'halo-halo', 'mix of things', 45.00),
(3, 'halo-halo', 'mix of things', 45.00),
(5, 'butterscotch', 'peanuts', 57.00),
(6, 'chocolate', 'sweet', 70000.00),
(7, 'wow ', 'cool', 90.00);

-- --------------------------------------------------------

--
-- Table structure for table `drinks`
--

CREATE TABLE `drinks` (
  `id` int(11) NOT NULL,
  `dish_name` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `drinks`
--

INSERT INTO `drinks` (`id`, `dish_name`, `description`, `price`) VALUES
(2, 'coke', 'frizzy', 35.00),
(3, 'water', 'water', 59.00),
(4, 'hey', 'twoo', 4.00);

-- --------------------------------------------------------

--
-- Table structure for table `entree`
--

CREATE TABLE `entree` (
  `id` int(11) NOT NULL,
  `dish_name` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `entree`
--

INSERT INTO `entree` (`id`, `dish_name`, `description`, `price`) VALUES
(1, 'wellington', 'some kind of meat', 200.02),
(2, 'chicken', 'fried', 100.00),
(3, 'dragon', 'some kind of animal', 2000.00),
(4, 'meat', 'someting', 80.00),
(5, 'wow', 'true', 800.00),
(6, 'coool', 'hey', 90.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appetizer`
--
ALTER TABLE `appetizer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dessert`
--
ALTER TABLE `dessert`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `drinks`
--
ALTER TABLE `drinks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `entree`
--
ALTER TABLE `entree`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appetizer`
--
ALTER TABLE `appetizer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `dessert`
--
ALTER TABLE `dessert`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `drinks`
--
ALTER TABLE `drinks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `entree`
--
ALTER TABLE `entree`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
