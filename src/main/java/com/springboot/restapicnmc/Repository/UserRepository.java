package com.springboot.restapicnmc.Repository;

import com.springboot.restapicnmc.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {



    @Query(value ="select user_id,password,ssa_id,circle_id from user_master where user_id = ?1 and password = ?2" ,nativeQuery = true)
    Optional<User> findUserByUsernameAndPassword(String username,String password);

}
