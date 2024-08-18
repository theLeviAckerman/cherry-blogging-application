package com.cherry.blogging.impl;

import com.cherry.blogging.dto.CategoryDto;
import com.cherry.blogging.dto.PostDto;
import com.cherry.blogging.dto.UserDto;
import com.cherry.blogging.entity.Category;
import com.cherry.blogging.entity.Post;
import com.cherry.blogging.entity.User;
import com.cherry.blogging.execption.ResourceNotFoundException;
import com.cherry.blogging.mapper.CategoryMapper;
import com.cherry.blogging.mapper.PostMapper;
import com.cherry.blogging.mapper.UserMapper;
import com.cherry.blogging.respository.CategoryRepository;
import com.cherry.blogging.respository.PostRepository;
import com.cherry.blogging.respository.UserRepository;
import com.cherry.blogging.service.CategoryService;
import com.cherry.blogging.service.PostService;
import com.cherry.blogging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private UserRepository userRepo;


    @Override
    public PostDto createPost(PostDto postDto, Integer categoryId, Integer userId) {

        UserDto userById = this.userService.getUserById(userId);
        CategoryDto categoryById = this.categoryService.getCategoryById(categoryId);

        Post post = PostMapper.INSTANCE.postDtoToPost(postDto);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(UserMapper.INSTANCE.userDtoToUser(userById));
        post.setCategory(CategoryMapper.INSTANCE.dtoToCategory(categoryById));
        Post savedPost = this.postRepo.save(post);
        return PostMapper.INSTANCE.postToPostDto(savedPost);

    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post postById = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        postById.setTitle(postDto.getTitle());
        postById.setContent(postDto.getContent());
        postById.setImageName(postDto.getImageName());

        Post savedPost = this.postRepo.save(postById);
        return PostMapper.INSTANCE.postToPostDto(savedPost);
    }

    @Override
    public void deletePost(Integer postId) {
        Post postById = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        this.postRepo.delete(postById);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList = this.postRepo.findAll();
        return postList.stream().map(PostMapper.INSTANCE::postToPostDto).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post postById = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        return PostMapper.INSTANCE.postToPostDto(postById);
    }

    @Override
    public List<PostDto> getAllPostByCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        List<Post> postList = this.postRepo.findByCategory(category);
        return postList.stream().map(PostMapper.INSTANCE::postToPostDto).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getAllPostByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
        List<Post> postList = this.postRepo.findByUser(user);
        return postList.stream().map(PostMapper.INSTANCE::postToPostDto).collect(Collectors.toList());
    }

}
