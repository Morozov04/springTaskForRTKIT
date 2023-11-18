package com.project.springTaskForRTKIT.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AssessmentDTORequest {
    private Integer assessment;
}
