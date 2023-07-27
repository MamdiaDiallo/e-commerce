package fr.sncf.ecommerce.common.infrastructure.persistence;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

/**
 * Classe utilitaire pour les repositories JDBC
 */
@Component
public class JdbcUtils {

    /**
     * Exécute une requete de lecture read
     * via {@link org.springframework.jdbc.core.JdbcTemplate#query}
     * et renvoie le résultat sous forme d'objet {@link Optional}
     * plutot que renvoyer une exception de type
     * {@link EmptyResultDataAccessException}.
     */

    public static <T> Optional<T> findAsOptional(Supplier<T> queryResultSupplier) {
        try {
            return Optional.of(queryResultSupplier.get());

        } catch (EmptyResultDataAccessException emty) {
            return Optional.empty();
        }
    }
}
