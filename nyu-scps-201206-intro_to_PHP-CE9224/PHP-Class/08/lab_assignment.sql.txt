DROP TABLE IF EXISTS `entries_denormalized`;
CREATE TABLE `entries_denormalized` (
    `id` int UNSIGNED NOT NULL auto_increment,
    `email` varchar(255) NOT NULL,
    `name` varchar(35) NOT NULL,
    `title` varchar(255) NOT NULL,
    `entry` text NOT NULL,
    `date_created` timestamp NOT NULL DEFAULT NOW(),
    primary key (`id`),
    key (`name`)
)ENGINE=InnoDB;

INSERT INTO `entries_denormalized`
    (`email`,`name`,`title`,`entry`)
VALUES
    ('steve@gmail.com','Steve','Apple Will Use It In A Breakthrough Product', 'bla bla bla...'),
    ('grace@gmail.com','Grace','Fox News Anchor Went On An EPIC Rant About The GOP Primary', 'bla bla bla...'),
    ('Alyson@gmail.com','Alyson','Should Startups Get Special Treatment?', 'bla bla bla...'),
    ('seth@gmail.com','Seth','Executive\'s Plan To Build A Huge Home Has Enraged A Town', 'bla bla bla...'),
    ('julie@gmail.com','Julie','Looking For A New Job Title? This Hilarious Website Is For You', 'bla bla bla...'),
    ('matt@gmail.com','Matt','Yelp Said Something On Its Earnings Call Today That Should Scare The Heck Out Of Google', 'bla bla bla...'),
    ('julie@gmail.com','Julie','17 Enterprise Startups To Bet Your Career On', 'bla bla bla...'),
    ('matt@gmail.com','Matt','Windows \'Live\' Is Dead', 'bla bla bla...');

DROP TABLE IF EXISTS `entries`;
CREATE TABLE `entries` (
    `id` int UNSIGNED NOT NULL auto_increment,
    `author_id` int UNSIGNED NOT NULL,
    `title` varchar(255) NOT NULL,
    `entry` text NOT NULL,
    `date_created` timestamp NOT NULL DEFAULT NOW(),
    primary key (`id`)
)ENGINE=InnoDB;

INSERT INTO `entries`
    (`author_id`,`title`,`entry`)
VALUES
    (1,'Apple Will Use It In A Breakthrough Product', 'bla bla bla...'),
    (2,'Fox News Anchor Went On An EPIC Rant About The GOP Primary', 'bla bla bla...'),
    (3,'Should Startups Get Special Treatment?', 'bla bla bla...'),
    (4,'Executive\'s Plan To Build A Huge Home Has Enraged A Town', 'bla bla bla...'),
    (5,'Looking For A New Job Title? This Hilarious Website Is For You', 'bla bla bla...'),
    (6,'Yelp Said Something On Its Earnings Call Today That Should Scare The Heck Out Of Google', 'bla bla bla...'),
    (5,'17 Enterprise Startups To Bet Your Career On', 'bla bla bla...'),
    (6,'Windows \'Live\' Is Dead', 'bla bla bla...');

DROP TABLE IF EXISTS `authors`;
CREATE TABLE `authors` (
    `id` int UNSIGNED NOT NULL auto_increment,
    `email` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    primary key (`id`)
)ENGINE=InnoDB;

INSERT INTO `authors`
    (`email`,`name`)
VALUES
    ('steve@gmail.com','Steve'),
    ('grace@gmail.com','Grace'),
    ('Alyson@gmail.com','Alyson'),
    ('seth@gmail.com','Seth'),
    ('julie@gmail.com','Julie'),
    ('matt@gmail.com','Matt');
