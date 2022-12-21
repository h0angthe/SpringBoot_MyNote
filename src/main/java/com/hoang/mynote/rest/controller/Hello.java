//package com.hoang.mynote.rest.controller;
//
//
//import com.hoang.mynote.domain.HelloService;
//import com.hoang.mynote.infra.model.Customer;
//import com.hoang.mynote.rest.model.InputHello;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//public class Hello {
//    @Autowired
//    HelloService helloService;
//
//    @GetMapping("/hello")
//    public String hello (@RequestBody InputHello input) {
//        return "Hello world";
//    }
//
//    @PostMapping("/hello/guest")
//    public String hello2 (@RequestBody InputHello input) {
//        return "Hello " + input.getName();
//    }
//
//
//    @GetMapping("/customer")
//    public List<Customer> customer (@RequestBody InputHello input) {
//        return helloService.getCustomerList();
//    }
//
//    @GetMapping("/customer/{id}")
//    public Customer getcustomerbyID (@PathVariable("id") int id  ) {
//        return helloService.searchId(id);
//    }
//
//    @GetMapping("/customer/search")
//    public List<Customer> getcustomerbyName (@RequestParam(name = "name") String name) {
//        return helloService.getCustomerbyName(name);
//    }
//
//    @PostMapping("/customer")
//    public String addNew (@RequestBody InputHello input) {
//        Customer customer = new Customer();
//        customer.setName(input.getName());
//        customer.setAge(input.getAge());
//        return helloService.addNew(customer);
//    }
//
//    @PutMapping("/customer")
//    public String put (@RequestBody InputHello input) {
//        Customer customer = new Customer();
//        customer.setId(input.getId());
//        customer.setName(input.getName());
//        customer.setAge(input.getAge());
//
//        return helloService.put(customer);
//    }
//
//    @DeleteMapping("/customer")
//    public String del (@RequestBody InputHello input) {
//        Customer customer = new Customer();
//        customer.setId(input.getId());
//
//        return helloService.del(customer);
//    }
//    @GetMapping("/add")
//    public String setCookie(HttpServletResponse response) {
//        // create a cookie
//        Cookie cookies = new Cookie("username", "the");
//        //add a cookie to the response
//        response.addCookie(cookies);
//
//        return "Username is changed!";
//    }
//    @GetMapping("/read")
//    public String read(@CookieValue(value = "username", defaultValue = "Atta") String username){
//        return username;
//    }
//
//    @GetMapping("/name/check")
//        public Object checkName(@CookieValue(value = "username", defaultValue =" ") String username) {
//            if (!StringUtils.hasText(username));
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(username);
//        }
//    @GetMapping("/name")
//    public String Name(@RequestParam(name = "username" ) String username,
//        HttpServletResponse response) {
//        if (StringUtils.hasText(username))
//            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Guest Name is empty !!!");
//        Cookie cookies = new Cookie("username", username);
//        response.addCookie(cookies);
//
//        return "Username";
//    }
//
//}
