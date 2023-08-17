package fr.sncf.ecommerce.users.application.api.controllers.responses;

import org.springframework.stereotype.Component;
import fr.sncf.ecommerce.users.domain.models.User;

@Component
public class UserResponseMapper {

    public UserResponse mapResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();

    }
}
