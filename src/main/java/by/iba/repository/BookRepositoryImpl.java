package by.iba.repository;

import by.iba.domain.BookEntity;
import by.iba.repository.mapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private static final String SELECT_FROM_BOOKS_WHERE_ID = "select * from books where id = ?";

    private static final String SELECT_ALL_BOOKS = "select * from books";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(BookEntity book) {
        return jdbcTemplate.update(
                "insert into books (id, numberOfPages, title) values(?,?,?)",
                book.getId(), book.getNumberOfPages(), book.getTitle()
        );
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
                                rs.getLong("id"), rs.getInt("numberOfPages"), rs.getString("title")
                        ))
        );
    }

}
