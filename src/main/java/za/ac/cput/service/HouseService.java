package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.House;
import za.ac.cput.repository.HouseRepository;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepository repository;

    @Autowired
    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    public House save(House house) {
        if (house == null) return null;
        return repository.save(house);
    }

    public House read(String propertyId) {
        return repository.findById(propertyId).orElse(null);
    }

    public List<House> getAll() {
        return repository.findAll();
    }

    public void delete(String propertyId) {
        repository.deleteById(propertyId);
    }

    public List<House> getHousesByManager(String managerId) {
        return repository.findByManager_ManagerId(managerId);
    }
}