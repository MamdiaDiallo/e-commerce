package fr.sncf.ecommerce.users.application.api.controllers.requests;

import fr.sncf.ecommerce.users.domain.models.UserRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUserRequest {

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    @Setter(AccessLevel.NONE)
    private UserRole role;

    public void setRole(String role) {
        this.role = UserRole.deserialize(role);
    }

}
