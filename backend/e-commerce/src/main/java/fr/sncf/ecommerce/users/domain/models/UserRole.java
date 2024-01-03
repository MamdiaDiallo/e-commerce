package fr.sncf.ecommerce.users.domain.models;

import java.util.Arrays;

public enum UserRole {

    USER("user"),
    ADMINISTRATOR("administrator");

    private final String stringValue;

    private static final long serialVersionUID = 0L;

    public String serialize() {
        return this.stringValue;
    }

    private UserRole(String stringValue) {
        this.stringValue = stringValue;
    }

    public static UserRole deserialize(String repr) {
        return Arrays.stream(UserRole.values())
                .filter(role -> role.stringValue.equals(repr))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("invalid value \"%s\"", repr)));
    }
}
