package ru.com.api.dto;

import com.dto.CoordinatesDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;

@Setter
@Getter
@Accessors(chain = true)
public class LabWorkDto implements Serializable {
    @JsonIgnoreProperties
    private Integer id;
    private String name;
    private CoordinatesDto coordinates;
    private Instant creationDate;
    private Integer minimalPoint;
    private Difficulty difficulty;
    private DisciplineDto discipline;
    @JsonIgnoreProperties
    private int stepsCount;
}
