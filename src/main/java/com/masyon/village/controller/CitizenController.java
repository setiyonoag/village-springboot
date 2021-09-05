package com.masyon.village.controller;

import com.masyon.village.model.dto.CitizenDto;
import com.masyon.village.model.entity.CitizenEntity;
import com.masyon.village.service.CitizenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/citizen")
public class CitizenController {

    @Autowired
    public CitizenService citizenService;

    @Autowired
    ModelMapper mapper;

    private CitizenDto convertToDto(CitizenEntity citizenEntity){
        CitizenDto CitizenDto = mapper.map(citizenEntity, CitizenDto.class);
        return CitizenDto;
    }

    private CitizenEntity convertToEntity(CitizenDto citizenDto){
        CitizenEntity CitizenEntity = mapper.map(citizenDto, CitizenEntity.class);
        return CitizenEntity;
    }

    @GetMapping()
    public List<CitizenDto> showAllCitizen() {
        List<CitizenEntity> citizenEntities = citizenService.getAllCitizen();
        List<CitizenDto> citizenDtos = citizenEntities.stream().map(this::convertToDto).collect(Collectors.toList());
        return citizenDtos;
    }

    //get citizen by id
    //add citizen
    //delete citizen
    //update citizen
}
