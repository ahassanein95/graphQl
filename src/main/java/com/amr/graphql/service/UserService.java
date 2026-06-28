package com.amr.graphql.service;

import com.amr.graphql.data.UserJpa;
import com.amr.graphql.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    //to do remove
    private final UserJpa userRespository;

    public List<User> getAllUsers() {
        return userRespository.findAll();
    }

    public User getUser(Long id) {
        return userRespository.findById(id).orElse(null);
    }

    public User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRespository.save(user);
    }


}
