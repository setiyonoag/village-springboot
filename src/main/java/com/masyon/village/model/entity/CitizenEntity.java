package com.masyon.village.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Citizen")
public class CitizenEntity {

    @Id
    @GeneratedValue(generator = "ctz-generator")
    @GenericGenerator(name = "ctz-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "ctz"),
            strategy = "com.masyon.village.identifier.MyGenerator"
    )
    @Column(name = "id_citizen")
    private String idCitizen;

    @Column(name = "head_of_family")
    private String headOfFamily;

    @Column(name = "family_member")
    private Integer familyMember;

    @ManyToOne
    @JoinColumn(
            name = "id_hamlet",
            referencedColumnName = "id_hamlet",
            insertable = false,
            updatable = false
    )
    private HamletEntity hamletEntity;

    @ManyToOne
    @JoinColumn(
            name = "id_neighbourhood",
            referencedColumnName = "id_neighbourhood",
            insertable = false,
            updatable = false
    )
    private NeighbourHEntity neighbourHEntity;
}
