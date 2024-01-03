package fr.sncf.ecommerce.users.integration.services;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import fr.sncf.ecommerce.users.integration.repository.UsersRepositoryTest;

@ExtendWith(MockitoExtension.class)
public class FindUserByEmailServiceTest {
    /*
     * @Autowired
     * private UsersRepositoryTest usersRepositoryTest;
     * 
     * @Autowired
     * public UsersRepository usersRepository;
     * 
     * @Mock
     * private User user;
     * 
     * @BeforeEach
     * public void setup() {
     * usersRepository = new JdbcUserRepository();
     * }
     * 
     * @Test
     * public void userTest() {
     * ///given
     * 
     * when(user.create(null));
     * }
     */
}
