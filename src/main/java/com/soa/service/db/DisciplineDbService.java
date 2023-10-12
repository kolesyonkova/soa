package com.soa.service.db;

import java.util.List;

import com.soa.converter.DisciplineConverter;
import com.soa.entity.DisciplineEntity;
import com.soa.entity.LabWorkEntity;
import com.soa.repository.DisciplineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DisciplineDbService {

    private final DisciplineRepository disciplineRepository;


    @Transactional(readOnly = true)
    public List<DisciplineEntity> suggest(String name, int limit) {
        return disciplineRepository.suggest(name, limit);
    }

}
