package com.africa.teambox.tweekles.controller;
import com.africa.teambox.tweekles.dto.PostRequestDto;
import com.africa.teambox.tweekles.model.Post;
import com.africa.teambox.tweekles.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@RequestBody @Valid PostRequestDto request){
        return new ResponseEntity<>(postService.createPost(request), HttpStatus.CREATED);
    }
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPost(){
        List<Post> posts = postService.getAllPost();
        return ResponseEntity.ok(posts);
    }
    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable UUID id) {
        Optional<Post> post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }
}
