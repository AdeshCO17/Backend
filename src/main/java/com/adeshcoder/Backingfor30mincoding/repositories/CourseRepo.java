package com.adeshcoder.Backingfor30mincoding.repositories;

import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.user.User;
import com.adeshcoder.Backingfor30mincoding.Entities.Course;
import com.adeshcoder.Backingfor30mincoding.Entities.CourseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepo extends JpaRepository<Course,Integer> {

    List<Course> findByUser(User user);
}
