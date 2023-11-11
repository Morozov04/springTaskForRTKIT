package com.project.springTaskForRTKIT.service;

import com.project.springTaskForRTKIT.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO getStudent(Long id);
    List<StudentDTO> getStudents();
    void createStudent(StudentDTO studentDTO);
    void updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudentById(Long id);
}
