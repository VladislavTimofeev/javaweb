CREATE TABLE users
(
    id        SERIAL PRIMARY KEY,
    firstName varchar(30) NOT NULL,
    lastName  varchar(30) NOT NULL
);

insert into users(id, firstName, lastName)
values (0, Vasya, Bobrikov);

