package fr.sncf.ecommerce.users.application.api.controllers.requests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import fr.sncf.ecommerce.users.domain.models.UserRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    private int id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private UserRole role;

    public String getRole() {
        return this.role.serializable();
    }

    public void setRole(String userRole) {
        this.role = UserRole.deSerializable(userRole);
    }

}
