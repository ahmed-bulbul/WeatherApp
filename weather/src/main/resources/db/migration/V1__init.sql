-- CREATE SEQUENCE user_favorite_location_id_seq
--     INCREMENT BY 1
--     MINVALUE 1
--     MAXVALUE 9223372036854775807
--     START 1
-- 	CACHE 1
-- 	NO CYCLE;
--
-- CREATE SEQUENCE users_id_seq
--     INCREMENT BY 1
--     MINVALUE 1
--     MAXVALUE 9223372036854775807
--     START 1
-- 	CACHE 1
-- 	NO CYCLE;

CREATE TABLE users
(
    id         bigserial    NOT NULL,
    email      varchar(255) NULL,
    "password" varchar(255) NULL,
    username   varchar(255) NOT NULL,
    CONSTRAINT uk_username UNIQUE (username),
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    user_id int8 NOT NULL,
    "role"  int2 NULL,
    CONSTRAINT user_roles_role_check CHECK (((role >= 0) AND (role <= 1)))
);


ALTER TABLE user_roles
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE user_favorite_location
(
    id               bigserial NOT NULL,
    latitude         float8 NULL,
    location_details varchar(255) NULL,
    location_id      int8 NULL,
    longitude        float8 NULL,
    user_id          int8 NULL,
    CONSTRAINT user_favorite_location_pkey PRIMARY KEY (id)
);
ALTER TABLE user_favorite_location
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id);