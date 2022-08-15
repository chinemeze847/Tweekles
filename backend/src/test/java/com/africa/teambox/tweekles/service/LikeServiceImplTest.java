package com.africa.teambox.tweekles.service;

import com.africa.teambox.tweekles.repository.LikeRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class LikeServiceTest
{

    LikeService service;

    LikeRepository repository;

    @Test
    void likePost()
    {

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