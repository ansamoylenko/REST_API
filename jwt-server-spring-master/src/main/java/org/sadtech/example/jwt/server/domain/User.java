package org.sadtech.example.jwt.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sadtech.example.jwt.server.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String dateOfBirth;
    private String email;
    private String number;

    public User(String login, String password, String firstName, String lastName, String patronymic, String dateOfBirth, String email, String number)
    {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.number = number;
    }
    public Set<Role> getRoles()
    {
//        Set<Role> sr = new HashSet<>();
//        sr.addAll(Collections.singleton(Role.USER));
        return Collections.singleton(Role.USER);
    }
}
