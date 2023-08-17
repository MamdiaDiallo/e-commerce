package fr.sncf.ecommerce.users.application.api.configurations;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomeUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.usersRepository.findByEmail(username)
                .map(userDataDetail -> new CustomeUserDetails(userDataDetail))
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("username with emal %s was not found", username)));
    }

    public Class<CustomeUserDetails> extracted() {
        return CustomeUserDetails.class;
    }

    @RequiredArgsConstructor
    public static class CustomeUserDetails implements UserDetails {

        private final User user;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority(user.getRole().serializable()));
        }

        @Override
        public String getPassword() {
            return this.user.getPassword();
        }

        @Override
        public String getUsername() {
            return this.user.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

    }
}
