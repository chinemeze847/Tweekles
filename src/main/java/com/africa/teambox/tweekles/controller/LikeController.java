package com.africa.teambox.tweekles.controller;


import com.africa.teambox.tweekles.dto.LikeRequestDto;
import com.africa.teambox.tweekles.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class LikeController {
    //like
    //unlike
    private final LikeService likeService;
    @PostMapping("/like/{postId}")
    public void likePost(@PathVariable String postId, @RequestBody LikeRequestDto request){
        likeService.likePost(postId, request);
    }

}
