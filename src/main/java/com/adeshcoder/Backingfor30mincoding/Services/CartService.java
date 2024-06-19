package com.adeshcoder.Backingfor30mincoding.Services;

import com.adeshcoder.Backingfor30mincoding.Entities.Cart;
import com.adeshcoder.Backingfor30mincoding.payloads.CartDto;

import java.util.List;

public interface CartService {
      CartDto create(CartDto cart,Integer courseId);

       List<CartDto> getAll();

       void  delete(Integer cartId);

      Cart getById(Integer cartId);
}
