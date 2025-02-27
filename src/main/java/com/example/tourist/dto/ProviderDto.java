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
}