CREATE TABLE IF NOT EXISTS users
(
    id        SERIAL PRIMARY KEY,
    first_name varchar(30) NOT NULL,
    last_name  varchar(30) NOT NULL,
    age integer NOT NULL,
    email varchar(30) NOT NULL,
    date_of_birth date NOT NULL
);

CREATE TABLE IF NOT EXISTS books
(
    id        SERIAL PRIMARY KEY,
    number_of_pages integer,
    title  varchar(30),
    release_year integer,
    price real
);

CREATE TABLE IF NOT EXISTS authors
(
    id        SERIAL PRIMARY KEY,
    first_name varchar(30) NOT NULL,
    last_name  varchar(30) NOT NULL,
    date_of_birth date NOT NULL,
    country varchar(30) NOT NULL,
    is_deleted boolean default false
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
    order_date date NOT NULL,
    order_cost real NOT NULL,
    user_id varchar(30) NOT NULL,
    book_id varchar(30) NOT NULL
);