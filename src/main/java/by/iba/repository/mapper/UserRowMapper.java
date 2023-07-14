package by.iba.repository.mapper;

import by.iba.domain.UserEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(rs.getLong("id"));
        userEntity.setFirstName(rs.getString("firstName"));
        userEntity.setLastName(rs.getString("lastName"));
        userEntity.setAge(rs.getInt("age"));
        userEntity.setEmail(rs.getString("email"));
        userEntity.setDateOfBirth(rs.getDate("dateOfBirth"));

        return userEntity;

    }
}
