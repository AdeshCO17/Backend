package com.adeshcoder.Backingfor30mincoding.Authentication.jwt;

import lombok.Data;

/**
 * @author Samson Effes
 */

@Data
public class
JWTAuthenticationRequest {
    private String userName;
    private String password;
}
