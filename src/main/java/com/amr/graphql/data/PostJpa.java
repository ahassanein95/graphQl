package com.amr.graphql.data;

import com.amr.graphql.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpa extends JpaRepository<Post, Long> {
}
