package com.cherry.blogging.impl;

import com.cherry.blogging.dto.CategoryDto;
import com.cherry.blogging.dto.PostDto;
import com.cherry.blogging.dto.UserDto;
import com.cherry.blogging.entity.Category;
import com.cherry.blogging.entity.Post;
import com.cherry.blogging.entity.User;
import com.cherry.blogging.mapper.CategoryMapper;
import com.cherry.blogging.mapper.PostMapper;
import com.cherry.blogging.mapper.UserMapper;
import com.cherry.blogging.respository.PostRepository;
import com.cherry.blogging.service.CategoryService;
import com.cherry.blogging.service.PostService;
import com.cherry.blogging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostRepository postRepo;


    @Override
    public PostDto createPost(PostDto postDto, Integer categoryId, Integer userId) {

        UserDto userById = this.userService.getUserById(userId);
        CategoryDto categoryById = this.categoryService.getCategoryById(categoryId);

        Post post= PostMapper.INSTANCE.postDtoToPost(postDto);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(UserMapper.INSTANCE.userDtoToUser(userById));
        post.setCategory(CategoryMapper.INSTANCE.dtoToCategory(categoryById));

        Post savedPost = this.postRepo.save(post);
        return PostMapper.INSTANCE.postToPostDto(savedPost);

    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPostByCategory(Integer categoryId) {

        CategoryDto categoryById = this.categoryService.getCategoryById(categoryId);
        Category category = CategoryMapper.INSTANCE.dtoToCategory(categoryById);
        List<Post> postList = this.postRepo.findByCategory(category);
        return postList.stream().map(PostMapper.INSTANCE::postToPostDto).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getAllPostByUser(Integer userId) {
        UserDto userById = this.userService.getUserById(userId);
        User user = UserMapper.INSTANCE.userDtoToUser(userById);
        List<Post> postList = this.postRepo.findByUser(user);

        return postList.stream().map(PostMapper.INSTANCE::postToPostDto).collect(Collectors.toList());
    }

}
