package com.adeshcoder.Backingfor30mincoding.controller;

import com.adeshcoder.Backingfor30mincoding.Entities.Course;
import com.adeshcoder.Backingfor30mincoding.Services.CourseService;
import com.adeshcoder.Backingfor30mincoding.Services.FileService;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDetailDto;
import com.adeshcoder.Backingfor30mincoding.payloads.CourseDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CourseController {

    static String path="project.image";


    @Autowired
    private FileService fileService;


    @Autowired
    private CourseService courseService;

    @PostMapping("usercourse/{userId}")
    public  ResponseEntity <CourseDto> creatusercourse(@RequestBody CourseDto courseDto ,@PathVariable Long userId){

        CourseDto response=this.courseService.createCourseUser(courseDto,userId);

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @PostMapping("course")
    public ResponseEntity<CourseDto> create(@RequestBody CourseDto course){
        CourseDto response=this.courseService.createCourse(course);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // get  all course
    @GetMapping("courses")
    public ResponseEntity<List<CourseDto>> getAll(){
        return  new ResponseEntity<List<CourseDto>>(this.courseService.getAll(),HttpStatus.OK);
    }

    //get single course
    @GetMapping("course/single/{courseId}")
    public ResponseEntity <CourseDto> getSingleCourse(@PathVariable Integer courseId){

        return  new ResponseEntity<CourseDto>(this.courseService.getById(courseId),HttpStatus.OK);
    }

    @DeleteMapping("{courseId}")
    public String Delete(@PathVariable Integer courseId){
        this.courseService.delete(courseId);
        return  "Deleted";
    }

    @PostMapping("{courseId}/{pay}")

    public ResponseEntity<CourseDto> updatePayment(@PathVariable Integer courseId,@PathVariable  Boolean pay){

        return  new ResponseEntity<>(this.courseService.paymentUpdate(courseId,pay),HttpStatus.OK);

    }

    @PostMapping("image/{LangId}")
    public ResponseEntity<CourseDto> uploadPostImage(@RequestParam("image") MultipartFile image, // giving req image time
                                                     @PathVariable("LangId") Integer LangId) throws IOException {
        //returning filename
        CourseDto postDto=this.courseService.getById(LangId);
        System.out.println(" course controller called");

//        LanguageDto languageDto=new LanguageDto(postDto.getTitle(),postDto.getDescription(),postDto.getImageName());
        String fileName=this.fileService.uploadImage(path, image);
        postDto.setImageName(fileName);//setting image name

        CourseDto updatePost=this.courseService.updateCourse(LangId,postDto); // updata the entity
        return new ResponseEntity<CourseDto>(updatePost,HttpStatus.OK);


    }

    @GetMapping(value="image/{imageName}",produces= MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("imageName")String imageName,
                              HttpServletResponse response)throws IOException {

        InputStream resource=this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE); //giving image response of jpeg

        StreamUtils.copy(resource, response.getOutputStream());

    }

    @GetMapping("{courseId}")

    public ResponseEntity<List<CourseDto>> getbyuser(@PathVariable Long courseId){

        return new ResponseEntity<>(this.courseService.getByUser(courseId),HttpStatus.OK);
    }




}
