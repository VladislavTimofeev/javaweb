package by.iba.repository.impl;

import by.iba.domain.BookEntity;
import by.iba.repository.BookRepository;
import by.iba.repository.mapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private static final String SELECT_FROM_BOOKS_WHERE_ID = "select * from books where id = ?";

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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into books (numberOfPages, title, releaseYear) values(?,?,?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, book.getNumberOfPages());
            ps.setString(2, book.getTitle());
            ps.setInt(3,book.getReleaseYear());
            return ps;
        }, keyHolder);
        return Long.valueOf(String.valueOf(keyHolder.getKey()));
    }

    @Override
    public List<BookEntity> findAll() {
        return jdbcTemplate.query(
                SELECT_ALL_BOOKS,
                new BookRowMapper()
        );
    }

    @Override
    public Optional<BookEntity> findById(Long id) {
        return jdbcTemplate.queryForObject(
                SELECT_FROM_BOOKS_WHERE_ID,
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new BookEntity(
                                rs.getLong("id"), rs.getInt("numberOfPages"),
                                rs.getString("title"), rs.getInt("releaseYear")
                        ))
        );
    }

}
