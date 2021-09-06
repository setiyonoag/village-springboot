package com.masyon.village.service;

import com.masyon.village.exception.ResourceNotFoundException;
import com.masyon.village.model.entity.NeighbourHEntity;
import com.masyon.village.model.entity.NeighbourHEntity;

import java.util.List;

public interface NeighbourhoodService {

    List<NeighbourHEntity> getAllNeighbourhood();
    List<NeighbourHEntity> delNeighbourhood(String id) throws ResourceNotFoundException;
    NeighbourHEntity saveNeighbourhood(NeighbourHEntity neighbourHEntity);
    NeighbourHEntity getNeighbourhoodById(String id) throws ResourceNotFoundException;
    NeighbourHEntity updateNeighbourhood(String id, NeighbourHEntity neighbourHEntity) throws ResourceNotFoundException;

}
