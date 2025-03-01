package com.example.tourist.service;

import com.example.tourist.model.Provider;

import java.util.List;
import java.util.UUID;


public interface ProviderService{

     List<Provider> getAllProviders();

     Provider getProviderById(UUID id);

     Provider saveProvider(Provider provider);

     void deleteProvider(UUID id);
}

