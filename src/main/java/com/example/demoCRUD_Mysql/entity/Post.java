package com.example.demoCRUD_Mysql.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.aspectj.apache.bcel.classfile.SourceFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;


    @Temporal(TemporalType.DATE)
    @Column(name = "time")
    private Date time;


    public Post() {
    }

    public Post(String name, String pass, Date time) {
        this.title = title;
        this.content = content;
        this.time = time;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}



