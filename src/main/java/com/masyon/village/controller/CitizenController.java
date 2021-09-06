package com.masyon.village.controller;

import com.masyon.village.exception.ResourceNotFoundException;
import com.masyon.village.model.dto.CitizenDto;
import com.masyon.village.model.dto.CitizenDto;
import com.masyon.village.model.entity.CitizenEntity;
import com.masyon.village.model.entity.CitizenEntity;
import com.masyon.village.service.CitizenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //get all Citizen
    @GetMapping()
    public List<CitizenDto> showAllCitizen() {
        List<CitizenEntity> citizenEntities = citizenService.getAllCitizen();
        List<CitizenDto> citizenDtos = citizenEntities.stream().map(this::convertToDto).collect(Collectors.toList());
        return citizenDtos;
    }

    //get Citizen by id
    @GetMapping("/{id}")
    public CitizenDto showCitizenById(@PathVariable(value = "id")String CitizenId) throws ResourceNotFoundException {
        CitizenEntity citizenEntity = citizenService.getCitizenById(CitizenId);
        CitizenDto citizenDto = convertToDto(citizenEntity);
        return citizenDto;
    }
    //add Citizen
    @PostMapping
    public CitizenDto insertCitizen(@RequestBody CitizenDto CitizenDto){
        CitizenEntity citizenEntity = convertToEntity(CitizenDto);
        CitizenEntity citizen = citizenService.saveCitizen(citizenEntity);
        return convertToDto(citizen);
    }
    //delete Citizen
    @DeleteMapping("/{id}")
    public List<CitizenDto> deleteCitizen(@PathVariable(value = "id")String CitizenId) throws ResourceNotFoundException {
        List<CitizenEntity> citizenEntities = citizenService.delCitizen(CitizenId);
        List<CitizenDto> citizenDtos = citizenEntities.stream().map(this::convertToDto).collect(Collectors.toList());
        return citizenDtos;
    }
    //update Citizen
    @PutMapping("/{id}")
    public CitizenDto updateCitizen(@PathVariable(value = "id")String CitizenId, @RequestBody CitizenDto CitizenDto) throws ResourceNotFoundException {
        CitizenEntity citizenEntity = convertToEntity(CitizenDto);
        CitizenEntity citizenUpdated = citizenService.updateCitizen(CitizenId, citizenEntity);
        return convertToDto(citizenUpdated);
    }
    //count citizen by hamlet
    @GetMapping("hml/{id}")
    public Object countCitizenByHamlet(@PathVariable(value = "id") String id) {
        return citizenService.countCitizenByHamlet(id);
    }
    //count citizen by hamlet
    @GetMapping("nbh/{id}")
    public Object countCitizenByNeighbourhood(@PathVariable(value = "id") String id) {
        return citizenService.countCitizenByNeighbourhood(id);
    }
}
