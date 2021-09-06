package com.masyon.village.repository;

import com.masyon.village.model.entity.NeighbourHEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NeighbourhoodRepo extends JpaRepository<NeighbourHEntity, String> {

    @Query("SELECT COUNT(nn.headOfNeighbourHood) " +
            "FROM NeighbourHEntity AS nn " +
            "WHERE nn.idHamlet = :idHamlet")
    Object countNeighbourhoodByHamlet(String idHamlet);

}
