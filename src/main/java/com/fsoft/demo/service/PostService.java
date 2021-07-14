package com.fsoft.demo.service;

import com.fsoft.demo.dto.PostDTO;
import com.fsoft.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface PostService {

    List<PostDTO> findAll();

    PostDTO findById(Long id) throws ResourceNotFoundException;

    PostDTO updateTitle(Long id, String title) throws ResourceNotFoundException;

    PostDTO updateContent(Long id, String content) throws ResourceNotFoundException;
}
