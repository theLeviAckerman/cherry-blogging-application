package com.cherry.blogging.dto;

import com.cherry.blogging.entity.Category;
import com.cherry.blogging.entity.User;
import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@Getter
@Setter
public class PostDto {

    private Integer id;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private UserDto userDto;
    private CategoryDto categoryDto;

}
