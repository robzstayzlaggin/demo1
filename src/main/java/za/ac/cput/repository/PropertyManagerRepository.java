package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.PropertyManager;

public interface PropertyManagerRepository extends JpaRepository<PropertyManager, String> {
}