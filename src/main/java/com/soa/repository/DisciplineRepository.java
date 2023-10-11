package com.soa.repository;

import com.soa.entity.DisciplineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<DisciplineEntity, Integer> {
}
