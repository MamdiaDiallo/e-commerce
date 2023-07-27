package fr.sncf.ecommerce.users.application.api.controllers.requests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import fr.sncf.ecommerce.users.domain.models.UserRole;
import lombok.Data;

@Data
public class CreateUserRequest {

    private String email;

    private String firstName;

    private String lastName;

    private UserRole role;

    private String password;

    private LocalDate dateOfBirth;

    private LocalDate createdDate;

    @JsonGetter("role")
    public String getSerializeRole() {
        return this.getRole().toString();
    }

    @JsonSetter("role")
    public void setSerializedRole(String role) {
        this.role = UserRole.deSerializable(role);
    }
}
