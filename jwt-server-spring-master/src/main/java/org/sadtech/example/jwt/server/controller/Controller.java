package org.sadtech.example.jwt.server.controller;

import lombok.RequiredArgsConstructor;
import org.sadtech.example.jwt.server.ServerJwtApplication;
import org.sadtech.example.jwt.server.domain.*;
import org.sadtech.example.jwt.server.domain.User;
import org.sadtech.example.jwt.server.domain.UserRepository;
import org.sadtech.example.jwt.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class Controller {

    private final AuthService authService;
    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("hello/user")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();

        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("hello/admin")
    public ResponseEntity<String> helloAdmin() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello admin " + authInfo.getPrincipal() + "!");
    }

    @PostMapping("user/add")
    public ResponseEntity<Integer> add(@RequestBody User user)
    {
        System.out.println(userRepository);
        System.out.println(user.getFirstName());
        ServerJwtApplication.ur = this.userRepository;
        System.out.println(ServerJwtApplication.ur);

        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser.getId());
    }



}