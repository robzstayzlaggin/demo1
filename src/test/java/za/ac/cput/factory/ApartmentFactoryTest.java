package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Apartment;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.PropertyManager;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentFactoryTest {

    @Test
    void testCreateApartmentSuccess() {
        Name name = NameFactory.createName("Alice", "", "Smith");
        PropertyManager manager = PropertyManagerFactory.createPropertyManager("M100", name, "alice@urban.co.za", "0821234567");

        Apartment apartment = ApartmentFactory.createApartment("A100", "Sunset Apartments", 6000.00, manager, 1);

        assertNotNull(apartment);
        assertEquals("A100", apartment.getPropertyId());
        assertEquals(6000.00, apartment.getMonthlyRent());
        assertEquals(1, apartment.getFloorNumber());
        assertNotNull(apartment.getManager());
    }

    @Test
    void testCreateApartmentInvalidRent() {
        Name name = NameFactory.createName("Alice", "", "Smith");
        PropertyManager manager = PropertyManagerFactory.createPropertyManager("M100", name, "alice@urban.co.za", "0821234567");

        Apartment apartment = ApartmentFactory.createApartment("A100", "Sunset Apartments", -500.00, manager, 1);

        assertNull(apartment, "Should return null if monthly rent is not greater than zero");
    }
}