package com.masyon.village.controller;

import com.masyon.village.exception.ResourceNotFoundException;
import com.masyon.village.model.dto.HamletDto;
import com.masyon.village.model.entity.HamletEntity;
import com.masyon.village.service.HamletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/hamlet")
public class HamletController {

    @Autowired
    public HamletService hamletService;

    @Autowired
    ModelMapper mapper;

    private HamletDto convertToDto(HamletEntity hamletEntity){
        HamletDto hamletDto = mapper.map(hamletEntity, HamletDto.class);
        return hamletDto;
    }

    private HamletEntity convertToEntity(HamletDto hamletDto){
        HamletEntity hamletEntity = mapper.map(hamletDto, HamletEntity.class);
        return hamletEntity;
    }

    //get all hamlet
    @GetMapping()
    public List<HamletDto> showAllHamlet() {
        List<HamletEntity> hamletEntities = hamletService.getAllHamlet();
        List<HamletDto> hamletDtos = hamletEntities.stream().map(this::convertToDto).collect(Collectors.toList());
        return hamletDtos;
    }
    //get hamlet by id
    @GetMapping("/{id}")
    public HamletDto showHamletById(@PathVariable(value = "id")String hamletId) throws ResourceNotFoundException {
        HamletEntity hamletEntity = hamletService.getHamletById(hamletId);
        HamletDto hamletDto = convertToDto(hamletEntity);
        return hamletDto;
    }
    //add hamlet
    @PostMapping
    public HamletDto insertHamlet(@RequestBody HamletDto hamletDto){
        HamletEntity hamletEntity = convertToEntity(hamletDto);
        HamletEntity hamlet = hamletService.saveHamlet(hamletEntity);
        return convertToDto(hamlet);
    }
    //delete hamlet
    @DeleteMapping("/{id}")
    public List<HamletDto> deleteHamlet(@PathVariable(value = "id")String hamletId) throws ResourceNotFoundException {
        List<HamletEntity> hamletEntities = hamletService.delHamlet(hamletId);
        List<HamletDto> hamletDtos = hamletEntities.stream().map(this::convertToDto).collect(Collectors.toList());
        return hamletDtos;
    }
    //update hamlet
    @PutMapping("/{id}")
    public HamletDto updateHamlet(@PathVariable(value = "id")String hamletId, @RequestBody HamletDto hamletDto) throws ResourceNotFoundException {
        HamletEntity hamletEntity = convertToEntity(hamletDto);
        HamletEntity hamletUpdated = hamletService.updateHamlet(hamletId, hamletEntity);
        return convertToDto(hamletUpdated);
    }
}
