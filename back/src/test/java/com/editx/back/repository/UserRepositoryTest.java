package com.editx.back.repository;

import com.editx.back.BackApplicationTests;
import com.editx.back.domain.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends BackApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = User.builder()
                .account("1234")
                .createdAt(LocalDateTime.now())
                .createdBy("peter")
                .status("enable")
                .password("1234")
                .phone("010-4580-8682")
                .build();
        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {
        Optional<User> user = userRepository.findById(10L);
        user.ifPresent(existUser ->{
            // 사용자가 어떤 장바구니를 가지고 있는가
            existUser.getOrderGroupList().forEach(orderGroup -> {
                System.out.println("----------주문묶음---------");
                System.out.println("수령인  : " + orderGroup.getRevName());
                System.out.println("수령지  : " + orderGroup.getRevAddress());
                System.out.println("총금액  : " + orderGroup.getTotalPrice());
                System.out.println("총수량  : " + orderGroup.getTotalQuantity());
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("----------주문상세내역---------");
                    System.out.println("주문의 상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정 일자 : " + orderDetail.getArrivalDate());
                    System.out.println("주문상품 : " + orderDetail.getItem().getName());
                    System.out.println("----------파트너사---------");
                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                });
            });
            Assert.assertNotNull(user);
        });
    }

    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(10L);
        user.ifPresent(existUser -> {
            userRepository.delete(existUser);
        });
        Optional<User> deletedUser = userRepository.findById(10L);
        Assert.assertFalse(deletedUser.isPresent());
    }
}
