-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  localhost
-- Généré le :  Sam 02 Juin 2018 à 11:58
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `realestate`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `profile_pic` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`, `name`, `last_name`, `phone`, `profile_pic`) VALUES
(1, 'admin@gmail.com', '00000000', 'Med Amine', 'admin', '0555882079', 'default_profile_picture.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `agent`
--

CREATE TABLE `agent` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `gender` varchar(255) NOT NULL,
  `blocked` int(1) NOT NULL DEFAULT '1',
  `locale` enum('1','2','3','4','5') NOT NULL,
  `profile_pic` varchar(255) NOT NULL,
  `cv` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `agent`
--

INSERT INTO `agent` (`id`, `email`, `password`, `username`, `name`, `last_name`, `birthdate`, `gender`, `blocked`, `locale`, `profile_pic`, `cv`, `phone`) VALUES
(6, 'agent02@gmail.com', '00000000', 'agent02', 'agent', 'amine', '2002-12-17', 'male', 1, '1', 'default_profile_picture.jpg', '', '0559797985'),
(7, 'agent03@gmail.com', '00000000', 'agent03', 'agent', 'agent', '1995-06-27', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(8, 'agent04@gmail.com', '00000000', 'agent04', 'agent04', 'agent04', '1995-06-07', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(9, 'agent05@gmail.com', '00000000', 'agent05', 'agent05', 'agent05', '1989-06-07', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(10, 'agent06@gmail.com', '00000000', 'agent06', 'agent06', 'agent06', '1989-06-07', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(11, 'agent07@gmail.com', '00000000', 'agent07', 'agent07', 'agent07', '1989-06-07', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(12, 'agent08@gmail.com', '00000000', 'agent08', 'agent08', 'agent08', '1989-06-07', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(13, 'agent09@gmail.com', '00000000', 'agent09', 'agent09', 'agent09', '1989-09-18', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(14, 'agent10@gmail.com', '00000000', 'agent10', 'agent10', 'agent10', '1975-09-18', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(15, 'agent11@gmail.com', '00000000', 'agent11', 'agent11', 'agent11', '1975-09-18', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(16, 'agent12@gmail.com', '00000000', 'agent12', 'agent12', 'agent12', '1975-09-18', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(17, 'agent13@gmail.com', '00000000', 'agent13', 'agent13', 'agent13', '1975-09-18', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(18, 'agent14@gmail.com', '00000000', 'agent14', 'agent14', 'agent14', '0000-00-00', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(19, 'agent15@gmail.com', '00000000', 'agent15', 'agent15', 'agent15', '1985-02-07', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(20, 'agent16@gmail.com', '00000000', 'agent16', 'agent16', 'agent16', '1985-02-07', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(21, 'agent17@gmail.com', '00000000', 'agent17', 'agent17', 'agent17', '1985-02-07', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(22, 'agent18@gmail.com', '00000000', 'agent18', 'agent18', 'agent18', '1985-02-07', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(23, 'agent19@gmail.com', '00000000', 'agent19', 'agent19', 'agent19', '1985-02-07', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(24, 'agent20@gmail.com', '00000000', 'agent20', 'agent20', 'agent20', '1985-02-07', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(25, 'agent21@gmail.com', '00000000', 'agent21', 'agent21', 'agent21', '1992-06-17', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(26, 'agent22@gmail.com', '00000000', 'agent22', 'agent22', 'agent22', '1992-06-17', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(27, 'agent23@gmail.com', '00000000', 'agent23', 'agent23', 'agent23', '1992-06-17', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(28, 'agent24@gmail.com', '00000000', 'agent24', 'agent24', 'agent24', '1992-06-17', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(29, 'agent25@gmail.com', '00000000', 'agent25', 'agent25', 'agent25', '1992-06-17', 'male', 1, '1', 'default_profile_picture.jpg', '', '0559797985'),
(30, 'agent26@gmail.com', '00000000', 'agent26', 'agent26', 'agent26', '1992-06-17', 'male', 0, '1', 'default_profile_picture.jpg', '', '0559797985'),
(31, 'agent27@gmail.com', '00000000', 'agent27', 'agent27', 'agent27', '1985-05-07', 'male', 0, '1', 'default_profile_picture.jpg', '', '0559797985'),
(32, 'agent28@gmail.com', '00000000', 'agent28', 'agent28', 'agent28', '1985-05-07', 'male', 0, '1', 'default_profile_picture.jpg', '', '0559797985'),
(33, 'agent29@gmail.com', '00000000', 'agent29', 'agent-29', 'agent29', '1985-05-07', 'male', 0, '1', 'default_profile_picture.jpg', '', '0559797985'),
(34, 'agent30@gmail.com', '00000000', 'agent30', 'agent30', 'agent30', '1985-05-07', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(35, 'agent31@gmail.com', '00000000', 'agent31', 'agent31', 'agent31', '1985-05-07', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(36, 'agent32@gmail.com', '00000000', 'agent32', 'agent32', 'agent32', '1985-05-07', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(37, 'agent33@gmail.com', '00000000', 'agent33', 'agent33', 'agent33', '1990-08-08', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(38, 'agent34@gmail.com', '00000000', 'agent34', 'agent34', 'agent34', '1990-08-08', 'male', 0, '5', 'default_profile_picture.jpg', '', '0559797985'),
(39, 'agent35@gmail.com', '00000000', 'agent35', 'agent35', 'agent35', '1990-08-08', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(40, 'agent36@gmail.com', '00000000', 'agent36', 'agent36', 'agent36', '1990-08-08', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(41, 'agent37@gmail.com', '00000000', 'agent37', 'agent37', 'agent37', '1990-08-08', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(42, 'agent38@gmail.com', '00000000', 'agent38', 'agent38', 'agent38', '1990-08-08', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(43, 'agent39@gmail.com', '00000000', 'agent39', 'agent39', 'agent39', '1991-02-10', 'male', 0, '2', 'default_profile_picture.jpg', '', '0559797985'),
(44, 'agent40@gmail.com', '00000000', 'agent40', 'agent40', 'agent40', '1991-02-10', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(45, 'agent41@gmail.com', '00000000', 'agent41', 'agent41', 'agent41', '1991-02-10', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(46, 'agent42@gmail.com', '00000000', 'agent42', 'agent42', 'agent42', '1991-02-10', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(47, 'agent43@gmail.com', '00000000', 'agent43', 'agent43', 'agent43', '1991-02-10', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(48, 'agent44@gmail.com', '00000000', 'agent44', 'agent44', 'agent44', '1991-02-10', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(49, 'agent45@gmail.com', '00000000', 'agent45', 'agent45', 'agent45', '1978-04-12', 'male', 0, '3', 'default_profile_picture.jpg', '', '0559797985'),
(50, 'agent46@gmail.com', '00000000', 'agent46', 'agent46', 'agent46', '1978-04-12', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(51, 'agent47@gmail.com', '00000000', 'agent47', 'agent47', 'agent47', '1978-04-12', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(52, 'agent48@gmail.com', '00000000', 'agent48', 'agent48', 'agent48', '1978-04-12', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(53, 'agent49@gmail.com', '00000000', 'agent49', 'agent49', 'agent49', '1978-04-12', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(54, 'agent50@gmail.com', '00000000', 'agent50', 'agent50', 'agent50', '1978-04-12', 'male', 0, '4', 'default_profile_picture.jpg', '', '0559797985'),
(55, 'agent51@gmail.com', '00000000', 'agent55', 'amine', 'amine', '2002-12-18', 'male', 0, '1', 'default_profile_picture.jpg', '1527044808714.jpg', '0559559598'),
(56, 'agent56@gmail.com', '00000000', 'agent56', 'agent', 'agent', '1991-11-28', 'male', 1, '1', '1527549545174.jpg', 'agent56-cv.jpg', '0559595959'),
(57, 'agent57@gmail.com', '00000000', 'agent57', 'agent', 'agent', '2000-01-01', 'male', 1, '5', '1527549824009.jpg', 'agent57-cv.jpg', '0559595959'),
(58, 'agent58@gmail.com', '00000000', 'agent58', 'agent', 'agent', '2000-01-01', 'male', 1, '1', '1527550017718.png', 'agent58-cv.jpg', '0559595959');

-- --------------------------------------------------------

--
-- Structure de la table `appointement`
--

CREATE TABLE `appointement` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `first_half` int(11) NOT NULL DEFAULT '0',
  `second_half` int(11) NOT NULL DEFAULT '0',
  `id_agent` int(11) NOT NULL,
  `id_lodgement` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `client_confirm` int(11) NOT NULL DEFAULT '0',
  `agent_confirm` int(11) NOT NULL DEFAULT '0',
  `review` varchar(255) NOT NULL,
  `canceled` int(1) NOT NULL DEFAULT '0',
  `canceler` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `appointement`
--

INSERT INTO `appointement` (`id`, `date`, `first_half`, `second_half`, `id_agent`, `id_lodgement`, `id_client`, `client_confirm`, `agent_confirm`, `review`, `canceled`, `canceler`) VALUES
(160, '2018-05-30', 1, 0, 30, 68, 4, 0, 0, '', 1, 'client'),
(161, '2018-05-29', 1, 0, 30, 38, 4, 1, 0, '', 1, 'client'),
(162, '2018-05-29', 0, 1, 33, 38, 4, 0, 0, '', 1, 'client'),
(163, '2018-06-03', 1, 0, 30, 39, 4, 0, 0, '', 1, 'client'),
(164, '2018-05-30', 0, 1, 30, 39, 4, 0, 0, '', 1, 'client'),
(165, '2018-05-30', 1, 0, 30, 39, 4, 0, 0, '', 1, 'client'),
(166, '2018-05-31', 1, 0, 33, 57, 4, 0, 0, '', 1, 'client'),
(167, '2018-05-29', 1, 0, 30, 44, 4, 0, 0, '', 1, 'client'),
(168, '2018-05-30', 0, 1, 30, 40, 4, 0, 0, '', 1, 'client'),
(169, '2018-05-30', 0, 1, 30, 40, 1, 0, 0, '', 0, ''),
(170, '2018-05-29', 1, 0, 55, 38, 14, 0, 0, '', 1, 'client'),
(172, '2018-08-10', 0, 1, 32, 43, 4, 0, 0, '', 0, ''),
(173, '2018-05-30', 1, 0, 30, 39, 14, 0, 0, '', 1, 'client'),
(174, '2018-07-18', 0, 1, 33, 47, 14, 0, 0, '', 0, ''),
(175, '2018-08-08', 0, 1, 30, 51, 14, 0, 0, '', 1, 'agent'),
(176, '2018-05-31', 0, 1, 30, 40, 4, 0, 0, '', 1, 'agent'),
(177, '2018-06-06', 0, 1, 30, 43, 4, 0, 0, '', 1, 'client'),
(178, '2018-06-01', 1, 0, 30, 38, 4, 0, 0, '', 0, ''),
(179, '2018-06-01', 0, 1, 30, 38, 14, 0, 0, '', 0, ''),
(180, '2018-06-02', 1, 0, 30, 38, 14, 0, 0, '', 0, ''),
(181, '2018-06-02', 0, 1, 30, 38, 14, 0, 0, '', 0, '');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `gender` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `blocked` int(1) NOT NULL DEFAULT '0',
  `profile_pic` varchar(255) NOT NULL DEFAULT 'default_profile_picture.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `email`, `password`, `username`, `name`, `last_name`, `birthdate`, `gender`, `phone`, `blocked`, `profile_pic`) VALUES
(1, 'amine@gmail.com', '00000000', 'amine77', 'amine', 'griche', '1995-06-27', 'male', '0559377270', 1, 'default_profile_picture.jpg'),
(2, 'amine.griche77@gmail.com', '00000000', 'amine77', 'amine', 'griche', '2018-04-23', 'male', '0559767676', 0, 'default_profile_picture.jpg'),
(4, 'amine01@gmail.com', '00000000', 'amine01', 'amine', 'griche', '2002-12-11', 'male', '0559767676', 0, 'default_profile_picture.jpg'),
(5, 'amine02@gmail.com', '00000000', 'amine02', 'amine', 'amine', '2002-12-04', 'male', '0559767676', 0, 'default_profile_picture.jpg'),
(6, 'amine03@gmail.com', '00000000', 'amine03', 'amine', 'amine', '1995-06-27', 'male', '0559677270', 0, 'default_profile_picture.jpg'),
(7, 'amine05@gmail.com', '00000000', 'amine05', 'amine', 'amine', '2002-12-18', 'male', '0559559598', 0, 'default_profile_picture.jpg'),
(8, 'amine06@gmail.com', '00000000', 'amine06', 'amine', 'amine', '2002-12-09', 'male', '0559559598', 0, 'default_profile_picture.jpg'),
(9, 'amine07@gmail.com', '00000000', 'amine07', 'amine', 'amine', '2002-12-09', 'male', '0559559598', 0, 'default_profile_picture.jpg'),
(10, 'amine08@gmail.com', '00000000', 'amine08', 'amine', 'amine', '2002-12-09', 'male', '0559559598', 0, 'default_profile_picture.jpg'),
(11, 'amine09@gmail.com', '00000000', 'amine09', 'amine', 'amine', '2002-12-09', 'male', '0559559598', 0, 'default_profile_picture.jpg'),
(12, 'amine10@gmail.com', '00000000', 'amine10', 'amine', 'amine', '2002-12-09', 'male', '0559559598', 0, 'default_profile_picture.jpg'),
(14, 'amine11@gmail.com', '00000000', 'amine11', 'amine', 'amine', '1993-09-24', 'male', '0559767676', 0, '1527548527111.jpg'),
(16, 'amine12@gmail.com', '00000000', 'amine12', 'amine', 'amine', '1994-01-01', 'male', '0559767676', 0, '1527545271828.jpg'),
(17, 'amine13@gmail.com', '00000000', 'added_by_operator', '', '', '0002-11-30', '', '', 0, '');

-- --------------------------------------------------------

--
-- Structure de la table `favorite`
--

CREATE TABLE `favorite` (
  `id` int(11) NOT NULL,
  `id_lodgement` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `favorite`
--

INSERT INTO `favorite` (`id`, `id_lodgement`, `id_client`, `time`) VALUES
(1, 38, 4, '2018-05-31 01:14:14');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Structure de la table `lodgement`
--

CREATE TABLE `lodgement` (
  `id` int(11) NOT NULL,
  `locale` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `surface` double NOT NULL,
  `type` varchar(255) NOT NULL,
  `floor` int(11) NOT NULL,
  `price` double NOT NULL,
  `pics` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `lodgement`
--

INSERT INTO `lodgement` (`id`, `locale`, `address`, `surface`, `type`, `floor`, `price`, `pics`) VALUES
(38, '1', 'alger', 50, 'F1', 2, 15000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(39, '1', 'alger', 50, 'F1', 2, 15000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(40, '1', 'annaba', 100, 'F2', 1, 12000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(41, '1', 'tipaza', 120, 'F3', 2, 10000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(42, '1', 'alger', 200, 'F4', 5, 8000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(43, '1', 'tipaza', 250, 'F5', 4, 20000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(44, '1', 'oran', 41, 'F1', 3, 25000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(45, '1', 'tipaza', 86, 'F2', 2, 18000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(46, '1', 'oran', 55, 'F2', 1, 17000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(47, '1', 'alger', 82, 'F3', 1, 18000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(48, '1', 'tipaza', 92, 'F3', 2, 15500000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(49, '1', 'constantine', 38, 'F1', 5, 14600000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(50, '1', 'jijle', 123, 'F4', 4, 19800000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(51, '1', 'alger', 142, 'F4', 3, 11200000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(52, '1', 'annaba', 180, 'F5', 2, 15200000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(53, '1', 'oran', 205, 'F5', 1, 19800000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(54, '1', 'jijle', 70, 'F2', 5, 17800000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(55, '1', 'annaba', 90, 'F3', 2, 11300000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(56, '1', 'alger', 50, 'F1', 4, 28000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(57, '1', 'oran', 142, 'F4', 2, 35000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(58, '1', 'alger', 182, 'F5', 1, 50000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(59, '1', 'oran', 191, 'F5', 3, 31500000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(60, '1', 'jijle', 220, 'F5', 3, 23000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(61, '1', 'annaba', 32, 'F1', 5, 11000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(62, '1', 'oran', 51, 'F2', 2, 21000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(63, '1', 'jijle', 50, 'F4', 4, 22000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(64, '1', 'oran', 50, 'F3', 1, 21000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(65, '1', 'constantine', 30, 'F1', 1, 23000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(66, '1', 'annaba', 250, 'F5', 2, 24000000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(67, '1', 'alger', 190, 'F4', 3, 24500000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(68, '1', 'constantine', 75, 'F2', 5, 25600000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(69, '1', 'alger', 48, 'F1', 3, 27800000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg'),
(70, '1', 'constantine', 68, 'F3', 2, 14500000, 'pic_01.jpg,pic_02.jpg,pic_03.jpg,pic_04.jpg,pic_05.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `id_appointement` int(11) NOT NULL,
  `client_notif` varchar(255) NOT NULL,
  `agent_notif` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `v_agent` int(1) NOT NULL DEFAULT '0',
  `v_client` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `notification`
--

INSERT INTO `notification` (`id`, `id_appointement`, `client_notif`, `agent_notif`, `time`, `v_agent`, `v_client`) VALUES
(2, 161, 'no_notif', 'The client: amine01 has confirmed his appointement.', '2018-05-28 01:41:43', 1, 1),
(3, 161, 'no_notif', 'The client: amine01 canceled his appointement.', '2018-05-28 01:45:46', 1, 1),
(4, 162, 'no_notif', 'The client: amine01 canceled his appointement.', '2018-05-28 10:25:49', 0, 1),
(5, 160, 'The agent: agent26 has canceled his appointement.', 'no_notif', '2018-05-28 10:31:08', 1, 1),
(6, 163, 'no_notif', 'The client: amine01 canceled his appointement.', '2018-05-28 10:36:41', 1, 1),
(7, 165, 'The agent: agent26 has canceled his appointement.', 'no_notif', '2018-05-28 16:23:55', 1, 1),
(8, 167, 'The appointement has been automaticly canceled due to your non confirmation.', 'The appointement has been automaticly canceled due to the client non confirmation.', '2018-05-28 23:06:32', 1, 1),
(9, 170, 'The appointement has been automaticly canceled due to your non confirmation.', 'The appointement has been automaticly canceled due to the client non confirmation.', '2018-05-28 23:07:02', 0, 1),
(10, 173, 'The appointement has been automaticly canceled due to your non confirmation.', 'The appointement has been automaticly canceled due to the client non confirmation.', '2018-05-30 09:37:29', 1, 1),
(11, 168, 'The appointement has been automaticly canceled due to your non confirmation.', 'The appointement has been automaticly canceled due to the client non confirmation.', '2018-05-30 10:59:13', 1, 1),
(12, 164, 'The appointement has been automaticly canceled due to your non confirmation.', 'The appointement has been automaticly canceled due to the client non confirmation.', '2018-05-30 10:59:13', 1, 1),
(13, 177, 'The agent: agent26 has canceled his appointement.', 'no_notif', '2018-05-30 22:37:00', 1, 1),
(14, 177, 'The agent: agent26 has canceled his appointement.', 'no_notif', '2018-05-30 22:37:29', 1, 1),
(15, 176, 'The agent: agent26 has canceled his appointement.', 'no_notif', '2018-05-30 22:37:33', 1, 1),
(16, 176, 'The agent: agent26 has canceled his appointement.', 'no_notif', '2018-05-30 22:39:12', 1, 1),
(17, 176, 'The agent: agent26 has canceled his appointement.', 'no_notif', '2018-05-30 22:39:35', 1, 1),
(18, 166, 'The appointement has been automaticly canceled due to your non confirmation.', 'The appointement has been automaticly canceled due to the client non confirmation.', '2018-05-31 00:49:21', 0, 1),
(19, 166, 'The appointement has been automaticly canceled due to your non confirmation.', 'The appointement has been automaticly canceled due to the client non confirmation.', '2018-05-31 12:28:07', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `operator`
--

CREATE TABLE `operator` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `gender` varchar(255) NOT NULL,
  `blocked` int(1) NOT NULL DEFAULT '1',
  `locale` int(1) NOT NULL,
  `profile_pic` varchar(255) NOT NULL DEFAULT 'default_profile_picture.jpg',
  `cv` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `operator`
--

INSERT INTO `operator` (`id`, `email`, `password`, `username`, `name`, `last_name`, `birthdate`, `gender`, `blocked`, `locale`, `profile_pic`, `cv`, `phone`) VALUES
(1, 'operator@gmail.com', '00000000', 'operator', 'operator', 'operator', '1995-06-27', 'male', 0, 1, 'default_profile_picture.jpg', '', NULL),
(2, 'operator00@gmail.com', '00000000', 'operator', 'operator', 'amine', '2002-12-25', 'male', 1, 1, 'default_profile_picture.jpg', '', '0559767676');

-- --------------------------------------------------------

--
-- Structure de la table `reports`
--

CREATE TABLE `reports` (
  `id` int(11) NOT NULL,
  `id_appointement` int(11) NOT NULL,
  `repoter` varchar(255) NOT NULL,
  `report` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `v_operator` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `reports`
--

INSERT INTO `reports` (`id`, `id_appointement`, `repoter`, `report`, `time`, `v_operator`) VALUES
(1, 167, 'client', 'There was a probleme', '2018-05-28 11:21:57', 1);

-- --------------------------------------------------------

--
-- Structure de la table `statistcs`
--

CREATE TABLE `statistcs` (
  `id` int(11) NOT NULL,
  `id_visitor` int(11) NOT NULL,
  `type_visitor` varchar(255) NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `statistcs`
--

INSERT INTO `statistcs` (`id`, `id_visitor`, `type_visitor`, `date`) VALUES
(2, 30, 'agent', '2018-05-30 10:50:20'),
(3, 30, 'agent', '2018-05-30 11:10:55'),
(4, 30, 'agent', '2018-05-30 11:11:08'),
(5, 30, 'agent', '2018-05-30 11:11:29'),
(6, 31, 'agent', '2018-05-30 11:35:26'),
(7, 4, 'client', '2018-05-30 11:59:13'),
(8, 4, 'client', '2018-05-30 12:05:09'),
(9, 1, 'operator', '2018-05-30 12:41:37'),
(10, 1, 'operator', '2018-05-30 12:41:45'),
(11, 1, 'operator', '2018-05-30 12:41:49'),
(12, 14, 'client', '2018-05-30 12:41:57'),
(13, 31, 'agent', '2018-05-30 12:42:07'),
(14, 30, 'agent', '2018-05-30 12:42:12'),
(15, 17, 'client', '2018-05-30 12:43:04'),
(16, 14, 'client', '2018-05-30 12:43:13'),
(17, 4, 'client', '2018-05-30 21:34:52'),
(18, 4, 'client', '2018-05-30 21:39:01'),
(19, 4, 'client', '2018-05-30 21:40:40'),
(20, 30, 'agent', '2018-05-30 23:11:34'),
(21, 30, 'agent', '2018-05-30 23:32:23'),
(22, 30, 'agent', '2018-05-30 23:35:30'),
(23, 30, 'agent', '2018-05-30 23:36:57'),
(24, 30, 'agent', '2018-05-30 23:39:09'),
(25, 30, 'agent', '2018-05-30 23:39:33'),
(26, 4, 'client', '2018-05-31 01:49:20'),
(27, 4, 'client', '2018-05-31 01:50:55'),
(28, 30, 'agent', '2018-05-31 01:57:00'),
(29, 4, 'client', '2018-05-31 01:57:15'),
(30, 4, 'client', '2018-05-31 02:00:04'),
(31, 4, 'client', '2018-05-31 02:01:12'),
(32, 4, 'client', '2018-05-31 02:08:12'),
(33, 4, 'client', '2018-05-31 02:13:07'),
(34, 4, 'client', '2018-05-31 02:32:49'),
(35, 4, 'client', '2018-05-31 02:34:32'),
(36, 4, 'client', '2018-05-31 02:36:08'),
(37, 4, 'client', '2018-05-31 02:37:26'),
(38, 4, 'client', '2018-05-31 02:42:22'),
(39, 1, 'operator', '2018-05-31 02:47:59'),
(40, 30, 'agent', '2018-05-31 02:49:42'),
(41, 4, 'client', '2018-05-31 02:49:54'),
(42, 4, 'client', '2018-05-31 02:55:19'),
(43, 4, 'client', '2018-05-31 02:59:21'),
(44, 4, 'client', '2018-05-31 03:02:07'),
(45, 4, 'client', '2018-05-31 13:12:58'),
(46, 30, 'agent', '2018-05-31 13:14:30'),
(47, 14, 'client', '2018-05-31 13:15:17'),
(48, 14, 'client', '2018-05-31 13:21:05'),
(49, 14, 'client', '2018-05-31 13:22:11'),
(50, 14, 'client', '2018-05-31 13:23:19'),
(51, 14, 'client', '2018-05-31 13:23:55'),
(52, 14, 'client', '2018-05-31 13:25:19'),
(53, 14, 'client', '2018-05-31 13:25:53'),
(54, 4, 'client', '2018-05-31 13:27:07'),
(55, 4, 'client', '2018-05-31 13:30:03'),
(56, 4, 'client', '2018-05-31 13:30:45'),
(57, 4, 'client', '2018-05-31 13:32:35'),
(58, 4, 'client', '2018-05-31 13:37:16'),
(59, 4, 'client', '2018-05-31 13:38:06'),
(60, 4, 'client', '2018-05-31 13:38:49'),
(61, 4, 'client', '2018-05-31 13:39:29'),
(62, 4, 'client', '2018-05-31 13:40:16'),
(63, 4, 'client', '2018-05-31 13:42:00'),
(64, 4, 'client', '2018-05-31 13:58:35'),
(65, 4, 'client', '2018-05-31 14:36:06'),
(66, 4, 'client', '2018-05-31 14:41:41'),
(67, 4, 'client', '2018-05-31 14:51:41'),
(68, 4, 'client', '2018-05-31 15:35:50'),
(69, 4, 'client', '2018-05-31 15:42:01'),
(70, 4, 'client', '2018-05-31 15:49:53'),
(71, 4, 'client', '2018-05-31 15:52:26'),
(72, 4, 'client', '2018-05-31 15:53:17'),
(73, 4, 'client', '2018-05-31 15:55:46'),
(74, 4, 'client', '2018-05-31 16:13:58'),
(75, 4, 'client', '2018-05-31 16:19:34'),
(76, 4, 'client', '2018-05-31 16:21:23'),
(77, 4, 'client', '2018-05-31 16:23:47'),
(78, 4, 'client', '2018-05-31 16:31:59'),
(79, 4, 'client', '2018-05-31 16:40:10'),
(80, 4, 'client', '2018-05-31 16:45:43'),
(81, 4, 'client', '2018-05-31 16:49:46'),
(82, 4, 'client', '2018-05-31 16:57:21'),
(83, 4, 'client', '2018-05-31 16:59:22'),
(84, 4, 'client', '2018-05-31 17:01:20'),
(85, 4, 'client', '2018-05-31 17:04:42'),
(86, 4, 'client', '2018-05-31 17:09:12'),
(87, 4, 'client', '2018-05-31 17:11:57'),
(88, 4, 'client', '2018-06-01 11:43:17'),
(89, 4, 'client', '2018-06-01 11:48:18'),
(90, 4, 'client', '2018-06-01 11:52:26'),
(91, 30, 'agent', '2018-06-01 18:00:55');

-- --------------------------------------------------------

--
-- Structure de la table `wishlist`
--

CREATE TABLE `wishlist` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `max_surface` double NOT NULL,
  `min_surface` double NOT NULL,
  `max_price` double NOT NULL,
  `min_price` double NOT NULL,
  `max_floor` int(11) NOT NULL,
  `min_floor` int(11) NOT NULL,
  `found` tinyint(1) NOT NULL DEFAULT '0',
  `id_found` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `wishlist`
--

INSERT INTO `wishlist` (`id`, `id_client`, `address`, `type`, `max_surface`, `min_surface`, `max_price`, `min_price`, `max_floor`, `min_floor`, `found`, `id_found`) VALUES
(4, 4, 'alger', 'F1', 120, 30, 1500000000, 1200000, 5, 0, 1, 38),
(5, 4, 'alger', 'F1', 0, 0, 0, 0, 0, 0, 0, 0);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Index pour la table `appointement`
--
ALTER TABLE `appointement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_agent` (`id_agent`),
  ADD KEY `id_lodgement` (`id_lodgement`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `lodgement`
--
ALTER TABLE `lodgement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_appointement` (`id_appointement`);

--
-- Index pour la table `operator`
--
ALTER TABLE `operator`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_appointement` (`id_appointement`);

--
-- Index pour la table `statistcs`
--
ALTER TABLE `statistcs`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client_wish` (`id_client`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `agent`
--
ALTER TABLE `agent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
--
-- AUTO_INCREMENT pour la table `appointement`
--
ALTER TABLE `appointement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=182;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT pour la table `favorite`
--
ALTER TABLE `favorite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `lodgement`
--
ALTER TABLE `lodgement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
--
-- AUTO_INCREMENT pour la table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `operator`
--
ALTER TABLE `operator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `reports`
--
ALTER TABLE `reports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `statistcs`
--
ALTER TABLE `statistcs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;
--
-- AUTO_INCREMENT pour la table `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `appointement`
--
ALTER TABLE `appointement`
  ADD CONSTRAINT `id_agent` FOREIGN KEY (`id_agent`) REFERENCES `agent` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_client` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_lodgement` FOREIGN KEY (`id_lodgement`) REFERENCES `lodgement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `id_appointement` FOREIGN KEY (`id_appointement`) REFERENCES `appointement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`id_appointement`) REFERENCES `appointement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `wishlist`
--
ALTER TABLE `wishlist`
  ADD CONSTRAINT `id_client_wish` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
