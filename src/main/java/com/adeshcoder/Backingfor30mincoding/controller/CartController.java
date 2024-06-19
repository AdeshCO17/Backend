package com.adeshcoder.Backingfor30mincoding.controller;


import com.adeshcoder.Backingfor30mincoding.Entities.Cart;
import com.adeshcoder.Backingfor30mincoding.Services.CartService;
import com.adeshcoder.Backingfor30mincoding.payloads.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart/")
public class CartController {
    @Autowired
    private CartService service;

    @PostMapping("add/{courseId}")
    public ResponseEntity<CartDto> create(@RequestBody CartDto cart,@PathVariable ("courseId") Integer courseId){
        return new ResponseEntity<>(this.service.create(cart,courseId), HttpStatus.CREATED);
    }

    @DeleteMapping("{cartId}")
    public String delete(@PathVariable Integer cartId){
        this.service.delete(cartId);

        return "Deleted";
    }

    @GetMapping ("{cartId}")
    public  ResponseEntity<Cart> getbyId(@PathVariable Integer cartId){

        return  new ResponseEntity<>(this.service.getById(cartId),HttpStatus.OK);
    }

    @GetMapping("all")
    public  ResponseEntity<List<CartDto>> getall(){
        return new ResponseEntity<>(this.service.getAll(),HttpStatus.OK);
    }

}
