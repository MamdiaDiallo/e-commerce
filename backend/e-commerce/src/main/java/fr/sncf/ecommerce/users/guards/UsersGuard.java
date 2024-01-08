package fr.sncf.ecommerce.users.guards;

import org.springframework.stereotype.Component;

import fr.sncf.ecommerce.common.configurations.CustomUserDetailsService.CustomUserDetails;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;

@Component("usersGuard")
public class UsersGuard {

    public boolean canCreate(User user, Object principal) {

        if (principal instanceof CustomUserDetails) {
            final var caller = ((CustomUserDetails) principal).getUser();

            if (caller.getRole().equals(UserRole.ADMINISTRATOR)) {
                return true;
            }
        }
        return false;
    }
}
