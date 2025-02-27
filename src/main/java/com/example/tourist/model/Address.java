package com.example.tourist.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    private Integer building;
    private String street;
    private String city;
    private String region;

    private Double longitude; // Опционально
    private Double latitude;  // Опционально

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Attraction> attractions = new ArrayList<>();
}

