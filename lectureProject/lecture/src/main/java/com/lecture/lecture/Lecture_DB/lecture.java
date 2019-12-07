package com.lecture.lecture.Lecture_DB;


import javax.persistence.*;

@Entity
@Table(name = "lecture")
public class lecture {
    //아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //날짜
    @Column(length=100)
    private String lecture_day;

    //시간
    @Column(length=50)
    private double lecture_time ;

    //이름
    @Column(length=100)
    private String name;

    //점수
    @Column(length=100)
    private double score;

    //교수id
    @Column(length=100)
    private String professor_id;

    //학기
    @Column(length=100)
    private Long semester_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLecture_day() {
        return lecture_day;
    }

    public void setLecture_day(String lecture_day) {
        this.lecture_day = lecture_day;
    }

    public double getLecture_time() {
        return lecture_time;
    }

    public void setLecture_time(double lecture_time) {
        this.lecture_time = lecture_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(String professor_id) {
        this.professor_id = professor_id;
    }

    public Long getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(Long semester_id) {
        this.semester_id = semester_id;
    }
}
