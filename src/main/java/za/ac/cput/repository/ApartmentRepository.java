package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Apartment;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, String> {
    List<Apartment> findByManager_ManagerId(String managerId);
}