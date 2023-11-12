package com.project.springTaskForRTKIT.service;

import com.project.springTaskForRTKIT.dto.StudentDTORequest;
import com.project.springTaskForRTKIT.dto.StudentDTOResponse;

import java.util.List;

public interface StudentService {

    List<StudentDTOResponse> getStudentFromGroup(Long id_groups, String last_name, String first_name);
    List<StudentDTOResponse> getStudentsFromGroup(Long id_groups);
    StudentDTOResponse getStudentFromGroupById(Long id_groups, Long id_student);
    List<StudentDTOResponse> getStudents();
    StudentDTOResponse getStudent(Long id);
    void createStudent(StudentDTORequest studentDTORequest);
    void updateStudent(Long id, StudentDTORequest studentDTORequest);
    void deleteStudentById(Long id);
}
