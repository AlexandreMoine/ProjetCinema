CREATE DATABASE IF NOT EXISTS cinema;
GRANT ALL ON `cinema`.* TO 'userepul'@'%' IDENTIFIED BY 'epul';
USE cinema;


DROP TABLE IF EXISTS `personnage`;
DROP TABLE IF EXISTS `film`;
DROP TABLE IF EXISTS `categorie`;
DROP TABLE IF EXISTS `acteur`;
DROP TABLE IF EXISTS `realisateur`;


CREATE TABLE IF NOT EXISTS `acteur` (
  `noAct` int(4) NOT NULL AUTO_INCREMENT,
  `nomAct` varchar(20) NOT NULL,
  `prenAct` varchar(20) DEFAULT NULL,
  `dateNaiss` date DEFAULT NULL,
  `dateDeces` date DEFAULT NULL,
  PRIMARY KEY (`noAct`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `acteur` (`nomAct`, `prenAct`, `dateNaiss`, `dateDeces`) VALUES
('Reno', 'Jean', '1948-07-30', NULL),
('Portman', 'Natalie', '1981-06-09', NULL),
('Dujardin', 'Jean', '1972-06-19', NULL),
('Bourvil', 'André', '1917-07-27', '1970-09-23'),
('De Funes', 'Louis', '1914-08-31', '1983-01-27'),
('Anglade', 'Jean-Hugues', '1955-07-29', NULL),
('Lambert', 'Christophe', '1957-03-29', NULL);


CREATE TABLE IF NOT EXISTS `categorie` (
  `codeCat` varchar(2) NOT NULL,
  `libelleCat` varchar(20) NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`codeCat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `categorie` (`codeCat`, `libelleCat`, `image`) VALUES
('AC', 'Action', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/M9-pistolet.jpg/220px-M9-pistolet.jpg'),
('CO', 'ComÃ©die', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Eduard_von_Gr%C3%BCtzner_Falstaff.jpg/220px-Eduard_von_Gr%C3%BCtzner_Falstaff.jpg'),
('PO', 'Policier', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Police-IMG_4105.jpg/300px-Police-IMG_4105.jpg'),
('WE', 'Western', 'https://upload.wikimedia.org/wikipedia/commons/5/53/Buffalo_Bills_Wild_West_Show%2C_1890.jpg');


CREATE TABLE IF NOT EXISTS `realisateur` (
  `noRea` int(2) NOT NULL AUTO_INCREMENT,
  `nomRea` varchar(20) NOT NULL,
  `prenRea` varchar(20) NOT NULL,
  PRIMARY KEY (`noRea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `realisateur` (`nomRea`, `prenRea`) VALUES
('Oury', 'Gérard'),
('Chabrol', 'Claude'),
('Besson', 'Luc'),
('Besnard', 'Eric');


CREATE TABLE IF NOT EXISTS `film` (
  `noFilm` int(4) NOT NULL AUTO_INCREMENT,
  `titre` varchar(30) NOT NULL,
  `duree` int(3) NOT NULL,
  `dateSortie` date NOT NULL,
  `budget` int(8) NOT NULL,
  `montantRecette` int(8) NOT NULL,
  `noRea` int(2) NOT NULL,
  `codeCat` varchar(2) NOT NULL,
  PRIMARY KEY (`noFilm`),
  KEY `noRea` (`noRea`),
  KEY `codeCat` (`codeCat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `film`
  ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`noRea`) REFERENCES `realisateur` (`noRea`),
  ADD CONSTRAINT `film_ibfk_2` FOREIGN KEY (`codeCat`) REFERENCES `categorie` (`codeCat`);

INSERT INTO `film` (`titre`, `duree`, `dateSortie`, `budget`, `montantRecette`, `noRea`, `codeCat`) VALUES
('Léon', 110, '1994-04-14', 17531000, 69250000, 3, 'PO'),
('Cash', 100, '2008-04-23', 18340000, 60340000, 4, 'PO'),
('La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC'),
('Subway', 104, '1985-04-10', 10567000, 70500000, 3, 'PO');


CREATE TABLE IF NOT EXISTS `personnage` (
  `noFilm` int(4) NOT NULL,
  `noAct` int(4) NOT NULL,
  `nomPers` varchar(30) NOT NULL,
  PRIMARY KEY (`noFilm`,`noAct`),
  KEY `noFilm` (`noFilm`),
  KEY `noAct` (`noAct`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `personnage`
  ADD CONSTRAINT `personnage_ibfk_1` FOREIGN KEY (`noFilm`) REFERENCES `film` (`noFilm`),
  ADD CONSTRAINT `personnage_ibfk_2` FOREIGN KEY (`noAct`) REFERENCES `acteur` (`noAct`);

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