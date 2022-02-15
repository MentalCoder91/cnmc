package com.springboot.restapicnmc.Service;

import com.springboot.restapicnmc.Model.User;

import java.util.List;

public interface UserService {


    User saveUser(User user);


    User getUserByUserNameAndPassword(User user);

    List<User> getAllUsers();






}
