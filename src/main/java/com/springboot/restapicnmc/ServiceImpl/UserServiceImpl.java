package com.springboot.restapicnmc.ServiceImpl;


import com.springboot.restapicnmc.Repository.UserRepository;
import com.springboot.restapicnmc.Service.UserService;
import com.springboot.restapicnmc.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
          return userRepository.save(user);
    }



    @Override
    public User getUserByUserNameAndPassword(User user) {

        Optional<User> user1 = userRepository.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());

        if(!user1.isPresent()){
            System.out.println("User not Present");
        }

        return user1.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



}