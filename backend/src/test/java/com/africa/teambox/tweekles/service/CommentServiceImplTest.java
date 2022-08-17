package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.CommentRequestDto;
import com.africa.teambox.tweekles.model.Comment;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.repository.CommentRepository;
import com.africa.teambox.tweekles.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import com.africa.teambox.tweekles.exception.MaximumLengthExceededException;
import com.africa.teambox.tweekles.exception.NotFoundException;
import com.africa.teambox.tweekles.repository.LikeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

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
    @Autowired
    LikeRepository likeRepository;

    @Autowired
    CommentServiceImpl commentService;

    private UUID postId;

    @BeforeEach
    void setUp() {
        commentRepository.deleteAll();
        likeRepository.deleteAll();
        postRepository.deleteAll();

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
    void shouldIncreaseNumberOfCommentsWhenCommentIsAdded() {
        post = new Post();
        post.setUsername("Modupe");
        post.setMessage("A senior backend dev");
        Post savedPost = postRepository.save(post);

        List<Comment> allComments1 = commentService.getAllComment(savedPost.getId());

        commentRequestDto = new CommentRequestDto("TestUserName", "Test Comment");
        commentService.addComment(String.valueOf(savedPost.getId()), commentRequestDto);

        List<Comment> allComments2 = commentService.getAllComment(savedPost.getId());

        assertEquals(allComments2.size(), allComments1.size() + 1);

    }

    @Test
    void shouldThrowNotFoundExceptionWhenPostIdDoesNotExist() {
        postId = UUID.fromString("16e3e6fa-10ab-4e30-9ed9-bfc2add3aa7f");

        commentRequestDto = new CommentRequestDto("TestUserName", "Test Comment");

        assertThrows(NotFoundException.class, () -> {
            commentService.addComment(String.valueOf(postId), commentRequestDto);
        });

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

    @Test
    void shouldThrowMaximumLengthExceededExceptionWhenCommentExceeds500Characters() {
        post = new Post();
        post.setUsername("Modupe");
        post.setMessage("A senior backend dev");
        Post savedPost = postRepository.save(post);

        String comment501Characters = "Loorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibu";

        commentRequestDto = new CommentRequestDto("TestUserName", comment501Characters );

        assertThrows(MaximumLengthExceededException.class, () -> {
            commentService.addComment(String.valueOf(savedPost.getId()), commentRequestDto);
        });

    }
}