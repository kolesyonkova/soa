package com.soa.repository;

import com.soa.dto.FilterQueryDto;
import com.soa.entity.LabWorkEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabWorkRepository extends JpaRepository<LabWorkEntity, Integer> {
    @Query("select sum(l.minimalPoint) from LabWorkEntity l")
    Integer getSumOfMinimalPoint();

    @Query("select count (l.id) from LabWorkEntity l group by l.coordinates.x, l.coordinates.y")
    List<Integer> getGroupedByCoordinates();

    @Query("select distinct l.minimalPoint from LabWorkEntity l")
    List<Integer> getDistinctByMinimalPoint();

    @Query("select l from LabWorkEntity l where "
            + "((:#{#dto.name}) is null or l.name in (:#{#dto.name}))"
            + "and ((:#{#dto.id}) is null or l.id in (:#{#dto.id}))"
            + "and ((:#{#dto.minimalPoint}) is null or l.minimalPoint in (:#{#dto.minimalPoint}))"
            + "and ((:#{#dto.difficulties}) is null or l.difficulty in (:#{#dto.difficulties}))"
    )
    List<LabWorkEntity> getLabWorksWithFiltering(@Param("dto") FilterQueryDto dto, Pageable pageable);
}
