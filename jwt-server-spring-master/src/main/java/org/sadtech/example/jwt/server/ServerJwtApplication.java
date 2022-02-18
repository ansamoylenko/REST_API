package org.sadtech.example.jwt.server;

import org.sadtech.example.jwt.server.domain.User;
import org.sadtech.example.jwt.server.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


@SpringBootApplication
public class ServerJwtApplication {
    public static UserRepository ur;

    public static void main(String[] args) {
        SpringApplication.run(ServerJwtApplication.class, args);
    }

}
