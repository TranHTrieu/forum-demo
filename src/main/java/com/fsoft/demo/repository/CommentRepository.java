package com.fsoft.demo.repository;

import com.fsoft.demo.entity.Account;
import com.fsoft.demo.entity.Comment;
import com.fsoft.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByPost(Post post);

    List<Comment> findCommentsByAccount(Account account);
}
