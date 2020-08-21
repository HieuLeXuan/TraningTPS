INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO permissions(name) VALUES('images_see');
INSERT INTO permissions(name) VALUES('images_upload');
INSERT INTO permissions(name) VALUES('images_download');

INSERT INTO user_permissions(user_id, permission_id) VALUES(1, 1);
INSERT INTO user_permissions(user_id, permission_id) VALUES(1, 2);
INSERT INTO user_permissions(user_id, permission_id) VALUES(1, 3);

