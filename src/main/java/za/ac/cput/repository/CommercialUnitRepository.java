package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.CommercialUnit;

import java.util.List;

public interface CommercialUnitRepository extends JpaRepository<CommercialUnit, String> {
    List<CommercialUnit> findByManager_ManagerId(String managerId);
}