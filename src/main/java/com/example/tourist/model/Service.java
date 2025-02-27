package com.example.tourist.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
import java.util.Set;


@Entity
@Table(name = "service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ServiceType type;

    @ManyToMany(mappedBy = "services")
    private Set<Attraction> attractions;
}

