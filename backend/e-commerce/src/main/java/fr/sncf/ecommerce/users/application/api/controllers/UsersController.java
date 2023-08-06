package fr.sncf.ecommerce.users.application.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.sncf.ecommerce.users.application.api.controllers.requests.CreateUserRequest;
import fr.sncf.ecommerce.users.application.api.controllers.responses.UserResponse;
import fr.sncf.ecommerce.users.application.api.controllers.responses.UserResponseMapper;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import fr.sncf.ecommerce.users.domain.services.CreateUserService;
import fr.sncf.ecommerce.users.domain.services.FindByIdUserService;
import fr.sncf.ecommerce.users.domain.services.FindUserByEmailService;
import fr.sncf.ecommerce.users.domain.services.FindUserByIdService;

@RestController
public class UsersController {

        @Autowired
        private CreateUserService createUserService;

        @Autowired
        private UserResponseMapper userResponseMapper;

        @Autowired
        private FindByIdUserService findByIdUserService;

        @Autowired
        private FindUserByEmailService findUserByEmailService;

        @Autowired
        private FindUserByIdService findUserByIdService;

        @PostMapping("create")
        public ResponseEntity<UserResponse> createdUser(@RequestBody CreateUserRequest createUserRequest) {

                User user = createUserService.Create(CreateUserParams.builder()
                                .firstName(createUserRequest.getFirstName())
                                .lastName(createUserRequest.getLastName())
                                .email(createUserRequest.getEmail())
                                .password(createUserRequest.getPassword())
                                .role(UserRole.deSerializable(createUserRequest.getRole()))
                                .build());
                return ResponseEntity.status(200)
                                .header("e-commerce", "user")
                                .body(this.userResponseMapper.mapResponse(user));

        }

        @GetMapping("users")
        public List<UserResponse> gest() {

                return this.findByIdUserService.getAll()
                                .stream()
                                .map(user -> UserResponse.builder()
                                                .role(user.getRole())
                                                .id(user.getId())
                                                .firstName(user.getFirstName())
                                                .lastName(user.getLastName())
                                                .email(user.getEmail())
                                                .build())
                                .collect(Collectors.toList());

        }

        @GetMapping("read-email/{email}")
        public ResponseEntity<UserResponse> findByEmail(@PathVariable("email") String email) {
                User user = this.findUserByEmailService.findUserByEmail(email);
                return ResponseEntity
                                .status(200)
                                .header("email", "email-user")
                                .body(this.userResponseMapper.mapResponse(user));

        }

        @GetMapping("read-id/{id}")
        public ResponseEntity<UserResponse> finById(@PathVariable("id") int id) {
                User user = this.findUserByIdService.findUserById(id);
                return ResponseEntity
                                .status(200)
                                .header("id", "find user by id")
                                .body(this.userResponseMapper.mapResponse(user));
        }
}