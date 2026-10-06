package za.ac.cput.factory;

import za.ac.cput.domain.CommercialUnit;
import za.ac.cput.domain.PropertyManager;

public class CommercialUnitFactory {

    public static CommercialUnit createCommercialUnit(String propertyId, String title, double monthlyRent, PropertyManager manager, double floorArea) {
        if (PropertyValidator.isNullOrEmpty(propertyId)) return null;
        if (PropertyValidator.isNullOrEmpty(title)) return null;
        if (monthlyRent <= 0) return null;
        if (manager == null) return null;
        if (floorArea <= 0) return null; // must be greater than zero[cite: 2]

        return (CommercialUnit) new CommercialUnit.Builder()
                .propertyId(propertyId)
                .title(title)
                .monthlyRent(monthlyRent)
                .manager(manager)
                .floorArea(floorArea)
                .build();
    }
}