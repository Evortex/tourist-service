package com.example.tourist.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "ticket_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketInfo {
    @Id
    @GeneratedValue
    private UUID id;

    private BigDecimal price;
    private String currency;
    private Boolean availability;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    @OneToOne
    @JoinColumn(name = "attraction_id", nullable = false)
    private Attraction attraction;
}
