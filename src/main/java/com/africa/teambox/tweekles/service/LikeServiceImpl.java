package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.LikeRequestDto;
import com.africa.teambox.tweekles.exception.NotFoundException;
import com.africa.teambox.tweekles.model.Like;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.repository.LikeRepository;
import com.africa.teambox.tweekles.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService{

    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    @Override
    public Like likePost(String postId, LikeRequestDto request) {
        Post post = postRepository.findById(UUID.fromString(postId))
                .orElseThrow(() -> new NotFoundException("Id not found"));


       Like like = new Like();

       like.setUsername(request.getUsername());
       like.setIsLiked(true);
       like.setPost(post);
        return likeRepository.save(like);
    }
}
