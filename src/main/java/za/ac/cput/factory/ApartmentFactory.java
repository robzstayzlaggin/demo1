package za.ac.cput.factory;

import za.ac.cput.domain.Apartment;
import za.ac.cput.domain.PropertyManager;

public class ApartmentFactory {

    public static Apartment createApartment(String propertyId, String title, double monthlyRent, PropertyManager manager, int floorNumber) {
        if (PropertyValidator.isNullOrEmpty(propertyId)) return null;
        if (PropertyValidator.isNullOrEmpty(title)) return null;
        if (monthlyRent <= 0) return null; // must be greater than zero[cite: 2]
        if (manager == null) return null;
        if (floorNumber < 0) return null; // must be zero or greater[cite: 2]

        return (Apartment) new Apartment.Builder()
                .propertyId(propertyId)
                .title(title)
                .monthlyRent(monthlyRent)
                .manager(manager)
                .floorNumber(floorNumber)
                .build();
    }
}