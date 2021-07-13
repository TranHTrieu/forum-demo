package com.fsoft.demo.service;

import com.fsoft.demo.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> findAll();

    PostDTO findById(Long id);

    PostDTO updateTitle(Long id, String title);

    PostDTO updateContent(Long id, String content);
}
