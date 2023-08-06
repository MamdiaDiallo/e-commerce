package fr.sncf.ecommerce.users.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import fr.sncf.ecommerce.users.infrastructure.adapters.persistence.JdbcUserRepository;

@Service
public class FindByIdUserService {

    @Autowired
    public UsersRepository usersRepositor = new JdbcUserRepository();

    public List<User> getAll() {
        return this.usersRepositor.getUsers();
    }

}
