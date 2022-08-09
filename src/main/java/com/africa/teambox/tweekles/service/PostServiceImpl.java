package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.PostRequestDto;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
   private final PostRepository postRepository;
    @Override
    public void createPost(PostRequestDto request) {
        Post post = new Post();
        post.setUsername(request.getUsername());
        post.setMessage(request.getMessage());
        postRepository.save(post);
    }
    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(UUID id) {
        return postRepository.findById(id);
    }
}
