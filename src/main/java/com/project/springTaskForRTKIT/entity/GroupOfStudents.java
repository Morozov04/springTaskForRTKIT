package com.project.springTaskForRTKIT.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Embeddable
@Table(name = "t_group_of_students")
public class GroupOfStudents {
    @ManyToOne
    @JoinColumn(name = "id_groups", referencedColumnName = "id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    private Student student;

    public GroupOfStudents() {
    }

    public GroupOfStudents(Group group, Student student) {
        this.group = group;
        this.student = student;
    }
}