package com.lab.lab4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/museums")
@CrossOrigin(origins = "*")
public class MuseumController {

    @Autowired
    private MuseumRepository museumRepository;

    @GetMapping
    public List<Museum> getAllMuseums() {
        log.info("Отримання списку всіх музеїв з бази даних");
        return museumRepository.findAll();
    }

    @PostMapping
    public Museum createMuseum(@RequestBody Museum museum) {
        log.info("Додавання нового музею: {}", museum.getName());
        return museumRepository.save(museum);
    }

    @PutMapping("/{id}")
    public Museum updateMuseum(@PathVariable Long id, @RequestBody Museum museumDetails) {
        log.info("Оновлення інформації про музей з ID: {}", id);
        Museum museum = museumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Museum not found with id: " + id));

        museum.setName(museumDetails.getName());
        museum.setCity(museumDetails.getCity());
        museum.setCountry(museumDetails.getCountry());
        museum.setDescription(museumDetails.getDescription());
        museum.setImageUrl(museumDetails.getImageUrl());
        museum.setYearFounded(museumDetails.getYearFounded());

        return museumRepository.save(museum);
    }

    @DeleteMapping("/{id}")
    public void deleteMuseum(@PathVariable Long id) {
        log.info("Видалення музею з ID: {}", id);
        museumRepository.deleteById(id);
    }
}