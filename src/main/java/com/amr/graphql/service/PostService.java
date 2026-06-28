package com.amr.graphql.service;

import com.amr.graphql.data.PostJpa;
import com.amr.graphql.data.UserJpa;
import com.amr.graphql.models.Post;
import com.amr.graphql.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostJpa postsRepository;
    private final UserJpa userRepository;

    public List<Post> getPosts(){
        return postsRepository.findAll();
    }

    public Post getPost(Long id) {
        return postsRepository.findById(id).orElse(null);
    }

    public Post createPost(String title, String content, Long authorId) {
        User author = userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();

        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        return postsRepository.save(post);
    }
}
