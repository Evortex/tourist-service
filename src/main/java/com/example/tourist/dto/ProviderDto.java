package com.example.tourist.dto;

import com.example.tourist.model.ProviderType;
import lombok.Data;
import java.util.UUID;

@Data
public class ProviderDto {
    private UUID id;
    private String name;
    private String description;
    private ProviderType type;

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

    public ProviderType getType() {
        return type;
    }

    public void setType(ProviderType type) {
        this.type = type;
    }
}