package com.lecture.lecture.Student_DB;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class student {

    //아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    //비번
    @Column( length=100)
    private String password;

    //이름
    @Column(length=50)
    private String name;

    //번호
    @Column( length=100)
    private String phone;

    //이메일
    @Column(length=100)
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}