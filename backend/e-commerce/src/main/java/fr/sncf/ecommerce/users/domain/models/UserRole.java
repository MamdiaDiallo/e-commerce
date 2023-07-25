package fr.sncf.ecommerce.users.domain.models;

import java.util.Arrays;
import java.util.stream.Stream;

public enum UserRole {

    ADMINISTRATOR("admin"),
    USER("user");

    private String stringValue;

    private UserRole(String stringValue) {
        this.stringValue = stringValue;

    }

    private String serializable() {
        return this.stringValue;
    }

    public static UserRole deSerializable(String userRole) {

        return Arrays.stream(UserRole.values()).filter(role -> role.stringValue.equals(userRole))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(" unknown user role ")));
    }

}
