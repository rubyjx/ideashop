package com.ruby.ideashop.user.controller;

import com.ruby.ideashop.user.pojo.User;
import com.ruby.ideashop.user.service.UserService;
import com.ruby.ideashop.user.vo.UserSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * @author xinjin
 * 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 新增/更新用户
     */
    @RequestMapping(value = "/v1",method = RequestMethod.POST)
    public  String  addUser(UserSaveVo userSaveVo){
        User user=new User();
       // request.setAttribute("aaa","bbb");
        return userService.addUser(user);
    }
    /**
     * 删除用户
     */
    @RequestMapping(value = "/v1",method = RequestMethod.DELETE)
    public String deleteUser(){
        return null;
    }
    /**
     * 查询用户详情
     */
    @RequestMapping(value = "/v1/{id}",method = RequestMethod.GET)
    public String selectById(){
        return null;
    }
    /**
     * 查询用户列表
     */
    @RequestMapping(value = "/v1",method = RequestMethod.GET)
    public String selectByList(){
        return null;
    }

}
