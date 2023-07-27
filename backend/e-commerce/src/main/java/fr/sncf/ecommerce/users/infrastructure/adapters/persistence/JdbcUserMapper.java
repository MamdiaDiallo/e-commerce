package fr.sncf.ecommerce.users.infrastructure.adapters.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;

public class JdbcUserMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet rs, int rowNum) throws SQLException {

    /** conversion de la date naissance en LocalDate */
    Timestamp createdDateTimestamp = rs.getTimestamp("date_of_birth");
    LocalDateTime createdDateconvertDateTime = createdDateTimestamp.toLocalDateTime();
    LocalDate createdDate = createdDateconvertDateTime.toLocalDate();

    /** Conversion de la date naissance en LocalDate */
    Timestamp dateBirthTimestamp = rs.getTimestamp("date_of_birth");
    LocalDateTime dateBirthconverDateTime = dateBirthTimestamp.toLocalDateTime();
    LocalDate dateOfBirth = dateBirthconverDateTime.toLocalDate();

    User user = new User();
    user.setFirstName(rs.getString("first_name"));
    user.setLastName("last_name");
    user.setEmail("email");
    user.setPassword("password");
    user.setRole(UserRole.deSerializable(rs.getString("role")));
    user.setCreatedDate(createdDate);
    user.setDateOfBirth(dateOfBirth);

    return user;
  }

}
