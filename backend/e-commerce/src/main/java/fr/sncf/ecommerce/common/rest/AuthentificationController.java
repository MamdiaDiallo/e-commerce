package fr.sncf.ecommerce.common.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.sncf.ecommerce.common.configurations.CustomUserDetailsService.CustomUserDetails;
import fr.sncf.ecommerce.users.application.api.controllers.responses.UserResponse;
import fr.sncf.ecommerce.users.application.api.controllers.responses.UserResponseMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/auth/state")
@RequiredArgsConstructor
@CrossOrigin(" http://localhost:4200")
public class AuthentificationController {

    private final UserResponseMapper userResponseMapper;
    /**
     * Récupérer le "nom" de l'utilisateur aut
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<UserResponse> getAuthentificationState() {
        // access to authentification object context
        final var authentification = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentification);
        if (authentification instanceof AnonymousAuthenticationToken) {
            return ResponseEntity.noContent().build();
        }
        final var userDetails = (CustomUserDetails)authentification.getPrincipal();
        return ResponseEntity.ok(this.userResponseMapper.map(userDetails.getUser()));
    }
}
