package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.PostDTO;
import com.fsoft.demo.entity.Account;
import com.fsoft.demo.entity.Post;
import com.fsoft.demo.exception.ResourceNotFoundException;
import com.fsoft.demo.repository.AccountRepository;
import com.fsoft.demo.repository.PostRepository;
import com.fsoft.demo.service.PostService;
import com.fsoft.demo.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private AccountRepository accountRepository;
    private MapUtils mapUtils;

    @Autowired
    public PostServiceImpl(MapUtils mapUtils,
                           PostRepository postRepository,
                           AccountRepository accountRepository){
        this.mapUtils = mapUtils;
        this.postRepository = postRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<PostDTO> findAll() {
        List<Post> rs = postRepository.findAll();
        List<PostDTO> rsDTO = new ArrayList<>();
        for (Post post : rs){
            rsDTO.add((PostDTO) mapUtils.mapper(post));
        }
        return rsDTO;
    }

    @Override
    public List<PostDTO> findPostsByAccount(Long accountId) throws ResourceNotFoundException {
        Account account = accountRepository.findById(accountId).orElseThrow(() ->
                new ResourceNotFoundException("Account not found for this id: " + accountId));
        List<Post> posts = postRepository.findPostsByAccount(account);
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : posts){
            PostDTO postDTO = (PostDTO) mapUtils.mapper(post);
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

    @Override
    public PostDTO save(PostDTO newPostDTO) {
        Post newPost = postRepository.save((Post) mapUtils.mapper(newPostDTO));
        return (PostDTO) mapUtils.mapper(newPost);
    }

    @Override
    public PostDTO findById(Long id) throws ResourceNotFoundException {
        Post rs = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post not found for this id: " + id));
        return (PostDTO) mapUtils.mapper(rs);
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
