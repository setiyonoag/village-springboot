package com.masyon.village.repository;

import com.masyon.village.model.entity.CitizenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CitizenRepo extends JpaRepository<CitizenEntity, String> {

    @Query ("SELECT COUNT(cc.headOfFamily) " +
            "FROM CitizenEntity AS cc " +
            "WHERE cc.idHamlet = :idHamlet")
    Object countCitizenByHamlet(String idHamlet);

    @Query ("SELECT COUNT(cc.headOfFamily) " +
            "FROM CitizenEntity AS cc " +
            "WHERE cc.idNeighbourhood = :id")
    Object countCitizenByNeighbourhood(String id);
}
