package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "commercial_unit")
public class CommercialUnit extends Property {
    private double floorArea;

    protected CommercialUnit() {}

    private CommercialUnit(Builder builder) {
        super(builder);
        this.floorArea = builder.floorArea;
    }

    public double getFloorArea() { return floorArea; }

    @Override
    public String toString() {
        return "CommercialUnit{propertyId='" + propertyId + "', title='" + title + "', monthlyRent=" + monthlyRent +
                ", manager=" + manager + ", floorArea=" + floorArea + "}";
    }

    public static class Builder extends Property.Builder<Builder> {
        private double floorArea;

        @Override
        protected Builder self() {
            return this;
        }

        public Builder floorArea(double floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder copy(CommercialUnit unit) {
            this.propertyId = unit.propertyId;
            this.title = unit.title;
            this.monthlyRent = unit.monthlyRent;
            this.manager = unit.manager;
            this.floorArea = unit.floorArea;
            return this;
        }

        @Override
        public CommercialUnit build() {
            return new CommercialUnit(this);
        }
    }
}