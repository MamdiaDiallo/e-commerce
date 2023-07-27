package fr.sncf.ecommerce.users.application.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.sncf.ecommerce.users.application.api.controllers.requests.CreateUserRequest;
import fr.sncf.ecommerce.users.application.api.controllers.responses.UserResponse;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams.UserBuilder;
import fr.sncf.ecommerce.users.domain.services.CreateUserService;

@Controller
public class UsersController {

    private CreateUserService createUserService;

    @PostMapping(value = "create")
    public ResponseEntity<UserResponse> createdUser(@RequestBody CreateUserRequest createUserRequest) {
CreateUserParams userParams;
userParams  = new UserBuilder().withFirstName(createUserRequest.getFirstName())
                .build();
        createUserService.Create(userParams);

    return null;

}
