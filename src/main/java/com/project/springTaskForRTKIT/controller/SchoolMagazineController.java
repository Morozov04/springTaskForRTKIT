package com.project.springTaskForRTKIT.controller;

import com.project.springTaskForRTKIT.dto.AssessmentDTORequest;
import com.project.springTaskForRTKIT.dto.StudentDTOResponse;
import com.project.springTaskForRTKIT.service.SchoolMagazineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/school/magazine")
public class SchoolMagazineController {

    private final SchoolMagazineService service;

    /** Получение средних оценок каждого ученика в указанном классе */
    @GetMapping("groups/{id_groups}/students/avg_marks")
    private List<Map<Integer, Double>> getAverageAssessmentsByClassNumber(@PathVariable Long id_groups) {
        return service.getAverageAssessmentsByClassNumber(id_groups);
    }

    /** Изменение оценки конкретного ученика */
    @PutMapping("/groups/{id_groups}/students/{id_student}/marks/{name_sub}")
    private void updateAssessment(@PathVariable Long id_groups,
                                  @PathVariable Long id_student,
                                  @PathVariable String name_sub,
                                  @RequestBody AssessmentDTORequest assessment) {
        service.updateAssessment(id_groups, id_student, name_sub, assessment);
    }

    /** Положить ученика в группу */
    @PutMapping("/groups/{id_groups}/students/{id_student}")
    public void putStudentInGroup(@PathVariable Long id_groups,
                                  @PathVariable Long id_student){
        service.putStudentInGroup(id_groups, id_student);
    }

    /** Существующие ученики */
    @GetMapping("students")
    public List<StudentDTOResponse> getStudents() {
        return service.getStudents();
    }

    /** Существующий ученик (по id) */
    @GetMapping("students/{id}")
    public StudentDTOResponse getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    /** Удаление ученика */
    @DeleteMapping("students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudentById(id);
    }
}
