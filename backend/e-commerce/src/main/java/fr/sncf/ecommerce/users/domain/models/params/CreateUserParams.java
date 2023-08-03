package fr.sncf.ecommerce.users.domain.models.params;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class CreateUserParams {

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private LocalDate createdDate;

    private String email;

    private String password;

    @Getter(AccessLevel.NONE)
    private UserRole role;

    public String getRole() {
        return this.role.serializable();
    }

}
