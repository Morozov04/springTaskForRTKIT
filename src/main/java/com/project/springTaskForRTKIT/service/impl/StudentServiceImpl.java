package com.project.springTaskForRTKIT.service.impl;

import com.project.springTaskForRTKIT.dto.StudentDTO;
import com.project.springTaskForRTKIT.entity.Student;
import com.project.springTaskForRTKIT.mapper.StudentDTOMapper;
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
    private final StudentDTOMapper studentDTOMapper;
    @Override
    public StudentDTO getStudent(Long id) {
        return studentRepository
                .findById(id)
                .map(studentDTOMapper)
                .orElseThrow(() -> new RuntimeException("student with id [%s] not found".formatted(id)));
    }

    @Override
    public List<StudentDTO> getStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public void createStudent(StudentDTO studentDTO) {
        studentRepository.save(new Student(
                        studentDTO.getLastName(),
                        studentDTO.getFirstName(),
                        studentDTO.getAge()));
    }

    @Override
    public void updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("student with id [%s] not found".formatted(id)));

        boolean changes = false;

        if (studentDTO.getLastName() != null && !studentDTO.getLastName().equals(student.getLastName())) {
            student.setLastName(studentDTO.getLastName());
            changes = true;
        }
        if (studentDTO.getFirstName() != null && !studentDTO.getFirstName().equals(student.getFirstName())) {
            student.setFirstName(studentDTO.getFirstName());
            changes = true;
        }
        if (studentDTO.getAge() != null && !studentDTO.getAge().equals(student.getAge())) {
            student.setAge(studentDTO.getAge());
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
