package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.entity.Comment;
import com.fsoft.demo.exception.ResourceNotFoundException;
import com.fsoft.demo.repository.CommentRepository;
import com.fsoft.demo.service.CommentService;
import com.fsoft.demo.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private MapUtils mapUtils;

    @Autowired
    public CommentServiceImpl(MapUtils mapUtils, CommentRepository commentRepository){
        this.mapUtils = mapUtils;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDTO> findAll() {
        List<Comment> rs = commentRepository.findAll();
        List<CommentDTO> rsDTO = new ArrayList<>();
        for (Comment comment : rs){
            rsDTO.add((CommentDTO) mapUtils.mapper(comment));
        }
        return rsDTO;
    }

    @Override
    public CommentDTO save(CommentDTO newCommentDTO) {
        Comment newComment = commentRepository.save((Comment) mapUtils.mapper(newCommentDTO));
        return (CommentDTO)mapUtils.mapper(newComment);
    }

    @Override
    public CommentDTO findById(Long id) throws ResourceNotFoundException {
        Comment rs = commentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Comment not found for this id " + id));
        return (CommentDTO) mapUtils.mapper(rs);
    }

    @Override
    public CommentDTO updateContent(Long id, String content) throws ResourceNotFoundException {
        CommentDTO comment = findById(id);
        comment.setContent(content);
        return save(comment);
    }
}
