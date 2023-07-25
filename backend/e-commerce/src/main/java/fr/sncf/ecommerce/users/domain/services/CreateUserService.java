package fr.sncf.ecommerce.users.domain.services;

import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import java.time.LocalDateTime;

public class CreateUserService {

    private final UsersRepository userRepository;

    private final LocalDateTime dateTime;

    User Create(CreateUserParams userParam) {

        if (this.userRepository.findByEmail(userParam.getEmail()).isPresent()) {

        }
        return null;
    }

}
