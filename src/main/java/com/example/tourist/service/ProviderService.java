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

     /**
      * Получить список всех поставщиков услуг.
      *
      * @return список всех {@link Provider}
      */
     List<Provider> getAllProviders();

     /**
      * Получить информацию о поставщике по его уникальному идентификатору.
      *
      * @param id уникальный идентификатор поставщика
      * @return объект {@link Provider}, содержащий данные о поставщике
      */
     Provider getProviderById(UUID id);

     /**
      * Сохранить новый или обновить существующий поставщик.
      *
      * @param provider объект {@link Provider}, содержащий информацию о поставщике
      * @return объект {@link Provider}, сохраненный в базе данных
      */
     Provider saveProvider(Provider provider);

     /**
      * Удалить поставщика по его уникальному идентификатору.
      *
      * @param id уникальный идентификатор поставщика
      */
     void deleteProvider(UUID id);
}
