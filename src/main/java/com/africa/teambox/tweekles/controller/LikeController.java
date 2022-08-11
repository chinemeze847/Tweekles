package com.africa.teambox.tweekles.controller;


import com.africa.teambox.tweekles.dto.LikeRequestDto;
import com.africa.teambox.tweekles.model.Like;
import com.africa.teambox.tweekles.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class LikeController {
    private final LikeService likeService;
    @PostMapping("/like/{postId}")
    public ResponseEntity<Like> likePost(@PathVariable String postId, @RequestBody LikeRequestDto request){
        return new ResponseEntity<>(likeService.likePost(postId, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/unlike/{likeId}")
    public ResponseEntity<?> unlikePost(@PathVariable String likeId, @RequestBody LikeRequestDto request){
        likeService.unlikePost(likeId, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/likes/{postId}/count")
    public ResponseEntity<Integer> getPostLikesCount(@PathVariable UUID postId){
        return new ResponseEntity<>(likeService.getPostLikesCount(String.valueOf(postId)), HttpStatus.OK);
    }
}
