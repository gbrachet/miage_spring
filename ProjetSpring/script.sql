-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 20 Février 2013 à 21:20
-- Version du serveur: 5.5.29
-- Version de PHP: 5.4.6-1ubuntu1.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `spring`
--

-- --------------------------------------------------------

--
-- Structure de la table `Contact`
--

CREATE TABLE IF NOT EXISTS `Contact` (
  `userA` int(10) unsigned NOT NULL,
  `userB` int(10) unsigned NOT NULL,
  `status` enum('valid','blocked') NOT NULL DEFAULT 'valid',
  PRIMARY KEY (`userA`,`userB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Message`
--

CREATE TABLE IF NOT EXISTS `Message` (
  `idMessage` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `from` int(10) unsigned NOT NULL,
  `to` int(10) unsigned NOT NULL,
  `title` varchar(64) NOT NULL,
  `content` text NOT NULL,
  `send` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `receive` timestamp NULL DEFAULT NULL,
  `read` enum('y','n') NOT NULL DEFAULT 'n',
  PRIMARY KEY (`idMessage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `idUser` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` char(16) DEFAULT NULL,
  `password` char(32) NOT NULL,
  `email` varchar(72) DEFAULT NULL,
  `firstName` varchar(32) DEFAULT NULL,
  `lastName` varchar(32) DEFAULT NULL,
  `sex` enum('m','f') DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `lastConnection` date DEFAULT NULL,
  `registration` date NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `User`
--

INSERT INTO `User` (`idUser`, `username`, `password`, `email`, `firstName`, `lastName`, `sex`, `birthday`, `lastConnection`, `registration`) VALUES
(3, NULL, '123456', 'g.brachet@gmail.com', NULL, NULL, 'm', '1989-05-14', NULL, '2013-02-20');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;