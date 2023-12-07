package ru.com.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@Accessors(chain = true)
public class CoordinatesDto implements Serializable {
    private int x;
    private Double y;
}
