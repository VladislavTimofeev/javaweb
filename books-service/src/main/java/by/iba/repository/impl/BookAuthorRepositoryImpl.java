package by.iba.repository.impl;

import by.iba.domain.BookAuthorsEntity;
import by.iba.repository.BookAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookAuthorRepositoryImpl implements BookAuthorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveBookAuthor(BookAuthorsEntity bookAuthorsEntity) {
        return jdbcTemplate.update(
                "insert into books_authors(book_id, author_id) values (?,?)",
                bookAuthorsEntity.getBookId(), bookAuthorsEntity.getAuthorId()
        );
    }
}
