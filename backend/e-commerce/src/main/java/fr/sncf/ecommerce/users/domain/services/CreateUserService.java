package fr.sncf.ecommerce.users.domain.services;

import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import fr.sncf.ecommerce.users.domain.exceptions.ImailIspresentException;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;

import java.time.Instant;
import java.time.LocalDateTime;

public class CreateUserService {

    private UsersRepository userRepository;

    public User Create(CreateUserParams userParam) throws ImailIspresentException {

        if (userRepository.findByEmail(userParam.getEmail()).isPresent()) {
            throw new ImailIspresentException(userParam.getEmail());
        } else {
            User user = new User();
            user.create(userParam);

            return user;
        }
    }

}
