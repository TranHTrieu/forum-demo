package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.dto.PostDTO;
import com.fsoft.demo.entity.Comment;
import com.fsoft.demo.entity.Post;
import com.fsoft.demo.exception.ResourceNotFoundException;
import com.fsoft.demo.repository.PostRepository;
import com.fsoft.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    private Object mapper(Object obj){
        if (obj instanceof Post){
            PostDTO rs = new PostDTO();
            rs.setId(((Post) obj).getId());
            rs.setTitle(((Post) obj).getTitle());
            rs.setContent(((Post) obj).getContent());
            List<Comment> comments = ((Post) obj).getComments();
            List<CommentDTO> commentDTOS = new ArrayList<>();
            for(Comment comment : comments){
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setId(comment.getId());
                commentDTO.setContent(comment.getContent());
                commentDTOS.add(commentDTO);
            }
            rs.setCommentDTOS(commentDTOS);
            return rs;
        }
        if (obj instanceof PostDTO){
            Post rs = new Post();
            rs.setId(((PostDTO) obj).getId());
            rs.setTitle(((PostDTO) obj).getTitle());
            rs.setContent(((PostDTO) obj).getContent());
            List<CommentDTO> commentDTOS = ((PostDTO) obj).getCommentDTOS();
            List<Comment> comments = new ArrayList<>();
            for(CommentDTO commentDTO : commentDTOS){
                Comment comment = new Comment();
                comment.setId(commentDTO.getId());
                comment.setContent(commentDTO.getContent());
                comments.add(comment);
            }
            rs.setComments(comments);
            return rs;
        }
        return null;
    }


    @Override
    public List<PostDTO> findAll() {
        List<Post> rs = postRepository.findAll();
        List<PostDTO> rsDTO = new ArrayList<>();
        for (Post post : rs){
            rsDTO.add((PostDTO) mapper(post));
        }
        return rsDTO;
    }

    @Override
    public PostDTO save(PostDTO newPostDTO) {
        Post newPost = postRepository.save((Post) mapper(newPostDTO));
        return (PostDTO) mapper(newPost);
    }

    @Override
    public PostDTO findById(Long id) throws ResourceNotFoundException {
        Post rs = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post not found for this id: " + id));
        return (PostDTO)mapper(rs);
    }

    @Override
    public PostDTO updateTitle(Long id, String title) throws ResourceNotFoundException {
        PostDTO post = findById(id);
        post.setTitle(title);
        return post;
    }

    @Override
    public PostDTO updateContent(Long id, String content) throws ResourceNotFoundException {
        PostDTO post = findById(id);
        post.setContent(content);
        return post;
    }
}
