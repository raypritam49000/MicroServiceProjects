package com.ray.pritam.userservice.controller;

import com.ray.pritam.userservice.entity.User;
import com.ray.pritam.userservice.service.UserService;
import com.ray.pritam.userservice.vo.ResponseTemplateVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

//    @GetMapping("/{id}")
//    public ResponseTemplateVO getUser(@PathVariable(value = "id") String userId) {
//        return userService.getUserWithDepartment(userId);
//    }

    @GetMapping(value = "/secure")
    public String getSecure() {
        return "Secure endpoint available";
    }

    @GetMapping("/hello")
    public ResponseEntity<?> helloPritam(){
        return ResponseEntity.ok(Map.of("message","Hello Pritam Ray"));
    }
}