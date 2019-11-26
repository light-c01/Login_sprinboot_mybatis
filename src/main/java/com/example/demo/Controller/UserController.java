package com.example.demo.Controller;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/Login")
    public  String  userLogin(){
        return "userLogin";
    }

    //@ResponseBody
    @RequestMapping("/registerpage")
    public  String  register(){
        return "register";
    }


    @RequestMapping("/userLogin")
    public  String userLogin(@RequestParam ("username") String username, @RequestParam("password") String password, HttpServletRequest request){

        User user=userService.queryuser(username,password);
        if(user != null){                                                  //登录成功
            request.getSession().setAttribute("session_user",user);
            System.out.println("登录成功");//将用户信息放入session
            return "index";
        }
        return "loginError";

    }

    /**
     *
     * @param username
     * @param password
     * @param password2
     * @param age
     * @return
     */
    @ResponseBody
    @RequestMapping("/uregister")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,
                          @RequestParam("age") int age){

        if(StringUtils.isEmpty(username)){
            return "用户名不能为空";
        }

        if(StringUtils.isEmpty(password)){
            return "密码不能为空";
        }

        if(StringUtils.isEmpty(password2)){
            return "确认密码不能为空";
        }

        if(!password.equals(password2)){
            return "两次密码不相同，注册失败！！";
        }else {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setAge(age);
            int res = userService.insert(user);
            if(res == 0){
                return "注册失败！";
            }else {
                return "注册成功！";
            }
        }

    }

}
