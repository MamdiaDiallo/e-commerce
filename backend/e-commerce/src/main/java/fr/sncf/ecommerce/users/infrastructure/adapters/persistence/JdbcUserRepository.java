package fr.sncf.ecommerce.users.infrastructure.adapters.persistence;

import java.util.Optional;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
            + "(id,last_name , last_name, first_name, email, created_date, date_of_date, role)"
            + "VALUES"
            + " ( last_name = :lastName, first_name = :firstName,email = :email, role = :role, created_date = :createdDat, date_of_birth = :dateOfBirth,    role = :role,)";

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

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Optional<User> findById(int id) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Override
    public Iterable<User> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
