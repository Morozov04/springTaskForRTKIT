package com.project.springTaskForRTKIT.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "t_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name", length = 30, nullable = false)
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "id_plan", nullable = false)
    private Plan plan;

    public Group() {
    }

    public Group(String groupName, Plan plan) {
        this.groupName = groupName;
        this.plan = plan;
    }
}
