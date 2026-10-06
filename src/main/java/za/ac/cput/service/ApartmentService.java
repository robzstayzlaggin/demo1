package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Apartment;
import za.ac.cput.repository.ApartmentRepository;

import java.util.List;

@Service
public class ApartmentService {

    private final ApartmentRepository repository;

    @Autowired
    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public Apartment save(Apartment apartment) {
        if (apartment == null) return null;
        return repository.save(apartment);
    }

    public Apartment read(String propertyId) {
        return repository.findById(propertyId).orElse(null);
    }

    public List<Apartment> getAll() {
        return repository.findAll();
    }

    public void delete(String propertyId) {
        repository.deleteById(propertyId);
    }

    public List<Apartment> getApartmentsByManager(String managerId) {
        return repository.findByManager_ManagerId(managerId);
    }
}