package com.editx.back.repository;

import com.editx.back.BackApplicationTests;
import com.editx.back.domain.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class ItemRepositoryTest extends BackApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = Item.builder()
                .status("UNREGISTERED")
                .name("노트북")
                .title("삼성 노트북 A100")
                .content("2019년 형 노트북")
                .price(90000)
                .brandName("삼성")
                .createdAt(LocalDateTime.now())
                .createdBy("peter")
//                .partnerId(1L)
                .build();
        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);

    }
}
