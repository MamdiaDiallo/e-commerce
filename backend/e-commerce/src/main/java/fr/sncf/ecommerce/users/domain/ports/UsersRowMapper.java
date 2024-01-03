package fr.sncf.ecommerce.users.domain.ports;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;
import jakarta.annotation.Nullable;

@Component
public class UsersRowMapper implements RowMapper<User> {

    @Override
    @Nullable
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(UUID.fromString(rs.getString("id")))
                .firstname(rs.getString("firstname"))
                .lastname(rs.getString("lastname"))
                .email(rs.getString("email"))
                .role(UserRole.deserialize(rs.getString("role")))
                .password(rs.getString("password"))
                .build();
    }

}
