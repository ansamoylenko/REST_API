package org.sadtech.example.jwt.server.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.sadtech.example.jwt.server.ServerJwtApplication;
import org.sadtech.example.jwt.server.controller.Controller;
import org.sadtech.example.jwt.server.domain.User;
import org.sadtech.example.jwt.server.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final List<User> users;



    public Optional<User> getByLogin(@NonNull String login)
    {
        return ServerJwtApplication.ur.findDistinctByLogin(login);

//        return users.stream()
//                .filter(user -> login.equals(user.getLogin()))
//                .findFirst();
    }

}