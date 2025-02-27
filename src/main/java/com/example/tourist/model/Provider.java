package com.example.tourist.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "provider")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ProviderType type;

    @ManyToMany(mappedBy = "providers")
    private Set<Attraction> attractions;
}
