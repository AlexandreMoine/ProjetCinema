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

INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('AC', 'Action', 'action','#b34040');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('AV', 'Aventure', 'adventure', '#40b367');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('AN', 'Animation', 'animation','#b39840');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('CM', 'Comédie', 'comedy', '#40b3b3');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('UK', 'Sans catégorie', 'default','#7cb340');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('DR', 'Drame', 'drama', '#7340b3');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('FM', 'Famille', 'family','#b3406e');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('FT', 'Fantastique', 'fantasy', '#4043b3');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('HS', 'Historique', 'history', '#40a0b3');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('HR', 'Horreur', 'horror','#7740b3');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('MS', 'Musical', 'musical', '#b3b340');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('RM', 'Romantique', 'romance','#b34040');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('SF', 'Science Fiction', 'sci-fi', '#4540b3');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('TH', 'Thriller', 'thriller','#40b34e');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('WR', 'Guerre', 'war', '#40b358');
INSERT INTO `category` (`code`, `name`, `icon`, `color`) VALUES ('WS', 'Western', 'western','#b36f40');

--
-- Déchargement des données de la table `film`
--

INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Léon','Un tueur à gages répondant au nom de Léon prend sous son aile Mathilda, une petite fille de 12 ans, seule rescapée du massacre de sa famille. Bientôt, Léon va faire de Mathilda une `nettoyeuse'', comme lui. La jeune fille pourra alors venger son petit frère.', 110, '1994-04-14', 'images/leon.jpg', 3);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Ca$h','', 100, '2008-04-23', 'images/cash.jpg', 4);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('La grande vadrouille','', 132, '1966-12-01', 'images/la-grande-vadrouille.jpg', 2);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Subway','', 104, '1985-04-10', 'images/subway.jpg', 3);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Coco','', 0, '1985-04-10', 'images/coco.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Forrest Gump','', 0, '1985-04-10', 'images/forrest-gump.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Gladiator','', 0, '1985-04-10', 'images/gladiator.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Inception','', 0, '1985-04-10', 'images/inception.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Interstellar','', 0, '1985-04-10', 'images/interstellar.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Le dictateur','', 0, '1985-04-10', 'images/le-dictateur.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Le parrain','', 0, '1985-04-10', 'images/le-parrain.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ("Le seigneur des anneaux : La communauté de l\'anneau",'', 0, '1985-04-10', 'images/coco.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ("Le seigneur des anneaux : Les deux tours",'', 0, '1985-04-10', 'images/coco.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ("Le seigneur des anneaux : Le retour du roi",'', 0, '1985-04-10', 'images/coco.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Le voyage de Chihiro','', 0, '1985-04-10', 'images/le-voyage-de-chihiro.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Retour vers le futur','', 0, '1985-04-10', 'images/retour-vers-le-futur.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Spiderman into the spiderverse','', 0, '1985-04-10', 'images/spiderman-into-the-spiderverse.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Star Wars : épisode 5 - Ta mère contre attaque','', 0, '1985-04-10', 'images/star-wars-episode-5.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('The dark knight','', 0, '1985-04-10', 'images/the-dark-knight.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Toy story 3','', 0, '1985-04-10', 'images/toy-story-3.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ("Vol au dessus d\'un nid de coucou",'', 0, '1985-04-10', 'images/vol-au-dessus-dun-nid-de-coucou.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Your name','', 0, '1985-04-10', 'images/your-name.jpg', null);
INSERT INTO `movie` (`title`, `description`, `duration`, `release_date`, `cover_path`, `director_id`) VALUES ('Zootopia','', 0, '1985-04-10', 'images/zootopia.jpg', null);

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


INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (1,'AC');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (1,'DR');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (2,'TH');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (3,'CM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (3,'WR');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (3,'HS');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (4,'TH');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (4,'DR');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (5,'AN');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (5,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (5,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (6,'DR');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (6,'RM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (6,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (7,'AC');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (7,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (8,'SF');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (8,'AC');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (9,'SF');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (9,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (9,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (10,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (10,'HS');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (10,'WR');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (10,'CM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (11,'DR');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (11,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (12,'FT');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (12,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (13,'FT');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (13,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (14,'FT');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (14,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (15,'AN');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (15,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (15,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (16,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (16,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (16,'SF');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (17,'AN');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (17,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (18,'SF');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (18,'WR');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (19,'AC');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (19,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (19,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (20,'AN');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (20,'AV');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (20,'FM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (21,'DR');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (21,'CM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (22,'AN');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (22,'RM');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (23,'AN');
INSERT INTO `movie_categories` (`movie_id`, `category_id`) VALUES (23,'HR');



COMMIT;