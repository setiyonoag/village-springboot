package com.masyon.village.service;

import com.masyon.village.exception.ResourceNotFoundException;
import com.masyon.village.model.entity.HamletEntity;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import java.util.List;

public interface HamletService {

    List<HamletEntity> getAllHamlet();
    List<HamletEntity> delHamlet(String id) throws ResourceNotFoundException;
    HamletEntity saveHamlet(HamletEntity hamletEntity);
    HamletEntity getHamletById(String id) throws ResourceNotFoundException;
    HamletEntity updateHamlet(String id, HamletEntity hamletEntity) throws ResourceNotFoundException;

}
