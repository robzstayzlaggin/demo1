package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
    void testCreateNameSuccess() {
        Name name = NameFactory.createName("John", "A.", "Doe");
        assertNotNull(name);
        assertEquals("John", name.getFirstName());
        assertEquals("A.", name.getMiddleName());
        assertEquals("Doe", name.getLastName());
    }

    @Test
    void testCreateNameFailureMissingFirstName() {
        Name name = NameFactory.createName("", "A.", "Doe");
        assertNull(name, "Should return null when first name is empty");
    }
}