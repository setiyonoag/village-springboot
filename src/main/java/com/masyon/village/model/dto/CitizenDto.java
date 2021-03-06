package com.masyon.village.model.dto;

import com.masyon.village.model.entity.NeighbourHEntity;
import lombok.Data;

@Data
public class CitizenDto {


    private String idCitizen;
    private String headOfFamily;
    private Integer familyMember;
    private String idHamlet;
    private String idNeighbourhood;
    private NeighbourHEntity neighbourHEntity;
}
