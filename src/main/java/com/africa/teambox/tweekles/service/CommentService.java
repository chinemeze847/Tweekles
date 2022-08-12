package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.CommentRequestDto;
import com.africa.teambox.tweekles.model.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    Comment addComment(String postId, CommentRequestDto request);

    List<Comment> getAllComment(UUID postId);

//    Integer getPostCommentCount(String postId);
}
