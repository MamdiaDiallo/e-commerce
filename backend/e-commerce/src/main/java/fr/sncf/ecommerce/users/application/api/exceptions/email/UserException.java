package fr.sncf.ecommerce.users.application.api.exceptions.email;

public abstract class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
