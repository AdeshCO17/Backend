package com.adeshcoder.Backingfor30mincoding.repositories;

import com.adeshcoder.Backingfor30mincoding.Entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepo extends JpaRepository<Cart,Integer> {
}
