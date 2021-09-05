package com.masyon.village.controller;

import com.masyon.village.model.dto.HamletDto;
import com.masyon.village.model.dto.NeighbourHDto;
import com.masyon.village.model.entity.HamletEntity;
import com.masyon.village.model.entity.NeighbourHEntity;
import com.masyon.village.service.NeighbourhoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/neighbourhood")
public class NeighbourhoodController {

    @Autowired
    public NeighbourhoodService neighbourhoodService;

    @Autowired
    ModelMapper mapper;

    private NeighbourHDto convertToDto(NeighbourHEntity neighbourHEntity) {
        NeighbourHDto neighbourHDto = mapper.map(neighbourHEntity, NeighbourHDto.class);
        return neighbourHDto;
    }
    private NeighbourHEntity convertToEntity(NeighbourHDto neighbourHDto) {
        NeighbourHEntity neighbourHEntity = mapper.map(neighbourHDto, NeighbourHEntity.class);
        return neighbourHEntity;
    }

    //get all neighbourhood
    @GetMapping()
    public List<NeighbourHDto> showAllNeighbourhood() {
        List<NeighbourHEntity> neighbourHEntities = neighbourhoodService.getAllNeighbourhood();
        List<NeighbourHDto> neighbourHDtos = neighbourHEntities.stream().map(this::convertToDto).collect(Collectors.toList());
        return neighbourHDtos;
    }
    //get neighbourhood by id
    //add neighbourhood
    //delete neighbourhood
    //update neighbourhood


}
