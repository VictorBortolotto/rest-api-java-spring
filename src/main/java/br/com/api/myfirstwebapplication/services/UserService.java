package br.com.api.myfirstwebapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.myfirstwebapplication.model.User;
import br.com.api.myfirstwebapplication.repository.UserRepository;

@Service
@Transactional
public class UserService {
    
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User findUserById(long id){
        return userRepository.findUserById(id);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<User> updateUserEmail(long id, User user){
        return userRepository.findById(id).map(record -> {
            record.setEmail(user.getEmail());
            User updatedUser = userRepository.save(record);
            return ResponseEntity.ok().body(updatedUser);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> updateUser(long id, User user){
        return userRepository.findById(id).map(record -> {
            record.setEmail(user.getEmail());
            record.setName(user.getName());
            record.setAge(user.getAge());
            User updatedUser = userRepository.save(record);
            return ResponseEntity.ok().body(updatedUser);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(long id){
        return userRepository.findById(id).map(record -> {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}