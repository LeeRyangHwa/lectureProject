package com.lecture.lecture.Student_Lecture_DB;


import javax.persistence.*;

@Entity
@Table(name = "student_lecture")
public class student_lecture {

    //아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //학생id

    @Column(length=100)
    private String student_id;

    //강좌id
    @Column(length=100)
    private Long lecture_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Long getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(Long lecture_id) {
        this.lecture_id = lecture_id;
    }
}
