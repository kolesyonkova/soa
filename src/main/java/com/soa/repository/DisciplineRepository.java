package com.soa.repository;

import java.util.List;

import com.soa.entity.DisciplineEntity;
import com.soa.entity.LabWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DisciplineRepository extends JpaRepository<DisciplineEntity, Integer> {

    @Query(value = "select * from discipline d " +
            "where d.discipline_name like concat('%', :name, '%') " +
            "limit :limit",
            nativeQuery = true)
    List<DisciplineEntity> suggest(@Param("name") String name, @Param("limit") int limit);
}
