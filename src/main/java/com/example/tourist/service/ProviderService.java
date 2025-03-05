package com.example.tourist.service;

import com.example.tourist.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с поставщиками услуг.
 * Этот интерфейс определяет методы для получения, создания, обновления и удаления данных о поставщиках.
 * Поставщики услуг могут быть связаны с различными объектами, такими как достопримечательности и билеты.
 */
public interface ProviderService {

     List<Provider> getAllProviders();

     Provider getProviderById(UUID id);

     Provider saveProvider(Provider provider);

     void deleteProvider(UUID id);
}
