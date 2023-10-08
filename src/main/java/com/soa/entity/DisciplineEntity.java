package com.soa.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@Accessors(chain = true)
public class DisciplineEntity {
    @Column(name = "DISCIPLINE_NAME")
    private String name;
    @Column(name = "SELF_STUDY_HOURS")
    private int selfStudyHours;
}
