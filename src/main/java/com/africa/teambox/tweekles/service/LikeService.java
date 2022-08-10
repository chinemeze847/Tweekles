package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.dto.LikeRequestDto;
import com.africa.teambox.tweekles.model.Like;

public interface LikeService {

    Like likePost(String postId, LikeRequestDto request);
}
