package com.adeshcoder.Backingfor30mincoding.controller;


import com.adeshcoder.Backingfor30mincoding.Entities.Guide;
import com.adeshcoder.Backingfor30mincoding.Services.GuideService;

import com.adeshcoder.Backingfor30mincoding.payloads.GuideDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/guide")
@RestController
@AllArgsConstructor
public class GuideController {

    @Autowired
    private GuideService guideService;

    @PostMapping
    public ResponseEntity<Guide> CreateGuide(@RequestBody GuideDto guideDto){

        return new ResponseEntity<>(guideService.createGuide(guideDto), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public  ResponseEntity<List<Guide>> getAll(){
        return new ResponseEntity<List<Guide>>(guideService.getAllGuide(),HttpStatus.OK);
    }
    @GetMapping("{guideId}")
    public ResponseEntity<Guide> getGuide(@PathVariable Integer guideId){
        return new ResponseEntity<Guide>(guideService.getGuide(guideId), HttpStatus.OK);
    }
    @DeleteMapping("{guideId}")
    public  void Delete(@PathVariable Integer guideId){

        this.guideService.DeleteGuide(guideId);

    }
}
