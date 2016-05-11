-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 09 Mai 2016 à 11:19
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.5.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `vertx_assurance`
--

-- --------------------------------------------------------

--
-- Structure de la table `carburant`
--

CREATE TABLE IF NOT EXISTS `carburant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `carburant`
--

INSERT INTO `carburant` (`id`, `name`) VALUES
(1, 'Carburant A'),
(2, 'Carburant B'),
(3, 'Carburant C'),
(4, 'Carburant D'),
(5, 'Carburant E');

-- --------------------------------------------------------

--
-- Structure de la table `chevaux_fiscaux`
--

CREATE TABLE IF NOT EXISTS `chevaux_fiscaux` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `chevaux_fiscaux`
--

INSERT INTO `chevaux_fiscaux` (`id`, `name`) VALUES
(1, 'Chevaux A'),
(2, 'Chevaux B'),
(3, 'Chevaux C'),
(4, 'Chevaux D'),
(5, 'Chevaux E');

-- --------------------------------------------------------

--
-- Structure de la table `marque`
--

CREATE TABLE IF NOT EXISTS `marque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `marque`
--

INSERT INTO `marque` (`id`, `name`) VALUES
(1, 'Marque A'),
(2, 'Marque B'),
(3, 'Marque C'),
(4, 'Marque D'),
(5, 'Marque E');

-- --------------------------------------------------------

--
-- Structure de la table `modele`
--

CREATE TABLE IF NOT EXISTS `modele` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `modele`
--

INSERT INTO `modele` (`id`, `name`) VALUES
(1, 'Modele A'),
(2, 'Modele B'),
(3, 'Modele C'),
(4, 'Modele D'),
(5, 'Modele E');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `name`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

CREATE TABLE IF NOT EXISTS `voiture` (
  `id_marque` int(11) NOT NULL,
  `id_modele` int(11) NOT NULL,
  `id_chevaux_fiscaux` int(11) NOT NULL,
  `id_carburant` int(11) NOT NULL,
  PRIMARY KEY (`id_marque`,`id_modele`,`id_chevaux_fiscaux`,`id_carburant`),
  KEY `FK_voiture_id_modele` (`id_modele`),
  KEY `FK_voiture_id_chevaux_fiscaux` (`id_chevaux_fiscaux`),
  KEY `FK_voiture_id_carburant` (`id_carburant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `voiture`
--

INSERT INTO `voiture` (`id_marque`, `id_modele`, `id_chevaux_fiscaux`, `id_carburant`) VALUES
(1, 1, 1, 1),
(1, 1, 1, 2),
(1, 1, 1, 3),
(1, 2, 1, 1),
(1, 2, 2, 1),
(2, 3, 3, 3),
(2, 3, 4, 4),
(3, 3, 4, 5),
(3, 4, 4, 5),
(4, 4, 2, 1),
(4, 5, 3, 2),
(5, 5, 5, 5);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `voiture`
--
ALTER TABLE `voiture`
  ADD CONSTRAINT `FK_voiture_id` FOREIGN KEY (`id_marque`) REFERENCES `marque` (`id`),
  ADD CONSTRAINT `FK_voiture_id_carburant` FOREIGN KEY (`id_carburant`) REFERENCES `carburant` (`id`),
  ADD CONSTRAINT `FK_voiture_id_chevaux_fiscaux` FOREIGN KEY (`id_chevaux_fiscaux`) REFERENCES `chevaux_fiscaux` (`id`),
  ADD CONSTRAINT `FK_voiture_id_modele` FOREIGN KEY (`id_modele`) REFERENCES `modele` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
