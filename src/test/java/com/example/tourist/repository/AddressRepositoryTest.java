package com.example.tourist.repository;

import com.example.tourist.AbstractTestContainer;
import com.example.tourist.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Интеграционные тесты для репозитория адресов.
 */
public class AddressRepositoryTest extends AbstractTestContainer {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testSaveAndFind() {
        Address address = new Address();
        address.setCity("Москва");
        address.setStreet("Тверская");
        addressRepository.save(address);

        List<Address> addresses = addressRepository.findByCity("Москва");
        assertThat(addresses).isNotEmpty();
        assertThat(addresses.get(0).getStreet()).isEqualTo("Тверская");
    }
}
