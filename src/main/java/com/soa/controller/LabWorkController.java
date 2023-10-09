package com.soa.controller;

import com.soa.dto.FilterQueryDto;
import com.soa.dto.LabWorkDto;
import com.soa.service.LabWorkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/labworks")
@AllArgsConstructor
public class LabWorkController {
    private final LabWorkService labWorkService;

    @PostMapping
    public ResponseEntity<LabWorkDto> createLabWork(@Valid @RequestBody LabWorkDto dto) {
        return ResponseEntity.status(200).body(labWorkService.createLabWork(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabWorkDto> updateLabWork(@PathVariable(name = "id") Integer id, @Valid @RequestBody LabWorkDto dto) {
        return ResponseEntity.status(200).body(labWorkService.updateLabWork(id, dto));
    }

    @PutMapping("/{id}/difficulty/increase/{steps-count}")
    public ResponseEntity<LabWorkDto> increaseStepsCount(@Valid @Min(1) @PathVariable(name = "id") Integer id, @Valid @Min(0) @PathVariable(name = "steps-count") Integer stepsCount) {
        return ResponseEntity.status(200).body(labWorkService.increaseStepsCount(id, stepsCount));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabWorkDto> findById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.status(200).body(labWorkService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<LabWorkDto>> getLabWorksWithFiltering(@Valid FilterQueryDto dto) {
        System.out.println(dto);
        return ResponseEntity.status(200).body(labWorkService.getLabWorksWithFiltering(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "id") Integer id) {
        labWorkService.deleteById(id);
    }
}
