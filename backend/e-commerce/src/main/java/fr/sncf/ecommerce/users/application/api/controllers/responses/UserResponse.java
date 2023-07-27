package fr.sncf.ecommerce.users.application.api.controllers.responses;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonGetter;

import fr.sncf.ecommerce.users.domain.models.UserRole;
import lombok.Builder;

@Builder
public class UserResponse {

    private int id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String email;

    private LocalDate createdDate;

    private UserRole role;

    @JsonGetter("role")
    public String getSerializedRole() {
        return this.role.toString();
    }

}
