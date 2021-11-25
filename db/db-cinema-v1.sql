-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 25 nov. 2021 à 15:00
-- Version du serveur : 10.4.19-MariaDB
-- Version de PHP : 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cinema`
--


CREATE DATABASE IF NOT EXISTS cinema;
GRANT ALL ON `cinema`.* TO 'userepul'@'%' IDENTIFIED BY 'epul';
USE cinema;


DROP TABLE IF EXISTS `personnage`;
DROP TABLE IF EXISTS `film`;
DROP TABLE IF EXISTS `categorie`;
DROP TABLE IF EXISTS `acteur`;
DROP TABLE IF EXISTS `realisateur`;
DROP TABLE IF EXISTS `utilisateur`;

-- --------------------------------------------------------

--
-- Structure de la table `acteur`
--

CREATE TABLE `acteur` (
  `noAct` int(4) NOT NULL,
  `nomAct` varchar(20) NOT NULL,
  `prenAct` varchar(20) DEFAULT NULL,
  `dateNaiss` date DEFAULT NULL,
  `dateDeces` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `acteur`
--

INSERT INTO `acteur` (`noAct`, `nomAct`, `prenAct`, `dateNaiss`, `dateDeces`) VALUES
(1, 'Reno', 'Jean', '1948-07-30', NULL),
(2, 'Portman', 'Natalie', '1981-06-09', NULL),
(3, 'Dujardin', 'Jean', '1972-06-19', NULL),
(4, 'Bourvil', 'André', '1917-07-27', '1970-09-23'),
(5, 'De Funes', 'Louis', '1914-08-31', '1983-01-27'),
(6, 'Anglade', 'Jean-Hugues', '1955-07-29', NULL),
(7, 'Lambert', 'Christophe', '1957-03-29', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `codeCat` varchar(2) NOT NULL,
  `libelleCat` varchar(20) NOT NULL,
  `image` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`codeCat`, `libelleCat`, `image`) VALUES
('AC', 'Action', 'https://upload.wikimedia.org/wikipedia/commons/thu'),
('CO', 'ComÃ©die', 'https://upload.wikimedia.org/wikipedia/commons/thu'),
('PO', 'Policier', 'https://upload.wikimedia.org/wikipedia/commons/thu'),
('WE', 'Western', 'https://upload.wikimedia.org/wikipedia/commons/5/5');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
  `noFilm` int(4) NOT NULL,
  `titre` varchar(30) NOT NULL,
  `duree` int(3) NOT NULL,
  `dateSortie` date NOT NULL,
  `budget` int(8) NOT NULL,
  `montantRecette` int(8) NOT NULL,
  `noRea` int(2) NOT NULL,
  `codeCat` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`noFilm`, `titre`, `duree`, `dateSortie`, `budget`, `montantRecette`, `noRea`, `codeCat`) VALUES
(1, 'Léon', 110, '1994-04-14', 17531000, 69250000, 3, 'PO'),
(2, 'Cash', 100, '2008-04-23', 18340000, 60340000, 4, 'PO'),
(3, 'La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC'),
(4, 'Subway', 104, '1985-04-10', 10567000, 70500000, 3, 'PO');

-- --------------------------------------------------------

--
-- Structure de la table `personnage`
--

CREATE TABLE `personnage` (
  `noFilm` int(4) NOT NULL,
  `noAct` int(4) NOT NULL,
  `nomPers` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personnage`
--

INSERT INTO `personnage` (`noFilm`, `noAct`, `nomPers`) VALUES
(1, 1, 'Léon'),
(1, 2, 'Mathilda'),
(2, 1, 'Maxime Dubreuil'),
(2, 3, 'Cash'),
(3, 4, 'Augustin Bouvet'),
(3, 5, 'Stanislas Lefort'),
(4, 1, 'Le Batteur'),
(4, 6, 'Le Roller'),
(4, 7, 'Fred');

-- --------------------------------------------------------

--
-- Structure de la table `realisateur`
--

CREATE TABLE `realisateur` (
  `noRea` int(2) NOT NULL,
  `nomRea` varchar(20) NOT NULL,
  `prenRea` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `realisateur`
--

INSERT INTO `realisateur` (`noRea`, `nomRea`, `prenRea`) VALUES
(1, 'Oury', 'Gérard'),
(2, 'Chabrol', 'Claude'),
(3, 'Besson', 'Luc'),
(4, 'Besnard', 'Eric');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `mdp`, `role`) VALUES
(1, 'Merlot', '$2a$04$CMDLDuhgBAxnpYwy3Lfsr.nBFH.eGEep6bV6mh4j7Nxtns4awxIlq', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `acteur`
--
ALTER TABLE `acteur`
  ADD PRIMARY KEY (`noAct`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`codeCat`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`noFilm`),
  ADD KEY `noRea` (`noRea`),
  ADD KEY `codeCat` (`codeCat`);

--
-- Index pour la table `personnage`
--
ALTER TABLE `personnage`
  ADD PRIMARY KEY (`noFilm`,`noAct`),
  ADD KEY `noFilm` (`noFilm`),
  ADD KEY `noAct` (`noAct`);

--
-- Index pour la table `realisateur`
--
ALTER TABLE `realisateur`
  ADD PRIMARY KEY (`noRea`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `acteur`
--
ALTER TABLE `acteur`
  MODIFY `noAct` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
  MODIFY `noFilm` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `realisateur`
--
ALTER TABLE `realisateur`
  MODIFY `noRea` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`noRea`) REFERENCES `realisateur` (`noRea`),
  ADD CONSTRAINT `film_ibfk_2` FOREIGN KEY (`codeCat`) REFERENCES `categorie` (`codeCat`);

--
-- Contraintes pour la table `personnage`
--
ALTER TABLE `personnage`
  ADD CONSTRAINT `personnage_ibfk_1` FOREIGN KEY (`noFilm`) REFERENCES `film` (`noFilm`),
  ADD CONSTRAINT `personnage_ibfk_2` FOREIGN KEY (`noAct`) REFERENCES `acteur` (`noAct`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
