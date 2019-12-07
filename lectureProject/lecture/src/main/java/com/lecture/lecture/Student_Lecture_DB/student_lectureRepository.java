package com.lecture.lecture.Student_Lecture_DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface student_lectureRepository extends JpaRepository<student_lecture, Long> {

    @Query("select sl from student_lecture sl where sl.student_id=:user" )
    List<student_lecture> findByStudent_id(@Param("user") String user);

}
