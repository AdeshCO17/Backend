package com.adeshcoder.Backingfor30mincoding.Authentication.jwt.security;

import com.adeshcoder.Backingfor30mincoding.Authentication.jwt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Samson Effes
 */

@Component
public class LibraryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(LibraryUserDetails::new)      // use to convert the user to userdetails
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}
