package com.project.blog.controller;

import com.project.blog.model.User;
import com.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //각각의 메소드의 반환물(return)이 body에 쓰게됨
@RequestMapping("/users") //users로 들어오는 모든 요청을 맞이한다
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("") // http://localhost:8080/에 대한 GET 요청을 처리하는 것입니다.?
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userid}")    //경로에 중괄호를 쓰면 그건 변수명이다.
    public User getUserByUserId(@PathVariable("userid") Integer userid) {
        return userService.getUserByUserId(userid);
    }

    @PostMapping("")
    public User registUser(@RequestBody User user) {
        System.out.println(user);
        return userService.registUser(user);
    }

    //Update
    @PutMapping("/{userid}")
    public void modifyUser(
            @PathVariable("userid") Integer userid,
            @RequestBody User user) {
        userService.modifyUser(user);
    }

    //Delete
    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable Integer userid) {
        userService.removeUser(userid);
    }


}
