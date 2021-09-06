package com.masyon.village.service;

import com.masyon.village.exception.ResourceNotFoundException;
import com.masyon.village.model.entity.HamletEntity;
import com.masyon.village.repository.HamletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HamletServiceImpl implements HamletService{

    @Autowired
    public HamletRepo hamletRepo;

    //------------------------- Service Hamlet ----------------------------
    //get all hamlet
    @Override
    public List<HamletEntity> getAllHamlet() {
        List<HamletEntity> hamletEntities = new ArrayList<>();
        hamletRepo.findAll().forEach(hamletEntities::add);
        return hamletEntities;
    }
    //delete hamlet by id
    @Override
    public List<HamletEntity> delHamlet(String id) throws ResourceNotFoundException {
        hamletRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hamlet not found for this id = "+id));
        hamletRepo.deleteById(id);
        List<HamletEntity> hamletEntities = new ArrayList<>();
        hamletRepo.findAll().forEach(hamletEntities::add);
        return hamletEntities;
    }
    //create hamlet
    @Override
    public HamletEntity saveHamlet(HamletEntity hamletEntity) {
        return hamletRepo.save(hamletEntity);
    }
    //get hamlet by id
    @Override
    public HamletEntity getHamletById(String id) throws ResourceNotFoundException {
        hamletRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hamlet not found for this id = "+id));
        HamletEntity hamletEntity = hamletRepo.getById(id);
        return hamletEntity;
    }
    //update hamlet by id
    @Override
    public HamletEntity updateHamlet(String id, HamletEntity hamletEntity) throws ResourceNotFoundException {
        HamletEntity hamlet = hamletRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hamlet not found for this id = "+id));
        hamlet.setHeadOfHamlet(hamletEntity.getHeadOfHamlet());
        hamlet.setAreaHamlet(hamletEntity.getAreaHamlet());
        final HamletEntity updatedHamlet = hamletRepo.save(hamlet);
        return updatedHamlet;
    }


}
