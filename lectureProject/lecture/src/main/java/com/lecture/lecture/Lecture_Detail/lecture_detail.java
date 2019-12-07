package com.lecture.lecture.Lecture_Detail;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lecture_detail")
public class lecture_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private byte canceled;

    @Column( length=100)
    private Date lecture_date;

    @Column(length=100)
    private String lecture_day;

    @Column( length=100)
    private Double lecture_detail_time;

    @Column(length=100)
    private Long lecture_id;


    @Column(nullable = true)
    private Integer assignment_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getCanceled() {
        return canceled;
    }

    public void setCanceled(byte canceled) {
        this.canceled = canceled;
    }

    public Date getLecture_date() {
        return lecture_date;
    }

    public void setLecture_date(Date lecture_date) {
        this.lecture_date = lecture_date;
    }

    public String getLecture_day() {
        return lecture_day;
    }

    public void setLecture_day(String lecture_day) {
        this.lecture_day = lecture_day;
    }

    public Double getLecture_detail_time() {
        return lecture_detail_time;
    }

    public void setLecture_detail_time(Double lecture_detail_time) {
        this.lecture_detail_time = lecture_detail_time;
    }

    public Long getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(Long lecture_id) {
        this.lecture_id = lecture_id;
    }

    public Integer getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(Integer assignment_id) {
        this.assignment_id = assignment_id;
    }
}
