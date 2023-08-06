package fr.sncf.ecommerce.users.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sncf.ecommerce.users.application.api.exceptions.email.EmailIsNotPresent;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;

@Service
public class FindUserByIdService {

    @Autowired
    private UsersRepository usersRepository;

    public User findUserById(int id) {
        if (this.usersRepository.findById(id).isPresent())
            return this.usersRepository.findById(id).orElseThrow(() -> new EmailIsNotPresent("unknow user id"));
        else
            throw new EmailIsNotPresent("unknow user id ");
    }
}
