package com.project.springTaskForRTKIT.service;

import java.util.List;

public interface AssessmentService {
    List<Object[]> getAverageAssessmentsByClassNumber(Long id_groups);

    void updateAssessment(Long id_groups, Long id_student, String name_sub, Integer assessment);
}
