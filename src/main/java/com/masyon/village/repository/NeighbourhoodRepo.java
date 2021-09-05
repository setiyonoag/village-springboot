package com.masyon.village.repository;

import com.masyon.village.model.entity.NeighbourHEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NeighbourhoodRepo extends JpaRepository<NeighbourHEntity, String> {
}
