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
    private Set<UUID> providerIds;

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

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public UUID getTicketInfoId() {
        return ticketInfoId;
    }

    public void setTicketInfoId(UUID ticketInfoId) {
        this.ticketInfoId = ticketInfoId;
    }

    public Set<UUID> getProviderIds() {
        return providerIds;
    }

    public void setProviderIds(Set<UUID> providerIds) {
        this.providerIds = providerIds;
    }
}