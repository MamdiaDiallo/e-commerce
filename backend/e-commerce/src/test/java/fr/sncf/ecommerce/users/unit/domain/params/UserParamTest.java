package fr.sncf.ecommerce.users.unit.domain.params;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import fr.sncf.ecommerce.users.domain.models.UserRole;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;

public class UserParamTest {

    @Autowired
    private CreateUserParams userParams;

    @Test
    public void createdUserParamsTest() {
        String expectedEmail = "mamdia@gmail.com";
        String expectedRole = "user";

        userParams = CreateUserParams.builder()
                .email("mamdia@gmail.com")
                .role(UserRole.deSerializable("user"))
                .build();
        assertThat(userParams.getRole()).isEqualTo(expectedRole);
        assertThat(userParams.getEmail()).isEqualTo(expectedEmail);
    }

}
