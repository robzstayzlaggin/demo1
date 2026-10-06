package za.ac.cput.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Name implements ValueObject {
    private String firstName;
    private String middleName;
    private String lastName;

    // Protected no-arg constructor required for JPA
    protected Name() {}

    // Private constructor used by the Builder
    private Name(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name{firstName='" + firstName + "', middleName='" + middleName + "', lastName='" + lastName + "'}";
    }

    // Builder Pattern implementation
    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Name name) {
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.lastName = name.lastName;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }
}