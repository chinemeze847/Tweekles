package com.africa.teambox.tweekles.controller;

import com.africa.teambox.tweekles.dto.CommentRequestDto;
import com.africa.teambox.tweekles.dto.PostRequestDto;
import com.africa.teambox.tweekles.service.CommentService;
import com.africa.teambox.tweekles.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comments/{postId}")
    public ResponseEntity<?> addComment(@PathVariable String postId, @RequestBody CommentRequestDto request){
        return new ResponseEntity<>(commentService.addComment(postId, request), HttpStatus.CREATED);
    }




}
