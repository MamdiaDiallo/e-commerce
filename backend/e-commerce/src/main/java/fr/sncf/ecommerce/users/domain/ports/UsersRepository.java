package fr.sncf.ecommerce.users.domain.ports;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.sncf.ecommerce.users.domain.models.User;
import lombok.RequiredArgsConstructor;

public interface UsersRepository {

    /*
     * Lire un utilisateur si il est dans la base de donné par son identifiant
     * 
     * @param l'id {@link int} identifiant de l'utilisateur
     * 
     * @return l'utilisateur si présent, vide sinon
     */
    Optional<User> findById(int id);

    /*
     * Lire un utilisateur dans la base de données
     * 
     * @param email l'email de l'utilisateur
     * 
     * @return Un {@link Optional} contenant l'utilisateur si présent, vide sinon
     */
    Optional<User> findByEmail(String email);

    /*
     * Lire tous les utilisateurs presents dans la base de données
     * 
     * @return users {@link user} all users
     */
    public List<User> getUsers();

    /*
     * Savaugarder l'était de l'utilisateur en lui attribuant un identifiant
     * 
     * @param user le {@link User} à sauvegarder
     * 
     * @return user {@link User} sauvegarder
     */
    public void save(User user);

    /*
     * Supprimer un utilisateur s'il est dans la base de données
     * 
     * @param user l'objet {@link User} à supprimer
     * 
     * @return
     */
    public void delete(int id);

}
