package fr.sncf.ecommerce.users.domain.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.sncf.ecommerce.users.domain.models.params.CreateUserParams;
import io.micrometer.common.lang.NonNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class User implements Serializable {

    @Setter
    private UUID id;

    @NonNull
    private final String firstname;

    @NonNull
    private final String lastname;

    @NonNull
    private final String email;

    @NonNull
    private final UserRole role;

    @NonNull
    private final String password;
}
