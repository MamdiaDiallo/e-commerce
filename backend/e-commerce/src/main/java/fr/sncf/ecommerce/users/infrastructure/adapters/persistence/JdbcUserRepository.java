package fr.sncf.ecommerce.users.infrastructure.adapters.persistence;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.sncf.ecommerce.common.infrastructure.persistence.JdbcUtils;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor()
public class JdbcUserRepository implements UsersRepository {

        private static final String USERS_TABLE = "users";

        private static final String USER_DEFAULT_SELECT_FIELD = " * ";

        private static final String INSERT_INTO = "INSERT INTO";

        private static final String SELECT = "SELECT ";

        private static final String FROM = " FROM";

        private static final String DELETE = "DELETE";

        private static String INSERT_USER = "INSERT INTO " +
                        "users " +
                        "(id,last_name , first_name, password, email, role) " +
                        "VALUES " +
                        "(:id,:lastName,:firstName, :password, :email, :role)";

        private static final String SELECT_ALL_USRS = "SELECT * FROM users";

        private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM users AS u WHERE u.email = :email";

        private static final String SELECT_USER_BY_ID = "SELECT * FROM users AS u WHERE u.id = :id";

        private static final String DELETE_USER = DELETE +
                        " FROM users AS u WHERE ";

        /** implementations des methodes de l'interface User repository */
        @Autowired
        private NamedParameterJdbcTemplate jdbcTemplate;

        @Autowired
        private JdbcUserMapper jdbcUserMapper;

        @Override
        public Optional<User> findById(int id) {
                return JdbcUtils.findAsOptional(
                                () -> jdbcTemplate.queryForObject(SELECT_USER_BY_ID,
                                                Collections.singletonMap("id", id),
                                                this.jdbcUserMapper));
        }

        @Override
        public Optional<User> findByEmail(String email) {
                return JdbcUtils.findAsOptional(
                                () -> jdbcTemplate.queryForObject(SELECT_USER_BY_EMAIL,
                                                Collections.singletonMap("email", email), this.jdbcUserMapper));
        }

        @Override
        public List<User> getUsers() {
                return this.jdbcTemplate.query(SELECT_ALL_USRS,
                                Collections.emptyMap(),
                                this.jdbcUserMapper);

        }

        @Override
        public void save(User user) {

                int vrais = this.jdbcTemplate.update("INSERT INTO " +
                                "users " +
                                "(id,last_name , first_name, password, email, role) " +
                                "VALUES " +
                                "(:id,:lastName,:firstName, :password, :email, :role)",
                                Map.of("id", user.getId(),
                                                "lastName", user.getLastName(),
                                                "firstName", user.getFirstName(),
                                                "password", user.getPassword(),
                                                "email", user.getEmail(),
                                                "role", user.getRole().serializable()));

                if (vrais != 1)
                        throw new IllegalStateException(String.format("inserer des donné correct %d ", user));
        }

        @Override
        public void delete(int id) {
                this.jdbcTemplate.update("DELETE FROM users WHERE id = :id", Collections.singletonMap("id", id));
        }

}
