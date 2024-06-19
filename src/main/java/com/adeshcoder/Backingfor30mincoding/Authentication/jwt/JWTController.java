package com.adeshcoder.Backingfor30mincoding.Authentication.jwt;


import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.exception.UserNotFoundException;
import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.user.User;
import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.user.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Samson Effes
 */


@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class JWTController {

    
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    private  final UserRepository userRepository;


    @PostMapping
    public String getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            System.out.println("successfully done");
            return jwtService.generateToken(authRequest.getUserName());

        }
        else {
            throw new UserNotFoundException("Invalid user credentials");
        }
    }
    @PostMapping("/check")
    public  DetailSharing checking(@RequestBody User user){

        User user1=userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if (authentication.isAuthenticated()){
            System.out.println("successfully done");
//            return jwtService.generateToken(user.getEmail());
            DetailSharing d=new DetailSharing(jwtService.generateToken(user.getEmail()),user1);
            return d;


        }
        else {
            throw new UserNotFoundException("Invalid user credentials");
        }
    }
}
