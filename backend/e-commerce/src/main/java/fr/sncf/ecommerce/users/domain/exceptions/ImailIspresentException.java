package fr.sncf.ecommerce.users.domain.exceptions;

import java.util.Locale;

public class ImailIspresentException extends UserExeption {

    public ImailIspresentException(String email) {
        super(String.format(Locale.FRENCH, " User is Allready existe \"%s\"", email));
    }
}
