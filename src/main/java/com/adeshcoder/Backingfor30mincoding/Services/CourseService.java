package com.adeshcoder.Backingfor30mincoding.Services;

import com.adeshcoder.Backingfor30mincoding.Entities.Course;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDetailDto;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDto;

import java.util.List;

public interface CourseService {



    public CourseDto createCourse(CourseDto course);
    public  CourseDto updateCourse(Integer courseId,CourseDto courseDto);

    public List<CourseDto> getAll();

    public  void delete(Integer courseId);

    public  CourseDto getById(Integer courseId);

    //method for payment
    public CourseDto paymentUpdate(Integer courseId,Boolean pay);

    // creat course using user
    public  CourseDto createCourseUser(CourseDto courseDtoDto ,Long userId);

    public List<CourseDto> getByUser(Long userId);




}
