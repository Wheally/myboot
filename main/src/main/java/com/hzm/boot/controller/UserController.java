package com.hzm.boot.controller;

import com.hzm.boot.domain.User;
import com.hzm.boot.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
@Api("UserController相关接口说明")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据用户Id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", dataType = "String", required = true, value = "用户Id")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没写对"),
            @ApiResponse(code = 404, message = "请求的路劲不存在")
    })
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(@RequestParam int userId, HttpServletRequest request){
        System.out.println("UserId:"+userId);
        
        request.getSession().setAttribute("hello", "hello world");
        return userService.getUser(userId);
    }

}
