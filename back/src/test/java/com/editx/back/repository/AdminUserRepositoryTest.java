package com.editx.back.repository;

import com.editx.back.BackApplicationTests;
import com.editx.back.domain.entity.AdminUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

    public class AdminUserRepositoryTest extends BackApplicationTests {

        @Autowired
        private AdminUserRepository adminUserRepository;

        @Test
        public void create() {
            AdminUser adminUser = AdminUser.builder()
                    .account("test")
                    .password("test")
                    .status("REGISTERED")
                    .role("PARTNER")
                    .build();
            AdminUser newAdminUser = adminUserRepository.save(adminUser);
            Assert.assertNotNull(newAdminUser);
        }

    }
