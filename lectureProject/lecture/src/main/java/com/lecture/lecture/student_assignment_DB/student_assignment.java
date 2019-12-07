package com.lecture.lecture.student_assignment_DB;

import javax.persistence.*;

@Entity
@Table(name = "student_assignment")
public class student_assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //비번
    @Column( length=100)
    private Long assignment_id;

    @Column( length=100)
    private String part;

    @Column( length=100)
    private String student_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(Long assignment_id) {
        this.assignment_id = assignment_id;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
}
