package org.example.dictaionhomework2.User.repository;


import org.example.dictaionhomework2.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
