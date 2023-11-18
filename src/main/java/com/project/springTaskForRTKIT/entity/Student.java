package com.project.springTaskForRTKIT.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @NotNull
    @Max(value = 17)
    @Min(value = 5)
    @Column(name = "age", nullable = false)
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group", nullable = false)
    private Group group;

    public Student() {
    }

    public Student(String lastName, String firstName, Integer age, Group group) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.group = group;
    }
}
