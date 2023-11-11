package com.project.springTaskForRTKIT.repository;

import com.project.springTaskForRTKIT.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
