package com.example.demo;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LoginApplicationTests {

    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void contextLoads() {
//        int key=userMapper.delete(4);
//        if (key==1)
//            System.out.println("删除成功");
//
//    }

//    /**
//     * 插入测试
//     */
//    @Test
//    public void insert() {
//
//        User user=new User();
//
//        user.setUsername("7");
//        user.setPassword("7");
//        user.setAge(7);
//
//        int key=userMapper.insert(user);
//        if (key==1)
//            System.out.println("插入成功");
//
//    }

    /**
     * 搜索测试
     */
    @Test
    public void queryuser() {

        User key=userMapper.queryuser("3","3");
        if (key!=null)
            System.out.println("搜索成功");

    }

}
