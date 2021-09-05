package com.masyon.village.repository;

import com.masyon.village.model.entity.CitizenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepo extends JpaRepository<CitizenEntity, String> {
}
