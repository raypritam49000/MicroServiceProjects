package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.service.UserService;
import com.dailycodebuffer.user.vo.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
       return this.userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("userId") Long userId){
        log.info("Inside getUserWithDepartment of UserController");
        ResponseTemplateVo  responseTemplateVo = this.userService.getUserWithDepartment(userId);
        return responseTemplateVo;
    }
}
