package com.lab.lab4;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // "user" в Postgres — зарезервоване слово, тому тільки "users"!
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role;
}