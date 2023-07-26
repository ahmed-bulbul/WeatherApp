-- pwd:demoUser
INSERT INTO users
(id,created_by, creation_date, last_modified_by, last_modified_date, email, "password", username)
VALUES(1, 1, NOW(), 1, NOW(),'user@gmail.com', '$2a$12$gZA5L01coFBboejZjqPpnuOQOlnoa7G/CsqFGr3EbdqL2bQVuBMFm', 'user');

-- pwd:demoAdmin
INSERT INTO users
(id,created_by, creation_date, last_modified_by, last_modified_date, email, "password", username)
VALUES (2, 1, NOW(), 1, NOW(), 'admin@gmail.com', '$2a$12$XIHNjtPd8vMlq5OIHlDHReDt9lxrwqPAG1UAgCB70puys92.64/7a', 'admin');

INSERT INTO roles
(id,created_by, creation_date, last_modified_by, last_modified_date, "name")
VALUES(1,1,NOW(), 1, NOW(), 'ADMIN');

INSERT INTO roles
(id,created_by, creation_date, last_modified_by, last_modified_date, "name")
VALUES(2,1,NOW(), 1, NOW(), 'USER');


INSERT INTO user_role_map (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_role_map (user_id, role_id)
VALUES (2, 1);
INSERT INTO user_role_map (user_id, role_id)
VALUES (2, 2);
