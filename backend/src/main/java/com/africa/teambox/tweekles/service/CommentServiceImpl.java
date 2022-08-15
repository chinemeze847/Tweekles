package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.CommentRequestDto;
import com.africa.teambox.tweekles.exception.MaximumLengthExceededException;
import com.africa.teambox.tweekles.exception.NotFoundException;
import com.africa.teambox.tweekles.model.Comment;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.repository.CommentRepository;
import com.africa.teambox.tweekles.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    @Override
    public Comment addComment(String postId, CommentRequestDto request) {

        Post post = postRepository.findById(UUID.fromString(postId))
                .orElseThrow(() -> new NotFoundException("Id not found"));

        if ((request.getComment()).length() > 500) {
            throw new MaximumLengthExceededException("Character literals should not be more than 500");
        }

        Comment comment = new Comment();
        comment.setComment(request.getComment());
        comment.setUsername(request.getUsername());
        comment.setPost(post);

        return commentRepository.save(comment);
    }


    @Override
    public List<Comment> getAllComment(UUID postId) {
        return commentRepository.findCommentByPostId(postId);
    }


//    @Override
//    public Integer getPostCommentCount(String postId) {
////        return commentRepository.findByCommentId(postId);
//    }
}
