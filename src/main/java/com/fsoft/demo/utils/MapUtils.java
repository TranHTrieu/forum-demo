package com.fsoft.demo.utils;

import antlr.StringUtils;
import com.fsoft.demo.dto.CommentDTO;
import com.fsoft.demo.dto.PostDTO;
import com.fsoft.demo.entity.Comment;
import com.fsoft.demo.entity.Post;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapUtils {

    public Object mapper(Object obj) {
        if (obj instanceof Comment){
            CommentDTO rs = new CommentDTO();
            rs.setId(((Comment) obj).getId());
            rs.setContent(((Comment) obj).getContent());
            Post post = ((Comment) obj).getPost();
            PostDTO postDTO = new PostDTO();
            postDTO.setId(post.getId());
            postDTO.setTitle(post.getTitle());
            postDTO.setContent(post.getContent());
            rs.setPostDTO(postDTO);
            return rs;
        }
        if (obj instanceof CommentDTO){
            Comment rs = new Comment();
            rs.setId(((CommentDTO) obj).getId());
            rs.setContent(((CommentDTO) obj).getContent());
            PostDTO postDTO = ((CommentDTO) obj).getPostDTO();
            Post post = new Post();
            post.setId(postDTO.getId());
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
            rs.setPost(post);
            return rs;
        }
        if (obj instanceof Post){
            PostDTO rs = new PostDTO();
            rs.setId(((Post) obj).getId());
            rs.setTitle(((Post) obj).getTitle());
            rs.setContent(((Post) obj).getContent());
            if(!ObjectUtils.isEmpty(((Post) obj).getComments())){
                List<Comment> comments = ((Post) obj).getComments();
                List<CommentDTO> commentDTOS = new ArrayList<>();
                for(Comment comment : comments){
                    CommentDTO commentDTO = new CommentDTO();
                    commentDTO.setId(comment.getId());
                    commentDTO.setContent(comment.getContent());
                    commentDTOS.add(commentDTO);
                }
                rs.setCommentDTOS(commentDTOS);
            }
            return rs;
        }
        if (obj instanceof PostDTO){
            Post rs = new Post();
            rs.setId(((PostDTO) obj).getId());
            rs.setTitle(((PostDTO) obj).getTitle());
            rs.setContent(((PostDTO) obj).getContent());
            if(!ObjectUtils.isEmpty(((PostDTO) obj).getCommentDTOS())){
                List<CommentDTO> commentDTOS = ((PostDTO) obj).getCommentDTOS();
                List<Comment> comments = new ArrayList<>();
                for(CommentDTO commentDTO : commentDTOS){
                    Comment comment = new Comment();
                    comment.setId(commentDTO.getId());
                    comment.setContent(commentDTO.getContent());
                    comments.add(comment);
                }
                rs.setComments(comments);
            }
            return rs;
        }
        return null;
    }
}
