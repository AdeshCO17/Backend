package com.adeshcoder.Backingfor30mincoding.payloads;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor

public class CourseDetailDto {


    private Integer id;

    private String topic;

    private String path;

    private  CourseDto course;
}
