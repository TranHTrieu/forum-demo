package com.fsoft.demo.controller;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.exception.ResourceNotFoundException;
import com.fsoft.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDTO> getAllComments(){
        return commentService.findAll();
    }

    @GetMapping("/post/{id}")
    public List<CommentDTO> getAllCommentsByPost(@PathVariable(value = "id") Long postId) throws ResourceNotFoundException {
        return commentService.findCommentsByPost(postId);
    }

    @GetMapping("/account/{id}")
    public List<CommentDTO> getAllCommentsByAccount(@PathVariable(value = "id") Long accountId) throws ResourceNotFoundException {
        return commentService.findCommentsByAccount(accountId);
    }

    @PostMapping("/post/{id}")
    public CommentDTO saveComment(@PathVariable(value = "id") Long postId, @RequestBody CommentDTO newComment) throws ResourceNotFoundException {
        return commentService.save(postId, newComment);
    }

    @GetMapping("/{id}")
    public CommentDTO getComment(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return commentService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateContent(@PathVariable(value = "id") Long id, @RequestBody String content) throws ResourceNotFoundException {
        CommentDTO comment = commentService.updateContent(id, content);
        return ResponseEntity.ok(comment);
    }
}
