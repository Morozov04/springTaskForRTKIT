package com.project.springTaskForRTKIT.repository;

import com.project.springTaskForRTKIT.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long>{

    @Query(value = "SELECT t_student.id AS student_id, AVG(t_assessment.assessment) AS average_grade FROM t_student " +
            "JOIN t_group ON t_student.id_group = t_group.id JOIN t_assessment ON t_student.id = t_assessment.id_student" +
            " WHERE t_group.id = :classNumber GROUP BY t_student.id", nativeQuery = true)
    List<Object[]> getAverageAssessmentsByClassNumber(@Param("classNumber") Long classNumber);

    @Query(value = "SELECT id FROM t_assessment WHERE id_subject = (SELECT id FROM t_subject WHERE " +
            "subject_name = :name_sub) AND id_student = :id_s ", nativeQuery = true)
    Long getNameSubject(@Param("name_sub") String name_sub, @Param("id_s") Long id_s);
}
