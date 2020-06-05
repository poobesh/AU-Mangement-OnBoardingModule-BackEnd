-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2020 at 05:23 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `accolite`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `pincode` int(11) NOT NULL,
  `district` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Address table contains the state and district details';

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`pincode`, `district`, `state`, `country`) VALUES
(536704, 'Pune', 'Maharashtra', 'India'),
(636704, 'Chennai', 'Tamil Nadu', 'India');

-- --------------------------------------------------------

--
-- Table structure for table `bank_details`
--

CREATE TABLE `bank_details` (
  `ac_no` bigint(20) NOT NULL,
  `ifsc_code` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `branch` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Gives Bank Details';

--
-- Dumping data for table `bank_details`
--

INSERT INTO `bank_details` (`ac_no`, `ifsc_code`, `name`, `branch`) VALUES
(150099992233, 'PNB0015009', 'Virat', 'Chennai');

-- --------------------------------------------------------

--
-- Table structure for table `demand`
--

CREATE TABLE `demand` (
  `demand_id` int(11) NOT NULL,
  `hiring_manager_id` int(11) NOT NULL,
  `company_name` varchar(30) NOT NULL,
  `location` varchar(15) NOT NULL,
  `skillset` varchar(30) NOT NULL,
  `joining_date` date NOT NULL,
  `status` varchar(6) NOT NULL,
  `posted_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Demand Table Gives the demands that are active and closed';

--
-- Dumping data for table `demand`
--

INSERT INTO `demand` (`demand_id`, `hiring_manager_id`, `company_name`, `location`, `skillset`, `joining_date`, `status`, `posted_date`) VALUES
(1, 11, 'ABC', 'Chennai', 'Angular', '2020-12-12', 'active', '2020-05-14'),
(2, 10, 'XYZ', 'Mumbai', 'Java', '2019-11-15', 'closed', '2019-10-14'),
(3, 12, 'XYZ', 'Mumbai', 'Java', '2020-08-08', 'active', '2020-05-11'),
(4, 13, 'ABC', 'Chennai', 'Python', '2020-08-15', 'active', '2020-05-14'),
(5, 14, 'XYZ', 'Delhi', 'Python', '2019-06-07', 'closed', '2018-02-02'),
(6, 15, 'ABC', 'Mumbai', 'Python', '2019-06-02', 'closed', '2019-05-02'),
(7, 16, 'ABC', 'Bangalore', 'C/c++', '2018-06-02', 'closed', '2018-03-01'),
(8, 17, 'ABC', 'Mumbai', 'Java', '2017-06-02', 'closed', '2017-02-02');

-- --------------------------------------------------------

--
-- Stand-in structure for view `employee`
-- (See below for the actual view)
--
CREATE TABLE `employee` (
`id` int(11)
,`email` varchar(50)
,`version` int(11)
,`first_name` varchar(15)
,`last_name` varchar(15)
,`dob` date
,`blood_type` varchar(5)
,`gender` varchar(6)
,`date_of_joining` date
,`permanent_address` text
,`permanent_pincode` int(11)
,`pan_number` varchar(10)
,`skill_1` varchar(30)
,`skill_2` varchar(30)
,`skill_3` varchar(30)
,`status` tinyint(1)
,`experience` int(11)
,`phone_number` bigint(11)
,`current_address` text
,`current_pincode` int(11)
,`BGC` tinyint(1)
,`designation` varchar(20)
,`demand_id` int(11)
,`bank_ac_no` bigint(20)
,`ac_no` bigint(20)
,`ifsc_code` varchar(10)
,`name` varchar(30)
,`branch` varchar(30)
);

-- --------------------------------------------------------

--
-- Table structure for table `employee_constant`
--

CREATE TABLE `employee_constant` (
  `id` int(11) NOT NULL,
  `first_name` varchar(15) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `blood_type` varchar(5) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `date_of_joining` date NOT NULL,
  `permanent_address` text NOT NULL,
  `pincode` int(11) NOT NULL,
  `pan_number` varchar(10) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Employee Details that are not supposed to be changed';

--
-- Dumping data for table `employee_constant`
--

INSERT INTO `employee_constant` (`id`, `first_name`, `last_name`, `email`, `dob`, `blood_type`, `gender`, `date_of_joining`, `permanent_address`, `pincode`, `pan_number`, `version`, `status`) VALUES
(1, 'Virat', 'Kholi', 'virat2000@outlook.com', '1992-05-27', 'A-ve', 'Male', '2018-11-14', '9/144 , Rajaji Street', 636704, 'DHJKK4836A', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee_editable`
--

CREATE TABLE `employee_editable` (
  `emailversion` varchar(50) NOT NULL,
  `experience` int(11) NOT NULL,
  `phone_number` bigint(11) NOT NULL,
  `current_address` text NOT NULL,
  `pincode` int(11) NOT NULL,
  `BGC` tinyint(1) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `bank_ac_no` bigint(20) NOT NULL,
  `demand_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Employee Editable table contains fields that are editable';

--
-- Dumping data for table `employee_editable`
--

INSERT INTO `employee_editable` (`emailversion`, `experience`, `phone_number`, `current_address`, `pincode`, `BGC`, `designation`, `bank_ac_no`, `demand_id`) VALUES
('virat2000@outlook.com0', 2, 9876543333, '3/9 , Anna Nagar', 600022, 1, 'SDE', 150099992233, 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `employee_skill`
-- (See below for the actual view)
--
CREATE TABLE `employee_skill` (
`id` int(11)
,`email` varchar(50)
,`version` int(11)
,`first_name` varchar(15)
,`last_name` varchar(15)
,`dob` date
,`blood_type` varchar(5)
,`gender` varchar(6)
,`date_of_joining` date
,`permanent_address` text
,`permanent_pincode` int(11)
,`pan_number` varchar(10)
,`skill_1` varchar(30)
,`skill_2` varchar(30)
,`skill_3` varchar(30)
,`status` tinyint(1)
,`experience` int(11)
,`phone_number` bigint(11)
,`current_address` text
,`current_pincode` int(11)
,`BGC` tinyint(1)
,`designation` varchar(20)
,`demand_id` int(11)
,`bank_ac_no` bigint(20)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `employee_temporary`
-- (See below for the actual view)
--
CREATE TABLE `employee_temporary` (
`id` int(11)
,`first_name` varchar(15)
,`last_name` varchar(15)
,`email` varchar(50)
,`dob` date
,`blood_type` varchar(5)
,`gender` varchar(6)
,`date_of_joining` date
,`permanent_address` text
,`permanent_pincode` int(11)
,`pan_number` varchar(10)
,`version` int(11)
,`status` tinyint(1)
,`emailversion` varchar(50)
,`experience` int(11)
,`phone_number` bigint(11)
,`current_address` text
,`current_pincode` int(11)
,`BGC` tinyint(1)
,`designation` varchar(20)
,`bank_ac_no` bigint(20)
,`demand_id` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `hiring_manager`
--

CREATE TABLE `hiring_manager` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone_no` bigint(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `department_name` varchar(30) NOT NULL,
  `required_employee_count` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `required_experience` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Gives Details About Hiring Manager';

--
-- Dumping data for table `hiring_manager`
--

INSERT INTO `hiring_manager` (`id`, `name`, `phone_no`, `email`, `department_name`, `required_employee_count`, `duration`, `required_experience`) VALUES
(10, 'John', 9090876457, 'john1976@yahoo.com', 'Customer Relation', 10, 10, 2),
(11, 'Rajesh', 8765432103, 'raju@gmail.com', 'Product design', 30, 6, 3),
(12, 'Alice', 9876501235, 'alice@gmail.com', 'Testing', 70, 12, 4),
(13, 'Bob', 7895638346, 'bob@gmail.com', 'Testing', 20, 15, 3),
(14, 'Rohit', 6907893421, 'rohit@yahoo.com', 'Product Design', 18, 5, 4),
(15, 'Dhawan', 8907654876, 'dhawan@outlook.com', 'Testing', 18, 4, 6),
(16, 'Ram', 8907654389, 'ram@gmail.com', 'Design', 16, 3, 3),
(17, 'Ragu', 8907654876, 'ragu@yahoo.com', 'Testing', 23, 6, 5);

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `pan_number` varchar(10) NOT NULL,
  `skill_1` varchar(30) NOT NULL,
  `skill_2` varchar(30) NOT NULL,
  `skill_3` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`pan_number`, `skill_1`, `skill_2`, `skill_3`) VALUES
('DHJKK4836A', 'Python', 'Angular', 'Java');

-- --------------------------------------------------------

--
-- Stand-in structure for view `trends`
-- (See below for the actual view)
--
CREATE TABLE `trends` (
`company_name` varchar(30)
,`count` decimal(32,0)
,`year` int(4)
);

-- --------------------------------------------------------

--
-- Structure for view `employee`
--
DROP TABLE IF EXISTS `employee`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee`  AS  select `employee_skill`.`id` AS `id`,`employee_skill`.`email` AS `email`,`employee_skill`.`version` AS `version`,`employee_skill`.`first_name` AS `first_name`,`employee_skill`.`last_name` AS `last_name`,`employee_skill`.`dob` AS `dob`,`employee_skill`.`blood_type` AS `blood_type`,`employee_skill`.`gender` AS `gender`,`employee_skill`.`date_of_joining` AS `date_of_joining`,`employee_skill`.`permanent_address` AS `permanent_address`,`employee_skill`.`permanent_pincode` AS `permanent_pincode`,`employee_skill`.`pan_number` AS `pan_number`,`employee_skill`.`skill_1` AS `skill_1`,`employee_skill`.`skill_2` AS `skill_2`,`employee_skill`.`skill_3` AS `skill_3`,`employee_skill`.`status` AS `status`,`employee_skill`.`experience` AS `experience`,`employee_skill`.`phone_number` AS `phone_number`,`employee_skill`.`current_address` AS `current_address`,`employee_skill`.`current_pincode` AS `current_pincode`,`employee_skill`.`BGC` AS `BGC`,`employee_skill`.`designation` AS `designation`,`employee_skill`.`demand_id` AS `demand_id`,`employee_skill`.`bank_ac_no` AS `bank_ac_no`,`b`.`ac_no` AS `ac_no`,`b`.`ifsc_code` AS `ifsc_code`,`b`.`name` AS `name`,`b`.`branch` AS `branch` from (`employee_skill` join `bank_details` `b` on((`b`.`ac_no` = `employee_skill`.`bank_ac_no`))) ;

-- --------------------------------------------------------

--
-- Structure for view `employee_skill`
--
DROP TABLE IF EXISTS `employee_skill`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_skill`  AS  select `et`.`id` AS `id`,`et`.`email` AS `email`,`et`.`version` AS `version`,`et`.`first_name` AS `first_name`,`et`.`last_name` AS `last_name`,`et`.`dob` AS `dob`,`et`.`blood_type` AS `blood_type`,`et`.`gender` AS `gender`,`et`.`date_of_joining` AS `date_of_joining`,`et`.`permanent_address` AS `permanent_address`,`et`.`permanent_pincode` AS `permanent_pincode`,`et`.`pan_number` AS `pan_number`,`s`.`skill_1` AS `skill_1`,`s`.`skill_2` AS `skill_2`,`s`.`skill_3` AS `skill_3`,`et`.`status` AS `status`,`et`.`experience` AS `experience`,`et`.`phone_number` AS `phone_number`,`et`.`current_address` AS `current_address`,`et`.`current_pincode` AS `current_pincode`,`et`.`BGC` AS `BGC`,`et`.`designation` AS `designation`,`et`.`demand_id` AS `demand_id`,`et`.`bank_ac_no` AS `bank_ac_no` from (`employee_temporary` `et` join `skill` `s` on((`s`.`pan_number` = `et`.`pan_number`))) ;

-- --------------------------------------------------------

--
-- Structure for view `employee_temporary`
--
DROP TABLE IF EXISTS `employee_temporary`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_temporary`  AS  (select `c`.`id` AS `id`,`c`.`first_name` AS `first_name`,`c`.`last_name` AS `last_name`,`c`.`email` AS `email`,`c`.`dob` AS `dob`,`c`.`blood_type` AS `blood_type`,`c`.`gender` AS `gender`,`c`.`date_of_joining` AS `date_of_joining`,`c`.`permanent_address` AS `permanent_address`,`c`.`pincode` AS `permanent_pincode`,`c`.`pan_number` AS `pan_number`,`c`.`version` AS `version`,`c`.`status` AS `status`,`e`.`emailversion` AS `emailversion`,`e`.`experience` AS `experience`,`e`.`phone_number` AS `phone_number`,`e`.`current_address` AS `current_address`,`e`.`pincode` AS `current_pincode`,`e`.`BGC` AS `BGC`,`e`.`designation` AS `designation`,`e`.`bank_ac_no` AS `bank_ac_no`,`e`.`demand_id` AS `demand_id` from (`employee_constant` `c` join `employee_editable` `e` on(((`e`.`emailversion` = concat(`c`.`email`,`c`.`version`)) and (`c`.`status` = 1))))) ;

-- --------------------------------------------------------

--
-- Structure for view `trends`
--
DROP TABLE IF EXISTS `trends`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `trends`  AS  select `demand`.`company_name` AS `company_name`,sum(`hiring_manager`.`required_employee_count`) AS `count`,year(`demand`.`posted_date`) AS `year` from (`demand` join `hiring_manager` on((`hiring_manager`.`id` = `demand`.`hiring_manager_id`))) group by year(`demand`.`posted_date`),`demand`.`company_name` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`pincode`);

--
-- Indexes for table `bank_details`
--
ALTER TABLE `bank_details`
  ADD PRIMARY KEY (`ac_no`);

--
-- Indexes for table `demand`
--
ALTER TABLE `demand`
  ADD PRIMARY KEY (`demand_id`);

--
-- Indexes for table `employee_constant`
--
ALTER TABLE `employee_constant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee_editable`
--
ALTER TABLE `employee_editable`
  ADD PRIMARY KEY (`emailversion`);

--
-- Indexes for table `hiring_manager`
--
ALTER TABLE `hiring_manager`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`pan_number`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
