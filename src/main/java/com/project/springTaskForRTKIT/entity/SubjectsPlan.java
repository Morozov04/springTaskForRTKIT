package com.project.springTaskForRTKIT.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "t_subjects_plan")
public class SubjectsPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_plan", nullable = false)
    private Long plan;

    @Column(name = "id_subject", nullable = false)
    private Long subject;

    public SubjectsPlan() {
    }

    public SubjectsPlan(Long plan, Long subject) {
        this.plan = plan;
        this.subject = subject;
    }
}
