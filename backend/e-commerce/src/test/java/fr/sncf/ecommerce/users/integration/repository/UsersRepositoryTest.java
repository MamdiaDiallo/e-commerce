package fr.sncf.ecommerce.users.integration.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;

@DataJdbcTest
public class UsersRepositoryTest {
    /*
     * @Autowired
     * private fr.sncf.ecommerce.users.domain.ports.UsersRepository repository;
     * 
     * @Autowired
     * private CreateUserParams userParams;
     * 
     * @BeforeEach
     * public void setup() {
     * repository = new JdbcUserRepository();
     * }
     * 
     * @Test
     * public void usersRepositoryTest() {
     * // given
     * String email = "mamdi@gmail.com";
     * 
     * User user = User.create(userParams.builder()
     * .email(email)
     * .role(UserRole.deSerializable("user"))
     * .firstName("mamd")
     * .lastName("mda")
     * .password("email").build());
     * this.repository.save(user);
     * // when
     * 
     * boolean exist = this.repository.findByEmail(email).isPresent();
     * // then
     * assertThat(exist).isTrue();
     * 
     * }
     */
}
