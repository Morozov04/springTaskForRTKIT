package com.project.springTaskForRTKIT.controller;

import com.project.springTaskForRTKIT.dto.StudentDTOResponse;
import com.project.springTaskForRTKIT.service.AssessmentService;
import com.project.springTaskForRTKIT.service.GroupService;
import com.project.springTaskForRTKIT.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/school/magazine")
public class SchoolMagazineController {

    private final StudentService studentService;
    private final AssessmentService assessmentService;
    private final GroupService groupService;

    //ДЗ
    //Получение средних оценок каждого ученика в указанном классе
    @GetMapping("groups/{id_groups}/students/avg_marks")
    private List<Object[]> getAverageAssessmentsByClassNumber(@PathVariable Long id_groups) {
        return assessmentService.getAverageAssessmentsByClassNumber(id_groups);
    }

    //ДЗ
    //Изменение оценки конкретного ученика
    @PutMapping("/groups/{id_groups}/students/{id_student}/marks/{name_sub}/{assessment}")
    private void updateAssessment(@PathVariable Long id_groups,
                                  @PathVariable Long id_student,
                                  @PathVariable String name_sub,
                                  @PathVariable Integer assessment) {
        assessmentService.updateAssessment(id_groups, id_student, name_sub, assessment);
    }

    //ДЗ
    //Положить ученика в группу
    @PutMapping("/groups/{id_groups}/students/{id_student}")
    public void putStudentInGroup(@PathVariable Long id_groups,
                                  @PathVariable Long id_student){
        groupService.putStudentInGroup(id_groups, id_student);
    }

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

    //Удаление ученика
    @DeleteMapping("students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}
