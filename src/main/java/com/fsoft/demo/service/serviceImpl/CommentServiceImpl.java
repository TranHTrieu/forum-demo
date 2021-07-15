package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.entity.Comment;
import com.fsoft.demo.exception.ResourceNotFoundException;
import com.fsoft.demo.repository.CommentRepository;
import com.fsoft.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    private Object mapper(Object obj){
        if (obj instanceof Comment){
            CommentDTO rs = new CommentDTO();
            rs.setContent(((Comment) obj).getContent());
            return rs;
        }
        if (obj instanceof CommentDTO){
            Comment rs = new Comment();
            rs.setContent(((CommentDTO) obj).getContent());
            return rs;
        }
        return null;
    }

    @Override
    public List<CommentDTO> findAll() {
        List<Comment> rs = commentRepository.findAll();
        List<CommentDTO> rsDTO = new ArrayList<>();
        for (Comment comment : rs){
            rsDTO.add((CommentDTO) mapper(comment));
        }
        return rsDTO;
    }

    @Override
    public CommentDTO save(CommentDTO newCommentDTO) {
        Comment newComment = commentRepository.save((Comment) mapper(newCommentDTO));
        return (CommentDTO)mapper(newComment);
    }

    @Override
    public CommentDTO findById(Long id) throws ResourceNotFoundException {
        Comment rs = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id " + id));
        return (CommentDTO) mapper(rs);
    }

    @Override
    public CommentDTO updateContent(Long id, String content) throws ResourceNotFoundException {
        CommentDTO comment = findById(id);
        comment.setContent(content);
        return save(comment);
    }
}
