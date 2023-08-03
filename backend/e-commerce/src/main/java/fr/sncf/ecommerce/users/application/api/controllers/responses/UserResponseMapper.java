package fr.sncf.ecommerce.users.application.api.controllers.responses;

import org.springframework.stereotype.Component;

import fr.sncf.ecommerce.users.domain.models.User;

@Component
public class UserResponseMapper {
    public UserResponse mapResponse(User user) {
        return UserResponse.builder()
                .createdDate(user.getCreatedDate())
                .dateOfBirth(user.getDateOfBirth())
                .email(user.getEmail())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .id(user.getId())
                .role(user.getRole())
                .build();

    }
}
