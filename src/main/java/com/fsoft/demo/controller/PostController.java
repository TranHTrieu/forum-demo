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
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.findAll();
    }

    @PostMapping
    public PostDTO addPost(@RequestBody PostDTO newPost){
        return postService.save(newPost);
    }

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return postService.findById(id);
    }

    @PutMapping("/title/{id}")
    public ResponseEntity<PostDTO> updateTitle(@PathVariable(value = "id") Long id,
                                               @RequestBody String title) throws ResourceNotFoundException {
        PostDTO postUpdate = postService.updateTitle(id, title);
        return ResponseEntity.ok(postUpdate);
    }

    @PutMapping("/content/{id}")
    public ResponseEntity<PostDTO> updateContent(@PathVariable(value = "id") Long id,
                                                 @RequestBody String content) throws ResourceNotFoundException {
        PostDTO postUpdate = postService.updateContent(id, content);
        return ResponseEntity.ok(postUpdate);
    }
}
