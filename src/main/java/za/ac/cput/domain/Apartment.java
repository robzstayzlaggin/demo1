package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "apartment")
public class Apartment extends Property {
    private int floorNumber;

    protected Apartment() {}

    private Apartment(Builder builder) {
        super(builder);
        this.floorNumber = builder.floorNumber;
    }

    public int getFloorNumber() { return floorNumber; }

    @Override
    public String toString() {
        return "Apartment{propertyId='" + propertyId + "', title='" + title + "', monthlyRent=" + monthlyRent +
                ", manager=" + manager + ", floorNumber=" + floorNumber + "}";
    }

    public static class Builder extends Property.Builder<Builder> {
        private int floorNumber;

        @Override
        protected Builder self() {
            return this;
        }

        public Builder floorNumber(int floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }

        public Builder copy(Apartment apartment) {
            this.propertyId = apartment.propertyId;
            this.title = apartment.title;
            this.monthlyRent = apartment.monthlyRent;
            this.manager = apartment.manager;
            this.floorNumber = apartment.floorNumber;
            return this;
        }

        @Override
        public Apartment build() {
            return new Apartment(this);
        }
    }
}