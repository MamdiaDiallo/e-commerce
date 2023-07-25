package fr.sncf.ecommerce.users.unit.domain.params;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat; // main one
import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.sncf.ecommerce.users.domain.models.UserRole;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams.UserBuilder;

public class UserParamTest {

    private CreateUserParams userParams;

    @Test
    public void createdUserParamsTest() {
        String email = "mamdia@gmail.com";

        userParams = new UserBuilder()
                .withFirstName("mamdia")
                .withLastName("diallo")
                .withEmail(email)
                .withCreatedDateTime(LocalDateTime.now())
                .withDateOfBirth(LocalDate.of(2000, 01, 14))
                .withRole(UserRole.deSerializable("admin"))
                .build();

        assertEquals(email, userParams.getEmail());

    }
}
