package fr.sncf.ecommerce.users.application.api.controllers.responses;

import org.springframework.stereotype.Component;
import fr.sncf.ecommerce.users.domain.models.User;

@Component
public class UserResponseMapper {

    public UserResponse map(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
