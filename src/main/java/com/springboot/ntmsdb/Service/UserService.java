package com.springboot.ntmsdb.Service;

import com.springboot.ntmsdb.Model.User;

import java.util.List;

public interface UserService {


    User saveUser(User user);


    User getUserByUserNameAndPassword(User user);

    List<User> getAllUsers();






}
