package fr.sncf.ecommerce.users.domain.models.params;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fr.sncf.ecommerce.users.domain.models.User;
import fr.sncf.ecommerce.users.domain.models.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateUserParams {

    private String firstName;

    private String lastName;

    private LocalDate dateOfirth;

    private LocalDate createdDate;

    private String email;

    private UserRole role;

    private String password;

    /** Build the user parameter and chaine attribute on by on */
    public static class UserBuilder {

        private String firstName;

        private String lastName;

        private LocalDate dateOfBirth;

        private LocalDate createdDate;

        private String email;

        private UserRole role;

        private String password;

        /** Function to build firstname return this UserBuilder */
        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /** Function to build lastname return this UserBuilder */
        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /** Function to build date Of Birth user return this UserBuilder */
        public UserBuilder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        /** Function to build date created user return this UserBuilder */
        public UserBuilder withCreatedDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        /** Function to email role admin || user return this UserBuilder */
        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        /** Function to build password return this UserBuilder */
        public UserBuilder withPassWord(String password) {
            this.password = password;
            return this;
        }

        /** Function to build role admin || user return this UserBuilder */
        public UserBuilder withRole(UserRole role) {
            this.role = role;
            return this;
        }

        public CreateUserParams build() {

            CreateUserParams userParams = new CreateUserParams();

            userParams.firstName = this.firstName;
            userParams.lastName = this.lastName;
            userParams.dateOfirth = this.dateOfBirth;
            userParams.email = this.email;
            userParams.password = this.password;
            userParams.role = this.role;
            userParams.createdDate = this.createdDate;

            return userParams;

        }

    }
}
