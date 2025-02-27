package com.example.tourist.repository;

import com.example.tourist.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, UUID> {
    List<Attraction> findByAddress_CityContainingIgnoreCase(String city);
}

