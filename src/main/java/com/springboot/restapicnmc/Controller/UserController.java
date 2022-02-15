package com.springboot.restapicnmc.Controller;


import com.springboot.restapicnmc.Model.User;
import com.springboot.restapicnmc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/hello")
    public  String helloUSer()
    {
            return "Hello User !!!!!!!!!";

    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){

        return new ResponseEntity<List<User>>(userService.getAllUsers() , HttpStatus.OK);
    }


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<User> getLoginUser(@RequestBody User user){
        String username = user.getUsername();
        System.out.println("This is username: "+username);

        return new ResponseEntity<User>(userService.getUserByUserNameAndPassword(user) , HttpStatus.OK);
    }


    @PostMapping("/saveAll")
    public ResponseEntity<User> insertUser(@RequestBody User user){

        System.out.println("Inside insertUser");

        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }





















}
