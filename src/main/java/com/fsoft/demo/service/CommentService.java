package com.fsoft.demo.service;

import com.fsoft.demo.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> findAll();

    CommentDTO save(CommentDTO newComment);

    CommentDTO findById(Long id);

    CommentDTO updateContent(Long id, String content);
}
