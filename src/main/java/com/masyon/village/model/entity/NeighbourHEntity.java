package com.masyon.village.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "neighbourhood")
public class NeighbourHEntity {

    @Id
    @GeneratedValue(generator = "nbh-generator")
    @GenericGenerator(name = "nbh-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "NBH"),
            strategy = "com.masyon.village.identifier.MyGenerator"
    )
    @Column(name = "id_neighbourhood")
    private String idNeighbourHood;

    @Column(name = "head_neighbourhood")
    private String headOfNeighbourHood;

    @Column(name = "area_neighbourhood")
    private Integer areaNeighbourHood;

    @ManyToOne
    @JoinColumn(
            name = "id_hamlet",
            referencedColumnName = "id_hamlet",
            insertable = false,
            updatable = false
    )
    private HamletEntity hamletEntity;
}
