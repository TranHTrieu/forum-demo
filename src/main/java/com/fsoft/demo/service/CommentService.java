package com.fsoft.demo.service;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface CommentService {

    List<CommentDTO> findAll();

    CommentDTO findById(Long id) throws ResourceNotFoundException;

    List<CommentDTO> findCommentsByPost(Long postId) throws ResourceNotFoundException;

    List<CommentDTO> findCommentsByAccount(Long accountId) throws ResourceNotFoundException;

    CommentDTO save(Long postId, CommentDTO newComment) throws ResourceNotFoundException;

    CommentDTO updateContent(Long id, String content) throws ResourceNotFoundException;
}
