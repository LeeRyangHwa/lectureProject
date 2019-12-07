
package com.lecture.lecture.Professor_DB;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface professorRepository extends JpaRepository<professor, String> {

    List<professor> findByid(String id);
}
