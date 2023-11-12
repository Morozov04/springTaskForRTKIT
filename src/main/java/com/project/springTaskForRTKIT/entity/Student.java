package com.project.springTaskForRTKIT.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "id_group")
    private Long group;

    public Student() {
    }

    public Student(String lastName, String firstName, Integer age, Long group) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.group = group;
    }
}
