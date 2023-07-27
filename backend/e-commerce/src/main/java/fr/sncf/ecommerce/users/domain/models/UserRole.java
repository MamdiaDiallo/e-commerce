package fr.sncf.ecommerce.users.domain.models;

import java.util.Arrays;

public enum UserRole {

    ADMINISTRATOR("admin"),
    USER("user");

    private String stringValue;

    private UserRole(String stringValue) {
        this.stringValue = stringValue;

    }

    public String serializable() {
        return this.stringValue;
    }

    public static UserRole deSerializable(String userRole) {

        return Arrays.stream(UserRole.values()).filter(role -> role.stringValue.equals(userRole))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(" unknown user role \"%s\"")));
    }

}
