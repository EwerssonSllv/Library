package com.ewersson.Library.Controller;

import com.ewersson.Library.Model.User.User;
import com.ewersson.Library.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Post new users
    @PostMapping
    public User create(@RequestBody User user){
        return userService.saveUser(user);
    }

    // Get users
    @GetMapping("/{id")
    public ResponseEntity<User> get(@PathVariable Integer id){
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update users
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User update){
        User user = userService.uptdateUser(id, update);
        return ResponseEntity.ok(user);
    }

    // Delete users
    @DeleteMapping("/{id")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
