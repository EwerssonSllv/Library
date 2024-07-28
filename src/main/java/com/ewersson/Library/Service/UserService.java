package com.ewersson.Library.Service;

import com.ewersson.Library.Model.User.User;
import com.ewersson.Library.Repository.UserRepository;
import com.ewersson.Library.Service.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Integer id){
        User user = userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("User Not Found! Id:" + id + "Type: " + User.class.getName()));
    return userRepository.findById(id);
    }

    public void deleteUserById(Integer id){
        User user = userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("User Not Found!"));
        userRepository.deleteById(id);
    }

    public User uptdateUser(Integer id, User updatedUser){
        User user = userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("User Not Found!"));
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
    return userRepository.save(user);
    }

}
