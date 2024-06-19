package com.adeshcoder.Backingfor30mincoding.ServiceImp;


import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.user.User;
import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.user.UserRepository;
import com.adeshcoder.Backingfor30mincoding.Entities.Course;
import com.adeshcoder.Backingfor30mincoding.Entities.CourseDetail;
import com.adeshcoder.Backingfor30mincoding.Services.CourseService;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDetailDto;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDto;
import com.adeshcoder.Backingfor30mincoding.repositories.CourseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CourseRepo courseRepo;


    @Override
    public CourseDto createCourse(CourseDto course) {

       Course course1=this.mapper.map(course,Course.class);
       Course courseDto=this.courseRepo.save(course1);
       CourseDto d=this.mapper.map(courseDto,CourseDto.class);
       return  d;

    }

    //

    @Override
    public CourseDto updateCourse(Integer courseId, CourseDto courseDto) {
        Course entity=this.courseRepo.findById(courseId).orElseThrow();
        entity.setImageName(courseDto.getImageName());

        CourseDto dto=this.mapper.map(this.courseRepo.save(entity),CourseDto.class);

        return  dto;

    }

    @Override
    public List<CourseDto> getAll() {

        List<Course> course=this.courseRepo.findAll();
        List<CourseDto> dto=course.stream().map((d)->this.mapper.map(d,CourseDto.class)).collect(Collectors.toList());

        return dto;


    }

    @Override
    public void delete(Integer courseId) {

        Course entity=this.courseRepo.findById(courseId).orElseThrow();
        this.courseRepo.delete(entity);
    }

    @Override
    public CourseDto getById(Integer courseId) {
        Course entity=this.courseRepo.findById(courseId).orElseThrow();
      return  this.mapper.map(entity,CourseDto.class);
    }

    @Override
    public CourseDto paymentUpdate(Integer courseId, Boolean pay) {
        //find exits course
        Course course=this.courseRepo.findById(courseId).orElseThrow();
        course.setPayment(pay);
        Course result= this.courseRepo.save(course);
        return this.mapper.map(result,CourseDto.class);




    }

    @Override
    public CourseDto createCourseUser(CourseDto courseDto, Long userId) {




        User user=this.userRepository.findById(userId).orElseThrow();

        Course course=this.mapper.map(courseDto,Course.class);
        course.setImageName(courseDto.getImageName());
        course.setLanguage(courseDto.getLanguage());
        course.setAuthor(courseDto.getAuthor());
        course.setPrice(courseDto.getPrice());
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setUser(user);
        CourseDto dto=this.mapper.map(this.courseRepo.save(course),CourseDto.class);
        return dto;
    }

    @Override
    public List<CourseDto> getByUser(Long userId) {
        User user=this.userRepository.findById(userId).orElseThrow();
        List<Course> details= this.courseRepo.findByUser(user);

        List<CourseDto> newdetail=details.stream().map((d)->this.mapper.map(d,CourseDto.class)).collect(Collectors.toList());
        return newdetail;
    }
}
