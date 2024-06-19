package com.adeshcoder.Backingfor30mincoding.Entities;


import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
@Setter
@Getter
@NoArgsConstructor

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String title;

    @Column(name = "description",length = 65535)
    private String description;

    private String language;

    private  String author;

    private String price;

    @Column(name="imageName")
    private String imageName;

    private Boolean payment=false;

    @ManyToOne
    private User user;



    // onetomany relation

    @OneToMany(mappedBy = "course",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<CourseDetail> courseDetails=new ArrayList<>();



    //one to one mapping
    @OneToOne(mappedBy = "course")
    private  Cart cart;




}
