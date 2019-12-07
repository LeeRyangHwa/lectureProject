package com.lecture.lecture.Lecture_Detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface lecture_detailRepository extends JpaRepository<lecture_detail,Long> {
    @Query("select d from lecture_detail d where d.lecture_id=:id" )
    List<lecture_detail> findByLecture_id(@Param("id") Long id);
}
