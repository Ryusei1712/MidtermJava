package com.example.midtermjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        // Check if the email is already registered
        if (userService.isUserExists(user.getEmail())) {
            return new ResponseEntity<>("Email is already registered", HttpStatus.BAD_REQUEST);
        }

        // Encode the password before saving to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.registerUser(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Validate user credentials (you can use Spring Security for more advanced features)
        if (userService.validateUser(user.getEmail(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }
}

