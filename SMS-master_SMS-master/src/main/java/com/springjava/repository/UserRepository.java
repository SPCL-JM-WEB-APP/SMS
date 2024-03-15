package com.springjava.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springjava.entity.User;
import com.springjava.entity.UserDetails;
public interface UserRepository extends JpaRepository<User, Integer> {
User findByEmail(String email);

void save(UserDetails user);
}