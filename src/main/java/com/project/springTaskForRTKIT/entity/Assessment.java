package com.project.springTaskForRTKIT.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Embeddable
@Table(name = "t_assessment")
public class Assessment {
    @Column(name = "id_student", nullable = false)
    private Long student;

    @Column(name = "id_subject", nullable = false)
    private Long subject;

    @Column(name = "assessment", nullable = false)
    private Integer assessment;

    public Assessment() {
    }

    public Assessment(Long student, Long subject, Integer assessment) {
        this.student = student;
        this.subject = subject;
        this.assessment = assessment;
    }
}
