-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 11 Janvier 2019 à 08:38
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `humanresources`
--

-- --------------------------------------------------------

--
-- Structure de la table `countries`
--

CREATE TABLE IF NOT EXISTS `countries` (
  `COUNTRY_ID` varchar(2) NOT NULL,
  `COUNTRY_NAME` varchar(40) DEFAULT NULL,
  `REGION_ID` decimal(5,0) DEFAULT NULL,
  PRIMARY KEY (`COUNTRY_ID`),
  KEY `COUNTR_REG_FK` (`REGION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `countries`
--

INSERT INTO `countries` (`COUNTRY_ID`, `COUNTRY_NAME`, `REGION_ID`) VALUES
('AU', 'Australia', '3'),
('BE', 'Belgium', '1'),
('BR', 'Brazil', '2'),
('CA', 'Canada', '2'),
('CH', 'Switzerland', '1'),
('CN', 'China', '3'),
('DE', 'Germany', '1'),
('DK', 'Denmark', '1'),
('EG', 'Egypt', '4'),
('FR', 'TEst', '1'),
('FT', 'Test', '1'),
('HK', 'HongKong', '3'),
('IL', 'Israel', '4'),
('IN', 'India', '3'),
('IT', 'Italy', '1'),
('JP', 'Japan', '3'),
('KW', 'Kuwait', '4'),
('MX', 'Mexic', '1'),
('NG', 'Nigeria', '4'),
('NL', 'Netherlands', '1'),
('SG', 'Singapore', '3'),
('UK', 'United Kingdom', '1'),
('US', 'United States of America', '2'),
('ZM', 'Zambia', '4'),
('ZV', 'ZRILAN', '1'),
('ZW', 'Zimbabwe', '4'),
('ZZ', 'ZRILANTE', '1');

-- --------------------------------------------------------

--
-- Structure de la table `departments`
--

CREATE TABLE IF NOT EXISTS `departments` (
  `DEPARTMENT_ID` decimal(4,0) NOT NULL DEFAULT '0',
  `DEPARTMENT_NAME` varchar(30) NOT NULL,
  `MANAGER_ID` decimal(6,0) DEFAULT NULL,
  `LOCATION_ID` decimal(4,0) DEFAULT NULL,
  `employee_list_employee_id` int(11) DEFAULT NULL,
  `job_history_list_start_date` date DEFAULT NULL,
  `job_history_list_employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`),
  KEY `DEPT_MGR_FK` (`MANAGER_ID`),
  KEY `DEPT_LOCATION_IX` (`LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `departments`
--

INSERT INTO `departments` (`DEPARTMENT_ID`, `DEPARTMENT_NAME`, `MANAGER_ID`, `LOCATION_ID`, `employee_list_employee_id`, `job_history_list_start_date`, `job_history_list_employee_id`) VALUES
('20', 'Marketing', '201', '1800', NULL, NULL, NULL),
('30', 'Purchasing', '114', '1700', NULL, NULL, NULL),
('40', 'Human Resources', '203', '2400', NULL, NULL, NULL),
('50', 'Shipping', '121', '1500', NULL, NULL, NULL),
('60', 'IT', '103', '1400', NULL, NULL, NULL),
('70', 'Public Relations', '204', '2700', NULL, NULL, NULL),
('80', 'Sales', '145', '2500', NULL, NULL, NULL),
('90', 'Executive', '100', '1700', NULL, NULL, NULL),
('100', 'Finance', '108', '1700', NULL, NULL, NULL),
('110', 'Accounting', '205', '1700', NULL, NULL, NULL),
('120', 'Treasury', '0', '1700', NULL, NULL, NULL),
('130', 'Corporate Tax', '0', '1700', NULL, NULL, NULL),
('140', 'Control And Credit', '0', '1700', NULL, NULL, NULL),
('150', 'Shareholder Services', '0', '1700', NULL, NULL, NULL),
('160', 'Benefits', '0', '1700', NULL, NULL, NULL),
('170', 'Manufacturing', '0', '1700', NULL, NULL, NULL),
('180', 'Construction', '0', '1700', NULL, NULL, NULL),
('190', 'Contracting', '0', '1700', NULL, NULL, NULL),
('200', 'Operations', '0', '1700', NULL, NULL, NULL),
('210', 'IT Support', '0', '1700', NULL, NULL, NULL),
('220', 'NOC', '0', '1700', NULL, NULL, NULL),
('230', 'IT Helpdesk', '0', '1700', NULL, NULL, NULL),
('240', 'Government Sales', '0', '1700', NULL, NULL, NULL),
('250', 'Retail Sales', '0', '1700', NULL, NULL, NULL),
('260', 'Recruiting', '0', '1700', NULL, NULL, NULL),
('270', 'Payroll', '0', '1700', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `employees`
--

CREATE TABLE IF NOT EXISTS `employees` (
  `EMPLOYEE_ID` decimal(6,0) NOT NULL DEFAULT '0',
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(25) NOT NULL,
  `EMAIL` varchar(25) NOT NULL,
  `PASSWORD` varchar(255) CHARACTER SET utf8 NOT NULL,
  `PHONE_NUMBER` varchar(20) DEFAULT NULL,
  `HIRE_DATE` date NOT NULL,
  `JOB_ID` varchar(10) NOT NULL,
  `SALARY` decimal(8,2) DEFAULT NULL,
  `COMMISSION_PCT` decimal(2,2) DEFAULT NULL,
  `MANAGER_ID` decimal(6,0) DEFAULT NULL,
  `DEPARTMENT_ID` decimal(4,0) DEFAULT NULL,
  `employee_id_start_date` date DEFAULT NULL,
  `employee_id_employee_id` int(11) DEFAULT NULL,
  `job_id_job_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  UNIQUE KEY `EMP_EMAIL_UK` (`EMAIL`),
  KEY `EMP_DEPARTMENT_IX` (`DEPARTMENT_ID`),
  KEY `EMP_JOB_IX` (`JOB_ID`),
  KEY `EMP_MANAGER_IX` (`MANAGER_ID`),
  KEY `EMP_NAME_IX` (`LAST_NAME`,`FIRST_NAME`),
  KEY `FK316bjxe1mvbugkqpbryjsr87j` (`job_id_job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employees`
--

INSERT INTO `employees` (`EMPLOYEE_ID`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PASSWORD`, `PHONE_NUMBER`, `HIRE_DATE`, `JOB_ID`, `SALARY`, `COMMISSION_PCT`, `MANAGER_ID`, `DEPARTMENT_ID`, `employee_id_start_date`, `employee_id_employee_id`, `job_id_job_id`) VALUES
('100', 'Steven', 'King', 'SKING', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.123.4567', '1987-06-17', 'AD_PRES', '24000.00', '0.00', '0', '90', NULL, NULL, NULL),
('101', 'Neena', 'Kochhar', 'NKOCHHAR', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.123.4568', '1987-06-18', 'AD_VP', '17000.00', '0.00', '100', '90', NULL, NULL, NULL),
('102', 'Lex', 'De Haan', 'LDEHAAN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.123.4569', '1987-06-18', 'AD_VP', '17000.00', '0.00', '100', '90', NULL, NULL, NULL),
('103', 'Alexander', 'Hunold', 'AHUNOLD', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '590.423.4567', '1987-06-20', 'IT_PROG', '9000.00', '0.00', '102', '60', NULL, NULL, NULL),
('104', 'Bruce', 'Ernst', 'BERNST', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '590.423.4568', '1987-06-21', 'IT_PROG', '6000.00', '0.00', '103', '60', NULL, NULL, NULL),
('105', 'David', 'Austin', 'DAUSTIN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '590.423.4569', '1987-06-22', 'IT_PROG', '4800.00', '0.00', '103', '60', NULL, NULL, NULL),
('106', 'Valli', 'Pataballa', 'VPATABAL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '590.423.4560', '1987-06-23', 'IT_PROG', '4800.00', '0.00', '103', '60', NULL, NULL, NULL),
('107', 'Diana', 'Lorentz', 'DLORENTZ', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '590.423.5567', '1987-06-24', 'IT_PROG', '4200.00', '0.00', '103', '60', NULL, NULL, NULL),
('108', 'Nancy', 'Greenberg', 'NGREENBE', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.124.4569', '1987-06-25', 'FI_MGR', '12000.00', '0.00', '101', '100', NULL, NULL, NULL),
('109', 'Daniel', 'Faviet', 'DFAVIET', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.124.4169', '1987-06-26', 'FI_ACCOUNT', '9000.00', '0.00', '108', '100', NULL, NULL, NULL),
('110', 'John', 'Chen', 'JCHEN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.124.4269', '1987-06-27', 'FI_ACCOUNT', '8200.00', '0.00', '108', '100', NULL, NULL, NULL),
('111', 'Ismael', 'Sciarra', 'ISCIARRA', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.124.4369', '1987-06-28', 'FI_ACCOUNT', '7700.00', '0.00', '108', '100', NULL, NULL, NULL),
('112', 'Jose Manuel', 'Urman', 'JMURMAN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.124.4469', '1987-06-29', 'FI_ACCOUNT', '7800.00', '0.00', '108', '100', NULL, NULL, NULL),
('113', 'Luis', 'Popp', 'LPOPP', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.124.4567', '1987-06-30', 'FI_ACCOUNT', '6900.00', '0.00', '108', '100', NULL, NULL, NULL),
('114', 'Den', 'Raphaely', 'DRAPHEAL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.127.4561', '1987-07-01', 'PU_MAN', '11000.00', '0.00', '100', '30', NULL, NULL, NULL),
('115', 'Alexander', 'Khoo', 'AKHOO', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.127.4562', '1987-07-02', 'PU_CLERK', '3100.00', '0.00', '114', '30', NULL, NULL, NULL),
('116', 'Shelli', 'Baida', 'SBAIDA', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.127.4563', '1987-07-03', 'PU_CLERK', '2900.00', '0.00', '114', '30', NULL, NULL, NULL),
('117', 'Sigal', 'Tobias', 'STOBIAS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.127.4564', '1987-07-04', 'PU_CLERK', '2800.00', '0.00', '114', '30', NULL, NULL, NULL),
('118', 'Guy', 'Himuro', 'GHIMURO', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.127.4565', '1987-07-05', 'PU_CLERK', '2600.00', '0.00', '114', '30', NULL, NULL, NULL),
('119', 'Karen', 'Colmenares', 'KCOLMENA', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.127.4566', '1987-07-06', 'PU_CLERK', '2500.00', '0.00', '114', '30', NULL, NULL, NULL),
('120', 'Matthew', 'Weiss', 'MWEISS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.123.1234', '1987-07-07', 'ST_MAN', '8000.00', '0.00', '100', '50', NULL, NULL, NULL),
('121', 'Adam', 'Fripp', 'AFRIPP', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.123.2234', '1987-07-08', 'ST_MAN', '8200.00', '0.00', '100', '50', NULL, NULL, NULL),
('122', 'Payam', 'Kaufling', 'PKAUFLIN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.123.3234', '1987-07-09', 'ST_MAN', '7900.00', '0.00', '100', '50', NULL, NULL, NULL),
('124', 'Kevin', 'Mourgos', 'KMOURGOS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.123.5234', '1987-07-11', 'ST_MAN', '5800.00', '0.00', '100', '50', NULL, NULL, NULL),
('125', 'Julia', 'Nayer', 'JNAYER', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.124.1214', '1987-07-12', 'ST_CLERK', '3200.00', '0.00', '120', '50', NULL, NULL, NULL),
('126', 'Irene', 'Mikkilineni', 'IMIKKILI', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.124.1224', '1987-07-13', 'ST_CLERK', '2700.00', '0.00', '120', '50', NULL, NULL, NULL),
('127', 'James', 'Landry', 'JLANDRY', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.124.1334', '1987-07-14', 'ST_CLERK', '2400.00', '0.00', '120', '50', NULL, NULL, NULL),
('128', 'Steven', 'Markle', 'SMARKLE', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.124.1434', '1987-07-15', 'ST_CLERK', '2200.00', '0.00', '120', '50', NULL, NULL, NULL),
('129', 'Laura', 'Bissot', 'LBISSOT', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.124.5234', '1987-07-16', 'ST_CLERK', '3300.00', '0.00', '121', '50', NULL, NULL, NULL),
('130', 'Mozhe', 'Atkinson', 'MATKINSO', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.124.6234', '1987-07-17', 'ST_CLERK', '2800.00', '0.00', '121', '50', NULL, NULL, NULL),
('131', 'James', 'Marlow', 'JAMRLOW', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.124.7234', '1987-07-18', 'ST_CLERK', '2500.00', '0.00', '121', '50', NULL, NULL, NULL),
('132', 'TJ', 'Olson', 'TJOLSON', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.124.8234', '1987-07-19', 'ST_CLERK', '2100.00', '0.00', '121', '50', NULL, NULL, NULL),
('133', 'Jason', 'Mallin', 'JMALLIN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.127.1934', '1987-07-20', 'ST_CLERK', '3300.00', '0.00', '122', '50', NULL, NULL, NULL),
('134', 'Michael', 'Rogers', 'MROGERS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.127.1834', '1987-07-21', 'ST_CLERK', '2900.00', '0.00', '122', '50', NULL, NULL, NULL),
('135', 'Ki', 'Gee', 'KGEE', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.127.1734', '1987-07-22', 'ST_CLERK', '2400.00', '0.00', '122', '50', NULL, NULL, NULL),
('136', 'Hazel', 'Philtanker', 'HPHILTAN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.127.1634', '1987-07-23', 'ST_CLERK', '2200.00', '0.00', '122', '50', NULL, NULL, NULL),
('137', 'Renske', 'Ladwig', 'RLADWIG', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.121.1234', '1987-07-24', 'ST_CLERK', '3600.00', '0.00', '123', '50', NULL, NULL, NULL),
('138', 'Stephen', 'Stiles', 'SSTILES', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.121.2034', '1987-07-25', 'ST_CLERK', '3200.00', '0.00', '123', '50', NULL, NULL, NULL),
('139', 'John', 'Seo', 'JSEO', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.121.2019', '1987-07-26', 'ST_CLERK', '2700.00', '0.00', '123', '50', NULL, NULL, NULL),
('140', 'Joshua', 'Patel', 'JPATEL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.121.1834', '1987-07-27', 'ST_CLERK', '2500.00', '0.00', '123', '50', NULL, NULL, NULL),
('141', 'Trenna', 'Rajs', 'TRAJS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.121.8009', '1987-07-28', 'ST_CLERK', '3500.00', '0.00', '124', '50', NULL, NULL, NULL),
('142', 'Curtis', 'Davies', 'CDAVIES', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.121.2994', '1987-07-29', 'ST_CLERK', '3100.00', '0.00', '124', '50', NULL, NULL, NULL),
('143', 'Randall', 'Matos', 'RMATOS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.121.2874', '1987-07-30', 'ST_CLERK', '2600.00', '0.00', '124', '50', NULL, NULL, NULL),
('144', 'Peter', 'Vargas', 'PVARGAS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.121.2004', '1987-07-31', 'ST_CLERK', '2500.00', '0.00', '124', '50', NULL, NULL, NULL),
('145', 'John', 'Russell', 'JRUSSEL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.429268', '1987-08-01', 'SA_MAN', '14000.00', '0.40', '100', '80', NULL, NULL, NULL),
('146', 'Karen', 'Partners', 'KPARTNER', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.467268', '1987-08-02', 'SA_MAN', '13500.00', '0.30', '100', '80', NULL, NULL, NULL),
('147', 'Alberto', 'Errazuriz', 'AERRAZUR', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.429278', '1987-08-03', 'SA_MAN', '12000.00', '0.30', '100', '80', NULL, NULL, NULL),
('148', 'Gerald', 'Cambrault', 'GCAMBRAU', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.619268', '1987-08-04', 'SA_MAN', '11000.00', '0.30', '100', '80', NULL, NULL, NULL),
('149', 'Eleni', 'Zlotkey', 'EZLOTKEY', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.429018', '1987-08-05', 'SA_MAN', '10500.00', '0.20', '100', '80', NULL, NULL, NULL),
('150', 'Peter', 'Tucker', 'PTUCKER', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.129268', '1987-08-06', 'SA_REP', '10000.00', '0.30', '145', '80', NULL, NULL, NULL),
('151', 'David', 'Bernstein', 'DBERNSTE', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.345268', '1987-08-07', 'SA_REP', '9500.00', '0.25', '145', '80', NULL, NULL, NULL),
('152', 'Peter', 'Hall', 'PHALL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.478968', '1987-08-08', 'SA_REP', '9000.00', '0.25', '145', '80', NULL, NULL, NULL),
('153', 'Christopher', 'Olsen', 'COLSEN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.498718', '1987-08-09', 'SA_REP', '8000.00', '0.20', '145', '80', NULL, NULL, NULL),
('154', 'Nanette', 'Cambrault', 'NCAMBRAU', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.987668', '1987-08-10', 'SA_REP', '7500.00', '0.20', '145', '80', NULL, NULL, NULL),
('155', 'Oliver', 'Tuvault', 'OTUVAULT', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1344.486508', '1987-08-11', 'SA_REP', '7000.00', '0.15', '145', '80', NULL, NULL, NULL),
('156', 'Janette', 'King', 'JKING', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1345.429268', '1987-08-12', 'SA_REP', '10000.00', '0.35', '146', '80', NULL, NULL, NULL),
('157', 'Patrick', 'Sully', 'PSULLY', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1345.929268', '1987-08-13', 'SA_REP', '9500.00', '0.35', '146', '80', NULL, NULL, NULL),
('158', 'Allan', 'McEwen', 'AMCEWEN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1345.829268', '1987-08-14', 'SA_REP', '9000.00', '0.35', '146', '80', NULL, NULL, NULL),
('159', 'Lindsey', 'Smith', 'LSMITH', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1345.729268', '1987-08-15', 'SA_REP', '8000.00', '0.30', '146', '80', NULL, NULL, NULL),
('160', 'Louise', 'Doran', 'LDORAN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1345.629268', '1987-08-16', 'SA_REP', '7500.00', '0.30', '146', '80', NULL, NULL, NULL),
('161', 'Sarath', 'Sewall', 'SSEWALL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1345.529268', '1987-08-17', 'SA_REP', '7000.00', '0.25', '146', '80', NULL, NULL, NULL),
('162', 'Clara', 'Vishney', 'CVISHNEY', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1346.129268', '1987-08-18', 'SA_REP', '10500.00', '0.25', '147', '80', NULL, NULL, NULL),
('163', 'Danielle', 'Greene', 'DGREENE', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1346.229268', '1987-08-19', 'SA_REP', '9500.00', '0.15', '147', '80', NULL, NULL, NULL),
('164', 'Mattea', 'Marvins', 'MMARVINS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1346.329268', '1987-08-20', 'SA_REP', '7200.00', '0.10', '147', '80', NULL, NULL, NULL),
('165', 'David', 'Lee', 'DLEE', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1346.529268', '1987-08-21', 'SA_REP', '6800.00', '0.10', '147', '80', NULL, NULL, NULL),
('166', 'Sundar', 'Ande', 'SANDE', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1346.629268', '1987-08-22', 'SA_REP', '6400.00', '0.10', '147', '80', NULL, NULL, NULL),
('167', 'Amit', 'Banda', 'ABANDA', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1346.729268', '1987-08-23', 'SA_REP', '6200.00', '0.10', '147', '80', NULL, NULL, NULL),
('168', 'Lisa', 'Ozer', 'LOZER', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1343.929268', '1987-08-24', 'SA_REP', '11500.00', '0.25', '148', '80', NULL, NULL, NULL),
('169', 'Harrison', 'Bloom', 'HBLOOM', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1343.829268', '1987-08-25', 'SA_REP', '10000.00', '0.20', '148', '80', NULL, NULL, NULL),
('170', 'Tayler', 'Fox', 'TFOX', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1343.729268', '1987-08-26', 'SA_REP', '9600.00', '0.20', '148', '80', NULL, NULL, NULL),
('171', 'William', 'Smith', 'WSMITH', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1343.629268', '1987-08-27', 'SA_REP', '7400.00', '0.15', '148', '80', NULL, NULL, NULL),
('172', 'Elizabeth', 'Bates', 'EBATES', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1343.529268', '1987-08-28', 'SA_REP', '7300.00', '0.15', '148', '80', NULL, NULL, NULL),
('173', 'Sundita', 'Kumar', 'SKUMAR', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1343.329268', '1987-08-29', 'SA_REP', '6100.00', '0.10', '148', '80', NULL, NULL, NULL),
('174', 'Ellen', 'Abel', 'EABEL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1644.429267', '1987-08-30', 'SA_REP', '11000.00', '0.30', '149', '80', NULL, NULL, NULL),
('175', 'Alyssa', 'Hutton', 'AHUTTON', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1644.429266', '1987-08-31', 'SA_REP', '8800.00', '0.25', '149', '80', NULL, NULL, NULL),
('176', 'Jonathon', 'Taylor', 'JTAYLOR', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1644.429265', '1987-09-01', 'SA_REP', '8600.00', '0.20', '149', '80', NULL, NULL, NULL),
('177', 'Jack', 'Livingston', 'JLIVINGS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1644.429264', '1987-09-02', 'SA_REP', '8400.00', '0.20', '149', '80', NULL, NULL, NULL),
('178', 'Kimberely', 'Grant', 'KGRANT', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1644.429263', '1987-09-03', 'SA_REP', '7000.00', '0.15', '149', '80', NULL, NULL, NULL),
('179', 'Charles', 'Johnson', 'CJOHNSON', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '011.44.1644.429262', '1987-09-04', 'SA_REP', '6200.00', '0.10', '149', '80', NULL, NULL, NULL),
('180', 'Winston', 'Taylor', 'WTAYLOR', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.507.9876', '1987-09-05', 'SH_CLERK', '3200.00', '0.00', '120', '50', NULL, NULL, NULL),
('181', 'Jean', 'Fleaur', 'JFLEAUR', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.507.9877', '1987-09-06', 'SH_CLERK', '3100.00', '0.00', '120', '50', NULL, NULL, NULL),
('182', 'Martha', 'Sullivan', 'MSULLIVA', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.507.9878', '1987-09-07', 'SH_CLERK', '2500.00', '0.00', '120', '50', NULL, NULL, NULL),
('183', 'Girard', 'Geoni', 'GGEONI', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.507.9879', '1987-09-08', 'SH_CLERK', '2800.00', '0.00', '120', '50', NULL, NULL, NULL),
('184', 'Nandita', 'Sarchand', 'NSARCHAN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.509.1876', '1987-09-09', 'SH_CLERK', '4200.00', '0.00', '121', '50', NULL, NULL, NULL),
('185', 'Alexis', 'Bull', 'ABULL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.509.2876', '1987-09-10', 'SH_CLERK', '4100.00', '0.00', '121', '50', NULL, NULL, NULL),
('186', 'Julia', 'Dellinger', 'JDELLING', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.509.3876', '1987-09-11', 'SH_CLERK', '3400.00', '0.00', '121', '50', NULL, NULL, NULL),
('187', 'Anthony', 'Cabrio', 'ACABRIO', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.509.4876', '1987-09-12', 'SH_CLERK', '3000.00', '0.00', '121', '50', NULL, NULL, NULL),
('188', 'Kelly', 'Chung', 'KCHUNG', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.505.1876', '1987-09-13', 'SH_CLERK', '3800.00', '0.00', '122', '50', NULL, NULL, NULL),
('189', 'Jennifer', 'Dilly', 'JDILLY', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.505.2876', '1987-09-14', 'SH_CLERK', '3600.00', '0.00', '122', '50', NULL, NULL, NULL),
('190', 'Timothy', 'Gates', 'TGATES', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.505.3876', '1987-09-15', 'SH_CLERK', '2900.00', '0.00', '122', '50', NULL, NULL, NULL),
('191', 'Randall', 'Perkins', 'RPERKINS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.505.4876', '1987-09-16', 'SH_CLERK', '2500.00', '0.00', '122', '50', NULL, NULL, NULL),
('192', 'Sarah', 'Bell', 'SBELL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.501.1876', '1987-09-17', 'SH_CLERK', '4000.00', '0.00', '123', '50', NULL, NULL, NULL),
('193', 'Britney', 'Everett', 'BEVERETT', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.501.2876', '1987-09-18', 'SH_CLERK', '3900.00', '0.00', '123', '50', NULL, NULL, NULL),
('194', 'Samuel', 'McCain', 'SMCCAIN', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.501.3876', '1987-09-19', 'SH_CLERK', '3200.00', '0.00', '123', '50', NULL, NULL, NULL),
('195', 'Vance', 'Jones', 'VJONES', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.501.4876', '1987-09-20', 'SH_CLERK', '2800.00', '0.00', '123', '50', NULL, NULL, NULL),
('196', 'Alana', 'Walsh', 'AWALSH', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.507.9811', '1987-09-21', 'SH_CLERK', '3100.00', '0.00', '124', '50', NULL, NULL, NULL),
('197', 'Kevin', 'Feeney', 'KFEENEY', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.507.9822', '1987-09-22', 'SH_CLERK', '3000.00', '0.00', '124', '50', NULL, NULL, NULL),
('198', 'Donald', 'OConnell', 'DOCONNEL', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.507.9833', '1987-09-23', 'SH_CLERK', '2600.00', '0.00', '124', '50', NULL, NULL, NULL),
('199', 'Douglas', 'Grant', 'DGRANT', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '650.507.9844', '1987-09-24', 'SH_CLERK', '2600.00', '0.00', '124', '50', NULL, NULL, NULL),
('201', 'Michael', 'Hartstein', 'MHARTSTE', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.123.5555', '1987-09-26', 'MK_MAN', '13000.00', '0.00', '100', '20', NULL, NULL, NULL),
('202', 'Pat', 'Fay', 'PFAY', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '603.123.6666', '1987-09-27', 'MK_REP', '6000.00', '0.00', '201', '20', NULL, NULL, NULL),
('203', 'Susan', 'Mavris', 'SMAVRIS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.123.7777', '1987-09-28', 'HR_REP', '6500.00', '0.00', '101', '40', NULL, NULL, NULL),
('204', 'Hermann', 'Baer', 'HBAER', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.123.8888', '1987-09-29', 'PR_REP', '10000.00', '0.00', '101', '70', NULL, NULL, NULL),
('205', 'Shelley', 'Higgins', 'SHIGGINS', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.123.8080', '1987-09-30', 'AC_MGR', '12000.00', '0.00', '101', '110', NULL, NULL, NULL),
('206', 'William', 'Gietz', 'WGIETZ', '$2a$10$OZwtWO6m0OgKFTgdNhY5FulzP6exepdw0uG5TS0ExaQK4cP1BE8di', '515.123.8181', '1987-10-01', 'AC_ACCOUNT', '8300.00', '0.00', '205', '110', NULL, NULL, NULL),
('207', 'sgf', 'jkj', 'a.ster@outlook.fr', '$2a$10$sk7uaAxu0T9QED3phSbrz.NQz0rv0.aikpr6gVqv7rbrgsPXdBXFa', 'kjl', '2019-01-10', 'AD_PRES', '0.00', NULL, NULL, '20', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(13);

-- --------------------------------------------------------

--
-- Structure de la table `jobs`
--

CREATE TABLE IF NOT EXISTS `jobs` (
  `JOB_ID` varchar(10) NOT NULL DEFAULT '',
  `JOB_TITLE` varchar(35) NOT NULL,
  `MIN_SALARY` decimal(6,0) DEFAULT NULL,
  `MAX_SALARY` decimal(6,0) DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jobs`
--

INSERT INTO `jobs` (`JOB_ID`, `JOB_TITLE`, `MIN_SALARY`, `MAX_SALARY`) VALUES
('AC_ACCOUNT', 'Franc', '4200', '9000'),
('AC_MGR', 'Accounting Manager', '8200', '16000'),
('AD_ASST', 'Administration Assistant', '3000', '6000'),
('AD_PRES', 'President', '20000', '40000'),
('AD_VP', 'Administration Vice President', '15000', '30000'),
('FI_ACCOUNT', 'Accountant', '4200', '9000'),
('FI_MGR', 'Finance Manager', '8200', '16000'),
('HR_REP', 'Human Resources Representative', '4000', '9000'),
('IT_PROG', 'Programmer', '4000', '10000'),
('MK_MAN', 'Marketing Manager', '9000', '15000'),
('MK_REP', 'Marketing Representative', '4000', '9000'),
('PR_REP', 'Public Relations Representative', '4500', '10500'),
('PU_CLERK', 'Purchasing Clerk', '2500', '5500'),
('PU_MAN', 'Purchasing Manager', '8000', '15000'),
('SA_MAN', 'Sales Manager', '10000', '20000'),
('SA_REP', 'Sales Representative', '6000', '12000'),
('SH_CLERK', 'Shipping Clerk', '2500', '5500'),
('ST_CLERK', 'Stock Clerk', '2000', '5000'),
('ST_MAN', 'Stock Manager', '5500', '8500');

-- --------------------------------------------------------

--
-- Structure de la table `job_history`
--

CREATE TABLE IF NOT EXISTS `job_history` (
  `EMPLOYEE_ID` decimal(6,0) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `JOB_ID` varchar(10) NOT NULL,
  `DEPARTMENT_ID` decimal(4,0) DEFAULT NULL,
  `job_history_list_job_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`,`START_DATE`),
  KEY `JHIST_DEPARTMENT_IX` (`DEPARTMENT_ID`),
  KEY `JHIST_EMPLOYEE_IX` (`EMPLOYEE_ID`),
  KEY `JHIST_JOB_IX` (`JOB_ID`),
  KEY `FKaukpq0xs73gv11iwlmusnekf6` (`job_history_list_job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `job_history`
--

INSERT INTO `job_history` (`EMPLOYEE_ID`, `START_DATE`, `END_DATE`, `JOB_ID`, `DEPARTMENT_ID`, `job_history_list_job_id`) VALUES
('101', '1989-09-21', '1993-10-27', 'AC_ACCOUNT', '110', NULL),
('101', '1993-10-28', '1997-03-15', 'AC_MGR', '110', NULL),
('102', '1993-01-13', '1998-07-24', 'IT_PROG', '60', NULL),
('114', '1998-03-24', '1999-12-31', 'ST_CLERK', '50', NULL),
('122', '1999-01-01', '1999-12-31', 'ST_CLERK', '50', NULL),
('176', '1998-03-24', '1998-12-31', 'SA_REP', '80', NULL),
('176', '1999-01-01', '1999-12-31', 'SA_MAN', '80', NULL),
('201', '1996-02-17', '1999-12-19', 'MK_REP', '20', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `locations`
--

CREATE TABLE IF NOT EXISTS `locations` (
  `LOCATION_ID` decimal(4,0) NOT NULL DEFAULT '0',
  `STREET_ADDRESS` varchar(40) DEFAULT NULL,
  `POSTAL_CODE` varchar(12) DEFAULT NULL,
  `CITY` varchar(30) NOT NULL,
  `STATE_PROVINCE` varchar(25) DEFAULT NULL,
  `COUNTRY_ID` varchar(2) DEFAULT NULL,
  `country_id_country_id` varchar(255) DEFAULT NULL,
  `location_id_department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`LOCATION_ID`),
  KEY `LOC_CITY_IX` (`CITY`),
  KEY `LOC_COUNTRY_IX` (`COUNTRY_ID`),
  KEY `LOC_STATE_PROVINCE_IX` (`STATE_PROVINCE`),
  KEY `FK75a3erb06r1toxgragfu7bp4h` (`country_id_country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `locations`
--

INSERT INTO `locations` (`LOCATION_ID`, `STREET_ADDRESS`, `POSTAL_CODE`, `CITY`, `STATE_PROVINCE`, `COUNTRY_ID`, `country_id_country_id`, `location_id_department_id`) VALUES
('1000', '1297 Via Cola di Rie', '989', 'Roma', '', 'IT', NULL, NULL),
('1200', '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP', NULL, NULL),
('1300', '9450 Kamiya-cho', '6823', 'Hiroshima', '', 'JP', NULL, NULL),
('1400', '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US', NULL, NULL),
('1500', '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US', NULL, NULL),
('1600', '2007 Zagora St', '50090', 'South Brunswick', 'New Jersey', 'US', NULL, NULL),
('1700', '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US', NULL, NULL),
('1800', '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA', NULL, NULL),
('1900', '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA', NULL, NULL),
('2000', '40-5-12 Laogianggen', '190518', 'Beijing', '', 'CN', NULL, NULL),
('2100', '1298 Vileparle (E)', '490231', 'Bombay', 'Maharashtra', 'IN', NULL, NULL),
('2200', '12-98 Victoria Street', '2901', 'Sydney', 'New South Wales', 'AU', NULL, NULL),
('2300', '198 Clementi North', '540198', 'Singapore', '', 'SG', NULL, NULL),
('2400', '8204 Arthur St', '', 'London', '', 'UK', NULL, NULL),
('2500', '"Magdalen Centre', ' The Oxford ', 'OX9 9ZB', 'Oxford', 'UK', NULL, NULL),
('2600', '9702 Chester Road', '9629850293', 'Stretford', 'Manchester', 'UK', NULL, NULL),
('2700', 'Schwanthalerstr. 7031', '80925', 'Munich', 'Bavaria', 'DE', NULL, NULL),
('2800', 'Rua Frei Caneca 1360', '01307-002', 'Sao Paulo', 'Sao Paulo', 'BR', NULL, NULL),
('2900', '20 Rue des Corps-Saints', '1730', 'Geneva', 'Geneve', 'CH', NULL, NULL),
('3000', 'Murtenstrasse 921', '3095', 'Bern', 'BE', 'CH', NULL, NULL),
('3100', 'Pieter Breughelstraat 837', '3029SK', 'Utrecht', 'Utrecht', 'NL', NULL, NULL),
('3200', 'Mariano Escobedo 9991', '11932', 'Mexico City', '"Distrito Federal', 'MX', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `regions`
--

CREATE TABLE IF NOT EXISTS `regions` (
  `REGION_ID` decimal(5,0) NOT NULL,
  `REGION_NAME` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`REGION_ID`),
  UNIQUE KEY `sss` (`REGION_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `regions`
--

INSERT INTO `regions` (`REGION_ID`, `REGION_NAME`) VALUES
('2', 'Americas'),
('3', 'Asia'),
('1', 'Europe'),
('4', 'Middle East and Africa');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `countries`
--
ALTER TABLE `countries`
  ADD CONSTRAINT `FKr1fmqmei20mceuddty8cympx` FOREIGN KEY (`REGION_ID`) REFERENCES `regions` (`REGION_ID`);

--
-- Contraintes pour la table `departments`
--
ALTER TABLE `departments`
  ADD CONSTRAINT `FKqsrwrq8xt10jqu1jjwpdnvnno` FOREIGN KEY (`LOCATION_ID`) REFERENCES `locations` (`LOCATION_ID`);

--
-- Contraintes pour la table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `FK316bjxe1mvbugkqpbryjsr87j` FOREIGN KEY (`job_id_job_id`) REFERENCES `jobs` (`JOB_ID`),
  ADD CONSTRAINT `FKgy4qe3dnqrm3ktd76sxp7n4c2` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `departments` (`DEPARTMENT_ID`),
  ADD CONSTRAINT `FKnpqyu6u0fdh2rmqtoue23gxb4` FOREIGN KEY (`JOB_ID`) REFERENCES `jobs` (`JOB_ID`);

--
-- Contraintes pour la table `job_history`
--
ALTER TABLE `job_history`
  ADD CONSTRAINT `FK6wr8te1t0a1gqbfkfgtqhhkqf` FOREIGN KEY (`JOB_ID`) REFERENCES `jobs` (`JOB_ID`),
  ADD CONSTRAINT `FK7y43ipy5e5g2jd2vaiskn76c9` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `departments` (`DEPARTMENT_ID`),
  ADD CONSTRAINT `FKaukpq0xs73gv11iwlmusnekf6` FOREIGN KEY (`job_history_list_job_id`) REFERENCES `jobs` (`JOB_ID`),
  ADD CONSTRAINT `FKhbqeamoyj90wvkw4a25camb4n` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employees` (`EMPLOYEE_ID`);

--
-- Contraintes pour la table `locations`
--
ALTER TABLE `locations`
  ADD CONSTRAINT `FK75a3erb06r1toxgragfu7bp4h` FOREIGN KEY (`country_id_country_id`) REFERENCES `countries` (`COUNTRY_ID`),
  ADD CONSTRAINT `FKqkdn2dl5vjl7ogslbs6g01hsu` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `countries` (`COUNTRY_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
