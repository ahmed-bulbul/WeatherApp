INSERT INTO users(id,create_date,created_by, modify_date, updated_by, email, "password", username)
VALUES (1,NOW(),'system',NOW(), 'system','user@gmail.com', '$2a$10$lg6nhtbEYilsNh2SjMMkZuWIxhju0jOhdBexlFxHiVl0ZUljEzSOG', 'user');

INSERT INTO users(id,create_date,created_by, modify_date, updated_by, email, "password", username)
VALUES (2,NOW(),'system',NOW(), 'system', 'admin@gmail.com', '$2a$10$0sc6BRSFfixENhIK6BPciOKJv0SXF/TPioQTInZjIHF8A6DzjOqKe', 'admin');

INSERT INTO roles (id,create_date,created_by, modify_date, updated_by, name, description)
VALUES ('1',NOW(),'system',NOW(), 'system', 'admin', 'Can make changes to Configuration');

INSERT INTO roles (id,create_date,created_by, modify_date, updated_by, name, description)
VALUES ('2',NOW(),'system',NOW(), 'system','user', 'use apps');

INSERT INTO user_role_map (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_role_map (user_id, role_id)
VALUES (2, 1);
INSERT INTO user_role_map (user_id, role_id)
VALUES (2, 2);

