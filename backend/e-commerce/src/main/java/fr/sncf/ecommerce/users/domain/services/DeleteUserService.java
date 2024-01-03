package fr.sncf.ecommerce.users.domain.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.sncf.ecommerce.common.exceptions.ResourceNotFoundExeption;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UsersRepository usersRepository;

    public void delete(UUID id) {
        final var user = this.usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption(User.class));

        this.usersRepository.delete(user);

    }
}
