package com.lecture.lecture.Assignment_DB;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "assignment")
public class assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100)
    private Date end_date;

    @Column(length=100)
    private String name;

    @Column(length=100)
    private Date start_date;

    @Column(length=100)
    private String type;

    @Column( length=100)
    private Long lecture_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(Long lecture_id) {
        this.lecture_id = lecture_id;
    }
}
