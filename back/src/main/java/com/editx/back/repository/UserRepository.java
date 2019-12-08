package com.editx.back.repository;

import com.editx.back.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByPhoneOrderByIdDesc(String phone);
}
