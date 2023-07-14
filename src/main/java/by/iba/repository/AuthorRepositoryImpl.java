package by.iba.repository;

import by.iba.domain.AuthorEntity;
import by.iba.repository.mapper.AuthorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    private static final String SELECT_FROM_AUTHORS_WHERE_ID = "select * from authors where id = ?";
    private static final String SELECT_ALL_AUTHORS = "select * from authors";
    private static final String INSERT_INTO_AUTHORS = "insert into authors (firstName, lastName," +
            " dateOfBirth, country) values(?,?,?,?)";
    //private static final String DELETE_AUTHOR_BY_ID = "delete from authors where id = ?";
    private static final String DELETE_AUTHOR_BY_ID = "update authors set isDeleted = true where id = ?";
    private static final String RESTORE_AUTHOR_BY_ID = "update authors set isDeleted = false where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(AuthorEntity author) {
        return jdbcTemplate.update(
                INSERT_INTO_AUTHORS,
                author.getFirstName(), author.getLastName(), author.getDateOfBirth(), author.getCountry()
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
                                rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"),
                                rs.getDate("dateOfBirth"), rs.getString("country"), rs.getBoolean("isDeleted")))
        );
    }

    @Override
    public int deleteAuthorById(Long id) {
        return jdbcTemplate.update(DELETE_AUTHOR_BY_ID, id);
    }

    @Override
    public int restoreAuthorById(Long id) {
        return jdbcTemplate.update(RESTORE_AUTHOR_BY_ID,id);
    }
}
