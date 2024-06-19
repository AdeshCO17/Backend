package com.adeshcoder.Backingfor30mincoding.payloads;

import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.user.UserDto;
import com.adeshcoder.Backingfor30mincoding.Entities.Cart;
import com.adeshcoder.Backingfor30mincoding.Entities.Course;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Integer id;

    private String title;

    @Column(name = "description",length = 65535)
    private String description;

    private String language;

    private  String author;

    private String price;

    private String imageName;

    private Boolean payment=false;

    private UserDto userDto;


}
