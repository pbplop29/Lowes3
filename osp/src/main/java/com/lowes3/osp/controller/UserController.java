package com.lowes3.osp.controller;

import com.lowes3.osp.entity.User;
import com.lowes3.osp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService UserService;

    //http://localhost:8080/saveUser
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User User) {
        User User1 = UserService.saveUser(User);
        return User1;
    }

    //http://localhost:8080/getUser/1
    @GetMapping("/getUser/{UserId}")
    public User getUserById(@PathVariable("UserId") Integer UserId) {
        return UserService.getUserById(UserId);
    }

    //http://localhost:8080/updateUser
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User User){
        return UserService.updateUser(User);
    }

    //http://localhost:8080/deleteUser/1
    @DeleteMapping("/deleteUser/{UserId}")
    public String deleteUserByID(@PathVariable("UserId") Integer UserId){
        String checkIfDeleted = UserService.deleteUserById(UserId);
        return checkIfDeleted;
    }
}
