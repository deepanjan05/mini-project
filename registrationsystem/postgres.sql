\c miniproject;

create table users(
    userid SERIAL,
    name varchar(50) not null,
    email varchar(40) UNIQUE,
    password varchar(30) not null,
    gender varchar(10),
    created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
    PRIMARY KEY(userid)
);