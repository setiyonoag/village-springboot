package com.masyon.village.service;

import com.masyon.village.model.entity.NeighbourHEntity;
import com.masyon.village.repository.NeighbourhoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NeighbourhoodServiceImpl implements NeighbourhoodService{

    @Autowired
    public NeighbourhoodRepo neighbourhoodRepo;

    @Override
    public List<NeighbourHEntity> getAllNeighbourhood() {
        List<NeighbourHEntity> neighbourHEntities = new ArrayList<>();
        neighbourhoodRepo.findAll().forEach(neighbourHEntities::add);
        return neighbourHEntities;
    }
}
