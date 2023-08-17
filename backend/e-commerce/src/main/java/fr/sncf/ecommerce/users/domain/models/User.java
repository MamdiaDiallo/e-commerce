package fr.sncf.ecommerce.users.domain.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private UserRole role;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static User create(CreateUserParams userParams) {
        User user = new User();

        user.setRole(UserRole.deSerializable(userParams.getRole()));
        user.setId(userParams.getId());
        user.setFirstName(userParams.getFirstName());
        user.setLastName(userParams.getLastName());
        user.setEmail(userParams.getEmail());
        user.setPassword(userParams.getPassword());

        return user;
    }

    public static Object withDefaultPasswordEncoder() {
        return null;
    }

}
