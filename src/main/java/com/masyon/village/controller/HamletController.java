package com.masyon.village.controller;

import com.masyon.village.model.dto.HamletDto;
import com.masyon.village.model.entity.HamletEntity;
import com.masyon.village.service.HamletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //add hamlet
    //delete hamlet
    //update hamlet
}
