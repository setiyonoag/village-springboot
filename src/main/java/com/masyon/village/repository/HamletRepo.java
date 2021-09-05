package com.masyon.village.repository;

import com.masyon.village.model.entity.HamletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamletRepo extends JpaRepository<HamletEntity, String> {
}
