package com.yu.order.repository;

import com.yu.order.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
