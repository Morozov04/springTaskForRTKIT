package com.project.springTaskForRTKIT.controller;

import com.project.springTaskForRTKIT.dto.StudentDTORequest;
import com.project.springTaskForRTKIT.dto.StudentDTOResponse;
import com.project.springTaskForRTKIT.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/school/magazine")
public class SchoolMagazineController {

    private final StudentService studentService;

    //Ученики в группе (все)
    @GetMapping("groups/{id_groups}/students")
    public List<StudentDTOResponse> getStudentsFromGroup(@PathVariable Long id_groups) {
        return studentService.getStudentsFromGroup(id_groups);
    }

    //Ученики в группе (по ФИО)
    @GetMapping("groups/{id_groups}/students/{last_name}/{first_name}")
    public List<StudentDTOResponse> getStudentFromGroup(@PathVariable Long id_groups,
                                                       @PathVariable String last_name,
                                                       @PathVariable String first_name) {
        return studentService.getStudentFromGroup(id_groups, last_name, first_name);
    }

    //Ученик в группе (по id)
    @GetMapping("groups/{id_groups}/students/{id_student}")
    public StudentDTOResponse getStudentFromGroupById(@PathVariable Long id_groups,
                                                     @PathVariable Long id_student) {
        return studentService.getStudentFromGroupById(id_groups, id_student);
    }

    //Положить ученика в группу
    //Получение средних оценок каждого ученика в указанном классе
    //Изменение оценки конкретного ученика


    //Существующие ученики
    @GetMapping("students")
    public List<StudentDTOResponse> getStudents() {
        return studentService.getStudents();
    }

    //Существующий ученик (по id)
    @GetMapping("students/{id}")
    public StudentDTOResponse getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    //Создание ученика
    @PostMapping("students")
    public void createStudent(@RequestBody StudentDTORequest studentDTORequest) {
        studentService.createStudent(studentDTORequest);
    }

    //Обновление полей ученика
    @PutMapping("students/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDTORequest studentDTORequest) {
        studentService.updateStudent(id, studentDTORequest);
    }

    //Удаление ученика
    @DeleteMapping("students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}
