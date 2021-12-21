SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `users` (`username`, `email`, `password`) VALUES ('Merlot', 'merlot@gmail.com', '$2a$04$CMDLDuhgBAxnpYwy3Lfsr.nBFH.eGEep6bV6mh4j7Nxtns4awxIlq');
INSERT INTO `users` (`username`, `email`, `password`) VALUES ('thiti', 'thiti@gmail.com', '$2a$04$1zyF3Uu.ZDMZuICCKcw1WO0zoHnDRMnL.v7yAm881jYEF5NOQR58.');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO user_roles(user_id, role_id) VALUES(1, 1);

INSERT INTO user_roles(user_id, role_id) VALUES(2, 1);
INSERT INTO user_roles(user_id, role_id) VALUES(2, 2);
INSERT INTO user_roles(user_id, role_id) VALUES(2, 3);
INSERT INTO user_roles(user_id, role_id) VALUES(1, 2);
INSERT INTO user_roles(user_id, role_id) VALUES(1, 3);


--
-- Déchargement des données de la table `acteur`
--

INSERT INTO actor (id, firstname, lastname, birth, death) VALUES (1, 'Jean', 'Reno', '1948-07-30', NULL);
INSERT INTO actor (id, firstname, lastname, birth, death) VALUES (2, 'Natalie', 'Portman', '1981-06-09', NULL);
INSERT INTO actor (id, firstname, lastname, birth, death) VALUES (3, 'Jean', 'Dujardin', '1972-06-19', NULL);
INSERT INTO actor (id, firstname, lastname, birth, death) VALUES (4, 'André', 'Bourvil', '1917-07-27', '1970-09-23');
INSERT INTO actor (id, firstname, lastname, birth, death) VALUES (5, 'Louis', 'De Funes', '1914-08-31', '1983-01-27');
INSERT INTO actor (id, firstname, lastname, birth, death) VALUES (6, 'Jean-Hugues', 'Anglade', '1955-07-29', NULL);
INSERT INTO actor (id, firstname, lastname, birth, death) VALUES (7, 'Christophe', 'Lambert', '1957-03-29', NULL);

--
-- Déchargement des données de la table `realisateur`
--

INSERT INTO `director` (`id`, `lastname`, `firstname`) VALUES (1, 'Oury', 'Gérard');
INSERT INTO `director` (`id`, `lastname`, `firstname`) VALUES (2, 'Chabrol', 'Claude');
INSERT INTO `director` (`id`, `lastname`, `firstname`) VALUES (3, 'Besson', 'Luc');
INSERT INTO `director` (`id`, `lastname`, `firstname`) VALUES (4, 'Besnard', 'Eric');


--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `category` (`code`, `name`, `image`) VALUES ('AC', 'Action', 'https://upload.wikimedia.org/wikipedia/commons/thu');
INSERT INTO `category` (`code`, `name`, `image`) VALUES ('CO', 'ComÃ©die', 'https://upload.wikimedia.org/wikipedia/commons/thu');
INSERT INTO `category` (`code`, `name`, `image`) VALUES ('PO', 'Policier', 'https://upload.wikimedia.org/wikipedia/commons/thu');
INSERT INTO `category` (`code`, `name`, `image`) VALUES ('WE', 'Western', 'https://upload.wikimedia.org/wikipedia/commons/5/5');

--
-- Déchargement des données de la table `film`
--

INSERT INTO `movie` (`id`, `title`, `duration`, `release_date`, `budget`, `revenue_amount`, `director_id`, `category_code`) VALUES (1, 'Léon', 110, '1994-04-14', 17531000, 69250000, 3, 'PO');
INSERT INTO `movie` (`id`, `title`, `duration`, `release_date`, `budget`, `revenue_amount`, `director_id`, `category_code`) VALUES (2, 'Cash', 100, '2008-04-23', 18340000, 60340000, 4, 'PO');
INSERT INTO `movie` (`id`, `title`, `duration`, `release_date`, `budget`, `revenue_amount`, `director_id`, `category_code`) VALUES (3, 'La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC');
INSERT INTO `movie` (`id`, `title`, `duration`, `release_date`, `budget`, `revenue_amount`, `director_id`, `category_code`) VALUES (4, 'Subway', 104, '1985-04-10', 10567000, 70500000, 3, 'PO');

--
-- Déchargement des données de la table `personnage`
--

INSERT INTO `movie_character` (`movie_id`, `actor_id`, `firstname`) VALUES (1, 1, 'Léon');
INSERT INTO `movie_character` (`movie_id`, `actor_id`, `firstname`) VALUES (1, 2, 'Mathilda');
INSERT INTO `movie_character` (`movie_id`, `actor_id`, `firstname`) VALUES (2, 1, 'Maxime Dubreuil');
INSERT INTO `movie_character` (`movie_id`, `actor_id`, `firstname`) VALUES (2, 3, 'Cash');
INSERT INTO `movie_character` (`movie_id`, `actor_id`, `firstname`) VALUES (3, 4, 'Augustin Bouvet');
INSERT INTO `movie_character` (`movie_id`, `actor_id`, `firstname`) VALUES (3, 5, 'Stanislas Lefort');
INSERT INTO `movie_character` (`movie_id`, `actor_id`, `firstname`) VALUES (4, 1, 'Le Batteur');
INSERT INTO `movie_character` (`movie_id`, `actor_id`, `firstname`) VALUES (4, 6, 'Le Roller');
INSERT INTO `movie_character` (`movie_id`, `actor_id`, `firstname`) VALUES (4, 7, 'Fred');


COMMIT;