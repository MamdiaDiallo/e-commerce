package fr.sncf.ecommerce.users.infrastructure.adapters.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;

public class JdbcUserMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    User user = new User();
    user.setFirstName(rs.getString("first_name"));
    user.setLastName("last_name");
    user.setEmail("email");
    user.setPassword("password");
    user.setRole(UserRole.deSerializable(rs.getString("role")));
    user.setCreatedDate(rs.timeStamp("created_date"));
    user.setDateOfBirth(rs.getTimestamp("date_of_birth"));

    return user;
  }

}
