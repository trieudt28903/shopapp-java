package com.dev.shopdienthoai.demo.service;

import com.dev.shopdienthoai.demo.domain.User;
import com.dev.shopdienthoai.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void saveUser(User user){
         userRepository.save(user);
    }
}
