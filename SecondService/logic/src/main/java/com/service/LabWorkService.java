package com.service;


import com.dto.LabWorkDto;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface LabWorkService {

    LabWorkDto increaseStepsCount(Integer id, Integer stepsCount);

    List<LabWorkDto> makeHardcore(Integer id);
}
