package fr.sncf.ecommerce.users.application.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.sncf.ecommerce.users.application.api.controllers.requests.CreateUserRequest;
import fr.sncf.ecommerce.users.application.api.controllers.responses.UserResponse;
import fr.sncf.ecommerce.users.application.api.controllers.responses.UserResponseMapper;
import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import fr.sncf.ecommerce.users.domain.services.CreateUserService;
import fr.sncf.ecommerce.users.domain.services.DeleteUserService;
import fr.sncf.ecommerce.users.domain.services.FindByIdUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import fr.sncf.ecommerce.users.domain.services.FindAllUserService;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UsersController {

        @Autowired
        private CreateUserService createUserUseCase;

        @Autowired
        private UserResponseMapper userResponseMapper;

        @Autowired
        private FindByIdUserService findByIdUserService;

        @Autowired
        private FindAllUserService findUserByIdService;

        @Autowired
        private DeleteUserService deleteUserService;

        /*
         * create user
         */
        @PostMapping
       // @ResponseStatus(HttpStatus.CREATED)
        public UserResponse createUser(@Valid @RequestBody CreateUserRequest request) {

                final var user = this.createUserUseCase.create(
                                CreateUserParams.builder()
                                                .firstname(request.getFirstname())
                                                .lastname(request.getLastname())
                                                .email(request.getEmail())
                                                .password(request.getPassword())
                                                .role(request.getRole())
                                                .build());
                return this.userResponseMapper.map(user);
        }

        @GetMapping
        public List<UserResponse> findAll() {

                return this.findUserByIdService.read()
                                .stream()
                                .map(this.userResponseMapper::map)
                                .toList();
        }

        @GetMapping("{id}")
        //@PreAuthorize("hasRole('user')")
        public UserResponse findById(@PathVariable("id") UUID id) {
                return this.userResponseMapper.map(this.findByIdUserService.read(id));
        }

        @DeleteMapping("{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteById(@PathVariable("id") UUID id) {
                this.deleteUserService.delete(id);
        }
}