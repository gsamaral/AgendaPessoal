-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 01, 2017 at 11:04 AM
-- Server version: 5.7.18-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Planner`
--

-- --------------------------------------------------------

--
-- Table structure for table `Categoria`
--

CREATE TABLE `Categoria` (
  `idCat` int(11) NOT NULL,
  `nomeCat` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Categoria`
--

INSERT INTO `Categoria` (`idCat`, `nomeCat`) VALUES
(3, 'Reunião'),
(4, 'Escolar'),
(7, 'Outros');

-- --------------------------------------------------------

--
-- Table structure for table `TAREFA`
--

CREATE TABLE `TAREFA` (
  `id` int(11) NOT NULL,
  `nomeTarefa` varchar(40) NOT NULL,
  `categoria` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `dataTarefa` date DEFAULT NULL,
  `hora` int(11) NOT NULL,
  `min` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TAREFA`
--

INSERT INTO `TAREFA` (`id`, `nomeTarefa`, `categoria`, `status`, `dataTarefa`, `hora`, `min`) VALUES
(19, 'Lavar louca', 'Reunião', 'Ativa', '2017-06-10', 1, 15),
(21, 'horinha', 'Reunião', 'Ativa', '2017-05-06', 0, 0),
(22, 'atividadenova', 'Reunião', 'Ativa', '2017-06-06', 5, 30),
(23, 'Beber Agua', 'Outros', 'Planejamento', '2017-05-30', 5, 0),
(24, 'ir ao dentista', 'Teste', 'Ativa', '2017-06-03', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Categoria`
--
ALTER TABLE `Categoria`
  ADD PRIMARY KEY (`idCat`);

--
-- Indexes for table `TAREFA`
--
ALTER TABLE `TAREFA`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Categoria`
--
ALTER TABLE `Categoria`
  MODIFY `idCat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `TAREFA`
--
ALTER TABLE `TAREFA`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
