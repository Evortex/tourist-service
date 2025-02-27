package com.example.tourist.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "attraction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attraction {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AttractionType getType() {
        return type;
    }

    public void setType(AttractionType type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public Set<Provider> getProviders() {
        return providers;
    }

    public void setProviders(Set<Provider> providers) {
        this.providers = providers;
    }

    @Enumerated(EnumType.STRING)
    private AttractionType type;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToOne(mappedBy = "attraction", cascade = CascadeType.ALL)
    private TicketInfo ticketInfo;

    @ManyToMany
    @JoinTable(
            name = "attraction_provider",
            joinColumns = @JoinColumn(name = "attraction_id"),
            inverseJoinColumns = @JoinColumn(name = "provider_id")
    )
    private Set<Provider> providers;
}