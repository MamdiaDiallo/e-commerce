package fr.sncf.ecommerce.users.integration.repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.sncf.ecommerce.common.infrastructure.persistence.JdbcUtils;
import fr.sncf.ecommerce.users.domain.models.User;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor()
public class UsersRepository {
    /*
     * @Autowired
     * private JdbcUserMapper jdbcUserMapper;
     * 
     * @Autowired
     * private NamedParameterJdbcTemplate jdbcTemplate;
     * 
     * public Optional<User> findById(int id) {
     * return JdbcUtils.findAsOptional(
     * () ->
     * jdbcTemplate.queryForObject("SELECT * FROM users AS u WHERE u.id = :id",
     * Collections.singletonMap("id", id),
     * this.jdbcUserMapper));
     * }
     * 
     * public Optional<User> findByEmail(String email) {
     * return JdbcUtils.findAsOptional(
     * () ->
     * jdbcTemplate.queryForObject("SELECT * FROM users AS u WHERE u.email = :email"
     * ,
     * Collections.singletonMap("email", email), this.jdbcUserMapper));
     * }
     * 
     * public List<User> getUsers() {
     * return this.jdbcTemplate.query("SELECT * FROM users",
     * Collections.emptyMap(),
     * this.jdbcUserMapper);
     * 
     * }
     * 
     * public void save(User user) {
     * // SqlParameterSource parametre = new BeanPropertySqlParameterSource(user);
     * 
     * int vrais = this.jdbcTemplate.update("INSERT INTO " +
     * "users " +
     * "(id,last_name , first_name, password, email, role) " +
     * "VALUES " +
     * "(:id,:lastName,:firstName, :password, :email, :role)",
     * Map.of("id", user.getId(),
     * "lastName", user.getLastName(),
     * "firstName", user.getFirstName(),
     * "password", user.getPassword(),
     * "email", user.getEmail(),
     * "role", user.getRole().serializable()));
     * 
     * if (vrais != 1)
     * throw new
     * IllegalStateException(String.format("inserer des donné correct %d ", user));
     * }
     * 
     * public void delete(int id) {
     * this.jdbcTemplate.update("DELETE FROM users WHERE id = :id",
     * Collections.singletonMap("id", id));
     * }
     */
}
