package fr.sncf.ecommerce.users.domain.models;

public enum UserRole {

    ADMIN("admin"),
    USER("user");

    private final String stringValue;

    private UserRole(String stringValue) {
        this.stringValue = stringValue;
    }

    public String serializable() {
        return this.stringValue;
    }

    public static UserRole deSerializable(String userRole) {

        for (UserRole role : UserRole.values()) {
            if (role.stringValue.equals(userRole)) {
                return role;
            }
        }
        throw new IllegalArgumentException(String.format(" unknown user role \"%s\"", userRole));
    }

}
