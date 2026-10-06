package za.ac.cput.factory;

import za.ac.cput.domain.Name;

public class NameFactory {

    public static Name createName(String firstName, String middleName, String lastName) {
        if (PropertyValidator.isNullOrEmpty(firstName)) return null;
        if (PropertyValidator.isNullOrEmpty(lastName)) return null;

        String validMiddleName = PropertyValidator.isNullOrEmpty(middleName) ? "" : middleName;

        return new Name.Builder()
                .firstName(firstName)
                .middleName(validMiddleName)
                .lastName(lastName)
                .build();
    }
}