package com.africa.teambox.tweekles.controller;

import com.africa.teambox.tweekles.dto.CommentRequestDto;
import com.africa.teambox.tweekles.dto.PostRequestDto;
import com.africa.teambox.tweekles.model.Comment;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.service.CommentService;
import com.africa.teambox.tweekles.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<Comment>> getComment(@PathVariable UUID postId){
        List<Comment> comments = commentService.getAllComment(postId);
        return ResponseEntity.ok(comments);
    }

//    @GetMapping("/comments/{postId}/count")
//    public ResponseEntity<Integer> getPostCommentCount(@PathVariable UUID postId){
//        return new ResponseEntity<>(commentService.getPostCommentCount(String.valueOf(postId)), HttpStatus.OK);
//    }

}
