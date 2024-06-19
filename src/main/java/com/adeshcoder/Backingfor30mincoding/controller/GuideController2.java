package com.adeshcoder.Backingfor30mincoding.controller;

import com.adeshcoder.Backingfor30mincoding.Entities.Guide2;
import com.adeshcoder.Backingfor30mincoding.Services.Guide2Service;
import com.adeshcoder.Backingfor30mincoding.payloads.GuideDto;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/guide2")
@RestController
@AllArgsConstructor
public class GuideController2 {
    @Autowired
    private Guide2Service guideService;

    @PostMapping
    public ResponseEntity<Guide2> CreateGuide(@RequestBody GuideDto guideDto){

        return new ResponseEntity<>(guideService.createGuide(guideDto), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public  ResponseEntity<List<Guide2>> getAll(){
        return new ResponseEntity<List<Guide2>>(guideService.getAllGuide(),HttpStatus.OK);
    }
    @GetMapping("{guideId}")
    public ResponseEntity<Guide2> getGuide(@PathVariable Integer guideId){
        return new ResponseEntity<Guide2>(guideService.getGuide(guideId), HttpStatus.OK);
    }
    @DeleteMapping("{guideId}")
    public  void Delete(@PathVariable Integer guideId){

        this.guideService.DeleteGuide(guideId);

    }
}
