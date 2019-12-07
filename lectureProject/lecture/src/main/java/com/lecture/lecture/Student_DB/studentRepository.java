package com.lecture.lecture.Student_DB;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface studentRepository extends JpaRepository<student,String> {
    List<student> findByid(String id);
}
