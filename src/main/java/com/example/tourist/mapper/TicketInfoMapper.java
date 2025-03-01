package com.example.tourist.mapper;

import com.example.tourist.dto.TicketInfoDto;
import com.example.tourist.model.TicketInfo;
import org.springframework.stereotype.Component;

/**
 * Класс для преобразования между объектами {@link TicketInfo} и {@link TicketInfoDto}.
 * Используется для преобразования данных между слоями модели и DTO.
 */
@Component
public class TicketInfoMapper {

    /**
     * Преобразует объект {@link TicketInfo} в объект {@link TicketInfoDto}.
     *
     * @param ticketInfo объект модели, который необходимо преобразовать.
     * @return объект типа {@link TicketInfoDto}, содержащий данные из объекта {@link TicketInfo}.
     */
    public static TicketInfoDto toDto(TicketInfo ticketInfo) {
        TicketInfoDto dto = new TicketInfoDto();
        dto.setId(ticketInfo.getId());
        dto.setPrice(ticketInfo.getPrice());
        dto.setCurrency(ticketInfo.getCurrency());
        dto.setAvailability(ticketInfo.getAvailability());
        dto.setAttractionId(ticketInfo.getAttraction().getId());
        return dto;
    }

    /**
     * Преобразует объект {@link TicketInfoDto} в объект {@link TicketInfo}.
     *
     * @param dto объект типа {@link TicketInfoDto}, который необходимо преобразовать.
     * @return объект модели {@link TicketInfo}, содержащий данные из объекта {@link TicketInfoDto}.
     */
    public static TicketInfo toEntity(TicketInfoDto dto) {
        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setId(dto.getId());
        ticketInfo.setPrice(dto.getPrice());
        ticketInfo.setCurrency(dto.getCurrency());
        ticketInfo.setAvailability(dto.getAvailability());
        return ticketInfo;
    }
}
