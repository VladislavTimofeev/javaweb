CREATE TABLE IF NOT EXISTS users
(
    id        SERIAL PRIMARY KEY,
    firstName varchar(30) NOT NULL,
    lastName  varchar(30) NOT NULL,
    age integer NOT NULL,
    email varchar(30) NOT NULL,
    dateOfBirth date NOT NULL
);

CREATE TABLE IF NOT EXISTS books
(
    id        SERIAL PRIMARY KEY,
    numberOfPages integer,
    title  varchar(30),
    releaseYear integer
);

CREATE TABLE IF NOT EXISTS authors
(
    id        SERIAL PRIMARY KEY,
    firstName varchar(30) NOT NULL,
    lastName  varchar(30) NOT NULL,
    dateOfBirth date NOT NULL,
    country varchar(30) NOT NULL,
    isDeleted boolean default false
);

CREATE TABLE IF NOT EXISTS books_authors
(
    id        SERIAL PRIMARY KEY,
    book_id integer,
    author_id integer
);

CREATE TABLE IF NOT EXISTS orders
(
    id        SERIAL PRIMARY KEY,
    orderDate date NOT NULL,
    orderCost real NOT NULL,
    userId varchar(30) NOT NULL
);