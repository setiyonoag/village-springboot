package com.masyon.village.service;

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

    @Override
    public List<HamletEntity> getAllHamlet() {
        List<HamletEntity> hamletEntities = new ArrayList<>();
        hamletRepo.findAll().forEach(hamletEntities::add);
        return hamletEntities;

    }
}
