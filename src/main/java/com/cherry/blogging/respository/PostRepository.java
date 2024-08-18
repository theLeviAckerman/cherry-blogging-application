package com.cherry.blogging.respository;

import com.cherry.blogging.entity.Category;
import com.cherry.blogging.entity.Post;
import com.cherry.blogging.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}
