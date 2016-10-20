package com.hzm.boot.controller;

import com.hzm.boot.domain.User;
import com.hzm.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(@RequestParam int userId, HttpServletRequest request){
        System.out.println("UserId:"+userId);

        request.getSession().setAttribute("hello", "hello world");
        return userService.getUser(userId);
    }

}
