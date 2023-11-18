package com.project.springTaskForRTKIT.service;

import com.project.springTaskForRTKIT.dto.AssessmentDTORequest;
import com.project.springTaskForRTKIT.dto.StudentDTOResponse;

import java.util.List;
import java.util.Map;

public interface SchoolMagazineService {
    List<Map<Integer, Double>> getAverageAssessmentsByClassNumber(Long id_groups);
    void updateAssessment(Long id_groups, Long id_student, String name_sub, AssessmentDTORequest assessment);

    void putStudentInGroup(Long id_groups, Long id_student);

    List<StudentDTOResponse> getStudents();
    StudentDTOResponse getStudent(Long id);
    void deleteStudentById(Long id);
}
