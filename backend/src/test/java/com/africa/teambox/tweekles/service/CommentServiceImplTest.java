package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.CommentRequestDto;
import com.africa.teambox.tweekles.model.Comment;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.repository.CommentRepository;
import com.africa.teambox.tweekles.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CommentServiceImplTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentServiceImpl service;

    CommentRequestDto commentRequestDto;
    Post post;
    Post savedPost;

    @BeforeEach
    void setUp() {
        commentRequestDto =  new CommentRequestDto();
        commentRequestDto.setComment("This is a random comment");
        commentRequestDto.setUsername("Micheal");

        post = new Post();
        post.setUsername("John");
        post.setMessage("This is a new post");
        savedPost = postRepository.save(post);
    }
    @Test
    void shouldAddCommentIfPostIdIsPresent() {
        Comment comment = service.addComment(String.valueOf(savedPost.getId()), commentRequestDto);

        commentRepository.save(comment);
        assertThat(comment).isInstanceOf(Object.class);
        assertThat(comment).extracting("comment", "username")
                .doesNotContainNull()
                .containsExactly("This is a random comment", "Micheal");

    }

    @Test
    void getAllComment() {
        service.addComment(String.valueOf(savedPost.getId()), commentRequestDto);

        commentRepository.findCommentByPostId(savedPost.getId());
        List comments = service.getAllComment(savedPost.getId());

        assertThat(comments).isInstanceOf(Object.class);
        assertThat(comments).extracting("comment", "username")
                .doesNotContainNull();
    }
}