package com.editx.back.repository;

import com.editx.back.BackApplicationTests;
import com.editx.back.domain.entity.Partner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepsitoryTest extends BackApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        Partner partner = Partner.builder()
                .name("Partner01")
                .status("REGISTERED")
                .address("서울시 강남구")
                .partnerNumber("070-1111-2222")
                .callCenter("010-1111-2222")
                .businessNumber("123455")
                .ceoName("홍길동")
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
//                .categoryId(1L)
                .build();
        Partner newPartner = partnerRepository.save(partner);
        Assert.assertNotNull(newPartner);
    }
}
