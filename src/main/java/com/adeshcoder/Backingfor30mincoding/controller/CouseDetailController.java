package com.adeshcoder.Backingfor30mincoding.controller;


import com.adeshcoder.Backingfor30mincoding.Entities.CourseDetail;
import com.adeshcoder.Backingfor30mincoding.Services.CourseDetailService;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDetailDto;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coursedetail/")
public class CouseDetailController {


    @Autowired
    private CourseDetailService service;

    @PostMapping("details/{courseId}")
    public ResponseEntity<CourseDetailDto> create(@RequestBody CourseDetailDto details, @PathVariable Integer courseId){



        return new ResponseEntity<>(this.service.createDetails(details,courseId), HttpStatus.CREATED);

    }
    @DeleteMapping("{detailId}")

    public  String delete(@PathVariable Integer detailId){

        this.service.delete(detailId);

        return "Deleted";

    }

    @GetMapping("details")
    public  ResponseEntity<List<CourseDetailDto>> getAll(){
        return new ResponseEntity<>(this.service.getAll(),HttpStatus.OK);
    }

    @GetMapping("{courseId}")

    public ResponseEntity<List<CourseDetailDto>> getbyuser(@PathVariable Integer courseId){

        return new ResponseEntity<>(this.service.getByUser(courseId),HttpStatus.OK);
    }


}
