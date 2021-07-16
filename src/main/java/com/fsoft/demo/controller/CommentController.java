package com.fsoft.demo.controller;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.exception.ResourceNotFoundException;
import com.fsoft.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "*")
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

    @PostMapping
    public CommentDTO saveComment(@RequestBody CommentDTO newComment){
        return commentService.save(newComment);
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
