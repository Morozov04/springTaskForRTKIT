package com.project.springTaskForRTKIT.mapper;

import com.project.springTaskForRTKIT.dto.StudentDTOResponse;
import com.project.springTaskForRTKIT.entity.Student;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudentDTOMapperResponse implements Function<Student, StudentDTOResponse> {
    @Override
    public StudentDTOResponse apply(Student student) {
        return new StudentDTOResponse()
                .setId(student.getId())
                .setLastName(student.getLastName())
                .setFirstName(student.getFirstName())
                .setAge(student.getAge())
                .setGroup(student.getGroup() != null ? student.getGroup().getId() : null);
    }
}
