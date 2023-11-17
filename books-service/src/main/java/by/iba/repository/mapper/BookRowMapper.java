package by.iba.repository.mapper;

import by.iba.domain.BookEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<BookEntity> {


    @Override
    public BookEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(rs.getLong("id"));
        bookEntity.setNumberOfPages(rs.getInt("number_of_pages"));
        bookEntity.setTitle(rs.getString("title"));
        bookEntity.setReleaseYear(rs.getInt("release_year"));

        return bookEntity;
    }
}
