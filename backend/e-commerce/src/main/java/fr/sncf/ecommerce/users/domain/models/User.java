package fr.sncf.ecommerce.users.domain.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import lombok.Data;

@Data
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String email;

    private LocalDateTime createdDateTime;

    private UserRole role;

    private String password;

    public User create(CreateUserParams userParams) {
        User user = new User();
        user.setFirstName(userParams.getFirstName());
        user.setLastName(userParams.getLastName());
        user.setDateOfBirth(userParams.getDateOfirth());
        user.setEmail(userParams.getEmail());
        user.setCreatedDateTime(userParams.getCreatedDateTime());
        user.setRole(userParams.getRole());
        user.setPassword(userParams.getPassword());

        return user;
    }

}
