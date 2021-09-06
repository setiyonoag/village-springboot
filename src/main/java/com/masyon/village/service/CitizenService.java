package com.masyon.village.service;

import com.masyon.village.exception.ResourceNotFoundException;
import com.masyon.village.model.entity.CitizenEntity;
import com.masyon.village.model.entity.CitizenEntity;

import java.util.List;

public interface CitizenService {

    List<CitizenEntity> getAllCitizen();
    List<CitizenEntity> delCitizen(String id) throws ResourceNotFoundException;
    CitizenEntity saveCitizen(CitizenEntity citizenEntity);
    CitizenEntity getCitizenById(String id) throws ResourceNotFoundException;
    CitizenEntity updateCitizen(String id, CitizenEntity citizenEntity) throws ResourceNotFoundException;
    Object countCitizenByHamlet(String idHamlet);
    Object countCitizenByNeighbourhood(String id);
}
