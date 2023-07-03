package by.iba.repository.mapper;

import by.iba.domain.AuthorEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<AuthorEntity> {
    @Override
    public AuthorEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(rs.getLong("id"));
        authorEntity.setFirstName(rs.getString("firstName"));
        authorEntity.setLastName(rs.getString("lastName"));
        return authorEntity;
    }
}
