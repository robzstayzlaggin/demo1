package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Property;

public interface PropertyRepository extends JpaRepository<Property, String> {
}