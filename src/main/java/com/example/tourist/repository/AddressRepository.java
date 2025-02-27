package com.example.tourist.repository;


import com.example.tourist.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;
@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    List<Address> findByCityContainingIgnoreCase(String city);
    List<Address> findByRegionContainingIgnoreCase(String region);
}