package com.ewersson.Library.Controller;

import com.ewersson.Library.Model.Books;
import com.ewersson.Library.Model.DTO.UserCreateDTO;
import com.ewersson.Library.Model.User;
import com.ewersson.Library.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/collection")
    public Set<Books> getUserPersonalCollection(@PathVariable Integer userId) {
        return userService.getUserPersonalCollection(userId);
    }

    // Post new users
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody UserCreateDTO obj) {
        User user = this.userService.fromDTO(obj);
        User newUser = this.userService.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    // Get users
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id){
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update users
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User update){
        User user = userService.update(id, update);
        return ResponseEntity.ok(user);
    }

    // Delete users
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
