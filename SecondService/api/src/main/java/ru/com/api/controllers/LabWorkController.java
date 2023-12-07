package ru.com.api.controllers;

import com.dto.LabWorkDto;
import com.service.LabWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.com.api.util.JndiUtils;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/bars")
public class LabWorkController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping(value = "/labwork/{labwork-id}/difficulty/increase/{steps-count}")
    public LabWorkDto increaseStepsCount(@PathVariable("labwork-id") Integer id, @PathVariable("steps-count") Integer stepsCount) {
        System.out.println("here");
        return getService().increaseStepsCount(id, stepsCount);
    }

    @GetMapping(value = "/disciplines/{discipline-id}/make-hardcore")
    public List<LabWorkDto> makeHardcore(@PathVariable("discipline-id") Integer id) {
        return getService().makeHardcore(id);
    }


    private LabWorkService getService() {
        return JndiUtils.getFromContext(LabWorkService.class,
                "ejb:/logic-1.0-SNAPSHOT-jar-with-dependencies/LabWorkServiceImpl!com.service.LabWorkService");
    }
}
