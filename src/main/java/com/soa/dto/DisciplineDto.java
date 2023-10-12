package com.soa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Accessors(chain = true)
public class DisciplineDto {

    @JsonIgnoreProperties
    private Integer id;
    @NotBlank
    private String name;
    private int selfStudyHours = 0;
}
