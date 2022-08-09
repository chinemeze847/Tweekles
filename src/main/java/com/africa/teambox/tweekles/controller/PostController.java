package com.africa.teambox.tweekles.controller;
import com.africa.teambox.tweekles.dto.PostRequestDto;
import com.africa.teambox.tweekles.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/post")
public class PostController {
    private final PostService postService;

    @PostMapping()
    public ResponseEntity<?> createPost(@RequestBody PostRequestDto request){
        postService.createPost(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
