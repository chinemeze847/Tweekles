package com.africa.teambox.tweekles.controller;


import com.africa.teambox.tweekles.dto.LikeRequestDto;
import com.africa.teambox.tweekles.model.Like;
import com.africa.teambox.tweekles.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Like> likePost(@PathVariable String postId, @RequestBody LikeRequestDto request){
        return new ResponseEntity<Like>(likeService.likePost(postId, request), HttpStatus.CREATED);
    }

}
