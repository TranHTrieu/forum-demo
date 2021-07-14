package com.fsoft.demo.service;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface CommentService {

    List<CommentDTO> findAll();

    CommentDTO save(CommentDTO newComment);

    CommentDTO findById(Long id) throws ResourceNotFoundException;

    CommentDTO updateContent(Long id, String content) throws ResourceNotFoundException;
}
