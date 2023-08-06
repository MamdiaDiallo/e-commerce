package fr.sncf.ecommerce.users.application.api.controllers.responses;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonGetter;

import fr.sncf.ecommerce.users.domain.models.UserRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    @Getter(AccessLevel.NONE)
    private UserRole role;

    public String getRole() {
        return this.role.serializable();
    }

}
