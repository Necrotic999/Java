package com.lab.lab4;

import com.lab.lab4.Museum;
import com.lab.lab4.MuseumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuseumService {

    private final MuseumRepository repository;

    public List<Museum> getAllMuseums() {
        return repository.findAll();
    }

    public Museum getMuseumById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Museum not found with id: " + id));
    }

    public Museum saveMuseum(Museum museum) {
        return repository.save(museum);
    }

    public Museum updateMuseum(Long id, Museum updatedMuseum) {
        Museum existing = getMuseumById(id);
        existing.setName(updatedMuseum.getName());
        existing.setCity(updatedMuseum.getCity());
        existing.setCountry(updatedMuseum.getCountry());
        existing.setDescription(updatedMuseum.getDescription());
        existing.setImageUrl(updatedMuseum.getImageUrl());
        existing.setYearFounded(updatedMuseum.getYearFounded());
        return repository.save(existing);
    }

    public void deleteMuseum(Long id) {
        repository.deleteById(id);
    }
}