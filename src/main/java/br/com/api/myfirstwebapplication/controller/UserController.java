package br.com.api.myfirstwebapplication.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.myfirstwebapplication.model.User;
import br.com.api.myfirstwebapplication.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/user/{id}")
    public User findUserById(@PathVariable("id") long id){
        return userService.findUserById(id);
    }

    @GetMapping(path = "/users")
    public List<User> findAll(){
        return userService.findAllUsers();
    }

    @PostMapping(path = "/new-user")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PatchMapping(path = "/update-email/{id}")
    public ResponseEntity<User> udpdateEmail(@PathVariable("id") long id, @RequestBody User user){
        return userService.updateUserEmail(id, user);
    }

    @PutMapping(path = "/update-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/delete-user/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        return userService.delete(id);
    }

}
