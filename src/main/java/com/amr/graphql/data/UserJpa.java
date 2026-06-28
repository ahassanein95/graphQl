package com.amr.graphql.data;

import com.amr.graphql.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User, Long> {
}
