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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LikeServiceTest
{
    @InjectMocks
    LikeServiceImpl service;
    @Mock
    LikeRepository repository;

    @Mock
    PostRepository postRepository;

    @Mock
    LikeRequestDto likeRequestDto;
    private UUID postId;
    Post post;
    Like like;
    @BeforeEach
    void setUp() {
        postId = UUID.fromString("16e3e6fa-10ab-4e30-9ed9-bfc2add3aa7f");

        likeRequestDto = new LikeRequestDto();
        likeRequestDto.setUsername("Eze");

        post = new Post();
        post.setUsername("Modupe");
        post.setMessage("A senior backend dev");
        post.setId(postId);

        like = new Like();
        like.setUsername("Eze");
        like.setPost(post);
    }

    @Test
    void shouldLikePostIfPostIdIsPresent()
    {
        when(repository.save(like)).thenReturn(like);
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        Like actualLike = service.likePost(String.valueOf(postId), likeRequestDto);

        assertThat(actualLike).isEqualTo(like);
    }

    @Test
    @Disabled
    void unlikePost() {
    }

    @Test
    @Disabled
    void getPostLikesCount()
    {
    }
}