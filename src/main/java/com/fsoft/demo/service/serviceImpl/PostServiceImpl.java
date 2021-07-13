package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.PostDTO;
import com.fsoft.demo.repository.PostRepository;
import com.fsoft.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDTO> findAll() {
        return null;
    }

    @Override
    public PostDTO findById(Long id) {
        return null;
    }

    @Override
    public PostDTO updateTitle(Long id, String title) {
        PostDTO post = findById(id);
        post.setTitle(title);
        return post;
    }

    @Override
    public PostDTO updateContent(Long id, String content) {
        PostDTO post = findById(id);
        post.setContent(content);
        return post;
    }
}
