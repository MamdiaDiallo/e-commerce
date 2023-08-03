package fr.sncf.ecommerce.users.infrastructure.adapters.persistence;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.support.JdbcUtil;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.sncf.ecommerce.common.infrastructure.persistence.JdbcUtils;
import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.ports.UsersRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JdbcUserRepository implements UsersRepository {

        private static final String USERS_TABLE = "users";

        private static final String USER_DEFAULT_SELECT_FIELD = "*";

        private static final String INSERT_INTO = "INSERT INTO";

        private static final String SELECT = "SELECT";

        private static final String FROM = "FROM";

        private static final String DELETE = "DELETE";

        private static String INSERT_USER = INSERT_INTO
                        + USERS_TABLE
                        + "(id , last_name, first_name, email, created_date, date_of_birth)"
                        + "VALUES"
                        + " ( :lastName,  :firstName,:email,:createdDate,:dateOfBirth)";

        private static final String SELECT_ALL_USRS = SELECT
                        + USER_DEFAULT_SELECT_FIELD
                        + "FROM"
                        + USERS_TABLE;

        private static final String SELECT_USER_BY_EMAIL = SELECT
                        + USER_DEFAULT_SELECT_FIELD
                        + FROM
                        + USERS_TABLE
                        + "WHERE email = :email";

        private static final String SELECT_USER_BY_ID = SELECT
                        + USER_DEFAULT_SELECT_FIELD
                        + FROM
                        + USERS_TABLE
                        + "WHERE id = :id";

        private static final String DELETE_USER = DELETE
                        + FROM
                        + USERS_TABLE
                        + "WHERE id = :id";

        /** implementations des methodes de l'interface User repository */
        @Autowired
        private NamedParameterJdbcTemplate jdbcTemplate;

        @Autowired
        private JdbcUserMapper jdbcUserMapper;

        @Override
        public Optional<User> findById(int id) {
                return JdbcUtils.findAsOptional(() -> jdbcTemplate.queryForObject(SELECT_USER_BY_ID,
                                Collections.singletonMap("id", id),
                                this.jdbcUserMapper));
        }

        @Override
        public Optional<User> findByEmail(String email) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
        }

        @Override
        public Iterable<User> getUsers() {

                return null;

        }

        @Override
        public void save(User user) {
                int vrais = this.jdbcTemplate.update(INSERT_USER,
                                Map.of("id", user.getId(),
                                                "lastName", user.getLastName(),
                                                "firstName", user.getFirstName(),
                                                "createdDate", user.getCreatedDate(),
                                                "dateOfBirth", user.getDateOfBirth(),
                                                "password", user.getPassword(),
                                                "email", user.getEmail(),
                                                "role", user.getRole().serializable()));
                if (vrais != 1)
                        throw new IllegalStateException(String.format("inserer des donné correct %d ", user));
        }

        @Override
        public void delete(User user) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }

}
