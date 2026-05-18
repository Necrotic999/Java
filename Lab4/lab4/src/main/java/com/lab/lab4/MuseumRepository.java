package com.lab.lab4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "museums", path = "museums")
@CrossOrigin(origins = "*")
public interface MuseumRepository extends JpaRepository<Museum, Long> {
}