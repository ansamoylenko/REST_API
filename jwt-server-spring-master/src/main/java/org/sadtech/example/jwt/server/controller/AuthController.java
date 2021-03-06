package org.sadtech.example.jwt.server.controller;

import lombok.RequiredArgsConstructor;
import org.sadtech.example.jwt.server.ServerJwtApplication;
import org.sadtech.example.jwt.server.domain.*;
import org.sadtech.example.jwt.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor



public class AuthController {

   // @Autowired
    private UserRepository userRepository;

    private final AuthService authService;
    private final AuthService authService2;



    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) {
        final JwtResponse token = authService2.login(authRequest);
        return ResponseEntity.ok(token);
    }







//    @PostMapping("add")
//    public ResponseEntity<JwtResponse> add(@RequestBody JwtRequest authRequest)
//    {
//        //System.out.println("dddd");
//        final JwtResponse token = authService.login(authRequest);
//        ///User newUser = userRepository.save(user);
//        //return newUser.getId();
//        return ResponseEntity.ok(token);
//    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }



}
