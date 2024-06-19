package com.adeshcoder.Backingfor30mincoding.Authentication.jwt;

import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DetailSharing {
    private  String Token;
    private User user;
}
