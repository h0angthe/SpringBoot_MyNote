package com.hoang.mynote.service;

import com.hoang.mynote.rest.model.InputCreateTag;
import com.hoang.mynote.rest.model.InputCreateUser;
import com.hoang.mynote.infra.entity.User;
import com.hoang.mynote.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Object check(String username){
        List<User> users = userRepository.findByName(username);
        if (!CollectionUtils.isEmpty(users))
            return users.get(0);
        else
            return null;
    }
    public Object saveUser(InputCreateUser inputCreateUser, HttpServletResponse response){
        if (!StringUtils.hasText(inputCreateUser.getUsername()))
            return "Name is empty !!!";

        // add cookie to response
        Cookie cookie = new Cookie("username", inputCreateUser.getUsername());
        cookie.setMaxAge(100000000);
        response.addCookie(cookie);

        List<User> users = userRepository.findByName(inputCreateUser.getUsername());
        if(CollectionUtils.isEmpty(users)) {
            User user = new User();
            user.setName(inputCreateUser.getUsername());
            userRepository.save(user);
        }

        return "Add a User !!!";
    }
    public Object logout(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (cookies.length > 0)
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

        return "Log out !!!";
    }
}
