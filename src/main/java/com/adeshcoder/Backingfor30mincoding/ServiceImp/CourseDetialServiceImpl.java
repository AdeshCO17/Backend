package com.adeshcoder.Backingfor30mincoding.ServiceImp;


import com.adeshcoder.Backingfor30mincoding.Entities.Course;
import com.adeshcoder.Backingfor30mincoding.Entities.CourseDetail;
import com.adeshcoder.Backingfor30mincoding.Services.CourseDetailService;
import com.adeshcoder.Backingfor30mincoding.Services.CourseService;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDetailDto;
import com.adeshcoder.Backingfor30mincoding.repositories.CourseDetailRepo;
import com.adeshcoder.Backingfor30mincoding.repositories.CourseRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseDetialServiceImpl implements CourseDetailService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CourseDetailRepo detailRepo;

    @Autowired
    private CourseRepo  courseRepo;


    @Override
    public CourseDetailDto createDetails(CourseDetailDto detailDto, Integer courseId) {

        Course course=this.courseRepo.findById(courseId).orElseThrow();

        CourseDetail detail=this.mapper.map(detailDto,CourseDetail.class);
//        System.out.println(detailDto.getPath());

        detail.setPath(detailDto.getPath());
        detail.setTopic(detailDto.getTopic());
        detail.setCourse(course);
        CourseDetailDto dto=this.mapper.map(this.detailRepo.save(detail),CourseDetailDto.class);
        return dto;
    }

    @Override
    public void delete(Integer detailId) {

        CourseDetail courseDetail =this.detailRepo.findById(detailId).orElseThrow();

        this.detailRepo.delete(courseDetail);


    }

    @Override
    public List<CourseDetailDto> getAll() {

        List<CourseDetail> details=this.detailRepo.findAll();
        List<CourseDetailDto> postDtos= details.stream().map((post)->this.mapper.map(post, CourseDetailDto.class)).collect(Collectors.toList());
        return  postDtos;
    }

    @Override
    public List<CourseDetailDto> getByUser(Integer courseId) {

        Course course=this.courseRepo.findById(courseId).orElseThrow();
          List<CourseDetail> details= this.detailRepo.findByCourse(course);

          List<CourseDetailDto> newdetail=details.stream().map((d)->this.mapper.map(d,CourseDetailDto.class)).collect(Collectors.toList());
          return newdetail;
    }
}
