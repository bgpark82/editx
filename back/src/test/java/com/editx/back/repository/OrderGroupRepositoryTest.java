package com.editx.back.repository;

import com.editx.back.BackApplicationTests;
import com.editx.back.domain.entity.OrderGroup;
import com.editx.back.domain.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderGroupRepositoryTest extends BackApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        Optional<User> user = userRepository.findById(10L);
        user.ifPresent(existUser -> {
            OrderGroup orderGroup = OrderGroup.builder()
                    .status("COMPLETE")
                    .orderType("ALL")
                    .revAddress("서울시 강남구")
                    .revName("홍길동")
                    .paymentType("CARD")
                    .totalPrice(BigDecimal.valueOf(900000))
                    .totalQuantity(1)
                    .orderAt(LocalDateTime.now().plusDays(2))
                    .arriveDate(LocalDateTime.now())
                    .createdAt(LocalDateTime.now())
                    .createdBy("AdminServer")
                    .user(existUser)
                    .build();
            OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
            Assert.assertNotNull(newOrderGroup);
        });

    }
}
