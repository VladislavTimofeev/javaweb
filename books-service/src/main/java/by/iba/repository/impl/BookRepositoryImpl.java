package by.iba.repository.impl;

import by.iba.domain.BookEntity;
import by.iba.repository.BookRepository;
import by.iba.repository.mapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private static final String SELECT_FROM_BOOKS_WHERE_ID = "select * from books where id = ?";
    private static final String INSERT_INTO_BOOKS = "insert into books (number_of_pages, title, release_year, price) values(?,?,?,?)";
    private static final String SELECT_BOOKS = "select * from books";

    private static final String SELECT_ALL_BOOKS = "SELECT * " +
            "FROM books b " +
            "INNER JOIN books_authors ba " +
            "ON b.id =  ba.book_id " +
            "INNER JOIN authors a " +
            "ON a.id = ba.author_id ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long save(BookEntity book) {
        return jdbcTemplate.update(
                INSERT_INTO_BOOKS,
                book.getNumberOfPages(), book.getTitle(), book.getReleaseYear(), book.getPrice()
        );
    }

    @Override
    public List<BookEntity> findAll() {
        return jdbcTemplate.query(
                SELECT_BOOKS,
                new BookRowMapper()
        );
    }

    @Override
    public Optional<BookEntity> findById(Long id) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_FROM_BOOKS_WHERE_ID,
                    new Object[]{id},
                    (rs, rowNum) ->
                            Optional.of(new BookEntity(
                                    rs.getLong("id"), rs.getInt("number_of_pages"),
                                    rs.getString("title"), rs.getInt("release_year"),
                                    rs.getDouble("price")
                            ))
            );
        } catch (DataAccessException e) {
//            throw new RepositoryException(e);
            System.err.println(e);
            return Optional.empty();
        }
    }

}
