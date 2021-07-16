package com.fsoft.demo.controller;

import com.fsoft.demo.dto.PostDTO;
import com.fsoft.demo.exception.ResourceNotFoundException;
import com.fsoft.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

    @PostMapping("/posts")
    public PostDTO addPost(@RequestBody PostDTO newPost){
        return postService.save(newPost);
    }

    @GetMapping("/posts/{id}")
    public PostDTO getPost(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return postService.findById(id);
    }

    @PutMapping("/posts/title/{id}")
    public ResponseEntity<PostDTO> updateTitle(@PathVariable(value = "id") Long id,
                                               @RequestBody String title) throws ResourceNotFoundException {
        PostDTO postUpdate = postService.updateTitle(id, title);
        return ResponseEntity.ok(postUpdate);
    }

    @PutMapping("/posts/content/{id}")
    public ResponseEntity<PostDTO> updateContent(@PathVariable(value = "id") Long id,
                                                 @RequestBody String content) throws ResourceNotFoundException {
        PostDTO postUpdate = postService.updateContent(id, content);
        return ResponseEntity.ok(postUpdate);
    }
}
