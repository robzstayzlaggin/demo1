package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.PropertyManager;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.factory.PropertyManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PropertyManagerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "/api/property-managers";

    @Test
    void testCreateAndReadPropertyManager() {
        Name name = NameFactory.createName("Sarah", "M.", "Connor");
        PropertyManager manager = PropertyManagerFactory.createPropertyManager("M300", name, "sarah@urban.co.za", "0841234567");

        ResponseEntity<PropertyManager> postResponse = restTemplate.postForEntity(baseURL + "/create", manager, PropertyManager.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse.getBody());
        assertEquals("M300", postResponse.getBody().getManagerId());

        ResponseEntity<PropertyManager> getResponse = restTemplate.getForEntity(baseURL + "/read/M300", PropertyManager.class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertNotNull(getResponse.getBody());
    }
}