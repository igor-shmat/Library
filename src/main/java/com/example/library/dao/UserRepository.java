package com.example.library.dao;

import com.example.library.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByFio(String fio);

}
