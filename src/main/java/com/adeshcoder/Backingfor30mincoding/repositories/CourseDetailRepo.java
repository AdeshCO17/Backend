package com.adeshcoder.Backingfor30mincoding.repositories;

import com.adeshcoder.Backingfor30mincoding.Entities.Course;
import com.adeshcoder.Backingfor30mincoding.Entities.CourseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDetailRepo extends JpaRepository<CourseDetail,Integer> {

    //custom method

    List<CourseDetail> findByCourse(Course course);
}
