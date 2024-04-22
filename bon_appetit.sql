-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2024 at 04:09 PM
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
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appetizer`
--

INSERT INTO `appetizer` (`id`, `dish_name`, `description`, `price`) VALUES
(2, 'vince', 'gwapo', 99999),
(3, 'awdad', 'awda', 21),
(4, 'aw', 'awd', 23);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `name` text NOT NULL,
  `username` varchar(10) NOT NULL,
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`name`, `username`, `id`, `time`) VALUES
('ashutosh', '029', 123, '2024-04-21 12:37:23'),
('kumar', '92', 456, '2024-04-21 12:37:46'),
('kumar', '92', 456, '2024-04-21 12:37:58');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appetizer`
--
ALTER TABLE `appetizer`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appetizer`
--
ALTER TABLE `appetizer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
