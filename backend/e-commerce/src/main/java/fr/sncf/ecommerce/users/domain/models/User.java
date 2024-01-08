package fr.sncf.ecommerce.users.domain.models;

import java.io.Serializable;
import java.util.UUID;
import io.micrometer.common.lang.NonNull;
import lombok.Builder;
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
