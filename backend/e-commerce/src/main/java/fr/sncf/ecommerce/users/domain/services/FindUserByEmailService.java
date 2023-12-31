package fr.sncf.ecommerce.users.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sncf.ecommerce.users.application.api.exceptions.email.EmailIsNotPresent;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;

@Service
public class FindUserByEmailService {

    @Autowired
    public UsersRepository usersRepository;

    public User findUserByEmail(String email) {
        if (this.usersRepository.findByEmail(email).isPresent())
            return this.usersRepository.findByEmail(email).orElseThrow(() -> new EmailIsNotPresent(email));
        else
            throw new EmailIsNotPresent(email);
    }

}
