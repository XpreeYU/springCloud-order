package com.yu.order.repository;

import com.yu.order.OrderApplicationTests;
import com.yu.order.dataobject.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserRepositoryTest extends OrderApplicationTests {


    @Autowired
    private UserRepository repository;

    @Test
    public void saveAll() throws Exception {
        User user = new User();
        user.setId(3);
        user.setSelfRate(new BigDecimal(0.12));

        repository.save(user);
    }
}