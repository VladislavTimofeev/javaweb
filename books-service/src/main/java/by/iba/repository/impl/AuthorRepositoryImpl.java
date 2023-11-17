package by.iba.repository.impl;

import by.iba.domain.AuthorEntity;
import by.iba.repository.AuthorRepository;
import by.iba.repository.mapper.AuthorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    private static final String SELECT_FROM_AUTHORS_WHERE_ID = "select * from authors where id = ?";
    private static final String SELECT_ALL_AUTHORS = "select * from authors";
    private static final String INSERT_INTO_AUTHORS = "insert into authors (first_name, last_name," +
            " date_of_birth, country, is_deleted) values(?,?,?,?,?)";
    //private static final String DELETE_AUTHOR_BY_ID = "delete from authors where id = ?";
    private static final String DELETE_AUTHOR_BY_ID = "update authors set is_deleted = true where id = ?";
    private static final String RESTORE_AUTHOR_BY_ID = "update authors set is_deleted = false where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(AuthorEntity author) {
        return jdbcTemplate.update(
                INSERT_INTO_AUTHORS,
                author.getFirstName(), author.getLastName(), author.getDateOfBirth(), author.getCountry(), author.isDeleted()
        );
    }

    @Override
    public List<AuthorEntity> findAll() {
        return jdbcTemplate.query(
                SELECT_ALL_AUTHORS,
                new AuthorRowMapper()
        );
    }

    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return jdbcTemplate.queryForObject(
                SELECT_FROM_AUTHORS_WHERE_ID,
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new AuthorEntity(
                                rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
                                rs.getDate("date_of_birth"), rs.getString("country"), rs.getBoolean("is_deleted")))
        );
    }

    @Override
    public AuthorEntity deleteAuthorById(Long id) {
        return jdbcTemplate.queryForObject(
                DELETE_AUTHOR_BY_ID,
                new AuthorRowMapper()
        );
    }

    @Override
    public AuthorEntity restoreAuthorById(Long id) {
        return jdbcTemplate.queryForObject(
                RESTORE_AUTHOR_BY_ID,
                new AuthorRowMapper()
        );
    }
}
