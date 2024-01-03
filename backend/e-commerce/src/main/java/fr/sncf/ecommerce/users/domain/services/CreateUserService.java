package fr.sncf.ecommerce.users.domain.services;

import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.sncf.ecommerce.users.application.api.exceptions.email.EmailIsNotPresent;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    @Autowired
    private UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * cree un user
     * 
     * @param userParam
     * @return un User
     */
    public User create(CreateUserParams userParam) {

        if (this.usersRepository.findByEmail(userParam.getEmail()).isPresent()) {
            throw new EmailIsNotPresent(userParam.getEmail());
        }

        final var user = User.builder()
                .firstname(userParam.getFirstname())
                .lastname(userParam.getLastname())
                .email(userParam.getEmail())
                .password(this.passwordEncoder.encode(userParam.getPassword()))
                .role(userParam.getRole())
                .build();

        this.usersRepository.create(user);

        return (user);

    }

}
