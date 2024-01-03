package fr.sncf.ecommerce.users.unit.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;

@ExtendWith(MockitoExtension.class)
public class UserTest {
    /*
     * @Autowired
     * private User user;
     * 
     * @Autowired
     * private CreateUserParams createUserParams;
     * 
     * @Test
     * public void userTest() {
     * String expectedEmail = "mamd@gmail.com";
     * String expectedRole = "admin";
     * 
     * createUserParams = CreateUserParams.builder()
     * .email("mamd@gmail.com")
     * .role(UserRole.deSerializable("admin"))
     * .build();
     * 
     * user = User.create(createUserParams);
     * 
     * assertThat(user.getEmail()).isEqualTo(expectedEmail);
     * assertThat(user.getRole().serializable()).isEqualTo(expectedRole);
     * }
     */
}
