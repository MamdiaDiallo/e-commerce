package fr.sncf.ecommerce.users.domain.services;

import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import fr.sncf.ecommerce.users.infrastructure.adapters.persistence.JdbcUserRepository;
import lombok.RequiredArgsConstructor;

@Service
public class CreateUserService {

    @Autowired
    private UsersRepository userRepository;

    /**
     * cree un user
     * 
     * @param userParam
     * @return un User
     */
    public User Create(CreateUserParams userParam) {

        User user = User.create(userParam);
        this.userRepository.save(user);
        return user;

    }

}
