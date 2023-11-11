package com.project.springTaskForRTKIT.controller;

import com.project.springTaskForRTKIT.dto.StudentDTO;
import com.project.springTaskForRTKIT.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/school/magazine")
public class SchoolMagazineController {

    private final StudentService studentService;

    @GetMapping("student")
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("student/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

   @PostMapping("student")
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
    }

    @PutMapping("student/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(id, studentDTO);
    }

    @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}
