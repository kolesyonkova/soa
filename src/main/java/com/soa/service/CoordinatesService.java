package com.soa.service;

import com.soa.service.db.LabWorkDbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoordinatesService {
    private LabWorkDbService labWorkDbService;

    public List<Integer> getGroupedByCoordinates() {
        return labWorkDbService.getGroupedByCoordinates();
    }
}
