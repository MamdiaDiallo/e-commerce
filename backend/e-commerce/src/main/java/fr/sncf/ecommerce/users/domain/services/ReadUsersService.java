package fr.sncf.ecommerce.users.domain.services;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;

public class ReadUsersService {

    private UsersRepository usersRepository;

    public Iterable<User> getUsers() {
        return usersRepository.getUsers();
    }
}
