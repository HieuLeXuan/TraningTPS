create database minishop;

use minishop;

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO permissions(name) VALUES('images_see');
INSERT INTO permissions(name) VALUES('images_upload');
INSERT INTO permissions(name) VALUES('images_download');
