package com.project.springTaskForRTKIT.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface GroupService {

    void putStudentInGroup(Long id_groups, Long id_student);
}
