package com.project.springTaskForRTKIT.mapper;

import com.project.springTaskForRTKIT.dto.StudentDTORequest;
import com.project.springTaskForRTKIT.entity.Student;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudentDTOMapperRequest implements Function<Student, StudentDTORequest> {
    @Override
    public StudentDTORequest apply(Student student){
        return new StudentDTORequest()
                    .setLastName(student.getLastName())
                    .setFirstName(student.getFirstName())
                    .setAge(student.getAge());
    }
}

