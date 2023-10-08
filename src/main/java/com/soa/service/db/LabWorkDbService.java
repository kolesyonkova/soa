package com.soa.service.db;

import com.soa.dto.FilterQueryDto;
import com.soa.entity.LabWorkEntity;
import com.soa.repository.LabWorkRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class LabWorkDbService {
    private LabWorkRepository labWorkRepository;

    @Transactional
    public LabWorkEntity save(LabWorkEntity labWorkEntity) {
        return labWorkRepository.save(labWorkEntity);
    }

    @Transactional(readOnly = true)
    public Optional<LabWorkEntity> findById(Integer id) {
        return labWorkRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Integer getSum() {
        return labWorkRepository.getSumOfMinimalPoint();
    }

    @Transactional(readOnly = true)
    public List<Integer> getGroupedByCoordinates() {
        return labWorkRepository.getGroupedByCoordinates();
    }

    @Transactional(readOnly = true)
    public List<Integer> getDistinctByMinimalPoint() {
        return labWorkRepository.getDistinctByMinimalPoint();
    }

    @Transactional(readOnly = true)
    public List<LabWorkEntity> getLabWorksWithFiltering(FilterQueryDto dto, Pageable pageable) {
        return labWorkRepository.getLabWorksWithFiltering(dto, pageable);
    }

    @Transactional
    public void deleteById(Integer id) {
        labWorkRepository.deleteById(id);
    }
}
