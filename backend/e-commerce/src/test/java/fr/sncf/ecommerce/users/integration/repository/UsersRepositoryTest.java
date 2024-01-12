package fr.sncf.ecommerce.users.integration.repository;

import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

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
