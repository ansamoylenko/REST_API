package org.sadtech.example.jwt.server.domain;

import org.sadtech.example.jwt.server.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>
{
    //String value = "SELECT * from db.user where login = " + login;
    //@Query("SELECT * from db.user where login = " + login, nativeQuery = true)
    Optional<User> findDistinctByLogin(String login);
}
