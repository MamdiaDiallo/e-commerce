package fr.sncf.ecommerce.users.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllUserService {

    private final UsersRepository usersRepository;

    public List<User> read() {
        return this.usersRepository.findAll();
    }
}
