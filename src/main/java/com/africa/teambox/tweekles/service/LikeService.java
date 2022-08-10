package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.LikeRequestDto;

public interface LikeService {

    void likePost(String postId, LikeRequestDto request);
}
