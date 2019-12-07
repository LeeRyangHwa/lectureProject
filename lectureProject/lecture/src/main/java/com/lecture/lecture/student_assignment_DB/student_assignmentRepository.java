package com.lecture.lecture.student_assignment_DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface student_assignmentRepository extends JpaRepository<student_assignment,Long> {

    @Query("select d from student_assignment d where d.assignment_id=:Assign_id" )
    List<student_assignment> findByassignment_id(@Param("Assign_id") Long Assign_id);
}
