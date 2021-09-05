package com.masyon.village.service;

import com.masyon.village.model.entity.CitizenEntity;
import com.masyon.village.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CitizenServiceImpl implements CitizenService{

    @Autowired
    public CitizenRepo citizenRepo;

    @Override
    public List<CitizenEntity> getAllCitizen() {
        List<CitizenEntity> citizenEntities = new ArrayList<>();
        citizenRepo.findAll().forEach(citizenEntities::add);
        return citizenEntities;
    }
}
