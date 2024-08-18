package com.cherry.blogging.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private int id;

    @NotEmpty
    @Size(min = 3,max = 64,message = "Category Title Should be between 3 to 64 Characters")
    private String title;
    @NotEmpty
    @Size(min = 3,max = 1024,message = "Category Description Should be between 10 to 1024 Characters")
    private String description;
}
