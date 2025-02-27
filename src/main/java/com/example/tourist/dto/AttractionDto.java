package com.example.tourist.dto;

import com.example.tourist.model.AttractionType;
import lombok.Data;
import java.util.UUID;
import java.util.Set;

@Data
public class AttractionDto {
    private UUID id;
    private String name;
    private String description;
    private AttractionType type;
    private UUID addressId;
    private UUID ticketInfoId;
    private Set<UUID> providerIds; // Список связанных поставщиков услуг
}