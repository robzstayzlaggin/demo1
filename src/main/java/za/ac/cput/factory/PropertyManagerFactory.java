package za.ac.cput.factory;

import za.ac.cput.domain.Name;
import za.ac.cput.domain.PropertyManager;

public class PropertyManagerFactory {

    public static PropertyManager createPropertyManager(String managerId, Name name, String email, String mobile) {
        if (PropertyValidator.isNullOrEmpty(managerId)) return null;
        if (name == null) return null;
        if (!PropertyValidator.isValidEmail(email)) return null;
        if (!PropertyValidator.isValidMobile(mobile)) return null;

        return new PropertyManager.Builder()
                .managerId(managerId)
                .name(name)
                .email(email)
                .mobile(mobile)
                .build();
    }
}