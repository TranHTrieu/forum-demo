package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.dto.PostDTO;
import com.fsoft.demo.entity.Account;
import com.fsoft.demo.entity.Comment;
import com.fsoft.demo.entity.Post;
import com.fsoft.demo.exception.ResourceNotFoundException;
import com.fsoft.demo.repository.AccountRepository;
import com.fsoft.demo.repository.CommentRepository;
import com.fsoft.demo.repository.PostRepository;
import com.fsoft.demo.service.CommentService;
import com.fsoft.demo.utils.MapUtils;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private MapUtils mapUtils;
    private AccountRepository accountRepository;

    @Autowired
    public CommentServiceImpl(MapUtils mapUtils,
                              CommentRepository commentRepository,
                              PostRepository postRepository,
                              AccountRepository accountRepository){
        this.mapUtils = mapUtils;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.accountRepository = accountRepository;
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
    public List<CommentDTO> findCommentsByPost(Long postId) throws ResourceNotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("Post not found for this id " + postId));
        List<Comment> comments = commentRepository.findCommentsByPost(post);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for(Comment comment : comments){
            CommentDTO commentDTO = (CommentDTO) mapUtils.mapper(comment);
            commentDTOS.add(commentDTO);
        }
        return commentDTOS;
    }

    @Override
    public List<CommentDTO> findCommentsByAccount(Long accountId) throws ResourceNotFoundException {
        Account account = accountRepository.findById(accountId).orElseThrow(() ->
                new ResourceNotFoundException("Account not found for this id: " + accountId));
        List<Comment> comments = commentRepository.findCommentsByAccount(account);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment comment : comments){
            CommentDTO commentDTO = (CommentDTO) mapUtils.mapper(comment);
            commentDTOS.add(commentDTO);
        }
        return commentDTOS;
    }

    @Override
    public CommentDTO save(Long postId, CommentDTO newCommentDTO) throws ResourceNotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("Account not found for this id: " + postId));
        PostDTO postDTO = (PostDTO) mapUtils.mapper(post);
        newCommentDTO.setPostDTO(postDTO);
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
//        CommentDTO comment = findById(id);
//        comment.setContent(content);
//        return save(comment);
        return null;
    }
}
