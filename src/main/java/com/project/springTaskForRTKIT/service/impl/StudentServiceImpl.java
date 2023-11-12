package com.project.springTaskForRTKIT.service.impl;

import com.project.springTaskForRTKIT.dto.StudentDTORequest;
import com.project.springTaskForRTKIT.dto.StudentDTOResponse;
import com.project.springTaskForRTKIT.entity.Student;
import com.project.springTaskForRTKIT.mapper.StudentDTOMapperRequest;
import com.project.springTaskForRTKIT.mapper.StudentDTOMapperResponse;
import com.project.springTaskForRTKIT.repository.StudentRepository;
import com.project.springTaskForRTKIT.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentDTOMapperResponse studentDTOMapperResponse;

    @Override
    public List<StudentDTOResponse> getStudentFromGroup(Long id_groups, String last_name, String first_name) {
        if (!studentRepository
                .existsGroup(id_groups)) { throw new RuntimeException("group [%s] not exists"
                .formatted(id_groups)); }

        return studentRepository
                .findByGroupAndLastNameAndFirstName(id_groups, last_name, first_name)
                .stream()
                .map(studentDTOMapperResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTOResponse> getStudentsFromGroup(Long id_groups) {
        if (!studentRepository
                .existsGroup(id_groups)) { throw new RuntimeException("group [%s] not exists"
                .formatted(id_groups)); }

        return studentRepository
                .findByGroup(id_groups)
                .stream()
                .map(studentDTOMapperResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTOResponse getStudentFromGroupById(Long id_groups, Long id_student) {
        if (!studentRepository
                .existsGroup(id_groups)) { throw new RuntimeException("group [%s] not exists"
                .formatted(id_groups)); }

        if(!studentRepository
                .findById(id_student)
                .orElseThrow(() -> new RuntimeException("student with id [%s] not found".formatted(id_student)))
                .getGroup()
                .equals(id_groups)) { throw new RuntimeException("student with id [%s] not in [%s] group"
                                        .formatted(id_student, id_groups)); }
        return studentRepository
                .findById(id_student)
                .map(studentDTOMapperResponse)
                .orElseThrow();
    }

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
    public void createStudent(StudentDTORequest studentDTORequest) {
        studentRepository.save(new Student(
                        studentDTORequest.getLastName(),
                        studentDTORequest.getFirstName(),
                        studentDTORequest.getAge(), null));
    }

    @Override
    public void updateStudent(Long id, StudentDTORequest studentDTORequest) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("student with id [%s] not found".formatted(id)));

        boolean changes = false;

        if (studentDTORequest.getLastName() != null && !studentDTORequest.getLastName().equals(student.getLastName())) {
            student.setLastName(studentDTORequest.getLastName());
            changes = true;
        }
        if (studentDTORequest.getFirstName() != null && !studentDTORequest.getFirstName().equals(student.getFirstName())) {
            student.setFirstName(studentDTORequest.getFirstName());
            changes = true;
        }
        if (studentDTORequest.getAge() != null && !studentDTORequest.getAge().equals(student.getAge())) {
            student.setAge(studentDTORequest.getAge());
            changes = true;
        }
        if (!changes) {
            throw new RuntimeException("no data changes found");
        }
        studentRepository.save(student);
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
}
