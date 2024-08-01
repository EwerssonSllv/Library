package com.ewersson.Library.Controller;

import com.ewersson.Library.Model.Book.Books;
import com.ewersson.Library.Model.User.AuthenticationDTO;
import com.ewersson.Library.Model.User.LoginResponseDTO;
import com.ewersson.Library.Model.User.RegisterDTO;
import com.ewersson.Library.Model.User.User;
import com.ewersson.Library.Repository.UserRepository;
import com.ewersson.Library.Security.TokenService;
import com.ewersson.Library.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/{userId}/collection")
    public Set<Books> getUserPersonalCollection(@PathVariable Integer userId) {
        return userService.getUserPersonalCollection(userId);
    }

    // Post new users

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), data.role(), encryptedPassword);

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
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
