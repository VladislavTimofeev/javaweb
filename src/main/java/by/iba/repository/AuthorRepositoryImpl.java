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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(AuthorEntity author) {
        return jdbcTemplate.update(
                INSERT_INTO_AUTHORS,
                author.getFirstName(),author.getLastName(),author.getDateOfBirth(),author.getCountry()
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
                                rs.getDate("dateOfBirth"), rs.getString("country")))
        );
    }
}
