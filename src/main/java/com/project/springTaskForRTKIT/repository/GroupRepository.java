package com.project.springTaskForRTKIT.repository;

import com.project.springTaskForRTKIT.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
