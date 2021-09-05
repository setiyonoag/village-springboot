package com.masyon.village.model.dto;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
public class NeighbourHDto {

    private String idNeighbourHood;
    private String headOfNeighbourHood;
    private Integer areaNeighbourHood;
    private String idHamlet;
}
