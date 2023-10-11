package com.soa.service;

import com.soa.converter.LabWorkConverter;
import com.soa.dto.FilterQueryDto;
import com.soa.dto.LabWorkDto;
import com.soa.entity.LabWorkEntity;
import com.soa.exception.EntityNotFoundException;
import com.soa.filter.FilterService;
import com.soa.service.db.LabWorkDbService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LabWorkService {
    private final LabWorkDbService labWorkDbService;
    private final LabWorkConverter labWorkConverter;
    private final PageService pageService;

    public LabWorkDto createLabWork(LabWorkDto dto) {
        LabWorkEntity entity = labWorkConverter.convertToEntity(dto);
        entity = labWorkDbService.save(entity);
        return labWorkConverter.convertToDto(entity);
    }

    public LabWorkDto updateLabWork(Integer id, LabWorkDto dto) {
        labWorkDbService.findById(id).orElseThrow(EntityNotFoundException::new);
        LabWorkEntity entity = labWorkConverter.convertToEntity(dto);
        entity.setId(id);
        entity = labWorkDbService.save(entity);
        return labWorkConverter.convertToDto(entity);
    }

    public LabWorkDto increaseStepsCount(Integer id, Integer stepsCount) {
        LabWorkEntity entity = labWorkDbService.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setStepsCount(entity.getStepsCount() + stepsCount);
        labWorkDbService.save(entity);
        return labWorkConverter.convertToDto(entity);
    }

    public LabWorkDto findById(Integer id) {
        LabWorkEntity entity = labWorkDbService.findById(id).orElseThrow(EntityNotFoundException::new);
        return labWorkConverter.convertToDto(entity);
    }

    public List<LabWorkDto> getLabWorksWithFiltering(FilterQueryDto dto) {
        FilterService.isValidRequestParams(dto);
        PageRequest request = pageService.getPageRequest(dto.getLimit(), dto.getOffset(), dto.getSort());
        return labWorkDbService.getLabWorksWithFiltering(dto, request).stream().map(labWorkConverter::convertToDto).toList();
    }

    public List<LabWorkDto> getLabworksSuggest(String name, int limit) {
        return labWorkDbService.suggest(name, limit).stream().map(labWorkConverter::convertToDto).toList();
    }

    public void deleteById(Integer id) {
        labWorkDbService.findById(id).orElseThrow(EntityNotFoundException::new);
        labWorkDbService.deleteById(id);
    }
}
