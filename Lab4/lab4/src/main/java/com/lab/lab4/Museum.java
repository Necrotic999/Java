package com.lab.lab4;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "museums")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Museum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;                    // Назва музею

    private String city;                    // Місто

    private String country;                 // Країна

    @Column(length = 1000)
    private String description;             // Опис

    @Column(name = "image_url", length = 500)
    private String imageUrl;                // Фото музею

    @Column(name = "year_founded")
    private String yearFounded;            // Рік заснування
}