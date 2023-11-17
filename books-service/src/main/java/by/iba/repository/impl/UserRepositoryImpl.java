package by.iba.repository.impl;

import by.iba.domain.UserEntity;
import by.iba.repository.UserRepository;
import by.iba.repository.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SELECT_FROM_USERS_WHERE_ID = "select * from users where id = ?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String INSERT_INTO_USERS = "insert into users (first_name, last_name, age, email, date_of_birth) values(?,?,?,?,?)";

    private static final String SELECT_USER_BY_EMAIL = "select * from users where email = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(UserEntity user) {
        return jdbcTemplate.update(
                INSERT_INTO_USERS,
                user.getFirstName(),user.getLastName(),user.getAge(),user.getEmail(),user.getDateOfBirth()
                //new UserRowMapper()
        );
    }

    @Override
    public List<UserEntity> findAll() {
        return jdbcTemplate.query(
                SELECT_ALL_USERS,
                new UserRowMapper()
        );

    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return jdbcTemplate.queryForObject(
                SELECT_USER_BY_EMAIL,
                new Object[]{email},
                (rs, rowNum) ->
                        Optional.of(new UserEntity(
                                rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
                                rs.getInt("age"), rs.getString("email"), rs.getDate("date_of_birth")))
        );
    }


    @Override
    public Optional<UserEntity> findById(Long id) {
        return jdbcTemplate.queryForObject(
                SELECT_FROM_USERS_WHERE_ID,
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new UserEntity(
                                rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
                                rs.getInt("age"), rs.getString("email"), rs.getDate("date_of_birth")))
        );
    }

}
