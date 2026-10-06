package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Apartment;
import za.ac.cput.domain.CommercialUnit;
import za.ac.cput.domain.House;
import za.ac.cput.service.ApartmentService;
import za.ac.cput.service.CommercialUnitService;
import za.ac.cput.service.HouseService;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final CommercialUnitService commercialUnitService;

    @Autowired
    public PropertyController(ApartmentService apartmentService, HouseService houseService, CommercialUnitService commercialUnitService) {
        this.apartmentService = apartmentService;
        this.houseService = houseService;
        this.commercialUnitService = commercialUnitService;
    }

    // --- Apartment Endpoints ---
    @PostMapping("/apartment/create")
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        Apartment created = apartmentService.save(apartment);
        return created != null ? ResponseEntity.ok(created) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/apartment/read/{id}")
    public ResponseEntity<Apartment> readApartment(@PathVariable("id") String id) {
        Apartment apt = apartmentService.read(id);
        return apt != null ? ResponseEntity.ok(apt) : ResponseEntity.notFound().build();
    }

    @GetMapping("/apartment/all")
    public ResponseEntity<List<Apartment>> getAllApartments() {
        return ResponseEntity.ok(apartmentService.getAll());
    }

    // --- House Endpoints ---
    @PostMapping("/house/create")
    public ResponseEntity<House> createHouse(@RequestBody House house) {
        House created = houseService.save(house);
        return created != null ? ResponseEntity.ok(created) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/house/read/{id}")
    public ResponseEntity<House> readHouse(@PathVariable("id") String id) {
        House house = houseService.read(id);
        return house != null ? ResponseEntity.ok(house) : ResponseEntity.notFound().build();
    }

    @GetMapping("/house/all")
    public ResponseEntity<List<House>> getAllHouses() {
        return ResponseEntity.ok(houseService.getAll());
    }

    // --- Commercial Unit Endpoints ---
    @PostMapping("/commercial/create")
    public ResponseEntity<CommercialUnit> createCommercialUnit(@RequestBody CommercialUnit commercialUnit) {
        CommercialUnit created = commercialUnitService.save(commercialUnit);
        return created != null ? ResponseEntity.ok(created) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/commercial/read/{id}")
    public ResponseEntity<CommercialUnit> readCommercialUnit(@PathVariable("id") String id) {
        CommercialUnit unit = commercialUnitService.read(id);
        return unit != null ? ResponseEntity.ok(unit) : ResponseEntity.notFound().build();
    }

    @GetMapping("/commercial/all")
    public ResponseEntity<List<CommercialUnit>> getAllCommercialUnits() {
        return ResponseEntity.ok(commercialUnitService.getAll());
    }
}