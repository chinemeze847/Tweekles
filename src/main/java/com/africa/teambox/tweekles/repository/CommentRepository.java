package com.africa.teambox.tweekles.repository;


import com.africa.teambox.tweekles.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findCommentByPostId(UUID postId);
//    Integer findByCommentId(String postId);
}
