-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 03, 2025 at 06:07 AM
-- Server version: 8.0.40
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank_manegment_atharv`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `user_id` int NOT NULL,
  `account_number` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `aadharcard_number` varchar(200) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `upi_id` varchar(20) DEFAULT NULL,
  `mpin` varchar(20) DEFAULT NULL,
  `account_type` enum('savings','current','student') NOT NULL,
  `ifsc_code` varchar(20) NOT NULL,
  `branch_name` varchar(50) DEFAULT NULL,
  `balance` decimal(15,2) DEFAULT '0.00',
  `internet_banking` enum('enabled','disabled') DEFAULT 'disabled',
  `pin` varchar(6) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`user_id`, `account_number`, `name`, `contact_number`, `email`, `aadharcard_number`, `password`, `gender`, `age`, `address`, `upi_id`, `mpin`, `account_type`, `ifsc_code`, `branch_name`, `balance`, `internet_banking`, `pin`, `created_at`) VALUES
(1, '1', 'atharv', '9930524962', 'a@gmail.com', '1223321123221', 'atharv', 'male', 23, 'thane', NULL, NULL, 'savings', '1', 'thane', 6.00, 'enabled', '12345', '2024-11-16 20:02:58');

-- --------------------------------------------------------

--
-- Table structure for table `cards`
--

CREATE TABLE `cards` (
  `card_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `card_type` enum('debit','credit') NOT NULL,
  `card_number` varchar(16) NOT NULL,
  `cvv` varchar(3) NOT NULL,
  `expiry_date` date NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `account_number` varchar(500) DEFAULT NULL,
  `aadharcard_number` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cards`
--

INSERT INTO `cards` (`card_id`, `user_id`, `card_type`, `card_number`, `cvv`, `expiry_date`, `created_at`, `account_number`, `aadharcard_number`) VALUES
(1, 1, 'debit', '201', '123', '2029-11-27', '2024-11-27 08:29:17', '1', '1223321123221');

-- --------------------------------------------------------

--
-- Table structure for table `link`
--

CREATE TABLE `link` (
  `link_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `linked_via` enum('mobile','aadhaar','debit_card') NOT NULL,
  `linked_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `account_number` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `link`
--

INSERT INTO `link` (`link_id`, `user_id`, `linked_via`, `linked_date`, `account_number`) VALUES
(1, 1, 'mobile', '2024-12-16 10:40:12', '1'),
(2, 1, 'mobile', '2024-12-16 10:48:51', '1');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transaction_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `transaction_type` enum('debit','credit','balance_inquiry','pin_change','pin_generate') DEFAULT NULL,
  `amount` decimal(15,2) DEFAULT '0.00',
  `transaction_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `account_number` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transaction_id`, `user_id`, `transaction_type`, `amount`, `transaction_date`, `account_number`) VALUES
(1, 1, 'debit', 0.00, '2024-11-18 17:49:53', '1'),
(2, 1, 'debit', 0.00, '2024-11-18 17:56:05', '1'),
(3, 1, 'debit', 0.00, '2024-11-18 17:57:29', '1'),
(4, 1, 'debit', 0.00, '2024-11-18 18:04:12', '1'),
(5, 1, 'debit', 0.00, '2024-11-18 18:05:06', '1'),
(6, 1, 'debit', 0.00, '2024-11-18 18:11:50', '1'),
(7, 1, 'debit', 0.00, '2024-11-19 06:31:49', '1'),
(8, 1, 'debit', 0.00, '2024-11-19 06:33:26', '1'),
(9, 1, 'debit', 0.00, '2024-11-19 06:34:20', '1'),
(10, 1, 'credit', 2.00, '2024-11-19 06:43:46', '1'),
(11, 1, 'credit', 2.00, '2024-11-19 06:47:33', '1'),
(12, 1, 'debit', 4.00, '2024-11-19 06:53:25', '1'),
(13, 1, 'credit', 4.00, '2024-11-19 06:56:05', '1'),
(14, 1, 'debit', 4.00, '2024-11-19 07:02:15', '1'),
(15, 1, 'debit', 8.00, '2024-11-19 07:02:46', '1'),
(16, 1, 'debit', 20.00, '2024-11-19 07:03:23', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `account_number` (`account_number`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`card_id`),
  ADD UNIQUE KEY `card_number` (`card_number`),
  ADD UNIQUE KEY `aadharcard_number` (`aadharcard_number`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `link`
--
ALTER TABLE `link`
  ADD PRIMARY KEY (`link_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `account_number` (`account_number`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cards`
--
ALTER TABLE `cards`
  MODIFY `card_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `link`
--
ALTER TABLE `link`
  MODIFY `link_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transaction_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cards`
--
ALTER TABLE `cards`
  ADD CONSTRAINT `cards_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `accounts` (`user_id`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `accounts` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
