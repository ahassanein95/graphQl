package com.amr.graphql.controller;

import com.amr.graphql.data.PostJpa;
import com.amr.graphql.data.UserJpa;
import com.amr.graphql.models.Post;
import com.amr.graphql.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostsController {
    private final PostService postService;

    @QueryMapping
    public List<Post> posts() {
        return postService.getPosts();
    }

    @QueryMapping
    public Post post(@Argument Long id){
        return postService.getPost(id);
    }

    @MutationMapping
    public Post createPost(
            @Argument String title,
            @Argument String content,
            @Argument Long authorId
    ) {
       return postService.createPost(title, content, authorId);
    }
}
