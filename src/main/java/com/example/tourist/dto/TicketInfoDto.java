package com.example.tourist.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TicketInfoDto {
    private UUID id;
    private BigDecimal price;
    private String currency;
    private Boolean availability;
    private UUID attractionId;
}