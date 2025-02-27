package com.example.tourist.mapper;

import com.example.tourist.dto.TicketInfoDto;
import com.example.tourist.model.TicketInfo;
import org.springframework.stereotype.Component;

@Component
public class TicketInfoMapper {
    public static TicketInfoDto toDto(TicketInfo ticketInfo) {
        TicketInfoDto dto = new TicketInfoDto();
        dto.setId(ticketInfo.getId());
        dto.setPrice(ticketInfo.getPrice());
        dto.setCurrency(ticketInfo.getCurrency());
        dto.setAvailability(ticketInfo.getAvailability());
        dto.setAttractionId(ticketInfo.getAttraction().getId());
        return dto;
    }

    public static TicketInfo toEntity(TicketInfoDto dto) {
        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setId(dto.getId());
        ticketInfo.setPrice(dto.getPrice());
        ticketInfo.setCurrency(dto.getCurrency());
        ticketInfo.setAvailability(dto.getAvailability());
        return ticketInfo;
    }
}