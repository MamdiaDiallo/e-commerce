package fr.sncf.ecommerce.users.unit.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat; // main one

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams.UserBuilder;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    private User user;

    @BeforeEach
    public void init() {

        user = new User();
    }

    /** test pour creer un user */
    @Test
    public void UserBuilderTest() {

        String expectedFirstName = "mamdia";
        String expectedEmail = "mamdia@gmail.com";

        CreateUserParams createUserParams = new UserBuilder()
                .withFirstName("mamdia")
                .withEmail("mamdia@gmail.com")
                .build();

        String email = user.create(createUserParams).getEmail();
        String firstName = user.create(createUserParams).getFirstName();

        assertThat(email).isEqualTo(expectedEmail);
        assertThat(expectedFirstName).isEqualTo(firstName);
    }
}
