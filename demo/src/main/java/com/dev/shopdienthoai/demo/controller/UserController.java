package com.dev.shopdienthoai.demo.controller;


import com.dev.shopdienthoai.demo.domain.User;
import com.dev.shopdienthoai.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user=this.userService.getUserById(id);
        //return ResponseEntity.status(HttpStatus.OK).body(user);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        User userCreate=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreate);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
       // return ResponseEntity.status(HttpStatus.OK).body("delete success");
        return ResponseEntity.ok("delete success");
    }
    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateUser=this.userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);
    }
}
