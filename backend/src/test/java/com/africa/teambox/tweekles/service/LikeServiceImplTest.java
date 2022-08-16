package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.LikeRequestDto;
import com.africa.teambox.tweekles.model.Like;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.repository.LikeRepository;
import com.africa.teambox.tweekles.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class LikeServiceTest {
//    @InjectMocks
    @Autowired
    LikeServiceImpl service;
    @Autowired
    LikeRepository repository;

    @Autowired
    PostServiceImpl postService;
   @Autowired
    PostRepository postRepository;

    LikeRequestDto likeRequestDto;
    private UUID postId;
    Post post;
    Like like;
    @BeforeEach
    void setUp() {
        postId = UUID.fromString("16e3e6fa-10ab-4e30-9ed9-bfc2add3aa7f");

        likeRequestDto = new LikeRequestDto();
        likeRequestDto.setUsername("Eze");
    }

    @Test
    void shouldLikePostIfPostIdIsPresent() {

        post = new Post();
        post.setUsername("Modupe");
        post.setMessage("A senior backend dev");
        Post savedPost = postRepository.save(post);
        Integer count1 = service.getPostLikesCount(String.valueOf(savedPost.getId()));

        like = new Like();
        like.setUsername("Eze");
        like.setPost(savedPost);

        service.likePost(String.valueOf(savedPost.getId()), likeRequestDto);
        Integer count2 = service.getPostLikesCount(String.valueOf(savedPost.getId()));

        assertEquals(count2, count1 + 1);
    }

    @Test
    @Disabled
    void shouldUnlikePostIfPostIdIsPresent() {

        Post post1 = new Post();
        post1.setId(UUID.fromString("16e3e6fb-10ab-4e30-9ed9-bfc2add3aa7f"));
        post1.setUsername("Mary");
        post1.setMessage("We are testing stuff");

        Like likes = new Like();
        likes.setPost(post1);
        likes.setUsername("Eze");
        likes.setId(UUID.fromString("16e3e6fb-10ab-4e30-9ed9-bfc2add3af2f"));

        when(repository.findById(likes.getId())).thenReturn(Optional.of(likes));
        Mockito.doNothing().when(repository).delete(likes);
        service.unlikePost(String.valueOf(likes.getId()), likeRequestDto);
        verify(repository).delete(likes);

    }

    @Test
    @Disabled
    void getPostLikesCount() {

    }
}