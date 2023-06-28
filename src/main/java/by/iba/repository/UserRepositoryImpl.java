package by.iba.repository;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(UserEntity user) {
        return jdbcTemplate.update(
                "insert into users (id, firstName, lastName) values(?,?,?)",
                user.getId(), user.getFirstName(), user.getLastName());
    }

    @Override
    public List<UserEntity> findAll() {
        return jdbcTemplate.query(
                SELECT_ALL_USERS,
                new UserRowMapper()
        );

    }


    @Override
    public Optional<UserEntity> findById(Long id) {
        return jdbcTemplate.queryForObject(
                SELECT_FROM_USERS_WHERE_ID,
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new UserEntity(
                                rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName")
                        ))
        );
    }

}
