package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.repository.CommentRepository;
import com.fsoft.demo.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDTO> findAll() {
        return null;
    }

    @Override
    public CommentDTO save(CommentDTO newComment) {
        return null;
    }

    @Override
    public CommentDTO findById(Long id) {
        return null;
    }

    @Override
    public CommentDTO updateContent(Long id, String content) {
        CommentDTO comment = findById(id);
        comment.setContent(content);
        return save(comment);
    }
}
