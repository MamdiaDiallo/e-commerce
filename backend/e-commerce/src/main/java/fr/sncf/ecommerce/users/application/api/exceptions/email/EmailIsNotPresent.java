package fr.sncf.ecommerce.users.application.api.exceptions.email;

public class EmailIsNotPresent extends UserException {

    public EmailIsNotPresent(String email) {
        super(String.format("Unknow email please try again \\\"%s\\\"", email));
    }
}
