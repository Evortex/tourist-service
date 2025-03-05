package com.example.tourist.service;

import com.example.tourist.AbstractTestContainer;
import com.example.tourist.exception.AddressNotFoundException;
import com.example.tourist.model.Address;
import com.example.tourist.service.impl.AddressServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Интеграционные тесты для сервиса работы с адресами.
 */
public class AddressServiceImplTest extends AbstractTestContainer {

    @Autowired
    private AddressServiceImpl addressService;

    @Test
    public void testSaveAndFind() {
        Address address = new Address();
        address.setCity("Санкт-Петербург");
        address.setStreet("Невский проспект");
        Address savedAddress = addressService.saveAddress(address);

        Address foundAddress = addressService.getAddressById(savedAddress.getId());
        assertThat(foundAddress).isNotNull();
        assertThat(foundAddress.getCity()).isEqualTo("Санкт-Петербург");
    }

    @Test
    public void testAddressNotFound() {
        UUID fakeId = UUID.randomUUID();
        assertThrows(AddressNotFoundException.class, () -> addressService.getAddressById(fakeId));
    }
}
