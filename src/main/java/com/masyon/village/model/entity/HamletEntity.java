package com.masyon.village.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hamlet")
public class HamletEntity {

    @Id
    @GeneratedValue(generator = "hml-generator")
    @GenericGenerator(name = "hml-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "HML"),
            strategy = "com.masyon.village.identifier.MyGenerator"
    )
    @Column(name = "id_hamlet")
    private String idHamlet;

    @Column(name = "head_hamlet")
    private String headOfHamlet;

    @Column(name = "area_hamlet")
    private Integer areaHamlet;
}
