\c miniproject;

CREATE SEQUENCE user_id_seq;

ALTER SEQUENCE user_id_seq RESTART WITH 101;

create table users(
    userid int DEFAULT nextval('user_id_seq'),
    name varchar(50) not null,
    email varchar(40) UNIQUE,
    password varchar(30) not null,
    gender varchar(10),
    created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
    PRIMARY KEY(userid)
);