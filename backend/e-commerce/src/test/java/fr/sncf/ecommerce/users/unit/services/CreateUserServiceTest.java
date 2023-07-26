package fr.sncf.ecommerce.users.unit.services;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat; // main one

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams.UserBuilder;
import fr.sncf.ecommerce.users.domain.services.CreateUserService;

public class CreateUserServiceTest {

    private CreateUserParams userParams;

    private User user;

    private CreateUserService createUserService;

    @BeforeEach
    public void setup() {
        user = new User();
        createUserService = new CreateUserService();
    }

    @Test
    public void createUserRepository() {

        String expectedFirstName = "Barry";
        String expectedLastName = "Mamoudou";
        String expectedLastEmail = "barry@gmail.com";
        LocalDate expectedDateBirth = LocalDate.of(1999, 05, 27);

        userParams = new UserBuilder()
                .withCreatedDate(LocalDate.now())
                .withFirstName("Barry")
                .withLastName("Mamoudou")
                .withEmail("barry@gmail.com")
                .withDateOfBirth(LocalDate.of(1999, 05, 27))
                .build();
        User userResult = user.create(userParams);

        assertThat(userResult.getLastName()).isEqualTo(expectedLastName);
        assertThat(userResult.getDateOfBirth()).isEqualTo(expectedDateBirth);
        assertThat(userResult.getEmail()).isEqualTo(expectedLastEmail);
        assertThat(userResult.getFirstName()).isEqualTo(expectedFirstName);
    }

    @Test
    public void createUserServiceTest() {
        String expectedFirstName = "Barry";
        String expectedLastName = "Mamoudou";
        String expectedLastEmail = "barry@gmail.com";
        LocalDate expectedDateBirth = LocalDate.of(1999, 05, 27);

        userParams = new UserBuilder()
                .withCreatedDate(LocalDate.now())
                .withFirstName("Barry")
                .withLastName("Mamoudou")
                .withEmail("barry@gmail.com")
                .withDateOfBirth(LocalDate.of(1999, 05, 27))
                .build();

        User result = createUserService.Create(userParams);
        assertThat(result.getEmail()).isEqualTo(expectedLastEmail);

    }

}
