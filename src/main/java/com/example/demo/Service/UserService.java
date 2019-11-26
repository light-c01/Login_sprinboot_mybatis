package com.example.demo.Service;


import com.example.demo.Mapper.UserMapper;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param id
     * @return
     */
    public  int delete(Integer id){
        int key=userMapper.delete(id);
        return id;
    }

    /**
     *
     * @param user
     * @return
     */
    public  int insert(User user){
        int key=userMapper.insert(user);
        return key;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public  User queryuser(String username,String password){
        User key=userMapper.queryuser(username,password);
        return key;
    }

}
