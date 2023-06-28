package by.iba.repository;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SELECT_FROM_USERS_WHERE_ID = "select * from users where id = ?";
//    private static final String PUT_IN_USERS = "INSERT INTO USERS VALUES (?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(UserEntity user) {
        return jdbcTemplate.update(
                "insert into users (id, firstName, lastName) values(?,?,?)",
                user.getId(), user.getFirstName(), user.getLastName());
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

//    @Override
//    public Optional<UserEntity> addUser(UserDto userDto) {
//        return this.jdbcTemplate.update("INSERT INTO users (firstName, lastName) VALUES (?,?)",
//                userDto.setFirstName("firstName"),userDto.setLastName("lastName")
//        );
//    }
}
