package com.adeshcoder.Backingfor30mincoding.ServiceImp;

import com.adeshcoder.Backingfor30mincoding.Entities.Cart;
import com.adeshcoder.Backingfor30mincoding.Entities.Course;
import com.adeshcoder.Backingfor30mincoding.Services.CartService;
import com.adeshcoder.Backingfor30mincoding.payloads.CartDto;
import com.adeshcoder.Backingfor30mincoding.repositories.CartRepo;
import com.adeshcoder.Backingfor30mincoding.repositories.CourseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CartRepo repo;

    @Autowired
    private CourseRepo courseRepo;
    @Override
    public CartDto create(CartDto cart,Integer courseId) {

        Course course =courseRepo.findById(courseId).orElseThrow();

       Cart entity= this.mapper.map(cart,Cart.class);
       entity.setCourse(course);

       CartDto dto=this.mapper.map(this.repo.save(entity),CartDto.class);

       return dto;



    }

    @Override
    public List<CartDto> getAll() {

        List<Cart> list=repo.findAll();
        List<CartDto>listdto=list.stream().map((l)->this.mapper.map(l,CartDto.class)).collect(Collectors.toList());

        return listdto;

    }

    @Override
    public void delete(Integer cartId) {
        Cart entity=this.repo.findById(cartId).orElseThrow();
        this.repo.delete(entity);

    }

    @Override
    public Cart getById(Integer cartId) {
        Cart entity=this.repo.findById(cartId).orElseThrow();
        return  entity;
    }
}
