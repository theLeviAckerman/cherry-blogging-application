package com.cherry.blogging.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_title", nullable = false, length = 255)
    private String title;

    @Column(name = "post_content", nullable = false, length = 1024)
    private String content;

    private  String imageName;

    private Date addedDate;


    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;


}
