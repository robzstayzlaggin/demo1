package za.ac.cput.factory;

import za.ac.cput.domain.House;
import za.ac.cput.domain.PropertyManager;

public class HouseFactory {

    public static House createHouse(String propertyId, String title, double monthlyRent, PropertyManager manager, int numberOfBedrooms) {
        if (PropertyValidator.isNullOrEmpty(propertyId)) return null;
        if (PropertyValidator.isNullOrEmpty(title)) return null;
        if (monthlyRent <= 0) return null;
        if (manager == null) return null;
        if (numberOfBedrooms < 1) return null; // must be at least 1[cite: 2]

        return (House) new House.Builder()
                .propertyId(propertyId)
                .title(title)
                .monthlyRent(monthlyRent)
                .manager(manager)
                .numberOfBedrooms(numberOfBedrooms)
                .build();
    }
}