package com.amr.graphql.controller;

import com.amr.graphql.models.User;
import com.amr.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class UserController {

    public final UserService userService;
    @QueryMapping
    public List<User> users() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User user(@Argument Long id){
        return userService.getUser(id);
    }

    @MutationMapping
    public User createUser(
            @Argument String name,
            @Argument String email
    ) {
        return userService.createUser(name, email);
    }
}
