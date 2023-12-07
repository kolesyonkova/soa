package com.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@Accessors(chain = true)
public class DisciplineDto  implements Serializable {

    @JsonIgnoreProperties
    private Integer id;
    private String name;
    private int selfStudyHours = 0;
}
