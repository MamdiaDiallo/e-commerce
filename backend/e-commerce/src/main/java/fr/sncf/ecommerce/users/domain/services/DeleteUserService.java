package fr.sncf.ecommerce.users.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sncf.ecommerce.users.application.api.exceptions.email.EmailIsNotPresent;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;

@Service
public class DeleteUserService {

    @Autowired
    public UsersRepository usersRepository;

    public void deleteUser(int id) {
        if (this.usersRepository.findById(id).isPresent())
            this.usersRepository.delete(id);
        else
            throw new EmailIsNotPresent("unknow id try again");
    }
}
