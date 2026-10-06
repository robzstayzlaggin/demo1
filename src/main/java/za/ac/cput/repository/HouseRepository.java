package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.House;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, String> {
    List<House> findByManager_ManagerId(String managerId);
}