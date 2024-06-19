package com.adeshcoder.Backingfor30mincoding.Entities;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    private String title;
//
//    private Integer price;
//
//    private  String author;


    //one to one relationship

    @OneToOne
    @JoinColumn(name = "course_id")
    private  Course course;



}
