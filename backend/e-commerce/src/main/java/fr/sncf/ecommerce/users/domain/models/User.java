package fr.sncf.ecommerce.users.domain.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

}
