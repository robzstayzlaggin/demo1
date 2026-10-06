package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.PropertyManager;
import za.ac.cput.service.PropertyManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/property-managers")
public class PropertyManagerController {

    private final PropertyManagerService service;

    @Autowired
    public PropertyManagerController(PropertyManagerService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<PropertyManager> create(@RequestBody PropertyManager propertyManager) {
        PropertyManager created = service.save(propertyManager);
        if (created == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<PropertyManager> read(@PathVariable("id") String id) {
        PropertyManager manager = service.read(id);
        if (manager == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(manager);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PropertyManager>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}