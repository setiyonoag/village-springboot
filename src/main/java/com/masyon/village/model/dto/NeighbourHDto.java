package com.masyon.village.model.dto;

import com.masyon.village.model.entity.HamletEntity;
import lombok.Data;

@Data
public class NeighbourHDto {

    private String idNeighbourHood;
    private String headOfNeighbourHood;
    private Integer areaNeighbourHood;
    private String idHamlet;
    private HamletEntity hamletEntity;
}
