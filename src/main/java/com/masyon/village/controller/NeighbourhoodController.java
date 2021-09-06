package com.masyon.village.controller;

import com.masyon.village.exception.ResourceNotFoundException;
import com.masyon.village.model.dto.NeighbourHDto;
import com.masyon.village.model.dto.HamletDto;
import com.masyon.village.model.dto.NeighbourHDto;
import com.masyon.village.model.entity.NeighbourHEntity;
import com.masyon.village.model.entity.HamletEntity;
import com.masyon.village.model.entity.NeighbourHEntity;
import com.masyon.village.service.NeighbourhoodService;
import com.masyon.village.service.NeighbourhoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //get Neighbourhood by id
    @GetMapping("/{id}")
    public NeighbourHDto showNeighbourhoodById(@PathVariable(value = "id")String NeighbourhoodId) throws ResourceNotFoundException {
        NeighbourHEntity neighbourhoodById = neighbourhoodService.getNeighbourhoodById(NeighbourhoodId);
        NeighbourHDto neighbourHDto = convertToDto(neighbourhoodById);
        return neighbourHDto;
    }
    //add Neighbourhood
    @PostMapping
    public NeighbourHDto insertNeighbourhood(@RequestBody NeighbourHDto NeighbourHDto){
        NeighbourHEntity neighbourHEntity = convertToEntity(NeighbourHDto);
        NeighbourHEntity neighbourhood = neighbourhoodService.saveNeighbourhood(neighbourHEntity);
        return convertToDto(neighbourhood);
    }
    //delete Neighbourhood
    @DeleteMapping("/{id}")
    public List<NeighbourHDto> deleteNeighbourhood(@PathVariable(value = "id")String NeighbourhoodId) throws ResourceNotFoundException {
        List<NeighbourHEntity> neighbourHEntities = neighbourhoodService.delNeighbourhood(NeighbourhoodId);
        List<NeighbourHDto> neighbourHDtos = neighbourHEntities.stream().map(this::convertToDto).collect(Collectors.toList());
        return neighbourHDtos;
    }
    //update Neighbourhood
    @PutMapping("/{id}")
    public NeighbourHDto updateNeighbourhood(@PathVariable(value = "id")String NeighbourhoodId, @RequestBody NeighbourHDto NeighbourHDto) throws ResourceNotFoundException {
        NeighbourHEntity neighbourHEntity = convertToEntity(NeighbourHDto);
        NeighbourHEntity updateNeighbourhood = neighbourhoodService.updateNeighbourhood(NeighbourhoodId, neighbourHEntity);
        return convertToDto(updateNeighbourhood);
    }


}
