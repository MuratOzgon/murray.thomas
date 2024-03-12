// UserController.java
package com.challenge.murray.thomas.controller;

import com.challenge.murray.thomas.model.User;
import com.challenge.murray.thomas.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginDetails) {
        User user = userService.findByUsername(loginDetails.getUsername());
        if (user != null && userService.matchesPassword(loginDetails.getPassword(), user.getPassword())) {
            return ResponseEntity.ok(userService.findUserByEmail(user.getEmail()).getId());
        } else {
            assert user != null;
            return ResponseEntity.status(401).body("Authentication failed"+ loginDetails.getPassword() + user.getPassword());
        }
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
