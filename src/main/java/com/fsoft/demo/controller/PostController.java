package com.fsoft.demo.controller;

import com.fsoft.demo.dto.PostDTO;
import com.fsoft.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostDTO> getAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public PostDTO getPost(@PathVariable(value = "id") Long id){
        return postService.findById(id);
    }

    @PostMapping("/posts/{id}")
    public ResponseEntity<PostDTO> updateTitle(@PathVariable(value = "id") Long id,
                                               @RequestBody String title){
        PostDTO postUpdate = postService.updateTitle(id, title);
        return ResponseEntity.ok(postUpdate);
    }

    @PostMapping("/posts/{id}")
    public ResponseEntity<PostDTO> updateContent(@PathVariable(value = "id") Long id,
                                                 @RequestBody String content){
        PostDTO postUpdate = postService.updateContent(id, content);
        return ResponseEntity.ok(postUpdate);
    }
}
