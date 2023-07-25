CREATE SEQUENCE user_favorite_location_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE users_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;
CREATE SEQUENCE roles_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE users
(
    id                 int8         NOT NULL,
    creation_date      timestamp with time zone,
    created_by         character varying,
    last_modified_by   character varying,
    last_modified_date timestamp with time zone,
    email              varchar(255) NULL,
    "password"         varchar(255) NULL,
    username           varchar(255) NOT NULL,
    CONSTRAINT uk_username UNIQUE (username),
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id                 int8                   NOT NULL,
    creation_date      timestamp with time zone,
    created_by         character varying,
    last_modified_by   character varying,
    last_modified_date timestamp with time zone,
    description        character varying(255),
    name               character varying(255) NOT NULL,
    CONSTRAINT uk_name UNIQUE (name),
    CONSTRAINT roles_pkey PRIMARY KEY (id)
);
CREATE TABLE user_role_map
(
    user_id int8 NOT NULL,
    role_id int8 NOT NULL
);
ALTER TABLE user_role_map
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE user_role_map
    ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles (id);

CREATE TABLE user_favorite_location
(
    id                 int8 NOT NULL,
    creation_date      timestamp with time zone,
    created_by         character varying,
    last_modified_by   character varying,
    last_modified_date timestamp with time zone,
    latitude           float8 NULL,
    location_details   varchar(255) NULL,
    location_id        int8 NULL,
    longitude          float8 NULL,
    user_id            int8 NULL,
    CONSTRAINT user_favorite_location_pkey PRIMARY KEY (id)
);
ALTER TABLE user_favorite_location
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id);