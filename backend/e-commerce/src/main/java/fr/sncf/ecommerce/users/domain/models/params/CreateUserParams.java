package fr.sncf.ecommerce.users.domain.models.params;
import fr.sncf.ecommerce.users.domain.models.UserRole;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserParams {

    private final String firstname;

    private final String lastname;

    private final String email;

    private final String password;

    private final UserRole role;
}
