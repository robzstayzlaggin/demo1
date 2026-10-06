package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.PropertyManager;
import za.ac.cput.repository.PropertyManagerRepository;

import java.util.List;

@Service
public class PropertyManagerService {

    private final PropertyManagerRepository repository;

    @Autowired
    public PropertyManagerService(PropertyManagerRepository repository) {
        this.repository = repository;
    }

    public PropertyManager save(PropertyManager propertyManager) {
        if (propertyManager == null) return null;
        return repository.save(propertyManager);
    }

    public PropertyManager read(String managerId) {
        return repository.findById(managerId).orElse(null);
    }

    public List<PropertyManager> getAll() {
        return repository.findAll();
    }

    public void delete(String managerId) {
        repository.deleteById(managerId);
    }
}