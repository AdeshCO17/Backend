package com.adeshcoder.Backingfor30mincoding.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="CourseDetail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String topic;

    private String path;

    @ManyToOne
    private Course course;


}
