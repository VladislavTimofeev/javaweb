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
        authorEntity.setFirstName(rs.getString("first_name"));
        authorEntity.setLastName(rs.getString("last_name"));
        authorEntity.setDateOfBirth(rs.getDate("date_of_birth"));
        authorEntity.setCountry(rs.getString("country"));
        authorEntity.setDeleted(rs.getBoolean("is_deleted"));

        return authorEntity;
    }
}
