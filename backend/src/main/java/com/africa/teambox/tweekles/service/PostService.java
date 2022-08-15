package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.PostRequestDto;
import com.africa.teambox.tweekles.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostService {
    Post createPost(PostRequestDto request);

    List<Post> getAllPost();
    Optional<Post> getPostById(UUID id);
}
