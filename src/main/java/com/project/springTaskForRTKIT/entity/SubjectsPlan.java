package com.project.springTaskForRTKIT.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Embeddable
@Table(name = "t_subjects_plan")
public class SubjectsPlan {
    @ManyToOne
    @JoinColumn(name = "id_plan", nullable = false)
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "id_subject", nullable = false)
    private Subject subject;

    public SubjectsPlan() {
    }

    public SubjectsPlan(Plan plan, Subject subject) {
        this.plan = plan;
        this.subject = subject;
    }
}
