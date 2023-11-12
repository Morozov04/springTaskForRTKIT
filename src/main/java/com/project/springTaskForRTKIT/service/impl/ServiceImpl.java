package com.project.springTaskForRTKIT.service.impl;

import com.project.springTaskForRTKIT.dto.StudentDTOResponse;
import com.project.springTaskForRTKIT.entity.Assessment;
import com.project.springTaskForRTKIT.mapper.StudentDTOMapperResponse;
import com.project.springTaskForRTKIT.repository.AssessmentRepository;
import com.project.springTaskForRTKIT.repository.GroupRepository;
import com.project.springTaskForRTKIT.repository.StudentRepository;
import com.project.springTaskForRTKIT.service.AssessmentService;
import com.project.springTaskForRTKIT.service.GroupService;
import com.project.springTaskForRTKIT.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceImpl implements StudentService, AssessmentService, GroupService {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final AssessmentRepository assessmentRepository;

    private final StudentDTOMapperResponse studentDTOMapperResponse;

    @Override
    public List<StudentDTOResponse> getStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentDTOMapperResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTOResponse getStudent(Long id) {
        return studentRepository
                .findById(id)
                .map(studentDTOMapperResponse)
                .orElseThrow(() -> new RuntimeException("student with id [%s] not found".formatted(id)));
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new RuntimeException(
                    "student with id [%s] not found".formatted(id)
            );
        }
        studentRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getAverageAssessmentsByClassNumber(Long id_groups) {
        return assessmentRepository.getAverageAssessmentsByClassNumber(id_groups);
    }

    @Override
    public void updateAssessment(Long id_groups, Long id_student, String name_sub, Integer assessment) {
        Assessment newAssessment = assessmentRepository
                .findById(assessmentRepository.getNameSubject(name_sub, id_student))
                .orElseThrow(() -> new RuntimeException("such subject does not exist"));

        if(!newAssessment.getStudent().getGroup().getId().equals(id_groups)) {
            throw new RuntimeException("this student is not in the group");
        }

        boolean changes = false;

        if (!assessment.equals(newAssessment.getAssessment())){
            newAssessment.setAssessment(assessment);
            changes = true;
        }

        if (!changes) {
            throw new RuntimeException("no data changes found");
        }
        assessmentRepository.save(newAssessment);
    }

    @Override
    public void putStudentInGroup(Long id_groups, Long id_student) {
        if(studentRepository
                .findById(id_student)
                .orElseThrow(() -> new RuntimeException("student with id [%s] not found"
                        .formatted(id_student)))
                        .getGroup() != null) {
            throw new RuntimeException("this student have group");
        }
        studentRepository.save(studentRepository.findById(id_student).orElseThrow()
                .setGroup(groupRepository.findById(id_groups).orElseThrow()));
    }
}
