package com.main.project.java.Service;

import com.main.project.java.Entity.User;
import com.main.project.java.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }
    public void saveUser(User user){
        this.userRepository.save(user);

    }
    public User getUserById(int userId){
        Optional<User> optional = userRepository.findById(userId);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("---------- User not found---------- " + userId);
        }
        return user;
    }

    public void deleteUserById(int userId){
        this.userRepository.deleteById(userId);

    }

}
