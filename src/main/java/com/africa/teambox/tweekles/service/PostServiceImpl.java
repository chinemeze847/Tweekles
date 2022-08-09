package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.PostRequestDto;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
   private final PostRepository postRepository;
    @Override
    public void createPost(PostRequestDto request) {
        Post post = new Post();
        post.setUsername(request.getUserName());
        post.setMessage(request.getMessage());
        postRepository.save(post);

    }
}
