package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "property_manager")
public class PropertyManager {
    @Id
    private String managerId;

    @Embedded
    private Name name;

    private String email;
    private String mobile;

    protected PropertyManager() {}

    private PropertyManager(Builder builder) {
        this.managerId = builder.managerId;
        this.name = builder.name;
        this.email = builder.email;
        this.mobile = builder.mobile;
    }

    public String getManagerId() { return managerId; }
    public Name getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }

    @Override
    public String toString() {
        return "PropertyManager{managerId='" + managerId + "', name=" + name + ", email='" + email + "', mobile='" + mobile + "'}";
    }

    public static class Builder {
        private String managerId;
        private Name name;
        private String email;
        private String mobile;

        public Builder managerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder copy(PropertyManager manager) {
            this.managerId = manager.managerId;
            this.name = manager.name;
            this.email = manager.email;
            this.mobile = manager.mobile;
            return this;
        }

        public PropertyManager build() {
            return new PropertyManager(this);
        }
    }
}