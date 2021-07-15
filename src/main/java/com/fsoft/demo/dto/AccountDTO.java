package com.fsoft.demo.dto;

import java.util.List;

public class AccountDTO {
    private Long id;
    private String name;
    private String password;
    private List<PostDTO> postDTOS;
    private List<CommentDTO> commentDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PostDTO> getPostDTOS() {
        return postDTOS;
    }

    public void setPostDTOS(List<PostDTO> postDTOS) {
        this.postDTOS = postDTOS;
    }

    public List<CommentDTO> getCommentDTOS() {
        return commentDTOS;
    }

    public void setCommentDTOS(List<CommentDTO> commentDTOS) {
        this.commentDTOS = commentDTOS;
    }
}
