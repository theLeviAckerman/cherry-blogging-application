package com.cherry.blogging.controller;

import com.cherry.blogging.dto.PostDto;
import com.cherry.blogging.entity.Post;
import com.cherry.blogging.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(
             @RequestBody PostDto postDto,
             @RequestParam(required = true) Integer categoryId,
             @RequestParam(required = true) Integer userId){
        PostDto postSaved = this.postService.createPost(postDto, categoryId, userId);
        return new ResponseEntity<>(postSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetch/user/{userId}")
    public  ResponseEntity<List<PostDto>> fetchPostByUserId(@PathVariable Integer userId){
        List<PostDto> allPostByUser = this.postService.getAllPostByUser(userId);
        return  new ResponseEntity<>(allPostByUser,HttpStatus.OK);
    }




}
