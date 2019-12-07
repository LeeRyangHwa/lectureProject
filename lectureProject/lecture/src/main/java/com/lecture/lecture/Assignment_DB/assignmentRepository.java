package com.lecture.lecture.Assignment_DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface assignmentRepository extends JpaRepository<assignment,Long> {
    @Query("select d from assignment d where d.lecture_id=:id" )
    List<assignment> findBylecture_id(@Param("id") Long id);
}
