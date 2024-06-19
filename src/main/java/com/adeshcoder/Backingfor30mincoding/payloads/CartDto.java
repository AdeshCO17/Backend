package com.adeshcoder.Backingfor30mincoding.payloads;


import com.adeshcoder.Backingfor30mincoding.Entities.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Integer id;

    private CourseDto course;

}
