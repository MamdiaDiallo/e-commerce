package fr.sncf.ecommerce.users.application.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.sncf.ecommerce.users.application.api.controllers.requests.CreateUserRequest;
import fr.sncf.ecommerce.users.application.api.controllers.responses.UserResponse;
import fr.sncf.ecommerce.users.application.api.controllers.responses.UserResponseMapper;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import fr.sncf.ecommerce.users.domain.services.CreateUserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private CreateUserService createUserService;

    private UserResponseMapper userResponseMapper;

    @Autowired // Assuming CreateUserService is a Spring Bean and properly configured
    public UsersController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createdUser(@RequestBody CreateUserRequest createUserRequest) {

        User user = createUserService.Create(CreateUserParams.builder()
                .firstName(createUserRequest.getFirstName())
                .createdDate(createUserRequest.getDateOfBirth())
                .dateOfBirth(createUserRequest.getDateOfBirth())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .role(UserRole.deSerializable(createUserRequest.getRole()))
                .build());
        return ResponseEntity.status(200)
                .body(this.userResponseMapper.mapResponse(user));

    }

    @GetMapping(value = "/users")
    public ResponseEntity<String> gest() {
        return ResponseEntity.ok("merci");
    }
}