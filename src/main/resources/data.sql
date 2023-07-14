CREATE TABLE users
(
    id        SERIAL PRIMARY KEY,
    firstName varchar(30) NOT NULL,
    lastName  varchar(30) NOT NULL,
    age integer NOT NULL,
    email varchar(30) NOT NULL,
    dateOfBirth date NOT NULL
);

CREATE TABLE books
(
    id        SERIAL PRIMARY KEY,
    numberOfPages integer,
    title  varchar(30)
);

CREATE TABLE authors
(
    id        SERIAL PRIMARY KEY,
    firstName varchar(30) NOT NULL,
    lastName  varchar(30) NOT NULL,
    dateOfBirth date NOT NULL,
    country varchar(30) NOT NULL
);

CREATE TABLE books_authors
(
    id        SERIAL PRIMARY KEY,
    book_id integer,
    author_id integer
);



-- insert into users(id, firstName, lastName)
-- values (0, "Vasya", "Bobrikov");

-- books id name
-- authors id name
-- books_authors id book_id author_id
--
-- insert into books(id, name)
--     values(1,"Ball")
--
-- insert into authors(id, name)
--     values (1, "Garry")
-- insert into books_authors(id, book_id, author_id)
--     values (1, 1, 1)
--
-- SELECT *
-- FROM books b
-- INNER JOIN books_authors ba
-- ON b.id =  ba.book_id
-- INNER JOIN authors a
-- ON a.id = ba.author_id
