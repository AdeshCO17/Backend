package com.adeshcoder.Backingfor30mincoding.controller;



import com.adeshcoder.Backingfor30mincoding.Entities.Guide1;
import com.adeshcoder.Backingfor30mincoding.Services.Guide1Serive;
import com.adeshcoder.Backingfor30mincoding.payloads.GuideDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/guide1")
@RestController
@AllArgsConstructor
public class GuideController1 {

    @Autowired
    private Guide1Serive guideService;

    @PostMapping
    public ResponseEntity<Guide1> CreateGuide(@RequestBody GuideDto guideDto){

        return new ResponseEntity<>(guideService.createGuide(guideDto), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public  ResponseEntity<List<Guide1>> getAll(){
        return new ResponseEntity<List<Guide1>>(guideService.getAllGuide(),HttpStatus.OK);
    }
    @GetMapping("{guideId}")
    public ResponseEntity<Guide1> getGuide(@PathVariable Integer guideId){
        return new ResponseEntity<Guide1>(guideService.getGuide(guideId), HttpStatus.OK);
    }
    @DeleteMapping("{guideId}")
    public  void Delete(@PathVariable Integer guideId){

        this.guideService.DeleteGuide(guideId);

    }
}
