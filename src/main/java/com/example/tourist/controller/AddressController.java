package com.example.tourist.controller;

import com.example.tourist.dto.AddressDto;
import com.example.tourist.mapper.AddressMapper;
import com.example.tourist.model.Address;
import com.example.tourist.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с адресами.
 * Предоставляет API для получения, создания, удаления и поиска адресов.
 */
@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
@Tag(name = "Адреса", description = "API для управления адресами")
public class AddressController {

    private final AddressService addressService;

    /**
     * Получает список всех адресов.
     *
     * @return Список объектов {@link AddressDto}, представляющих все адреса.
     */
    @Operation(summary = "Получить все адреса", description = "Возвращает список всех доступных адресов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно получен список адресов")
    })
    @GetMapping
    public List<AddressDto> getAllAddresses() {
        return addressService.getAllAddresses().stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Получает адрес по уникальному идентификатору.
     *
     * @param id UUID уникальный идентификатор адреса.
     * @return Ответ с объектом {@link AddressDto}, представляющим адрес.
     */
    @Operation(summary = "Получить адрес по ID", description = "Возвращает адрес по его уникальному идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Адрес найден"),
            @ApiResponse(responseCode = "404", description = "Адрес не найден")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable UUID id) {
        return ResponseEntity.ok(AddressMapper.toDto(addressService.getAddressById(id)));
    }

    /**
     * Создает новый адрес.
     *
     * @param addressDto Объект {@link AddressDto}, содержащий данные для создания адреса.
     * @return Объект {@link AddressDto}, представляющий созданный адрес.
     */
    @Operation(summary = "Создать новый адрес", description = "Добавляет новый адрес в систему")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Адрес успешно создан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные")
    })
    @PostMapping
    public AddressDto createAddress(@RequestBody AddressDto addressDto) {
        Address address = AddressMapper.toEntity(addressDto);
        return AddressMapper.toDto(addressService.saveAddress(address));
    }

    /**
     * Удаляет адрес по уникальному идентификатору.
     *
     * @param id UUID уникальный идентификатор адреса, который нужно удалить.
     */
    @Operation(summary = "Удалить адрес", description = "Удаляет адрес по его уникальному идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Адрес успешно удален"),
            @ApiResponse(responseCode = "404", description = "Адрес не найден")
    })
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
    }

    /**
     * Ищет адреса по названию города.
     *
     * @param city Название города для поиска.
     * @return Список объектов {@link AddressDto}, представляющих адреса, найденные по городу.
     */
    @Operation(summary = "Поиск адресов по городу", description = "Находит все адреса в указанном городе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список адресов найден"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос")
    })
    @GetMapping("/search/city")
    public List<AddressDto> searchByCity(@RequestParam String city) {
        return addressService.searchByCity(city).stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Ищет адреса по названию региона.
     *
     * @param region Название региона для поиска.
     * @return Список объектов {@link AddressDto}, представляющих адреса, найденные по региону.
     */
    @Operation(summary = "Поиск адресов по региону", description = "Находит все адреса в указанном регионе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список адресов найден"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос")
    })
    @GetMapping("/search/region")
    public List<AddressDto> searchByRegion(@RequestParam String region) {
        return addressService.searchByRegion(region).stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }
}
