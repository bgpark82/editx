package com.editx.back.repository;

import com.editx.back.BackApplicationTests;
import com.editx.back.domain.entity.OrderDetail;
import com.editx.back.domain.entity.OrderGroup;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends BackApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create() {
        OrderGroup existOrderGroup = null;

        Optional<OrderGroup> orderGroup = orderGroupRepository.findById(1L);
        Assert.assertTrue(orderGroup.isPresent());
        existOrderGroup = orderGroup.get();

        OrderDetail orderDetail = OrderDetail.builder()
                .status("WATiNG")
                .quantity(1)
                .arrivalDate(LocalDateTime.now().plusDays(2))
                .totalPrice(BigDecimal.valueOf(9000000))
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .orderGroup(existOrderGroup)        // 어떤 장바구니의
//                .itemId(1L)                         // 어떤 상품
                .build();
        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}
