package fr.sncf.ecommerce.users.domain.ports;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.sncf.ecommerce.common.infrastructure.persistence.JdbcUtils;
import fr.sncf.ecommerce.users.domain.models.User;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UsersRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final UsersRowMapper usersRowMapper;

    // @PreAuthorize("@usersGuard.canCreate(#user, principal)")
    public void create(User user) {
        final UUID id = UUID.randomUUID();
        final var insertQuery = "INSERT INTO users " +
                "(id, firstname, lastname, email, password, role)" +
                "VALUES (:id, :firstname, :lastname, :email, :password, :role)";

        // Check for null role
        String role = (user.getRole() != null) ? user.getRole().serialize() : null;

        final var updated = this.jdbcTemplate.update(
                insertQuery,
                Map.of(
                        "id", id,
                        "firstname", user.getFirstname(),
                        "lastname", user.getLastname(),
                        "email", user.getEmail(),
                        "password", user.getPassword(),
                        "role", role));

        if (updated != 1) {
            throw new IllegalStateException(String.format("Single insert query returned %d", updated));
        }

        user.setId(id);
    }

    public Optional<User> findByEmail(String email) {

        final var selectQuery = "SELECT * FROM \"users\" AS \"user\" WHERE \"user\".\"email\" = :email";

        return JdbcUtils.findAsOptional(() -> this.jdbcTemplate.queryForObject(
                selectQuery,
                Collections.singletonMap("email", email),
                this.usersRowMapper));
    }

    public Optional<User> findById(UUID id) {

        final var selectQuery = "SELECT * FROM \"users\" AS \"user\" WHERE \"user\".\"id\" = :id";

        return JdbcUtils.findAsOptional(() -> this.jdbcTemplate.queryForObject(
                selectQuery,
                Collections.singletonMap("id", id.toString()),
                this.usersRowMapper));
    }

    public List<User> findAll() {

        final var selectQuery = "SELECT * FROM \"users\" ";

        return this.jdbcTemplate.query(
                selectQuery,
                Collections.emptyMap(),
                this.usersRowMapper);
    }

    public void delete(User user) {

        final var deleteQuery = "DELETE FROM \"users\" AS \"user\" WHERE \"user\".\"id\" = :id";

        final var deleted = this.jdbcTemplate.update(
                deleteQuery,
                Collections.singletonMap("id", user.getId().toString()));

        if (deleted != 1) {
            throw new IllegalStateException(String.format("no user or more than one user were deleted (%d)", deleted));
        }
    }
}
