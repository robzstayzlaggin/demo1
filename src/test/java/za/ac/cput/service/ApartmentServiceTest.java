package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Apartment;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.PropertyManager;
import za.ac.cput.factory.ApartmentFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.factory.PropertyManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApartmentServiceTest {

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private PropertyManagerService managerService;

    @Test
    void testSaveAndReadApartment() {
        Name name = NameFactory.createName("Bob", "", "Builder");
        PropertyManager manager = PropertyManagerFactory.createPropertyManager("M200", name, "bob@urban.co.za", "0831234567");
        managerService.save(manager);

        Apartment apartment = ApartmentFactory.createApartment("A200", "Hilltop View", 7500.00, manager, 3);
        Apartment saved = apartmentService.save(apartment);

        assertNotNull(saved);
        assertEquals("A200", saved.getPropertyId());

        Apartment found = apartmentService.read("A200");
        assertNotNull(found);
        assertEquals("Hilltop View", found.getTitle());
    }
}