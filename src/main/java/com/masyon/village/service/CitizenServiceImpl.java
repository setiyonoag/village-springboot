package com.masyon.village.service;

import com.masyon.village.exception.ResourceNotFoundException;
import com.masyon.village.model.entity.CitizenEntity;
import com.masyon.village.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    public CitizenRepo citizenRepo;
    //------------------------- Service Citizen ----------------------------
    //get all Citizen
    @Override
    public List<CitizenEntity> getAllCitizen() {
        List<CitizenEntity> citizenEntities = new ArrayList<>();
        citizenRepo.findAll().forEach(citizenEntities::add);
        return citizenEntities;
    }
    //delete Citizen by id
    @Override
    public List<CitizenEntity> delCitizen(String id) throws ResourceNotFoundException {
        citizenRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Citizen not found for this id = "+id));
        citizenRepo.deleteById(id);
        List<CitizenEntity> citizenEntities = new ArrayList<>();
        citizenRepo.findAll().forEach(citizenEntities::add);
        return citizenEntities;
    }
    //create Citizen
    @Override
    public CitizenEntity saveCitizen(CitizenEntity citizenEntity) {
        return citizenRepo.save(citizenEntity);
    }
    //get Citizen by id
    @Override
    public CitizenEntity getCitizenById(String id) throws ResourceNotFoundException {
        citizenRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Citizen not found for this id = "+id));
        CitizenEntity citizenEntity = citizenRepo.getById(id);
        return citizenEntity;
    }
    //update Citizen by id
    @Override
    public CitizenEntity updateCitizen(String id, CitizenEntity citizenEntity) throws ResourceNotFoundException {
        CitizenEntity citizen = citizenRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Citizen not found for this id = "+id));
        citizen.setHeadOfFamily(citizenEntity.getHeadOfFamily());
        citizen.setFamilyMember(citizenEntity.getFamilyMember());
        citizen.setIdHamlet(citizenEntity.getIdHamlet());
        citizen.setIdNeighbourHood(citizenEntity.getIdNeighbourHood());
        final CitizenEntity updatedCitizen = citizenRepo.save(citizen);
        return updatedCitizen;
    }
}
