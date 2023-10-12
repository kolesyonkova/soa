package com.soa.service;

import java.util.List;

import com.soa.converter.DisciplineConverter;
import com.soa.converter.LabWorkConverter;
import com.soa.dto.DisciplineDto;
import com.soa.dto.LabWorkDto;
import com.soa.service.db.DisciplineDbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DisciplineService {

    private final DisciplineDbService disciplineDbService;
    private final LabWorkService labWorkService;
    private final DisciplineConverter disciplineConverter;

    public List<DisciplineDto> suggest(String name, int limit) {
        return disciplineDbService.suggest(name, limit).stream().map(disciplineConverter::convertToDto).toList();
    }

}
