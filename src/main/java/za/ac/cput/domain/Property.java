package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "property")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Property {
    @Id
    protected String propertyId;
    protected String title;
    protected double monthlyRent;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    protected PropertyManager manager;

    protected Property() {}

    protected Property(Builder<?> builder) {
        this.propertyId = builder.propertyId;
        this.title = builder.title;
        this.monthlyRent = builder.monthlyRent;
        this.manager = builder.manager;
    }

    public String getPropertyId() { return propertyId; }
    public String getTitle() { return title; }
    public double getMonthlyRent() { return monthlyRent; }
    public PropertyManager getManager() { return manager; }

    public abstract String toString();

    public abstract static class Builder<T extends Builder<T>> {
        protected String propertyId;
        protected String title;
        protected double monthlyRent;
        protected PropertyManager manager;

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T propertyId(String propertyId) {
            this.propertyId = propertyId;
            return self();
        }

        public T title(String title) {
            this.title = title;
            return self();
        }

        public T monthlyRent(double monthlyRent) {
            this.monthlyRent = monthlyRent;
            return self();
        }

        public T manager(PropertyManager manager) {
            this.manager = manager;
            return self();
        }

        public abstract Property build();
    }
}