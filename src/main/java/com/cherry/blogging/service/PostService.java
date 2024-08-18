package com.cherry.blogging.service;

import com.cherry.blogging.dto.PostDto;
import com.cherry.blogging.entity.Post;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void  deletePost(Integer postId);

    List<PostDto> getAllPosts();

    PostDto getPostById(Integer postId);

    List<PostDto> getAllPostByCategory(Integer categoryId);

    List<PostDto> getAllPostByUser(Integer userID);

}
