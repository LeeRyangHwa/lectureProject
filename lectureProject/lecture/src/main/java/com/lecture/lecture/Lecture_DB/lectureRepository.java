package com.lecture.lecture.Lecture_DB;

        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;

public interface lectureRepository extends JpaRepository<lecture,Long> {
    List<lecture> findByid(Long id);
}
