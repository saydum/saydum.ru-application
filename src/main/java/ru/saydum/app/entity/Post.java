package ru.saydum.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(name = "create_date_post")
    private Date createDatePost;

}