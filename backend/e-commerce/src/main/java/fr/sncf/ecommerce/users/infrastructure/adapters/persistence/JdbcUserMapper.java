package fr.sncf.ecommerce.users.infrastructure.adapters.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;

@Component
public class JdbcUserMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet rs, int rowNum) throws SQLException {

    /** conversion de la date naissance en LocalDate */

    User user = new User();
    user.setId(rs.getInt("id"));
    user.setFirstName(rs.getString("first_name"));
    user.setLastName(rs.getString("last_name"));
    user.setEmail(rs.getString("email"));
    user.setPassword(rs.getString("password"));
    user.setRole(UserRole.deSerializable(rs.getString("role")));
    return user;
  }

}
