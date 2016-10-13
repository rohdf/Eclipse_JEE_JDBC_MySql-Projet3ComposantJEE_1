/*
														Auteur: Rohdri FRIMAT
														Date: 21/09/2016
*/

/*
 * BD MySql
 * */


-- CREATE DATABASE dblogin ;

-- GRANT ALL PRIVILEGES ON dblogin.* TO 'sa'@'localhost' IDENTIFIED BY 'sa';

-- USE dblogin;

/**/
DROP TABLE IF EXISTS utilisateur CASCADE;
DROP TABLE IF EXISTS city CASCADE;


create table utilisateur(
identifiant varchar(40), 
motdepasse varchar(40),
PRIMARY KEY (identifiant)
);


INSERT INTO utilisateur VALUES ('ldurand', '123456789');
INSERT INTO utilisateur VALUES ('dpetitjean', '987654321');
    








