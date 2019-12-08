package com.editx.back.repository;

import com.editx.back.BackApplicationTests;
import com.editx.back.domain.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends BackApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        Category category = Category.builder()
                .type("computer")
                .title("컴퓨터")
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .build();
        Category newCategory = categoryRepository.save(category);
        Assert.assertNotNull(newCategory);
    }

    @Test
    public void read() {
        String type  = "computer";
        Optional<Category> category = categoryRepository.findById(2L);
        category.ifPresent(c -> Assert.assertEquals(type, c.getType()));
    }
}
