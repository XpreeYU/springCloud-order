package com.yu.order.redis;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.yu.order.OrderApplicationTests;
import com.yu.order.config.RedisUtil;
import com.yu.order.config.entity.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName RedisTest
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/6/8 13:35
 **/
@Component
public class RedisTest extends OrderApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testRedis() throws Exception{

        List<Person> list = new ArrayList<>();

        Person person = new Person();
        person.setYear(1);
        person.setSelfRate(new BigDecimal("12.589"));
        Person person2 = new Person();
        person2.setYear(2);

        list.add(person);
        list.add(person2);

        Boolean result = redisUtil.set("person", list);
        System.out.println("result: " + result);

    }

    @Test
    public void setObjListRedis() throws Exception{
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setYear(3);
        person.setSelfRate(new BigDecimal(25.16));
        Person person2 = new Person();
        person2.setYear(4);
        person2.setSpouseRate(new BigDecimal(20.36));
        list.add(person);
        list.add(person2);

        Gson gson = new Gson();
        String str = gson.toJson(list);

        redisUtil.set("user", str);

    }


    @Test
    public void getRedis() throws Exception{
        Object person = redisUtil.get("person");
        System.out.println("person: " + person.toString());


        String jsonList = redisUtil.get("user").toString();
        Gson gson = new Gson();
        List<Person> list= gson.fromJson(jsonList, new TypeToken<List<Person>>(){}.getType());
        for (Person personTemp : list) {
            System.out.println(personTemp.getYear());
        }
    }

}
