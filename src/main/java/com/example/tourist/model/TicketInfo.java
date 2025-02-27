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

    @OneToOne
    @JoinColumn(name = "attraction_id", nullable = false)
    private Attraction attraction;
}
