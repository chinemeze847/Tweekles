package com.africa.teambox.tweekles.repository;

import com.africa.teambox.tweekles.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
//    Post findPostById(String UUID);
}
