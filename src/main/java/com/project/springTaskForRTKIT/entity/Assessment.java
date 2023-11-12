package com.project.springTaskForRTKIT.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "t_assessment")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject", nullable = false)
    private Subject subject;

    @Column(name = "assessment", nullable = false)
    private Integer assessment;

    public Assessment() {
    }

    public Assessment(Student student, Subject subject, Integer assessment) {
        this.student = student;
        this.subject = subject;
        this.assessment = assessment;
    }
}
