package com.lab.lab4;

import com.lab.lab4.Museum;
import com.lab.lab4.MuseumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/museums")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class MuseumController {

    private final MuseumService service;

    @GetMapping
    public List<Museum> getAll() {
        return service.getAllMuseums();
    }

    @GetMapping("/{id}")
    public Museum getById(@PathVariable Long id) {
        return service.getMuseumById(id);
    }

    @PostMapping
    public ResponseEntity<Museum> create(@RequestBody Museum museum) {
        Museum saved = service.saveMuseum(museum);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public Museum update(@PathVariable Long id, @RequestBody Museum museum) {
        return service.updateMuseum(id, museum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteMuseum(id);
        return ResponseEntity.noContent().build();
    }
}