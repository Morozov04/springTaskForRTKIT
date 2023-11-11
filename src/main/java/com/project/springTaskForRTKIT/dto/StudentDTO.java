package com.project.springTaskForRTKIT.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class StudentDTO {
    private String lastName;
    private String firstName;
    private Integer age;
}
