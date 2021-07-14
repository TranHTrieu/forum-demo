package com.fsoft.demo.controller;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.exception.ResourceNotFoundException;
import com.fsoft.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<CommentDTO> getAllComments(){
        return commentService.findAll();
    }

    @GetMapping("/comments/{id}")
    public CommentDTO getComment(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return commentService.findById(id);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<CommentDTO> updateContent(@PathVariable(value = "id") Long id, @RequestBody String content) throws ResourceNotFoundException {
        CommentDTO comment = commentService.updateContent(id, content);
        return ResponseEntity.ok(comment);
    }
}
