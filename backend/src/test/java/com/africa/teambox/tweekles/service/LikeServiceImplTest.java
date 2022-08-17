package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.LikeRequestDto;
import com.africa.teambox.tweekles.model.Like;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.repository.LikeRepository;
import com.africa.teambox.tweekles.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LikeServiceImplTest {
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
    Post savedPost;
    @BeforeEach
    void setUp() {
        likeRequestDto = new LikeRequestDto();
        likeRequestDto.setUsername("Eze");

        post = new Post();
        post.setUsername("Modupe");
        post.setMessage("A senior backend dev");
        savedPost = postRepository.save(post);
    }

    @Test
    void shouldLikePostIfPostIdIsPresent() {
        Integer postCount = service.getPostLikesCount(String.valueOf(savedPost.getId()));

        like = new Like();
        like.setUsername("Eze");
        like.setPost(savedPost);

        service.likePost(String.valueOf(savedPost.getId()), likeRequestDto);
        Integer expectedCount = service.getPostLikesCount(String.valueOf(savedPost.getId()));

        assertEquals(expectedCount, postCount + 1);
    }

    @Test
    void shouldUnlikePostIfPostIdIsPresent() {
        like = new Like();
        like.setUsername("Eze");
        like.setPost(savedPost);
        Like likedPost = repository.save(like);

        Integer postCount = service.getPostLikesCount(String.valueOf(savedPost.getId()));
        service.unlikePost(String.valueOf(likedPost.getId()), likeRequestDto);

        Integer expectedCount = service.getPostLikesCount(String.valueOf(savedPost.getId()));

        assertEquals(expectedCount, postCount - 1);

    }

    @Test
    void getPostLikesCount() {
        like = new Like();
        like.setUsername("Eze");
        like.setPost(savedPost);

        repository.save(like);

        Integer expectedCount = service.getPostLikesCount(String.valueOf(savedPost.getId()));

        assertEquals(expectedCount, 1);
    }
}