package com.project.springTaskForRTKIT.mapper;

import com.project.springTaskForRTKIT.dto.StudentDTO;
import com.project.springTaskForRTKIT.entity.Student;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudentDTOMapper implements Function<Student, StudentDTO> {

    public StudentDTO apply(Student student){
        return new StudentDTO()
                    .setLastName(student.getLastName())
                    .setFirstName(student.getFirstName())
                    .setAge(student.getAge());
    }
}

