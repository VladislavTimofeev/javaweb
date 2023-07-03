package by.iba.repository;

import by.iba.domain.AuthorEntity;
import by.iba.domain.UserEntity;
import by.iba.repository.mapper.AuthorRowMapper;
import by.iba.repository.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    private static final String SELECT_FROM_AUTHORS_WHERE_ID = "select * from authors where id = ?";
    private static final String SELECT_ALL_AUTHORS = "select * from authors";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(AuthorEntity author) {
        return jdbcTemplate.update(
                "insert into authors (id, firstName, lastName) values(?,?,?)",
                author.getId(), author.getFirstName(), author.getLastName()
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
                                rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName")
                        ))
        );
    }
}
