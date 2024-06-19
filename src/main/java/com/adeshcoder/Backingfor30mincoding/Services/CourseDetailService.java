package com.adeshcoder.Backingfor30mincoding.Services;

import com.adeshcoder.Backingfor30mincoding.Entities.CourseDetail;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDetailDto;

import java.util.List;

public interface CourseDetailService {

    //crete CourseDetail with userId

    public CourseDetailDto createDetails(CourseDetailDto detailDto , Integer courseId);

    public  void  delete(Integer detailId);

    //get all course detail

    public List<CourseDetailDto> getAll();

    //get by user

    public List<CourseDetailDto> getByUser(Integer courseId);









}
