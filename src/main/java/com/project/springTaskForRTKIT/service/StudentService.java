package com.project.springTaskForRTKIT.service;

import com.project.springTaskForRTKIT.dto.StudentDTORequest;
import com.project.springTaskForRTKIT.dto.StudentDTOResponse;

import java.util.List;

public interface StudentService {

    List<StudentDTOResponse> getStudents();
    StudentDTOResponse getStudent(Long id);
    void deleteStudentById(Long id);
}
