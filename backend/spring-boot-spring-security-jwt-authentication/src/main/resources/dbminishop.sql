create database minishop;

use minishop;

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO permissions(name) VALUES('See_image');
INSERT INTO permissions(name) VALUES('Udate_image');
INSERT INTO permissions(name) VALUES('Download_image');
