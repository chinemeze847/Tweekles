package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.CommentRequestDto;
import com.africa.teambox.tweekles.model.Comment;

public interface CommentService {
    Comment addComment(String postId, CommentRequestDto request);
}
