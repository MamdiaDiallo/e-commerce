package fr.sncf.ecommerce.users.application.api.controllers.responses;

import java.util.UUID;

import fr.sncf.ecommerce.users.domain.models.UserRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {

    private final UUID id;

    private final String firstname;

    private final String lastname;

    private final String email;

    @Getter(AccessLevel.NONE)
    private final UserRole role;

    public String getRole() {
        return this.role.serialize();
    }

}
