package com.example.demo.Mapper;


import com.example.demo.Model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface UserMapper {

    @Select({"select * from user_table"})
    int query();

    /**
     * 搜索用户用User，不能用int
     * @param username
     * @param password
     * @return
     */
    @Select({"select * from user_table WHERE username=#{username} AND password=#{password}"})
    User queryuser(@Param("username") String username,@Param("password") String password);

    @Delete({"DELETE FROM user_table WHERE id=#{id,jdbcType=INTEGER}"})
    int delete(Integer id);

    @Insert({"INSERT INTO user_table(username,password,age) VALUES(#{username},#{password},#{age})"})
    int insert(User user);


}
