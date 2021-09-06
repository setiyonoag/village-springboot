package com.masyon.village.service;

import com.masyon.village.exception.ResourceNotFoundException;
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
    //------------------------- Service Neighbourhood ----------------------------
    //get all Neighbourhood
    @Override
    public List<NeighbourHEntity> getAllNeighbourhood() {
        List<NeighbourHEntity> neighbourHEntities = new ArrayList<>();
        neighbourhoodRepo.findAll().forEach(neighbourHEntities::add);
        return neighbourHEntities;
    }
    //delete NeighbourH by id
    @Override
    public List<NeighbourHEntity> delNeighbourhood(String id) throws ResourceNotFoundException {
        neighbourhoodRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("NeighbourH not found for this id = "+id));
        neighbourhoodRepo.deleteById(id);
        List<NeighbourHEntity> neighbourHEntities = new ArrayList<>();
        neighbourhoodRepo.findAll().forEach(neighbourHEntities::add);
        return neighbourHEntities;
    }
    //create NeighbourH
    @Override
    public NeighbourHEntity saveNeighbourhood(NeighbourHEntity NeighbourHEntity) {
        return neighbourhoodRepo.save(NeighbourHEntity);
    }
    //get NeighbourH by id
    @Override
    public NeighbourHEntity getNeighbourhoodById(String id) throws ResourceNotFoundException {
        neighbourhoodRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("NeighbourH not found for this id = "+id));
        NeighbourHEntity neighbourHEntity = neighbourhoodRepo.getById(id);
        return neighbourHEntity;
    }
    //update NeighbourH by id
    @Override
    public NeighbourHEntity updateNeighbourhood(String id, NeighbourHEntity neighbourHEntity) throws ResourceNotFoundException {
        NeighbourHEntity NeighbourH = neighbourhoodRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("NeighbourH not found for this id = "+id));
        NeighbourH.setHeadOfNeighbourHood(neighbourHEntity.getHeadOfNeighbourHood());
        NeighbourH.setAreaNeighbourHood(neighbourHEntity.getAreaNeighbourHood());
        NeighbourH.setIdHamlet(neighbourHEntity.getIdHamlet());
        final NeighbourHEntity updatedNeighbourH = neighbourhoodRepo.save(NeighbourH);
        return updatedNeighbourH;
    }
    //count neighbourhood by id hamlet
    @Override
    public Object countNeighbourhoodByHamlet(String idHamlet) {
        Object count = neighbourhoodRepo.countNeighbourhoodByHamlet(idHamlet);
        return count;
    }
}
