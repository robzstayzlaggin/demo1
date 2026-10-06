package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CommercialUnit;
import za.ac.cput.repository.CommercialUnitRepository;

import java.util.List;

@Service
public class CommercialUnitService {

    private final CommercialUnitRepository repository;

    @Autowired
    public CommercialUnitService(CommercialUnitRepository repository) {
        this.repository = repository;
    }

    public CommercialUnit save(CommercialUnit commercialUnit) {
        if (commercialUnit == null) return null;
        return repository.save(commercialUnit);
    }

    public CommercialUnit read(String propertyId) {
        return repository.findById(propertyId).orElse(null);
    }

    public List<CommercialUnit> getAll() {
        return repository.findAll();
    }

    public void delete(String propertyId) {
        repository.deleteById(propertyId);
    }

    public List<CommercialUnit> getCommercialUnitsByManager(String managerId) {
        return repository.findByManager_ManagerId(managerId);
    }
}