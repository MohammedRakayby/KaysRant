//package com.rakayby.blog.util;
//
//import com.rakayby.blog.model.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Mohammed.Rakayby
// */
//@RequiredArgsConstructor
//@Service
//public class UserUtils {
//
//    private final PasswordEncoder passwordEncoder;
//
//    public void encodeUserPassword(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//    }
//
////    public Boolean passwordMatch(String storedPassword, String submittedPassword) {
////        return passwordEncoder.matches(storedPassword, submittedPassword);
////    }
//}
