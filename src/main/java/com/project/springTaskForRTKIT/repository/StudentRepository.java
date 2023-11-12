package com.project.springTaskForRTKIT.repository;

import com.project.springTaskForRTKIT.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByGroup(Long group);

    List<Student> findByGroupAndLastNameAndFirstName(Long id_groups, String last_name, String first_name);

    @Query(value = "SELECT EXISTS(SELECT id FROM t_group WHERE id = :id)", nativeQuery = true)
    Boolean existsGroup(@Param("id") Long id);

    @Query(value = "SELECT EXISTS(SELECT id FROM t_student WHERE id = :id)", nativeQuery = true)
    Boolean existsStudent(@Param("id") Long id);
}
