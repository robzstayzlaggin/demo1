package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "house")
public class House extends Property {
    private int numberOfBedrooms;

    protected House() {}

    private House(Builder builder) {
        super(builder);
        this.numberOfBedrooms = builder.numberOfBedrooms;
    }

    public int getNumberOfBedrooms() { return numberOfBedrooms; }

    @Override
    public String toString() {
        return "House{propertyId='" + propertyId + "', title='" + title + "', monthlyRent=" + monthlyRent +
                ", manager=" + manager + ", numberOfBedrooms=" + numberOfBedrooms + "}";
    }

    public static class Builder extends Property.Builder<Builder> {
        private int numberOfBedrooms;

        @Override
        protected Builder self() {
            return this;
        }

        public Builder numberOfBedrooms(int numberOfBedrooms) {
            this.numberOfBedrooms = numberOfBedrooms;
            return this;
        }

        public Builder copy(House house) {
            this.propertyId = house.propertyId;
            this.title = house.title;
            this.monthlyRent = house.monthlyRent;
            this.manager = house.manager;
            this.numberOfBedrooms = house.numberOfBedrooms;
            return this;
        }

        @Override
        public House build() {
            return new House(this);
        }
    }
}