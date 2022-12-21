package com.hoang.mynote.rest.controller;

import com.hoang.mynote.rest.model.InputCreateUser;
import com.hoang.mynote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/name")
    public Object saveName(@RequestBody InputCreateUser inputCreateUser,
                           HttpServletResponse response) {
        return userService.saveUser(inputCreateUser, response);
    }

    @GetMapping("/name/check")
    public Object checkName(@CookieValue (value = "username", defaultValue =" ") String username ){
        if (!StringUtils.hasText(username))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Guest Name is empty !!!");
        return userService.check(username);
    }
    @GetMapping("/logout")
    public Object logOut(HttpServletResponse response, HttpServletRequest request){return userService.logout(request,response);}
}
